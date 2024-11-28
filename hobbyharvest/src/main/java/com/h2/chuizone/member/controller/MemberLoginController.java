package com.h2.chuizone.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.h2.chuizone.member.model.service.MemberService;
import com.h2.chuizone.member.model.vo.Member;

/**
 * Servlet implementation class MemberLoginController
 */

public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPw(userPw);
		Member loginUser = new MemberService().loginMember(m);
		
		HttpSession session = request.getSession();
		if (loginUser != null) {
			
			session.setAttribute("loginUser", loginUser);
			
			response.sendRedirect( request.getContextPath() );
		} else {
			// 로그인 페이지로 다시 포워딩
			session.setAttribute("alertMsg", "존재하지 않는 아이디입니다.");
			request.getRequestDispatcher("views/member/loginForm.jsp").forward(request, response);
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
