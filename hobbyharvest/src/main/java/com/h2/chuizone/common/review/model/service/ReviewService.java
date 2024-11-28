package com.h2.chuizone.common.review.model.service;

import java.util.List;

import com.h2.chuizone.common.review.model.dto.ReviewDto;
import com.h2.chuizone.common.review.model.vo.Review;

public interface ReviewService {
	/**
	 * 리뷰 테이블에서 게시글 번호에 맞는 데이터 조회하는 쿼리문
	 * @param boardNo 게시글 번호
	 * @return 게시글 번호에 맞는 리스트 형태의 리뷰 DTO 클래스
	 */
	List<ReviewDto> selectReviewList(int boardNo);
	
	/**
	 * 리뷰 테이블에 데이터 삽입을 하기 위한 쿼리문
	 * @param review 데이터 삽입을 위한 리뷰 클래스
	 * @return 성공 유무
	 */
	int insertReview(Review review);
	
	/**
	 * 리뷰 테이블에서 추천수를 수정하기 위한 쿼리문
	 * @param recommandNo 수정할 추천 수
	 * @param reviewNo 리뷰 번호
	 * @return 성공 유무
	 */
	int updateReview(int recommandNo, int reviewNo);
	
	/**
	 * 리뷰 테이블에서 리뷰 번호와 맞는 추천수를 조회하는 쿼리문
	 * @param reviewNo 리뷰 번호
	 * @return 리뷰 번호에 맞는 추천수
	 */
	int selectReviewByRecommand(int reviewNo);
}
