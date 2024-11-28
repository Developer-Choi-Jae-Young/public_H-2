package com.h2.chuizone.common.boardcalender.model.service;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.boardcalender.model.dao.BoardCalenderDao;
import com.h2.chuizone.common.boardcalender.model.vo.BoardCalender;
import com.h2.chuizone.template.MybatisTemplate;

public class BoardCalenderServiceImpl implements BoardCalenderService{
	private BoardCalenderDao boardCalenderDao = new BoardCalenderDao();
	
	@Override
	public int insertBoardCalender(BoardCalender boardCalender) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = boardCalenderDao.insertBoardCalender(sqlSession, boardCalender);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public int selectCalenderNo(int boardNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		return boardCalenderDao.selectCalenderNo(sqlSession, boardNo);
	}
}
