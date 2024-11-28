package com.h2.chuizone.common.bookcategory.model.vo;

public class BookCategory {
	private int bookCategoryNo;
	private int memberNo;
	private int categoryNo;
	
	public BookCategory(int bookCategoryNo, int memberNo, int categoryNo) {
		this.bookCategoryNo = bookCategoryNo;
		this.memberNo = memberNo;
		this.categoryNo = categoryNo;
	}

	public BookCategory() {
	}

	public int getBookCategoryNo() {
		return bookCategoryNo;
	}

	public void setBookCategoryNo(int bookCategoryNo) {
		this.bookCategoryNo = bookCategoryNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	@Override
	public String toString() {
		return "BookCategory [bookCategoryNo=" + bookCategoryNo + ", MemberNo=" + memberNo + ", categoryNo="
				+ categoryNo + "]";
	}
}
