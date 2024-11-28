package com.h2.chuizone.common.categoryboardrecommand.model.service;

import com.h2.chuizone.common.categoryboardrecommand.model.vo.CategoryBoardRecommand;

public interface CategoryBoardRecommandService {
	/**
	 * 카테고리 보드 - 추천 테이블의 데이터 갯수 조회하는 쿼리문
	 * @return 카테고리 보드 - 추천 테이블의 데이터 갯수
	 */
	int selectCategoryBoardRecommand();
	
	/**
	 * 카테고리 보드 - 추천 테이블에서 카테고리 번호와 회원 번호에 맞는 데이터 갯수를 조회하는 쿼리문
	 * @param categoryNo 카테고리 번호
	 * @param memberNo 회원 번호
	 * @return 카테고리 보드 - 추천 테이블에서 카테고리 번호와 회원 번호에 맞는 데이터 갯수
	 */
	int selectCategoryBoardRecommandByUserNo(int categoryNo, int memberNo);
	
	/**
	 * 카테고리 보드 - 추천 테이블에 데이터를 삽입하는 쿼리문
	 * @param categoryBoardRecommand 카테고리 보드 - 추천 테이블에 데이터를 삽입하기 위한 클래스
	 * @return 성공 여부
	 */
	int insertCategoryBoardRecommand(CategoryBoardRecommand categoryBoardRecommand);
	
	/**
	 * 카테고리 보드 - 추천 테이블에서 카테고리 번호와 회원 번호에 맞는 데이터를 삭제하는 쿼리문
	 * @param categoryNo 카테고리 번호
	 * @param memberNo 회원 번호
	 * @return 성공 여부
	 */
	int deleteCategoryBoardRecommand(int categoryNo, int memberNo);
}
