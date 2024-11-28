package com.h2.chuizone.common.category.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.category.model.vo.Category;

public class CategoryDao {
	public List<Category> selectCategoryList(SqlSession sqlSession) {
		return sqlSession.selectList("categoryMapper.selectCategoryList");
	}
	
	public Category selectCategory(SqlSession sqlSession, String categoryName) {
		return sqlSession.selectOne("categoryMapper.selectCategory", categoryName);
	}
}
