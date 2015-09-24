<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
						<ul id="messageUL" class="message-list">
							
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