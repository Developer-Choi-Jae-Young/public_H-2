package com.h2.chuizone.common.kindofboard.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.kindofboard.model.dao.KindOfBoardDao;
import com.h2.chuizone.common.kindofboard.model.vo.KindOfBoard;
import com.h2.chuizone.template.MybatisTemplate;

public class KindOfBoardServiceImpl implements KindOfBoardService{
	private KindOfBoardDao kindOfBoardDao = new KindOfBoardDao();
	
	@Override
	public List<KindOfBoard> selectKindOfBoardList() {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		return kindOfBoardDao.selectKindOfBoardList(sqlSession);
	}

}
