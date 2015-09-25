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
	<%@ include file="/jsp/admin/include/common.jsp" %>
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
	<script>
	
	function ckSDate() {
		alert("날짜확인함수")
		return true;
	}
		
	function moveRegist() {
		location.href = "${pageContext.request.contextPath}/jsp/admin/assignment/adAssRegist.jsp";
	}
	$(document).ready(function () {
	  $("#a${thisPage}").addClass("on");
	});
	
	function prePage() {
	  location.href = "/EduMIS/admin/assList.do?reqIndex=${thisPage-1}";
	}
	
	function nextPage() {
	  location.href = "/EduMIS/admin/assList.do?reqIndex=${thisPage+1}";
	}
	</script>
</head>
<body class="page-join  btn-page">
	<div class="wrap">
		<div class="wrap-inner">
				<%@ include file="/jsp/admin/include/leftMenu.jsp" %>	
			<div class="container">
				<%@ include file="/jsp/admin/include/topMenu.jsp" %>
				<div class="container-inner">
					<div class="content">
					<!--  test-class 부분을  s-aaa 형식의 이름으로 클래스 잡아주세요  common 클래스 이름은 지우지 마세요 -->
						<section class="test-class common">
							<!--  작업부분 제목 써주세요 --><h2>과제 목록</h2>
							<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->
								<c:set var = "index" value = "0"/>
								<div class="adAssRegist">
								<table class="table-board board-style1">
									<colgroup>
										<col style="width:10%" />
										<col style="width:15%" />
										<col style="width:60%" />
										<col style="width:15%" />
									</colgroup>
										<tr>
											<th>NO</th>
											<th>과제명</th>
											<th>진행기간</th>
											<th>진행여부</th>
										</tr>
										<c:forEach var = "list" items = "${asslist}">
											<tr height="30px;" style="text-align: center;">
												<td>${list.no}</td>
												<td><a href = "${pageContext.request.contextPath}/admin/assDetail.do?no=${list.no}"  style="text-decoration: none;">${list.title}</a></td>
												<td>${list.startDate}~${list.endDate}</td>
												<td>${ckArr[index]}</td>
											</tr>
												<c:set var = "index" value = "${index + 1}"/>
										</c:forEach>
									</table>
								</div>
								<div>
								<div style="text-align:right; margin:10px 0">
									<input style="width:70px; height:40px; display:inline-block;" type="submit" onclick="moveRegist();" value="과제 등록" class="btn txt-assign-regist-s btn-txt btn-blue" />
								</div>
								<div align="center" class="board-paging">
									<button type="button" class="btn-paging btn-paging-prev" onclick="prePage()">이전</button>
									<c:forEach var="i" begin = "1" end = "${pageIndex}">
										<a href="/EduMIS/admin/assList.do?reqIndex=${i}" id = "a${i}" style="text-decoration: none;">${i}</a>
									</c:forEach>
									<button type="button" class="btn-paging btn-paging-next" onclick="nextPage()">다음</button>
								</div>
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