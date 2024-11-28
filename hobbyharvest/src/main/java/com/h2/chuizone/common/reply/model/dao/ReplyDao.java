package com.h2.chuizone.common.reply.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.h2.chuizone.common.reply.model.dto.ReplyDto;
import com.h2.chuizone.common.reply.model.vo.Reply;

public class ReplyDao {
	public List<ReplyDto> selectReplyList(SqlSession sqlSession, int boardId) {
		return sqlSession.selectList("replyMapper.selectReplyList", boardId);
	}
	
	public int insertReply(SqlSession sqlSession, Reply reply) {
		if(reply.getParentReplyNo() == -1) {
			return sqlSession.insert("replyMapper.insertReplyParent", reply);
		} else {			
			return sqlSession.insert("replyMapper.insertReply", reply);
		}
	}
	
	public int deleteReply(SqlSession sqlSession, int boardId, int replyId) {
		Map<String, Integer> map = new HashMap<>();
		map.put("boardId", boardId);
		map.put("replyId", replyId);
		
		return sqlSession.update("replyMapper.deleteReply", map);
	}
	
	public int updateReply(SqlSession sqlSession, int boardId, int replyId, String content) {
		Map<String, Object> map = new HashMap<>();
		map.put("boardId", boardId);
		map.put("replyId", replyId);
		map.put("content", content);

		return sqlSession.update("replyMapper.updateReply", map);
	}
}
