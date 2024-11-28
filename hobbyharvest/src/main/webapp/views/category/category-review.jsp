<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
    [contenteditable]:empty:before {
        content: attr(placeholder);
        color: gray
    }

    .starpoint_wrap{
        display:inline-block;
    }

    .starpoint_box{
        position:relative;
        background:url(https://ido-archive.github.io/svc/etc/element/img/sp_star.png) 0 0 no-repeat;
        font-size:0;
    }

    .starpoint_box .starpoint_bg{
        display:block;
        position:absolute;
        top:0;
        left:0;
        height:18px;
        background:url(https://ido-archive.github.io/svc/etc/element/img/sp_star.png) 0 -20px no-repeat;
        pointer-events:none;
    }

    .starpoint_box .label_star{
        display:inline-block;
        width:10px;
        height:10px;
        box-sizing:border-box;
    }

    .starpoint_box .star_radio{
        opacity:0;
        width:0;
        height:0;
        position:absolute;
    }

    .starpoint_box .star_radio:nth-of-type(1):hover ~ .starpoint_bg,
    .starpoint_box .star_radio:nth-of-type(1):checked ~ .starpoint_bg{
        width:10%;
    }

    .starpoint_box .star_radio:nth-of-type(2):hover ~ .starpoint_bg,
    .starpoint_box .star_radio:nth-of-type(2):checked ~ .starpoint_bg{
        width:20%;
    }

    .starpoint_box .star_radio:nth-of-type(3):hover ~ .starpoint_bg,
    .starpoint_box .star_radio:nth-of-type(3):checked ~ .starpoint_bg{
        width:30%;
    }

    .starpoint_box .star_radio:nth-of-type(4):hover ~ .starpoint_bg,
    .starpoint_box .star_radio:nth-of-type(4):checked ~ .starpoint_bg{
        width:40%;
    }

    .starpoint_box .star_radio:nth-of-type(5):hover ~ .starpoint_bg,
    .starpoint_box .star_radio:nth-of-type(5):checked ~ .starpoint_bg{
        width:50%;
    }

    .starpoint_box .star_radio:nth-of-type(6):hover ~ .starpoint_bg,
    .starpoint_box .star_radio:nth-of-type(6):checked ~ .starpoint_bg{
        width:60%;
    }

    .starpoint_box .star_radio:nth-of-type(7):hover ~ .starpoint_bg,
    .starpoint_box .star_radio:nth-of-type(7):checked ~ .starpoint_bg{
        width:70%;
    }

    .starpoint_box .star_radio:nth-of-type(8):hover ~ .starpoint_bg,
    .starpoint_box .star_radio:nth-of-type(8):checked ~ .starpoint_bg{
        width:80%;
    }

    .starpoint_box .star_radio:nth-of-type(9):hover ~ .starpoint_bg,
    .starpoint_box .star_radio:nth-of-type(9):checked ~ .starpoint_bg{
        width:90%;
    }

    .starpoint_box .star_radio:nth-of-type(10):hover ~ .starpoint_bg,
    .starpoint_box .star_radio:nth-of-type(10):checked ~ .starpoint_bg{
        width:100%;
    }

    .blind{
        position:absolute;
        clip:rect(0 0 0 0);
        margin:-1px;
        width:1px;
        height: 1px;
        overflow:hidden;
    }

    .btn-style {
        border: none; 
        border-radius: 10px; 
        width: 100px; 
        height: 50px;
    }

    .review-write-frame {
        width: 1400px; 
        margin: auto;
    }

    .review-area {
        width: 70%; 
        border: 1px solid;
        margin: auto;
    }

    .review-write-title {
        border: 1px solid; 
        border-radius: 10px; 
        text-align: center; 
        height: 50px; 
        line-height: 50px; 
        margin: 10px;
    }

    .review-title-area {
        margin: 10px;
    }

    .review-title {
        border: 1px solid; 
        border-top-left-radius: 10px; 
        border-top-right-radius: 10px; 
        border-bottom: none; 
        padding: 10px;
    }

    .review-title-content{
        border: 1px solid; 
        border-bottom-left-radius: 10px; 
        border-bottom-right-radius: 10px; 
        padding: 10px;
    }

    .review-star-area {
        margin: 10px;
    }

    .review-content-title {
        border-bottom: 1px solid; 
        padding: 10px;
    }

    .review-content-area {
        border: 1px solid; 
        border-radius: 10px; 
        margin: 10px;
    }

    .content {
        margin: 10px; 
        min-height: 200px;
    }

    .btn-frame {
        padding: 10px;
    }
</style>

</head>
<body>
	<jsp:include page="../common/header.jsp" />
	<br><br><br>
	<form id="review-my-form" action="unjoinClub.me" method="post">
	    <div class="review-write-frame">
	        <div class="review-area">
	        	<input type="hidden" name="boardNo" value="<%= request.getAttribute("boardNo") %>">
	            <div class="review-write-title">리뷰 작성</div>
	
	            <div class="review-title-area">
	                <div class="review-title">제목</div>
	                <div class="review-title-content" contenteditable placeholder='제목을 입력해 주세요...' id="div-review-title"></div>
	                <input type="hidden" name="title" id="hidden-review-title">
	            </div>
	
	            <div class="review-star-area">
	                <div class="starpoint_wrap">
	                    <div class="starpoint_box">
	                      <label for="starpoint_1" class="label_star" title="0.5"><span class="blind">0.5점</span></label>
	                      <label for="starpoint_2" class="label_star" title="1"><span class="blind">1점</span></label>
	                      <label for="starpoint_3" class="label_star" title="1.5"><span class="blind">1.5점</span></label>
	                      <label for="starpoint_4" class="label_star" title="2"><span class="blind">2점</span></label>
	                      <label for="starpoint_5" class="label_star" title="2.5"><span class="blind">2.5점</span></label>
	                      <label for="starpoint_6" class="label_star" title="3"><span class="blind">3점</span></label>
	                      <label for="starpoint_7" class="label_star" title="3.5"><span class="blind">3.5점</span></label>
	                      <label for="starpoint_8" class="label_star" title="4"><span class="blind">4점</span></label>
	                      <label for="starpoint_9" class="label_star" title="4.5"><span class="blind">4.5점</span></label>
	                      <label for="starpoint_10" class="label_star" title="5"><span class="blind">5점</span></label>
	                      <input type="radio" name="starpoint" id="starpoint_1" class="star_radio" value="1">
	                      <input type="radio" name="starpoint" id="starpoint_2" class="star_radio" value="2">
	                      <input type="radio" name="starpoint" id="starpoint_3" class="star_radio" value="3">
	                      <input type="radio" name="starpoint" id="starpoint_4" class="star_radio" value="4">
	                      <input type="radio" name="starpoint" id="starpoint_5" class="star_radio" value="5">
	                      <input type="radio" name="starpoint" id="starpoint_6" class="star_radio" value="6">
	                      <input type="radio" name="starpoint" id="starpoint_7" class="star_radio" value="7">
	                      <input type="radio" name="starpoint" id="starpoint_8" class="star_radio" value="8">
	                      <input type="radio" name="starpoint" id="starpoint_9" class="star_radio" value="9">
	                      <input type="radio" name="starpoint" id="starpoint_10" class="star_radio" value="10">
	                      <span class="starpoint_bg"></span>
	                    </div>
	                  </div>
	            </div>
	
	            <div class="review-content-area">
	                <div>
	                    <div class="review-content-title">내용</div>
	                </div>
	                
	                <div class="content" contenteditable placeholder='내용을 입력해 주세요...' id="div-review-content"></div>
	                <input type="hidden" name="content" id="hidden-review-content">
	            </div>
	            
	            <div class="btn-frame">
	                <button class="btn-style" type="button" onclick="reviewCancel();">취소</button>
	                <button class="btn-style" type="submit">등록</button>
	            </div>
	        </div>
	    </div>
    </form>
    <br><br><br>
    <jsp:include page="../common/footer.jsp" />
    
     <script>
        // 폼 제출 전 div 내용 추출
        function prepareFormData() {
            const contentDiv = document.getElementById('div-review-content');
            const titleDiv = document.getElementById('div-review-title');
            const hiddenInputContent = document.getElementById('hidden-review-content');
            const hiddenInputTitle = document.getElementById('hidden-review-title');

            // div의 HTML 내용을 가져와서 hidden input 필드에 설정
            hiddenInputContent.value = contentDiv.innerHTML;
            hiddenInputTitle.value = titleDiv.innerHTML;
        }

        // 폼 제출 시 prepareFormData 함수 호출
        document.getElementById('review-my-form').addEventListener('submit', function(event) {
            prepareFormData();
        });
        
        function reviewCancel() {
			let result = confirm("리뷰 작성을 그만하겠습니까?");
        	
        	if(result) {
        		history.back();
        	}
        }
    </script>
</body>
</html>