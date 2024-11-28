<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 작성한 문의</title>
	<link rel="stylesheet" href="views/css/miPage.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
</head>
<body>
<% String contextPath = request.getContextPath(); %>
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div id="bodySection">

		<h2>1:1문의 조회</h2>

		<div class="container">

			<div class="form-group title-area" style="display: flex; justify-content: space-between;">
				<label for="title">제목</label>
				<input type="text" id="title" name="title" class="display-title" style="width:75%" value="${ myInquiry.boardTitle }" readonly/>
				<input type="text" id="wdate" name="wdate" class="display-date" value="${ myInquiry.createDate }" style="width:20%" readonly/>
			</div>
			<label for="content">내용</label>
			<c:if test="${ !empty orgFileNames }">
			<div class="file-output">
				<span>첨부파일</span>
				<ul class="scroll-list">
				<c:forEach var="i" begin="0" end="${fn:length(orgFileNames) - 1}">
					<li><a  href="<%= contextPath %>/${chgFileNames[i]}" download="${ orgFileNames[i] }">${ orgFileNames[i] }</a></li>
				</c:forEach>
				</ul>
			</div>
			</c:if>
			<div class="form-group">
				<textarea id="content" name="content" class="input-content" readonly>${ myInquiry.boardContent }</textarea>
			</div>
			<div class="button-group">
				<button class="cancel-button" onclick="deleteInquiry(${myInquiry.boardNo})">삭제</button>
				<button class="save-button" onclick="modifyInquiry(${myInquiry.boardNo})">수정</button>
			</div>


		</div>

	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
	
	<script>
		function deleteInquiry(boardNo) {
			
			location.href="" + boardNo
		}
		function modifyInquiry(boardNo) {
			location.href="" + boardNo
		}
	</script>
	
</body>
</html>