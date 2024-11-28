package com.h2.chuizone.common.memberclub.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.memberclub.model.vo.MemberClub;

public class MemberClubDao {
	public List<Integer> selectJoinClub(SqlSession sqlSession, int memberId) {
		return sqlSession.selectList("memberClubMapper.selectJoinClub", memberId);
	}
	
	public int insertJoinClub(SqlSession sqlSession, MemberClub memberClub) {
		return sqlSession.insert("memberClubMapper.insertJoinClub", memberClub);
	}
	
	public int deleteJoinClub(SqlSession sqlSession, MemberClub memberClub) {
		return sqlSession.delete("memberClubMapper.deleteJoinClub", memberClub);
	}
}
