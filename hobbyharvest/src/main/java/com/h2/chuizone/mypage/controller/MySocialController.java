package com.h2.chuizone.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.h2.chuizone.member.model.vo.Member;
import com.h2.chuizone.mypage.model.vo.MySocial;
import com.h2.chuizone.mypage.service.MyPageService;
import com.h2.chuizone.template.PageInfo;
import com.h2.chuizone.template.Pagination;

/**
 * Servlet implementation class MySocialController
 */
@WebServlet("/toMySocial.do")
public class MySocialController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MySocialController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int cpage = 1;
		if(request.getParameter("cpage") != null) {
			cpage = Integer.parseInt(request.getParameter("cpage"));
		}
		String userNo = ((Member)session.getAttribute("loginUser")).getUserNo()+"";
		int mySocialCount = new MyPageService().selectMySocialCount(userNo);
		PageInfo pi;
		
		pi = Pagination.getPageInfo(mySocialCount, cpage, 5, 16);
		
		ArrayList<MySocial> mySocialList = new MyPageService().selectMySocialList(pi, userNo);
		
		
		
		for(MySocial ms : mySocialList) {
			if(ms.getDescription().length() > 10 ) {
				ms.setDescription(ms.getDescription().substring(0, 10)+ "..." );
			}
			if(ms.getTitle().length() > 5 ) {
				ms.setTitle(ms.getTitle().substring(0, 5)+ "..." );
			}
		}
		
		request.setAttribute("mySocialList", mySocialList);
		request.setAttribute("pi", pi);
		
		request.getRequestDispatcher("views/myPage/mySocial.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
