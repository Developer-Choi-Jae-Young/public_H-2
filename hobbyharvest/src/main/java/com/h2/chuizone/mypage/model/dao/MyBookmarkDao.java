package com.h2.chuizone.mypage.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.mypage.model.vo.MyBookmark;
import com.h2.chuizone.template.PageInfo;

public class MyBookmarkDao {

	/**
	 * @param sqlSession
	 * @param userNo 북마크한 게시글 페이지 조회 시 전달될 회원번호를 담는 매개변수
	 * @return 해당 클라이언트가 북마크한 게시글 총 갯수를 int타입으로 반환
	 */
	public int selectMyBookmarkCount(SqlSession sqlSession, String userNo) {

		return sqlSession.selectOne("boardMapper.selectMyBookmarkCount", userNo);
	}

	/**
	 * @param sqlsession
	 * @param pi 북마크한 게시글 페이지 조회시 전달될 PageInfo 객체를 담는 매개변수
	 * @param memberNo 북마크한 게시글 페이지 조회시 전달될 회원번호를 담는 매개변수
	 * @return 클라이언트가 북마크한 게시글 페이지 조회시 반환될 게시글 목록 정보를 ArrayList 타입으로 반환
	 */
	public ArrayList<MyBookmark> selectMyBookmark(SqlSession sqlsession, PageInfo pi, String memberNo) {

		int offset = (pi.getCurrentPage()-1) * pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		return (ArrayList)sqlsession.selectList("boardMapper.MyBookmark", memberNo, rowBounds);
	}

}
