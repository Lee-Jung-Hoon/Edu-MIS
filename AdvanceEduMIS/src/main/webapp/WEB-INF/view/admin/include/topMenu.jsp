<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty sessionScope.admin}">
	<script>
		// 소켓서버에 접속
	  	socket = io.connect("http://localhost:10004");
	  	socket.emit("login", {no: "${admin.no}", name: "${admin.name}"});
	  	socket.on("msg", function (sendName) {
	  		$.noticeAdd({stayTime: 30000, "text": sendName + "님에게메시지가 도착했습니다."});
	  	});
	</script>
</c:if>


				<header class="header">
					<button type="button" class="btn-menu">
						  <span></span>
						  <span></span>
						  <span></span>
						  <span></span>
					</button>
					<!-- 메시지 들어가는 부분 -->
					<div class="top-message">
						<c:if test="${not empty admin}">
						<button type="button" class="btn-message">
							<img src="${pageContext.request.contextPath}/images/message.png" alt="" />
							<span class="count">${msgCount}</span>	
						</button>
						</c:if>
						<div class="message-layer">
							<button type="button" class="btn-message-close" onclick="msgClose()">닫기</button>
							<div class="message-frame">
							<!-- 메시지 작업 시작영역 -->
							
								<!-- 쪽지 시작 -->
								<div class="message-frame-sort1">
									<button type="button" class="btn-toggle btn-write">새로운 쪽지</button>
									<h2><img src="${pageContext.request.contextPath}/images/txt-letter.png" alt="쪽지" /><em id="countView"></em></h2>
									
									<div class="message-inner">
										<form>
											<ul id="messageUL" class="message-list"></ul> 
										</form>
									</div>
								</div>
								<!-- 쪽지 끝 -->

								<!-- 새로운 쪽지 시작 -->
								<div class="message-frame-sort2">
									<button type="button" class="btn-toggle btn-return">되돌아가기</button>
									<form action="" method="">
										<h2><img src="${pageContext.request.contextPath}/images/txt-letter-new.png" alt="새로운 쪽지" /></h2>
										<!--  디폴트 관리자 -->
										<div class="message-receive">
											<p>받는사람 : </p>

											<!-- 학생일 경우 -->
										<!-- <div class="message-receive student">
											<p>받는사람 : 강사님</p> -->

											<!-- 디폴트 관리자 ※ 학생일 경우 아래 태그 제외 -->
											<div class="message-receive-inner">
											<button type="button" class="btn-plus">추가</button></div>

										</div>

										<!-- 디폴트 관리자 -->
										<textarea class="text-receive" ></textarea>
										<!-- 학생일 경우 -->
										<!-- <textarea class="text-receive student"></textarea> -->
										<!-- 신규일 경우 사용됨.. -->
										<button type="button" class="btn-send" onclick="sendTalk(0, 0, '${admin.name}')">
											<div class="circle">
												<div class="envelope-top"></div>
												<div class="envelope"></div>
											</div>
										</button>
									</form>
								</div>

								<div class="layer-side">
									<p><label for="list-all">전체선택</label><input type="checkbox" id="list-all" /></p>
									
									<!-- 메세지 보낼수 있는 것 처리 작업 -->
									<ul id="memberUL"></ul>
									
									<button type="button" class="btn-check">닫기</button>	
								</div>

								<!-- 새로운 쪽지 끝 -->

								<!--  메시지 작업 시작영역 끝 -->	
							</div>
						</div>
					</div>
					<!-- 메시지 들어가는 부분 끝 -->
					
			<ul>
		<c:choose>
			<c:when test="${empty sessionScope.admin}">
				<li class="login"><a href="#">로그인</a>
					<div class="login-form">
						<form action="${pageContext.request.contextPath}/user/login/login.do" method="POST">
							<input type="text" placeholder="아이디" name="id" value="${cookie.loginId.value}" />
							<input type="password" placeholder="비밀번호" name="pass"/>
							<span><input type="checkbox" id="save" name="save" value="Y" 
							<c:if test="${not empty cookie.loginId}">
							    checked="checked"
							</c:if>
							 />
							<label for="save">아이디 저장하기</label></span>
							<input type="submit" class="btn-submit" />
						</form>
						<button type="button" class="btn-close">닫기</button>
					</div>
				</li>
			</c:when>
			<c:otherwise>
				<li><a href="${pageContext.request.contextPath}/admin/login/logout.do">로그아웃</a> </li>
			</c:otherwise>
		</c:choose>
	</ul>
				</header>					