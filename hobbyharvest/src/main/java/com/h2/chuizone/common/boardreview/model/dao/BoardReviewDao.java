package com.h2.chuizone.common.boardreview.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.boardreview.model.vo.BoardReview;

public class BoardReviewDao {
	public int insertBoardReview(SqlSession sqlSession, BoardReview boardReview) {
		return sqlSession.insert("boardReviewMapper.insertBoardReview", boardReview);
	}
}
