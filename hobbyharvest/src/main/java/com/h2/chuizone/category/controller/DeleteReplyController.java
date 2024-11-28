package com.h2.chuizone.category.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.h2.chuizone.common.reply.model.dto.ReplyDto;
import com.h2.chuizone.common.reply.model.service.ReplyService;
import com.h2.chuizone.common.reply.model.service.ReplyServiceImpl;
import com.h2.chuizone.template.ReplyLogic;

/**
 * Servlet implementation class DeleteReplyController
 */
@WebServlet("/deleteReply.me")
public class DeleteReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteReplyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		int replyId =  Integer.parseInt(request.getParameter("replyId"));
		
		ReplyService replyService = new ReplyServiceImpl();
		
		int result = replyService.deleteReply(boardId, replyId);
		
		if(result > 0) {
			List<ReplyDto> replyList = replyService.selectReplyList(boardId);
			List<ReplyDto> dstList = new ArrayList<>();
			
			ReplyLogic replyLogic = new ReplyLogic();
					
			GsonBuilder gsonBuilder = new GsonBuilder();
	        gsonBuilder.setDateFormat("yyyy-MM-dd");
			Gson gson = gsonBuilder.create();
			replyLogic.Reply(replyList, dstList, replyLogic.getCommentList(replyList, 0), 1);
			String jsonReply = gson.toJson(dstList);
			
		    response.setCharacterEncoding("UTF-8");
			response.getWriter().print(jsonReply);
		} else {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
