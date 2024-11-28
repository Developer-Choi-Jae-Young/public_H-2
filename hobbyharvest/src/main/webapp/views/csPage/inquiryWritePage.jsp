<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1문의 작성</title>
	<link rel="stylesheet" href="views/css/iwPage.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
<div id="bodySection">
	
	<h2>1:1문의 작성</h2>
	
	<div class="container">
	<form action="inquiry.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name = "userNo" value = "${ loginUser.userNo }"/>
	<input type="hidden" name = "kindOfBoard" value = "10"/>
		<div class="form-group">
				<label for="title">제목</label>
				<input type="text" id="title" name="inquiryTitle" class="input-title" />
		</div>
		<label for="content">내용</label>
		<div class="file-input">
			<label for="fileUpload">첨부파일1</label>
			<input type="file" id="fileUpload" name="upfile"/>
		</div>
		<div class="file-input">
			<label for="fileUpload">첨부파일2</label>
			<input type="file" id="fileUpload" name="upfile"/>
		</div>
		<div>
			<label for="kind-of-inquiry">문의분류</label>
			<select id="kind-of-inquiry" name="inquiryGroup">
				<option value="1">계정 관련 문의</option>
				<option value="2">불편사항 관련 문의</option>
				<option value="3">소모임 관련 문의</option>
			</select>
		</div>
		<div class="form-group">
				<textarea id="content" name="inquiryContent" class="input-content"></textarea>
		</div>
		<div class="button-group">
				<button class="cancel-button" onclick="history.go(-1)">취소</button>
				<button class="save-button">저장</button>
		</div>
		</form>
	</div>

	
</div>



<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>