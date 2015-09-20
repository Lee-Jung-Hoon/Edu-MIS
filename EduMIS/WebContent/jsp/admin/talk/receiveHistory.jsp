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
<!-- 				<script src="httprequest.js"></script> -->
				<script>
				var httpRequest = null;

				// 브라우저에 따라 XMLHttpRequest 객체를 생성해 주는 함수
				function getXMLHttpRequest() {
					if (window.ActiveXObject) {
						// IE에서 XMLHttpRequest 객체 구하기
						try {
							return new ActiveXObject("Microsoft.XMLHTTP");
						} catch (e) {
							return null;
						}
					} else if (window.XMLHttpRequest) {
						// IE를 제외한 파이어 폭스, 오페라와 같은 브라우저에서 XMLHttpRequest 객체를 구한다.
						return new XMLHttpRequest;
					}

					return null;
				}

				// XMLHttpRequest를 사용해서 지정된 URL로 지정된 요청 인자를 전송방식(GET/POST)으로 웹 서버에 요청을 전송한다.
				// 서버의 응답 결과는 callback 으로 지정된 콜백함수를 호출한다.
				function sendRequest(url, params, callback, method) {
					httpRequest = getXMLHttpRequest();

					// readyState 속성이 변경될때마다 호출될 콜백함수를 지정한다.
					httpRequest.onreadystatechange = callback;
					
					// 전송방식이 생략된 경우 기본으로 GET 방식으로 설정한다.
					var httpMethod = method ? method : 'GET';
					// 전송 방법이 GET/POST이외는 무조건 GET 방식으로 설정한다.
					if (httpMethod != 'GET' && httpMethod != 'POST') {
						httpMethod = 'GET';
					}
					// 요청 인자의 기본값을 설정한다.
					var httpParams = "";
					if (params != null && params != '') {
						for ( var key in params) {
							if (httpParams == "") {
								httpParams = key + '=' + encodeURIComponent(params[key]);
							} else {
								httpParams += '&' + key + '=' + encodeURIComponent(params[key]);
							}
						}
					}

					var httpUrl = url;
					// 전송 방법이 GET 방법이면서 요청인자가 존재할 경우 URL뒤에 요청인자를 추가한다.
					if (httpMethod == 'GET' && httpParams != "") {
						httpUrl = httpUrl + "?" + httpParams;
					}
					// 전송 방법과 URL을 설정한다.
					httpRequest.open(httpMethod, httpUrl, true);
					// 전송 방법이 POST이면 전송할 켄텐츠의 타입을 지정한다.
					if (httpMethod == 'POST') {
						httpRequest.setRequestHeader('Content-Type',
								'application/x-www-form-urlencoded');
					}
					// 전송방법이 POST이면 요청인자를 send()의 인자로 전달한다.
					httpRequest.send(httpMethod == 'POST' ? httpParams : null);
				}
		
// 					var httpRequest;
// 					function getHttpRequest() {
// 						if (window.XMLHttpRequest) {
// 							return new XMLHttpRequest();
// 						} else if (window.ActiveXObject) {
// 							return new ActiveXObject("Microsoft.XMLHTTP");
// 						} else {
// 							return null;
// 						}
// 					}
// 					function sendRequest(method, url, callback){
// 						alert(callback)
// 						httpRequest.onreadystatechange = callback;
// 						httpRequest.open(method, url, true);
// 						httpRequest.send(null);
						
// 					}
					function selectTalk() {
						
						var sel = document.querySelector("#sel");
						var opts = sel.options;
						var index = sel.selectedIndex;
						var param = opts[index].value;
						switch (param) {
						case "send":
							sendRequest("/EduMIS/talk/sendList.do", null, msg);
							break;
						case "receive":
							sendRequest("/EduMIS/talk/receiveList.do", null, msg);
							break;
						case "basket":
							sendRequest("/EduMIS/talk/receiveList.do", null, msg);
							break;

						}
						

					}
				</script>
				<div class="container-inner">
					<div class="content">
						<!--  test-class 부분을  s-aaa 형식의 이름으로 클래스 잡아주세요  common 클래스 이름은 지우지 마세요 -->
						<section class="test-class common">
							<!--  작업부분 제목 써주세요 -->
							<h2>Talk 히스토리</h2>
							<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->

							<div class="">
								<table style="width: 100%" border="1">
									<tr>
										<select id="sel" onchange="selectTalk()">
											<option value="send">받은쪽지함</option>
											<option value="receive">보낸쪽지함</option>
											<option value="basket">휴지통</option>
										</select>
									</tr>
									<tr>
										<td align="center" width=5%><input type="checkbox"
											name="allCheck" onclick="allCheck()" /></td>
										<th align="center" width=5%>읽음</th>
										<th align="center" width=20%>받은사람</th>
										<th align="center" width=50%>내용</th>
										<th align="center" width=20%>받은시간</th>
									</tr>

									<c:forEach var="list" items="${list}">
										<tr>
											<td align="center" width=5%><input type="checkbox"
												name="allCheck" onclick="allCheck()" /></td>
											<td align="center" width=5%>${list.checkYN}</td>
											<td align="center" width=20%>${list.mName}</td>
											<td align="center" width=50%>${list.content}</td>
											<td align="center" width=20%>${list.sendDate}</td>
										</tr>
									</c:forEach>
								</table>

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
