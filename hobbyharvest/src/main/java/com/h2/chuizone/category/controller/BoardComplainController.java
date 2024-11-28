package com.h2.chuizone.category.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h2.chuizone.category.model.dto.SelectCategoryBoardListDto;
import com.h2.chuizone.category.model.service.CategoryBoardService;
import com.h2.chuizone.category.model.service.CategoryBoardServiceImpl;
import com.h2.chuizone.common.board.model.service.BoardService;
import com.h2.chuizone.common.board.model.service.BoardServiceImpl;
import com.h2.chuizone.common.categoryboardcomplain.model.service.CategoryBoardComplainService;
import com.h2.chuizone.common.categoryboardcomplain.model.service.CategoryBoardComplainServiceImpl;
import com.h2.chuizone.common.categoryboardcomplain.model.vo.CategoryBoardComplain;
import com.h2.chuizone.member.model.vo.Member;

/**
 * Servlet implementation class BoardComplainController
 */
@WebServlet("/BoardComplain.me")
public class BoardComplainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardComplainController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = (Member)request.getSession().getAttribute("loginUser");
		int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		CategoryBoardService categoryBoardService = new CategoryBoardServiceImpl();
		CategoryBoardComplainService categoryBoardComplainService = new CategoryBoardComplainServiceImpl();
		int resultCategoryBoard = categoryBoardComplainService.selectCategoryBoardComplainByUserNo(categoryNo, member.getUserNo());
		
		if(resultCategoryBoard > 0) {
			int result = categoryBoardComplainService.deleteCategoryBoardComplain(categoryNo, member.getUserNo());
			
			if(result > 0) {
				categoryBoardService.updateCategoryBoardByComplainMinus(categoryNo);
			}
		} else {
			int result = categoryBoardComplainService.insertCategoryBoardComplain(new CategoryBoardComplain(0, member.getUserNo(), categoryNo));
			
			if(result > 0) {
				categoryBoardService.updateCategoryBoardByComplainPlus(categoryNo);
			}
		}
		
		BoardService boardService = new BoardServiceImpl();
		SelectCategoryBoardListDto selectCategoryBoardListDto = boardService.selectCategoryBoard(boardNo);
		
		response.getWriter().print(selectCategoryBoardListDto.getComplain());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
