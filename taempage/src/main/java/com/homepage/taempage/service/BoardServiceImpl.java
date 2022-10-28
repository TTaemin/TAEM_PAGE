package com.homepage.taempage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homepage.taempage.common.Criteria;
import com.homepage.taempage.domain.BoardVo;
import com.homepage.taempage.domain.CategoryVo;
import com.homepage.taempage.domain.ReplyVo;
import com.homepage.taempage.persistence.BoardDao;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	
	@Override
	public int countPage(Criteria cri, int cateNo) {
		// TODO Auto-generated method stub
		return boardDao.countPage(cri, cateNo);
	}

	@Override
	public List<BoardVo> boardList(Criteria cri, int cateNo) {
		// TODO Auto-generated method stub
		return boardDao.boardList(cri, cateNo);
	}
	

	@Override
	public BoardVo boardView(int boardNo) {
		// TODO Auto-generated method stub
		return boardDao.boardView(boardNo);
	}

	@Override
	public void write(BoardVo board) {
		// TODO Auto-generated method stub
		boardDao.write(board);
	}

	@Override
	public void update(BoardVo board) {
		// TODO Auto-generated method stub
		boardDao.update(board);
	}

	@Override
	public void delete(int boardNo) {
		// TODO Auto-generated method stub
		boardDao.delete(boardNo);
	}
	
	
	//category
	@Override
	public List<CategoryVo> category() throws Exception {
		// TODO Auto-generated method stub
		return boardDao.category();
	}

	

	//reply
	@Override
	public int memChk(int replyNo) {
		// TODO Auto-generated method stub
		return boardDao.memChk(replyNo);
	}
	
	@Override
	public void reply(ReplyVo reply) {
		// TODO Auto-generated method stub
		boardDao.reply(reply);
	}

	@Override
	public List<ReplyVo> replyList(int boardNo) {
		// TODO Auto-generated method stub
		return boardDao.replyList(boardNo);
	}

	@Override
	public void replyUpdate(ReplyVo reply) {
		// TODO Auto-generated method stub
		boardDao.replyUpdate(reply);
	}

	@Override
	public void replyDelete(ReplyVo reply) {
		// TODO Auto-generated method stub
		boardDao.replyDelete(reply);
	}

	
	/*admin-page*/
	
	@Override
	public List<BoardVo> adminBoardList(int cateNo) {
		// TODO Auto-generated method stub
		return boardDao.adminBoardList(cateNo);
	}






}
