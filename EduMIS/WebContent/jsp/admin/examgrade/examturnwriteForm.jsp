<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title>제목</title>
<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
</head>

<h2>회차 등록</h2>
<form
	action="${pageContext.request.contextPath}/examgrade/ExamTurnWrite.do">
	<input type="submit" value="등록">
	<table>
		<tr>
			<th>시험제목</th>
			<td><input type="text" size="50" name="title"></td>
		</tr>

		<tr>
			<th>시험일자</th>
			<td><input type="text" size="50" id="datepicker"
				name="datepicker"></td>
		</tr>
		<tr>
			<th>시험내용</th>
			<td><input type="text" size="50" name="content"></td>
		</tr>
	</table>
</form>