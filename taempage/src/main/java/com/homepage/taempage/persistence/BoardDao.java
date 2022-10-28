package com.homepage.taempage.persistence;

import java.util.List;

import com.homepage.taempage.common.Criteria;
import com.homepage.taempage.domain.BoardVo;
import com.homepage.taempage.domain.CategoryVo;
import com.homepage.taempage.domain.ReplyVo;

public interface BoardDao {
	
	//카운트페이지
	public int countPage(Criteria cri, int cateNo);
	
	//리스트
	public List<BoardVo> boardList(Criteria cri, int cateNo);
	
	//상세보기
	public BoardVo boardView(int boardNo);
	
	//입력
	public void write(BoardVo board);
	
	//비밀글 설정
	
	//수정
	public void update(BoardVo board);
	
	//삭제
	public void delete(int boardNo);
	
	
	/*category*/
	public List<CategoryVo> category() throws Exception;
	
	/*reply*/
	//멤버체크
	public int memChk(int replyNo);
	
	//댓글달기
	public void reply(ReplyVo reply);
	
	//댓글리스트
	public List<ReplyVo> replyList(int boardNo);
	
	//댓글수정
	public void replyUpdate(ReplyVo reply);
	
	//댓글삭제
	public void replyDelete(ReplyVo reply);
	
	
	/*admin page*/
	//글 리스트
	public List<BoardVo> adminBoardList(int cateNo);
	
}
