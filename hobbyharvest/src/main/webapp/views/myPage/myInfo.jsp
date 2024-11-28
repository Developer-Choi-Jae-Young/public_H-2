<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!DOCTYPE html>
    <html lang="en">
<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Hobby Harvest</title>

        <link rel="stylesheet" href="views/css/myPage.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>

</head>
<body>
	<script>
		if('${alertMsg}' != '') {
			alert('${alertMsg}');
			<% request.getSession().removeAttribute("alertMsg"); %>
		}
	</script>
	<header>
		<jsp:include page="../common/header.jsp"></jsp:include>
	</header>
	<div id="bodySection">
    <%@ include file="myPageNav.jsp" %>
    	
        <div class="content">
        <div id="user-info">
        <h2>기본정보</h2>
        <hr>
        <form action="updateInfo.do" method="post">
            <table>
                <tr>
                    <td rowspan="2" style="vertical-align: middle; width: 0;"><img src="views/img/user_img.png" alt=""></td>
                    <td><input type="text" name="userId" value="${ loginUser.userId }" style="border: none;" readonly></td>
                </tr>
                <tr>
                    <td style="padding-left: 10px" > <input type="email" name="email" class="myinfo" value="${ loginUser.email }" style="border: none; width: 300px;" readonly></td>
                </tr>
                
                <tr>
                    <td style="vertical-align: middle;"><img src="views/img/Smartphone.png" alt="" style=""></td>
                    <td> <input type="tel" name="phone" class="myinfo" value="${ loginUser.phone }" style="border: none; width: 300px;" readonly></td>
                </tr>
                <tr>
                    <td style="vertical-align: middle;"><img src="views/img/address.png" alt=""></td>
                    <td><input type="text" name="address" class="myinfo" value="${ loginUser.address }" style="border: none; width: 300px;" readonly></td>
                </tr>
            </table>
        </div>
        
        <div style="margin-top: 10px;"><button type="button" class="btn modify" style="margin-left: 80%; box-shadow: 0px 3px 5px gray;" onclick="modify();">정보 수정</button></div>
        </form>
        </div>
    </div>
    
        <!-- Footer -->
         <jsp:include page="../common/footer.jsp"></jsp:include>

	<script>
			function modify() {
				$(".myinfo").prop("readonly", false);
				$(".myinfo").css("box-shadow", "0px 0px 5px gray");
				$(".modify").text("저  장");
				$(".modify").click(function() {
					$(".modify").prop("type", "submit");
				});
			}
	
	</script>
<body>
</html>
    