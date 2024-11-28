package com.h2.chuizone.common.reply.model.dto;

import java.sql.Date;

public class ReplyDto {
	private int replyNo;
	private int boardNo;
	private String memberName;
	private Date replayDate;
	private int replyComplainCount;
	private String replyContent;
	private int parentReplyNo;
	private int depts;
	private String status;
	
	public ReplyDto(int replyNo, int boardNo, String memberName, Date replayDate, int replyComplainCount,
			String replyContent, int parentReplyNo, int depts, String status) {
		this.replyNo = replyNo;
		this.boardNo = boardNo;
		this.memberName = memberName;
		this.replayDate = replayDate;
		this.replyComplainCount = replyComplainCount;
		this.replyContent = replyContent;
		this.parentReplyNo = parentReplyNo;
		this.depts = depts;
		this.status = status;
	}

	public ReplyDto() {
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

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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

	public int getDepts() {
		return depts;
	}

	public void setDepts(int depts) {
		this.depts = depts;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ReplyDto [replyNo=" + replyNo + ", boardNo=" + boardNo + ", memberName=" + memberName + ", replayDate="
				+ replayDate + ", replyComplainCount=" + replyComplainCount + ", replyContent=" + replyContent
				+ ", parentReplyNo=" + parentReplyNo + ", depts=" + depts + ", status=" + status + "]";
	}
}
