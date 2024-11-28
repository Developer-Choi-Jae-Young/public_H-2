package com.h2.chuizone.common.categoryboardcomplain.model.vo;

public class CategoryBoardComplain {
	private int categoryBoardComplainNo;
	private int memberNo;
	private int categoryNo;
	
	public CategoryBoardComplain(int categoryBoardComplainNo, int memberNo, int categoryNo) {
		this.categoryBoardComplainNo = categoryBoardComplainNo;
		this.memberNo = memberNo;
		this.categoryNo = categoryNo;
	}

	public CategoryBoardComplain() {
	}

	public int getCategoryBoardComplainNo() {
		return categoryBoardComplainNo;
	}

	public void setCategoryBoardComplainNo(int categoryBoardComplainNo) {
		this.categoryBoardComplainNo = categoryBoardComplainNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	@Override
	public String toString() {
		return "CategoryBoardComplain [categoryBoardComplainNo=" + categoryBoardComplainNo + ", memberNo=" + memberNo
				+ ", categoryNo=" + categoryNo + "]";
	}
}
