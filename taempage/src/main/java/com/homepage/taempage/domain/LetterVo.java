package com.homepage.taempage.domain;

import java.util.Date;

/*
create table LETTER(
    letterNo NUMBER PRIMARY KEY,
    memNo NUMBER,
    lPassword VARCHAR2(20),
    lTitle VARCHAR2(100),
    lContent VARCHAR2(3000),
    lReply VARCHAR2(3000),
    letterDate Date DEFAULT SYSDATE
);
 */

public class LetterVo {

	private int letterNo;
	private int memNo;
	private String memId;
	private String lPassword;
	private String lTitle;
	private String lContent;
	private String lReply;
	private Date letterDate;
	public int getLetterNo() {
		return letterNo;
	}
	public void setLetterNo(int letterNo) {
		this.letterNo = letterNo;
	}
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
	public String getlPassword() {
		return lPassword;
	}
	public void setlPassword(String lPassword) {
		this.lPassword = lPassword;
	}
	public String getlTitle() {
		return lTitle;
	}
	public void setlTitle(String lTitle) {
		this.lTitle = lTitle;
	}
	public String getlContent() {
		return lContent;
	}
	public void setlContent(String lContent) {
		this.lContent = lContent;
	}
	public String getlReply() {
		return lReply;
	}
	public void setlReply(String lReply) {
		this.lReply = lReply;
	}
	public Date getLetterDate() {
		return letterDate;
	}
	public void setLetterDate(Date letterDate) {
		this.letterDate = letterDate;
	}
	@Override
	public String toString() {
		return "LetterVo [letterNo=" + letterNo + ", memNo=" + memNo + ", memId=" + memId + ", lPassword=" + lPassword
				+ ", lTitle=" + lTitle + ", lContent=" + lContent + ", lReply=" + lReply + ", letterDate=" + letterDate
				+ "]";
	}

	
	
	
}
