package com.h2.chuizone.common.reply.model.vo;

import java.sql.Date;

public class Reply {
	private int replyNo;
	private int boardNo;
	private int memberNo;
	private Date replayDate;
	private int replyComplainCount;
	private String replyContent;
	private int parentReplyNo;
	
	public Reply(int replyNo, int boardNo, int memberNo, Date replayDate, int replyComplainCount, String replyContent,
			int parentReplyNo) {
		this.replyNo = replyNo;
		this.boardNo = boardNo;
		this.memberNo = memberNo;
		this.replayDate = replayDate;
		this.replyComplainCount = replyComplainCount;
		this.replyContent = replyContent;
		this.parentReplyNo = parentReplyNo;
	}

	public Reply() {
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
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

	public Date getReplayDate() {
		return replayDate;
	}

	public void setReplayDate(Date replayDate) {
		this.replayDate = replayDate;
	}

	public int getReplyComplainCount() {
		return replyComplainCount;
	}

	public void setReplyComplainCount(int replyComplainCount) {
		this.replyComplainCount = replyComplainCount;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public int getParentReplyNo() {
		return parentReplyNo;
	}

	public void setParentReplyNo(int parentReplyNo) {
		this.parentReplyNo = parentReplyNo;
	}

	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", boardNo=" + boardNo + ", memberNo=" + memberNo + ", replayDate="
				+ replayDate + ", replyComplainCount=" + replyComplainCount + ", replyContent=" + replyContent
				+ ", parentReplyNo=" + parentReplyNo + "]";
	}
}
