package com.h2.chuizone.common.review.model.dto;

public class ReviewDto {
	private int reviewNo;
	private String memberName;
	private int recommandNo;
	private int starNo;
	private String title;
	private String content;
	private boolean recommandFlag;
	
	public ReviewDto(int reviewNo, String memberName, int recommandNo, int starNo, String title, String content) {
		this.reviewNo = reviewNo;
		this.memberName = memberName;
		this.recommandNo = recommandNo;
		this.starNo = starNo;
		this.title = title;
		this.content = content;
	}

	public ReviewDto() {
		super();
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getRecommandNo() {
		return recommandNo;
	}

	public void setRecommandNo(int recommandNo) {
		this.recommandNo = recommandNo;
	}

	public int getStarNo() {
		return starNo;
	}

	public void setStarNo(int starNo) {
		this.starNo = starNo;
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
	
	public boolean isRecommandFlag() {
		return recommandFlag;
	}

	public void setRecommandFlag(boolean recommandFlag) {
		this.recommandFlag = recommandFlag;
	}

	@Override
	public String toString() {
		return "[reviewNo=" + reviewNo + ", memberName=" + memberName + ", recommandNo=" + recommandNo
				+ ", starNo=" + starNo + ", title=" + title + ", content=" + content + ", recommandFlag=" + recommandFlag + "]";
	}
}
