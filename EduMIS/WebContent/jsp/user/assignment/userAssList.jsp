<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width">
	<title>게시판</title>
	<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
	<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script>
	   function List() {
		   if (confirm("목록으로 가시겠습니까?")) {
				location.href = "${pageContext.request.contextPath}/user/assList.do";
			}
	}

	</script>
</head>
<body class="page-board">
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
						<section class="board common">
							<div class="board-frame">
								<h2>과제목록</h2>
								<table class="table-board board-style1">
									<colgroup>
										<col style="width:10%" />
										<col style="width:25%" />
										<col style="width:35%" />
										<col style="width:15%" />
										<col style="width:15%" />
									</colgroup>
									<thead>
										<tr>
											<th>글번호</th>
											<th>과제명</th>
											<th>제출기간</th>
											<th>제출여부</th>
											<th>진행여부</th>
										</tr>
									</thead>
									<tbody>
									<c:set var = "index" value = "0"/>
									
									<c:forEach var="list" items="${list}">
										<tr>
											<td>${list.no}</td>
											<td><a href ="${pageContext.request.contextPath}/user/assDetail.do?no=${list.no}">${list.title}</a></td>
											<td>${list.startDate} ~ ${list.endDate}</td>
											<td>${list.isSubmit}</td>
											<td>${ckArr[index]}</td>
										</tr>
										<c:set var = "index" value = "${index + 1}"/>
									</c:forEach>	
									</tbody>
								</table>
								<div class="board-paging">
									<button type="button" class="btn-paging btn-paging-prev">이전</button>
									<a href="#">1</a>
									<a href="#" class="on">2</a>
									<a href="#">3</a>
									<a href="#">4</a>
									<a href="#">5</a>
									<button type="button" class="btn-paging btn-paging-next">다음</button>
								</div>
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
