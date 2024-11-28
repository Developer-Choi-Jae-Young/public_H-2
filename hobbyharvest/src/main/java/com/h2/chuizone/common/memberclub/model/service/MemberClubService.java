package com.h2.chuizone.common.memberclub.model.service;

import java.util.List;

import com.h2.chuizone.common.memberclub.model.vo.MemberClub;

public interface MemberClubService {
	/**
	 * 회원 - 클럽 테이블에서 회원 번호에 맞는 클럽 번호 리스트를 조회하는 쿼리문
	 * @param memberId 회원 번호
	 * @return 클럽 테이블에서 회원 번호에 맞는 클럽 번호를 리스트 형태의 클래스로 반환
	 */
	List<Integer> selectJoinClub(int memberId);
	
	/**
	 *  회원 - 클럽 테이블에 데이터 삽입 하는 쿼리문
	 * @param memberClub 회원 - 클럽 테이블에 데이터를 삽입하기 위한 클래스
	 * @return 성공 유무
	 */
	int insertJoinClub(MemberClub memberClub);
	
	/**
	 * 회원 - 클럽 테이블에 데이터 삭제 하는 쿼리문
	 * @param memberClub 삭제 하기 위해 비교하는 클래스
	 * @return 성공 유무
	 */
	int deleteJoinClub(MemberClub memberClub);
}
