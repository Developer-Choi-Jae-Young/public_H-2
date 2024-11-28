package com.h2.chuizone.calender.model.dao;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.calender.model.dto.CalenderDto;
import com.h2.chuizone.calender.model.vo.Calender;

public class CalenderDao {
	public int insertCalender(SqlSession sqlSession, Calender calender) {
		return sqlSession.insert("calendarMapper.insertCalender", calender);
	}
	
	public List<CalenderDto> selectCalenderBoardList(SqlSession sqlSession, int categoryBoardNo) {
		return sqlSession.selectList("boardMapper.selectCalenderBoardList", categoryBoardNo);
	}
	
	public CalenderDto selectCalenderBoardListByBoardNo(SqlSession sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectCalenderBoardListByBoardNo", boardNo);
	}
	
	public int updateCalender(SqlSession sqlSession, int calenderNo, Date startDate, Date endDate) {
		Map<String, Object> map = new HashMap<>();
		map.put("calenderNo", calenderNo);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		
		return sqlSession.update("calendarMapper.updateCalender", map);
	}
}
