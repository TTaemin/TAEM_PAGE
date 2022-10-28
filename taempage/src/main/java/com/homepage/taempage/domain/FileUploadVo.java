package com.homepage.taempage.domain;

import java.util.Date;

public class FileUploadVo {
	
	private int fileNo;
	private String fileName;
	private String orgFile;
	private int fileSize;
	private Date fileDate;
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOrgFile() {
		return orgFile;
	}
	public void setOrgFile(String orgFile) {
		this.orgFile = orgFile;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	public Date getFileDate() {
		return fileDate;
	}
	public void setFileDate(Date fileDate) {
		this.fileDate = fileDate;
	}
	@Override
	public String toString() {
		return "FileUploadVo [fileNo=" + fileNo + ", fileName=" + fileName + ", orgFile=" + orgFile + ", fileSize=" + fileSize
				+ ", fileDate=" + fileDate + "]";
	}

	

}
