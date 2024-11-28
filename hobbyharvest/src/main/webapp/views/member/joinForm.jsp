<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

</head>
<body>
	<style>
    /* 기본 브라우저 스타일 초기화 */
    * {
        /* border: red solid 1px; */
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    html, body {
        width: 100%;
        height: 100%;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    body {
        padding: 30px 0;
    }

    .container {
        /* border: red 1px solid; */
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100%;
        width: 100%;
        max-width: 600px;
    }

    .join-form-area {
        border: lightgray 2px solid;
        border-radius: 15px;
        width: 500px;

        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* 그림자 효과 추가 */
        background-color: white; /* 배경색 추가 */
    }

    .container * {
        margin: 5px 0; /* 요소 간격 조정 */
    }

    table {
        width: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    table button { padding: 10px; }
    button:hover { cursor: pointer; }

    input {
        padding: 0px 10px 0px 10px;
        border: lightgray 2px solid;
        height: 35px;
        border-radius: 15px;
        }
    #input-id { width: 180px;}
    .input-items { width: 270px;}
    input[type=password] {
        font-size: 25px;
    }

    .btn-confirm {
        border: lightgray solid 2px;
        border-radius: 15px;
        background-color: white;
        color: black;
    }
    #btn-phone {
        border: none;
        border-radius: 15px;
        background-color: black;
        color: white;
    }
    #btn-join {
        width: 150px;
        height: 40px;
        border: none;
        border-radius: 15px;
        background-color: black;
        color: white;
    }
</style>

</head>
<body>
<%
    String contextPath = request.getContextPath();
    String alertMsg = (String)session.getAttribute("alertMsg");
%>

    <div class="container">
        <div class="join-form-area">
        <form id="join-form" action="<%= contextPath %>/join.me" method="post">
			<!-- table>(tr>td*2)*8 -->
			<table align="center" >
				<tr>
					<td>아이디</td>
                </tr>

                <tr>
                    <td>
						<input id="input-id" type="text" name="userId" required>
					</td>
					<td>
                        <button type="button" class="btn-confirm" onclick="idCheck();">중복검사</button>
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
				<tr>
					<td>비밀번호 확인</td>
                </tr>
                <tr>
					<td colspan="2">
						<input class="input-items" type="password" name="userPwCheck" minlength="8" required>
					</td>
                </tr>
				<tr>
					<td>닉네임</td>
                </tr>
                <tr>
					<td colspan="2">
						<input class="input-items" type="text" name="nickName" required>
					</td>
				</tr>
                <tr>
                    <td>주소</td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input class="input-items" type="text" name="address" required>
                    </td>
                </tr>
				<tr>
					<td>전화번호</td>
                </tr>
                <tr>
					<td colspan="2">
                        <input class="input-items" type="tel" id="input-phone" name="phone" required>        
					</td>
				</tr>
				<tr>
					<td>이메일</td>
                </tr>
                <tr>
					<td colspan="2">
                        <input class="input-items" type="email" name="email" required>
					</td>
				</tr>
			</table>
            <div align="center">
                <button type="submit" id="btn-join" onclick="return pwCheck();" disabled>회원가입</button>
            </div>
			</form>
        </div>
    </div>

    <script>
        function pwCheck() {
            const pw = document.querySelector("#join-form input[name=userPw]").value;
            const pwCheck = document.querySelector("#join-form input[name=userPwCheck]").value;

            if (pw != pwCheck) {
                alert("비밀번호와 비밀번호 확인 입력 값이 다릅니다.");
                return false;
            }
        };
        
        function idCheck() {
        	const idEle = $("#join-form input[name=userId]");
        	
        	$.ajax({
        		url: 'idCheck.me',
        		type: 'get',
        		data: {userId: idEle.val()},
        		success: function(result) {
        			if(result == 'Y' ) {
        				alert("사용 가능한 아이디입니다.");
                        document.querySelector("#btn-join").disabled = false;
        				// $("join-form input[type=submit]").removeAttr("disabled");
        			} else {
        				alert("사용할 수 없는 아이디입니다. 다시 입력해 주세요.");
        				
        				idEle.focus();
        			}
        		},
        		error: function(err) {
        			console.log(err);
        		}
        	});
        };
    </script>

</body>
</html>