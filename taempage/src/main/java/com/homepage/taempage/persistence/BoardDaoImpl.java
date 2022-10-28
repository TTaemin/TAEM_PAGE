package com.homepage.taempage.persistence;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.homepage.taempage.common.Criteria;
import com.homepage.taempage.domain.BoardVo;
import com.homepage.taempage.domain.CategoryVo;
import com.homepage.taempage.domain.ReplyVo;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	
	@Override
	public int countPage(Criteria cri, int cateNo) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("cri", cri);
		map.put("cateNo", cateNo);
		
		return sqlSessionTemplate.selectOne("BoardDao.countPage", map);
	}
	
	@Override
	public List<BoardVo> boardList(Criteria cri, int cateNo) {
		// TODO Auto-generated method stub
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("cri", cri);
		map.put("cateNo", cateNo);
		
		return sqlSessionTemplate.selectList("BoardDao.boardList", map);
	}
	

	@Override
	public BoardVo boardView(int boardNo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("BoardDao.boardView", boardNo);
	}

	@Override
	public void write(BoardVo board) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("BoardDao.write", board);
	}

	@Override
	public void update(BoardVo board) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("BoardDao.update", board);
	}

	@Override
	public void delete(int boardNo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("BoardDao.delete", boardNo);
	}
	
	
	//category
	@Override
	public List<CategoryVo> category() throws Exception {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("BoardDao.category");
	}
	
	
	//reply
	@Override
	public int memChk(int replyNo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("BoardDao.memChk", replyNo);
	}
	
	@Override
	public void reply(ReplyVo reply) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("BoardDao.reply", reply);
	}

	@Override
	public List<ReplyVo> replyList(int boardNo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("BoardDao.replyList", boardNo);
	}

	@Override
	public void replyUpdate(ReplyVo reply) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("BoardDao.replyUpdate", reply);
	}

	@Override
	public void replyDelete(ReplyVo reply) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("BoardDao.replyDelete", reply);
	}

	
	/*admin-page*/
	
	@Override
	public List<BoardVo> adminBoardList(int cateNo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("BoardDao.adminBoardList", cateNo);
	}




}
