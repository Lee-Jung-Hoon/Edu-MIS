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
	<%@ include file="/jsp/user/include/common.jsp" %>	
<script>
<c:if test="${not empty member}">
	var socket = io.connect("http://localhost:10004");
	socket.emit("setInfo", {no: "${member.no}", name: "${member.name}"})
</c:if>	
</script>	
</head>
<body class="page-main btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<%@ include file="/jsp/user/include/leftMenu.jsp" %>	
			<div class="container">
				<%@ include file="/jsp/user/include/topMenu.jsp" %>

				<div class="container-inner">
					<div class="content">
									
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
