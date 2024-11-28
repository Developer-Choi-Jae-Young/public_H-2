package com.h2.chuizone.customerServicePage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CsPageController
 */
@WebServlet("/toFaqPage.do")
public class CustomerServicePageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CustomerServicePageController() {
        super();
    }

	/**
	 * 자주묻는 질문 페이지(frequencyQuestionPage.jsp)로 포워딩, customerServicePage.jsp(고객센터 사이드바)를 include하고 있음
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/csPage/frequencyQuestionPage.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
