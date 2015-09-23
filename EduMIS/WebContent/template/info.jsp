<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width">
	<title>회원가입</title>
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
							<a href="#" class="btn-send">
							  <div class="circle">
								<div class="envelope-top"></div>
								<div class="envelope"></div>
							  </div>
							</a>
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
									<input type="submit" class="btn-submit" />
								</form>
								<button type="button" class="btn-close">닫기</button>
							</div>
						</li>
						<li><a href="#">회원가입</a></li>
					</ul>
				</header>
				<div class="container-inner">
					<div class="content">
						<section class="join common">
							<h2>제목과 타이틀 입력해주세요~</h2>
							<div class="student-info">
								<a href="#" class="btn btn-txt txt-add-member btn-blue btn-add-member">멤버추가</a>
								<ul>
									<li>
										<form action="">
											<div class="all-frame">
												<div class="img-frame">
													<span class="img"><img src="/EduMIS/images/icon-user.png" alt="" /></span>
													<a href="#">안지원</a>
												</div>
												<div class="txt-frame">
													<textarea></textarea>
													<input type="submit" class="btn btn-txt txt-regist-s btn-blue" value="등록" />
												</div>
												<a href="#" class="btn btn-txt txt-drop btn-blue btn-drop">중도포기</a>
											</div>
										</form>
									</li>
									<li>
										<form action="">
											<div class="all-frame">
												<div class="img-frame">
													<span class="img"><img src="/EduMIS/images/icon-user.png" alt="" /></span>
													<a href="#">안지원</a>
												</div>
												<div class="txt-frame">
													<textarea></textarea>
													<input type="submit" class="btn btn-txt txt-regist-s btn-blue" value="등록" />
												</div>
												<a href="#" class="btn btn-txt txt-drop btn-blue btn-drop">중도포기</a>
											</div>
										</form>
									</li>
									<li>
										<form action="">
											<div class="all-frame">
												<div class="img-frame">
													<span class="img"><img src="/EduMIS/images/icon-user.png" alt="" /></span>
													<a href="#">안지원</a>
												</div>
												<div class="txt-frame">
													<textarea></textarea>
													<input type="submit" class="btn btn-txt txt-regist-s btn-blue" value="등록" />
												</div>
												<a href="#" class="btn btn-txt txt-drop btn-blue btn-drop">중도포기</a>
											</div>
										</form>
									</li>
									<li>
										<form action="">
											<div class="all-frame">
												<div class="img-frame">
													<span class="img"><img src="/EduMIS/images/icon-user.png" alt="" /></span>
													<a href="#">안지원</a>
												</div>
												<div class="txt-frame">
													<textarea></textarea>
													<input type="submit" class="btn btn-txt txt-regist-s btn-blue" value="등록" />
												</div>
												<a href="#" class="btn btn-txt txt-drop btn-blue btn-drop">중도포기</a>
											</div>
										</form>
									</li>
								</ul>
							</div>
						</section>				
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="/EduMIS/js/common.js"></script>
</html>
