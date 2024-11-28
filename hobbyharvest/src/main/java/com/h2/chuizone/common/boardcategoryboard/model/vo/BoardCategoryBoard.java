package com.h2.chuizone.common.boardcategoryboard.model.vo;

public class BoardCategoryBoard {
	private int boardCategoryBoardNo;
	private int boardNo;
	private int categoryNo;
	
	public BoardCategoryBoard(int boardCategoryBoardNo, int boardNo, int categoryNo) {
		this.boardCategoryBoardNo = boardCategoryBoardNo;
		this.boardNo = boardNo;
		this.categoryNo = categoryNo;
	}

	public BoardCategoryBoard() {
	}

	public int getBoardCategoryBoardNo() {
		return boardCategoryBoardNo;
	}

	public void setBoardCategoryBoardNo(int boardCategoryBoardNo) {
		this.boardCategoryBoardNo = boardCategoryBoardNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	@Override
	public String toString() {
		return "BoardCategoryBoard [boardCategoryBoardNo=" + boardCategoryBoardNo + ", boardNo=" + boardNo
				+ ", categoryNo=" + categoryNo + "]";
	}
}
