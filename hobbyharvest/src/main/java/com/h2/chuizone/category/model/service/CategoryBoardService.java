package com.h2.chuizone.category.model.service;

import com.h2.chuizone.category.model.vo.CategoryBoard;
import com.h2.chuizone.common.board.model.vo.Board;

public interface CategoryBoardService {
	/**
	 * 게시글의 개수를 알기위한 Select 쿼리문
	 * @param 카테고리 번호
	 * @param 검색 키워드
	 * @return 게시글의 갯수
	 */
	int selectMaxPageNumber(int categoryNo, String keyword);
	
	/**
	 * 카테고리 보드 테이블 & 보드 테이블에 데이터 삽입하기 위한 쿼리문
	 * @param categoryBoard 카테고리 테이블에 삽입하기 위한 카테고리 테이블의 컬럼 값들
	 * @param board 보드 테이블에 삽입하기 위한 보드 테이블의 컬럼 값들
	 * @param userNo 해당 게시물의 작성자 정보를 위한 회원 번호
	 * @return 성공 여부
	 */
	int insertCategoryBoard(CategoryBoard categoryBoard, Board board, int userNo);
	
	/**
	 * 카테고리 보드 테이블의 현재 참여 인원을 증가 시키기 위한 쿼리문
	 * @param currentHeadCnt 현재 인원수
	 * @param boardNo 게시글 번호
	 * @return 성공 여부
	 */
	int updateCategoryBoardByCurCount(int currentHeadCnt, int boardNo);
	
	/**
	 * 카테고리 보드의 조회수 증가를 위한 쿼리문
	 * @param view 현재 조회수
	 * @param boardNo 게시글 번호
	 * @return 성공 여부
	 */
	int updateCategoryBoardByView(int view, int boardNo);

	/**
	 * 카테고리 보드의 추천수 증가를 위한 쿼리문
	 * @param categoryNo 카테고리 게시글 번호
	 * @return 성공 여부
	 */
	int updateCategoryBoardByRecommandPlus(int categoryNo);

	/**
	 * 카테고리 보드의 추천수 감소를 위한 쿼리문
	 * @param categoryNo 카테고리 게시글 번호
	 * @return 성공 여부
	 */
	int updateCategoryBoardByRecommandMinus(int categoryNo);

	/**
	 * 카테고리 보드의 신고수 증가를 위한 쿼리문
	 * @param categoryNo 카테고리 게시글 번호
	 * @return 성공 여부
	 */
	int updateCategoryBoardByComplainPlus(int categoryNo);

	/**
	 * 카테고리 보드의 신고수 감소를 위한 쿼리문
	 * @param categoryNo 카테고리 게시글 번호
	 * @return 성공 여부
	 */
	int updateCategoryBoardByComplainMinus(int categoryNo);
	
	/**
	 * 카테고리 보드 게시물 수정을 위한 쿼리문
	 * @param categoryBoardNo 카테고리보드 번호
	 * @param smallGroupCategoryNo 소분류-카테고리 테이블 번호
	 * @param categoryImage 첨부파일 이미지 경로
	 * @param maxCount 최대 인원수 값
	 * @return 성공 여부
	 */
	int updateCategoryBoard(int categoryBoardNo, int smallGroupCategoryNo, String categoryImage, int maxCount);
}
