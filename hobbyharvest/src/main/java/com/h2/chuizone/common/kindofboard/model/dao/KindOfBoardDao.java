package com.h2.chuizone.common.kindofboard.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.kindofboard.model.vo.KindOfBoard;

public class KindOfBoardDao {
	public List<KindOfBoard> selectKindOfBoardList(SqlSession sqlSession) {
		return sqlSession.selectList("kindOfBoardMapper.selectKindOfBoardList");
	}	
}
