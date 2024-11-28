<%@page import="com.h2.chuizone.common.reply.model.dto.ReplyDto"%>
<%@page import="com.h2.chuizone.common.review.model.dto.ReviewDto"%>
<%@page
	import="com.h2.chuizone.category.model.dto.SelectCategoryBoardListDto"%>
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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<style>
#border-view-area {
	width: 1000px;
	margin: auto;
	margin-top: 80px;
}

#border-view-section {
	width: 100%;
}

#section-modify-delete {
	display: flex;
	flex-direction: row;
	flex-wrap: wrap;
	justify-content: right;
}

#section-main-image {
	border: 1px solid;
	border-radius: 10px;
	height: 300px;
	margin: 10px 0px;
}

#section-border-info {
	border-radius: 10px;
	height: 50px;
	margin: 10px 0px;
	display: flex;
	flex-wrap: wrap;
	justify-content: left;
}

#section-group-behavior {
	border-radius: 10px;
	height: 50px;
	margin: 10px 0px;
	display: flex;
	flex-wrap: wrap;
	justify-content: flex-end;
}

.star-rating {
	display: flex;
}

.star {
	appearance: none;
	padding: 1px;
}

.star::after {
	content: '☆';
	color: hsl(60, 80%, 45%);
	font-size: 20px;
}

.star:hover::after {
	content: '★';
}

.star:has( ~ .star:hover)::after {
	content: '★';
}

.star:checked::after, .star:has( ~ .star:checked)::after {
	content: '★';
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

.icon-btn-style {
	border: 1px solid;
	border-radius: 10px;
	width: 100px;
	background-repeat: no-repeat;
	background-size: contain;
	display: flex;
	margin: 0px 10px;
	cursor: pointer;
}

.icon-style {
	border: 1px solid;
	border-radius: 10px;
	width: 50px;
	background-repeat: no-repeat;
	background-size: contain;
	display: flex;
}

.inner-content-style {
	margin: 50px;
}

#content-title-bar {
	border: 1px solid;
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
	height: 50px;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

#content {
	border: 1px solid;
	border-top: none;
	border-bottom-left-radius: 10px;
	border-bottom-right-radius: 10px;
	min-height: 500px;
	padding: 10px;
}

.border-info-icon-style {
	width: 50%;
	display: flex;
	justify-content: center;
	align-items: center;
}

.btn-joinable-style {
	border: none;
	border-radius: 10px;
	width: 100px;
	height: 100%;
	font-size: 20px;
	font-weight: 900;
}

.btn-join {
	background-color: rgb(234, 221, 255);
}

.btn-unjoin {
	background-color: red;
	color: white;
}

.top-style {
	border: 1px solid;
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
	height: 50px;
}

.bottom-style {
	border: 1px solid;
	border-top: none;
	border-bottom-left-radius: 10px;
	border-bottom-right-radius: 10px;
}

#padding-for-review {
	padding: 10px;
}

.review-title {
	width: 40%;
}

.icon-book-mark {
	background-image: url(resources/Bookmark-icon-after.png);
	background-size: contain;
	justify-content: flex-end;
	cursor: pointer;
	background-size: 25px 25px;
	background-position: center;
}

.icon-unbook-mark {
	background-image: url(resources/Bookmark-icon-before.png);
	justify-content: flex-end;
	cursor: pointer;
	background-size: 25px 25px;
	background-position: center;
}

.icon-declaration {
	background-image: url(resources/Complain-icon-after.png);
	justify-content: flex-end;
	background-size: 30px 30px;
	background-position: 10px center;
}

.icon-undeclaration {
	background-image: url(resources/Complain-icon-before.png);
	justify-content: flex-end;
	background-size: 30px 30px;
	background-position: 10px center;
}

.icon-comment-reply {
	background-image: url(resources/Reply-icon.png);
	justify-content: flex-end;
	background-size: 30px 30px;
	background-position: 10px center;
}

.icon-favorite {
	background-image: url(resources/Heart-icon-after.png);
	justify-content: flex-end;
	background-size: 30px 30px;
	background-position: 10px center;
}

.icon-unfavorite {
	background-image: url(resources/Heart-icon-before.png);
	justify-content: flex-end;
	background-size: 30px 30px;
	background-position: 10px center;
}

.icon-calender {
	width: 50px;
	background-image: url(resources/calender.png);
	background-repeat: no-repeat;
	background-size: 30px 30px;
	background-position: center;
}

.number-of-people {
	width: 150px;
	display: flex;
	justify-content: center;
	align-items: center;
}

.review-area {
	display: flex;
	align-items: center;
}

.review-header {
	width: 90%;
	margin: auto;
	display: flex;
	justify-content: space-around;
	align-items: center;
	margin-top: 10px;
}

.icon-recommand {
	width: 100px;
	height: 80%;
	display: flex;
	background-image: url(resources/Heart-icon-after.png);
	justify-content: flex-end;
	background-size: 30px 30px;
	background-position: left 10px center;
}

.icon-unrecommand {
	width: 100px;
	height: 80%;
	display: flex;
	background-image: url(resources/Heart-icon-before.png);
	justify-content: flex-end;
	background-size: 30px 30px;
	background-position: left 10px center;
}

.recommand-content {
	width: 50%;
	display: flex;
	justify-content: center;
	align-items: center;
}

.review-content {
	min-height: 400px;
	width: 90%;
	margin: auto;
}

.more-content {
	height: 50px;
	width: 90%;
	margin: 20px auto;
	text-align: center;
	line-height: 50px;
	justify-content: center;
}

.action-item-batch {
	display: flex;
	justify-content: flex-start;
}

#review-context {
	padding: 8px;
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

.starpoint_wrap {
	display: inline-block;
}

.starpoint_box {
	position: relative;
	background:
		url(https://ido-archive.github.io/svc/etc/element/img/sp_star.png) 0 0
		no-repeat;
	font-size: 0;
}

.starpoint_box .starpoint_bg {
	display: block;
	position: absolute;
	top: 0;
	left: 0;
	height: 18px;
	background:
		url(https://ido-archive.github.io/svc/etc/element/img/sp_star.png) 0
		-20px no-repeat;
	pointer-events: none;
}

.starpoint_box .label_star {
	display: inline-block;
	width: 10px;
	height: 10px;
	box-sizing: border-box;
}

.starpoint_box .star_radio {
	opacity: 0;
	width: 0;
	height: 0;
	position: absolute;
}

.starpoint_box .star_radio:nth-of-type(1):checked ~ .starpoint_bg {
	width: 10%;
}

.starpoint_box .star_radio:nth-of-type(2):checked ~ .starpoint_bg {
	width: 20%;
}

.starpoint_box .star_radio:nth-of-type(3):checked ~ .starpoint_bg {
	width: 30%;
}

.starpoint_box .star_radio:nth-of-type(4):checked ~ .starpoint_bg {
	width: 40%;
}

.starpoint_box .star_radio:nth-of-type(5):checked ~ .starpoint_bg {
	width: 50%;
}

.starpoint_box .star_radio:nth-of-type(6):checked ~ .starpoint_bg {
	width: 60%;
}

.starpoint_box .star_radio:nth-of-type(7):checked ~ .starpoint_bg {
	width: 70%;
}

.starpoint_box .star_radio:nth-of-type(8):checked ~ .starpoint_bg {
	width: 80%;
}

.starpoint_box .star_radio:nth-of-type(9):checked ~ .starpoint_bg {
	width: 90%;
}

.starpoint_box .star_radio:nth-of-type(10):checked ~ .starpoint_bg {
	width: 100%;
}

.blind {
	position: absolute;
	clip: rect(0, 0, 0, 0);
	margin: -1px;
	width: 1px;
	height: 1px;
	overflow: hidden;
}

.board-img-title {
	padding: 5px;
	width: 100%;
	height: 100%;
}
</style>
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");

	ObjectMapper mapper = new ObjectMapper();
	List<ReviewDto> review = (List<ReviewDto>) request.getAttribute("review");
	String jsonReview = mapper.writeValueAsString(review);

	List<ReplyDto> reply = (List<ReplyDto>) request.getAttribute("reply");
	String jsonReply = mapper.writeValueAsString(reply);

	SelectCategoryBoardListDto board_data = (SelectCategoryBoardListDto) request.getAttribute("board_data");
	String jsonBoard = mapper.writeValueAsString(board_data);
	%>
	<c:set var="index" value="0" />
	<jsp:include page="../common/header.jsp" />

	<div id="border-view-area">
		<div id="border-view-section">

			<c:if test="${owner == true}">
				<div id="section-modify-delete">
					<button class="btn-style btn-modify" onclick="updatePost();">수정</button>
					<button class="btn-style btn-delete" onclick="removePost();">삭제</button>
				</div>
			</c:if>

			<form action="" method="post" id="postForm">
				<input type="hidden" name="boardNo" value="${ board_data.boardNo }">
				<input type="hidden" name="categoryBoardNo" value="${ board_data.categoryBoardNo }">
			</form>

			<div id="section-main-image">
				<img class="board-img-title" src="${ board_data.categoryBoardImage}"
					alt="틀린이미지">
			</div>

			<div id="section-content">
				<div id="content-title-bar">
					<div class="inner-content-style">${ board_data.boardTitle }</div>
					<div class="inner-content-style">${ board_data.memberNicname }</div>
				</div>
				<div id="content">${ board_data.boardContent }</div>
			</div>
			<div style="display: flex; justify-content: space-between;">
				<div class="action-item-batch">
					<div id="section-border-info">
						<c:choose>
							<c:when test="${ recommandImg eq true }">
								<div class="icon-btn-style icon-favorite">
									<div class="border-info-icon-style" id="recommand"
										onclick="boardRecommand();">${ board_data.recommandNo }</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="icon-btn-style icon-unfavorite">
									<div class="border-info-icon-style" id="recommand"
										onclick="boardRecommand();">${ board_data.recommandNo }</div>
								</div>
							</c:otherwise>
						</c:choose>
					</div>

					<div id="section-border-info">
						<div class="icon-btn-style icon-comment-reply">
							<div class="border-info-icon-style" id="replyCount">${fn:length(reply)}</div>
						</div>
					</div>

					<div id="section-border-info">
						<c:choose>
							<c:when test="${ complainImg eq true }">
								<div class="icon-btn-style icon-declaration">
									<div class="border-info-icon-style" id="complain"
										onclick="boardComplain();">${ board_data.complain }</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="icon-btn-style icon-undeclaration">
									<div class="border-info-icon-style" id="complain"
										onclick="boardComplain();">${ board_data.complain }</div>
								</div>
							</c:otherwise>
						</c:choose>
					</div>

					<div id="section-border-info">
						<c:choose>
							<c:when test="${ scrapImg eq true }">
								<div class="icon-style icon-book-mark" id="scrap"
									onclick="boardScrap();"></div>
							</c:when>
							<c:otherwise>
								<div class="icon-style icon-unbook-mark" id="scrap"
									onclick="boardScrap();"></div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>

				<div id="section-group-behavior">
					<c:choose>
						<c:when test="${ join == true }">
							<div class="icon-btn-style icon-calender"
								onclick="goToCalender();"></div>
						</c:when>
						<c:otherwise>
						</c:otherwise>
					</c:choose>

					<div class="icon-btn-style number-of-people" id="headCount">${ board_data.currentCount }
						/ ${ board_data.maxCount }</div>
					<c:choose>
						<c:when test="${ join == true }">
							<button class="btn-joinable-style btn-unjoin" id="btn-unjoin"
								onclick="quit();">탈퇴하기</button>
						</c:when>
						<c:otherwise>
							<button class="btn-joinable-style btn-join" id="btn-join"
								onclick="join();">참여하기</button>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>

		<div id="reply-body">
			<jsp:include page="../common/reply.jsp">
				<jsp:param value="<%=jsonReply%>" name="reply" />
				<jsp:param value="<%=jsonBoard%>" name="board_data" />
				<jsp:param value="카테고리" name="type" />
			</jsp:include>
		</div>

		<div id="section-group-review">
			<div class="top-style review-area">
				<div class="inner-content-style">모임원의 리뷰</div>
			</div>

			<div class="bottom-style" id="padding-for-review">
				<div id="review-content">
					<c:choose>
						<c:when test="${fn:length(review) > 0}">
							<jsp:include page="category-review-item.jsp">
								<jsp:param value="${ index }" name="id" />
								<jsp:param value="${ review[index].reviewNo }" name="reviewId" />
								<jsp:param value="${ review[index].memberName }"
									name="memberName" />
								<jsp:param value="${ review[index].recommandNo }"
									name="recommandNo" />
								<jsp:param value="${ review[index].content }" name="content" />
								<jsp:param value="${ review[index].starNo }" name="starNo" />
								<jsp:param value="${ review[index].recommandFlag }"
									name="recommandFlag" />
							</jsp:include>
						</c:when>
						<c:otherwise>
							<div class="review-header">리뷰가 없습니다.</div>
						</c:otherwise>
					</c:choose>
				</div>
				<div class="icon-btn-style more-content" onclick="reviewMoreView();">더보기</div>
			</div>

		</div>
	</div>
	
	<br><br><br>
	<jsp:include page="../common/footer.jsp" />

	<script>		
		let clickCnt = 0;
		let reviews = <%=jsonReview%>;
		
    	function goToCalender() {
    		document.getElementById('postForm').action = "calender.me";
    		document.getElementById('postForm').submit();
    	}
    	
    	function join() {
    		let joinResult = confirm("소모임에 참여 하시겠습니까?");
    		
    		if(joinResult) {
    			$.ajax({
        			url: "joinClub.me",
        			method: "POST",
        			data: {
        				boardNo: <%=request.getParameter("board_id")%>
        			},
        			success: function(result) {    	    		
        				$('#headCount').text("${ board_data.currentCount + 1 } / ${ board_data.maxCount }");
        				$('#btn-join').remove();
        				$('#headCount').before('<div class="icon-btn-style icon-calender" onclick="goToCalender();"></div>');
        	    		$('#section-group-behavior').append('<button class="btn-joinable-style btn-unjoin" id="btn-unjoin" onclick="quit();">탈퇴하기</button>');    	    		
        			},
        			error: function (err) {
        				console.log(err);
        			},
        			complete: function () {
        			}
        		});	
    		}
    	}
    	
    	function quit() { 
    		let unJoinResult = confirm("소모임에 탈퇴 하시겠습니까?");
    		
    		if(unJoinResult) {
    			location.href="review.me?boardNo=" + <%=request.getParameter("board_id")%>;	
    		}
    	}
    	
    	function removePost() {
    		let removeResult = confirm("게시글을 삭제 하시겠습니까?");
    		
    		if(removeResult) {    			
	    		document.getElementById('postForm').action = "deleteCategoryBoard.me";
	    		document.getElementById('postForm').submit();
    		}
    	}
    	
    	function updatePost() {
    		document.getElementById('postForm').action = "updateCategoryBoard.me";
    		document.getElementById('postForm').submit();
    	}
    	
    	function reviewMoreView() {
    		clickCnt++;
    		<c:set var="indexCount" value="${index} + clickCnt" />
    		
    		if(${fn:length(review)} > ${indexCount}) {
    			$.ajax({
                    url: 'views/category/category-review-item.jsp',
                    method: 'GET',
                    data : {
                    	id: ${indexCount},
                    	reviewId: reviews[${indexCount}].reviewNo,
                        memberName: reviews[${indexCount}].memberName,
                        recommandNo: reviews[${indexCount}].recommandNo,
                        content: reviews[${indexCount}].content,
                        starNo: reviews[${indexCount}].starNo,
                        recommandFlag: reviews[${indexCount}].recommandFlag
                    },
                    success: function(data) {
                    	$('#review-content').append(data);	

                    },
                    error: function(status, error) {
                        console.error('AJAX 요청 오류:', status, error);
                    }
                });	
    		} else {
    			alert("더이상 리뷰가 없습니다.");
    		}
    	}
    	
    	function boardRecommand() {
    		$.ajax({
                url: 'BoardRecommand.me',
                method: 'GET',
                data : {
                	categoryNo: ${ board_data.categoryBoardNo },
                	boardNo: <%=request.getParameter("board_id")%>
                },
                success: function(data) {
                	console.log(data);
                	$('#recommand').text(data);
                	
                	if($('#recommand').parent().hasClass('icon-favorite')) {
                		 $('#recommand').parent().removeClass('icon-favorite');
                		 $('#recommand').parent().addClass('icon-unfavorite');
                    } else {
                    	$('#recommand').parent().removeClass('icon-unfavorite');
                    	$('#recommand').parent().addClass('icon-favorite');
                    }
                },
                error: function(status, error) {
                    console.error('AJAX 요청 오류:', status, error);
                }
            });	
    		
    	}
    	
    	function boardComplain() {
    		$.ajax({
                url: 'BoardComplain.me',
                method: 'GET',
                data : {
                	categoryNo: ${ board_data.categoryBoardNo },
                	boardNo: <%=request.getParameter("board_id")%>
                },
                success: function(data) {
                	console.log(data);
                	$('#complain').text(data);
                	
                	if($('#complain').parent().hasClass('icon-declaration')) {
               		  $('#complain').parent().removeClass('icon-declaration');
               		  $('#complain').parent().addClass('icon-undeclaration');
                    } else {
                   	  $('#complain').parent().removeClass('icon-undeclaration');
                   	  $('#complain').parent().addClass('icon-declaration');
                    }
                },
                error: function(status, error) {
                    console.error('AJAX 요청 오류:', status, error);
                }
            });	
    	}
    	
    	function boardScrap() {
    		$.ajax({
                url: 'BoardScrap.me',
                method: 'GET',
                data : {
                	categoryNo: ${ board_data.categoryBoardNo }
                },
                success: function(data) {
                	console.log(data);
                	if($('#scrap').hasClass('icon-book-mark')) {
                 		  $('#scrap').removeClass('icon-book-mark');
                 		  $('#scrap').addClass('icon-unbook-mark');
                      } else {
                     	  $('#scrap').removeClass('icon-unbook-mark');
                     	  $('#scrap').addClass('icon-book-mark');
                      }
                },
                error: function(status, error) {
                    console.error('AJAX 요청 오류:', status, error);
                }
            });	
    	}
    </script>
</body>
</html>