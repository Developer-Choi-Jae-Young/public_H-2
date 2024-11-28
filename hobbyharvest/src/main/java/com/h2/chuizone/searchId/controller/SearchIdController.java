package com.h2.chuizone.searchId.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h2.chuizone.searchId.model.service.SeachIdService;

/**
 * Servlet implementation class SearchIdController
 */
@WebServlet("/SearchId")
public class SearchIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIdController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		// => 요청 시 전달된 데이터 추출

		System.out.println(email);
		
		String userId = null;

		if (email != null) { // => email 정보가 있는 경우

			userId = new SeachIdService().searchId(email);
			// => DB에서 이메일 기준으로 데이터를 조회
			 
		}
		
		response.getWriter().print(userId);
		// => 결과 데이터를 응답

	}

}
