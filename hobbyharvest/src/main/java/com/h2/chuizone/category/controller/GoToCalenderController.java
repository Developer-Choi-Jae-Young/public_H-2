package com.h2.chuizone.category.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h2.chuizone.calender.model.dto.CalenderDto;
import com.h2.chuizone.calender.model.service.CalenderService;
import com.h2.chuizone.calender.model.service.CalenderServiceImpl;
import com.h2.chuizone.category.model.dto.SelectCategoryBoardListDto;
import com.h2.chuizone.common.board.model.service.BoardService;
import com.h2.chuizone.common.board.model.service.BoardServiceImpl;

/**
 * Servlet implementation class goToCalenderController
 */
@WebServlet("/calender.me")
public class GoToCalenderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoToCalenderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int categoryBoardNo = Integer.parseInt(request.getParameter("categoryBoardNo"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		CalenderService calenderService = new CalenderServiceImpl();
		BoardService boardService = new BoardServiceImpl();
		
		SelectCategoryBoardListDto selectCategoryBoardListDto = boardService.selectCategoryBoard(boardNo);
		List<CalenderDto> calenderDtoList = calenderService.selectCalenderBoardList(categoryBoardNo);
		
		request.setAttribute("clubName", selectCategoryBoardListDto.getClubName());
		request.setAttribute("categoryBoardNo", categoryBoardNo);
		request.setAttribute("calender", calenderDtoList);
		request.setAttribute("boardNo", boardNo);
		
		request.getRequestDispatcher("views/calender/calender.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
