package com.h2.chuizone.calender.model.service;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.calender.model.dao.CalenderDao;
import com.h2.chuizone.calender.model.dto.CalenderDto;
import com.h2.chuizone.calender.model.vo.Calender;
import com.h2.chuizone.template.MybatisTemplate;

public class CalenderServiceImpl implements CalenderService{
	private CalenderDao calenderDao = new CalenderDao();
	
	@Override
	public int insertCalender(Calender calender) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = calenderDao.insertCalender(sqlSession, calender);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public List<CalenderDto> selectCalenderBoardList(int categoryBoardNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		return calenderDao.selectCalenderBoardList(sqlSession, categoryBoardNo);
	}

	@Override
	public CalenderDto selectCalenderBoardListByBoardNo(int boardNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		return calenderDao.selectCalenderBoardListByBoardNo(sqlSession, boardNo);
	}

	@Override
	public int updateCalender(int calenderNo, Date startDate, Date endDate) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = calenderDao.updateCalender(sqlSession, calenderNo, startDate, endDate);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}
}
