package com.h2.chuizone.calender.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h2.chuizone.calender.model.service.CalenderService;
import com.h2.chuizone.calender.model.service.CalenderServiceImpl;
import com.h2.chuizone.calender.model.vo.Calender;
import com.h2.chuizone.common.board.model.service.BoardService;
import com.h2.chuizone.common.board.model.service.BoardServiceImpl;
import com.h2.chuizone.common.board.model.vo.Board;
import com.h2.chuizone.common.boardcalender.model.service.BoardCalenderService;
import com.h2.chuizone.common.boardcalender.model.service.BoardCalenderServiceImpl;
import com.h2.chuizone.common.boardcalender.model.vo.BoardCalender;
import com.h2.chuizone.common.calendercategoryboard.model.service.CalenderCategoryBoardService;
import com.h2.chuizone.common.calendercategoryboard.model.service.CalenderCategoryBoardServiceImpl;
import com.h2.chuizone.common.calendercategoryboard.model.vo.CalenderCategoryBoard;
import com.h2.chuizone.common.kindofboard.model.service.KindOfBoardService;
import com.h2.chuizone.common.kindofboard.model.service.KindOfBoardServiceImpl;
import com.h2.chuizone.common.kindofboard.model.vo.KindOfBoard;
import com.h2.chuizone.member.model.vo.Member;

/**
 * Servlet implementation class WriteCalenderController
 */
@WebServlet("/writeCalender.me")
public class WriteCalenderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteCalenderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int categoryBoardNo = Integer.parseInt(request.getParameter("categoryBoardNo"));
		Date startDate = Date.valueOf(request.getParameter("startDate"));
		Date endDate = Date.valueOf(request.getParameter("endDate"));
		Member member = (Member)request.getSession().getAttribute("loginUser");
		int cboardNo = Integer.parseInt(request.getParameter("cboardNo"));
		
		CalenderService calenderService = new CalenderServiceImpl();
		BoardService boardService = new BoardServiceImpl();
		BoardCalenderService boardCalenderService = new BoardCalenderServiceImpl();
		CalenderCategoryBoardService calenderCategoryBoardService = new CalenderCategoryBoardServiceImpl();
		KindOfBoardService kindOfBoardService = new KindOfBoardServiceImpl();
		
		int resultCalender = 0;
		int resultBoard = 0;
		int resultBoardCalender = 0;
		int resultCalenderCategoryBoard = 0;
		int kindOfBoardId = 0;
		
		List<KindOfBoard> kindOfBoardList = kindOfBoardService.selectKindOfBoardList();
		
		for(KindOfBoard kindOfBoard : kindOfBoardList) {
			if(kindOfBoard.getKindOfBoardName().equals("캘린더")) {
				kindOfBoardId = kindOfBoard.getKindOfBoardNo();
				break;
			}
		}
		
		Calender calender = new Calender(0, kindOfBoardId, startDate, endDate);
		resultCalender = calenderService.insertCalender(calender);
		
		Board board = new Board(0, member.getUserNo(), kindOfBoardId, title, null, content);
		resultBoard = boardService.insertBoard(board);
		
		if(resultCalender > 0 && resultBoard > 0) {
			BoardCalender boardCalender = new BoardCalender(0, board.getBoardNo(), calender.getCalenderNo());
			resultBoardCalender = boardCalenderService.insertBoardCalender(boardCalender);
			
			CalenderCategoryBoard calenderCategoryBoard = new CalenderCategoryBoard(0, categoryBoardNo, calender.getCalenderNo());
			resultCalenderCategoryBoard = calenderCategoryBoardService.insertCalenderCategoryBoard(calenderCategoryBoard);
		}
		
		if(resultCalender > 0 && resultBoard > 0 && resultBoardCalender > 0 && resultCalenderCategoryBoard > 0) {
			
			request.getSession().setAttribute("alertMsg", "일정을 작성하였습니다.");
			response.sendRedirect("calender.me?categoryBoardNo=" + categoryBoardNo + "&boardNo=" + cboardNo);
		} else {
			// 작성 실패
			request.getSession().setAttribute("alertMsg", "일정 작성에 실패하였습니다.");
			response.sendRedirect("calender.me?categoryBoardNo=" + categoryBoardNo + "&boardNo=" + cboardNo);			
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
