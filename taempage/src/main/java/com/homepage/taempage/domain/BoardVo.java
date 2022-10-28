package com.homepage.taempage.domain;

import java.util.Date;

public class BoardVo {
	
	private int boardNo;
	private int cateNo;
	private String cateName;
	private String open;
	private String boardPw;
	private String writer;
	private String title;
	private String content;
	private Date boardDate;
	private String fileName;
	private int replyNo;
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public int getCateNo() {
		return cateNo;
	}
	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}
	
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getBoardPw() {
		return boardPw;
	}
	public void setBoardPw(String boardPw) {
		this.boardPw = boardPw;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
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
		return "BoardVo [boardNo=" + boardNo + ", cateNo=" + cateNo + ", cateName=" + cateName + ", open=" + open
				+ ", boardPw=" + boardPw + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", boardDate=" + boardDate + ", fileName=" + fileName + ", replyNo=" + replyNo + "]";
	}

	

}
