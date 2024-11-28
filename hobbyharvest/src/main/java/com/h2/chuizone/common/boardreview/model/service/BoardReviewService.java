package com.h2.chuizone.common.boardreview.model.service;

import com.h2.chuizone.common.boardreview.model.vo.BoardReview;

public interface BoardReviewService {
	/**
	 * 리뷰 테이블에 데이터 삽입을 위한 쿼리문
	 * @param boardReview 리뷰 테이블 삽입을 위한 클래스
	 * @return 성공 여부
	 */
	int insertBoardReview(BoardReview boardReview);
}
