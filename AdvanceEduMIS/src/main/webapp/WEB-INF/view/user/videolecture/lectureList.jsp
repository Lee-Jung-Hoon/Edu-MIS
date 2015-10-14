<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<%@ include file="/WEB-INF/view/user/include/common.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	int paging = (int) request.getAttribute("paging");
%>
<head>
<meta charset="utf-8 ">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title>제목</title>
<script>
  function moveRegist() {
    location.href = "${pageContext.request.contextPath}/user/lecRegistForm.do";
  }
</script>
</head>
<body class="page-join btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<%@ include file="/WEB-INF/view/user/include/leftMenu.jsp"%>
			<div class="container">
				<%@ include file="/WEB-INF/view/user/include/topMenu.jsp"%>
				<div class="container-inner">

					<div class="content">
						<!--  test-class 부분을  s-aaa 형식의 이름으로 클래스 잡아주세요  common 클래스 이름은 지우지 마세요 -->
						<section class="test-class common board"> <!--  작업부분 제목 써주세요 -->
						<h2>강의 목록</h2>
						<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->
						<c:set var="index" value="0" />
						<div class="adAssRegist">
							<table class="tb-test table-board" align="center">
								<colgroup>
									<col style="width: 10%" />
									<col style="width: 60%" />
									<col style="width: 30%" />
								</colgroup>
								<tr>
									<th>NO</th>
									<th>강의 제목</th>
									<th>업데이트</th>
								</tr>
								<c:forEach var="lectureList" items="${lectureList}">
									<tr>
										<td>${lectureList.no}</td>
										<td><a href="lectureDetail.do?no=${lectureList.no}"
											style="text-decoration: none;">${lectureList.title}</a></td>
										<td>${lectureList.time}</td>
									</tr>
									<c:set var="index" value="${index + 1}" />
								</c:forEach>
							</table>
						</div>
						<div class="board-paging">
							<button type="button" class="btn-paging btn-paging-prev">이전</button>
							<c:forEach var="i" begin="1" end="${paging}">
								<a href="lectureList.do?pageNum=${i}">[${i}] </a>
							</c:forEach>
							<button type="button" class="btn-paging btn-paging-next">다음</button>
						</div>

						<div class="btn-area" style="text-align: right">
							<%-- 							<c:if test="${user.id eq 'admin'}"> --%>
							<input type="button"
								style="display: inline-block; width: 70px; height: 40px;"
								class="btn btn-txt btn-blue txt-regist-s" value="강의 등록"
								onclick="moveRegist()" />

							<%-- 							</c:if> --%>

						</div>
					</div>
					<!--  작업완료 부분 -->
					</section>
				</div>
			</div>
		</div>
	</div>
</body>
