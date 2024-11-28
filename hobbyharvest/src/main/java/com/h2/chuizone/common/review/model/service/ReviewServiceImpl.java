package com.h2.chuizone.common.review.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.review.model.dao.ReviewDao;
import com.h2.chuizone.common.review.model.dto.ReviewDto;
import com.h2.chuizone.common.review.model.vo.Review;
import com.h2.chuizone.template.MybatisTemplate;

public class ReviewServiceImpl implements ReviewService{
	private ReviewDao reviewDao = new ReviewDao();
	
	@Override
	public List<ReviewDto> selectReviewList(int boardNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		return reviewDao.selectReviewList(sqlSession, boardNo);
	}

	@Override
	public int insertReview(Review review) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = reviewDao.insertReview(sqlSession, review);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public int updateReview(int recommandNo, int reviewNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = reviewDao.updateReview(sqlSession, recommandNo, reviewNo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public int selectReviewByRecommand(int reviewNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		return reviewDao.selectReviewByRecommand(sqlSession, reviewNo);
	}
}
