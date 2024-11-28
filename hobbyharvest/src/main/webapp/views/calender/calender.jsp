<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.h2.chuizone.calender.model.dto.CalenderDto"%>
<%@page import="java.util.List"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- jquery CDN -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- fullcalendar CDN -->
<link href='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css' rel='stylesheet' />
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js'></script>
<!-- fullcalendar 언어 CDN -->
<script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>

<style>
    html, body {
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
    font-size: 14px;
  }

  /* 캘린더 위의 해더 스타일(날짜가 있는 부분) */
  .fc-header-toolbar {
    padding-top: 1em;
    padding-left: 1em;
    padding-right: 1em;
  }

  .calender-frame {
    border: 1px solid; 
    width: 1000px; 
    height: 900px; 
    margin: auto; 
    display: flex; 
    justify-content: center; 
    align-items: center;
  }

  .calender-content-frame {
    width: 80%; 
    text-align: center;
  }

  .calender-title {
    font-size: 24px; 
    font-weight: 900; 
    margin: 20px;
  }

  .btn-style {
    display: flex; 
    justify-content: center; 
    align-items: center; 
    margin-top: 20px; 
    border: none; 
    border-radius: 10px; 
    width: 100px; 
    height: 50px;
  }
  
  .fc-day a {
  	color: black;
  }
  
  .fc-day-sun a {
      color: red;
  }
	  
  .fc-day-sat a {
      color: blue;
  }
  
  .fc .fc-button-primary { 
	  color: #FFFFF; 
	  background-color: #ffb7b7 !important; 
	  border-color: #ffb7b7 !important; 
  }
</style>

</head>
<body>
<%
	request.setCharacterEncoding("utf-8");

	ObjectMapper mapper = new ObjectMapper();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");        
	mapper.setDateFormat(dateFormat);
	List<CalenderDto> calender = (List<CalenderDto>)request.getAttribute("calender");
	String jsonCalender = mapper.writeValueAsString(calender);
%>
<jsp:include page="../common/header.jsp" />
<br><br><br>
    <div class="calender-frame">
        <div class="calender-content-frame">
            <div class="calender-title">[ <%= request.getAttribute("clubName") %> 모임 캘린더 ]</div>
            <div id='calendar-container'>
                <div id='calendar'></div>
            </div>
        </div>
    </div>
<br><br><br>
<jsp:include page="../common/footer.jsp" />
    <script>
    	let calender = <%= jsonCalender %>;
    	
    	let calenderList = [];
    	for(let i of calender) {
    		calenderList.push({
    			title: i.title,
                url: 'showCalender.me?boardNo=' + i.boardNo + "&cboardNo=" + '<%= request.getAttribute("boardNo") %>', // 클릭시 해당 url로 이동
                start: i.startDate,
                end: i.endDate
    		})
    	}

        (function(){
          $(function(){
            // calendar element 취득
            var calendarEl = $('#calendar')[0];
            // full-calendar 생성하기
            var calendar = new FullCalendar.Calendar(calendarEl, {
              height: '700px', // calendar 높이 설정
              expandRows: true, // 화면에 맞게 높이 재설정
              slotMinTime: '08:00', // Day 캘린더에서 시작 시간
              slotMaxTime: '20:00', // Day 캘린더에서 종료 시간
              // 해더에 표시할 툴바
              headerToolbar: {
                left: 'prev,next',
                center: 'title',
                right: 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
              },
              initialView: 'dayGridMonth', // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
              navLinks: true, // 날짜를 선택하면 Day 캘린더나 Week 캘린더로 링크
              editable: true, // 수정 가능?
              selectable: true, // 달력 일자 드래그 설정가능
              nowIndicator: true, // 현재 시간 마크
              dayMaxEvents: true, // 이벤트가 오버되면 높이 제한 (+ 몇 개식으로 표현)
              locale: 'ko', // 한국어 설정
              eventAdd: function(obj) { // 이벤트가 추가되면 발생하는 이벤트
              },
              eventChange: function(obj) { // 이벤트가 수정되면 발생하는 이벤트
              },
              eventRemove: function(obj){ // 이벤트가 삭제되면 발생하는 이벤트
              },
              select: function(arg) { // 캘린더에서 드래그로 이벤트를 생성할 수 있다.
                <!-- var title = prompt('Event Title:'); -->
                location.href = "calenderWrite.me?categoryBoardNo="+<%= request.getAttribute("categoryBoardNo")%>+
                		"&startDate=" + arg.startStr + "&endDate=" + arg.endStr + "&cboardNo=" + '<%= request.getAttribute("boardNo") %>';
                if (title) {
                  calendar.addEvent({
                    title: title,
                    start: arg.start,
                    end: arg.end,
                    allDay: arg.allDay
                  })
                }
                calendar.unselect()
              },
              // 이벤트 
              events: calenderList
            });
            // 캘린더 랜더링
            calendar.render();
          });
        })();
      </script>
</body>
</html>