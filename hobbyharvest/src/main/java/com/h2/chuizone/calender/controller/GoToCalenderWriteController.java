package com.h2.chuizone.calender.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class goToCalenderWriteController
 */
@WebServlet("/calenderWrite.me")
public class GoToCalenderWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoToCalenderWriteController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryBoardNo = Integer.parseInt(request.getParameter("categoryBoardNo"));
		int cboardNo = Integer.parseInt(request.getParameter("cboardNo"));
		Date startDate = Date.valueOf(request.getParameter("startDate"));
		Date endDate =  Date.valueOf(request.getParameter("endDate"));
		
		request.setAttribute("categoryBoardNo", categoryBoardNo);
		request.setAttribute("cboardNo", cboardNo);
		request.setAttribute("startDate", startDate);
		request.setAttribute("endDate", endDate);
		
		request.getRequestDispatcher("views/calender/calender-write.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
