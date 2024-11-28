<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>

<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<style>
    html, body {
        width: 100%;
        height: 100%;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100%;
        width: 100%;
    }
    .container * {
        margin: 3px 0; /* 요소 간격 조정 */
    }

    .login-form-area {
        border: lightgray 2px solid;
        border-radius: 15px;

        display: flex;
        justify-content: center;
        align-items: center;

        width: 300px;
        height: 300px;
        padding: 20px; /* 여백 추가 */
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* 그림자 효과 추가 */
        background-color: white; /* 배경색 추가 */
    }

    table {
        width: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    button {
        padding: 10px;
        border: none;
        border-radius: 15px;
        background-color: black;
        color: white;
    }
    button:hover {
        cursor: pointer;
    }

    input {
        padding: 0px 10px 0px 10px;
        border: lightgray 2px solid;
        height: 35px;
        border-radius: 15px;
        }

    #btn-login {
        width: 100px;
    }
#search{
 padding: 10px;
	border: none;
	border-radius: 15px;
	background-color: black;
	color: white;
</style>
</head>



<body>
<%
	String contextPath = request.getContextPath();

	String alertMsg = (String)session.getAttribute("alertMsg");
%>

    <% if (alertMsg != null) { %>
        <script>
            alert("<%= alertMsg %>");
        </script>
        <% session.removeAttribute("alertMsg"); %>
    <% } %>
    <div class="container">
        <div class="login-form-area">
            <form id="login-form" action="<%= contextPath %>/login.me" method="post">
                <table align="center" >
                    <tr>
                        <td>아이디</td>
                    </tr>
                    <tr>
                        <td>
                            <input id="input-id" type="text" name="userId" required>
                        </td>
                    </tr>

                    <tr>
                        <td>비밀번호</td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <input class="input-items" type="password" name="userPw" minlength="8" required>
                        </td>
                    </tr>
                </table>
                <div align="center">
                    <button type="submit" id="btn-login">로그인</button>
                </div>
                <br>
                <div align="center">
                   <button type="button" id="btn-findId" data-toggle="modal"
						data-target="#idSearchModal">아이디 찾기</button>
					<button type="button" id="btn-findId" data-toggle="modal"
						data-target="#updatePwdModal">비밀번호 찾기</button>
                </div>
            </form>
        </div>
    </div>
    <!--아이디 찾기 모달-->
	<div class="modal fade" id="idSearchModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<!--모달 헤더 부분-->
				<div class="modal-header">
					<h3 class="modal-title fs-5" id="exampleModalLabel">아이디를
						잊어버리셨나요?</h3>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">&times</button>
				</div>
				<!--모달 바디 부분-->
				<div class="modal-body">


					<div class="mb-3">
						<label for="userEmail" class="col-form-label">E-Mail: </label> 
						<input type="email" class="form-control" id="email" name="email">
					</div>


					<button id="search" class="btn btn-sm" onclick="idSearch()">이메일로 받기</button>

				</div>
				<!--모달 푸터 부분-->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div>

	<!--비밀번호 찾기 모달-->
	<div class="modal fade" id="updatePwdModal" tabindex="-1"
		aria-labelledby="updatePwdModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<!--모달 헤더 부분-->
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="updatePwdModalLabel">비밀번호 변경</h1>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">&times</button>
				</div>
				<!--모달 바디 부분-->
				<div class="modal-body">

					<!-- <form action="<%=contextPath%>/UpdatePwd" method="post"> -->

					<div class="mb-3">
						<label for="userPwd" class="col-form-label">아이디: </label> <input
							type="text" class="form-control" id="userId" name="userId">
					</div>
					<div class="mb-3">
						<label for="newPassword" class="col-form-label">현재 비밀번호</label> <input
							type="password" class="form-control" id="password"
							name="newPassword">
					</div>
					<div class="mb-3">
						<label for="newPassword" class="col-form-label">변경할 비밀번호</label> <input
							type="password" class="form-control" id="newPassword"
							name="newPassword">
					</div>

					<div class="mb-3">
						<label for="newPasswordCheck" class="col-form-label">변경할 비밀번호 확인</label>
						 <input type="password" class="form-control"
							id="newPasswordCheck" name="newPasswordCheck">
					</div>

					<br>

					<button id="search" class="btn btn-sm" onclick="pwdCheck()">비밀번호 변경</button>

					<!-- </form> -->
				</div>
				<!--모달 푸터 부분-->
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
	</div>


	<script>
		function idSearch() {
			$.ajax({
				url:"SearchId",
				data:{email: $("#email").val()},
				method: "post",
				success: function(result){
					//console.log(result);
					if (result != 'null') {
						alert("아이디는 " + result + "입니다. ");
					} else {
						alert("조회된 아이디가 없습니다.");
					}
					$("#email").val('');
					// => 이메일 입력창을 초기화 (빈값으로 저장)
				},
				error: function(err){
					console.log("아이디 찾기 실패");
					console.log(err);
				}    
			})
		}
		
		function pwdCheck() {
			$.ajax({
		
			url:"UpdatePwd",
			data:{id: $("#userId").val(),
				  pwd: $("#password").val(),
			      newPwd: $("#newPassword").val(),
			      newPwdCheck: $("#newPasswordCheck").val()},
			      
			method: "post",
			success: function(result){
				alert(result);
				$("#userId").val('');
				$("#password").val('');
				$("#newPassword").val('');
				$("#newPasswordCheck").val('');
			}
			});
		}
			
				
			
	</script>
    
</body>
</html>