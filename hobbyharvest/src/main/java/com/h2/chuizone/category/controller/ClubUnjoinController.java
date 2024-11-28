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
import com.h2.chuizone.common.board.model.service.BoardService;
import com.h2.chuizone.common.board.model.service.BoardServiceImpl;
import com.h2.chuizone.common.board.model.vo.Board;
import com.h2.chuizone.common.boardreview.model.service.BoardReviewService;
import com.h2.chuizone.common.boardreview.model.service.BoardReviewServiceImpl;
import com.h2.chuizone.common.boardreview.model.vo.BoardReview;
import com.h2.chuizone.common.kindofboard.model.service.KindOfBoardService;
import com.h2.chuizone.common.kindofboard.model.service.KindOfBoardServiceImpl;
import com.h2.chuizone.common.kindofboard.model.vo.KindOfBoard;
import com.h2.chuizone.common.memberclub.model.service.MemberClubService;
import com.h2.chuizone.common.memberclub.model.service.MemberClubServiceImpl;
import com.h2.chuizone.common.memberclub.model.vo.MemberClub;
import com.h2.chuizone.common.review.model.service.ReviewService;
import com.h2.chuizone.common.review.model.service.ReviewServiceImpl;
import com.h2.chuizone.common.review.model.vo.Review;
import com.h2.chuizone.member.model.vo.Member;

/**
 * Servlet implementation class ClubUnjoinController
 */
@WebServlet("/unjoinClub.me")
public class ClubUnjoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClubUnjoinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int resultCategory = 0;
		int result = 0;
		int kindOfBoardId = -1;
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String title = request.getParameter("title");
		int starPoint = Integer.parseInt(request.getParameter("starpoint"));
		String content = request.getParameter("content");

		KindOfBoardService kindOfBoardService = new KindOfBoardServiceImpl();
		List<KindOfBoard> kindOfBoardList = kindOfBoardService.selectKindOfBoardList();
		
		for(KindOfBoard kindOfBoard : kindOfBoardList) {
			if(kindOfBoard.getKindOfBoardName().equals("리뷰")) {
				kindOfBoardId = kindOfBoard.getKindOfBoardNo();
				break;
			}
		}
		
		Member member = (Member)request.getSession().getAttribute("loginUser");
		Board board = new Board();
		board.setMemberNo(member.getUserNo());
		board.setKindOfBoardNo(kindOfBoardId);
		board.setTitle(title);
		board.setContent(content);
		
		BoardService boardService = new BoardServiceImpl();
		int resultBoard = boardService.insertBoard(board);
		
		Review review = new Review(0, kindOfBoardId, 0, starPoint, boardNo);
		ReviewService reviewService = new ReviewServiceImpl();
		int resultReview = reviewService.insertReview(review);
		
		BoardReviewService boardReviewService = new BoardReviewServiceImpl();
		int resultBoardReview = boardReviewService.insertBoardReview(new BoardReview(0, review.getReviewNo(), board.getBoardNo()));
		
		if(resultBoard > 0 && resultReview > 0 && resultBoardReview > 0) {
			
			boardService = new BoardServiceImpl();
			SelectCategoryBoardListDto selectCategoryBoardListDto = boardService.selectCategoryBoard(boardNo);

			MemberClubService memberClubService = new MemberClubServiceImpl();
			result = memberClubService.deleteJoinClub(new MemberClub(0, member.getUserNo(), selectCategoryBoardListDto.getClubNo()));
			System.out.println(selectCategoryBoardListDto);
			if(result > 0) {
				CategoryBoardService categroBoardService = new CategoryBoardServiceImpl();
				resultCategory = categroBoardService.updateCategoryBoardByCurCount(selectCategoryBoardListDto.getCurrentCount() - 1, boardNo);
			}
			
			if(result > 0 && resultCategory > 0) {
				request.getSession().setAttribute("alertMsg", "리뷰를 작성 하였습니다.");
				response.sendRedirect(request.getContextPath());
			} else {
				request.getSession().setAttribute("alertMsg", "리뷰작성에 실패 하였습니다.");
				response.sendRedirect(request.getContextPath() + "/showBoard.me?board_id=" + boardNo);
			}
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
