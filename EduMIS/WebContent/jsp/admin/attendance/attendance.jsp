<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title>출석</title>
<link href="/EduMIS/css/attstyle.css" rel="stylesheet">
<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="/EduMIS/jsp/admin/attendance/httprequest.js"></script>
<script>
	var id = "";
	var date;
	$(document).ready(function () {
		var param = {mNo:"1"};
		id = 'kCalendar';
		date = 
// 		kCalendar('kCalendar');
		sendRequest("/EduMIS/attendance/memAttList.do", param, kCalendar, "GET");
	});
	
	function kCalendar() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				var kCalendar = document.getElementById(id);
				var attMemList = eval(httpRequest.responseText);
				var calendar = '';
				
				calendar += "테스트 리스트갯수 : "+attMemList.length+"명";
				
				
				
				if( typeof( date ) !== 'undefined' ) {
					date = date.split('-');
					date[1] = date[1] - 1;
					date = new Date(date[0], date[1], date[2]);
				} else {
					var date = new Date();
				}
				var currentYear = date.getFullYear();
				//년도를 구함
				
				var currentMonth = date.getMonth() + 1;
				//연을 구함. 월은 0부터 시작하므로 +1, 12월은 11을 출력
				
				var currentDate = date.getDate();
				//오늘 일자.
				
				date.setDate(1);
				var currentDay = date.getDay();
				//이번달 1일의 요일은 출력. 0은 일요일 6은 토요일
				
				var dateString = new Array('sun', 'mon', 'tue', 'wed', 'thu', 'fri', 'sat');
				var dateUTF = new Array('일', '월', '화', '수', '목', '금', '토');
				var lastDate = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
				if( (currentYear % 4 === 0 && currentYear % 100 !== 0) || currentYear % 400 === 0 )
					lastDate[1] = 29;
				//각 달의 마지막 일을 계산, 윤년의 경우 년도가 4의 배수이고 100의 배수가 아닐 때 혹은 400의 배수일 때 2월달이 29일 임.
				
				var currentLastDate = lastDate[currentMonth-1];
				var week = Math.ceil( ( currentDay + currentLastDate ) / 7 );
				//총 몇 주인지 구함.
				
				
				//이전달 버튼 누를때
				if(currentMonth != 1)
					var prevDate = currentYear + '-' + ( currentMonth - 1 ) + '-' + currentDate;
				else
					var prevDate = ( currentYear - 1 ) + '-' + 12 + '-' + currentDate;
				//만약 이번달이 1월이라면 1년 전 12월로 출력.
				
				
				if(currentMonth != 12) {
					//다음달 버튼 누를떄
					var nextDate = currentYear + '-' + ( currentMonth + 1 ) + '-' + currentDate;
				}
				else{
					var nextDate = ( currentYear + 1 ) + '-' + 1 + '-' + currentDate;
				//만약 이번달이 12월이라면 1년 후 1월로 출력.
					
				}
		
				
				if( currentMonth < 10 )
					var currentMonth = '0' + currentMonth;
				//10월 이하라면 앞에 0을 붙여준다.
				
				
				calendar += '<div id="header">';
				calendar += '			<span><a href="#" class="button left" onclick="kCalendar(\'' +  id + '\', \'' + prevDate + '\')"><</a></span>';
				calendar += '			<span id="date">' + currentYear + '년 ' + currentMonth + '월</span>';
				calendar += '			<span><a href="#" class="button right" onclick="kCalendar(\'' + id + '\', \'' + nextDate + '\')">></a></span>';
				calendar += '		</div>';
		//		calendar += '			<thead>';
		//		calendar += '				<tr>';
		//		calendar += '				  <th class="sun" scope="row">일</th>';
		//		calendar += '				  <th class="mon" scope="row">월</th>';
		//		calendar += '				  <th class="tue" scope="row">화</th>';
		//		calendar += '				  <th class="wed" scope="row">수</th>';
		//		calendar += '				  <th class="thu" scope="row">목</th>';
		//		calendar += '				  <th class="fri" scope="row">금</th>';
		//		calendar += '				  <th class="sat" scope="row">토</th>';
		//		calendar += '				</tr>';
		//		calendar += '			</thead>';
				calendar += '		<table class="attend" border="1" width="1050" cellspacing="0" cellpadding="0" style="margin: 5px 0 0 10px">';
				calendar += '			<caption>' + currentYear + '년 ' + currentMonth + '월 달력</caption>';
				calendar += '			<tbody>';
				
				var dateNum = 1 - currentDay;
				
				calendar += '			<tr>';
				calendar += '			<td rowspan="2">이름</td>';
				// 여기에 이름 뿌려줌....
				for(var i = 0; i < week; i++) {
					for(var j = 0; j < 7; j++, dateNum++) {
						if( dateNum < 1 || dateNum > currentLastDate ) {
							calendar += '				<td class="' + dateString[j] + ' test"> </td>';
							continue;
						}
						calendar += '				<td class="' + dateString[j] + '">' + dateNum + '</td>';
					}
				}
				calendar += '			</tr>';
				
				// 요일을 써주기 위해 재선언 
				dateNum = 1 - currentDay;
				
				calendar += '			<tr >';
				for(var i = 0; i < week; i++) {
					for(var j = 0; j < 7; j++, dateNum++) {
						if( dateNum < 1 || dateNum > currentLastDate ) {
							calendar += '				<td class="' + dateString[j] + ' test"> </td>';
							continue;
						}
						calendar += '				<td class="' + dateString[j] + '">' + dateUTF[j] + '</td>';
					}
				}
				calendar += '			</tr>';
				calendar += '			</tbody>';
				calendar += '		</table>';
				
				kCalendar.innerHTML = calendar;
			}
		}
	}

</script>
</head>
<body class="page-join">
	<div class="wrap">
		<div class="wrap-inner">
			<aside>
				<h2>MENU</h2>
				<ul>
					<li><a href="#">과제 제출 게시판</a></li>
					<li><a href="#">교육생관리</a></li>
					<li><a href="#">조짜기</a></li>
					<li><a href="#">메시지 히스토리</a></li>
				</ul>
			</aside>
			<div class="container">
				<header class="header">
					<button type="button" class="btn-menu">
						<span></span> <span></span> <span></span> <span></span>
					</button>
					<!-- 메시지 들어가는 부분 -->
					<div class="top-message">
						<button type="button" class="btn-message">
							<img src="/EduMIS/images/message.png" alt="" /> <span
								class="count">1<!-- 메시지 개수 --></span>
						</button>
						<div class="message-layer">
							<button type="button" class="btn-message-close">닫기</button>
							<div class="message-frame">
								<!-- 메시지 작업 시작영역 -->
								<!--  메시지 작업 시작영역 끝 -->
							</div>
						</div>
					</div>
					<!-- 메시지 들어가는 부분 끝 -->
					<ul>
						<li><a href="#"><img src="/EduMIS/images/icon-user.png"
								alt="" />마이페이지</a></li>
						<li class="login"><a href="#">로그인</a>
							<div class="login-form">
								<form action="" method="">
									<input type="text" placeholder="아이디" /> <input type="password"
										placeholder="비밀번호" /> <span><input type="checkbox"
										id="save" /><label for="save">아이디 저장하기</label></span> <input
										type="submit" value="LOGIN" class="btn-submit" />
								</form>
								<button type="button" class="btn-close">닫기</button>
							</div></li>
						<li><a href="#">회원가입</a></li>
					</ul>
				</header>
				<div class="container-inner">
					<div class="content">
						<!--  test-class 부분을  s-aaa 형식의 이름으로 클래스 잡아주세요  common 클래스 이름은 지우지 마세요 -->
						<section class="test-class common">
							<!--  작업부분 제목 써주세요 -->
							<h2>출석부</h2>
							<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->
							<div id="kCalendar"></div>
							<!--  작업완료 부분 -->
						</section>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="/EduMIS/js/common.js"></script>
</html>
