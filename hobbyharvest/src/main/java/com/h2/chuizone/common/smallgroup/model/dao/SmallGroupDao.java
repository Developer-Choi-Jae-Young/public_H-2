package com.h2.chuizone.common.smallgroup.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.smallgroup.model.vo.SmallGroup;

public class SmallGroupDao {
	public List<SmallGroup> selectSmallGroupList(SqlSession sqlSession) {
		return sqlSession.selectList("smallGroupMapper.selectSmallGroupList");
	}
	
	public SmallGroup selectSmallGroup(SqlSession sqlSession, String smallGroupName) {
		return sqlSession.selectOne("smallGroupMapper.selectSmallGroup", smallGroupName);
	}
}
