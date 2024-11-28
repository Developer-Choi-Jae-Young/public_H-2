package com.h2.chuizone.homepage.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.review.model.vo.Review;
import com.h2.chuizone.homepage.model.dao.BestReviewDao;
import com.h2.chuizone.template.MybatisTemplate;

public class BestReviewService {
	
	BestReviewDao brDao = new BestReviewDao();

	/**
	 * 베스트 리뷰 노출용 서비스 메소드
	 * @return TOP 5 리뷰 정보를 담은 Dto 객체
	 */
	public ArrayList<Review> bestReview() {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		return brDao.bestReview(sqlSession);
	}

}
