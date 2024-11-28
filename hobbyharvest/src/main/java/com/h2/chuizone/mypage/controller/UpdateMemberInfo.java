package com.h2.chuizone.mypage.controller;

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
 * Servlet implementation class UpdateMemberInfo
 */
@WebServlet("/updateInfo.do")
public class UpdateMemberInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userId");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		Member m = new Member();
		m.setUserId(userId);
		m.setEmail(email);
		m.setPhone(phone);
		m.setAddress(address);
		HttpSession session =request.getSession();
		int result = new MemberService().updateMember(m);
		if(result > 0) {
			Member loginUser = (Member)session.getAttribute("loginUser");
			loginUser.setUserId(userId);
			loginUser.setEmail(email);
			loginUser.setPhone(phone);
			loginUser.setAddress(address);
			session.setAttribute("loginUser", loginUser);
			session.setAttribute("alertMsg", "회원정보가 수정되었습니다.");
			request.getRequestDispatcher("toMyInfo.do").forward(request, response);
		} else {
			session.setAttribute("alertMsg", "회원정보 수정에 실패했습니다.");
			request.getRequestDispatcher("views/myPage/myInfo.jsp").forward(request, response);
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
