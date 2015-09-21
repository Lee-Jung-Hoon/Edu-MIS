<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width">
	<title>조장 추천 게시판</title>
	<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
	<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
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
							
							<!-- 쪽지 시작 -->
								<div class="message-frame-sort1">
									<button type="button" class="btn-toggle btn-write">새로운 쪽지</button>
									<h2><img src="/EduMIS/images/txt-letter.png" alt="쪽지" /><em>( 2개 )</em></h2>
									<div class="message-inner">
										<ul class="message-list">
											<li>
												<a href="#"><span class="info1"><strong title="안지원">안지원</strong>으로부터 도착</span><span class="info2">15-09-19 (토) 20:01</span></a>
												<div class="text-content">
													<p>안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 .</p>
													<textarea></textarea>
													<button type="button" class="btn-send">
														<div class="circle">
															<div class="envelope-top"></div>
															<div class="envelope"></div>
														</div>
													</button>
												</div>
											</li>
											<li>
												<a href="#"><span class="info1"><strong title="안지원안지원안지원안지원안지원">안지원안지원안지원안지원안지원</strong>으로부터 도착</span><span class="info2">15-09-19 (토) 20:01</span></a>
												<div class="text-content">
													<p>안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 </p>
													<textarea></textarea>
													<button type="button" class="btn-send">
														<div class="circle">
															<div class="envelope-top"></div>
															<div class="envelope"></div>
														</div>
													</button>
												</div>
											</li>
											<li>
												<a href="#"><span class="info1"><strong title="안지원">안지원</strong>으로부터 도착</span><span class="info2">15-09-19 (토) 20:01</span></a>
												<div class="text-content">
													<p>안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 </p>
													<textarea></textarea>
													<button type="button" class="btn-send">
														<div class="circle">
															<div class="envelope-top"></div>
															<div class="envelope"></div>
														</div>
													</button>
												</div>
											</li>
											<li>
												<a href="#"><span class="info1"><strong title="안지원">안지원</strong>으로부터 도착</span><span class="info2">15-09-19 (토) 20:01</span></a>
												<div class="text-content">
													<p>안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 </p>
													<textarea></textarea>
													<button type="button" class="btn-send">
														<div class="circle">
															<div class="envelope-top"></div>
															<div class="envelope"></div>
														</div>
													</button>
												</div>
											</li>
											<li>
												<a href="#"><span class="info1"><strong title="안지원">안지원</strong>으로부터 도착</span><span class="info2">15-09-19 (토) 20:01</span></a>
												<div class="text-content">
													<p>안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 </p>
													<textarea></textarea>
													<button type="button" class="btn-send">
														<div class="circle">
															<div class="envelope-top"></div>
															<div class="envelope"></div>
														</div>
													</button>
												</div>
											</li>
											<li>
												<a href="#"><span class="info1"><strong title="안지원">안지원</strong>으로부터 도착</span><span class="info2">15-09-19 (토) 20:01</span></a>
												<div class="text-content">
													<p>안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 </p>
													<textarea></textarea>
													<button type="button" class="btn-send">
														<div class="circle">
															<div class="envelope-top"></div>
															<div class="envelope"></div>
														</div>
													</button>
												</div>
											</li>
											<li>
												<a href="#"><span class="info1"><strong title="안지원">안지원</strong>으로부터 도착</span><span class="info2">15-09-19 (토) 20:01</span></a>
												<div class="text-content">
													<p>안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 </p>
													<textarea></textarea>
													<button type="button" class="btn-send">
														<div class="circle">
															<div class="envelope-top"></div>
															<div class="envelope"></div>
														</div>
													</button>
												</div>
											</li>
											<li>
												<a href="#"><span class="info1"><strong title="안지원">안지원</strong>으로부터 도착</span><span class="info2">15-09-19 (토) 20:01</span></a>
												<div class="text-content">
													<p>안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플 텍스트입니다.안녕하세요 샘플</p>
													<textarea></textarea>
													<button type="button" class="btn-send">
														<div class="circle">
															<div class="envelope-top"></div>
															<div class="envelope"></div>
														</div>
													</button>
												</div>
											</li>
											
										
										</ul> 
									</div>
								</div>
								<!-- 쪽지 끝 -->


								<!-- 새로운 쪽지 시작 -->
								<div class="message-frame-sort2">
									<button type="button" class="btn-toggle btn-return">되돌아가기</button>
									<form action="" method="">
										<h2><img src="/EduMIS/images/txt-letter-new.png" alt="새로운 쪽지" /></h2>
										<!--  디폴트 관리자 -->
										<div class="message-receive">
											<p>받는사람 : </p>

											<!-- 학생일 경우 -->
										<!-- <div class="message-receive student">
											<p>받는사람 : 강사님</p> -->

											<!-- 디폴트 관리자 ※ 학생일 경우 아래 태그 제외 -->
											<div class="message-receive-inner"><button type="button" class="btn-plus">추가</button></div>

										</div>

										<!-- 디폴트 관리자 -->
										<textarea class="text-receive"></textarea>
										<!-- 학생일 경우 -->
										<!-- <textarea class="text-receive student"></textarea> -->

										<button type="button" class="btn-send">
											<div class="circle">
												<div class="envelope-top"></div>
												<div class="envelope"></div>
											</div>
										</button>
									</form>
								</div>

								<div class="layer-side">
									<p><label for="list-all">전체선택</label><input type="checkbox" id="list-all" /></p>
									<ul>
										<li><label for="list01">안지원</label><input type="checkbox" id="list01" /></li>
										<li><label for="list02">김지원</label><input type="checkbox" id="list02" /></li>
										<li><label for="list03">정지원</label><input type="checkbox" id="list03" /></li>
										<li><label for="list04">윤지원</label><input type="checkbox" id="list04" /></li>
									</ul>
									<button type="button" class="btn-check">확인</button>
								</div>

								<!-- 새로운 쪽지 끝 -->

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
