package com.homepage.taempage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.homepage.taempage.domain.MemberVo;
import com.homepage.taempage.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	BCryptPasswordEncoder pwEncoder;
	
	@Autowired
	private MemberService memService;
	
	//mypage
	@GetMapping("/info")
	public String info(HttpSession session, Model model) {
		
		MemberVo member = (MemberVo)session.getAttribute("member");
		model.addAttribute("member", member);
		
		if(member == null) {
			return "redirect:/member/login";
		}
		
		memService.memInfo(member.getMemNo());
		return "member/info";
	}
	
	//회원가입 시 아이디체크
	@ResponseBody
	@PostMapping("/idChk")
	public int idChk(MemberVo mem) {
		int pwChk = memService.idChk(mem);
		return pwChk;
	}
	//회원가입 시 이메일체크
	@ResponseBody
	@PostMapping("/emailChk")
	public int emailChk(MemberVo mem) {
		int emailChk = memService.emailChk(mem);
		return emailChk;
	}
	
	//회원가입 form
	@GetMapping("/join")
	public void memberJoin() {
		
	}
	//회원가입
	@PostMapping("/join")
	public String memberJoin(MemberVo mem, Model model, RedirectAttributes ra) {
		
		String encPassword = pwEncoder.encode(mem.getMemPw());
		mem.setMemPw(encPassword);
		
		//id체크해서 회원여부 확인
		int chk = memService.idChk(mem);
		
		//회원존재시 되돌아감
		if(chk == 1) {
			ra.addFlashAttribute("msg", "Member_Exist");
			return "member/join";
			
			//회원 미존재시 -> 회원가입 성공
		} else if(chk == 0) {
			memService.memJoin(mem);
		}
		
		//회원가입 성공시 welcome페이지로 넘어감
		return "redirect:/member/welcome";
	}
	//회원가입 완료 페이지
	@GetMapping("/welcome")
	public String welcome() {
		return "member/welcome";
	}
	
	//로그인 form
	@GetMapping("/login")
	public void memberLogin() {

	}
	//로그인
	@PostMapping("/login")
	public String memberLogin(MemberVo mem, HttpServletRequest req, RedirectAttributes ra) {
		
		MemberVo member = memService.login(mem);
		HttpSession session = req.getSession();
		
		//db에 저장된 pw랑 login시 입력한 pw 비교
		String dbPw = mem.getMemPw();
		String pw = member.getMemPw();
		
		boolean pwMatch = pwEncoder.matches(dbPw, pw);
		
		//멤버 존재하거나 pw매치하면
		if(member != null && pwMatch) {
			session.setAttribute("member", member);
			
			//아니면
		} else {
			session.setAttribute("member", null);
			ra.addFlashAttribute("msg", false);
		}
		ra.addFlashAttribute("member", member);
		String referer = req.getHeader("Referer");
		
		return "redirect:" + referer;
	}
	
	
	//로그아웃
	@GetMapping("/logout")
	public String memberLogout(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.invalidate();
		
		return "redirect:/";
	}
	
	
	//비밀번호 체크
	@ResponseBody
	@PostMapping("/pwChk")
	public int pwChk(MemberVo mem) {
		int chk = memService.pwChk(mem);
		return chk;
	}
	
	
	//회원 정보 수정 시 비밀번호 입력 form
	@GetMapping("/password")
	public void password() {
		
	}
	//회원 정보 수정 시 비밀번호 체크
	@PostMapping("/password")
	public String password(MemberVo mem, HttpSession session, RedirectAttributes ra) {
		
		MemberVo member = (MemberVo)session.getAttribute("member");
		
		String encPassword = pwEncoder.encode(mem.getMemPw());
		mem.setMemPw(encPassword);
		
		//db에 저장된 pw랑 login시 입력한 pw 비교
		String dbPw = mem.getMemPw();
		String pw = member.getMemPw();
		
		boolean pwMatch = pwEncoder.matches(dbPw, pw);
		
		if(!pwMatch) {
			ra.addFlashAttribute("msg", false);
			return "redirect:/member/password";
		}
		return "redirect:/member/update";
	}
	
	//회원 정보 수정 form
	@GetMapping("/update")
	public String memberUpdate(@RequestParam("no") int memNo) {
		return "member/update";
	}
	//회원정보 수정
	@PostMapping("/update")
	public String memberUpdate(MemberVo mem, Model model) {
		
		memService.memUpdate(mem);
		
		return "redirect:/member/info";
		
	}
	
	//회원탈퇴시 비밀번호 입력 form
	@GetMapping("/delete")
	public String memberDelete(@RequestParam("no") int memNo) {
		return "member/delete";
	}
	//회원탈퇴시 비밀번호 체크 후 탈퇴
	@PostMapping("/delete")
	public String memberDelete(MemberVo mem, HttpSession session, RedirectAttributes ra) {
		
		MemberVo member = (MemberVo)session.getAttribute("member");
		
		String dbPw = mem.getMemPw();
		String pw = member.getMemPw();
		
		boolean pwMatch = pwEncoder.matches(dbPw, pw);

		if(!pwMatch) {
			ra.addFlashAttribute("msg", false);
			return "redirect:/member/delete";	
		}
		
		memService.memDelete(mem);
		session.invalidate();
		return "redirect:/";
		
	}
	

}
