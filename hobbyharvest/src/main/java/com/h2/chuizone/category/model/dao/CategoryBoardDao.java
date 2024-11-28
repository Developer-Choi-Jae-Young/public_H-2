package com.h2.chuizone.category.model.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.category.model.vo.CategoryBoard;

public class CategoryBoardDao {
	public int selectMaxPageNumber(SqlSession sqlSession, int categoryNo, String keyword) {
		Map<String, Object> map = new HashMap<>();
		
		if(keyword.isEmpty()) {
			map.put("categoryNo", categoryNo);
			
			return sqlSession.selectOne("categoryBoardMapper.selectMaxPageNumber", map);
		} else {
			map.put("categoryNo", categoryNo);
			map.put("keyword", keyword);
			
			return sqlSession.selectOne("categoryBoardMapper.selectMaxPageNumberKeyword", map);
		}
	}
	
	public int insertCategoryBoard(SqlSession sqlSession, CategoryBoard categoryBoard) {
		return sqlSession.insert("categoryBoardMapper.insertCategoryBoard", categoryBoard);
	}
	
	public int updateCategoryBoardByCurCount(SqlSession sqlSession, int currentHeadCnt, int boardNo) {
		Map<String, Integer> map = new HashMap<>();
		map.put("currentHeadCnt", currentHeadCnt);
		map.put("boardNo", boardNo);
		
		return sqlSession.update("categoryBoardMapper.updateCategoryBoardByCurCount", map);
	}
	
	public int updateCategoryBoardByView(SqlSession sqlSession, int viewCnt, int boardNo) {
		Map<String, Integer> map = new HashMap<>();
		map.put("viewCnt", viewCnt);
		map.put("boardNo", boardNo);
		
		return sqlSession.update("categoryBoardMapper.updateCategoryBoardByView", map);
	}

	public int updateCategoryBoardByRecommandPlus(SqlSession sqlSession, int categoryNo) {
		return sqlSession.update("categoryBoardMapper.updateCategoryBoardByRecommandPlus", categoryNo);
	}

	public int updateCategoryBoardByRecommandMinus(SqlSession sqlSession, int categoryNo) {
		return sqlSession.update("categoryBoardMapper.updateCategoryBoardByRecommandMinus", categoryNo);
	}

	public int updateCategoryBoardByComplainPlus(SqlSession sqlSession, int categoryNo) {
		return sqlSession.update("categoryBoardMapper.updateCategoryBoardByComplainPlus", categoryNo);
	}

	public int updateCategoryBoardByComplainMinus(SqlSession sqlSession, int categoryNo) {
		return sqlSession.update("categoryBoardMapper.updateCategoryBoardByComplainMinus", categoryNo);
	}

	public int updateCategoryBoard(SqlSession sqlSession, int categoryBoardNo, int smallGroupCategoryNo,
			String categoryImage, int maxCount) {
		Map<String, Object> map = new HashMap<>();
		map.put("categoryBoardNo", categoryBoardNo);
		map.put("smallGroupCategoryNo", smallGroupCategoryNo);
		map.put("categoryImage", categoryImage);
		map.put("maxCount", maxCount);

		return sqlSession.update("categoryBoardMapper.updateCategoryBoard", map);
	}
}
