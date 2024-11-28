package com.h2.chuizone.common.kindofboard.model.service;

import java.util.List;

import com.h2.chuizone.common.kindofboard.model.vo.KindOfBoard;

public interface KindOfBoardService {
	/**
	 * 게시글 종류 테이블에 데이터를 조회하는 쿼리문
	 * @return 게시글 종류 테이블에서 데이터를 조회하여 리스트 형태의 클래스로 반환
	 */
	List<KindOfBoard> selectKindOfBoardList();
}
