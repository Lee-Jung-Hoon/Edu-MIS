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
<%@ include file="/WEB-INF/view/admin/include/common.jsp"%>

<style>
.member{


}
.member {
	float: left;
}

img {
	width: "90px";
	height: "90px";
	
}

.mybody {
	padding-bottom: 100%;
}
</style>
<script>


function timeDelay() {
 setTimeout(fake, 1000);
  
}
 function fake() {
   
 };

</script>

</head>
<body class="page-main btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<%@ include file="/WEB-INF/view/admin/include/leftMenu.jsp"%>
			<div class="container">
				<%@ include file="/WEB-INF/view/admin/include/topMenu.jsp"%>

				<div class="container-inner">
					<div class="content">
						<section class="groupsShow common">
							<div id="mybody">
							<h2>새로운 조가 만들어졌습니다.</h2>
								<br/>
								<div id = "groups">
								<c:forEach begin="1" end="${gNum/2}" var="i">

									<div style="clear: both;">


										<h2>${i}조</h2>
									</div>

									<c:forEach var="list" items="${mlist}">

										<c:if test="${list.team eq i}">
											<div style="display: block;" class="member">
												<input type="hidden" value="1"> 
												<c:if test="${list.filePath eq 'null' }">
												<img src="/AdvanceEduMIS/WEB-INF/view/admin/groupmaker/images/pic1.jpg" width="70px"
													height="70px" style="margin-right: 3px">
												</c:if>
												<c:if test="${list.filePath ne 'null' }">
												<img src="/AdvanceEduMIS/${list.filePath}/${list.realFileName}" width="70px"
													height="70px" style="margin-right: 3px">
												</c:if>
												<p align="center">${list.name}</p>
											</div>
										</c:if>

									</c:forEach>

								</c:forEach>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
							</div>
							</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>
