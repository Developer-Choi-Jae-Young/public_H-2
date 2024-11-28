<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	img {
		width: 100%;
		height: 100%;
	}
	#bestClub { display: flex; 
				justify-content: center;
				align-items: center;
	}
	
</style>
</head>
<body>

	<jsp:include page="common/header.jsp" />
	<br>
	<br>
	<h3 align="center" style="font-weight: 900; color: #4c4242;">Best Club</h3>
		<div id="bestClub">
			<%@ include file="category/category-item.jsp" %>
		</div>
		<div id="bestReview">
			<%@ include file="homepage/bestReview.jsp" %>
		</div>

	<img src="views/common/img/main.png">
	<img src="views/common/img/main2.png">
	
	<jsp:include page="common/footer.jsp" />

</body>
</html>