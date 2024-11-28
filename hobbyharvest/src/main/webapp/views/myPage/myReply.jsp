<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hobby Harvest</title>

    
</head>
<header>
		<jsp:include page="../common/header.jsp"></jsp:include>
	</header>
<div id="bodySection">
    <jsp:include page="myPageNav.jsp"></jsp:include>
    <div class="content">
        <div class="comment-list">
        
        	<c:forEach var="myReply" items="${ myReplyList }">
        	<a href="showBoard.me?board_id=${myReply.boardNo }">
            <div class="comment-item">
                <img src="${ myReply.img }" alt="Group Image">
                <div class="comment-info">
                    <h3>${ myReply.title }</h3>
                    <p>${ myReply.createDate }</p>
                    <p>${ myReply.reply }</p>
                </div>
            </div>
            </a>
            </c:forEach>
        </div>
        <c:if test="${pi.maxPage>1 }">
            <ul class="pagination justify-content-center">
				<li class="page-item"><a class="page-link" href="toMyReply.do?cpage=${ pi.currentPage-1 }">Previous</a></li>
				<c:forEach var="i" begin="${ pi.startPage }" end="${ pi.endPage }">
				<li class="page-item"><a class="page-link" href="toMyReply.do?cpage=${ i }">${ i }</a></li>
				</c:forEach>
				<li class="page-item"><a class="page-link" href="toMyReply.do?cpage=${ pi.currentPage+1 }">Next</a></li>
			</ul>
		</c:if>
    </div>
</div>
    <!-- Footer -->
    <jsp:include page="../common/footer.jsp"></jsp:include>
    
    
</body>
</html>

            


    <!-- Footer -->