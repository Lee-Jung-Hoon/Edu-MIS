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
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
	function jsClose() {
		parent.$.fn.colorbox.close();
		parent.location.reload();
	}
	// ajaxSubmit
	function regist_submit() {
	$.ajax({
	  type: 'get',
		url: "${pageContext.request.contextPath}/examgrade/ExamTurnWrite.do",
		data:  $("#wForm").serialize(),
		success: function (data) {
			alert("시험 정보가 등록되었습니다.");
			jsClose();
		},
		error: function (err) {
			alert("등록시 오류가 발생했습니다.");
		}
	});
	}
</script>
</head>
<form name="wForm" method="get"  id="wForm">
	<table class="table-board scroll">
		<tr>
			<th>시험제목</th>
			<td><input type="text" size="30" name="title" required autofocus></td>
		</tr>

		<tr>
			<th>시험일자</th>
			<td><input type="text" size="30" id="datepicker"
				name="datepicker" required autofocus></td>
		</tr>
		<tr>
			<th>시험내용</th>
			<td><input type="text" size="30" name="content" required autofocus></td>
		</tr>
	</table>
<a href="javascript:regist_submit()" >글등록</a>
<a href="javascript:jsClose()" >취소</a>
</form>