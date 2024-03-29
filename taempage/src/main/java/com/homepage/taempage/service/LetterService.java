package com.homepage.taempage.service;

import java.util.List;

import com.homepage.taempage.common.Criteria;
import com.homepage.taempage.common.LCriteria;
import com.homepage.taempage.domain.LetterVo;

public interface LetterService {
	
	//카운트 페이지
	public int countPage(LCriteria lCri);
	
	//리스트
	public List<LetterVo> letterList(LCriteria lCri);
	
	//글 상세보기
	public LetterVo letterView(int letterNo);
	
	//글 쓰기
	public void letterWrite(LetterVo letter);
	
	//pw 체크
	public LetterVo pwChk(int letterNo);
	
	//글 수정
	public void letterUpdate(LetterVo letter);
	
	//글 삭제
	public void letterDelete(int letterNo);
	
	
	/*reply*/
	
	//memCheck
	public int memChk(int letterNo);
	
	//reply입력
	public void lReplyWrite(LetterVo letter);
	
	//reply보기
	public LetterVo lReplyView(int letterNo);
	
	//reply수정
	public void lReplyUpdate(LetterVo letter);
	
	//reply삭제
	public void lReplyDelete(LetterVo letter);


}
