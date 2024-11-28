package com.h2.chuizone.common.categoryboardrecommand.model.vo;

public class CategoryBoardRecommand {
	private int categoryBoardRecommandNo;
	private int memberNo;
	private int categoryNo;
	
	public CategoryBoardRecommand(int categoryBoardRecommandNo, int memberNo, int categoryNo) {
		this.categoryBoardRecommandNo = categoryBoardRecommandNo;
		this.memberNo = memberNo;
		this.categoryNo = categoryNo;
	}

	public CategoryBoardRecommand() {
	}

	public int getCategoryBoardRecommandNo() {
		return categoryBoardRecommandNo;
	}

	public void setCategoryBoardRecommandNo(int categoryBoardRecommandNo) {
		this.categoryBoardRecommandNo = categoryBoardRecommandNo;
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
		return "CategoryBoardRecommand [categoryBoardRecommandNo=" + categoryBoardRecommandNo + ", memberNo=" + memberNo
				+ ", categoryNo=" + categoryNo + "]";
	}
}
