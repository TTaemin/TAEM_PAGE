package com.homepage.taempage.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.homepage.taempage.common.Criteria;
import com.homepage.taempage.common.LCriteria;
import com.homepage.taempage.domain.LetterVo;

@Repository
public class LetterDaoImpl implements LetterDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int countPage(LCriteria lCri) {
		int chk = sqlSessionTemplate.selectOne("LetterDao.countPage", lCri);
		return chk;
	}

	@Override
	public List<LetterVo> letterList(LCriteria lCri) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("LetterDao.letterList", lCri);
	}

	@Override
	public LetterVo letterView(int letterNo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("LetterDao.letterView", letterNo);
	}

	@Override
	public void letterWrite(LetterVo letter) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("LetterDao.letterWrite", letter);
	}

	@Override
	public LetterVo pwChk(int letterNo) {
		return sqlSessionTemplate.selectOne("LetterDao.pwChk", letterNo);
	}

	@Override
	public void letterUpdate(LetterVo letter) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("LetterDao.letterUpdate", letter);
	}

	@Override
	public void letterDelete(int letterNo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("LetterDao.letterDelete", letterNo);
	}
	
	
	//reply
	
	@Override
	public int memChk(int letterNo) {
		return sqlSessionTemplate.selectOne("LetterDao.memChk", letterNo);
	}

	@Override
	public void lReplyWrite(LetterVo letter) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.insert("LetterDao.lReplyWrite", letter);
	}

	@Override
	public LetterVo lReplyView(int letterNo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("LetterDao.lReplyView", letterNo);
	}

	@Override
	public void lReplyUpdate(LetterVo letter) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("LetterDao.lReplyUpdate", letter);
	}

	@Override
	public void lReplyDelete(LetterVo letter) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("LetterDao.lReplyDelete", letter);
	}




}
