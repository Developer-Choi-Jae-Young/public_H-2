package com.h2.chuizone.searchId.model.dao;

import org.apache.ibatis.session.SqlSession;

public class SearchIdDao {

	public String searchId(SqlSession sqlSession, String email) {
		return sqlSession.selectOne("memberMapper.searchId", email);
	}
	
}

