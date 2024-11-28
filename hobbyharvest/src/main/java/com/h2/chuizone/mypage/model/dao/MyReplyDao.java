package com.h2.chuizone.mypage.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.mypage.model.vo.MyReply;
import com.h2.chuizone.template.PageInfo;

public class MyReplyDao {

	
	/**
	 * @param userNo 내가 댓글 쓴 게시글 페이지 조회시 전달될 회원번호를 담는 매개변수
	 * @return 해당 클라이언트가 댓글 쓴 게시글 총 갯수를 int타입으로 반환
	 */
	public int selectMyReplyCount(SqlSession sqlSession, String userNo) {
		
		return sqlSession.selectOne("boardMapper.selectMyReplyCount", userNo);
	}
	
	/**
	 * @param pi 내가 댓글 쓴 게시글 페이지 조회 시 전달될 PageInfo 객체를 담는 매개변수
	 * @param userNo 내가 댓글 쓴 게시글 페이지 조회 시 전달될 회원번호를 담는 매개변수
	 * @return 클라이언트가 내가 댓글 쓴 게시글 페이지 조회시 반환될 게시글 목록 정보를 ArrayList 타입으로 반환
	 */
	public ArrayList<MyReply> selectMyReply(SqlSession sqlSession, PageInfo pi, String userNo) {
		
		int offset = (pi.getCurrentPage()-1)*pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		return (ArrayList)sqlSession.selectList("boardMapper.myReply", userNo, rowBounds);
	}
}
