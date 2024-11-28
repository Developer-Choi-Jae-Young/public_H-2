package com.h2.chuizone.common.smallgroupcategory.model.vo;

public class SmallGroupCategory {
	private int smallGroupCategoryNo;
	private int smallGroupNo;
	private int categoryNo;
	
	public SmallGroupCategory(int smallGroupCategoryNo, int smallGroupNo, int categoryNo) {
		this.smallGroupCategoryNo = smallGroupCategoryNo;
		this.smallGroupNo = smallGroupNo;
		this.categoryNo = categoryNo;
	}

	public SmallGroupCategory() {
	}

	public int getSmallGroupCategoryNo() {
		return smallGroupCategoryNo;
	}

	public void setSmallGroupCategoryNo(int smallGroupCategoryNo) {
		this.smallGroupCategoryNo = smallGroupCategoryNo;
	}

	public int getSmallGroupNo() {
		return smallGroupNo;
	}

	public void setSmallGroupNo(int smallGroupNo) {
		this.smallGroupNo = smallGroupNo;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	@Override
	public String toString() {
		return "SmallGroupCategory [smallGroupCategoryNo=" + smallGroupCategoryNo + ", smallGroupNo=" + smallGroupNo
				+ ", categoryNo=" + categoryNo + "]";
	}
}
