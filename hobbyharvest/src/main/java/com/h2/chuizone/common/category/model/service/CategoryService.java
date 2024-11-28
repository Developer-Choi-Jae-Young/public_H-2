package com.h2.chuizone.common.category.model.service;

import java.util.List;

import com.h2.chuizone.common.category.model.vo.Category;

public interface CategoryService {
	/**
	 * 카테고리 테이블에 데이터를 조회하는 쿼리문
	 * @return 카테고리 테이블의 데이터를 조회한 결과 리스트 클래스
	 */
	List<Category> selectCategoryList();
	
	/**
	 * 카테고리 테이블에서 카테고리 이름에 맞는 데이터를 조회하는 쿼리문
	 * @param categoryName 조회할 카테고리 이름
	 * @return 카테고리 테이블의 데이터를 조회한 결과 클래스
	 */
	Category selectCategory(String categoryName);
}
