package com.h2.chuizone.calender.model.service;

import java.sql.Date;
import java.util.List;

import com.h2.chuizone.calender.model.dto.CalenderDto;
import com.h2.chuizone.calender.model.vo.Calender;

public interface CalenderService {
	/**
	 * 캘린더 테이블에 데이터 삽입을 위한 쿼리문
	 * @param calender 데이터 삽일에 사용할 캘린더 클래스
	 * @return 성공 유무
	 */
	int insertCalender(Calender calender);
	
	/**
	 * 작성한 캘린더 보드를 조회하는 쿼리문
	 * @param 조회할 카테고리 보드 번호
	 * @return 리스트 형태의 캘린더 보드 DTO 클래스
	 */
	List<CalenderDto> selectCalenderBoardList(int categoryBoardNo);
	
	/**
	 * 작성한 캘린더 보드를 보드 번호로 조회하는 쿼리문
	 * @param boardNo 조회할 보드 번호
	 * @return 캘린더 보드 DTO 클래스
	 */
	CalenderDto selectCalenderBoardListByBoardNo(int boardNo);
	
	/**
	 * 캘린더 테이블의 데이터 수정을 위한 쿼리문
	 * @param calenderNo 수정할 캘린더 번호
	 * @param startDate 수정할 시작 날짜
	 * @param endDate 수정할 종료 날짜
	 * @return 성공 여부
	 */
	int updateCalender(int calenderNo, Date startDate, Date endDate);
}
