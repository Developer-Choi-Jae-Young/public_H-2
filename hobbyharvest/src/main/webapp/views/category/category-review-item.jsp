<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="top-style review-header" id="${ param.id }">
		<div class="review-title">${ param.memberName }</div>
		<div class="review-title">
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
					<input type="checkbox" name="starpoint" id="starpoint_1" class="star_radio" value="1" disabled> 
					<input type="checkbox"	name="starpoint" id="starpoint_2" class="star_radio" value="2" disabled>
					<input type="checkbox" name="starpoint" id="starpoint_3" class="star_radio" value="3" disabled> 
					<input type="checkbox"	name="starpoint" id="starpoint_4" class="star_radio" value="4" disabled>
					<input type="checkbox" name="starpoint" id="starpoint_5" class="star_radio" value="5" disabled> 
					<input type="checkbox" name="starpoint" id="starpoint_6" class="star_radio" value="6" disabled>
					<input type="checkbox" name="starpoint" id="starpoint_7" class="star_radio" value="7" disabled> 
					<input type="checkbox" name="starpoint" id="starpoint_8" class="star_radio" value="8" disabled>
					<input type="checkbox" name="starpoint" id="starpoint_9" class="star_radio" value="9" checked> 
					<input type="checkbox" name="starpoint" id="starpoint_10" class="star_radio" value="10" disabled>
					<span class="starpoint_bg"></span>
				</div>
			</div>
		</div>

		<c:choose>
			<c:when test="${ param.recommandFlag eq true }">
				<div class="icon-btn-style icon-recommand" onclick="recommand(${ param.reviewId }, ${ param.id });">
					<div class="recommand-content" id="recommand-${ param.id }">${ param.recommandNo }</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="icon-btn-style icon-unrecommand" onclick="recommand(${ param.reviewId }, ${ param.id });">
					<div class="recommand-content" id="recommand-${ param.id }">${ param.recommandNo }</div>
				</div>
			</c:otherwise>
		</c:choose>
		

	</div>

	<div class="bottom-style review-content">
		<div id="review-context">${ param.content }</div>
	</div>
	
	<script>		
		for(let i =0; i < $('#${param.id} input[name=starpoint]').length; i++) {
			if($('#${param.id} input[name=starpoint]')[i].value == ${ param.starNo } ) {
				$('#${param.id} input[name=starpoint]')[i].checked = true;
				$('#${param.id} input[name=starpoint]')[i].disabled = false;
			} else {
				$('#${param.id} input[name=starpoint]')[i].checked = false;
				$('#${param.id} input[name=starpoint]')[i].disabled = true;
			}
		}
		
		function recommand(reviewId, recommandId) {	
			$.ajax({
                url: 'reviewRecommand.me',
                method: 'GET',
                data : {
                	reviewNo: reviewId
                },
                success: function(data) {
                    $('#recommand-' + recommandId).text(data);
                    
                    if($('#recommand-' + recommandId).parent().hasClass('icon-recommand')) {
                    	 $('#recommand-' + recommandId).parent().removeClass('icon-recommand');
                    	 $('#recommand-' + recommandId).parent().addClass('icon-unrecommand');
                    } else {
                    	$('#recommand-' + recommandId).parent().removeClass('icon-unrecommand');
                    	$('#recommand-' + recommandId).parent().addClass('icon-recommand');
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