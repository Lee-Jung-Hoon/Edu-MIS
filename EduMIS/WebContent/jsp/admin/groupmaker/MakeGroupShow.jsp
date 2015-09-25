<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title>인연나비</title>
<%@ include file="/jsp/admin/include/common.jsp"%>

<style>
.member {
	float: left;
}

img {
	width: "90px";
	height: "90px";
}

.mybody {
	padding-bottom: 300px;
}
</style>

</head>
<body class="page-main btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<%@ include file="/jsp/admin/include/leftMenu.jsp"%>
			<div class="container">
				<%@ include file="/jsp/admin/include/topMenu.jsp"%>

				<div class="container-inner">
					<div class="content">
						<section class="groupsShow common">
							<h2>각 조 현황 보기</h2>
							<div id="mybody">
								<br>


								<c:forEach begin="1" end="${gNum/2}" var="i">

									<div style="clear: both;">



										<h2>${i}조</h2>
									</div>

									<c:forEach var="list" items="${mlist}">

										<c:if test="${list.team eq i}">
											<div style="display: block;" class="member">
												<input type="hidden" value="1"> <img
													src="/EduMIS/jsp/admin/groupmaker/images/pic1.jpg" width="90px"
													height="90px" style="margin-right: 3px">
												<p align="center">${list.name}</p>
											</div>
										</c:if>

									</c:forEach>

								</c:forEach>
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br /> <br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
							</div>
						</section>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
