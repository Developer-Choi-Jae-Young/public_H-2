package com.h2.chuizone.common.categoryboardcomplain.model.service;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.categoryboardcomplain.model.dao.CategoryBoardComplainDao;
import com.h2.chuizone.common.categoryboardcomplain.model.vo.CategoryBoardComplain;
import com.h2.chuizone.template.MybatisTemplate;

public class CategoryBoardComplainServiceImpl implements CategoryBoardComplainService{
	private CategoryBoardComplainDao categoryBoardComplainDao = new CategoryBoardComplainDao();
	
	@Override
	public int selectCategoryBoardComplain() {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		return categoryBoardComplainDao.selectCategoryBoardComplain(sqlSession);
	}

	@Override
	public int insertCategoryBoardComplain(CategoryBoardComplain categoryBoardRecommand) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = categoryBoardComplainDao.insertCategoryBoardComplain(sqlSession, categoryBoardRecommand);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public int deleteCategoryBoardComplain(int categoryNo, int memberNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = categoryBoardComplainDao.deleteCategoryBoardComplain(sqlSession, categoryNo, memberNo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public int selectCategoryBoardComplainByUserNo(int categoryNo, int memberNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		return categoryBoardComplainDao.selectCategoryBoardComplainByUserNo(sqlSession, categoryNo, memberNo);
	}
}
