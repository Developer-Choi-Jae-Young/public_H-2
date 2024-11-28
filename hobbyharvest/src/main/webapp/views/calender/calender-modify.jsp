<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
     .btn-frame {
        padding: 10px;
    }

    .btn-style {
        border: none; 
        border-radius: 10px; 
        width: 100px; 
        height: 50px;
    }

    [contenteditable]:empty:before {
        content: attr(placeholder);
        color: gray
    }

    .calender-write-frame {
        width: 1000px; 
        margin: auto;
    }

    .calender-write-title {
        border: 1px solid; 
        border-radius: 10px; 
        text-align: center; 
        height: 50px; 
        line-height: 50px; 
        margin: 10px 10px 10px 10px;
    }

    .calender-write-title-area {
        margin: 10px;
    }

    .calender-write-title-content{
        border: 1px solid; 
        border-bottom-left-radius: 10px; 
        border-bottom-right-radius: 10px; 
        padding: 10px;
    }

    .calender-write-area {
        width: 70%; 
        border: 1px solid;
        margin: auto;
    }

    .calender-title {
        border: 1px solid; 
        border-top-left-radius: 10px; 
        border-top-right-radius: 10px; 
        border-bottom: none; 
        padding: 10px;
    }

    .calender-content-area {
        border: 1px solid; 
        border-radius: 10px; 
        margin: 10px;
    }

    .content {
        margin: 10px; 
        min-height: 200px;
    }

    .calender-content-title {
        border-bottom: 1px solid; 
        padding: 10px;
    }
    .calender-date-frame {
        display: flex; 
        margin-left: 10px;
    }

    .calender-date-title {
        border: 1px solid; 
        border-top-left-radius: 10px; 
        border-bottom-left-radius: 10px; 
        width: 80px; 
        text-align: center; 
        line-height: 130px;
    }

    .calender-date-start-end {
        border: 1px solid; 
        border-top-right-radius: 10px; 
        border-bottom-right-radius: 10px;
    }

    .calender-date-start {
        border-bottom: 1px solid; 
        margin: 0px; 
        padding: 10px;
    }

    .calender-date-end {
        margin: 0px; 
        padding: 10px;
    }
</style>

</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<br><br><br>
	<form id="my-form" action="updateCalender.me" method="post">
	    <div class="calender-write-frame">
	        <div class="calender-write-area" >
	            <div class="calender-write-title">캘린더 일정 작성</div>
				<input type="hidden" name="categoryBoardNo" id="categoryBoardNo" value="<%= request.getAttribute("categoryBoardNo") %>">
				<input type="hidden" name="boardNo" id="boardNo" value="<%= request.getAttribute("boardNo") %>">
				<input type="hidden" name="cboardNo" id="cboardNo" value="<%= request.getAttribute("cboardNo") %>">
				
	            <div class="calender-write-title-area">
	                <div class="calender-title">제목</div>
	                <div class="calender-write-title-content" contenteditable placeholder='내용을 입력해 주세요...' id="div-title"><%= request.getAttribute("title") %></div>
	                <input type="hidden" name="title" id="hidden-title">
	            </div>
	            
	            <div class="calender-date-frame">
	                <div class="calender-date-title">날짜</div>
	                <div class="calender-date-start-end">
	                    <p class="calender-date-start">시작일<br><input type="date" value="<%= request.getAttribute("startDate") %>" name="startDate"></p>
	                    <p class="calender-date-end">종료일<br><input type="date" value="<%= request.getAttribute("endDate") %>" name="endDate"></p>
	                </div>
	            </div>
	
	            <div class="calender-content-area">
	                <div>
	                    <div class="calender-content-title">내용</div>
	                </div>
	                <div class="content" contenteditable placeholder='내용을 입력해 주세요...' id="div-content"><%= request.getAttribute("content") %></div>
	                <input type="hidden" name="content" id="hidden-content">
	            </div>
	            
	            <div class="btn-frame">
	                <button class="btn-style" type="button" onclick="cancel();">취소</button>
	                <button type="submit" class="btn-style">등록</button>
	            </div>
	        </div>
	    </div>
    </form>
    <br><br><br>
    <jsp:include page="../common/footer.jsp" />
    
    <script>
	    // 폼 제출 전 div 내용 추출
	    function prepareFormData() {
	        const contentDiv = document.getElementById('div-content');
	        const titleDiv = document.getElementById('div-title');
	        const hiddenInputContent = document.getElementById('hidden-content');
	        const hiddenInputTitle = document.getElementById('hidden-title');
	
	        // div의 HTML 내용을 가져와서 hidden input 필드에 설정
	        hiddenInputContent.value = contentDiv.innerHTML;
	        hiddenInputTitle.value = titleDiv.innerHTML;
	    }
	    
	    function cancel() {
			let result = confirm("일정 수정을 그만하겠습니까?");
        	
        	if(result) {
	    		location.href = "calender.me?categoryBoardNo=" + ${ categoryBoardNo } + "&boardNo=" + ${ cboardNo };
        	}
	    }
	    
	 	// 폼 제출 시 prepareFormData 함수 호출
        document.getElementById('my-form').addEventListener('submit', function(event) {
            prepareFormData();
        });
    </script>
</body>
</html>