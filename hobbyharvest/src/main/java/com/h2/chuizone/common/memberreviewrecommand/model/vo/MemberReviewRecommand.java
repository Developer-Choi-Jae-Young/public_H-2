package com.h2.chuizone.common.memberreviewrecommand.model.vo;

public class MemberReviewRecommand {
	private int memberReviewRecommand;
	private int reivewNo;
	private int memberNo;
	
	public MemberReviewRecommand(int memberReviewRecommand, int reivewNo, int memberNo) {
		this.memberReviewRecommand = memberReviewRecommand;
		this.reivewNo = reivewNo;
		this.memberNo = memberNo;
	}

	public MemberReviewRecommand() {
	}

	public int getMemberReviewRecommand() {
		return memberReviewRecommand;
	}

	public void setMemberReviewRecommand(int memberReviewRecommand) {
		this.memberReviewRecommand = memberReviewRecommand;
	}

	public int getReivewNo() {
		return reivewNo;
	}

	public void setReivewNo(int reivewNo) {
		this.reivewNo = reivewNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "MemberReviewRecommand [memberReviewRecommand=" + memberReviewRecommand + ", reivewNo=" + reivewNo
				+ ", memberNo=" + memberNo + "]";
	}
}
