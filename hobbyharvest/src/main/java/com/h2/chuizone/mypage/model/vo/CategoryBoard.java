package com.h2.chuizone.mypage.model.vo;


public class CategoryBoard {
	private int cbNo;		// 카테고리 게시글 번호
	private int caNo;		// 카테고리 번호
	private int cNo;		// 소모임 번호
	private int kbNo;		// 게시판 종류 번호
	private int rcNo;		// 추천수
	private int complain;	// 신고횟수
	private int views;		// 조회수
	private int scrap;		// 스크랩 횟수
	private String cbImg;		// 대표이미지
	private int maxCount;	// 최대 인원수
	private int currCount;	// 현재 인원수

	
	public CategoryBoard() {}

	public CategoryBoard(int cbNo, int caNo, int cNo, int kbNo, int rcNo, int complain, int views, int scrap,
			String cbImg, int maxCount, int currCount) {
		super();
		this.cbNo = cbNo;
		this.caNo = caNo;
		this.cNo = cNo;
		this.kbNo = kbNo;
		this.rcNo = rcNo;
		this.complain = complain;
		this.views = views;
		this.scrap = scrap;
		this.cbImg = cbImg;
		this.maxCount = maxCount;
		this.currCount = currCount;
	}
	
	
	@Override
	public String toString() {
		return "CatagoryBoard [cbNo=" + cbNo + ", caNo=" + caNo + ", cNo=" + cNo + ", kbNo=" + kbNo + ", rcNo=" + rcNo
				+ ", complain=" + complain + ", views=" + views + ", scrap=" + scrap + ", cbImg=" + cbImg
				+ ", maxCount=" + maxCount + ", currCount=" + currCount + "]";
	}

	public int getCbNo() {
		return cbNo;
	}
	public void setCbNo(int cbNo) {
		this.cbNo = cbNo;
	}
	public int getCaNo() {
		return caNo;
	}
	public void setCaNo(int caNo) {
		this.caNo = caNo;
	}
	public int getcNo() {
		return cNo;
	}
	public void setcNo(int cNo) {
		this.cNo = cNo;
	}
	public int getKbNo() {
		return kbNo;
	}
	public void setKbNo(int kbNo) {
		this.kbNo = kbNo;
	}
	public int getRcNo() {
		return rcNo;
	}
	public void setRcNo(int rcNo) {
		this.rcNo = rcNo;
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
	public String getCbImg() {
		return cbImg;
	}
	public void setCbImg(String cbImg) {
		this.cbImg = cbImg;
	}
	public int getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	public int getCurrCount() {
		return currCount;
	}
	public void setCurrCount(int currCount) {
		this.currCount = currCount;
	}
	
	
	

}
