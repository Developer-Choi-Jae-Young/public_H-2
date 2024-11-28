package com.h2.chuizone.searchId.model.service;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.searchId.model.dao.SearchIdDao;
import com.h2.chuizone.template.MybatisTemplate;


public class SeachIdService {

	private SearchIdDao sDao = new SearchIdDao();

	public String searchId(String email) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		String id = sDao.searchId(sqlSession, email);
		sqlSession.close();
		return id;
	}

}


