<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>고객센터</title>
</head>
<body>

		<% String contextPath = request.getContextPath(); %>
            <!-- Header -->
            <header>
                <jsp:include page="../common/header.jsp"></jsp:include>
            </header>
            
            <div id="bodySection">
                <!-- Sidebar -->
                <div id="side-bar">
                    <ul>
                        <li><a href="toFaqPage.do" class="inquiry-menu">자주 묻는 질문</a></li>
                        
                        <c:if test="${ !empty loginUser }">
                        	<li><a href="toPiPage.do" class="inquiry-menu">1:1 문의</a></li>
                        </c:if>
                        
                    </ul>
                </div>
                
                <!-- Main Content -->

    <script>
    	
    </script>
</body>
</html>

            
      
        
    