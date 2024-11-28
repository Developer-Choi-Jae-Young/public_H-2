package com.h2.chuizone.common.smallgroup.model.service;

import java.util.List;

import com.h2.chuizone.common.smallgroup.model.vo.SmallGroup;

public interface SmallGroupService {
	/**
	 * 소분류 테이블에 데이터를 조회하는 쿼리문
	 * @return 소분류 테이블의 데이터를 리스트 형태의 클래스로 반환
	 */
	List<SmallGroup> selectSmallGroupList();
	
	/**
	 * 소분류 테이블에서 소분류 이름에 맞는 데이터를 조회하는 쿼리문
	 * @param smallGroupName 소분류 이름
	 * @return 소분류 클래스 반환
	 */
	SmallGroup selectSmallGroup(String smallGroupName);
}
