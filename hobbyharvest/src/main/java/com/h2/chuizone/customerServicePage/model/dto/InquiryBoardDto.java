package com.h2.chuizone.customerServicePage.model.dto;

public class InquiryBoardDto {
	private Integer boardNo;
	private Integer inquiryNo;
	private String userNo;
	private String kindOfBoard;
	private String inquiryGroup;
	private String inquiryGroupName;
	private String boardTitle;
	private String createDate;
	private String boardContent;
	private String originFileNames;
	private String changeFileNames;

	public InquiryBoardDto() {}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", inquiryNo=" + inquiryNo + ", userNo=" + userNo + ", kindOfBoard="
				+ kindOfBoard + ", inquiryGroup=" + inquiryGroup + ", inquiryGroupName=" + inquiryGroupName
				+ ", boardTitle=" + boardTitle + ", createDate=" + createDate + ", boardContent=" + boardContent
				+ ", originFileNames=" + originFileNames + ", changeFileNames=" + changeFileNames + "]";
	}

	public InquiryBoardDto(Integer boardNo, Integer inquiryNo, String userNo, String kindOfBoard, String inquiryGroup,
			String inquiryGroupName, String boardTitle, String createDate, String boardContent, String originFileNames,
			String changeFileNames) {
		super();
		this.boardNo = boardNo;
		this.inquiryNo = inquiryNo;
		this.userNo = userNo;
		this.kindOfBoard = kindOfBoard;
		this.inquiryGroup = inquiryGroup;
		this.inquiryGroupName = inquiryGroupName;
		this.boardTitle = boardTitle;
		this.createDate = createDate;
		this.boardContent = boardContent;
		this.originFileNames = originFileNames;
		this.changeFileNames = changeFileNames;
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

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getKindOfBoard() {
		return kindOfBoard;
	}

	public void setKindOfBoard(String kindOfBoard) {
		this.kindOfBoard = kindOfBoard;
	}

	public String getInquiryGroup() {
		return inquiryGroup;
	}

	public void setInquiryGroup(String inquiryGroup) {
		this.inquiryGroup = inquiryGroup;
	}

	public String getInquiryGroupName() {
		return inquiryGroupName;
	}

	public void setInquiryGroupName(String inquiryGroupName) {
		this.inquiryGroupName = inquiryGroupName;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getOriginFileNames() {
		return originFileNames;
	}

	public void setOriginFileNames(String originFileNames) {
		this.originFileNames = originFileNames;
	}

	public String getChangeFileNames() {
		return changeFileNames;
	}

	public void setChangeFileNames(String changeFileNames) {
		this.changeFileNames = changeFileNames;
	}

	
}
