package com.homepage.taempage.common;

import org.springframework.web.util.UriComponentsBuilder;

public class LCriteria {
	
	private int page;
	private int total;
	private int perPageNum;
	private int rowStart;
	private int rowEnd;

	public LCriteria(int total, int page, int perPageNum) {
		setPage(page);
		setPerPageNum(perPageNum);
		setTotal(total);
	}

	public LCriteria() {
		this.page = 1;
		this.perPageNum = 10;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
		} else {
		this.page = page;
		}
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
		} else {
		this.perPageNum = perPageNum;
		}
	}
	public int getRowStart() {
		rowStart = ((page - 1) * perPageNum) + 1;
		return rowStart;
	}
	public void setRowStart(int rowStart) {
		this.rowStart = rowStart;
	}
	public int getRowEnd() {
		rowEnd = rowStart + perPageNum - 1;
		return rowEnd;
	}
	public void setRowEnd(int rowEnd) {
		this.rowEnd = rowEnd;
	}

	public String makeQuery() {
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", this.perPageNum);
				
		return uriComponentsBuilder.build().encode().toString();
	}

	@Override
	public String toString() {
		return "LCriteria [page=" + page + ", total=" + total + ", perPageNum=" + perPageNum + ", rowStart=" + rowStart
				+ ", rowEnd=" + rowEnd + "]";
	}
	
	

}
