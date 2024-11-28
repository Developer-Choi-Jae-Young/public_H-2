package com.h2.chuizone.category.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.h2.chuizone.common.category.model.service.CategoryService;
import com.h2.chuizone.common.category.model.service.CategoryServiceImpl;
import com.h2.chuizone.common.category.model.vo.Category;
import com.h2.chuizone.common.smallgroup.model.service.SmallGroupService;
import com.h2.chuizone.common.smallgroup.model.service.SmallGroupServiceImpl;
import com.h2.chuizone.common.smallgroup.model.vo.SmallGroup;
import com.h2.chuizone.common.smallgroupcategory.model.service.SmallGroupCategoryService;
import com.h2.chuizone.common.smallgroupcategory.model.service.SmallGroupCategoryServiceImpl;
import com.h2.chuizone.common.smallgroupcategory.model.vo.SmallGroupCategory;
import com.h2.chuizone.member.model.vo.Member;

/**
 * Servlet implementation class GoToCategoryWriteController
 */
@WebServlet("/categoryWrite.me")
public class GoToCategoryWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoToCategoryWriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = (Member)request.getSession().getAttribute("loginUser");
		
		if(member != null) {
			SmallGroupCategoryService smallCategoryService = new SmallGroupCategoryServiceImpl();
			CategoryService categoryService = new CategoryServiceImpl();
			SmallGroupService smallGroupService = new SmallGroupServiceImpl();
			
			List<SmallGroupCategory> smallGroupCategoryList = smallCategoryService.selectSmallGroupCategoryList();
			List<Category> categoryList = categoryService.selectCategoryList();
			List<SmallGroup> smallGroupList = smallGroupService.selectSmallGroupList();
			
			request.setAttribute("categoryList", categoryList);
			request.setAttribute("smallGroupCategoryList", smallGroupCategoryList);
			request.setAttribute("smallGroupList", smallGroupList);
						
			request.getRequestDispatcher("views/category/category-write.jsp").forward(request, response);
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
