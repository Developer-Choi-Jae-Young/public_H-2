package com.h2.chuizone.updatePwd.model.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.member.model.vo.Member;

public class UpdatePwdDao {

	public int updatePassword(SqlSession sqlSession, HashMap data) {
		return sqlSession.update("memberMapper.updatePassword", data);
	}

	public Member selectMemberByUserId(SqlSession sqlSession, String userId) {
		return sqlSession.selectOne("memberMapper.selectMemberByUserId", userId);
	}
	

}
