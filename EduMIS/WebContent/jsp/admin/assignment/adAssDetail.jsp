<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width">
	<title>메인</title>
	<%@ include file="/jsp/admin/include/common.jsp" %>
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
		/* case "X":
			window.open("http://localhost:8000/EduMIS/jsp/admin/assignment/noSubmit.jsp","제출 상세", // 팝업창에 이름 설정
					"width=600, height=500, resizable=no")
			break; */
		}
	}
	
</script>	
</head>
<body class="page-board btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<%@ include file="/jsp/admin/include/leftMenu.jsp" %>	
			<div class="container">
				<%@ include file="/jsp/admin/include/topMenu.jsp" %>

				<div class="container-inner">
					<div class="content">
						<section class="board common">
							<c:set var = "index" value = "0"/>
							<div class="adAssRegist">
							<h2>과제 상세</h2>
								<table class="tb-test table-board" align="center">
									<colgroup>
										<col style="width:20%" />
										<col style="width:80%" />
									</colgroup>
									<tr>
										<th>과제명</th>
										<td style="text-align: left; padding:0 10px; box-sizing:border-box;">${detail.title}</td>
									</tr>
									<tr>
										<th>파일 다운로드</th>
										 <td style="text-align: left; padding:0 10px; box-sizing:border-box;"><a href='${pageContext.request.contextPath}/fileDownload?orgFileName=${detail.orgFileName}&realFileName=${detail.realFileName}'>${detail.orgFileName}</a></td>
									</tr>
									<tr>
										<th>과제 내용</th>
										  <td style="text-align: left; padding:0 10px; box-sizing:border-box;">${detail.content}</td>
									</tr>
								</table>
							</div>
							<div class="btn-area" style="text-align:right; margin-bottom:20px;">
								<input style="width:70px; height:40px; display:inline-block;" type="submit" value="과제 수정" onclick="modifyAss()" class="btn txt-assign-modify-s btn-txt btn-blue" />
								<input style="width:70px; height:40px; display:inline-block;" type="reset" value="과제 삭제" onclick="deleteAss()" class="btn txt-assign-del-s btn-txt btn-blue" />
								<input style="width:70px; height:40px; display:inline-block;" type="reset" value="과제 목록" onclick="listAss()" class="btn txt-assign-list-s btn-txt btn-blue" />
							</div>
							<!--
							  <div>
									<table class="tb-test2 table-board">
									<tr>
										<td>
											<span><input type="button" value="과제 수정" onclick="modifyAss()"></span>	
											<span><input type="button" value="과제 삭제" onclick="deleteAss()"></span>	
											<span><input type="button" value="과제 목록" onclick="listAss()"></span>	
										</td>
									</tr>
									</table>
							</div>
							-->
							<div>
							<h2>제출 목록</h2>
								<table class="tb-test table-board">
									<tr>
										<th>이름</th>
										<th>제출 여부</th>
									</tr>
										<c:forEach var = "list" items ="${list}">
											<tr>
												<td><c:if test="${list.pass eq 'O'}"><a href="javascript:popUp('${list.pass}', '${detail.no}', '${list.id}');"
														style = "text-decoration: none;">${list.name}</a>
														</c:if>
														<c:if test="${list.pass eq 'X' }">
														${list.name}
														</c:if>
												</td>
												<td>${list.pass}</td>
											</tr>
										</c:forEach>
								</table>
							</div>
						</section>	
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
