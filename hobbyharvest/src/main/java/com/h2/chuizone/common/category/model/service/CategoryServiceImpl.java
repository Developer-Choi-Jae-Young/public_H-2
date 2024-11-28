package com.h2.chuizone.common.category.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.category.model.dao.CategoryDao;
import com.h2.chuizone.common.category.model.vo.Category;
import com.h2.chuizone.template.MybatisTemplate;

public class CategoryServiceImpl implements CategoryService{
	private CategoryDao categoryDao = new CategoryDao();
	
	@Override
	public List<Category> selectCategoryList() {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		List<Category> result = categoryDao.selectCategoryList(sqlSession);
				
		return result;
	}

	@Override
	public Category selectCategory(String categoryName) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		return categoryDao.selectCategory(sqlSession, categoryName);
	}
}
