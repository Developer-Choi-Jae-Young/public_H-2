package com.h2.chuizone.homepage.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.category.model.dto.SelectCategoryBoardListDto;

public class BestClubDao {

	/**
	 * 베스트 소모임 노출용 DAO 메소드
	 * @param sqlSession SqlSession 객체
	 * @return TOP 5 소모임 정보를 담은 Dto 객체
	 */
	public List<SelectCategoryBoardListDto> bestClub(SqlSession sqlSession) {
		System.out.println("daotest");
		return sqlSession.selectList("boardMapper.bestClub");
	}

}
