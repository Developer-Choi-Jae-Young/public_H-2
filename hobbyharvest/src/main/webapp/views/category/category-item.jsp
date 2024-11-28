<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	#board {
		height: 40%;
		width: 15%;
		padding-top: 10px;
		padding-bottom: 10px;
		border: 1px solid #d9d9d9;
		border-radius: 10px;
		margin: 20px;
		cursor: pointer;
	}

	#board-img {
		background-color: white;
		height: 200px;
		width: 90%;
		margin: auto;
		margin-top: 5%;
		margin-bottom: 5%;
		border-radius: 10px;		
	}

	#board-info {
		background-color: white;
		height: 20%;
		width: 90%;
		margin: auto;
		margin-top: 5%;
		margin-bottom: 5%;
		border-radius: 10px;
	}
	
	.padding-5px {
		padding: 5px;
	}

	.height-20percent {
		height: 20%;
	}

	.height-60percent {
		height: 60%;
	}
	
	.float-left-style {
		float: left;
	}
	
	.text-align-right {
		text-align: right;
	}
	
	.board-img {
		width: 100%;
		height: 100%;
	}

</style>

</head>
<body>
	<c:forEach var="i" begin="0" end="${ pageing.boarderNum - 1 }" >
		<c:choose>
			<c:when test="${not empty board[i].boardNo}">
				<div id="board" onclick="showBoard(${board[i].boardNo});">
					<div id="board-img">
						<img class="board-img" src="${board[i].categoryBoardImage}">
					</div>
					<div id="board-info">
						<div class="padding-5px">
							<div class="height-20percent">
							    <c:choose>
							        <c:when test="${fn:length(board[i].boardTitle) > 10}">
							            ${fn:substring(board[i].boardTitle, 0, 10)}... (${board[i].smallGroupName})
							        </c:when>
							        <c:otherwise>
							            ${board[i].boardTitle} (${board[i].smallGroupName})
							        </c:otherwise>
							    </c:choose>
							</div>
							
							<div class="height-60percent">
							    <c:choose>
							        <c:when test="${fn:length(board[i].clubName) > 10}">
							            ${fn:substring(board[i].clubName, 0, 10)}...
							        </c:when>
							        <c:otherwise>
							           ${board[i].clubName}
							        </c:otherwise>
							    </c:choose>
							</div>
			
							<div class="height-20percent">
								<div class="float-left-style">
									<span>${board[i].memberNicname}</span>
								</div>
								<div class="text-align-right">
									<span>${board[i].currentCount}/${board[i].maxCount}</span>
								</div>
							</div>
						</div>
					</div>
				</div>	
			</c:when>
			<c:otherwise>
			</c:otherwise>
		</c:choose>
	</c:forEach>

	<script>
		function showBoard(id) {
			location.href="showBoard.me?board_id=" + id;
		}
	</script>
</body>
</html>