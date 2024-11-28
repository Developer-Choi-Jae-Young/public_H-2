package com.h2.chuizone.common.categoryboardrecommand.model.service;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.categoryboardrecommand.model.dao.CategoryBoardRecommandDao;
import com.h2.chuizone.common.categoryboardrecommand.model.vo.CategoryBoardRecommand;
import com.h2.chuizone.template.MybatisTemplate;

public class CategoryBoardRecommandServiceImpl implements CategoryBoardRecommandService{
	private CategoryBoardRecommandDao categoryBoardRecommandDao = new CategoryBoardRecommandDao();
	
	@Override
	public int selectCategoryBoardRecommand() {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		return categoryBoardRecommandDao.selectCategoryBoardRecommand(sqlSession);
	}

	@Override
	public int insertCategoryBoardRecommand(CategoryBoardRecommand categoryBoardRecommand) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = categoryBoardRecommandDao.insertCategoryBoardRecommand(sqlSession, categoryBoardRecommand);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public int deleteCategoryBoardRecommand(int categoryNo, int memberNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = categoryBoardRecommandDao.deleteCategoryBoardRecommand(sqlSession, categoryNo, memberNo);

		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public int selectCategoryBoardRecommandByUserNo(int categoryNo, int memberNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		return categoryBoardRecommandDao.selectCategoryBoardRecommandByUserNo(sqlSession, categoryNo, memberNo);
	}
}
