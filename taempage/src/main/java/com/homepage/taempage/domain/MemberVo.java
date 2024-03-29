package com.homepage.taempage.domain;

import java.util.Date;

public class MemberVo {
	
	private int memNo;
	private String memId;
	private String memPw;
	private String memName;
	private String memEmail;
	private String memPhone;
	private Date joinDate;
	private int verify;
	
	public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public int getVerify() {
		return verify;
	}
	public void setVerify(int verify) {
		this.verify = verify;
	}
	@Override
	public String toString() {
		return "MemberVo [memNo=" + memNo + ", memId=" + memId + ", memPw=" + memPw + ", memName=" + memName
				+ ", memEmail=" + memEmail + ", memPhone=" + memPhone + ", joinDate=" + joinDate + ", verify=" + verify
				+ "]";
	}
	


	
	

}
