package com.h2.chuizone.common.calendercategoryboard.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.calendercategoryboard.model.vo.CalenderCategoryBoard;

public class CalenderCategoryBoardDao {
	public int insertCalenderCategoryBoard(SqlSession sqlSession, CalenderCategoryBoard calenderCategoryBoard) {
		return sqlSession.insert("calenderCategoryBoardMapper.insertCalenderCategoryBoard", calenderCategoryBoard);
	}
}
