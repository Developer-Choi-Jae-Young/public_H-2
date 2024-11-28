package com.h2.chuizone.mypage.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.mypage.model.vo.MySocial;
import com.h2.chuizone.template.PageInfo;

public class MySocialDao {

	
	/**
	 * @param pi 가입한 소모임 페이지 조회시 전달될 PageInfo 객체를 담을 매개변수
	 * @param userNo 가입한 소모임 페이지 조회시 전달되는 회원번호를 담는 매개변수
	 * @return 클라이언트가 가입한 소모임 페이지 조회시 반환될 게시글 목록 정보를 ArrayList 타입으로 반환
	 */
	public ArrayList<MySocial> selectMySocial(SqlSession sqlSession, PageInfo pi, String userNo) {
		
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		ArrayList<MySocial> resultList = (ArrayList)sqlSession.selectList("boardMapper.selectMySocial", userNo, rowBounds);
		
		return resultList;

	}

	/**
	 * @param userNo 가입한 소모임 페이지 조회시 전달된 회원번호를 담는 매개변수
	 * @return 해당 클라이언트가 가입한 소모임 갯수를 int타입으로 반환
	 */
	public int selectMySocialCount(SqlSession sqlSession, String userNo) {
		return sqlSession.selectOne("boardMapper.selectMySocialCount", userNo);
	}

}
