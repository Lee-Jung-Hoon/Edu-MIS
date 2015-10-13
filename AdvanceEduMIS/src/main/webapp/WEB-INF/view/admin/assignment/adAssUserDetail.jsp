<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
	<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>제출 과제 상세</title>
<style>
	.tb-test th{
		text-align: center;
	}
</style>
</head>
<body class = "page-popup">
	<br/>
	<br/>
	<h2 align="center" style = "font-weight: bold;">과제 제출 상세</h2>
	<br/>
	<table class="tb-test table-board" align="center">
		<colgroup>
			<col style = "width:15%"/>
			<col style = "width:85%"/>
		</colgroup>
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