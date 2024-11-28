package com.h2.chuizone.common.smallgroupcategory.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.smallgroupcategory.model.dto.SelectGroupCategoryDto;
import com.h2.chuizone.common.smallgroupcategory.model.vo.SmallGroupCategory;

public class SmallGroupCategoryDao {
	public List<SmallGroupCategory> selectSmallGroupCategoryList(SqlSession sqlSession) {
		return sqlSession.selectList("smallGroupCategoryMapper.selectSmallGroupCategoryList");
	}
	
	public SmallGroupCategory selectSmallGroupCategory(SqlSession sqlSession, SelectGroupCategoryDto selectGroupCategoryDto) {
		return sqlSession.selectOne("smallGroupCategoryMapper.selectSmallGroupCategory", selectGroupCategoryDto);
	}
	
	public String selectSmallGroupName(SqlSession sqlSession, int selectSmallGroupName) {
		return sqlSession.selectOne("smallGroupCategoryMapper.selectSmallGroupName", selectSmallGroupName);
	}
}
