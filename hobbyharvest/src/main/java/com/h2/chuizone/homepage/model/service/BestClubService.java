package com.h2.chuizone.homepage.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.category.model.dto.SelectCategoryBoardListDto;
import com.h2.chuizone.homepage.model.dao.BestClubDao;
import com.h2.chuizone.template.MybatisTemplate;

public class BestClubService {
	SqlSession sqlSession = MybatisTemplate.getSqlSession();
	
	/**
	 * 베스트 소모임 노출용 서비스 메소드
	 * @return TOP 5 소모임 정보를 담은 Dto 객체
	 */
	public List<SelectCategoryBoardListDto> bestClub() {
		System.out.println("service test");

		return new BestClubDao().bestClub(sqlSession);
	}

}
