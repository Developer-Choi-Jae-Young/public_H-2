package com.h2.chuizone.calender.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h2.chuizone.calender.model.dto.CalenderDto;
import com.h2.chuizone.calender.model.service.CalenderService;
import com.h2.chuizone.calender.model.service.CalenderServiceImpl;
import com.h2.chuizone.common.reply.model.dto.ReplyDto;
import com.h2.chuizone.common.reply.model.service.ReplyService;
import com.h2.chuizone.common.reply.model.service.ReplyServiceImpl;
import com.h2.chuizone.member.model.vo.Member;
import com.h2.chuizone.template.ReplyLogic;

/**
 * Servlet implementation class ShowCalenderController
 */
@WebServlet("/showCalender.me")
public class ShowCalenderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCalenderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String cboardNo = request.getParameter("cboardNo");
		request.setAttribute("cboardNo", cboardNo);
		
		ReplyService replyService = new ReplyServiceImpl();
		List<ReplyDto> replyList = replyService.selectReplyList(boardNo);
		List<ReplyDto> dstList = new ArrayList<>();
		
		ReplyLogic replyLogic = new ReplyLogic();
		replyLogic.Reply(replyList, dstList, replyLogic.getCommentList(replyList, 0), 1);
		request.setAttribute("reply", dstList);
		
		CalenderService calenderService = new CalenderServiceImpl();
		CalenderDto calenderDto = calenderService.selectCalenderBoardListByBoardNo(boardNo);
		request.setAttribute("board_data", calenderDto);
		
		Member member = (Member)request.getSession().getAttribute("loginUser");
		if(member.getUserNo() == calenderDto.getMemberNo()) {
			request.setAttribute("owner", true);
		} else {
			request.setAttribute("owner", false);
		}
		
		request.getRequestDispatcher("views/calender/calender-view.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
