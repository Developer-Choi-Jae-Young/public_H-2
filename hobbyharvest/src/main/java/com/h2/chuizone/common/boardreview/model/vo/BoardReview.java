package com.h2.chuizone.common.boardreview.model.vo;

public class BoardReview {
	private int boardReviewNo;
	private int reviewNo;
	private int boardNo;
	
	public BoardReview(int boardReviewNo, int reviewNo, int boardNo) {
		this.boardReviewNo = boardReviewNo;
		this.reviewNo = reviewNo;
		this.boardNo = boardNo;
	}

	public BoardReview() {
	}

	public int getBoardReviewNo() {
		return boardReviewNo;
	}

	public void setBoardReviewNo(int boardReviewNo) {
		this.boardReviewNo = boardReviewNo;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	@Override
	public String toString() {
		return "BoardReview [boardReviewNo=" + boardReviewNo + ", reviewNo=" + reviewNo + ", boardNo=" + boardNo + "]";
	}
}
