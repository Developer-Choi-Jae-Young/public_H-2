package com.h2.chuizone.common.reply.model.service;

import java.util.List;

import com.h2.chuizone.common.reply.model.dto.ReplyDto;
import com.h2.chuizone.common.reply.model.vo.Reply;

public interface ReplyService {
	/**
	 * 댓글 테이블에서 게시글 번호에 맞는 댓글을 조회하는 쿼리문
	 * @param boardId 게시글 번호
	 * @return 리스트 형태의 댓글 DTO 클래스
	 */
	List<ReplyDto> selectReplyList(int boardId);
	
	/**
	 * 댓글 테이블에 데이터를 삽입하기 위한 쿼리문
	 * @param reply 삽입하기 위한 댓글 클래스
	 * @return 성공 유무
	 */
	int insertReply(Reply reply);
	
	/**
	 * 댓글 테이블에서 게시글 번호와 댓글 번호에 맞는 데이터를 삭제하기 위한 쿼리문
	 * @param boardId 게시글 번호
	 * @param replyId 댓글 번호
	 * @return 성공 유무
	 */
	int deleteReply(int boardId, int replyId);
	
	/**
	 * 댓글 테이블에서 게시글 번호와 댓글 번호에 맞는 데이터중 내용을 수정하기 위한 쿼리문
	 * @param boardId 게시글 번호
	 * @param replyId 댓글 번호
	 * @param content 수정할 댓글 내용
	 * @return 성공 유무
	 */
	int updateReply(int boardId, int replyId, String content);
}
