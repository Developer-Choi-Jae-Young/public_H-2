package com.h2.chuizone.common.review.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.review.model.dto.ReviewDto;
import com.h2.chuizone.common.review.model.vo.Review;

public class ReviewDao {
	public List<ReviewDto> selectReviewList(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectList("reviewMapper.selectReviewList", boardNo);
	}
	
	public int insertReview(SqlSession sqlSession, Review review) {
		return sqlSession.insert("reviewMapper.insertReview", review);
	}
	
	public int updateReview(SqlSession sqlSession, int recommandNo, int reviewNo) {
		Map<String, Integer> map = new HashMap<>();
		map.put("recommandNo", recommandNo);
		map.put("reviewNo", reviewNo);
		
		return sqlSession.update("reviewMapper.updateReview", map);
	}
	
	public int selectReviewByRecommand(SqlSession sqlSession, int reviewNo) {
		return sqlSession.selectOne("reviewMapper.selectReviewByRecommand", reviewNo);
	}
	
}
