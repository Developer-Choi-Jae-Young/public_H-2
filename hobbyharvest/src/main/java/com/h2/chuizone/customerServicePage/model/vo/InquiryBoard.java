package com.h2.chuizone.customerServicePage.model.vo;

public class InquiryBoard {
	private Integer boardNo;
	private Integer inquiryNo;
	
	public InquiryBoard() {}

	@Override
	public String toString() {
		return "InquiryBoard [boardNo=" + boardNo + ", inquiryNo=" + inquiryNo + "]";
	}

	public InquiryBoard(Integer boardNo, Integer inquiryNo) {
		super();
		this.boardNo = boardNo;
		this.inquiryNo = inquiryNo;
	}

	public Integer getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(Integer boardNo) {
		this.boardNo = boardNo;
	}

	public Integer getInquiryNo() {
		return inquiryNo;
	}

	public void setInquiryNo(Integer inquiryNo) {
		this.inquiryNo = inquiryNo;
	}

	

	

	
	
	
	
	

}
