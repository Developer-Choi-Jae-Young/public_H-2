package com.h2.chuizone.common.calendercategoryboard.model.vo;

public class CalenderCategoryBoard {
	private int calenderCategoryBoardNo;
	private int categoryBoardNo;
	private int calenderNo;
	
	public CalenderCategoryBoard(int calenderCategoryBoardNo, int categoryBoardNo, int calenderNo) {
		this.calenderCategoryBoardNo = calenderCategoryBoardNo;
		this.categoryBoardNo = categoryBoardNo;
		this.calenderNo = calenderNo;
	}

	public CalenderCategoryBoard() {
	}

	public int getCalenderCategoryBoardNo() {
		return calenderCategoryBoardNo;
	}

	public void setCalenderCategoryBoardNo(int calenderCategoryBoardNo) {
		this.calenderCategoryBoardNo = calenderCategoryBoardNo;
	}

	public int getCategoryBoardNo() {
		return categoryBoardNo;
	}

	public void setCategoryBoardNo(int categoryBoardNo) {
		this.categoryBoardNo = categoryBoardNo;
	}

	public int getCalenderNo() {
		return calenderNo;
	}

	public void setCalenderNo(int calenderNo) {
		this.calenderNo = calenderNo;
	}

	@Override
	public String toString() {
		return "CalenderCategoryBoard [calenderCategoryBoardNo=" + calenderCategoryBoardNo + ", categoryBoardNo="
				+ categoryBoardNo + ", calenderNo=" + calenderNo + "]";
	}
}
