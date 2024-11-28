package com.h2.chuizone.common.boardcalender.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.boardcalender.model.vo.BoardCalender;

public class BoardCalenderDao {
	
	public int insertBoardCalender(SqlSession sqlSession, BoardCalender boardCalender) {
		return sqlSession.insert("boardCalenderMapper.insertBoardCalender", boardCalender);
	}
	
	public int selectCalenderNo(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardCalenderMapper.selectCalenderNo", boardNo);
	}
}
