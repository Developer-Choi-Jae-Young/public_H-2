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
import com.h2.chuizone.common.memberclub.model.service.MemberClubService;
import com.h2.chuizone.common.memberclub.model.service.MemberClubServiceImpl;
import com.h2.chuizone.common.memberclub.model.vo.MemberClub;
import com.h2.chuizone.member.model.vo.Member;

/**
 * Servlet implementation class ClubJoinController
 */
@WebServlet("/joinClub.me")
public class ClubJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClubJoinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int resultCategory = 0;
		int result = 0;
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		BoardService boardService = new BoardServiceImpl();
		SelectCategoryBoardListDto selectCategoryBoardListDto = boardService.selectCategoryBoard(boardNo);
		Member member = (Member)request.getSession().getAttribute("loginUser");

		MemberClubService memberClubService = new MemberClubServiceImpl();
		result = memberClubService.insertJoinClub(new MemberClub(0, member.getUserNo(), selectCategoryBoardListDto.getClubNo()));
		
		if(result > 0) {
			CategoryBoardService categroBoardService = new CategoryBoardServiceImpl();
			resultCategory = categroBoardService.updateCategoryBoardByCurCount(selectCategoryBoardListDto.getCurrentCount() + 1, boardNo);
		}
		
		if(result > 0 && resultCategory > 0) {
			response.getWriter().print("OK");
		} else {
			response.getWriter().print("NG");
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
