package com.h2.chuizone.calender.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h2.chuizone.calender.model.service.CalenderService;
import com.h2.chuizone.calender.model.service.CalenderServiceImpl;
import com.h2.chuizone.common.board.model.service.BoardService;
import com.h2.chuizone.common.board.model.service.BoardServiceImpl;
import com.h2.chuizone.common.boardcalender.model.service.BoardCalenderService;
import com.h2.chuizone.common.boardcalender.model.service.BoardCalenderServiceImpl;

/**
 * Servlet implementation class UpdateCalenderController
 */
@WebServlet("/updateCalender.me")
public class UpdateCalenderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCalenderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int categoryBoardNo = Integer.parseInt(request.getParameter("categoryBoardNo"));
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		int cboardNo = Integer.parseInt(request.getParameter("cboardNo"));
		
		CalenderService calenderService = new CalenderServiceImpl();
		BoardService boardService = new BoardServiceImpl();
		BoardCalenderService boardCalenderService = new BoardCalenderServiceImpl();
		
		int calenderNo = boardCalenderService.selectCalenderNo(boardNo);
		
		int resultCalender = calenderService.updateCalender(calenderNo, Date.valueOf(startDate), Date.valueOf(endDate));
		int resultBoard = boardService.updateBoard(boardNo, content, title);
		
		if(resultCalender > 0 && resultBoard > 0) {
			request.setAttribute("categoryBoardNo", categoryBoardNo);
			request.setAttribute("boardNo", cboardNo);
			
			request.getSession().setAttribute("alertMsg", "일정을 수정하였습니다.");
			response.sendRedirect("calender.me?categoryBoardNo=" + categoryBoardNo + "&boardNo=" + cboardNo);
		} else {
			request.setAttribute("categoryBoardNo", categoryBoardNo);
			request.setAttribute("boardNo", cboardNo);
			
			request.getSession().setAttribute("alertMsg", "일정 수정에 실패 하였습니다.");
			response.sendRedirect("calender.me?categoryBoardNo=" + categoryBoardNo + "&boardNo=" + cboardNo);
		}
	}

}
