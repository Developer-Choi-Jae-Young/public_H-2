package com.h2.chuizone.category.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h2.chuizone.category.model.service.CategoryBoardService;
import com.h2.chuizone.category.model.service.CategoryBoardServiceImpl;
import com.h2.chuizone.common.bookcategory.model.service.BookCategoryService;
import com.h2.chuizone.common.bookcategory.model.service.BookCategoryServiceImpl;
import com.h2.chuizone.common.bookcategory.model.vo.BookCategory;
import com.h2.chuizone.member.model.vo.Member;

/**
 * Servlet implementation class BoardScrapController
 */
@WebServlet("/BoardScrap.me")
public class BoardScrapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardScrapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = (Member)request.getSession().getAttribute("loginUser");
		int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
		
		CategoryBoardService categoryBoardService = new CategoryBoardServiceImpl();
		BookCategoryService bookCategoryService = new BookCategoryServiceImpl();
		int resultCategoryBoard = bookCategoryService.selectBookCategoryByUserNo(categoryNo, member.getUserNo());
		
		String responseData = "";
		
		if(resultCategoryBoard > 0) {
			int result = bookCategoryService.deleteBookCategory(categoryNo, member.getUserNo());
			
			if(result > 0) {
				responseData = "unCheck";
			}
		} else {
			int result = bookCategoryService.insertBookCategory(new BookCategory(0, member.getUserNo(), categoryNo));
			
			if(result > 0) {
				responseData = "check";
			}
		}
		
		response.getWriter().print(responseData);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
