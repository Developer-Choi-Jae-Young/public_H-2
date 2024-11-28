package com.h2.chuizone.category.model.dto;

import java.sql.Date;

public class SelectCategoryBoardListDto {
	private int boardNo;
	private int categoryBoardNo;
  	private String clubName;
  	private int clubNo;
  	private String memberNicname;
  	private int memberNo;
  	private String smallGroupName;
  	private String categoryName;
  	private String boardTitle;
  	private Date boardDate;
  	private String boardContent;
  	private int recommandNo;
  	private int complain;
  	private int views;
  	private int scrap;
  	private String categoryBoardImage;
  	private int maxCount;
  	private int currentCount;
  	
	public SelectCategoryBoardListDto(int boardNo, int categoryBoardNo, String clubName, int clubNo, String memberNicname, int memberNo, String smallGroupName,
			String categoryName, String boardTitle, Date boardDate, String boardContent, int recommandNo, int complain, int views, int scrap,
			String categoryBoardImage, int maxCount, int currentCount) {
		this.boardNo = boardNo;
		this.categoryBoardNo = categoryBoardNo;
		this.clubName = clubName;
		this.clubNo = clubNo;
		this.memberNicname = memberNicname;
		this.memberNo = memberNo;
		this.smallGroupName = smallGroupName;
		this.categoryName = categoryName;
		this.boardTitle = boardTitle;
		this.boardDate = boardDate;
		this.boardContent = boardContent;
		this.recommandNo = recommandNo;
		this.complain = complain;
		this.views = views;
		this.scrap = scrap;
		this.categoryBoardImage = categoryBoardImage;
		this.maxCount = maxCount;
		this.currentCount = currentCount;
	}

	public SelectCategoryBoardListDto() {
		super();
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getMemberNicname() {
		return memberNicname;
	}

	public void setMemberNicname(String memberNicname) {
		this.memberNicname = memberNicname;
	}

	public String getSmallGroupName() {
		return smallGroupName;
	}

	public void setSmallGroupName(String smallGroupName) {
		this.smallGroupName = smallGroupName;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public int getRecommandNo() {
		return recommandNo;
	}

	public void setRecommandNo(int recommandNo) {
		this.recommandNo = recommandNo;
	}

	public int getComplain() {
		return complain;
	}

	public void setComplain(int complain) {
		this.complain = complain;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getScrap() {
		return scrap;
	}

	public void setScrap(int scrap) {
		this.scrap = scrap;
	}

	public String getCategoryBoardImage() {
		return categoryBoardImage;
	}

	public void setCategoryBoardImage(String categoryBoardImage) {
		this.categoryBoardImage = categoryBoardImage;
	}

	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

	
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getClubNo() {
		return clubNo;
	}

	public void setClubNo(int clubNo) {
		this.clubNo = clubNo;
	}
	
	public int getCategoryBoardNo() {
		return categoryBoardNo;
	}

	public void setCategoryBoardNo(int categoryBoardNo) {
		this.categoryBoardNo = categoryBoardNo;
	}
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "SelectCategoryBoardListDto [boardNo=" + boardNo + ", categoryBoardNo=" + categoryBoardNo + ", clubName="
				+ clubName + ", clubNo=" + clubNo + ", memberNicname=" + memberNicname + ", memberNo=" + memberNo
				+ ", smallGroupName=" + smallGroupName + ", categoryName=" + categoryName + ", boardTitle=" + boardTitle
				+ ", boardDate=" + boardDate + ", boardContent=" + boardContent + ", recommandNo=" + recommandNo
				+ ", complain=" + complain + ", views=" + views + ", scrap=" + scrap + ", categoryBoardImage="
				+ categoryBoardImage + ", maxCount=" + maxCount + ", currentCount=" + currentCount + "]";
	}
}
