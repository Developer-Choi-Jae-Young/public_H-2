<%@page import="com.h2.chuizone.calender.model.dto.CalenderDto"%>
<%@page import="com.h2.chuizone.common.reply.model.dto.ReplyDto"%>
<%@page import="java.sql.Date"%>
<%@page import="com.fasterxml.jackson.databind.module.SimpleModule"%>
<%@page import="com.h2.chuizone.category.model.dto.SelectCategoryBoardListDto"%>
<%@page import="java.util.List"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.comment-reply-style {
	display: flex;
	justify-content: space-between;
}

.reply-icon {
	background-image: url(resources/keyboard_return.png);
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

#comment-content {
	border: 1px solid;
	border-radius: 10px 0px 0px 10px;
	height: 100px;
	width: 80%;
	resize: none;
	padding: 8px;
}

#comment-area {
	display: flex;
	margin-bottom: 10px;
	margin: 20px;
}

#reply-area {
	
}

.display-comment {
	display: flex;
	padding: 20px;
}

.non-display-comment {
	display: none;
}

.reply-icon-style {
	padding-left: 10px;
}

a {
	cursor: pointer;
}

.reply-area-style-first {
	border: 1px solid;
	border-bottom: none;
	height: 10px;
}

.reply-area-style-end {
	border: 1px solid;
	border-top: none;
	height: 10px;
}
</style>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");

	String jsonReplies = request.getParameter("reply");
	String jsonBoards = request.getParameter("board_data");
	
	ObjectMapper mapper = new ObjectMapper();
	
	List<ReplyDto> replies = mapper.readValue(jsonReplies, mapper.getTypeFactory().constructCollectionType(List.class, ReplyDto.class));
    request.setAttribute("replys", replies);
	
    if(request.getParameter("type").equals("카테고리")) {
    	SelectCategoryBoardListDto boardData = mapper.readValue(jsonBoards, SelectCategoryBoardListDto.class);
        request.setAttribute("board_datas", boardData);	
    } else if(request.getParameter("type").equals("캘린더")) {
    	CalenderDto boardData = mapper.readValue(jsonBoards, CalenderDto.class);
    	request.setAttribute("board_datas", boardData);
    } else {
    	
    }
%>

	<div id="section-border-comment-reply">
		<div class="reply-area-style-first first-border-reply"></div>

		<c:forEach var="reply" items="${replys}" varStatus="status">
			<c:choose>
				<c:when test="${replys[status.index].parentReplyNo == 0}">
					<div class="reply-area-style no-border-reply">
						<div class="comment-reply-style">
							<div class="reply-nicname-area-style">
								<span id="no-reply-margin">${replys[status.index].memberName}</span>
							</div>
							<div id="modify-delete-reply">
								<c:choose>
									<c:when test="${ replys[status.index].status == 'Y' }">
									</c:when>
									<c:when test="${ replys[status.index].memberName == loginUser.nickName }">
										<a onclick="updateReply(this);">수정</a>
										<a
											onclick="deleteComment(${ board_datas.boardNo }, ${ replys[status.index].replyNo });">삭제</a>
										<a onclick="reply(this);">답글</a>
									</c:when>
									<c:otherwise>
										<a onclick="reply(this);">답글</a>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<div>
							<c:choose>
								<c:when test="${ replys[status.index].status == 'Y' }">
									<p class="reply-content-style">삭제된 댓글 입니다.</p>
								</c:when>
								<c:otherwise>
									<p class="reply-content-style">${replys[status.index].replyContent}</p>
								</c:otherwise>
							</c:choose>
						</div>

						<div id="reply-area" class="non-display-comment">
							<p class="reply-icon"></p>
							<textarea id="comment-content" placeholder="작성할 댓글을 입력하세요."></textarea>

							<button id="btn-reply"
								onclick="comment(this, ${ board_datas.boardNo }, ${ replys[status.index].replyNo }, ${ replys[status.index].depts });">댓글
								달기</button>
						</div>

						<div id="reply-area" class="non-display-comment">
							<p class="reply-icon"></p>
							<textarea id="comment-content" placeholder="작성할 댓글을 입력하세요."></textarea>

							<button id="btn-reply" onclick="updateComment(this, ${ board_datas.boardNo }, ${ replys[status.index].replyNo }, ${ replys[status.index].depts });">댓글 달기</button>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="reply-area-style no-border-reply">
						<div class="comment-reply-style">
							<div class="reply-nicname-area-style">
								<c:forEach var="i" begin="0" end="${ replys[status.index].depts }">
									&ensp;
								</c:forEach>
								<p class="reply-icon"></p>
								<span>${replys[status.index].memberName}</span>
							</div>
							<div id="modify-delete-reply">
								<c:choose>
									<c:when test="${ replys[status.index].status == 'Y' }">
									</c:when>
									<c:when test="${ replys[status.index].memberName == loginUser.nickName }">
										<a onclick="updateReply(this);">수정</a>
										<a
											onclick="deleteComment(${ board_datas.boardNo }, ${ replys[status.index].replyNo });">삭제</a>
										<a onclick="reply(this);">답글</a>
									</c:when>
									<c:otherwise>
										<a onclick="reply(this);">답글</a>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
						<div>
							<p class="reply-content-style">
								<c:forEach var="i" begin="0" end="${ replys[status.index].depts }">
									&ensp;
								</c:forEach>
								<c:choose>
									<c:when test="${ replys[status.index].status == 'Y' }">
										삭제된 댓글 입니다.
									</c:when>
									<c:otherwise>
										${replys[status.index].replyContent}
									</c:otherwise>
								</c:choose>
							</p>
						</div>

						<div id="reply-area" class="non-display-comment">
							<p class="reply-icon"></p>
							<textarea id="comment-content" placeholder="작성할 댓글을 입력하세요."></textarea>

							<button id="btn-reply" onclick="comment(this, ${ board_datas.boardNo }, ${ replys[status.index].replyNo }, ${ replys[status.index].depts });">댓글 달기</button>
						</div>
						
						<div id="reply-area" class="non-display-comment">
							<p class="reply-icon"></p>
							<textarea id="comment-content" placeholder="작성할 댓글을 입력하세요."></textarea>

							<button id="btn-reply" onclick="updateComment(this, ${ board_datas.boardNo }, ${ replys[status.index].replyNo }, ${ replys[status.index].depts });">댓글 달기</button>
						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</c:forEach>

		<div class="reply-area-style-end end-border-reply"></div>

		<div id="comment-area">
			<textarea id="comment-content" placeholder="작성할 댓글을 입력하세요."></textarea>

			<button id="btn-reply"
				onclick="comment(this, ${ board_datas.boardNo }, null, 0);">댓글
				달기</button>
		</div>
	</div>

	<script>
		var replies = <%= jsonReplies %>;
		var board_datas = <%= jsonBoards %>;
	    
        function reply(target) {
            if($($($(target).parents()[2]).children()[2]).hasClass("non-display-comment")) {
                $($($(target).parents()[2]).children()[2]).removeClass();
                $($($(target).parents()[2]).children()[2]).addClass("display-comment");
                
                $($($(target).parents()[0]).children()[0]).css({'pointer-events': 'none'});
                $($($(target).parents()[0]).children()[1]).css({'pointer-events': 'none'});
            } else {
                $($($(target).parents()[2]).children()[2]).removeClass();
                $($($(target).parents()[2]).children()[2]).addClass("non-display-comment");
                
                $($($(target).parents()[0]).children()[0]).css({'pointer-events': ''});
                $($($(target).parents()[0]).children()[1]).css({'pointer-events': ''});
            }
    	}
        
        function comment(target, boardId, parentId, dept) {      
        	let replyContent = "";
        	
        	if(dept > 1) {
        		replyContent = $($($(target).parents()[0]).children()[1]).val()	
        	} else {
        		replyContent = $($($(target).parents()[0]).children()[1]).val()
        	}
        	
        	if(parentId == null) {
        		replyContent = $($($(target).parents()[0]).children()[0]).val()	
        	}
        	
        	$.ajax({
        		 url: 'reply.me',
                 method: 'GET',
                 data : {
                 	boardId: boardId,
                 	parentId: parentId,
                 	content: replyContent
                 },
                 success: function(resultData) {
                	 $.ajax({
                		 url: 'views/common/reply.jsp',
                         method: 'POST',
                         data : {
                        	 reply: resultData,
                        	 board_data: JSON.stringify(board_datas),
                        	 type: '<%= request.getParameter("type") %>'
                         },
                         success: function(result) {
                        	 $('#reply-body').empty()
                        	 $('#reply-body').append(result);
                        	 let val = parseInt($('#replyCount').text(), 10) + 1;
                        	 $('#replyCount').text(val);
                         },
                         error: function(status, error) {
                             console.error('AJAX 요청 오류:', status, error);
                         }
                	});
                 },
                 error: function(status, error) {
                     console.error('AJAX 요청 오류:', status, error);
                 }
        	});
        	
        }
        
        function deleteComment(boardId, replyId) {      
        	$.ajax({
        		 url: 'deleteReply.me',
                 method: 'POST',
                 data : {
                 	boardId: boardId,
                 	replyId: replyId
                 },
                 success: function(resultData) {
                	 $.ajax({
                		 url: 'views/common/reply.jsp',
                         method: 'POST',
                         data : {
                        	 reply: resultData,
                        	 board_data: JSON.stringify(board_datas),
                        	 type: '<%= request.getParameter("type") %>'
                         },
                         success: function(result) {
                        	 $('#reply-body').empty()
                        	 $('#reply-body').append(result);
                         },
                         error: function(status, error) {
                             console.error('AJAX 요청 오류:', status, error);
                         }
                	});
                 },
                 error: function(status, error) {
                     console.error('AJAX 요청 오류:', status, error);
                 }
        	});
        }
        
        function updateComment(target, boardId, replyId, dept) {   
			let replyContent = "";
        	
        	if(dept > 1) {
        		replyContent = $($($(target).parents()[0]).children()[1]).val()	
        	} else {
        		replyContent = $($($(target).parents()[0]).children()[1]).val()
        	}
        	
        	$.ajax({
        		 url: 'updateReply.me',
                 method: 'POST',
                 data : {
                 	boardId: boardId,
                 	replyId: replyId,
                 	content: replyContent
                 },
                 success: function(resultData) {
                	 $.ajax({
                		 url: 'views/common/reply.jsp',
                         method: 'POST',
                         data : {
                        	 reply: resultData,
                        	 board_data: JSON.stringify(board_datas),
                        	 type: '<%= request.getParameter("type") %>'
                         },
                         success: function(result) {
                        	 $('#reply-body').empty()
                        	 $('#reply-body').append(result);
                         },
                         error: function(status, error) {
                             console.error('AJAX 요청 오류:', status, error);
                         }
                	});
                 },
                 error: function(status, error) {
                     console.error('AJAX 요청 오류:', status, error);
                 }
        	});
        	
        }
        
        function updateReply(target) {
        	let textVal = $($($($(target).parents()[2]).children()[1]).children()[0]).text();
        	textVal = textVal.replace(/\u2002/g, '').trim();
        	
            if($($($(target).parents()[2]).children()[3]).hasClass("non-display-comment")) {
                $($($(target).parents()[2]).children()[3]).removeClass();
                $($($(target).parents()[2]).children()[3]).addClass("display-comment");
                
                $($($($(target).parents()[2]).children()[1]).children()[0]).css('display', 'none');
                $($($($(target).parents()[2]).children()[3]).children()[1]).val(textVal);
                
                $($($(target).parents()[0]).children()[1]).css({'pointer-events': 'none'});
                $($($(target).parents()[0]).children()[2]).css({'pointer-events': 'none'});
            } else {
                $($($(target).parents()[2]).children()[3]).removeClass();
                $($($(target).parents()[2]).children()[3]).addClass("non-display-comment");
                $($($($(target).parents()[2]).children()[1]).children()[0]).css('display', 'block');
                
                $($($(target).parents()[0]).children()[1]).css({'pointer-events': ''});
                $($($(target).parents()[0]).children()[2]).css({'pointer-events': ''});
            }
    	}
    </script>
</body>
</html>