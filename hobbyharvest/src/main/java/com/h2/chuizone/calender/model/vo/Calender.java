package com.h2.chuizone.calender.model.vo;

import java.sql.Date;

public class Calender {
	private int calenderNo;
	private int kindOfBoardNo;
	private Date startDate;
	private Date endDate;
	
	public Calender(int calenderNo, int kindOfBoardNo, Date startDate, Date endDate) {
		this.calenderNo = calenderNo;
		this.kindOfBoardNo = kindOfBoardNo;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Calender() {
		super();
	}

	public int getCalenderNo() {
		return calenderNo;
	}

	public void setCalenderNo(int calenderNo) {
		this.calenderNo = calenderNo;
	}

	public int getKindOfBoardNo() {
		return kindOfBoardNo;
	}

	public void setKindOfBoardNo(int kindOfBoardNo) {
		this.kindOfBoardNo = kindOfBoardNo;
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

	@Override
	public String toString() {
		return "Calender [calenderNo=" + calenderNo + ", kindOfBoardNo=" + kindOfBoardNo + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
}
