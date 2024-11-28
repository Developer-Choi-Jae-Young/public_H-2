package com.h2.chuizone.common.board.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.category.model.dto.SelectCategoryBoardListDto;
import com.h2.chuizone.common.board.model.dao.BoardDao;
import com.h2.chuizone.common.board.model.vo.Board;
import com.h2.chuizone.template.MybatisTemplate;

public class BoardServiceImpl implements BoardService{
	private BoardDao boardDao = new BoardDao();
	
	@Override
	public int insertBoard(Board board) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = boardDao.insertBoard(sqlSession, board);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public List<SelectCategoryBoardListDto> selectCategoryBoardList(int startNum, int endNum, int categoryNo, String keyword) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		return boardDao.selectCategoryBoardList(sqlSession, startNum, endNum, categoryNo, keyword);
	}

	@Override
	public SelectCategoryBoardListDto selectCategoryBoard(int boardId) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		return boardDao.selectCategoryBoard(sqlSession, boardId);
	}

	@Override
	public int deleteCategoryBoard(int boardNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = boardDao.deleteCategoryBoard(sqlSession, boardNo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public int updateBoard(int boardNo, String content, String title) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = boardDao.updateBoard(sqlSession, boardNo, content, title);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}
}
