package com.h2.chuizone.common;

public class Pageing {
	private int boarderNum = 10;
	private final int maxPageingNum = 5;
	
	private int maxBoardNum;
	private int maxPage;

	private int currentPage;	
	private int stPageingNum;
	private int endPageingNum;
	
	public Pageing() {}
	
	public Pageing(int maxBoardNum, int currentPage) {
		this.maxBoardNum = maxBoardNum;
		this.currentPage = currentPage;
		
		stPageingNum = maxPageingNum * ((currentPage - 1)/maxPageingNum) + 1;
		endPageingNum = (int)Math.ceil(((double)currentPage/maxPageingNum))*maxPageingNum;
		maxPage = (int)Math.ceil(((double)maxBoardNum / boarderNum));
		
		maxPage = maxPage == 0 ? 1 : maxPage;
		endPageingNum = maxPage < endPageingNum ? maxPage : endPageingNum;
	}

	public int getMaxBoardNum() {
		return maxBoardNum;
	}

	public void setMaxBoardNum(int maxBoardNum) {
		this.maxBoardNum = maxBoardNum;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getStPageingNum() {
		return stPageingNum;
	}

	public void setStPageingNum(int stPageingNum) {
		this.stPageingNum = stPageingNum;
	}

	public int getEndPageingNum() {
		return endPageingNum;
	}

	public void setEndPageingNum(int endPageingNum) {
		this.endPageingNum = endPageingNum;
	}

	public int getBoarderNum() {
		return boarderNum;
	}
	
	public void setBoarderNum(int boarderNum) {
		this.boarderNum = boarderNum;
	}

	public int getMaxPageingNum() {
		return maxPageingNum;
	}

	@Override
	public String toString() {
		return "Pageing [borderNum=" + boarderNum + ", maxPageingNum=" + maxPageingNum + ", maxBoardNum=" + maxBoardNum
				+ ", maxPage=" + maxPage + ", currentPage=" + currentPage + ", stPageingNum=" + stPageingNum
				+ ", endPageingNum=" + endPageingNum + "]";
	}
}
