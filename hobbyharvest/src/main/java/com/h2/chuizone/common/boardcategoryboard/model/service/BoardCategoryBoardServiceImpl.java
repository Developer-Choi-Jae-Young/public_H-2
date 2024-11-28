package com.h2.chuizone.common.boardcategoryboard.model.service;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.boardcategoryboard.model.dao.BoardCategoryBoardDao;
import com.h2.chuizone.common.boardcategoryboard.model.vo.BoardCategoryBoard;
import com.h2.chuizone.template.MybatisTemplate;

public class BoardCategoryBoardServiceImpl implements BoardCategoryBoardService {
	public BoardCategoryBoardDao boardCategoryBoardDao = new BoardCategoryBoardDao();
	
	public int insertBoardCategoryBoard(BoardCategoryBoard boardCategoryBoard) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = boardCategoryBoardDao.insertBoardCategoryBoard(sqlSession, boardCategoryBoard);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}
}
