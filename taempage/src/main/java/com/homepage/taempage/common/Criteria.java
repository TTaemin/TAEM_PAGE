package com.homepage.taempage.common;

import org.springframework.web.util.UriComponentsBuilder;

import com.homepage.taempage.domain.BoardVo;

public class Criteria {
	
	private int page;
	private int total;
	private int perPageNum;
	private int rowStart;
	private int rowEnd;
	private int cateNo;

	public Criteria(int total, int page, int perPageNum) {
		setPage(page);
		setPerPageNum(perPageNum);
		setTotal(total);
	}

	public Criteria() {
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
	public int getCateNo() {
		return cateNo;
	}

	public void setCateNo(int cateNo, BoardVo board) {
		this.cateNo = cateNo;
	}

	public String makeQuery() {
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
				.queryParam("cate", this.cateNo)
				.queryParam("page", page)
				.queryParam("perPageNum", this.perPageNum);
				
		return uriComponentsBuilder.build().encode().toString();
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", total=" + total + ", perPageNum=" + perPageNum + ", rowStart=" + rowStart
				+ ", rowEnd=" + rowEnd + ", cateNo=" + cateNo + "]";
	}





}