<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.h2.chuizone.member.model.vo.Member" %>
    <!DOCTYPE html>
    <html lang="en">
<head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>자주묻는 질문</title>
        <link rel="stylesheet" href="views/css/csPage.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
</head>
<body>
    <jsp:include page="customerServicePage.jsp"></jsp:include>
    <%
    Member m = new Member(1, "mId", "mPw", "mNickName", "email", "address", "phone");
    request.getSession().setAttribute("userInfo", m);
    %>
        <div class="faq">
        
            <h2>자주묻는 질문</h2>
            
            <div class="flip">
                <h5>Q. 소모임 개설은 어떻게 하나요?</h5>
            </div>
            <div class="flipa">A. 원하는 카테고리와 소분류를 선택하고, 모임에 대한 설명을 기재하여 등록해 주시면 됩니다.</div>
            
            <div class="flip">
                <h5>Q. 카테고리에 속해 있는 소분류를 추가하고 싶어요.</h5>
            </div>
            <div class="flipa">A. 1:1 문의 사항을 통해 건의해 주세요. 취존에서 내부 검토 후 신설해드리겠습니다. </div>
            
            <div class="flip">
                <h5>Q. 가입한 소모임에서 탈퇴하고 싶어요</h5>
            </div>
            <div class="flipa">A. 가입한 소모임 게시글에서 탈퇴하기 버튼을 눌러 주세요. 모임에 대한 리뷰를 등록하면 탈퇴 처리됩니다. 취존의 발전을 위해 여러분들의 다양한 의견을 부탁드립니다!</div>
            
            <div class="flip">
                <h5>Q. 소모임 일정을 확인하고 싶어요.</h5>
            </div>
            <div class="flipa">A. 내가 가입한 소모임 게시글로 이동하여 캘린더 버튼을 눌러 주세요. 소모임 일정을 한눈에 확인할 수 있습니다.</div>
            
            <div class="flip">
                <h5>Q. 아이디/비밀번호를 찾고 싶어요.</h5>
            </div>
            <div class="flipa">A. 로그인 창에서 아이디/비밀번호 찾기를 통해 찾을 수 있습니다. 가입 시 기입한 정보를 통해 찾을 수 있어요.</div>
            
        </div>
    </div>
    
    <script>

        $(function() {
        	$('.flip').click(function() {
        		let nextFlipa = $(this).next('.flipa');
                nextFlipa.slideDown();
                $('.flipa').not(nextFlipa).slideUp();
        	});
        });

    </script>
    
	<!-- Footer -->
	<jsp:include page="../common/footer.jsp"></jsp:include>


<body>
</html>
    