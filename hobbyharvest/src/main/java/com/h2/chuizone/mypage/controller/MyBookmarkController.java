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
import com.h2.chuizone.mypage.model.vo.MyBookmark;
import com.h2.chuizone.mypage.model.vo.MySocial;
import com.h2.chuizone.mypage.service.MyPageService;
import com.h2.chuizone.template.PageInfo;
import com.h2.chuizone.template.Pagination;

/**
 * Servlet implementation class MyBookmark
 */
@WebServlet("/toMyBookmark.do")
public class MyBookmarkController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyBookmarkController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cpage = 1;
		HttpSession session = request.getSession();
		if(request.getParameter("cpage") != null) {
			cpage = Integer.parseInt(request.getParameter("cpage"));
		}
		String userNo = ((Member)session.getAttribute("loginUser")).getUserNo() + "";
		int myBookmarkCount = new MyPageService().selectMyBookmarkCount(userNo); // 북마크 수
		PageInfo pi = Pagination.getPageInfo(myBookmarkCount, cpage, 5, 16);
		ArrayList<MyBookmark> myBookmarkList = new MyPageService().selectMyBookmark(pi, userNo);
		
		for(MyBookmark mb : myBookmarkList) {
			if(mb.getDescription().length() > 10 ) {
				mb.setDescription(mb.getDescription().substring(0, 10)+ "..." );
			}
			if(mb.getTitle().length() > 5 ) {
				mb.setTitle(mb.getTitle().substring(0, 5)+ "..." );
			}
		}
		
		request.setAttribute("myBookmarkList", myBookmarkList);
		request.setAttribute("pi", pi);
		
		request.getRequestDispatcher("views/myPage/myBookmark.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
