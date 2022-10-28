package com.homepage.taempage.service;

import java.util.List;

import com.homepage.taempage.domain.QnaVo;
import com.homepage.taempage.domain.ReplyVo;

public interface QnaService {
	
	//pw Check
	public int pwChk(QnaVo qna);
	
	//리스트
	public List<QnaVo> qnaList(QnaVo qna);
	
	//상세보기
	public QnaVo qnaView(QnaVo qna);
	
	//글쓰기
	public void qnaWrite(QnaVo qna);
	
	//수정
	public void qnaUpdate(QnaVo qna);
	
	//지우기
	public void qnaDelete(QnaVo qna);
	
	//댓글쓰기
	public void qnaRepWrite(ReplyVo reply);
	
	//댓글리스트
	public List<ReplyVo> qnaRepList(ReplyVo reply);

}
