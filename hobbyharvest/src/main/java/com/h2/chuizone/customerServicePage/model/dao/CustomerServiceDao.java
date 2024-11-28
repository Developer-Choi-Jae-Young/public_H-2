package com.h2.chuizone.customerServicePage.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.customerServicePage.model.dto.InquiryBoardDto;
import com.h2.chuizone.customerServicePage.model.vo.InquiryBoard;
import com.h2.chuizone.template.PageInfo;

public class CustomerServiceDao {
	/**
	 * 
	 * @param sqlSession
	 * @param b BOARD 테이블에 저장할 데이터를 담는 매개변수
	 * @param b1 INQUIRY 테이블에 저장할 데이터를 담는 매개변수
	 * @return INQUIRYBOARD(위 두 테이블의 중간테이블)에 BNO와 INO 삽입 후 결과를 int타입으로 반환
	 */
	public int insertInquiryBoard(SqlSession sqlSession, InquiryBoardDto b, InquiryBoardDto b1) {
		int result = 0;
		sqlSession.insert("boardMapper.insertInquiryBoard", b);
		sqlSession.insert("boardMapper.insertInqiryBoardUpfile", b1);
		
		InquiryBoard ib = new InquiryBoard(b.getBoardNo(), b1.getInquiryNo());	// "boardMapper.insertInquiryBoard"실행 후 반환된 boardNo(BNO)값과 	
		result = sqlSession.insert("boardMapper.insertInquiryBoardAll", ib);	// "boardMapper.insertInqiryBoardUpfile"실행 후 반환된 inquiryNo(INO) 값을 연결테이블인 INQUIRYBOARD 테이블에 삽입.
		return result; 
	}

	/**
	 * 
	 * @param sqlSession
	 * @param userNo 해당 회원의 1:1문의 리스트 전체를 조회하기 위한 회원번호를 담는 매개변수
	 * @return 회원번호에 대하여 조회된 1:1문의 게시글 전체 갯수를 int타입으로 반환
	 */
	public int inquiryListCount(SqlSession sqlSession, String userNo) {
		return sqlSession.selectOne("boardMapper.inquiryListCount", userNo);
	}

	/**
	 * @param sqlSession
	 * @param pi 1:1문의 게시글 목록 페이지에 대한 페이지 정보를 담는 매개변수
	 * @param userNo 1:1문의 게시글 목록을 조회하기 위한 회원번호를 담는 매개변수
	 * @return 페이지 정보와 회원번호로 조회한 1:1문의 게시글 목록을 ArrayList타입으로 반환
	 */
	public ArrayList<InquiryBoardDto> selectInquiryList(SqlSession sqlSession, PageInfo pi, String userNo) {
		
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectInquiryList", userNo, rowBounds);
	}
	


	/**
	 * 
	 * @param sqlSession
	 * @param userNo 1:1문의 게시글 상세정보를 조회하기 위해 전달된 회원번호를 담는 매개변수
	 * @param boardNo 1:1문의 게시글 상세정보를 조회하기 위해 전달된 게시글 번호를 담는 매개변수
	 * @return 1:1문의 게시글 상세페이지에 전달할 값을 반환:
	 */
	public InquiryBoardDto selectInquiry(SqlSession sqlSession, String userNo, String boardNo) {
		Map<String, String> map = new HashMap<>();
		System.out.println(userNo);
		System.out.println(boardNo);
		map.put("userNo", userNo);
		map.put("boardNo", boardNo);
		return sqlSession.selectOne("boardMapper.selectInquiry", map);
	}

	

}
