package com.h2.chuizone.common.bookcategory.model.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.bookcategory.model.vo.BookCategory;

public class BookCategoryDao {

	public int selectBookCategory(SqlSession sqlSession) {
		return sqlSession.selectOne("bookCategoryMapper.selectBookCategory");
	}

	public int insertBookCategory(SqlSession sqlSession, BookCategory bookCategory) {
		return sqlSession.insert("bookCategoryMapper.insertBookCategory", bookCategory);
	}

	public int deleteBookCategory(SqlSession sqlSession, int categoryNo, int memberNo) {
		Map<String, Integer> map = new HashMap<>();
		map.put("categoryNo", categoryNo);
		map.put("memberNo", memberNo);
		
		return sqlSession.delete("bookCategoryMapper.deleteBookCategory", map);
	}

	public int selectBookCategoryByUserNo(SqlSession sqlSession, int categoryNo, int memberNo) {
		Map<String, Integer> map = new HashMap<>();
		map.put("categoryNo", categoryNo);
		map.put("memberNo", memberNo);
		
		return sqlSession.selectOne("bookCategoryMapper.selectBookCategoryByUserNo", map);
	}

}
