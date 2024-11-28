package com.h2.chuizone.updatePwd.model.service;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.member.model.vo.Member;
import com.h2.chuizone.template.MybatisTemplate;
import com.h2.chuizone.updatePwd.model.dao.UpdatePwdDao;

public class UpdatePwdService {
	private UpdatePwdDao upDao = new UpdatePwdDao();

	public Member updatePassword(String userId, String userPw,String newUserPw, String newUserPwCheck) {

		Member updateMem = null;
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		HashMap data = new HashMap();
		data.put("userId", userId);
		data.put("userPw", userPw);
		data.put("newUserPw", newUserPw);
		data.put("newUserPwCheck", newUserPwCheck);

		int result = upDao.updatePassword(sqlSession, data);
		
		System.out.println();
		if (result > 0) {
			sqlSession.commit();
		 updateMem = upDao.selectMemberByUserId(sqlSession, userId);
		
		
		
		}
		sqlSession.close();
		return updateMem;

	}
}

