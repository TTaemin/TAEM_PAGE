package com.homepage.taempage.persistence;

import java.util.List;

import com.homepage.taempage.domain.MemberVo;

public interface MemberDao {
	
	//id 체크
	public int idChk(MemberVo mem);
	
	//pw 체크
	public int pwChk(MemberVo mem);
	
	//email 체크
	public int emailChk(MemberVo mem);
	
	/* 회원 */
	//회원가입
	public void memJoin(MemberVo mem);
	
	//로그인
	public MemberVo login(MemberVo mem);
	
	//멤버정보수정
	public void memUpdate(MemberVo mem);
	
	//회원탈퇴
	public void memDelete(MemberVo mem);
	
	//회원정보보기
	public MemberVo memInfo(int memNo);
	
	
	/* 관리자 */	
	//멤버리스트
	public List<MemberVo> userList();
	
	//멤버수정
	public void userUpdate(MemberVo mem);
	
	//멤버삭제
	public void userDelete(int memNo);
	

}
