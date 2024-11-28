package com.h2.chuizone.common.smallgroupcategory.model.service;

import java.util.List;

import com.h2.chuizone.common.smallgroupcategory.model.dto.SelectGroupCategoryDto;
import com.h2.chuizone.common.smallgroupcategory.model.vo.SmallGroupCategory;

public interface SmallGroupCategoryService {
	/**
	 * 소분류-카테고리 테이블에서 데이터를 조회하는 쿼리문
	 * @return 소분류-카테고리 테이블에서 조회한 데이터를 리스트 형태의 클래스로 반환
	 */
	List<SmallGroupCategory> selectSmallGroupCategoryList();
	
	/**
	 * 소분류-카테고리 테이블에서 소분류 번호와 카테고리 번호에 맞는 데이터를 조회하는 쿼리문
	 * @param selectGroupCategoryDto 소분류 번호와 카테고리 번호를 갖고 있는 DTO클래스
	 * @return 조회한 소분류-카테고리 클래스
	 */
	SmallGroupCategory selectSmallGroupCategory(SelectGroupCategoryDto selectGroupCategoryDto);
	
	/**
	 * 소분류-카테고리 테이블에서 소분류-카테고리 번호에 맞는 소분류명을 조회하는 쿼리문
	 * @param smallGroupCategoryNo 소분류-카테고리 번호
	 * @return 소분류명
	 */
	String selectSmallGroupName(int smallGroupCategoryNo);
}
