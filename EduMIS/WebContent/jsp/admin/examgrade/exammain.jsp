<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title>제목</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="/EduMIS/css/examgrade/colorbox.css" />
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="/EduMIS/js/examgrade/jquery.colorbox.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#content').load('/EduMIS/examgrade/ExamTurnList.do');
		$('#exam').click(function() {
			$('#content').load('/EduMIS/examgrade/ExamTurnList.do');
			return false;
		});
		$('#student').click(function() {
			$('#content').load('/EduMIS/examgrade/ExamStudentList.do');
			return false;
		});
		$(".iframe").colorbox({iframe:true, title: "시험등록", overlayClose: false, width:"80%", height:"80%"});
		$("#datepicker").datepicker();
	});
	
	function doInsert(val) {
		if (confirm("성적을 등록하시겠습니까?")) {
			location.href = "${pageContext.request.contextPath}/examgrade/ExamGradeWriteForm.do?no="+val;
		}
	}
	
	function doModify(val) {
		if (confirm("성적을 수정하시겠습니까?")) {
			location.href = "${pageContext.request.contextPath}/examgrade/ExamGradeModifyForm.do?no="+val;
		}		
	}
	
</script>
</head>
<body class="page-board btn-page">
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
						<span></span><span></span> <span></span> <span></span>
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
							<div id="wrap">
							<!--  test-class 부분을  s-aaa 형식의 이름으로 클래스 잡아주세요  common 클래스 이름은 지우지 마세요 -->
							<section class="test-class common">
								<!--  작업부분 제목 써주세요 -->
								<div></div>
								<div></div>
								<h2>성적관리</h2>
								<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->
								<p><a class='iframe' href="/EduMIS/jsp/admin/examgrade/examturnwriteForm.jsp">시험등록</a></p>
								<p><a href="#" onclick="regPop()">시험등록</a></p>
								<a href="javascript:void(0);" id="exam">시험별</a> 
								<a href="javascript:void(0);" id="student">학생별</a>

								<div id="content"></div>
								<!--  작업완료 부분 -->
							</section>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="/EduMIS/js/common.js"></script>
</html>