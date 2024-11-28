package com.h2.chuizone.common.club.model.vo;

public class Club {
	private int clubNo;
	private String clubName;
	
	public Club(int clubNo, String clubName) {
		this.clubNo = clubNo;
		this.clubName = clubName;
	}

	public Club() {
	}

	public int getClubNo() {
		return clubNo;
	}

	public void setClubNo(int clubNo) {
		this.clubNo = clubNo;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	@Override
	public String toString() {
		return "Club [clubNo=" + clubNo + ", smallGroupName=" + clubName + "]";
	}
}
