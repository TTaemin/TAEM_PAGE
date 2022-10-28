package com.homepage.taempage.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.homepage.taempage.common.Criteria;
import com.homepage.taempage.common.PageMaker;
import com.homepage.taempage.domain.BoardVo;
import com.homepage.taempage.domain.CategoryVo;
import com.homepage.taempage.domain.MemberVo;
import com.homepage.taempage.domain.ReplyVo;
import com.homepage.taempage.service.BoardService;

import net.sf.json.JSONArray;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Autowired
	private BoardService bdService;
	

	//보드 리스트
	@GetMapping("/list")
	public String boardList(BoardVo board, CategoryVo cate, Criteria cri, HttpSession session, Model model,
			@RequestParam(value="page", required=false)String page,
			@RequestParam(value="perPageNum", required=false)String perPageNum,
			@RequestParam("cate") int cateNo){
		
		//멤버구분
		MemberVo member = (MemberVo)session.getAttribute("member");
		model.addAttribute("member", member);
		
		//리스트불러오기
		List<BoardVo> list = bdService.boardList(cri, cateNo);		
		model.addAttribute("bdList", list);
		
		//board의 cateNo를 현재 cateNo로 설정
		board.setCateNo(cateNo);
		model.addAttribute("board", board);
		
		//페이지메이커(카테고리 별 글 수 세기)
		PageMaker pageMaker = new PageMaker();
		int totalCount = bdService.countPage(cri, cateNo);
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		pageMaker.setCateNo(board.getCateNo());
		
		model.addAttribute("cri", cri);
		model.addAttribute("pageMaker", pageMaker);
		
		
		return "board/list";
	}
	
	//보드 상세보기
	@GetMapping("/view")
	public String boardView(BoardVo board, HttpSession session, Model model, @RequestParam("no") int boardNo, @ModelAttribute("cri") Criteria cri) {
		
		//멤버 구분
		MemberVo member = (MemberVo)session.getAttribute("member");
		model.addAttribute("member", member);
		
		//board를 boardNo별 뷰로 설정
		model.addAttribute("board", bdService.boardView(boardNo));
		
		//크리테리아 설정해서 목록 이동 시 이전페이지로 가게하기
		model.addAttribute("cri", cri);
		
		return "board/view";
	}
	
	/*reply(reply는 상세보기 페이지에서 이루어지므로 ajax 사용)*/
	//replyList
	@ResponseBody
	@GetMapping("/replyList")
	public List<ReplyVo> replyList(@RequestParam("no") int boardNo){
		
		List<ReplyVo> reply = bdService.replyList(boardNo);
		
		return reply;
	}
	
	//replyWrite
	@ResponseBody
	@PostMapping("/replyWrite")
	public void replyWrite(ReplyVo reply, HttpSession session) {
		
		MemberVo member = (MemberVo)session.getAttribute("member");
		reply.setMemNo(member.getMemNo());
		
		bdService.reply(reply);
	}
	
	//replyUpdate
	@ResponseBody
	@PostMapping("/replyUpdate")
	public int replyUpdate(ReplyVo reply, HttpSession session) {
		
		int result = 0;
		
		MemberVo member = (MemberVo)session.getAttribute("member");
		int replyMember = bdService.memChk(reply.getReplyNo());
		
		if(member.getMemNo() == replyMember) {
			reply.setMemNo(member.getMemNo());
			bdService.replyUpdate(reply);
			result = 1;
		}
		return result;
	}
	
	//replyDelete
	@ResponseBody
	@PostMapping("/replyDelete")
	public int replyDelete(ReplyVo reply, HttpSession session) {
		
		int result = 0;
		
		MemberVo member = (MemberVo)session.getAttribute("member");
		int replyMember = bdService.memChk(reply.getReplyNo());
		
		if(member.getMemNo() == replyMember) {
			reply.setMemNo(member.getMemNo());
			bdService.replyDelete(reply);
			result = 1;
		}
		return result;
	}
	
	//보드 입력하기 form	
	@GetMapping("/write")
	public String boardWrite(Model model) throws Exception {

		List<CategoryVo> category = bdService.category();
		model.addAttribute("category", category);
		
		return "board/write";
		
	}
	//보드 입력하기
	@PostMapping("/write")
	public String boardWrite(BoardVo board, Model model) throws Exception {

		bdService.write(board);
		model.addAttribute("board", board);
		
		return "redirect:/board/complete";
	}
	//보드 입력 완료 시
	@GetMapping("/complete")
	public void writeComplete() {
		
	}
	
	//ckeditor로 글 입력
	@RequestMapping(value = "/ckUpload", method = RequestMethod.POST)
	@ResponseBody
	public String ckImageUpload(HttpServletRequest req, HttpServletResponse res, MultipartHttpServletRequest mpReq) throws Exception{
		
		JsonObject json = new JsonObject();
		
		String orgFile = null;
		String fileName = null;
		
		PrintWriter printWriter = null;
		OutputStream out = null;
		
		MultipartFile file = mpReq.getFile("upload");
		
		if(file != null) {
			try {
				
				orgFile = file.getOriginalFilename();
				byte[] bytes = file.getBytes();
				File uploadFile = new File(uploadPath);
				
				if(!uploadFile.exists()) {
					uploadFile.mkdirs();
				}
				
				UUID uuid = UUID.randomUUID();
				String ext = FilenameUtils.getExtension(orgFile);
				fileName = uuid + "." + ext;
				
				String ckPath = uploadPath + fileName;
				
				out = new FileOutputStream(new File(ckPath));
				out.write(bytes);
				
				printWriter = res.getWriter();
				res.setContentType("text/html");
				String fileUrl = req.getContextPath() + "/upload/" + fileName;
				
				json.addProperty("uploaded", 1);
				json.addProperty("fileName", fileName);
				json.addProperty("url", fileUrl);
				
				printWriter.println(json);
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(out != null) { out.close(); }
				if(printWriter != null) { printWriter.close(); }
			}
		}

		return null;
		
	}
	
	//보드 수정하기 form
	@GetMapping("/update")
	public String boardUpdate(@RequestParam("no") int boardNo, Model model, @ModelAttribute("cri") Criteria cri) {
		
		BoardVo board = bdService.boardView(boardNo);
		model.addAttribute("board", board);
		
		model.addAttribute("cri", cri);
		
		return "board/update";
	}
	//보드 수정하기
	@PostMapping("/update")
	public String boardUpdate(BoardVo board, Model model, @RequestParam("no") int boardNo, @ModelAttribute("cri") Criteria cri) {
		
		bdService.update(board);
		model.addAttribute("board", board);
		
		model.addAttribute("cri", cri);
		
		return "redirect:/board/list";
		
	}
	
	//ckeditor로 보드 수정하기
	@RequestMapping(value = "/ckUploadUpd", method = RequestMethod.POST)
	@ResponseBody
	public String ckImageUploadUpdate(HttpServletRequest req, HttpServletResponse res, MultipartHttpServletRequest mpReq) throws Exception{
		
		JsonObject json = new JsonObject();
		
		String orgFile = null;
		String fileName = null;
		
		PrintWriter printWriter = null;
		OutputStream out = null;
		
		MultipartFile file = mpReq.getFile("upload");
		
		if(file != null) {
			try {
				
				orgFile = file.getOriginalFilename();
				byte[] bytes = file.getBytes();
				File uploadFile = new File(uploadPath);
				
				if(!uploadFile.exists()) {
					uploadFile.mkdirs();
				}
				
				UUID uuid = UUID.randomUUID();
				String ext = FilenameUtils.getExtension(orgFile);
				fileName = uuid + "." + ext;
				
				String ckPath = uploadPath + fileName;
				
				out = new FileOutputStream(new File(ckPath));
				out.write(bytes);
				
				printWriter = res.getWriter();
				res.setContentType("text/html");
				String fileUrl = req.getContextPath() + "/upload/" + fileName;
				
				json.addProperty("uploaded", 1);
				json.addProperty("fileName", fileName);
				json.addProperty("url", fileUrl);
				
				printWriter.println(json);
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}finally {
				if(out != null) { out.close(); }
				if(printWriter != null) { printWriter.close(); }
			}
		}

		return null;
		
	}
	
	//보드 삭제하기
	@GetMapping("/delete")
	public String boardDelete(BoardVo board, @RequestParam("no") int boardNo) {
		bdService.delete(boardNo);  //boardNo로 글 삭제
		return "redirect:/board/list";
	}
	

}
