package com.h2.chuizone.template;

import java.util.ArrayList;
import java.util.List;

import com.h2.chuizone.common.reply.model.dto.ReplyDto;

public class ReplyLogic {
	/**
	 * 댓글 대댓글을 화면에 표시하기 전에 정리하는 함수
	 * @param cList 원본 데이터
	 * @param dstList 함수 수행후 출력 데이터
	 * @param processList 재귀 함수 호출을 위한 가공중 데이터
	 * @param dept 대댓글 깊이
	 * @return 함수 수행후 출력 데이터
	 */
	public List<ReplyDto> Reply(List<ReplyDto> cList, List<ReplyDto> dstList, List<ReplyDto> processList, int dept) {
		for(ReplyDto c : processList) {			
			c.setDepts(dept);
			dstList.add(c);
			Reply(cList, dstList, getCommentList(cList, c.getReplyNo()), dept+1);
		}
		
		return dstList;
	}
	
	/**
	 * 해당 댓글의 부모 댓글의 유무를 판단하여 해당 대댓글의 리스트를 반환 해주는 함수
	 * @param cList 원본 데이터
	 * @param id 부모 댓글의 댓글 번호
	 * @return 가공중 데이터 반환
	 */
	public List<ReplyDto> getCommentList(List<ReplyDto> cList, Integer id) {
		List<ReplyDto> rList = new ArrayList<>();
		
		for(ReplyDto c : cList) {
			if(c.getParentReplyNo() == id) {				
				rList.add(c);
			}
		}
		
		return rList;
	}
}
