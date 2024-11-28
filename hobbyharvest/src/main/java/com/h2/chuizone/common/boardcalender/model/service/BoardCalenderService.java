package com.h2.chuizone.common.boardcalender.model.service;

import com.h2.chuizone.common.boardcalender.model.vo.BoardCalender;

public interface BoardCalenderService {
	/**
	 * 게시글-캘린더 테이블 데이터 삽입을 위한 쿼리문
	 * @param boardCalender 게시글-캘린더 데이터 클래스
	 * @return 성공 유무
	 */
	int insertBoardCalender(BoardCalender boardCalender);
	
	/**
	 * 보드 번호에 맞는 캘린더 번호 조회 쿼리문
	 * @param boardNo 보드 번호
	 * @return 캘린더 번호
	 */
	int selectCalenderNo(int boardNo);
}
