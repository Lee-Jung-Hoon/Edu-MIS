<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>도서 게시판</title>
<script>
	if("${msg}") {
		alert("게시글이 등록 되었습니다.");
	}
</script>
</head>
<body>
	<table border="1" width="70%">
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
		<td><a href="/MyEduMIS/bookboard/detail.do?no=${board.no}">${board.title}</a></td>
		<td>${board.regDate}</td>
		</tr>
	</c:forEach>
	
	<c:if test="${empty list}">
	<tr>
		<td colspan="4">검색된 게시물이 존재하지 않습니다.</td>
	</tr>
	</c:if>
	</table>
	<a href="/MyEduMIS/bookboard/writeForm.do">글쓰기</a>
</body>
</html>