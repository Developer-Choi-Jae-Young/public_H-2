<%@page import="com.h2.chuizone.calender.model.dto.CalenderDto"%>
<%@page import="com.h2.chuizone.common.reply.model.dto.ReplyDto"%>
<%@page import="java.util.List"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .calender-view-frame {
        width: 1000px; 
        margin: auto;
    }

    #btn-reply { 
        width: 20%; 
        border-radius: 0px 10px 10px 0px; 
    }

    .first-border-reply { 
        border-radius: 10px 10px 0px 0px;
    }
    
    .no-border-reply { 
        border-top: none; 
        border-bottom: none; 
    }

    .top-border-reply { 
        border-top: 1px solid; 
        border-bottom: none; 
    }

    .end-border-reply { 
        border-radius: 0px 0px 10px 10px; 
        margin-bottom: 10px; 
    }

    .comment-reply-style {
        display: flex; 
        justify-content: space-between;
    }

    .reply-icon {
        background-image: url(../resource/keyboard_return.png); 
        background-repeat: no-repeat; 
        width: 15px; 
        height: 15px; 
        background-size: 15px; 
        margin: 8px 0px 0px 8px;
        margin-right: 10px;
    }

    #no-reply-margin {
        margin: 0px 0px 0px 23px;
    }

    .reply-area-style {
        border: 1px solid; 
        min-height: 50px;
    }

    #modify-delete-reply {
        margin-right: 10px;
    }

    .reply-content-style {
        margin: 0px;
        margin-left: 25px;
    }

    .reply-nicname-area-style { 
        display: flex; 
    }

    .icon-comment-reply {
        background-image: url(https://cdn-icons-png.flaticon.com/128/4824/4824439.png); 
        justify-content: flex-end;
    }

    #comment-area { 
        display: flex; 
        margin-bottom: 10px;
    }

    #comment-content { 
        border: 1px solid; 
        border-radius: 10px 0px 0px 10px; 
        height: 100px; 
        width: 80%; 
        resize: none; 
        padding: 8px; 
    }

    .display-comment {
        margin: 20px; 
        display: flex;
    }

    .btn-frame {
        padding: 10px;
    }

    .btn-style {
        border: none; 
        border-radius: 10px; 
        width: 100px; 
        height: 50px;
    }

    .calender-view-title {
        border: 1px solid; 
        border-radius: 10px; 
        text-align: center; 
        height: 50px; 
        line-height: 50px; 
        margin: 10px 10px 10px 10px;
    }

    .reply-icon-style {
        padding-left: 10px;
    }

    .padding-ten-pixel{
        padding: 10px;
    }

    .calender-view-title-content{
        padding: 10px; 
        width: 300px;
    }

    .display-flex-style {
        display: flex;
    }

    .calender-view-content {
        border-top: 1px solid; 
        min-height: 300px;
    }

    .calender-view-title-sector {
        display: flex; 
        justify-content: space-between;
    }

    .calender-view-title-area{
        border: 1px solid; 
        border-radius: 10px; 
        margin: 0px 10px 10px 10px;
    }

    .calender-view-area {
        width: 70%; 
        border: 1px solid;
        margin: auto;
    }

    #section-border-comment-reply {
        margin: 0px 10px 0px 10px;
    }
    
    #section-modify-delete {
    	width: 85%;
		display: flex;
		flex-direction: row;
		flex-wrap: wrap;
		justify-content: flex-end;
	}
	
	.btn-style {
		border: none;
		font-size: 20pt;
		font-weight: 900;
		border-radius: 10px;
		margin: 10px;
	}
	
	.btn-modify {
		background-color: rgb(234, 221, 255);
	}

	.btn-delete {
		background-color: rgb(255, 108, 108);
		color: white;
	}
</style>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");

	ObjectMapper mapper = new ObjectMapper();
	
	List<ReplyDto> reply = (List<ReplyDto>)request.getAttribute("reply");
	String jsonReply = mapper.writeValueAsString(reply);
	
	CalenderDto board_data = (CalenderDto) request.getAttribute("board_data");
	String jsonBoard = mapper.writeValueAsString(board_data);
%>
<jsp:include page="../common/header.jsp" />
    <div class="calender-view-frame">
    	<c:if test="${owner == true}">
	    	<div id="section-modify-delete">
				<button class="btn-style btn-modify" onclick="updatePost();">수정</button>
				<button class="btn-style btn-delete" onclick="removePost();">삭제</button>
			</div>
		</c:if>
		
		<form action="" method="post" id="postForm">
			<input type="hidden" name="boardNo" value="${ board_data.boardNo }">
			<input type="hidden" name="cboardNo" value="${ cboardNo }">
			<input type="hidden" name="categoryBoardNo" value="${ board_data.categoryBoardNo }">
		</form>
			
        <div class="calender-view-area">
            <div class="calender-view-title">캘린더 일정 상세보기</div>
            
            <div class="calender-view-title-area">
                <div class="calender-view-title-sector">
                    <div class="calender-view-title-content">${ board_data.title }</div>
                    <div class="display-flex-style">
                        <div class="padding-ten-pixel">날짜</div>
                        <div class="padding-ten-pixel">${ board_data.startDate } ~ ${ board_data.endDate }</div>
                    </div>
                </div>
                
                <div class="calender-view-content">
                    <div class="padding-ten-pixel">${ board_data.content }</div>
                </div>
            </div>
            
            <div id="reply-body">
				<jsp:include page="../common/reply.jsp">
					<jsp:param value="<%= jsonReply %>" name="reply" />
					<jsp:param value="<%= jsonBoard %>" name="board_data" />
					<jsp:param value="캘린더" name="type" />
				</jsp:include>
			</div>
           
        </div>
    </div>
    <br><br><br>
    <jsp:include page="../common/footer.jsp" />
    
    <script>
	    function removePost() {
			let removeResult = confirm("일정을 삭제 하시겠습니까?");
    		
    		if(removeResult) {    
				document.getElementById('postForm').action = "deleteCalenderBoard.me";
				document.getElementById('postForm').submit();
    		}
		}
		
		function updatePost() {
			document.getElementById('postForm').action = "updateCalenderBoard.me";
			document.getElementById('postForm').submit();
		}
    </script>
</body>
</html>