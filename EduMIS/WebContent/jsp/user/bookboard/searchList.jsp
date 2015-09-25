<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title>도서목록</title>
<%@ include file="/jsp/admin/include/common.jsp"%>
</head>
<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<style type="text/css">
table {
	border: 0;
	border-collapse: separate;
	border-spacing: 0;
}

.tb-test {
	width: 900px;
	height: auto;
	border: 1px;
}

.tb-test td, .tb-test th {
	border-bottom: 1px solid #cccccc;
}

.tb-test th {
	text-align: center;
	width: 25%;
}

.tb-test tr {
	text-align: center;
	width: 25%;
}

.tb-test2 {
	width: 900px;
	height: auto;
	text-align: right;
}
</style>
<script>
  if ("${msg}") {
    alert("게시글이 등록 되었습니다.");
  }
  if ("${msg2}") {
    alert("게시글이 삭제 되었습니다.");
  }
</script>
</head>
<body class="page-main btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<%@ include file="/jsp/admin/include/leftMenu.jsp"%>
			<div class="container">
				<%@ include file="/jsp/admin/include/topMenu.jsp"%>
				<div class="container-inner">
					<div class="content">
						<!--  test-class 부분을  s-aaa 형식의 이름으로 클래스 잡아주세요  common 클래스 이름은 지우지 마세요 -->
						<section class="test-class common">
							<!--  작업부분 제목 써주세요 -->
							<h2>과제목록</h2>
							<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->
							<c:set var="index" value="0" />
							<div class="adAssRegist">
								<table class="tb-test table-board" style="align: center">
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
											<td><select id="choice" name="choice">
													<option value="">선택하세요</option>
													<option value="id">아이디</option>
													<option value="title">제목</option>
													<option value="no">글번호</option>
											</select></td>
											<td><input type="text" name="search" id="search"
												placeholder="검색" /> <input type="submit" value="검색" /></td>
										</tr>
									</table>
									<div class="board-paging">
										<button type="button" class="btn-paging btn-paging-prev">이전</button>
										<button type="button" class="btn-paging btn-paging-next">다음</button>
									</div>
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
