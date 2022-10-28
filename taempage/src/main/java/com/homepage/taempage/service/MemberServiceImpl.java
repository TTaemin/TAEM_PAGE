package com.homepage.taempage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.homepage.taempage.domain.MemberVo;
import com.homepage.taempage.persistence.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memDao;

	@Override
	public int idChk(MemberVo mem) {
		// TODO Auto-generated method stub
		return memDao.idChk(mem);
	}

	@Override
	public int pwChk(MemberVo mem) {
		// TODO Auto-generated method stub
		return memDao.pwChk(mem);
	}

	@Override
	public int emailChk(MemberVo mem) {
		// TODO Auto-generated method stub
		return memDao.emailChk(mem);
	}

	@Override
	public void memJoin(MemberVo mem) {
		// TODO Auto-generated method stub

		
		memDao.memJoin(mem);
	}

	@Override
	public MemberVo login(MemberVo mem) {
		// TODO Auto-generated method stub
		return memDao.login(mem);
	}

	@Override
	public void memUpdate(MemberVo mem) {
		// TODO Auto-generated method stub

		memDao.memUpdate(mem);
	}

	@Override
	public void memDelete(MemberVo mem) {
		// TODO Auto-generated method stub
		memDao.memDelete(mem);
	}

	@Override
	public MemberVo memInfo(int memNo) {
		// TODO Auto-generated method stub
		return memDao.memInfo(memNo);
	}

	@Override
	public List<MemberVo> userList() {
		// TODO Auto-generated method stub
		return memDao.userList();
	}

	@Override
	public void userUpdate(MemberVo mem) {
		// TODO Auto-generated method stub
		memDao.userUpdate(mem);
	}

	@Override
	public void userDelete(int memNo) {
		// TODO Auto-generated method stub
		memDao.userDelete(memNo);
	}

}
