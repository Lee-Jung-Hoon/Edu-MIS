<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width">
	<title>도서 게시판</title>
	<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
	<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script>
	if("${msg}") {
		alert("게시글이 등록 되었습니다.");
	}
	if("${msg2}") {
		alert("게시글이 삭제 되었습니다.");
	}
</script>
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
							<!--  작업부분 제목 써주세요 --><h2>과제목록</h2>
							<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->
                            <c:set var = "index" value = "0"/>
							<div class="">
								<table border="1" width ='110%'>
						     <tr>
											<td>글번호</td>
											<td>글쓴이</td>
											<td>제목</td>
											<td>등록일</td>
								 </tr>
											<c:forEach var="board" items="${list}">
									<tr>
												<td>${board.no}</td>
												<td>${board.id}</td>
												<td><a href="/EduMIS/bookboard/detail.do?no=${board.no}">${board.title}</a></td>
												<td>${board.regDate}</td>
									</tr>
											</c:forEach>
											
											<c:if test="${empty list}">
									<tr>
												<td colspan="4">검색된 게시물이 존재하지 않습니다.</td>
									</tr>
											</c:if>
							   </table>
								<form action="/EduMIS/bookboard/search.do">
							   <table>
							   <tr>
							   <td width=50%><a href="/EduMIS/bookboard/writeForm.do">글쓰기</a></td>
							   <td>
							   		<select id="choice" name="choice">
												<option value="">선택하세요</option>
												<option value="id">아이디</option>
												<option value="title">제목</option>
												<option value="no">글번호</option>
										 </select>
									</td>
							   <td><input type="text" name="search" id="search" placeholder="검색아아아아아..." />
							   		 <input type="submit" value="검색"/>
							   </td>
							   </tr>
							   </table>
							   </form>
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














