package com.h2.chuizone.category.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.h2.chuizone.category.model.service.CategoryBoardService;
import com.h2.chuizone.category.model.service.CategoryBoardServiceImpl;
import com.h2.chuizone.category.model.vo.CategoryBoard;
import com.h2.chuizone.common.board.model.vo.Board;
import com.h2.chuizone.common.category.model.service.CategoryService;
import com.h2.chuizone.common.category.model.service.CategoryServiceImpl;
import com.h2.chuizone.common.category.model.vo.Category;
import com.h2.chuizone.common.smallgroup.model.service.SmallGroupService;
import com.h2.chuizone.common.smallgroup.model.service.SmallGroupServiceImpl;
import com.h2.chuizone.common.smallgroup.model.vo.SmallGroup;
import com.h2.chuizone.common.smallgroupcategory.model.dto.SelectGroupCategoryDto;
import com.h2.chuizone.common.smallgroupcategory.model.service.SmallGroupCategoryService;
import com.h2.chuizone.common.smallgroupcategory.model.service.SmallGroupCategoryServiceImpl;
import com.h2.chuizone.common.smallgroupcategory.model.vo.SmallGroupCategory;
import com.h2.chuizone.member.model.vo.Member;
import com.h2.chuizone.template.FileUploadTemplate;

/**
 * Servlet implementation class writeBoardController
 */
@WebServlet("/writeBoard.me")
@MultipartConfig
public class WriteBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WriteBoardController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Member member = (Member)request.getSession().getAttribute("loginUser");
		String title = request.getParameter("title");
		String category = request.getParameter("board_category");
		String smallGroup = request.getParameter("board_group");
		String maxHeadCnt = request.getParameter("board_max_headcnt");
		String content = request.getParameter("content");
		String fileName = request.getParameter("file-name");		
		
		if(member != null && !category.equals("카테고리")  && !smallGroup.equals("소분류")) {
			CategoryService categoryService = new CategoryServiceImpl();
			SmallGroupService smallGroupService = new SmallGroupServiceImpl();
			SmallGroupCategoryService smallGroupCategoryService = new SmallGroupCategoryServiceImpl();
			
			Category categoryObj = categoryService.selectCategory(category);
			SmallGroup smallGroupObj = smallGroupService.selectSmallGroup(smallGroup);
			SmallGroupCategory smallGroupCategoryObj = smallGroupCategoryService.selectSmallGroupCategory(new SelectGroupCategoryDto(smallGroupObj.getSmallGroupNo(), categoryObj.getCategoryNo()));
			
			CategoryBoardService categoryBoardService = new CategoryBoardServiceImpl();
			
			fileName = FileUploadTemplate.getFileName(fileName);
			int result = categoryBoardService.insertCategoryBoard(new CategoryBoard(smallGroupCategoryObj.getSmallGroupCategoryNo(), "resources\\upload\\" + fileName, Integer.parseInt(maxHeadCnt)), new Board(title, content), member.getUserNo());
			
			// DB INSERT 성공시
			if(result > 0) {
				Part part = request.getPart("board-file"); //part타입으로 업로드된 파일을 받아온다.
				if(!fileName.isEmpty()) {			
					String uploadPath = getServletContext().getRealPath("/resources/upload/");
					FileUploadTemplate.fileUpload(uploadPath+fileName, part);
				}
				
				request.getSession().setAttribute("alertMsg", "게시물을 작성 하였습니다.");
			} else {
				request.getSession().setAttribute("alertMsg", "게시물을 작성에 실패 하였습니다.");
			}
		} else {
			request.getSession().setAttribute("alertMsg", "게시물을 작성에 실패 하였습니다.");
		}
        
		request.getRequestDispatcher("/").forward(request, response);
	}
}
