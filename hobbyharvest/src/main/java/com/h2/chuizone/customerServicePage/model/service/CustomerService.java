package com.h2.chuizone.customerServicePage.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.customerServicePage.model.dao.CustomerServiceDao;
import com.h2.chuizone.customerServicePage.model.dto.InquiryBoardDto;
import com.h2.chuizone.template.MybatisTemplate;
import com.h2.chuizone.template.PageInfo;

public class CustomerService {
	
	/**
	 * @param b BOARD테이블에 저장하기 위한 데이터는 담는 매개변수
	 * @param b1 INQUIRY테이블에 저장하기 위한 데이터는 담는 매개변수
	 * @return INQUIRYBOARD(중간테이블)까지 데이터 저장 후 반환된 결과
	 */
	public int insertInquiryBoard(InquiryBoardDto b, InquiryBoardDto b1) {
		int result = 0;
		
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		result = new CustomerServiceDao().insertInquiryBoard(sqlSession, b, b1);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result;
	}


	/**
	 * @param pi 1:1문의 게시글 페이지 페이지정보를 담는 매개변수
	 * @param userNo 1:1문의 게시글 조회시 클라이언트로부터 전달된 회원번호를 담는 매개변수
	 * @return 1:1문의 게시글 목록을 ArrayList 형태로 리턴
	 */
	public ArrayList<InquiryBoardDto> selectInquiryList(PageInfo pi, String userNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		return new CustomerServiceDao().selectInquiryList(sqlSession, pi, userNo);
	}


	/**
	 * @param userNo 1:1문의 게시글 상세페이지 조회 시 전달된 회원번호를 담는 매개변수
	 * @param boardNo 1:1문의 게시글 상세페이지 조회 시 전달된 게시판 번호를 담는 매개변수
	 * @return 게시판 상세페이지에 전달된 데이터를 InquiryBoardDto객체에 담아 반환 
	 */
	public InquiryBoardDto selectInquiry(String userNo, String boardNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		return new CustomerServiceDao().selectInquiry(sqlSession, userNo, boardNo);
	}


	/**
	 * @param userNo 1:1문의 게시글 페이지 조회시 전달될 회원번호를 담는 매개변수
	 * @return 해당 클라이언트의 1:1문의 게시글의 총 갯수를 반환
	 */
	public int inquiryListCount(String userNo) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		return new CustomerServiceDao().inquiryListCount(sqlSession, userNo);
	}

}
