package com.h2.chuizone.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.h2.chuizone.member.model.service.MemberService;
import com.h2.chuizone.member.model.vo.Member;

/**
 * Servlet implementation class MemberJoinController
 */
@WebServlet("/join.me")
public class MemberJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String nickName = request.getParameter("nickName");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		Member m = new Member(userId, userPw, nickName, email, address, phone);
		
		int result = new MemberService().joinMember(m);
		
		if (result > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "회원 가입에 성공했습니다.");
			
			response.sendRedirect(request.getContextPath());
		} else {
			// TODO: 오류 페이지로 포워딩
//			request.getRequestDispatcher(#).forward(request, response);
			System.out.println("오류 페이지 포워딩~");
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
