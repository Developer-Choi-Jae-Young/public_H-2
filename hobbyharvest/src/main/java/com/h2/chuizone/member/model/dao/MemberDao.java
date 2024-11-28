package com.h2.chuizone.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.member.model.vo.Member;

public class MemberDao {

	/**
	 * 로그인 처리용 DAO 메소드
	 * 
	 * @param sqlSession SqlSession 객체
	 * @param m          로그인 시도한 아이디, 비밀번호
	 * @return 로그인 시도한 멤버의 아이디, 비밀번호 정보를 담은 멤버 객체
	 */
	public Member loginMember(SqlSession sqlSession, Member m) {

		return sqlSession.selectOne("memberMapper.loginMember", m);

	}

	/**
	 * 회원가입 시 아이디 중복 확인 DAO 메소드
	 * 
	 * @param sqlSession SqlSession 객체
	 * @param userId     중복 체크할 아이디
	 * @return 조회된 아이디의 수
	 */
	public int idCheck(SqlSession sqlSession, String userId) {

		return sqlSession.selectOne("memberMapper.idCheck", userId);
	}

	/**
	 * 회원가입(회원 추가)용 DAO 메소드
	 * 
	 * @param sqlSession SqlSession 객체
	 * @param m          회원이 입력한 아이디, 비밀번호, 닉네임, 주소, 전화번호 이메일
	 * @return insert 처리된 행 수
	 */
	public int joinMember(SqlSession sqlSession, Member m) {
		System.out.println(m);
		return sqlSession.insert("memberMapper.joinMember", m);

	}

	public int deleteMember(SqlSession sqlSession, Member m) {

		return sqlSession.update("memberMapper.deleteMember", m);
	}

	public int updateMember(SqlSession sqlSession, Member m) {

		return sqlSession.update("memberMapper.updateMember", m);
	}
}
