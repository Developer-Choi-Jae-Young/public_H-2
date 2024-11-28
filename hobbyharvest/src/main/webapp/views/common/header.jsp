<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>header</title>

    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
	
    <!-- 부트스트랩 스크립트 코드 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!-- <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script> -->
    
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

    <style>

        @font-face {
            font-family: 'HancomMalangMalang-Regular';
            src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/2406-1@1.0/HancomMalangMalang-Regular.woff2') format('woff2');
            font-weight: 400;
            font-style: normal;
        }

        * {
            font-family: 'HancomMalangMalang-Regular';
        }

        .header {
            /* border: red solid 1px; */
            box-sizing: border-box;
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            padding: 0;
            width: 100%;
            min-width: 1200px;
            height: 82px;
            box-shadow: 0px 3px 10px 0px rgb(214, 214, 214);
            background-color: #b7d8ff;
        }

        #img-area {
            flex: left;
            width: 15%;
        }
        #img-area img {
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center;

            width: 250px;
            height: 80px;
        }

        .nav-area {
        /* border: red solid 1px; */
        width: 60%;
        display: flex;
        justify-content: space-evenly;
        align-items: center;
        }
        
        .menu {
            /* border: red solid 1px; */
            display: flex;
            width: 100px;
            height: 70px;
            /* background-color: aqua;
            border: black solid; */
        }
        .menu a {
            /* border: red solid 1px; */
            color: #4c4242;
            font-size: 20px;
            font-weight: 700;
            border-radius: 30px;
            text-decoration: none;

            transition: 0.3s ease-out;
            opacity : 0.9;

            display: inline-block;
            width: 100%;
            height: 100%;
            line-height: 65px;
        }
        .menu a:hover {
            text-decoration: none;
            background-color: #fff099;
            color: black;
            box-shadow: 0px 0px 10px gray;
            transition: 0.3s ease-out;
            opacity : 0.9;

            transition: 0.3s ease-out;
            opacity : 0.9;
        }

        .login-area {
            /* border: red solid 1px; */
            width: 15%;
            display: flex;
            flex-direction: row;
            align-items: center;
            justify-content: center;
            padding: 5px;
        }

        .before-login {
            display: flex;
        }
        .before-login button {
            /* border: red solid 1px; */
            color: #4c4242;
            border: none;
            background-color: #ffb7b7;
            font-weight: 900;
            font-size: 14px;
            padding: 10px;
            margin: 3px;
            border-radius: 15px;
        }
        .before-login button:hover {
            color: black;
            background-color: #fff099;
            box-shadow: 0px 0px 10px gray;

            transition: 0.3s ease-out;
            opacity : 0.9;
        }

        .after-login td {
            height: 100%;
            padding: 3px;
        }
        .after-login button {
            background-color: #ffb7b7;
            font-size: 14px;
            border: none;
        }
        .after-login button:hover {
            background-color: #fff099;
            box-shadow: 0px 0px 10px gray;

            transition: 0.3s ease-out;
            opacity : 0.9;
        }

        #profile-icon {
            /* border: blue solid 2px; */
            height: 75px;
            align-content: center;
        }
        #profile-icon img { width: 40px; height: 40px;}

        .dropdown button {
            /* border: red solid 1px; */
            width: 100px;
            border-radius: 15px;
        }

        #btn-dropdown:focus {
            background-color: #fff099;
        }

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

    <div class="header">
        <!-- 카테고리 영역 -->
        <div id="img-area">
            <img src="views/common/img/logo.png" alt="로고 이미지">
        </div>
        <div class="nav-area" align="center">
            <div class="menu"><a href="<%= contextPath %>">HOME</a></div>
            <div class="menu"><a href="<%= contextPath %>/category.me">카테고리</a></div>
            <div class="menu"><a href="#">공지사항</a></div>
            <div class="menu"><a href="<%= contextPath %>/toFaqPage.do">고객센터</a></div>
        </div>

        <div class="login-area">
        
        	<c:choose>
        	
	        	<c:when test="${ empty loginUser }">
	            <!-- 로그인 전 -->
	            <div class="before-login">
	                            <button id="btn-login" onclick="loginPage();">로그인</button>
	                            <button id="btn-join" onclick="joinPage();">회원가입</button>
	            </div>
	            <script>
                    // 로그인 페이지 요청
                    function loginPage() {
                        location.href="<%= contextPath %>/loginPage.me";
                    }

                    // 회원가입 페이지 요청
                    function joinPage() {
                        location.href="<%= contextPath %>/joinPage.me";
                    }
                </script>
	            
	            </c:when>
	            
	            <c:otherwise>
	            <!-- 로그인 후 -->
	            <div class="after-login">
	                <table>
	                    <tr>
	                        <td>
	                            <div id="profile-icon">
	                            <img src="views/common/img/profile-icon.png" alt="프로필 아이콘 이미지">
	                            </div>
	                        </td>
	                        <td>
	                            <div class="dropdown">
	                                <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" id="btn-dropdown">
	                                ${loginUser.nickName}님
	                                </button>
	                                <div class="dropdown-menu">
	                                    <a class="dropdown-item" href="<%= contextPath%>/toMyInfo.do">마이페이지</a>
	                                    <a class="dropdown-item" href="<%= contextPath%>/logout.me">로그아웃</a>
	                                </div>
	                            </div>
	                        </td>
	                    </tr>
	                </table>
	            </div>
	            </c:otherwise>
			</c:choose>
        </div>

    </div>

</body>
</html>