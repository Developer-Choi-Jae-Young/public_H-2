<%@page import="com.h2.chuizone.common.Pageing"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="page.me">
		<div id="pageing">
			<c:choose>
				<c:when test="${ pageing.currentPage <= 1 }">
					<button id="page-disable-previous" name="page"
					value=${ pageing.currentPage } disabled>← Previous</button>
				</c:when>
				<c:otherwise>
					<button id="page-enable-previous" name="page"
					value=${ pageing.currentPage - 1 }>← Previous</button>
				</c:otherwise>
			</c:choose>
			
			<c:forEach var="i" begin="${ pageing.stPageingNum }"
			 end="${ pageing.endPageingNum }">
				<c:choose>
					<c:when test="${ i == pageing.currentPage}">
						<button id="page-selected-number" name="page" value=${ i } disabled>${ i }</button>
					</c:when>
					<c:otherwise>
						<button id="page-nomal-number" name="page" value=${ i }>${ i }</button>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<c:choose>
				<c:when test="${pageing.currentPage == pageing.maxPage}">
					<button id="page-disable-next" name="page"
					value=${ pageing.currentPage } disabled>Next →</button>
				</c:when>
				<c:otherwise>
					<button id="page-enable-previous" name="page"
					value=${ pageing.currentPage + 1 }>Next →</button>
				</c:otherwise>
			</c:choose>
		</div>
	</form>
</body>
</html>