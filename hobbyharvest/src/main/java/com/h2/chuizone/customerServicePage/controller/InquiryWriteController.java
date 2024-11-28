package com.h2.chuizone.customerServicePage.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.h2.chuizone.customerServicePage.model.dto.InquiryBoardDto;
import com.h2.chuizone.customerServicePage.model.service.CustomerService;

/**
 * Servlet implementation class inquiryWriteController
 */

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 50 * 5)
@WebServlet("/inquiry.do")
public class InquiryWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InquiryWriteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 1:1문의 게시글 작성글을 저장하는 서블릿
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userNo = request.getParameter("userNo");
		String kindOfBoard = request.getParameter("kindOfBoard");		// 게시글 종류(소모임 게시글, 공지사항 게시글, 1:1문의 게시글 등...)
		String inquiryGroup = request.getParameter("inquiryGroup");		// 문의 분류(계정관련 문의, 소모임 이용관련 문의 등등 ...)
		String inquiryTitle = request.getParameter("inquiryTitle");		
		String inquiryContent = request.getParameter("inquiryContent");
		Collection<Part> parts = request.getParts();					// Part객체는 enctype="multipart/form-data" 속성을 가진 form 태그에서 전달된 모든 속성(문자열뿐만 아니라 파일 객체까지도)을 받음
		String path = request.getServletContext().getRealPath("/resources/uploadFiles/");	// 첨부된 파일을 저장할 실제 컴퓨터의 경로를 추출 (C://...)
		StringBuilder originFileNames = new StringBuilder();	
		StringBuilder changeFileNames = new StringBuilder();
		int i = 0;
		int result;

		
		for (Part part : parts) {
			// 사용자로부터 요청을 모두 Part타입으로 받기 때문에(첨부파일인지 아닌지 상관없이)
			// 객체에서 name을 추출해서 upfile(첨부파일 input의 name)이 아닐 경우 continue;
			if (!part.getName().equals("upfile"))
				continue;
			// 2차로 name = upfile의 value일 때 제출된 파일명을 확인하여 ""(첨부파일이 없을 시 빈 문자열로 옴)
			// 가 아닐 경우 첨부파일 처리절차 실행
			if(!part.getSubmittedFileName().isEmpty()) {
				
				int num;
				byte[] buf = new byte[1024];
				String originFileName = part.getSubmittedFileName();

				// 파읾명 변환
				// 1) 파일 업로드 시간(년월일시분초)
				String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				// 2) 5자리 랜덤값 : Math.random()
				int randNum = (int) (Math.random() * 90000 + 10000);

				// 3) 원본 파일의 확장자
				// 문자열 .substring(마지막 .의 취지)
				String ext = originFileName.substring(originFileName.lastIndexOf("."));
				// 업로드 시간(밀리초 단위) + 랜덤값(5자리) + 확장자
				String changeFileName = currentTime + randNum + ext;

				// 첨부된 파일 객체에서 inputStream을 얻고, 실제 파일을 저장할 물리적 경로(path)와 변환 파일명을 합하여 outputStream을 얻어 읽은 내용을 경로상에 저장
				try (BufferedInputStream bis = new BufferedInputStream(part.getInputStream());
						BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + changeFileName))) {
					while ((num = bis.read(buf)) != -1) {
						bos.write(buf, 0, num);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				// DB에 저장하는 변환 파일명은 1:1문의 게시글 조회 페이지에서 첨부파일을 다운로드 할 수 있도록(추후 (contextPath/)resources/upFiles/chageName으로 다운로드 링크를 얻을 수 있도록 저장)
				if(!originFileName.isEmpty() && !changeFileName.isEmpty() ) {
					originFileNames.append(originFileName);
					originFileNames.append(",");	// 첨부파일이 여러개일 시 ","로 구분하여 저장
					changeFileNames.append("resources/uploadFiles/" + changeFileName); // 저장된 물리경로 + 변환된 첨부파일명
					changeFileNames.append(",");
				}
				
			}
			
			
		}
		
		// 맨 끝에 붙은 "," 구분자 제거
		if(originFileNames.length()>0 && changeFileNames.length()>0) {
			originFileNames.delete(originFileNames.length() - 1, originFileNames.length());
			changeFileNames.delete(changeFileNames.length() - 1, changeFileNames.length());
		}
		
		// Board테이블에 저장할 데이터 담음
		InquiryBoardDto b = new InquiryBoardDto();
		b.setUserNo(userNo);
		b.setKindOfBoard(kindOfBoard);
		b.setBoardTitle(inquiryTitle);
		b.setBoardContent(inquiryContent);
		
		// Inquiry 테이블에 저장할 데이터 담음
		InquiryBoardDto b1 = new InquiryBoardDto();
		b1.setInquiryGroup(inquiryGroup);
		b1.setKindOfBoard(kindOfBoard);
		b1.setOriginFileNames(originFileNames.toString());
		b1.setChangeFileNames(changeFileNames.toString());
		
		// Board 테이블과 inquiry 테이블에 각각 insert 수행 후 반환된 boardNo값과 inquiryNo값을 두 테이블의 연결테이블인 BoardInquiry테이블에 담기 위해 각각 구분하여 전달
		result = new CustomerService().insertInquiryBoard(b, b1);
		
		
		if(result > 0) {
			request.setAttribute("userNo", userNo);
			request.getSession().setAttribute("alertMsg", "요청이 성공적으로 전달되었습니다.");
			request.getRequestDispatcher("toPiPage.do").forward(request, response);
		} else {
			request.getSession().setAttribute("alertMsg", "1:1문의 게시에 실패했습니다. 다시 시도해주세요.");
			request.getRequestDispatcher("views/csPage/personalInquiryPage.jsp").forward(request, response);
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
