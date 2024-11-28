<%@page import="com.h2.chuizone.common.smallgroup.model.vo.SmallGroup"%>
<%@page import="com.h2.chuizone.common.smallgroupcategory.model.vo.SmallGroupCategory"%>
<%@page import="com.h2.chuizone.common.category.model.vo.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<style>
    .board-write-frame {
        width: 1400px; 
        margin: auto;
    }

    .board-write-title {
        border: 1px solid; 
        border-radius: 10px; 
        text-align: center; 
        height: 50px; 
        line-height: 50px; 
        margin: 10px;
    }

    .board-area {
        width: 70%; 
        border: 1px solid;
        margin: auto;
    }

    .border-title-area {
        margin: 10px;
    }

    .board-title {
        border: 1px solid; 
        border-top-left-radius: 10px; 
        border-top-right-radius: 10px; 
        border-bottom: none; 
        padding: 10px;
    }

    .board-title-content{
        border: 1px solid; 
        border-bottom-left-radius: 10px; 
        border-bottom-right-radius: 10px; 
        padding: 10px;
    }

    .border-content-area{
        border: 1px solid; 
        border-radius: 10px; 
        margin: 10px;
    }

    .border-combo-option{
        border-bottom: 1px solid; 
        padding: 10px;
    }

    .combo-item{
        width: 100px; 
        height: 40px; 
        border-radius: 10px; 
        font-size: 21px;
    }

    .border-content-title {
        border-bottom: 1px solid; 
        padding: 10px;
    }

    .border-content-title-frame {
        display: flex; 
        justify-content: space-between; 
        border-bottom: 1px solid; 
        align-items: center;
    }

    .btn-style {
        border: none; 
        border-radius: 10px; 
        width: 100px; 
        height: 50px;
    }

    .btn-frame {
        padding: 10px;
    }

    .border-content-info-frame {
        padding: 0px 10px 0px 10px;
        border: none; 
		color: black;
		cursor: default; 
    }
    
    .border-content-info-frame:active {
    	border: none;
    }
    
    .border-content-info-frame:focus {
    	border: none;
    }

    .input-file-style {
        display: none;
    }

    .label-file-style {
        cursor: pointer; 
        border: 1px solid; 
        border-radius: 5px;
    }

    .content {
        margin: 10px; 
        min-height: 200px;
    }
	
    [contenteditable]:empty:before {
        content: attr(placeholder);
        color: gray
    }
</style>

</head>
<body>
	<%
	List<Category> categoryList = (List<Category>)request.getAttribute("categoryList");
	List<SmallGroupCategory> smallGroupCategoryList = (List<SmallGroupCategory>)request.getAttribute("smallGroupCategoryList");
	List<SmallGroup> smallGroupList = (List<SmallGroup>)request.getAttribute("smallGroupList");
	%>

	<jsp:include page="../common/header.jsp" />
	<br><br><br>
    <div class="board-write-frame">
        <div class="board-area">           
        	<div class="board-write-title">게시글 작성</div>
			<form id="my-form" action="writeBoard.me" method="post" enctype="multipart/form-data">
	            <div class="border-title-area">
	                <div class="board-title">제목</div>
	                <div class="board-title-content" contenteditable placeholder='제목을 입력해 주세요...' name="board_title" id="div-title"></div>
	                <input type="hidden" name="title" id="hidden-title">
	            </div>

	            <div class="border-content-area">
	                <div class="border-combo-option">
	                    <select class="combo-item" name="board_category" onchange="selectCategory(this.value);">
		                    <option value="카테고리">카테고리</option>
		                    <% 		                    
		                    if(categoryList != null) {
		                    	for(int i = 0; i < categoryList.size(); i++) { 
		                    %>
		                    <option value="<%= categoryList.get(i).getCategoryName() %>"><%= categoryList.get(i).getCategoryName() %></option>
		                    <%
		                    	}
		                    }
		                    %>
	                    </select>
						
	                    <select class="combo-item" name="board_group">
	                        <option value="소분류">소분류</option>
	                        <option value="소분류">소분류</option>
	                        <option value="소분류">소분류</option>
	                        <option value="소분류">소분류</option>
	                    </select>
	                    
	                    <select class="combo-item" name="board_max_headcnt">
	                        <option value="10">10명</option>
	                        <option value="20">20명</option>
	                        <option value="30">30명</option>
	                        <option value="50">50명</option>
	                    </select>
	
	                </div>
	                
	                <div>
	                    <div class="border-content-title">내용</div>
	                    <div class="border-content-title-frame">
	                        <p class="border-content-info-frame">대표이미지</p>
	                        <span class="border-file-name-span">                     	
	                        </span>
	                        <input type="hidden" class="border-file-name" name="file-name" readonly></input>
	                        <div class="border-content-info-frame">
	                            <label for="input-file" class="label-file-style">첨부파일 추가</label>
	                            <input id="input-file" class="input-file-style" type="file" name="board-file">
	                        </div>
	                    </div>
	                    
	                </div>
	                
	                <div class="content" contenteditable placeholder='내용을 입력해 주세요...' name="board-content" id="div-content"></div>
	                <input type="hidden" name="content" id="hidden-content">
	            </div>
	            
	            <div class="btn-frame">
	                <button class="btn-style" type="button" onclick="cancel();">취소</button>
	                <button type="submit" class="btn-style">등록</button>
	            </div>
            </form>
        </div>
    </div>
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
			let result = confirm("게시물 작성을 그만하겠습니까?");
        	
        	if(result) {        		
        		history.back();
        	}
        }
        
        function selectCategory(target) {
			const childEle = $("select[name=board_group]").children();
			childEle.remove();
			
			let index = $("select[name=board_category] option").index($("select[name=board_category] option:selected"));
			let smallGroup = [];
			let categoryNo = 0;
			let smallGroupId = 0;
			
			<%
				for(int i = 0; i < smallGroupCategoryList.size(); i++) {
			%>
				categoryNo = <%= smallGroupCategoryList.get(i).getCategoryNo() %>;
				if(categoryNo == index) {
					 smallGroupId = <%= smallGroupCategoryList.get(i).getSmallGroupNo() %>;
					 <% for(int j = 0; j < smallGroupList.size(); j++) { %>
					 	if(smallGroupId == <%= smallGroupList.get(j).getSmallGroupNo() %>) {
					 		smallGroup.push("<%= smallGroupList.get(j).getSmallGroupName() %>");
					 	}
				<% } %>
				}
			<%
				}
			%>
			
			$("select[name=board_group]").append("<option value='소분류'>소분류</option>");
			for(let i = 0; i < smallGroup.length; i++) {
				$("select[name=board_group]").append("<option value='" + smallGroup[i] + "'>" + smallGroup[i] + "</option>");	
			}
		}
        
        // 폼 제출 시 prepareFormData 함수 호출
        document.getElementById('my-form').addEventListener('submit', function(event) {
            prepareFormData();
        });
                
        var fileTarget = $('.input-file-style');
        
        fileTarget.on('change', function() {
        	  if (window.FileReader){
        	    // 최신 브라우저
        	    var filename = ($(this)[0]).files[0].name;
        	  }
        	  else {
        	    // 예전 브라우저
        	    var filename = $(this).val().toString().split('/').pop().split('\\').pop();
        	  }
        	  $('.border-file-name').val(filename);
        	  $('.border-file-name-span').text(filename);
        	});	
    </script>
</body>
</html>