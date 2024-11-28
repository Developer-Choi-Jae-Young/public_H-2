package com.h2.chuizone.category.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h2.chuizone.category.model.dto.SelectCategoryBoardListDto;
import com.h2.chuizone.category.model.service.CategoryBoardService;
import com.h2.chuizone.category.model.service.CategoryBoardServiceImpl;
import com.h2.chuizone.common.Pageing;
import com.h2.chuizone.common.board.model.service.BoardService;
import com.h2.chuizone.common.board.model.service.BoardServiceImpl;
import com.h2.chuizone.common.category.model.service.CategoryService;
import com.h2.chuizone.common.category.model.service.CategoryServiceImpl;
import com.h2.chuizone.common.category.model.vo.Category;

/**
 * Servlet implementation class selectBoardListController
 */
@WebServlet("/selectBoardList.me")
public class SelectBoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectBoardListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		CategoryBoardService categoryBoardService = new CategoryBoardServiceImpl();
		BoardService boardService = new BoardServiceImpl();
		CategoryService categoryService = new CategoryServiceImpl();
		
		int curPage = 0;
		int categoryNo = 0;
		String keyword = "";
		
		if(request.getParameter("page") != null) {
			curPage = Integer.parseInt(request.getParameter("page"));
		} else {
			curPage  = 1;
		}
		
		if(request.getParameter("categoryNo") != null) {
			categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
		} else {
			categoryNo  = 1;
		}
		
		request.setAttribute("categoryNo", categoryNo);
		
		
		if(request.getParameter("keyword") != null) {
			keyword = request.getParameter("keyword");
		} else {
			keyword  = "";
		}
		
		int maxBoardNum = categoryBoardService.selectMaxPageNumber(categoryNo, keyword);
		List<SelectCategoryBoardListDto> boardList = boardService.selectCategoryBoardList((curPage - 1) * 10 + 1, curPage * 10, categoryNo, keyword);

		if(request.getAttribute("page") != null) {
			request.setAttribute("pageing", 
									new Pageing(maxBoardNum,  curPage));
			request.setAttribute("board", 
					boardList);
		} else {
			request.setAttribute("pageing", 
					new Pageing(maxBoardNum, curPage));
			request.setAttribute("board", 
					boardList);
		}
		
		List<Category> categoryList = categoryService.selectCategoryList();
		request.setAttribute("category", categoryList);
		
		request.getRequestDispatcher("views/category/category.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
