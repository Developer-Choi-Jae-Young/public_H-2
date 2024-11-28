package com.h2.chuizone.common.calendercategoryboard.model.service;

import com.h2.chuizone.common.calendercategoryboard.model.vo.CalenderCategoryBoard;

public interface CalenderCategoryBoardService {
	/**
	 * 캘린더-카테고리 게시글 테이블에 데이터를 삽입하기 위한 쿼리문
	 * @param calenderCategoryBoard 캘린더-카테고리 데이터 클래스
	 * @return 성공 유무
	 */
	int insertCalenderCategoryBoard(CalenderCategoryBoard calenderCategoryBoard);
}
