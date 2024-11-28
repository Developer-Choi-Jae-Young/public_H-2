package com.h2.chuizone.common.club.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.club.model.vo.Club;

public class ClubDao {
	public int insertClub(SqlSession sqlSession, Club club) {
		return sqlSession.insert("clubMapper.insertClub", club);
	}
	
	public List<Club> selectClub(SqlSession sqlSession) {
		return sqlSession.selectList("clubMapper.selectClub");
	}
	
	public String selectClubName(SqlSession sqlSession, int clubId) {
		return sqlSession.selectOne("clubMapper.selectClubName", clubId);
	}

	public int updateClub(SqlSession sqlSession, int clubNo, String clubName) {
		Map<String, Object> map = new HashMap();
		map.put("clubNo", clubNo);
		map.put("clubName", clubName);
		
		return sqlSession.update("clubMapper.updateClub", map);
	}
}
