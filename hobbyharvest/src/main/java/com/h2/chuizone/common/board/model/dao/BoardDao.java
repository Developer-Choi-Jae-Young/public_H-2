package com.h2.chuizone.common.board.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.category.model.dto.SelectCategoryBoardListDto;
import com.h2.chuizone.common.board.model.vo.Board;

public class BoardDao {
	public int insertBoard(SqlSession sqlSession, Board board) {
		return sqlSession.insert("boardMapper.insertBoard", board);
	}
	
	public List<SelectCategoryBoardListDto> selectCategoryBoardList(SqlSession sqlSession, int startNum, int endNum, int categoryNo, String keyword) {
		Map<String, Object> map = new HashMap<>();
		
		if(keyword.isEmpty()) {
			map.put("startNum", startNum);
			map.put("endNum", endNum);
			map.put("categoryNo", categoryNo);
			
			return sqlSession.selectList("boardMapper.selectCategoryBoardList", map);
		} else {
			map.put("startNum", startNum);
			map.put("endNum", endNum);
			map.put("categoryNo", categoryNo);
			map.put("keyword", keyword);
			
			return sqlSession.selectList("boardMapper.selectCategoryBoardListKeyword", map);
		}
	}
	
	public SelectCategoryBoardListDto selectCategoryBoard(SqlSession sqlSession, int boardId) {
		return sqlSession.selectOne("boardMapper.selectCategoryBoard", boardId);
	}
	
	public int deleteCategoryBoard(SqlSession sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.deleteCategoryBoard", boardNo);
	}

	public int updateBoard(SqlSession sqlSession, int boardNo, String content, String title) {
		Map<String, Object> map = new HashMap<>();
		map.put("boardNo", boardNo);
		map.put("content", content);
		map.put("title", title);
		
		return sqlSession.update("boardMapper.updateBoard", map);
	}
}
