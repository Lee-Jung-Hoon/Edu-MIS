<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
								<h2>게시판</h2>
								<table class="table-board board-style1">
									<colgroup>
										<col style="width:10%" />
										<col style="width:15%" />
										<col style="width:60%" />
										<col style="width:15%" />
									</colgroup>
									<thead>
										<tr>
											<th>글번호</th>
											<th>작성자</th>
											<th>제목</th>
											<th>날짜</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>1</td>
											<td>홍길동</td>
											<td><a href="#">제목입니다제목입니다제목입니다제목입니다제목입니다제목입니다제목입니다제목입니다제목입니다제목입니다제목입니다제목입니다</a></td>
											<td>2015.05.16 23:01:10</td>
										</tr>
										<tr>
											<td>2</td>
											<td>홍길동</td>
											<td><a href="#">제목입니다제목입니다제목입니다제목입니다</a></td>
											<td>2015.05.16 23:01:10</td>
										</tr>
										<tr>
											<td>3</td>
											<td>홍길동</td>
											<td><a href="#">제목입니다제목입니다제목입니다제목입니다</a></td>
											<td>2015.05.16 23:01:10</td>
										</tr>
										<tr>
											<td>4</td>
											<td>홍길동</td>
											<td><a href="#">제목입니다제목입니다제목입니다제목입니다</a></td>
											<td>2015.05.16 23:01:10</td>
										</tr>
										<tr>
											<td>5</td>
											<td>홍길동</td>
											<td><a href="#">제목입니다제목입니다제목입니다제목입니다</a></td>
											<td>2015.05.16 23:01:10</td>
										</tr>
										<tr>
											<td>6</td>
											<td>홍길동</td>
											<td><a href="#">제목입니다제목입니다제목입니다제목입니다</a></td>
											<td>2015.05.16 23:01:10</td>
										</tr>
										<tr>
											<td>7</td>
											<td>홍길동</td>
											<td><a href="#">제목입니다제목입니다제목입니다제목입니다</a></td>
											<td>2015.05.16 23:01:10</td>
										</tr>
										<tr>
											<td>8</td>
											<td>홍길동</td>
											<td><a href="#">제목입니다제목입니다제목입니다제목입니다</a></td>
											<td>2015.05.16 23:01:10</td>
										</tr>
										<tr>
											<td>9</td>
											<td>홍길동</td>
											<td><a href="#">제목입니다제목입니다제목입니다제목입니다</a></td>
											<td>2015.05.16 23:01:10</td>
										</tr>
										<tr>
											<td>10</td>
											<td>홍길동</td>
											<td><a href="#">제목입니다제목입니다제목입니다제목입니다</a></td>
											<td>2015.05.16 23:01:10</td>
										</tr>
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
