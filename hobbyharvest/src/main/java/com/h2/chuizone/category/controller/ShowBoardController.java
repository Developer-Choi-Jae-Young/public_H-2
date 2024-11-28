package com.h2.chuizone.category.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import com.h2.chuizone.common.bookcategory.model.service.BookCategoryService;
import com.h2.chuizone.common.bookcategory.model.service.BookCategoryServiceImpl;
import com.h2.chuizone.common.categoryboardcomplain.model.service.CategoryBoardComplainService;
import com.h2.chuizone.common.categoryboardcomplain.model.service.CategoryBoardComplainServiceImpl;
import com.h2.chuizone.common.categoryboardrecommand.model.service.CategoryBoardRecommandService;
import com.h2.chuizone.common.categoryboardrecommand.model.service.CategoryBoardRecommandServiceImpl;
import com.h2.chuizone.common.memberclub.model.service.MemberClubService;
import com.h2.chuizone.common.memberclub.model.service.MemberClubServiceImpl;
import com.h2.chuizone.common.memberreviewrecommand.model.service.MemberReviewRecommandService;
import com.h2.chuizone.common.memberreviewrecommand.model.service.MemberReviewRecommandServiceImpl;
import com.h2.chuizone.common.reply.model.dto.ReplyDto;
import com.h2.chuizone.common.reply.model.service.ReplyService;
import com.h2.chuizone.common.reply.model.service.ReplyServiceImpl;
import com.h2.chuizone.common.review.model.dto.ReviewDto;
import com.h2.chuizone.common.review.model.service.ReviewService;
import com.h2.chuizone.common.review.model.service.ReviewServiceImpl;
import com.h2.chuizone.member.model.vo.Member;
import com.h2.chuizone.template.ReplyLogic;

/**
 * Servlet implementation class showBoardController
 */
@WebServlet("/showBoard.me")
public class ShowBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = (Member)request.getSession().getAttribute("loginUser");
		
		if(member != null) {
			int board_id = Integer.parseInt(request.getParameter("board_id"));
			request.setAttribute("board_id", board_id);
			
			BoardService boardService = new BoardServiceImpl();
			SelectCategoryBoardListDto selectCategoryBoardListDto = boardService.selectCategoryBoard(board_id);
	
			ReplyService replyService = new ReplyServiceImpl();
			List<ReplyDto> replyList = replyService.selectReplyList(board_id);
			List<ReplyDto> dstList = new ArrayList<>();
			
			ReplyLogic replyLogic = new ReplyLogic();
			replyLogic.Reply(replyList, dstList, replyLogic.getCommentList(replyList, 0), 1);
			request.setAttribute("reply", dstList);

			if(member.getUserNo() == selectCategoryBoardListDto.getMemberNo()) {
				request.setAttribute("owner", true);
			} else {
				request.setAttribute("owner", false);
			}
			
			MemberClubService memberClubService = new MemberClubServiceImpl();
			List<Integer> clubId = memberClubService.selectJoinClub(member.getUserNo());
			
			boolean isClubId = false;
			
			if(clubId != null) {
				for(Integer i : clubId) {
					if(i == selectCategoryBoardListDto.getClubNo()) {
						isClubId = true;
						break;
					} else {
						isClubId = false;
					}
				}
			}
			
			CategoryBoardService categoryBoardService = new CategoryBoardServiceImpl();
			categoryBoardService.updateCategoryBoardByView(selectCategoryBoardListDto.getViews() + 1, board_id);
			
			ReviewService reviewService = new ReviewServiceImpl();
			List<ReviewDto> reviewList = reviewService.selectReviewList(board_id);
			
			for(ReviewDto review : reviewList) {
				MemberReviewRecommandService memberReviewRecommandService = new MemberReviewRecommandServiceImpl();
				int result = memberReviewRecommandService.selectMemberReviewRecommand(review.getReviewNo(), member.getUserNo());
				
				if(result > 0) {
					review.setRecommandFlag(true);
				}
			}
			
			CategoryBoardRecommandService categoryBoardRecommandService = new CategoryBoardRecommandServiceImpl();
			int resultCategoryBoardRecommand = categoryBoardRecommandService.selectCategoryBoardRecommandByUserNo(selectCategoryBoardListDto.getCategoryBoardNo(), member.getUserNo());
			CategoryBoardComplainService categoryBoardComplainService = new CategoryBoardComplainServiceImpl();
			int resultCategoryBoardComplain = categoryBoardComplainService.selectCategoryBoardComplainByUserNo(selectCategoryBoardListDto.getCategoryBoardNo(), member.getUserNo());
			BookCategoryService bookCategoryService = new BookCategoryServiceImpl();
			int resultCategoryBoardScrap = bookCategoryService.selectBookCategoryByUserNo(selectCategoryBoardListDto.getCategoryBoardNo(), member.getUserNo());
			
			if(resultCategoryBoardRecommand > 0) {
				request.setAttribute("recommandImg", true);
			} else {
				request.setAttribute("recommandImg", false);
			}
			
			if(resultCategoryBoardComplain > 0) {
				request.setAttribute("complainImg", true);
			} else {
				request.setAttribute("complainImg", false);
			}

			if(resultCategoryBoardScrap > 0) {
				request.setAttribute("scrapImg", true);
			} else {
				request.setAttribute("scrapImg", false);
			}
			
			request.setAttribute("review", reviewList);
			request.setAttribute("join", isClubId);
			request.setAttribute("board_data", selectCategoryBoardListDto);
			
			request.getRequestDispatcher("views/category/category-view.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/login.me").forward(request, response);
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
