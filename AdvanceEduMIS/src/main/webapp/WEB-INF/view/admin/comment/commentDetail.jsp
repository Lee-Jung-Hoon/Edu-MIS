<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>수강생 정보</title>
</head>
<body class="page-popup">
	<br />
	<br />
	<h2 align="center" style="font-weight: bold;">수강생 정보</h2>
	<br />
	<table class="table-common">
		<colgroup>
			<col style="width: 25%" />
			<col style="width: 75%" />
		</colgroup>
		<tr>
			<th>아이디</th>
			<td>${vo.id}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${vo.name}</td>
		</tr>
		<tr>
			<th>전공</th>
			<td>${vo.major}</td>
		</tr>
		<tr>
			<th>등록일시</th>
			<td>${vo.year}-${vo.month}-${vo.day}</td>
		</tr>

		<tr>
		  <th>핸드폰</th>
			<td>${vo.phone1}-${vo.phone2}-${vo.phone3}</td>
		</tr>
		<tr>
		<th>이메일</th>
		<td>${vo.email}@${vo.emailDomain}</td>
		</tr>

		<tr>
			<th>학점</th>
			<td>${vo.grade}</td>
		</tr>
	</table>
</body>
</html>