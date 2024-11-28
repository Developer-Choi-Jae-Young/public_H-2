package com.h2.chuizone.common.memberreviewrecommand.model.service;

import com.h2.chuizone.common.memberreviewrecommand.model.vo.MemberReviewRecommand;

public interface MemberReviewRecommandService {
	/**
	 * 회원 - 리뷰추천 테이블에서 리뷰 번호와 회원 번호에 맞는 데이터의 갯수를 조회하는 쿼리문
	 * @param reviewNo 리뷰 번호
	 * @param memberNo 회원 번호
	 * @return 회원 - 리뷰추천 테이블에서 리뷰 번호와 회원 번호에 맞는 데이터의 갯수
	 */
	int selectMemberReviewRecommand(int reviewNo, int memberNo);
	
	/**
	 * 회원 - 리뷰추천 테이블에 데이터 삽입하는 쿼리문
	 * @param memberReviewRecommand 회원 - 리뷰추천 테이블에 데이터 삽입하기 위한 클래스
	 * @return 성공 유무
	 */
	int insertMemberReviewRecommand(MemberReviewRecommand memberReviewRecommand);
	
	/**
	 * 회원 - 리뷰추천 테이블에 데이터 삭제하는 쿼리문
	 * @param reviewNo 리뷰 번호
	 * @param memberNo 회원 번호
	 * @return 성공 유무
	 */
	int deleteMemberReviewRecommand(int reviewNo, int memberNo);
}
