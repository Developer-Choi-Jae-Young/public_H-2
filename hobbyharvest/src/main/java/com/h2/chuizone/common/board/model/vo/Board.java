package com.h2.chuizone.common.board.model.vo;

import java.sql.Date;

public class Board {
	private int boardNo;
	private int memberNo;
	private int kindOfBoardNo;
	private String title;
	private Date postDate;
	private String content;
	
	public Board(int boardNo, int memberNo, int kindOfBoardNo, String title, Date postDate, String content) {
		this.boardNo = boardNo;
		this.memberNo = memberNo;
		this.kindOfBoardNo = kindOfBoardNo;
		this.title = title;
		this.postDate = postDate;
		this.content = content;
	}
	
	
	public Board(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}



	public Board() {
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getKindOfBoard() {
		return kindOfBoardNo;
	}

	public void setKindOfBoardNo(int kindOfBoardNo) {
		this.kindOfBoardNo = kindOfBoardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", memberNo=" + memberNo + ", kindOfBoardNo=" + kindOfBoardNo + ", title="
				+ title + ", postDate=" + postDate + ", content=" + content + "]";
	}
}
