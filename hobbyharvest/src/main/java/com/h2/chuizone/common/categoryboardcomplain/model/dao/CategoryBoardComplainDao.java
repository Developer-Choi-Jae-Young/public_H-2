package com.h2.chuizone.common.categoryboardcomplain.model.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.categoryboardcomplain.model.vo.CategoryBoardComplain;

public class CategoryBoardComplainDao {

	public int selectCategoryBoardComplain(SqlSession sqlSession) {
		return sqlSession.selectOne("categoryBoardComplainMapper.selectCategoryBoardComplain");
	}

	public int insertCategoryBoardComplain(SqlSession sqlSession, CategoryBoardComplain categoryBoardRecommand) {
		return sqlSession.insert("categoryBoardComplainMapper.insertCategoryBoardComplain", categoryBoardRecommand);
	}

	public int deleteCategoryBoardComplain(SqlSession sqlSession, int categoryNo, int memberNo) {
		Map<String, Integer> map = new HashMap<>();
		map.put("categoryNo", categoryNo);
		map.put("memberNo", memberNo);
		
		return sqlSession.delete("categoryBoardComplainMapper.deleteCategoryBoardComplain", map);
	}

	public int selectCategoryBoardComplainByUserNo(SqlSession sqlSession, int categoryNo, int memberNo) {
		Map<String, Integer> map = new HashMap<>();
		map.put("categoryNo", categoryNo);
		map.put("memberNo", memberNo);
		
		return sqlSession.selectOne("categoryBoardComplainMapper.selectCategoryBoardComplainByUserNo", map);
	}

}
