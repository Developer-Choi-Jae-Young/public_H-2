package com.h2.chuizone.common.review.model.vo;

public class Review {
	private int reviewNo;
	private int kindOfBoardNo;
	private int recommandNo;
	private int startNo;
	private int boardNo;
	
	public Review(int reviewNo, int kindOfBoardNo, int recommandNo, int startNo, int boardNo) {
		this.reviewNo = reviewNo;
		this.kindOfBoardNo = kindOfBoardNo;
		this.recommandNo = recommandNo;
		this.startNo = startNo;
		this.boardNo = boardNo;
	}

	public Review() {
		super();
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getKindOfBoardNo() {
		return kindOfBoardNo;
	}

	public void setKindOfBoardNo(int kindOfBoardNo) {
		this.kindOfBoardNo = kindOfBoardNo;
	}

	public int getRecommandNo() {
		return recommandNo;
	}

	public void setRecommandNo(int recommandNo) {
		this.recommandNo = recommandNo;
	}

	public int getStartNo() {
		return startNo;
	}

	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", kindOfBoardNo=" + kindOfBoardNo + ", recommandNo=" + recommandNo
				+ ", startNo=" + startNo + ", boardNo=" + boardNo + "]";
	}
}
