package com.h2.chuizone.common.board.model.service;

import java.util.List;

import com.h2.chuizone.category.model.dto.SelectCategoryBoardListDto;
import com.h2.chuizone.common.board.model.vo.Board;

public interface BoardService {
	/**
	 * 보드 테이블에 데이터 삽입을 위한 쿼리문
	 * @param board 보드 테이블 데이터
	 * @return 성공 여부
	 */
	int insertBoard(Board board);
	
	/**
	 * 카테고리 & 보드 등 테이블의 리스트를 조회 하기 위한 쿼리문
	 * @param startNum 조회하기 위한 시작 값
	 * @param endNum 조회하기 위한 끝 값
	 * @param 카테고리 번호
	 * @param 검색 키워드
	 * @return 카테고리 및 보드 등 테이블 조인을 한 DTO클래스의 리스트 형태로 반환
	 */
	List<SelectCategoryBoardListDto> selectCategoryBoardList(int startNum, int endNum, int categoryNo, String keyword);
	
	/**
	 * 카테고리 & 보드 등 테이블의 한개의 컬럼만 조회 하기 위한 쿼리문
	 * @param boardId 조회할 보드 테이블의 번호
	 * @return 조회된 테이블의 데이터
	 */
	public SelectCategoryBoardListDto selectCategoryBoard(int boardId);
	
	/**
	 * 카테고리 보드의 삭제를 위한 쿼리문
	 * @param boardNo 삭제할 보드 테이블의 번호
	 * @return 성공 여부 
	 */
	int deleteCategoryBoard(int boardNo);
	
	/**
	 * 카테고리 보드의 수정을 위한 쿼리문
	 * @param boardNo 수정할 보드 테이블의 번호
	 * @param content 수정할 내용
	 * @param title 수정할 제목
	 * @return 성공 여부
	 */
	int updateBoard(int boardNo, String content, String title);
}
