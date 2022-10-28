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

import com.google.gson.JsonObject;
import com.homepage.taempage.common.Criteria;
import com.homepage.taempage.common.LCriteria;
import com.homepage.taempage.common.LPageMaker;
import com.homepage.taempage.common.PageMaker;
import com.homepage.taempage.domain.LetterVo;
import com.homepage.taempage.domain.MemberVo;
import com.homepage.taempage.domain.ReplyVo;
import com.homepage.taempage.service.LetterService;

@Controller
@RequestMapping("/letter")
public class LetterController {
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Autowired
	private LetterService letService;
	
	//letter 리스트
	@GetMapping("/list")
	public String letterList(LCriteria lCri, HttpSession session, Model model,
			@RequestParam(value="page", required = false)String page,
			@RequestParam(value = "perPageNum", required = false)String perPageNum) {
		
		MemberVo member = (MemberVo)session.getAttribute("member");
		model.addAttribute("member", member);
		
		List<LetterVo> letter = letService.letterList(lCri);
		model.addAttribute("letter", letter);
		
		LPageMaker lPageMaker = new LPageMaker();
		int totalCount = letService.countPage(lCri);
		
		lPageMaker.setlCri(lCri);
		lPageMaker.setTotalCount(totalCount);
		
		model.addAttribute("lCri", lCri);
		model.addAttribute("lPageMaker", lPageMaker);
		
		return "letter/list";
	}
	
	//letter 상세보기
	@GetMapping("/view")
	public String letterView(LetterVo letter, @RequestParam("no") int letterNo, HttpSession session, Model model, @ModelAttribute("lCri") LCriteria lCri) {
		
		MemberVo member = (MemberVo)session.getAttribute("member");
		model.addAttribute("member", member);
		
		model.addAttribute("letter", letService.letterView(letterNo));
		
		model.addAttribute("lCri", lCri);
		
		return "letter/view";
	}
	
	/*reply(ajax)*/
	//replyWrite
	@ResponseBody
	@PostMapping("/replyWrite")
	public void letterReplyWrite(LetterVo letter, HttpSession session, Model model) {
		
		MemberVo member = (MemberVo)session.getAttribute("member");
		model.addAttribute("member", member);
		
		letService.lReplyWrite(letter);
	}
	
	//replyView
	@ResponseBody
	@GetMapping("/replyView")
	public void letterReplyView(@RequestParam("no") int letterNo, Model model) {
		LetterVo letter = letService.lReplyView(letterNo);
		model.addAttribute("letter", letter);
	}
	
	//replyUpdate
	@ResponseBody
	@PostMapping("/replyUpdate")
	public int replyUpdate(LetterVo letter, HttpSession session) {
		
		int result = 0;
		
		MemberVo member = (MemberVo)session.getAttribute("member");
		
		if(member.getVerify() == 7) {
			letService.lReplyUpdate(letter);
			result = 1;
		}
		return result;
	}
	
	//replyDelete
	@ResponseBody
	@PostMapping("/replyDelete")
	public int replyDelete(LetterVo letter, HttpSession session) {
		
		int result = 0;
		
		MemberVo member = (MemberVo)session.getAttribute("member");
		
		if(member.getVerify() == 7) {
			letService.lReplyDelete(letter);
			result = 1;
		}
		return result;
	}
	
	//letter 입력 form
	@GetMapping("/write")
	public String letterWrite(Model model, HttpSession session) {
		
		MemberVo member = (MemberVo)session.getAttribute("member");
		model.addAttribute("member", member);
		
		if(member == null) {
			return "redirect:/member/login";
		}
		
		return "letter/write";
		
	}
	//letter 입력
	@PostMapping("/write")
	public String letterWrite(LetterVo letter, Model model, HttpSession session) {
		
		MemberVo member = (MemberVo)session.getAttribute("member");
		model.addAttribute("member", member);
		
		letter.setMemNo(member.getMemNo());
		
		letService.letterWrite(letter);
		model.addAttribute("letter", letter);
		
		return "redirect:/letter/list";
	}
	//letter 입력 ckUpload로
	@RequestMapping(value="/ckUpload", method = RequestMethod.POST)
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
	
	//letter 수정시 비밀번호 입력 form
	@GetMapping("/password")
	public String letterPwChk (@RequestParam("no") int letterNo, Model model) {
		
		LetterVo letter = letService.pwChk(letterNo);
		
		model.addAttribute("letter", letter);
		
		return "letter/password";
	}
	//letter 수정 form
	@GetMapping("/update")
	public String letterUpdate(@RequestParam("no") int letterNo, Model model) {
		
		LetterVo letter = letService.letterView(letterNo);
		model.addAttribute("letter", letter);
		
		return "letter/update";
	}
	//letter 수정
	@PostMapping("/update")
	public String letterUpdate(@RequestParam("no") int letterNo, LetterVo letter, Model model) {
		
		letService.letterUpdate(letter);
		
		model.addAttribute("letter", letter);
		
		return "redirect:/letter/list";
		
	}
	
	//letter 입력 ckUpload로
		@RequestMapping(value="/ckUploadUpd", method = RequestMethod.POST)
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
		
	
	//letter 삭제 시 비밀번호 입력 form
	@GetMapping("/delete")
	public String letterDelete(@RequestParam("no") int letterNo, Model model) {
		
		LetterVo letter = letService.pwChk(letterNo);
		
		model.addAttribute("letter", letter);
		
		return "letter/delete";
	}
	//letter 삭제 시 비밀번호 체크 후 삭제
	@PostMapping("/delete")
	public String letterDelete(@RequestParam("no") int letterNo, LetterVo letter, Model model) {
		
		letService.letterDelete(letterNo);
		model.addAttribute("letter", letter);
		
		return "redirect:/letter/list";
	}
	
	
	
}
