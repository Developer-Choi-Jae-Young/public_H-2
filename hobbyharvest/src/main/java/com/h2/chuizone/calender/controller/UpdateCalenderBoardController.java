package com.h2.chuizone.calender.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h2.chuizone.calender.model.dto.CalenderDto;
import com.h2.chuizone.calender.model.service.CalenderService;
import com.h2.chuizone.calender.model.service.CalenderServiceImpl;

/**
 * Servlet implementation class UpdateCalenderBoardController
 */
@WebServlet("/updateCalenderBoard.me")
public class UpdateCalenderBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCalenderBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int categoryBoardNo = Integer.parseInt(request.getParameter("categoryBoardNo"));
		int cboardNo = Integer.parseInt(request.getParameter("cboardNo"));
		
		CalenderService calenderService = new CalenderServiceImpl();
		CalenderDto calenderDto = calenderService.selectCalenderBoardListByBoardNo(boardNo);
		
		request.setAttribute("categoryBoardNo", categoryBoardNo);
		request.setAttribute("startDate", calenderDto.getStartDate());
		request.setAttribute("endDate", calenderDto.getEndDate());
		request.setAttribute("content", calenderDto.getContent());
		request.setAttribute("title", calenderDto.getTitle());
		request.setAttribute("cboardNo", cboardNo);
		request.setAttribute("boardNo", boardNo);
		
		request.getRequestDispatcher("views/calender/calender-modify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
