<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.h2.chuizone.member.model.vo.Member"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

		<link rel="stylesheet" href="views/css/myPage.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>

</head>
<body>

	<%
	String contextPath = request.getContextPath();
	%>
	<!-- Header -->

		<!-- Sidebar -->
		<div id="side-bar">
			<ul>
				<li><a href="<%=contextPath%>/toMyInfo.do" id="toMyInfo">내 정보 확인</a></li>
				<li><a href="<%=contextPath%>/toMySocial.do" id="toMySocial" >내 모임</a></li>
				<li><a href="<%=contextPath%>/toMyReply.do" id="toMyComment">내가 작성한 댓글</a></li>
				<li><a href="<%=contextPath%>/toMyBookmark.do" id="toMyBookmark">북마크</a></li>
				<li data-bs-toggle="modal" data-bs-target="#deleteMemberModal"><a href="#">회원탈퇴</a></li>
			</ul>
		</div>


		<!-- Modal -->
		<div class="modal fade" id="deleteMemberModal" tabindex="-1"
			aria-labelledby="deleteMemberModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="deleteMemberModalLabel">회원
							탈퇴</h1>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">&times;</button>
					</div>
					<!-- 모달 바디 부분 -->
					<div class="modal-body">
						<form action="<%=contextPath%>/delete.do" method="post">
							<input type="hidden" name="userId" value="${ loginUser.userId }">
							<div class="mb-3">
								<b>탈퇴 후 복구 불가능합니다. <br>그래도 탈퇴하시겠습니까?
								</b>
							</div>
							<div class="mb-3">
								<label for="message-text" class="col-form-label">비밀번호: </label>
								<input type="password" class="form-control" id="deleteCheckPwd"
									name="userPwd" required></input>
							</div>

							<br>

							<button type="submit" class="btn btn-sm btn-info"
								style="border-radius: 10px;">탈퇴하기</button>

						</form>

					</div>
					<!-- 모달 푸터 부분 -->
					<!-- <div class="modal-footer">
			  <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			  <button type="button" class="btn btn-primary">Send message</button>
			</div> -->
				</div>
			</div>
		</div>
		<!-- Main Content -->
</body>
</html>




