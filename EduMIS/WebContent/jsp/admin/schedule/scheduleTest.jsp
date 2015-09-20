<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title>제목</title>
<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script>
	// 날짜 객체를 얻어온다.
	var date = new Date();
	var y = date.getFullYear();
	var m = date.getMonth();
	var firstdate = new Date(y, m, 1);
	var firstday = firstdate.getDay();
	var startnum = eval(firstday + 1);
	var lastdate = new Date(y, m + 1, 0);
	var lastday = lastdate.getDate();
	// 전달
	var nMonth = m + 1;

	$(document).ready(
			function() {

				$(".btn-txt1").on("click", function() {
					$(".writeForm").css({
						color : "orange",
						display : "block"
					});

				});

				for (var i = 1; i <= lastday; i++) {
					$("#date" + startnum).html(i);
					startnum++;
				}

				$("#month-name").html(y + "년 " + nMonth);

				// 다음을 선택할 경우 다음 달로 넘어간다.

				var month = [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월",
						"9월", "10월", "11월", "12월" ];

				$("#next-month").on("click", function() {

					firstdate = new Date(y, nMonth, 1);
					firstday = firstdate.getDay();
					startnum = eval(firstday + 1);

					++nMonth;
					lastdate = new Date(y, nMonth, 0);
					lastday = lastdate.getDate();

					for (var i = 1; i <= 35; i++) {
						$("#date" + i).html("");
					}

					for (var i = 1; i <= lastday; i++) {
						$("#date" + startnum).html(i);
						startnum++;
					}

					// 월 정보를 중앙에 보여준다.
					if (nMonth > 12) {
						y += 1;
						nMonth = 1;
					}

					$("#month-name").html(y + "년" + nMonth);

				});

				$("#prev-month").on("click", function() {
					nMonth--;
					firstdate = new Date(y, nMonth, 1);
					firstday = firstdate.getDay();
					startnum = eval(firstday + 1);
					lastdate = new Date(y, nMonth + 1, 0);
					lastday = lastdate.getDate();
					for (var i = 1; i <= 35; i++) {
						$("#date" + i).html("");

					}
					for (var i = 1; i <= lastday; i++) {

						$("#date" + startnum).html(i);
						startnum++;
					}

					if (nMonth < 1) {
						y -= 1;
						nMonth = 12;
					}

					$("#month-name").html(y + "년" + nMonth);
					// 					$("#month-name").html(y);
				});

				// 월 정보를 불러낸다.

				var sizeArray = [ '60px', '180px', '300px', '420px', '540px',
						'660px', '780px' ]
				$(".test00 td").on(
						"click",
						function() {
							var index = $(this).index();
							if ($(this).hasClass('open')) {
								$('.test00 td').removeClass('open');
								$('.test01').slideUp();
							} else if ($(this).siblings().hasClass('open')) {
								$('.test00 td').removeClass('open');
								$(this).addClass('open').parents(".test00")
										.next().slideDown().find('span').css(
												'left', sizeArray[index]);
							} else {
								$('.test00 td').removeClass('open');
								$('.test01').slideUp();
								$(this).addClass('open').parents(".test00")
										.next().slideDown().find('span').css(
												'left', sizeArray[index]);
							}
						});
			});
</script>
<style type="text/css">
#prev-month {
	position: absolute;
	top: 120px;
	left: 300px;
}

#next-month {
	position: absolute;
	top: 120px;
	left: 530px;
}

.test01 span {
	width: 12px;
	height: 12px;
	display: block;
	background: #dddddd;
	position: absolute;
	top: -7.2px;
	margin-left: -6px;
	transform: rotate(45deg);
	border-left: 1px solid #cccccc;
	border-top: 1px solid #cccccc;
}

.test01 {
	position: relative;
	display: none;
	width: 841px;
	height: 100px;
	box-sizing: border-box;
	background: #dddddd;
	border-right: 1px solid #cccccc;
	border-left: 1px solid #cccccc;
	border-bottom: 1px solid #cccccc;
	overflow: visible !important;
	/* 	border: 1px solid #cccccc; */
}

table {
	border: 1px solid #cccccc;
}

.tb-1line td, .tb-2line td, .tb-3line td, .tb-4line td, .tb-5line td {
	width: 120px;
	height: 120px;
	border-bottom: 1px solid #cccccc;
	border-left: 1px solid #cccccc;
	box-sizing: border-box;
}

.tb-1line, .tb-2line, .tb-3line, .tb-4line, .tb-5line {
	border-right: 1px solid #cccccc;
}

.tb-0line th {
	width: 120px;
	font-weight: bold;
	height: 30px;
	border-bottom: 1px solid #cccccc;
}

.selected {
	background-color: #cccccc;
}

.top {
	width: 841px;
	height: 10px;
}

#topTd1, #topTd3, #topTd2 {
	width: 5%;
	text-align: center;
}

#topTd4 {
	width: 35%;
	text-align: right;
}

#topTd5 {
	width: 40%;
	text-align: right;
}

.test th, .test td {
	height: auto;
}
/* table {border-collapse:collapse;border-spacing:0;} */
table {
	border: 0;
	border-collapse: separate;
	border-spacing: 0;
}
</style>



<style type="text/css">
.writeForm {
width: 500px;
height: 800px;
	position: absolute;
	top: 300px;
	left 300px;
	display: none;
	background-color: white;
	border: 1px solid red;
}
</style>








</head>
<body class="page-join btn-page">

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
<div class="writeForm">
						<h2>일정등록</h2>
						<hr>
						<table>
							<tr>
								<th>일시</th>
								<td><input type="text" /> ~ <input type="text" /></td>
							</tr>
							<tr>
								<th>제목</th>
								<td><input type="text" /></td>
							</tr>
							<tr>
								<th>메모</th>
								<td><textarea cols="120" rows="10"></textarea></td>
							</tr>
							<tr>
								<th rowspan="2">장소</th>
							</tr>
							<tr>
								<th rowspan="2"><textarea></textarea></th>
							</tr>
						</table>
					</div>
							<!--  작업부분 제목 써주세요 -->
							<h2>일정표</h2>
							<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->



							<div class="">
								<div>
									<table class="top">
										<tr>
											<td id="topTd1"><input type="button"
												class="btn-txt txt-daily" value="일간" style="width: 40px"></td>
											<td id="topTd2"><input type="button"
												class="btn-txt txt-weekly" value="주간" style="width: 40px"></td>
											<td id="topTd3"><input type="button"
												class="btn-txt txt-monthly" value="월간" style="width: 40px"></td>
											<td id="topTd4"><input type="button" id="prev-month"
												value="이전" class="btn-txt txt-search" style="width: 40px;">
												&nbsp;&nbsp;&nbsp;<span id="month-name"></span>월
												&nbsp;&nbsp;&nbsp;<input type="button" id="next-month"
												value="다음" class="btn-txt txt-search" style="width: 40px;"></td>
											<td id="topTd5"><input type="button" value="검색"
												class="btn-txt txt-search"
												style="width: 40px; float: right;"> <input
												type="text" placeholder="검색어를 입력하세요" size="20px"
												style="float: right;"></td>
										</tr>

									</table>
								</div>
								<br /> <br /> <br />

								<div>
									<table class="tb-0line">
										<tr>
											<th style="color: red;">일</th>
											<th>월</th>
											<th>화</th>
											<th>수</th>
											<th>목</th>
											<th>금</th>
											<th style="color: blue;">토</th>
										</tr>
									</table>
								</div>
								<div class="test01">
									<input type="button" class="btn-txt1 txt-plan" id="writeBt"
										style="width: 60px;">
								</div>
								<div class="test00">
									<table class="tb-1line">
										<tr>
											<td id="date1"></td>
											<td id="date2"></td>
											<td id="date3"></td>
											<td id="date4"></td>
											<td id="date5"></td>
											<td id="date6"></td>
											<td id="date7"></td>
										</tr>
									</table>
								</div>
								<div class="test01">
									<span></span> <input type="button" class="btn-txt1 txt-plan"
										id="writeBt" style="width: 60px">
								</div>
								<div class="test00">
									<table class="tb-2line">
										<tr>
											<td id="date8"></td>
											<td id="date9"></td>
											<td id="date10"></td>
											<td id="date11"></td>
											<td id="date12"></td>
											<td id="date13"></td>
											<td id="date14"></td>
										</tr>
									</table>
								</div>
								<div class="test01">
									<span></span> <input type="button" class="btn-txt1 txt-plan"
										id="writeBt" style="width: 60px">
								</div>
								<div class="test00">
									<table class="tb-3line">
										<tr>
											<td id="date15"></td>
											<td id="date16"></td>
											<td id="date17"></td>
											<td id="date18"></td>
											<td id="date19"></td>
											<td id="date20"></td>
											<td id="date21"></td>
										</tr>
									</table>
								</div>
								<div class="test01">
									<span></span> <input type="button" class="btn-txt1 txt-plan"
										id="writeBt" style="width: 60px">
								</div>
								<div class="test00">
									<table class="tb-4line">
										<tr>
											<td id="date22"></td>
											<td id="date23"></td>
											<td id="date24"></td>
											<td id="date25"></td>
											<td id="date26"></td>
											<td id="date27"></td>
											<td id="date28"></td>
										</tr>
									</table>
								</div>
								<div class="test01">
									<span></span> <input type="button" class="btn-txt1 txt-plan"
										id="writeBt" style="width: 60px">
								</div>
								<div class="test00">
									<table class="tb-5line">
										<tr>
											<td id="date29"></td>
											<td id="date30"></td>
											<td id="date31"></td>
											<td id="date32"></td>
											<td id="date33"></td>
											<td id="date34"></td>
											<td id="date35"></td>
										</tr>

									</table>
								</div>
								<div class="test01">
									<span></span> <input type="button" class="btn-txt txt-plan"
										id="writeBt" style="width: 60px">
								</div>
							</div>
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
