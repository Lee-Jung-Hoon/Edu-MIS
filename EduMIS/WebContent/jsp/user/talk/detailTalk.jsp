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
						  <span></span>
						  <span></span>
						  <span></span>
						  <span></span>
					</button>
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
						<section class="test-class common table-common">
							<!--  작업부분 제목 써주세요 -->
							<h2>Talk 히스토리</h2>
							<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->

							<div class="">
								<table border="1">

									<tr>
										<th>보낸사람 :</th>
										<td>${detail.name}</td>
										<th>받은시간 :</th>
										<td>${detail.sendDate}</td>
									</tr>
									<tr>
										<th>내용 :</th>
										<td>${detail.content}</td>
									</tr>
								</table>
							
								<Form action="/EduMIS/talk/user/insertSendTalk.do?receiveNo">
									<table class="table-common" style="margin-top:20px;">
										<tr>
											
											<th>답장 : </th>
											<td><input type="text" name="content" size="60" /></td>
											<td><input type="submit" value="보내기" />
												<input type="hidden" name="sendMemberNo" value="${detail.sendMemberNo}" />
												<input type="hidden" name="tNo" value="${detail.no}" />
												<input type="hidden" name="receiveMemberNo" value="${detail.receiveMemberNo}" />
												<input type="hidden" name="pNo" value="${detail.pNo}" />
											</td>
										</tr>
									</table>
									<div class="btn-area">
										<span class="width50"><a class="btn btn-txt txt-list btn-blue" href="/EduMIS/talk/user/recvList.do">목록</a></span>
										<span class="width50"><a class="btn btn-txt txt-del btn-blue" href="/EduMIS/talk/user/deleteTalk.do?no=${detail.no}">삭제</a></span>
									</div>
								</Form>


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
