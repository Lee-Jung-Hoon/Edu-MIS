<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title>수강생 관리</title>
<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<style type="text/css">
table {
	border: 0;
	border-collapse: separate;
	border-spacing: 0;
}

.tb-test {
	width: 900px;
	height: auto;
	border: 1px;
}

.tb-test td, .tb-test th {
	border-bottom: 1px solid #cccccc;
}

.tb-test th {
	text-align: center;
	width: 25%;
}

.tb-test tr {
	text-align: center;
	width: 25%;
}

.tb-test2 {
	width: 900px;
	height: auto;
	text-align: right;
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
					<span></span> <span></span> <span></span> <span></span>
				</button>
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
						<section class="test-class common"> <!--  작업부분 제목 써주세요 -->
						<h2>수강생 정보</h2>
						<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->
						<form action=""method="">
						<c:set var="index" value="0" />
						<div>
							<table class="tb-test" align="center">
								
									
									<tr>
										<td rowspan="4" width="150px" height="200px">사진</td>
										<td>${vo.no}&nbsp;${vo.id}</td>
									</tr>
									<tr>
										<td>${vo.name}</td>
									</tr>
									<tr>
										<td>${vo.major}</td>
									</tr>
									<tr>
										<td>${vo.joinDate}-${vo.month}-${vo.day}</td>
									</tr>

									<tr>
										<td>${vo.joinDate}&nbsp;${vo.dropDate}</td>
										<td>${vo.dropReason}</td>
									</tr>
									<tr>
										<td>${vo.phone1}-${vo.phone2}-${vo.phone3}</td>
										<td>${vo.email}@${vo.emailDomain}</td>
									</tr>
									<tr>
										<td>${vo.techLeader}</td>
										<td>${vo.grade}</td>
									</tr>
								
							</table>
									<br/>
							<div align="center">
							<textarea name="comment" rows="10" cols="120"style="resize:none;"placeholder="입력해주세요"></textarea>
							</div>
						</div>
						<br/>
							<div align="center">
							<input type="submit" value="등록하기"/>
							<input type="button" value="수정하기"/>
							</div>
						
						</form>
						<!--  작업완료 부분 --> </section>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="/EduMIS/js/common.js"></script>