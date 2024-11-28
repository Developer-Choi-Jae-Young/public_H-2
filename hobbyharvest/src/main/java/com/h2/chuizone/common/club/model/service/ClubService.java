package com.h2.chuizone.common.club.model.service;

import java.util.List;

import com.h2.chuizone.common.club.model.vo.Club;

public interface ClubService {
	/**
	 * 클럽 테이블에 데이터 삽입하는 쿼리문
	 * @param club 클럽 테이블에 데이터를 삽입하기 위한 클래스
	 * @return 성공 여부
	 */
	int insertClub(Club club);
	
	/**
	 * 클럽 테이블에 데이터 조회하는 쿼리문
	 * @return 클럽 테이블의 데이터를 리스트 형태의 클래스로 반환
	 */
	List<Club> selectClub();
	
	/**
	 * 클럽 테이블에서 클럽 번호와 맞는 클럽의 이름을 조회하는 쿼리문
	 * @param clubId 클럽 번호
	 * @return 클럽 이름
	 */
	String selectClubName(int clubId);
	
	/**
	 * 클럽 테이블에 클럽 번호와 클럽 이름에 맞는 데이터를 수정하는 쿼리문
	 * @param clubNo 클럽 번호
	 * @param clubName 클럽 이름
	 * @return 성공 여부
	 */
	int updateClub(int clubNo, String clubName);
}
