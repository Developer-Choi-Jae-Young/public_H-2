package com.h2.chuizone.common.bookcategory.model.service;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.bookcategory.model.dao.BookCategoryDao;
import com.h2.chuizone.common.bookcategory.model.vo.BookCategory;
import com.h2.chuizone.template.MybatisTemplate;

public class BookCategoryServiceImpl implements BookCategoryService {
	private BookCategoryDao bookCategoryDao = new BookCategoryDao();
	
	@Override
	public int selectBookCategory() {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		return bookCategoryDao.selectBookCategory(sqlSession);
	}

	@Override
	public int insertBookCategory(BookCategory bookCategory) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = bookCategoryDao.insertBookCategory(sqlSession, bookCategory);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public int deleteBookCategory(int categoryNo, int memberNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = bookCategoryDao.deleteBookCategory(sqlSession, categoryNo, memberNo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public int selectBookCategoryByUserNo(int categoryNo, int memberNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		return bookCategoryDao.selectBookCategoryByUserNo(sqlSession, categoryNo, memberNo);
	}

	
}
