package com.h2.chuizone.customerServicePage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h2.chuizone.customerServicePage.model.dto.InquiryBoardDto;
import com.h2.chuizone.customerServicePage.model.service.CustomerService;
import com.h2.chuizone.member.model.vo.Member;
import com.h2.chuizone.template.PageInfo;
import com.h2.chuizone.template.Pagination;

/**
 * Servlet implementation class PiPageController
 */
@WebServlet("/toPiPage.do")
public class PersonalInquiryPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalInquiryPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 1:1문의 목록 페이지로(personalInquiryPage.jsp)로 포워딩, customerServicePage.jsp(고객센터 사이드바)를 include하고 있음
	 * 포워딩 시 1:1문의 목록 및 페이지네이션 정보를 포함하여 포워딩함
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo() + "";
		int cpage = 1;								// 사이드바 1:1문의 링크를 클릭하여 이동시 기본 현재 페이지가 1페이지로 시작함
		if(request.getParameter("cpage") != null) {	// 페이지네이션 바의 다른 페이지 번호 클릭시 현재 서블릿이 재호출되며 해당 페이지 번호가 cpage의 값으로 전달됨
			cpage = Integer.parseInt(request.getParameter("cpage"));
		}

		int inquiryListCount = new CustomerService().inquiryListCount(userNo); // 회원번호로 작성된 모든 1:1문의 게시글 갯수를 조회

		PageInfo pi = Pagination.getPageInfo(inquiryListCount, cpage, 5, 6);   // 1:1문의 게시글 갯수와 현재페이지, 페이징 바에 한눈에 표시되는 페이지 번호 최대 갯수, 한 페이지에 보이는 게시글 최대 갯수를 페이지정보 객체에 저장
		ArrayList<InquiryBoardDto> inquiryList = new CustomerService().selectInquiryList(pi, userNo); // 페이지 정보, 회원번호로 전달된 cpage(현재페이지)에 보일 게시글 목록을 추출
		
		
		if(inquiryList != null) {
			request.setAttribute("inquiryList", inquiryList);
			System.out.println(inquiryList.size());
			request.setAttribute("pi", pi);
			request.getRequestDispatcher("views/csPage/personalInquiryPage.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("views/csPage/personalInquiryPage.jsp").forward(request, response);
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
