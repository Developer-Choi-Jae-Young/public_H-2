package com.h2.chuizone.mypage.model.vo;

public class MySocial {
	private String title;
	private String description;
	private String boardNo;
	private String img;
	
	public MySocial() {}
	
	public MySocial(String title, String description, String boardNo, String img) {
		super();
		this.title = title;
		this.description = description;
		this.boardNo = boardNo;
		this.img = img;
	}


	@Override
	public String toString() {
		return "MySocialList [title=" + title + ", description=" + description + ", boardNo=" + boardNo + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	
	
	
	
}

