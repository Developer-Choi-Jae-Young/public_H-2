package com.h2.chuizone.common.smallgroup.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.smallgroup.model.dao.SmallGroupDao;
import com.h2.chuizone.common.smallgroup.model.vo.SmallGroup;
import com.h2.chuizone.template.MybatisTemplate;

public class SmallGroupServiceImpl implements SmallGroupService{
	private SmallGroupDao smallGroupDao = new SmallGroupDao();
	
	@Override
	public List<SmallGroup> selectSmallGroupList() {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		return smallGroupDao.selectSmallGroupList(sqlSession);
	}

	@Override
	public SmallGroup selectSmallGroup(String smallGroupName) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		return smallGroupDao.selectSmallGroup(sqlSession, smallGroupName);
	}
	
}
