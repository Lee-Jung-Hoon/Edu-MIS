<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>제출 과제 상세</title>
</head>
<body>
	
	<table>
		<tr>
			<th>과제 번호</th>
			<td>${vo.no}</td>
		</tr>
		<tr>
			<th>학생 ID</th>
			<td>${vo.id}</td>
		</tr>
		<tr>
			<th>학생 이름</th>
			<td>${vo.name}</td>
		</tr>
		<tr>
			<th>제출 내용</th>
			<td>${vo.content}</td>
		</tr>
		<tr>
			<th>제출 파일</th>
			<td><a href = '${pageContext.request.contextPath}/fileDownload?orgFileName=${vo.orgFileName}&realFileName=${vo.realFileName}'>${vo.orgFileName}</a></td>
		</tr>
	</table>
	
</body>
</html>