package com.homepage.taempage.common;

import org.springframework.web.util.UriComponentsBuilder;

public class Search {
	
	private String searchType = ""; // 검색 항목
	private String keyword = ""; // 검색하는 문자열
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String makeSearch() {
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance();
		
		if(searchType != null) {
			uriComponentsBuilder
				.queryParam("searchType", searchType)
				.queryParam("keyword", keyword);
		}
		return uriComponentsBuilder.build().encode().toString();
	}
	
	@Override
	public String toString() {
		return "Search [searchType=" + searchType + ", keyword=" + keyword + "]";
	}

}
