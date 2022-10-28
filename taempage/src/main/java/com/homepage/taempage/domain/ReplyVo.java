package com.homepage.taempage.domain;

import java.util.Date;

public class ReplyVo {
	
	private int replyNo;
	private int memNo;
	private int boardNo;
	private String reply;
	private Date replyDate;
	private String memId;
	
	public int getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}
	public int getMemNo() {
		return memNo;
	}
	public void setMemNo(int memNo) {
		this.memNo = memNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	@Override
	public String toString() {
		return "ReplyVo [replyNo=" + replyNo + ", memNo=" + memNo + ", boardNo=" + boardNo + ", reply=" + reply
				+ ", replyDate=" + replyDate + ", memId=" + memId + "]";
	}
	
	

}
