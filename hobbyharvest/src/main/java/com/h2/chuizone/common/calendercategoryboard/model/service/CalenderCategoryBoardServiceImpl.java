package com.h2.chuizone.common.calendercategoryboard.model.service;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.calendercategoryboard.model.dao.CalenderCategoryBoardDao;
import com.h2.chuizone.common.calendercategoryboard.model.vo.CalenderCategoryBoard;
import com.h2.chuizone.template.MybatisTemplate;

public class CalenderCategoryBoardServiceImpl implements CalenderCategoryBoardService {
	private CalenderCategoryBoardDao calenderCategoryBoardDao = new CalenderCategoryBoardDao();
	
	@Override
	public int insertCalenderCategoryBoard(CalenderCategoryBoard calenderCategoryBoard) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = calenderCategoryBoardDao.insertCalenderCategoryBoard(sqlSession, calenderCategoryBoard);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

}
