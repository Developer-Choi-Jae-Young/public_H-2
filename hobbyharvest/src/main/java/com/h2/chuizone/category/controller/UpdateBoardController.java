package com.h2.chuizone.category.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.h2.chuizone.category.model.dto.SelectCategoryBoardListDto;
import com.h2.chuizone.category.model.service.CategoryBoardService;
import com.h2.chuizone.category.model.service.CategoryBoardServiceImpl;
import com.h2.chuizone.common.board.model.service.BoardService;
import com.h2.chuizone.common.board.model.service.BoardServiceImpl;
import com.h2.chuizone.common.category.model.service.CategoryService;
import com.h2.chuizone.common.category.model.service.CategoryServiceImpl;
import com.h2.chuizone.common.category.model.vo.Category;
import com.h2.chuizone.common.club.model.service.ClubService;
import com.h2.chuizone.common.club.model.service.ClubServiceImpl;
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
 * Servlet implementation class UpdateBoardController
 */
@WebServlet("/updateBoard.me")
@MultipartConfig
public class UpdateBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		Member member = (Member)request.getSession().getAttribute("loginUser");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		String title = request.getParameter("title");
		String category = request.getParameter("board_category");
		String smallGroup = request.getParameter("board_group");
		int maxHeadCnt = Integer.parseInt(request.getParameter("board_max_headcnt"));
		String content = request.getParameter("content");
		String fileName = request.getParameter("file-name");	
				
		SmallGroupService smallGroupService = new SmallGroupServiceImpl();
		CategoryService categoryService = new CategoryServiceImpl();
		SmallGroupCategoryService smallGroupCategoryService = new SmallGroupCategoryServiceImpl();
		
		SmallGroup resultSmallGroup = smallGroupService.selectSmallGroup(smallGroup);
		Category resultCategory = categoryService.selectCategory(category);
		
		SmallGroupCategory smallGroupCategory = smallGroupCategoryService.selectSmallGroupCategory(new SelectGroupCategoryDto(resultSmallGroup.getSmallGroupNo(), resultCategory.getCategoryNo()));
		
		BoardService boardService = new BoardServiceImpl();
		CategoryBoardService categoryBoardService = new CategoryBoardServiceImpl();
		ClubService clubService = new ClubServiceImpl();
		SelectCategoryBoardListDto selectCategoryBoardListDto = boardService.selectCategoryBoard(boardNo);
		
		int boardRsult = 0;
		int categoryBoardResult = 0;
		int clubResult = 0;
		
		if(member != null) {			
			boardRsult = boardService.updateBoard(boardNo, content, title);
			
			fileName = FileUploadTemplate.getFileName(fileName); 
			categoryBoardResult = categoryBoardService.updateCategoryBoard(selectCategoryBoardListDto.getCategoryBoardNo(), smallGroupCategory.getSmallGroupCategoryNo(), "resources\\upload\\" + fileName, maxHeadCnt);
			clubResult = clubService.updateClub(selectCategoryBoardListDto.getClubNo(), title);
		}
		
		if(boardRsult > 0 && categoryBoardResult > 0 && clubResult > 0) {
			Part part = request.getPart("board-file"); //part타입으로 업로드된 파일을 받아온다.
			if(!fileName.isEmpty()) {	
				String uploadPath = getServletContext().getRealPath("/resources/upload/");
				FileUploadTemplate.fileUpload(uploadPath+fileName, part);
			}
			
			request.getSession().setAttribute("alertMsg", "게시글 수정하였습니다.");
			request.getRequestDispatcher("category.me").forward(request, response);
		} else {
			request.getSession().setAttribute("alertMsg", "게시글 수정에 실패하였습니다.");
			request.getRequestDispatcher("category.me").forward(request, response);
		}
	}

}
