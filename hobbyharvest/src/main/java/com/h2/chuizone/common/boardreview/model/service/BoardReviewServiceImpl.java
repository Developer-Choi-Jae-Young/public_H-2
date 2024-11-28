package com.h2.chuizone.common.boardreview.model.service;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.boardreview.model.dao.BoardReviewDao;
import com.h2.chuizone.common.boardreview.model.vo.BoardReview;
import com.h2.chuizone.template.MybatisTemplate;

public class BoardReviewServiceImpl implements BoardReviewService {
	private BoardReviewDao boardReviewDao = new BoardReviewDao();
	
	@Override
	public int insertBoardReview(BoardReview boardReview) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = boardReviewDao.insertBoardReview(sqlSession, boardReview);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}
	
}
