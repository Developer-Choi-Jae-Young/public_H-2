package com.h2.chuizone.category.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h2.chuizone.common.memberreviewrecommand.model.service.MemberReviewRecommandService;
import com.h2.chuizone.common.memberreviewrecommand.model.service.MemberReviewRecommandServiceImpl;
import com.h2.chuizone.common.memberreviewrecommand.model.vo.MemberReviewRecommand;
import com.h2.chuizone.common.review.model.service.ReviewService;
import com.h2.chuizone.common.review.model.service.ReviewServiceImpl;
import com.h2.chuizone.member.model.vo.Member;

/**
 * Servlet implementation class ReviewRecommandController
 */
@WebServlet("/reviewRecommand.me")
public class ReviewRecommandController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewRecommandController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int resultRecommnadCnt = 0;
		
		MemberReviewRecommandService memberReviewRecommandService = new MemberReviewRecommandServiceImpl();
		ReviewService reviewService = new ReviewServiceImpl();
		Member member = (Member)request.getSession().getAttribute("loginUser");
		int reviewNo = Integer.parseInt(request.getParameter("reviewNo"));
		int result = memberReviewRecommandService.selectMemberReviewRecommand(reviewNo, member.getUserNo());

		if(result > 0) {
			int resultMemberReviewRecommand = memberReviewRecommandService.deleteMemberReviewRecommand(reviewNo, member.getUserNo());

			if(resultMemberReviewRecommand > 0) {
				int recommandNo = reviewService.selectReviewByRecommand(reviewNo);
				int recommandUpdate = reviewService.updateReview(recommandNo - 1, reviewNo);
				
				if(recommandUpdate > 0) {
					resultRecommnadCnt = recommandNo - 1;
				} else {
					resultRecommnadCnt = recommandNo;
				}
			}
		} else {
			int resultMemberReviewRecommand = memberReviewRecommandService.insertMemberReviewRecommand(new MemberReviewRecommand(0, reviewNo, member.getUserNo()));
			
			if(resultMemberReviewRecommand > 0) {
				int recommandNo = reviewService.selectReviewByRecommand(reviewNo);
				int recommandUpdate = reviewService.updateReview(recommandNo + 1, reviewNo);
				
				if(recommandUpdate > 0) {
					resultRecommnadCnt = recommandNo + 1;
				} else {
					resultRecommnadCnt = recommandNo;
				}
			}
		}
		
		response.getWriter().print(resultRecommnadCnt);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
