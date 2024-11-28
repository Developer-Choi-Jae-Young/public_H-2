package com.h2.chuizone.common.memberclub.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.memberclub.model.dao.MemberClubDao;
import com.h2.chuizone.common.memberclub.model.vo.MemberClub;
import com.h2.chuizone.template.MybatisTemplate;

public class MemberClubServiceImpl implements MemberClubService{
	private MemberClubDao memberClubDao = new MemberClubDao();
	
	@Override
	public List<Integer> selectJoinClub(int memberId) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		List<Integer> result = memberClubDao.selectJoinClub(sqlSession, memberId);
		
		return result;
	}

	@Override
	public int insertJoinClub(MemberClub memberClub) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = memberClubDao.insertJoinClub(sqlSession, memberClub);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public int deleteJoinClub(MemberClub memberClub) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = memberClubDao.deleteJoinClub(sqlSession, memberClub);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}
}
