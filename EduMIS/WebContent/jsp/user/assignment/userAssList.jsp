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
	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script>

	function prePage() {
	  location.href = "/EduMIS/user/assList.do?reqIndex=${thisPage-1}";
	}
	
	function nextPage() {
	  location.href = "/EduMIS/user/assList.do?reqIndex=${thisPage+1}";
	}

	</script>
</head>
<body class="page-main btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<%@ include file="/jsp/admin/include/leftMenu.jsp" %>	
			<div class="container">
				<%@ include file="/jsp/admin/include/topMenu.jsp" %>

				<div class="container-inner">
					<div class="content">
						<section class="userAssList board common">
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
									
									<c:forEach var="assList" items="${assList}">
										<tr>
											<td>${assList.no}</td>
											<td><a href ="${pageContext.request.contextPath}/user/assDetail.do?no=${assList.no}">${assList.title}</a></td>
											<td>${assList.startDate} ~ ${assList.endDate}</td>
											<td>${assList.isSubmit}</td>
											<td>${ckArr[index]}</td>
										</tr>
										<c:set var = "index" value = "${index + 1}"/>
									</c:forEach>	
									</tbody>
								</table>
								<div class="board-paging">
									<button type="button" class="btn-paging btn-paging-prev">이전</button>
									<c:forEach var="i" begin = "1" end = "${pageIndex}">
												<a href="/EduMIS/user/assList.do?reqIndex=${i}" id = "a${i}" style="text-decoration: none;">${i}</a>
											</c:forEach>
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
</html>
