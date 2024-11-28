package com.h2.chuizone.mypage.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.member.model.dao.MemberDao;
import com.h2.chuizone.member.model.vo.Member;
import com.h2.chuizone.mypage.model.dao.MyBookmarkDao;
import com.h2.chuizone.mypage.model.dao.MyReplyDao;
import com.h2.chuizone.mypage.model.dao.MySocialDao;
import com.h2.chuizone.mypage.model.vo.MyBookmark;
import com.h2.chuizone.mypage.model.vo.MyReply;
import com.h2.chuizone.mypage.model.vo.MySocial;
import com.h2.chuizone.template.MybatisTemplate;
import com.h2.chuizone.template.PageInfo;

public class MyPageService {
	SqlSession sqlSession;
	
	public MyPageService() {
		this.sqlSession = MybatisTemplate.getSqlSession();
	}
	
	
	/**
	 * @param userNo 가입한 소모임 페이지 조회시 전달된 회원번호를 담는 매개변수
	 * @return 해당 클라이언트가 가입한 소모임 갯수를 int타입으로 반환
	 */
	public int selectMySocialCount(String userNo) {
		int result = 0;
		result = new MySocialDao().selectMySocialCount(sqlSession, userNo);
		return result;
	}

	/**
	 * @param pi 가입한 소모임 페이지 조회시 전달될 PageInfo 객체를 담을 매개변수
	 * @param userNo 가입한 소모임 페이지 조회시 전달되는 회원번호를 담는 매개변수
	 * @return 클라이언트가 가입한 소모임 페이지 조회시 반환될 게시글 목록 정보를 ArrayList 타입으로 반환
	 */
	public ArrayList<MySocial> selectMySocialList(PageInfo pi, String userNo) {
		ArrayList<MySocial> mySocialList = null;
		mySocialList = new MySocialDao().selectMySocial(sqlSession, pi, userNo);
		return mySocialList;
	}
	
	
	/**
	 * @param userNo 내가 댓글 쓴 게시글 페이지 조회시 전달될 회원번호를 담는 매개변수
	 * @return 해당 클라이언트가 댓글 쓴 게시글 총 갯수를 int타입으로 반환
	 */
	public int selectMyReplyCount(String userNo) {
		int result = 0;
		result = new MyReplyDao().selectMyReplyCount(sqlSession, userNo);
		return result;
	}

	/**
	 * @param pi 내가 댓글 쓴 게시글 페이지 조회 시 전달될 PageInfo 객체를 담는 매개변수
	 * @param userNo 내가 댓글 쓴 게시글 페이지 조회 시 전달될 회원번호를 담는 매개변수
	 * @return 클라이언트가 내가 댓글 쓴 게시글 페이지 조회시 반환될 게시글 목록 정보를 ArrayList 타입으로 반환
	 */
	public ArrayList<MyReply> selectMyReply(PageInfo pi, String userNo) {
		ArrayList<MyReply> mrList = null;
		mrList = new MyReplyDao().selectMyReply(sqlSession, pi, userNo);
		return  mrList;
		
	}


	/**
	 * @param userNo 북마크한 게시글 페이지 조회시 전달될 회원번호를 담는 매개변수
	 * @return 해당 클라이언트가 북마크한 게시글 총 갯수를 int타입으로 반환
	 */
	public int selectMyBookmarkCount(String userNo) {
		int result = 0;
		result = new MyBookmarkDao().selectMyBookmarkCount(sqlSession, userNo);
		return result;
	}
	
	/**
	 * @param pi 북마크한 게시글 페이지 조회시 전달될 PageInfo 객체를 담는 매개변수
	 * @param memberNo 북마크한 게시글 페이지 조회시 전달될 회원번호를 담는 매개변수
	 * @return 클라이언트가 북마크한 게시글 페이지 조회시 반환될 게시글 목록 정보를 ArrayList 타입으로 반환
	 */
	public ArrayList<MyBookmark> selectMyBookmark(PageInfo pi, String memberNo) {
		ArrayList<MyBookmark> mbList = null;
		mbList = new MyBookmarkDao().selectMyBookmark(sqlSession, pi, memberNo);
		return mbList;
	}

	
}
