package com.h2.chuizone.common.categoryboardcomplain.model.service;

import com.h2.chuizone.common.categoryboardcomplain.model.vo.CategoryBoardComplain;

public interface CategoryBoardComplainService {
	/**
	 * 카테고리-신고 테이블의 데이터 갯수를 조회하는 쿼리문
	 * @return 카테고리-신고 테이블의 데이터 갯수
	 */
	int selectCategoryBoardComplain();
	
	/**
	 * 카테고리-신고 테이블에서 카테고리 번호와 회원 번호에 맞는 데이터를 조회하는 쿼리문
	 * @param categoryNo 카테고리 번호
	 * @param memberNo 회원 번호
	 * @return 카테고리-신고 테이블에서 카테고리 번호와 회원 번호에 맞는 데이터 갯수
	 */
	int selectCategoryBoardComplainByUserNo(int categoryNo, int memberNo);
	
	/**
	 * 카테고리-신고 테이블에 데이터 삽입하는 쿼리문
	 * @param categoryBoardRecommand 카테고리-신고 테이블에 삽입할 카테고리-신고 클래스
	 * @return 성공 여부
	 */
	int insertCategoryBoardComplain(CategoryBoardComplain categoryBoardRecommand);
	
	/**
	 * 카테고리-신고 테이블에서 카테고리 번호와 회원 번호에 맞는 데이터를 삭제하는 쿼리문
	 * @param categoryNo 카테고리 번호
	 * @param memberNo 회원 번호
	 * @return 성공 여부
	 */
	int deleteCategoryBoardComplain(int categoryNo, int memberNo);
}
