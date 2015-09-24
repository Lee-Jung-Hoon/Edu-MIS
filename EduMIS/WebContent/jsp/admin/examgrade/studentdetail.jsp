<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script>
google.load('visualization', '1', {packages: ['corechart', 'line']});
google.setOnLoadCallback(drawBasic);
var num=1;

function drawBasic() {

      var data = new google.visualization.DataTable();
      data.addColumn('number', '회차');
      data.addColumn('number', '점수');
      
      <c:forEach var="list" items="${list}">
		data.addRows([ [Number(num++), Number("${list.score}")]]);
		</c:forEach>

      var options = {
        hAxis: {
          title: '회차'
        },
        vAxis: {
          title: '점수'
        },
        width: 900,
        height: 500
      };

      var chart = new google.visualization.LineChart(document.getElementById('chart_div'));

      chart.draw(data, options);
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
							<h2>성적 상세보기</h2>
							<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->

							<div class="">
							<input type="button" value="목록" onclick="location.href='/EduMIS/jsp/admin/examgrade/exammain.jsp'">
								<div>
									<table class="table-board">
										<tr>
											<th>이름</th>
											<td>${member.name}</td>
										</tr>
										
										<tr>
											<th>아이디</th>
											<td>${member.id}</td>
										</tr>
										
										<tr>
											<th>생년월일</th>
											<td>${member.year}/${member.month}/${member.day}</td>
										</tr>
										
										<tr>
											<th>가입일</th>
											<td>${member.joinDate}</td>
										</tr>
									</table>
								</div>
								<div style="width: 900px; height: 500px" id="chart_div"></div>
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
