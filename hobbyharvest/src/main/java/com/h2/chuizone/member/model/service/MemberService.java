package com.h2.chuizone.member.model.service;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.member.model.dao.MemberDao;
import com.h2.chuizone.member.model.vo.Member;
import com.h2.chuizone.template.MybatisTemplate;

public class MemberService {
	
	private MemberDao mDao = new MemberDao();

	/**
	 * 로그인 처리용 서비스 메소드
	 * @param m 로그인 시도한 아이디, 비밀번호
	 * @return 로그인 시도한 멤버의 아이디, 비밀번호 정보를 담은 멤버 객체
	 */
	public Member loginMember(Member m) {
		Member loginUser = null;
		
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		loginUser = mDao.loginMember(sqlSession, m);
		
		return loginUser;
	}
	
	/**
	 * 회원가입 시 아이디 중복 확인 서비스 메소드
	 * @param userId 중복 체크할 아이디
	 * @return 조회된 아이디의 수
	 */
	public int idCheck(String userId) {
		int count = 0;
		
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		count = mDao.idCheck(sqlSession, userId);
		
		return count;
	}

	/**
	 * 회원가입(회원 추가)용 서비스 메소드
	 * @param m 회원이 입력한 아이디, 비밀번호, 닉네임, 주소, 전화번호 이메일
	 * @return insert 처리된 행 수
	 */
	public int joinMember(Member m) {
		int result = 0;
		
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		result = mDao.joinMember(sqlSession, m);
		
		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}
	
	
	public int deleteMember(Member m) {
		int result = 0;
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		result = mDao.deleteMember(sqlSession, m);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}
	public int updateMember(Member m) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		int result = new MemberDao().updateMember(sqlSession, m);
		
		if(result>0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result;
	}
	

}
