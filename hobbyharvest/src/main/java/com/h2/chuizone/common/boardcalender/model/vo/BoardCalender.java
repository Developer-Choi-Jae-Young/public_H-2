package com.h2.chuizone.common.boardcalender.model.vo;

public class BoardCalender {
	private int boardCalenderNo;
	private int boardNo;
	private int calenderNo;
	
	public BoardCalender(int boardCalenderNo, int boardNo, int calenderNo) {
		this.boardCalenderNo = boardCalenderNo;
		this.boardNo = boardNo;
		this.calenderNo = calenderNo;
	}

	public BoardCalender() {
	}

	public int getBoardCalenderNo() {
		return boardCalenderNo;
	}

	public void setBoardCalenderNo(int boardCalenderNo) {
		this.boardCalenderNo = boardCalenderNo;
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

	@Override
	public String toString() {
		return "BoardCalender [boardCalenderNo=" + boardCalenderNo + ", boardNo=" + boardNo + ", calenderNo="
				+ calenderNo + "]";
	}
}
