package com.homepage.taempage.domain;

import java.util.Date;

public class QnaVo {
	
	private int qnaNo;
	private int memNo;
	private String open;
	private String qnaPw;
	private String qnaTitle;
	private String qnaContent;
	private Date qnaDate;
	private String fileName;
	
	//reply
	private int replyNo;
	
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getQnaPw() {
		return qnaPw;
	}
	public void setQnaPw(String qnaPw) {
		this.qnaPw = qnaPw;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}
	public Date getQnaDate() {
		return qnaDate;
	}
	public void setQnaDate(Date qnaDate) {
		this.qnaDate = qnaDate;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	@Override
	public String toString() {
		return "QnaVo [qnaNo=" + qnaNo + ", memNo=" + memNo + ", open=" + open + ", qnaPw=" + qnaPw + ", qnaTitle="
				+ qnaTitle + ", qnaContent=" + qnaContent + ", qnaDate=" + qnaDate + ", fileName=" + fileName
				+ ", replyNo=" + replyNo + "]";
	}

	
	

}
