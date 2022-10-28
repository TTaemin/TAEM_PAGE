package com.homepage.taempage.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.homepage.taempage.domain.QnaVo;
import com.homepage.taempage.domain.ReplyVo;

@Repository
public class QnaDaoImpl implements QnaDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int pwChk(QnaVo qna) {
		int chk = sqlSessionTemplate.selectOne("QnaDao.pwChk", qna);
		return chk;
	}

	@Override
	public List<QnaVo> qnaList(QnaVo qna) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("QnaDao.qnaList", qna);
	}

	@Override
	public QnaVo qnaView(QnaVo qna) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void qnaWrite(QnaVo qna) {
		// TODO Auto-generated method stub

	}

	@Override
	public void qnaUpdate(QnaVo qna) {
		// TODO Auto-generated method stub

	}

	@Override
	public void qnaDelete(QnaVo qna) {
		// TODO Auto-generated method stub

	}

	@Override
	public void qnaRepWrite(ReplyVo reply) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ReplyVo> qnaRepList(ReplyVo reply) {
		// TODO Auto-generated method stub
		return null;
	}

}
