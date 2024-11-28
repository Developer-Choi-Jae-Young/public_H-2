package com.h2.chuizone.common.bookcategory.model.service;

import com.h2.chuizone.common.bookcategory.model.vo.BookCategory;

public interface BookCategoryService {
	/**
	 * 북마크 테이블의 데이터의 갯수 를 조회하는 쿼리문
	 * @return 북마크 테이블의 데이터 갯수
	 */
	int selectBookCategory();
	
	/**
	 * 북마크 테이블에서 카테고리 번호와 회원 번호에 맞는 데이터 갯수를 조회하는 쿼리문 
	 * @param categoryNo 카테고리 번호
	 * @param memberNo 회원 번호
	 * @return 북마크 테이블에서 카테고리 번호와 회원 번호에 맞는 데이터 갯수
	 */
	int selectBookCategoryByUserNo(int categoryNo, int memberNo);
	
	/**
	 * 북마크 테이블에 데이터 삽입하는 쿼리문
	 * @param bookCategory 북마크 테이블의 삽일할 데이터 클래스
	 * @return 성공 여부
	 */
	int insertBookCategory(BookCategory bookCategory);
	
	/**
	 * 북마크 테이블에 카테고리 번호와 회원 번호에 맞는 데이터를 삭제하는 쿼리문
	 * @param categoryNo 카테고리 번호
	 * @param memberNo 회원 번호
	 * @return 성공 여부
	 */
	int deleteBookCategory(int categoryNo, int memberNo);
}
