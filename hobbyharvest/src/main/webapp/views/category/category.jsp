<%@page import="com.h2.chuizone.common.Pageing"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<style>
#category-menu {
	border: none;
	height: 70px;
	width: 1500px;
	border-radius: 20px;
	background-color: #ffe3e3;
	margin: auto;
	margin-top: 30px;
	display: flex;
	justify-content: center;
	align-items: center;
}

#boarder-area {
	width: 1500px;
	margin: auto;
	margin-top: 30px;
}

#board-section {
	/*height: 90%;*/
	width: 100%;
	display: flex;
	flex-direction: row;
	flex-wrap: wrap;
	justify-content: center;
}

#board {
	height: 40%;
	width: 15%;
	padding-top: 10px;
	padding-bottom: 10px;
	border: 1px solid #d9d9d9;
	border-radius: 10px;
	margin: 20px;
	cursor: pointer;
}

#board-img {
	background-color: white;
	height: 70%;
	width: 90%;
	margin: auto;
	margin-top: 5%;
	margin-bottom: 5%;
	border-radius: 10px;
}

#board-info {
	background-color: white;
	height: 20%;
	width: 90%;
	margin: auto;
	margin-top: 5%;
	margin-bottom: 5%;
	border-radius: 10px;
}

#board-info-section {
	height: 10%;
	width: 90%;
	margin: auto;
}

#search {
	width: 30%;
	height: 50%;
	float: left;
	margin: 20px;
}

#pageing {
	width: 30%;
	height: 50%;
	float: left;
	display: flex;
	margin: 20px;
	align-items: center;
}

#btn-write {
	width: 30%;
	height: 45px;
	border-radius: 10px;
	border: 1px solid rgb(118, 118, 118);
	float: left;
	margin: 20px;
}

#page-enable-previous {
	margin-right: 10px;
	cursor: pointer;
	background-color: transparent;
	border: none;
}

#page-disable-previous {
	margin-right: 10px;
	color: rgb(186, 186, 186);
	cursor: default;
	background-color: transparent;
	border: none;
}

#page-enable-next {
	margin-left: 5px;
	cursor: pointer;
	background-color: transparent;
	border: none;
}

#page-disable-next {
	margin-left: 5px;
	cursor: default;
	color: rgb(186, 186, 186);
	background-color: transparent;
	border: none;
}

#page-nomal-number {
	height: 20px;
	width: 20px;
	text-align: center;
	border-radius: 5px;
	line-height: 20px;
	margin-right: 5px;
	border: none;
	background-color: transparent;
	cursor: pointer
}

#page-selected-number {
	height: 20px;
	width: 20px;
	border: 1px solid rgb(44, 44, 44);
	text-align: center;
	border-radius: 5px;
	line-height: 20px;
	margin-right: 5px;
	background-color: rgb(44, 44, 44);
	color: white;
	cursor: default;
}

#btn-search-icon {
	height: 40px;
	width: 60px;
	border: 1px solid;
	border-top-right-radius: 10px;
	border-bottom-right-radius: 10px;
	background-image:
		url(https://cdn-icons-png.flaticon.com/512/13/13267.png);
	background-size: 30px;
	background-repeat: no-repeat;
	background-position: center;
}

#search-content {
	box-sizing: border-box;
	height: 40px;
	border-top-left-radius: 10px;
	border-bottom-left-radius: 10px;
	float: left;
}

.float-left-style {
	float: left;
}

.padding-5px {
	padding: 5px;
}

.height-20percent {
	height: 20%;
}

.height-60percent {
	height: 60%;
}

.text-align-right {
	text-align: right;
}

.board-img {
	width: 100%;
	height: 100%;
}

.category-frame {
	margin: 0px 10px;
	font-size: 18pt;
	width: 20%;
	text-align: center;
	cursor: pointer;
}
</style>
</head>
<body>
	<%
	Pageing pageing = (Pageing) request.getAttribute("pageing");
	%>
	<jsp:include page="../common/header.jsp" />

	<div id="category-menu">
		<c:forEach var="cate" items="${ category }">
			<div class="category-frame" onclick="goToCategory(${ cate.categoryNo });">${ cate.categoryName }</div>
		</c:forEach>
	</div>

	<div id="boarder-area">
		<div id="board-section">
			<%@ include file="category-item.jsp"%>
		</div>

		<div id="board-info-section">
			<div id="search">
				<input id="search-content" type="text" placeholder="Search...">
				<button id="btn-search-icon" onclick="searchCategory(${ categoryNo });"></button>
			</div>

			<%@ include file="pageing.jsp"%>

			<button id="btn-write" onclick="boardWrite();">글쓰기</button>
		</div>
	</div>
	<br><br><br><br><br><br>
	<jsp:include page="../common/footer.jsp" />

	<script>
		function boardWrite() {
			location.href = "categoryWrite.me";
		}
		
		function goToCategory(categoryId) {
			location.href = "selectBoardList.me?page=1&categoryNo=" + categoryId;
		}
		
		function searchCategory(categoryId) {
			location.href = "selectBoardList.me?page=1&categoryNo=" + categoryId + "&keyword=" + $('#search-content').val();
		}
	</script>
</body>
</html>