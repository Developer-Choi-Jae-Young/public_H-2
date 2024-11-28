package com.h2.chuizone.common.kindofboard.model.vo;

public class KindOfBoard {
	private int kindOfBoardNo;
	private String kindOfBoardName;
	
	public KindOfBoard(int kindOfBoardNo, String kindOfBoardName) {
		this.kindOfBoardNo = kindOfBoardNo;
		this.kindOfBoardName = kindOfBoardName;
	}
	
	public KindOfBoard() {
	}

	public int getKindOfBoardNo() {
		return kindOfBoardNo;
	}

	public void setKindOfBoardNo(int kindOfBoardNo) {
		this.kindOfBoardNo = kindOfBoardNo;
	}

	public String getKindOfBoardName() {
		return kindOfBoardName;
	}

	public void setKindOfBoardName(String kindOfBoardName) {
		this.kindOfBoardName = kindOfBoardName;
	}

	@Override
	public String toString() {
		return "KindOfBoard [kindOfBoardNo=" + kindOfBoardNo + ", kindOfBoardName=" + kindOfBoardName + "]";
	}	
}
