package com.h2.chuizone.calender.model.dto;

import java.sql.Date;

public class CalenderDto {
	private int boardNo;
	private int calenderNo;
	private int memberNo;
	private int categoryBoardNo;
	private String title;
	private String content;
	private Date startDate;
	private Date endDate;
	
	public CalenderDto(int boardNo, int calenderNo, int memberNo, int categoryBoardNo, String title, String content, Date startDate,
			Date endDate) {
		this.boardNo = boardNo;
		this.calenderNo = calenderNo;
		this.categoryBoardNo = categoryBoardNo;
		this.title = title;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public CalenderDto() {
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getCalenderNo() {
		return calenderNo;
	}

	public void setCalenderNo(int calenderNo) {
		this.calenderNo = calenderNo;
	}

	public int getCategoryBoardNo() {
		return categoryBoardNo;
	}

	public void setCategoryBoardNo(int categoryBoardNo) {
		this.categoryBoardNo = categoryBoardNo;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "CalenderDto [boardNo=" + boardNo + ", calenderNo=" + calenderNo + ", memberNo=" + memberNo
				+ ", categoryBoardNo=" + categoryBoardNo + ", title=" + title + ", content=" + content + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
}
