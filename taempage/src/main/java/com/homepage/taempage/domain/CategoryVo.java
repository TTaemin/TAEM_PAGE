package com.homepage.taempage.domain;

public class CategoryVo {
	
	private int cateNo;
	private String cateName;
	private int tier;
	
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
	public int getTier() {
		return tier;
	}
	public void setTier(int tier) {
		this.tier = tier;
	}
	@Override
	public String toString() {
		return "CategoryVo [cateNo=" + cateNo + ", cateName=" + cateName + ", tier=" + tier + "]";
	}



	

}
