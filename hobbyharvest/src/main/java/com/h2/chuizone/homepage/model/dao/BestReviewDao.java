package com.h2.chuizone.homepage.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.review.model.vo.Review;

public class BestReviewDao {

	/**
	 * 베스트 리뷰 노출용 DAO 메소드
	 * @param sqlSession SqlSession
	 * @return	TOP 5 리뷰 정보를 담은 Dto 객체
	 */
	public ArrayList<Review> bestReview(SqlSession sqlSession) {
		return (ArrayList)sqlSession.selectList("reviewMapper.bestReview");
	}

}
