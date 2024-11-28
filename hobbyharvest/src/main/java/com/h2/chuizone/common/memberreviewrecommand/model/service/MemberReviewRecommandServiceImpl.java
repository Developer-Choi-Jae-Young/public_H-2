package com.h2.chuizone.common.memberreviewrecommand.model.service;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.memberreviewrecommand.model.dao.MemberReviewRecommandDao;
import com.h2.chuizone.common.memberreviewrecommand.model.vo.MemberReviewRecommand;
import com.h2.chuizone.template.MybatisTemplate;

public class MemberReviewRecommandServiceImpl implements MemberReviewRecommandService{
	private MemberReviewRecommandDao memberReviewRecommandDao = new MemberReviewRecommandDao();
	
	@Override
	public int selectMemberReviewRecommand(int reviewNo, int memberNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		return memberReviewRecommandDao.selectMemberReviewRecommand(sqlSession, reviewNo, memberNo);
	}

	@Override
	public int insertMemberReviewRecommand(MemberReviewRecommand memberReviewRecommand) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = memberReviewRecommandDao.insertMemberReviewRecommand(sqlSession, memberReviewRecommand);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public int deleteMemberReviewRecommand(int reviewNo, int memberNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = memberReviewRecommandDao.deleteMemberReviewRecommand(sqlSession, reviewNo, memberNo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}
}
