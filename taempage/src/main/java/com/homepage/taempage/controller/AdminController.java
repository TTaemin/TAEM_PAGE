package com.homepage.taempage.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.homepage.taempage.domain.BoardVo;
import com.homepage.taempage.domain.CategoryVo;
import com.homepage.taempage.domain.MemberVo;
import com.homepage.taempage.service.BoardService;
import com.homepage.taempage.service.MemberService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private BoardService bdService;
	
	@Autowired
	private MemberService memService;
	
	
	/*메인페이지*/
	@GetMapping("/main_page")
	public void main_page() {
		
	}
	
//	@GetMapping("/main_page")
//	public String main_page(@RequestParam("cate") int cateNo) {
//		return "/admin/main_page";
//	}
	
	
	/*멤버관리*/
	//멤버리스트
	@GetMapping("/user/list")
	public String memberList(Model model) {
		
		List<MemberVo> member = memService.userList();
		model.addAttribute("user", member);
		
		return "admin/user/list";
		
	}
	
	//멤버수정 form
	@GetMapping("/user/update")
	public String memberUpdate(@RequestParam("no") int memNo) {
	
		return "admin/user/update";
	}
	//멤버수정
	@PostMapping("/user/update")
	public String memberUpdate(MemberVo mem, Model model, @RequestParam("no") int memNo) {
		
		memService.userUpdate(mem);
		model.addAttribute("user", mem);
		
		return "redirect:/admin/user/list";
	}
	
	//멤버삭제
	@ResponseBody
	@PostMapping("/user/delete")
	public int memberDelete(HttpSession session, @RequestParam(value="chkbox[]") List<String> chkArr, MemberVo mem, @RequestParam("no") int memNo) {
		
		MemberVo member = (MemberVo)session.getAttribute("member");
		
		int result = 0;
		
		member.setMemNo(mem.getMemNo());
		
		if(member.getVerify() ==  7) {
			for(String i : chkArr) {
				memNo = Integer.parseInt(i);
				mem.setMemNo(memNo);
				
				memService.userDelete(memNo);
			}
			result = 1;
		}
		
		return result;
		
	}
	
	
	/*보드관리*/
	//글 리스트(카테고리별 - 카테고리 클릭해서 글리스트로 들어가게)
	@GetMapping("/board/list")
	public void boardList() {
		
	}
	@PostMapping("/board/list")
	public String boardListCate(CategoryVo cate, Model model, @RequestParam("cate") int cateNo) {
		
		List<BoardVo> board = bdService.adminBoardList(cateNo);
		model.addAttribute("board", board);
		
		return "/admin/board/list";
		
	}
	

}
