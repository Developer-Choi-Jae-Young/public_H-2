package com.h2.chuizone.category.model.vo;

public class CategoryBoard {
	private int categoryBoardNo;
	private int smallGroupCategoryNo;
	private int clubNo;
	private int kindOfBoardNo;
	private int recommentCnt;
	private int viewCnt;
	private int reportCnt;
	private int scrapCnt;
	private String mainImg;
	private int maxHeadCnt;
	private int curHeadCnt;
	
	public CategoryBoard(int categoryBoardNo, int smallGroupCategoryNo, int clubNo, int kindOfBoardNo, int recommentCnt,
			int viewCnt, int reportCnt, int scrapCnt, String mainImg, int maxHeadCnt, int curHeadCnt) {
		this.categoryBoardNo = categoryBoardNo;
		this.smallGroupCategoryNo = smallGroupCategoryNo;
		this.clubNo = clubNo;
		this.kindOfBoardNo = kindOfBoardNo;
		this.recommentCnt = recommentCnt;
		this.viewCnt = viewCnt;
		this.reportCnt = reportCnt;
		this.scrapCnt = scrapCnt;
		this.mainImg = mainImg;
		this.maxHeadCnt = maxHeadCnt;
		this.curHeadCnt = curHeadCnt;
	}
	
	public CategoryBoard(int smallGroupCategoryNo, String mainImg, int maxHeadCnt) {
		super();
		this.smallGroupCategoryNo = smallGroupCategoryNo;
		this.mainImg = mainImg;
		this.maxHeadCnt = maxHeadCnt;
	}

	public CategoryBoard() {
	}

	public int getCategoryBoardNo() {
		return categoryBoardNo;
	}

	public void setCategoryBoardNo(int categoryBoardNo) {
		this.categoryBoardNo = categoryBoardNo;
	}

	public int getSmallGroupCategoryNo() {
		return smallGroupCategoryNo;
	}

	public void setSmallGroupCategoryNo(int smallGroupCategoryNo) {
		this.smallGroupCategoryNo = smallGroupCategoryNo;
	}

	public int getClubNo() {
		return clubNo;
	}

	public void setClubNo(int clubNo) {
		this.clubNo = clubNo;
	}

	public int getKindOfBoardNo() {
		return kindOfBoardNo;
	}

	public void setKindOfBoardNo(int kindOfBoardNo) {
		this.kindOfBoardNo = kindOfBoardNo;
	}

	public int getRecommentCnt() {
		return recommentCnt;
	}

	public void setRecommentCnt(int recommentCnt) {
		this.recommentCnt = recommentCnt;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public int getReportCnt() {
		return reportCnt;
	}

	public void setReportCnt(int reportCnt) {
		this.reportCnt = reportCnt;
	}

	public int getScrapCnt() {
		return scrapCnt;
	}

	public void setScrapCnt(int scrapCnt) {
		this.scrapCnt = scrapCnt;
	}

	public String getMainImg() {
		return mainImg;
	}

	public void setMainImg(String mainImg) {
		this.mainImg = mainImg;
	}

	public int getMaxHeadCnt() {
		return maxHeadCnt;
	}

	public void setMaxHeadCnt(int maxHeadCnt) {
		this.maxHeadCnt = maxHeadCnt;
	}

	public int getCurHeadCnt() {
		return curHeadCnt;
	}

	public void setCurHeadCnt(int curHeadCnt) {
		this.curHeadCnt = curHeadCnt;
	}

	@Override
	public String toString() {
		return "CategoryBoard [categoryBoardNo=" + categoryBoardNo + ", clubNo=" + clubNo
				+ ", kindOfBoardNo=" + kindOfBoardNo + ", recommentCnt=" + recommentCnt + ", viewCnt=" + viewCnt
				+ ", reportCnt=" + reportCnt + ", scrapCnt=" + scrapCnt + ", mainImg=" + mainImg + ", maxHeadCnt="
				+ maxHeadCnt + ", curHeadCnt=" + curHeadCnt + "]";
	}
}
