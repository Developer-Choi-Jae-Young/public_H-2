package com.h2.chuizone.common.smallgroupcategory.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.smallgroupcategory.model.dao.SmallGroupCategoryDao;
import com.h2.chuizone.common.smallgroupcategory.model.dto.SelectGroupCategoryDto;
import com.h2.chuizone.common.smallgroupcategory.model.vo.SmallGroupCategory;
import com.h2.chuizone.template.MybatisTemplate;

public class SmallGroupCategoryServiceImpl implements SmallGroupCategoryService{
 	private SmallGroupCategoryDao smallGroupCategoryDao = new SmallGroupCategoryDao();
	
 	@Override
	public List<SmallGroupCategory> selectSmallGroupCategoryList() {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		return smallGroupCategoryDao.selectSmallGroupCategoryList(sqlSession);
 	}

	@Override
	public SmallGroupCategory selectSmallGroupCategory(SelectGroupCategoryDto selectGroupCategoryDto) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		return smallGroupCategoryDao.selectSmallGroupCategory(sqlSession, selectGroupCategoryDto);
	}

	@Override
	public String selectSmallGroupName(int smallGroupCategoryNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		smallGroupCategoryDao.selectSmallGroupName(sqlSession, smallGroupCategoryNo);
		
		return null;
	}	
}
