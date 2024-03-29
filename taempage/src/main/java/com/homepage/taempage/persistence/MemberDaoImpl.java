package com.homepage.taempage.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.homepage.taempage.domain.MemberVo;

@Repository
public class MemberDaoImpl implements MemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public int idChk(MemberVo mem) {
		int chk = sqlSessionTemplate.selectOne("MemberDao.idChk", mem);
		return chk;
	}

	@Override
	public int pwChk(MemberVo mem) {
		int chk = sqlSessionTemplate.selectOne("MemberDao.pwChk", mem);
		return chk;
	}

	@Override
	public int emailChk(MemberVo mem) {
		int chk = sqlSessionTemplate.selectOne("MemberDao.emailChk", mem);
		return chk;
	}

	@Override
	public void memJoin(MemberVo mem) {
		sqlSessionTemplate.insert("MemberDao.memJoin", mem);
		
	}

	@Override
	public MemberVo login(MemberVo mem) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("MemberDao.login", mem);
	}

	@Override
	public void memUpdate(MemberVo mem) {
		sqlSessionTemplate.update("MemberDao.memUpdate", mem);
		
	}

	@Override
	public void memDelete(MemberVo mem) {
		sqlSessionTemplate.delete("MemberDao.memDelete", mem);
		
	}

	@Override
	public MemberVo memInfo(int memNo) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("MemberDao.memInfo", memNo);
	}

	@Override
	public List<MemberVo> userList() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("MemberDao.userList");
	}

	@Override
	public void userUpdate(MemberVo mem) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("MemberDao.userUpdate", mem);
	}

	@Override
	public void userDelete(int memNo) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("MemberDao.userDelete", memNo);
	}

}
