package com.h2.chuizone.common.memberclub.model.vo;

public class MemberClub {
	private int memberClubNo;
	private int memberNo;
	private int clubNo;
	
	public MemberClub(int memberClubNo, int memberNo, int clubNo) {
		this.memberClubNo = memberClubNo;
		this.memberNo = memberNo;
		this.clubNo = clubNo;
	}

	public MemberClub() {
	}

	public int getMemberClubNo() {
		return memberClubNo;
	}

	public void setMemberClubNo(int memberClubNo) {
		this.memberClubNo = memberClubNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getClubNo() {
		return clubNo;
	}

	public void setClubNo(int clubNo) {
		this.clubNo = clubNo;
	}

	@Override
	public String toString() {
		return "MemberClub [memberClubNo=" + memberClubNo + ", memberNo=" + memberNo + ", clubNo=" + clubNo + "]";
	}
}
