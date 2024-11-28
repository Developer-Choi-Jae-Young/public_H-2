package com.h2.chuizone.common.memberreviewrecommand.model.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.memberreviewrecommand.model.vo.MemberReviewRecommand;

public class MemberReviewRecommandDao {
	public int selectMemberReviewRecommand(SqlSession sqlSession, int reviewNo, int memberNo) {
		Map<String, Integer> map = new HashMap<>();
		map.put("reviewNo", reviewNo);
		map.put("memberNo", memberNo);
		
		return sqlSession.selectOne("memberReviewRecommandMapper.selectMemberReviewRecommand", map);
	}
	
	public int insertMemberReviewRecommand(SqlSession sqlSession, MemberReviewRecommand memberReviewRecommand) {
		return sqlSession.insert("memberReviewRecommandMapper.insertMemberReviewRecommand", memberReviewRecommand);
	}
	
	public int deleteMemberReviewRecommand(SqlSession sqlSession, int reviewNo, int memberNo) {
		Map<String, Integer> map = new HashMap<>();
		map.put("reviewNo", reviewNo);
		map.put("memberNo", memberNo);

		return sqlSession.delete("memberReviewRecommandMapper.deleteMemberReviewRecommand", map);
	}
}
