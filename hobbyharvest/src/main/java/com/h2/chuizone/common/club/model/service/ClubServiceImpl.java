package com.h2.chuizone.common.club.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.club.model.dao.ClubDao;
import com.h2.chuizone.common.club.model.vo.Club;
import com.h2.chuizone.template.MybatisTemplate;

public class ClubServiceImpl implements ClubService{
	private ClubDao clubDao = new ClubDao();
	
	@Override
	public int insertClub(Club club) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = clubDao.insertClub(sqlSession, club);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result; 
	}

	@Override
	public List<Club> selectClub() {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		return clubDao.selectClub(sqlSession);
	}
	
	@Override
	public String selectClubName(int clubId) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		return clubDao.selectClubName(sqlSession, clubId);
	}

	@Override
	public int updateClub(int clubNo, String clubName) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = clubDao.updateClub(sqlSession, clubNo, clubName);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result; 
	}
}
