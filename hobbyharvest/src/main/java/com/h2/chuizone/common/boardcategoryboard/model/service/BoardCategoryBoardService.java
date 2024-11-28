package com.h2.chuizone.common.boardcategoryboard.model.service;

import com.h2.chuizone.common.boardcategoryboard.model.vo.BoardCategoryBoard;

public interface BoardCategoryBoardService {
	/**
	 * 보드-카테고리 보드 테이블의 삽입을 위한 쿼리문
	 * @param boardCategoryBoard 삽입을 위한 보드 카테고리 보드의 데이터
	 * @return 성공 여부
	 */
	int insertBoardCategoryBoard(BoardCategoryBoard boardCategoryBoard);
}
