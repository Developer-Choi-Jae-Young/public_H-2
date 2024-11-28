package com.h2.chuizone.homepage.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h2.chuizone.common.Pageing;
import com.h2.chuizone.homepage.model.service.BestClubService;
import com.h2.chuizone.category.model.dto.SelectCategoryBoardListDto;


/**
 * Servlet implementation class bestClubController
 */
@WebServlet("/bestClub")
public class BestClubController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BestClubController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<SelectCategoryBoardListDto> bestClubList = new BestClubService().bestClub();
		request.setAttribute("board", bestClubList);
		 System.out.println("test");
		
		Pageing pageing = new Pageing();
		pageing.setBoarderNum(5);
		request.setAttribute("pageing", pageing);
		
		request.getRequestDispatcher("views/main.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
