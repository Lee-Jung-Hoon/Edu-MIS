<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title>메인</title>
<%@ include file="/jsp/user/include/common.jsp"%>
<script>
  if ("${msg}") {
    alert("게시글이 등록 되었습니다.");
  }
  function bookRegist() {
    location.href = "/EduMIS/bookboard/writeForm.do";
  }
</script>
</head>
<body class="page-main btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<%@ include file="/jsp/user/include/leftMenu.jsp"%>
			<div class="container">
				<%@ include file="/jsp/user/include/topMenu.jsp"%>

				<div class="container-inner">
					<div class="content">
						<!--  test-class 부분을  s-aaa 형식의 이름으로 클래스 잡아주세요  common 클래스 이름은 지우지 마세요 -->
						<section class="test-class common board">
							<!--  작업부분 제목 써주세요 -->
							<h2>도서 목록</h2>
							<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->
							<c:set var="index" value="0" />
							<div class="adAssRegist">
							<form action="/EduMIS/bookboard/search.do">
								<table class="tb-test table-board" style="align: center">
									<colgroup>
										<col style="width:10%" />
										<col style="width:20%" />
										<col style="width:40%" />
										<col style="width:30%" />
									</colgroup>
									<tr>
										<th>글번호</th>
										<th>글쓴이</th>
										<th>제목</th>
										<th>등록일</th>
									</tr>
									<c:forEach var="board" items="${board}">
										<tr>
											<td>${board.no}</td>
											<td>${board.id}</td>
											<td><a href="/EduMIS/bookboard/detail.do?no=${board.no}">${board.title}</a></td>
											<td>${board.regDate}</td>
										</tr>
									</c:forEach>
									<c:if test="${empty board}">
										<tr>
											<td colspan="4">검색된 게시물이 존재하지 않습니다.</td>
										</tr>
									</c:if>
								</table>
								<div style="margin:20px 0; text-align:center;">
									<select id="choice" name="choice" style="height:30px;">
										<option value="">선택하세요</option>
										<option value="id">아이디</option>
										<option value="title">제목</option>
										<option value="no">글번호</option>
									</select>
									<input type="text" name="search" id="search" placeholder="검색" style="height:30px; padding-left:10px;" />
									<input style="display:inline-block; width:60px; height:30px; margin-left:10px;" type="submit" value="검색" class="btn btn-txt txt-search btn-blue" />
								</div>								
							</form>
							</div>
							<!--
								<div class="board-paging">
								<button type="button" class="btn-paging btn-paging-prev">이전</button>
								<button type="button" class="btn-paging btn-paging-next">다음</button>
							</div>  
							-->
							<div style="text-align:right;">
									<input type="button" value="글 등록" style="display:inline-block; width:120px; height:50px;" onclick="bookRegist()" class="btn btn-txt txt-write btn-blue" />
							</div>						
					</section>
					</div>
					<!--  작업완료 부분 -->
				</div>
			</div>
		</div>
	</div>
</body>
</html>
