package com.homepage.taempage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homepage.taempage.common.Criteria;
import com.homepage.taempage.common.LCriteria;
import com.homepage.taempage.domain.LetterVo;
import com.homepage.taempage.persistence.LetterDao;

@Service
public class LetterServiceImpl implements LetterService {
	
	@Autowired
	private LetterDao letterDao;

	@Override
	public int countPage(LCriteria lCri) {
		// TODO Auto-generated method stub
		return letterDao.countPage(lCri);
	}

	@Override
	public List<LetterVo> letterList(LCriteria lCri) {
		// TODO Auto-generated method stub
		return letterDao.letterList(lCri);
	}

	@Override
	public LetterVo letterView(int letterNo) {
		// TODO Auto-generated method stub
		return letterDao.letterView(letterNo);
	}

	@Override
	public void letterWrite(LetterVo letter) {
		// TODO Auto-generated method stub
		letterDao.letterWrite(letter);
	}

	@Override
	public LetterVo pwChk(int letterNo) {
		// TODO Auto-generated method stub
		return letterDao.pwChk(letterNo);
	}

	@Override
	public void letterUpdate(LetterVo letter) {
		// TODO Auto-generated method stub
		letterDao.letterUpdate(letter);
	}

	@Override
	public void letterDelete(int letterNo) {
		// TODO Auto-generated method stub
		letterDao.letterDelete(letterNo);
	}
	
	
	//reply

	@Override
	public int memChk(int letterNo) {
		// TODO Auto-generated method stub
		return letterDao.memChk(letterNo);
	}
	
	@Override
	public void lReplyWrite(LetterVo letter) {
		// TODO Auto-generated method stub
		letterDao.lReplyWrite(letter);
	}

	@Override
	public LetterVo lReplyView(int letterNo) {
		return letterDao.lReplyView(letterNo);
	}

	@Override
	public void lReplyUpdate(LetterVo letter) {
		// TODO Auto-generated method stub
		letterDao.lReplyUpdate(letter);
	}

	@Override
	public void lReplyDelete(LetterVo letter) {
		// TODO Auto-generated method stub
		letterDao.lReplyDelete(letter);
	}



}
