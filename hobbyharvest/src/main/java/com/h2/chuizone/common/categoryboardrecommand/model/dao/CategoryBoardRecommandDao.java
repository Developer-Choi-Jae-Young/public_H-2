package com.h2.chuizone.common.categoryboardrecommand.model.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.categoryboardrecommand.model.vo.CategoryBoardRecommand;

public class CategoryBoardRecommandDao {

	public int selectCategoryBoardRecommand(SqlSession sqlSession) {
		return sqlSession.selectOne("categoryBoardRecommandMapper.selectCategoryBoardRecommand");
	}

	public int insertCategoryBoardRecommand(SqlSession sqlSession, CategoryBoardRecommand categoryBoardRecommand) {
		return sqlSession.insert("categoryBoardRecommandMapper.insertCategoryBoardRecommand", categoryBoardRecommand);
	}

	public int deleteCategoryBoardRecommand(SqlSession sqlSession, int categoryNo, int memberNo) {
		Map<String, Integer> map = new HashMap<>();
		map.put("categoryNo", categoryNo);
		map.put("memberNo", memberNo);
		
		return sqlSession.delete("categoryBoardRecommandMapper.deleteCategoryBoardRecommand", map);
	}

	public int selectCategoryBoardRecommandByUserNo(SqlSession sqlSession, int categoryNo, int memberNo) {
		Map<String, Integer> map = new HashMap<>();
		map.put("categoryNo", categoryNo);
		map.put("memberNo", memberNo);
		
		return sqlSession.selectOne("categoryBoardRecommandMapper.selectCategoryBoardRecommandByUserNo", map);
	}
	
}
