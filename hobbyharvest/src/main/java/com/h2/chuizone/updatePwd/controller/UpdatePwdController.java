package com.h2.chuizone.updatePwd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.h2.chuizone.member.model.vo.Member;
import com.h2.chuizone.updatePwd.model.service.UpdatePwdService;


/**
 * Servlet implementation class UpdatePwdController
 */
@WebServlet("/UpdatePwd")
public class UpdatePwdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePwdController() {
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
		Member updateMem = null;
		String userId = request.getParameter("id");
		String password = request.getParameter("pwd");
		String newPassword = request.getParameter("newPwd");
		String newPasswordCheck = request.getParameter("newPwdCheck");
		
		
		response.setContentType("text/html;charset=UTF-8");
		if (userId == null ) {
			response.getWriter().print("회원이 아닙니다.");
			
		}else if(password.equals(newPassword)){
			response.getWriter().print("기존의 비밀번호와 변경할 비밀번호가 같으면 안됩니다.");
		}else if(!newPassword.equals(newPasswordCheck)){
			response.getWriter().print("변경할 비밀번호와 변경할 비밀번호 확인 내용이 다릅니다.");
		}else if(newPassword.length() < 8){
			response.getWriter().print("비밀번호는 8자리 이상입니다.");	
		}else {
			updateMem = new UpdatePwdService().updatePassword(userId, password, newPassword, newPasswordCheck);
			HttpSession session = request.getSession();
						
			session.setAttribute("loginUser", updateMem);
			
			response.getWriter().print("비밀번호 변경 완료");		
		}
	}
	

}
