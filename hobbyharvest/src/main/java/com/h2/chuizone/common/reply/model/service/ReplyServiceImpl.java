package com.h2.chuizone.common.reply.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.reply.model.dao.ReplyDao;
import com.h2.chuizone.common.reply.model.dto.ReplyDto;
import com.h2.chuizone.common.reply.model.vo.Reply;
import com.h2.chuizone.template.MybatisTemplate;

public class ReplyServiceImpl implements ReplyService{
	private ReplyDao replyDao = new ReplyDao();
	
	@Override
	public List<ReplyDto> selectReplyList(int boardId) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		return replyDao.selectReplyList(sqlSession, boardId);
	}

	@Override
	public int insertReply(Reply reply) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = replyDao.insertReply(sqlSession, reply);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public int deleteReply(int boardId, int replyId) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = replyDao.deleteReply(sqlSession, boardId, replyId);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public int updateReply(int boardId, int replyId, String content) {
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = replyDao.updateReply(sqlSession, boardId, replyId, content);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}
}
