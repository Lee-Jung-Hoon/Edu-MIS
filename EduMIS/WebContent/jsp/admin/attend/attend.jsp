<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width">
	<title>출석률</title>
	<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
	<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
	<script>
	google.load('visualization', '1', {packages: ['corechart', 'bar']});
	google.setOnLoadCallback(drawStacked);
	
	var no=0;
	
	function drawStacked() {
	  var name = new Array('${listSize}');
	  var attend = new Array('${listSize}');
	  var lateness = new Array('${listSize}');
	  var early = new Array('${listSize}');
	  var absend = new Array('${listSize}');
		var count = 0;
	  
		  <c:forEach var="list" items="${list}">
		  			name[count] = '${list.mName}'
						count++;
		  			if(count=='${listSize}')
		  			  count=0;
			</c:forEach>
	    
			
		  <c:forEach var="list1" items="${list1}">
		  			attend[count] = Number('${list1.attType}')
						count++;
		  			if(count=='${listSize}')
		  			  count=0;
			</c:forEach>
			
		  <c:forEach var="list2" items="${list2}">
		  			lateness[count] = Number('${list2.attType}')
						count++;
		  			if(count=='${listSize}')
		  			  count=0;
			</c:forEach>
			
		  <c:forEach var="list3" items="${list3}">
		  			early[count] = Number('${list3.attType}')
							count++;
		  			if(count=='${listSize}')
		  			  count=0;
			</c:forEach>
		  <c:forEach var="list4" items="${list4}">
		  			absend[count] = Number('${list4.attType}')
						count++;
		  			if(count=='${listSize}')
		  			  count=0;
			</c:forEach>
			

			
		
		   
	      var data = google.visualization.arrayToDataTable([
	        ['자바73기', '출석', '지각','조퇴','결석'],
	        <c:forEach var="list" begin="0" end="${listSize-1}">
	        [name['${list}'],Number(attend['${list}']),Number(lateness['${list}']),Number(early['${list}']),Number(absend['${list}'])],
					</c:forEach>

	      ]);

	      var options = {
	        title: '자바 73기 출석률',
	        chartArea: {width: '50%'},
	        isStacked: 'percent',
	        legend: {position: 'top', maxLines: 1},

	        hAxis: {
	          title: '출석률(%)',
	          minValue: 0,
	          ticks: [0, .2, .4, .6, .8, 1]
	        },
	        vAxis: {
	          title: 'Java'
	        },
	        bar: { groupWidth: "30%" }
	      };
	      var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
	      chart.draw(data, options);
	    }
	</script>
	
	<style>
	.tb-test {
	border: 1px solid black;
	}
	.tb-test tr,td,th{
	border: 1px solid black;
	}
	#chart_div2 {
		padding-left:1px;
	}
	#chart_div2 ul {
		margin-left:-1px;
		padding: 2px;
	}
	#chart_div2 li {
		border-bottom:1px solid #ddd;

	}
	#chart_div2 li:last-child {
		border:0;
	}
	</style>
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
						  <span></span>
						  <span></span>
						  <span></span>
						  <span></span>
					</button>
					<!-- 메시지 들어가는 부분 -->
					<div class="top-message">
						<button type="button" class="btn-message">
							<img src="/EduMIS/images/message.png" alt="" />
							<span class="count">1<!-- 메시지 개수 --></span>
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
						<li><a href="#"><img src="/EduMIS/images/icon-user.png" alt="" />마이페이지</a></li>
						<li class="login">
							<a href="#">로그인</a>
							<div class="login-form">
								<form action="" method="">
									<input type="text"  placeholder="아이디" />
									<input type="password"  placeholder="비밀번호" />
									<span><input type="checkbox" id="save" /><label for="save">아이디 저장하기</label></span>
									<input type="submit" value="LOGIN" class="btn-submit" />
								</form>
								<button type="button" class="btn-close">닫기</button>
							</div>
						</li>
						<li><a href="#">회원가입</a></li>
					</ul>
				</header>
				<div class="container-inner">
					<div class="content">
					<!--  test-class 부분을  s-aaa 형식의 이름으로 클래스 잡아주세요  common 클래스 이름은 지우지 마세요 -->
						<section class="test-class common">
							<!--  작업부분 제목 써주세요 --><h2>자바반 출석률 통계</h2>
							<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->

							<div id="chart_div" style="width: 938px; height: 1000px;">
								
							</div>
							<div id="chart_div2" style="overflow:hidden; width:100%;">
								<ul style="float:left; width:20%; border:1px solid #ddd; box-sizing:border-box;">
									<li>이름</li>
									<c:forEach var="list" items="${list}">
										<li>${list.mName}</li>
									</c:forEach>
								</ul>
								<ul style="float:left; width:20%; border:1px solid #ddd; box-sizing:border-box;">
									<li background-color: green;>출석</li>
									<c:forEach var="list1" items="${list1}">
										<li>${list1.attType}</li>
									</c:forEach>
								</ul>
								<ul style="float:left; width:20%; border:1px solid #ddd; box-sizing:border-box;">
									<li>지각</li>
									<c:forEach var="list2" items="${list2}">
										<li>${list2.attType}</li>
									</c:forEach>
								</ul>
								<ul style="float:left; width:20%; border:1px solid #ddd; box-sizing:border-box;">
									<li>조퇴</li>
									<c:forEach var="list3" items="${list3}">
										<li>${list3.attType}</li>
									</c:forEach>
								</ul>
								<ul style="float:left; width:20%; border:1px solid #ddd; box-sizing:border-box; border:1px solid #ddd; box-sizing:border-box;">
									<li>결석</li>
									<c:forEach var="list4" items="${list4}">
										<li>${list4.attType}</li>
									</c:forEach>
								</ul>
									
									
								

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
