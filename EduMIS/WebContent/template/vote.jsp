<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width">
	<title>조장 추천 게시판</title>
	<%@ include file="/jsp/admin/include/common.jsp" %>	
</head>
<body class="page-leader btn-page">
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
						<section class="leader common">

							<h2>조장 추천 게시판</h2>
							<form action="#" method="#">
								<div class="leader-frame">
									<ul>
										<li>
											<div class="img"><img src="/EduMIS/images/icon-user.png" alt="" /></div>
											<div class="radio">
												<input type="radio" name="vote" id="vote1" />
												<label for="vote1"><span class="id">ID</span><span class="name">이름</span></label>
											</div>
										</li>
										<li>
											<div class="img"><img src="/EduMIS/images/icon-user.png" alt="" /></div>
											<div class="radio">
												<input type="radio" name="vote" id="vote2" />
												<label for="vote2"><span class="id">ID</span><span class="name">이름</span></label>
											</div>
										</li>
										<li>
											<div class="img"><img src="/EduMIS/images/icon-user.png" alt="" /></div>
											<div class="radio">
												<input type="radio" name="vote" id="vote3" />
												<label for="vote3"><span class="id">ID</span><span class="name">이름</span></label>
											</div>
										</li>
										<li>
											<div class="img"><img src="/EduMIS/images/icon-user.png" alt="" /></div>
											<div class="radio">
												<input type="radio" name="vote" id="vote4" />
												<label for="vote4"><span class="id">ID</span><span class="name">이름</span></label>
											</div>
										</li>
										<li>
											<div class="img"><img src="/EduMIS/images/icon-user.png" alt="" /></div>
											<div class="radio">
												<input type="radio" name="vote" id="vote5" />
												<label for="vote5"><span class="id">ID</span><span class="name">이름</span></label>
											</div>
										</li>
										<li>
											<div class="img"><img src="/EduMIS/images/icon-user.png" alt="" /></div>
											<div class="radio">
												<input type="radio" name="vote" id="vote6" />
												<label for="vote6"><span class="id">ID</span><span class="name">이름</span></label>
											</div>
										</li>
										<li>
											<div class="img"><img src="/EduMIS/images/icon-user.png" alt="" /></div>
											<div class="radio">
												<input type="radio" name="vote" id="vote7" />
												<label for="vote7"><span class="id">ID</span><span class="name">이름</span></label>
											</div>
										</li>
										<li>
											<div class="img"><img src="/EduMIS/images/icon-user.png" alt="" /></div>
											<div class="radio">
												<input type="radio" name="vote" id="vote8" />
												<label for="vote8"><span class="id">ID</span><span class="name">이름</span></label>
											</div>
										</li>
										<li>
											<div class="img"><img src="/EduMIS/images/icon-user.png" alt="" /></div>
											<div class="radio">
												<input type="radio" name="vote" id="vote9" />
												<label for="vote9"><span class="id">ID</span><span class="name">이름</span></label>
											</div>
										</li>
										<li>
											<div class="img"><img src="/EduMIS/images/icon-user.png" alt="" /></div>
											<div class="radio">
												<input type="radio" name="vote" id="vote10" />
												<label for="vote10"><span class="id">ID</span><span class="name">이름</span></label>
											</div>
										</li>
										<li>
											<div class="img"><img src="/EduMIS/images/icon-user.png" alt="" /></div>
											<div class="radio">
												<input type="radio" name="vote" id="vote11" />
												<label for="vote11"><span class="id">ID</span><span class="name">이름</span></label>
											</div>
										</li>
										<li>
											<div class="img"><img src="/EduMIS/images/icon-user.png" alt="" /></div>
											<div class="radio">
												<input type="radio" name="vote" id="vote12" />
												<label for="vote12"><span class="id">ID</span><span class="name">이름</span></label>
											</div>
										</li>
									</ul>
									<div class="btn-area">
										<span class="width50"><input type="submit" class="btn txt-vote btn-txt btn-blue" value="투표하기" /></span>
										<span class="width50"><a href="#" class="btn txt-result btn-txt btn-blue">결과보기</a></span>
									</div>
								</div>
							</form>
						</section>				
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="/EduMIS/js/common.js"></script>
</html>
