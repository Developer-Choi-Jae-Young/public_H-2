package com.h2.chuizone.common.boardcategoryboard.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.boardcategoryboard.model.vo.BoardCategoryBoard;

public class BoardCategoryBoardDao {
	public int insertBoardCategoryBoard(SqlSession sqlSession, BoardCategoryBoard boardCategoryBoard) {
		return sqlSession.insert("boardCategoryBoardMapper.insertBoardCategoryBoard", boardCategoryBoard);
	}
}
