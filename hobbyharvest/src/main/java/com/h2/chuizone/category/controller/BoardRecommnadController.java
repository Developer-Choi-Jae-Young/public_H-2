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
import com.h2.chuizone.common.categoryboardrecommand.model.service.CategoryBoardRecommandService;
import com.h2.chuizone.common.categoryboardrecommand.model.service.CategoryBoardRecommandServiceImpl;
import com.h2.chuizone.common.categoryboardrecommand.model.vo.CategoryBoardRecommand;
import com.h2.chuizone.member.model.vo.Member;

/**
 * Servlet implementation class BoardRecommnadController
 */
@WebServlet("/BoardRecommand.me")
public class BoardRecommnadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardRecommnadController() {
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
		CategoryBoardRecommandService categoryBoardRecommandService = new CategoryBoardRecommandServiceImpl();
		int resultCategoryBoard = categoryBoardRecommandService.selectCategoryBoardRecommandByUserNo(categoryNo, member.getUserNo());

		if(resultCategoryBoard > 0) {
			int result = categoryBoardRecommandService.deleteCategoryBoardRecommand(categoryNo, member.getUserNo());

			if(result > 0) {
				categoryBoardService.updateCategoryBoardByRecommandMinus(categoryNo);
			}
		} else {
			int result = categoryBoardRecommandService.insertCategoryBoardRecommand(new CategoryBoardRecommand(0, member.getUserNo(), categoryNo));

			if(result > 0) {
				categoryBoardService.updateCategoryBoardByRecommandPlus(categoryNo);
			}
		}
		
		BoardService boardService = new BoardServiceImpl();
		SelectCategoryBoardListDto selectCategoryBoardListDto = boardService.selectCategoryBoard(boardNo);
		
		response.getWriter().print(selectCategoryBoardListDto.getRecommandNo());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
