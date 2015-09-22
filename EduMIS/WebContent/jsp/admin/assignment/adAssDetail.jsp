<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title>제목</title>
<script>
	function modifyAss() {
		location.href = "${pageContext.request.contextPath}/admin/assBfModify.do?no=${detail.no}";
	}
	
	function deleteAss() {
		if (confirm("삭제 하시겠습니까?")) {
			location.href = "${pageContext.request.contextPath}/admin/assDelete.do?no=${detail.no}";
		}
	}
	
	function listAss() {
		location.href = "${pageContext.request.contextPath}/admin/assList.do";
	}
	
	function popUp(type, no, id){
		switch (type) {
		case "O":
			window.open("http://localhost:8000/EduMIS/admin/assUserDetail.do?no=" + no + "&id=" + id, // 팝업창에 띄울 페이지 주소
			"제출 상세", // 팝업창에 이름 설정
			"width=600, height=500, resizable=no");
			break;
		}
	}
	
	

</script>
<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<style type="text/css">
	table {border:0;border-collapse:separate;border-spacing:0;}
	.tb-test{
	width: 900px;
	height: auto;
	border: 1px;
	}
	.tb-test td, .tb-test th{
	border-bottom: 1px solid #cccccc;
	}
	.tb-test th{
	text-align: center;
	width: 25%;
	}
	.tb-test tr{
	text-align: center;
	width: 25%;
	}
	.tb-test2{
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
						<section class="test-class common">
							<!--  작업부분 제목 써주세요 --><h2>과제 상세</h2>
							<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->
								<c:set var = "index" value = "0"/>
								<div class="adAssRegist">
									<table class="tb-test" align="center">
										<tr>
										
											<th>과제명</th>
											<td>${detail.title}</td>
										</tr>
										<tr>
											<th>파일 다운로드</th>
											  <td><a href='${pageContext.request.contextPath}/fileDownload?orgFileName=${detail.orgFileName}&realFileName=${detail.realFileName}'>${detail.orgFileName}</a></td>
										</tr>
										<tr>
											<th>과제 내용</th>
											  <td>${detail.content}</td>
										</tr>
									</table>
								</div>
								<div>
										<table class="tb-test2">
										<tr>
											<td>
												<span><input type="button" value="과제 수정" onclick="modifyAss()"></span>	
												<span><input type="button" value="과제 삭제" onclick="deleteAss()"></span>	
												<span><input type="button" value="과제 목록" onclick="listAss()"></span>	
											</td>
										</tr>
										</table>
								</div>
								<div>
								<h2>제출 목록</h2>
									<table class="tb-test">
										<tr>
											<th>이름</th>
											<th>제출 여부</th>
										</tr>
											<c:forEach var = "list" items ="${list}">
												<tr>
													<td><a href="javascript:popUp('${list.pass}', '${detail.no}', '${list.id}');"
														style = "text-decoration: none;">${list.name}</a></td>
													<td>${list.pass}</td>
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