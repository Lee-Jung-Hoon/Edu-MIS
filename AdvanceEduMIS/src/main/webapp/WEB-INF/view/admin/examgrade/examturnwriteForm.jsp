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
<style>
.txt-writeExam-s {
/*  		background-image:url('/AdvanceEduMIS/images/ExamGrade_writeBtn.png'); */
	color: white;
	border: solid 1px white;
	padding-top : 50px;
	margin : 8px;
	padding : 3px;
	text-decoration: none;
	font-weight: bold;
 }
</style>
</head>
<form name="wForm" method="get"  id="wForm">
	<table class="table-board scroll">
		<tr>
			<th width="20%">시험제목</th>
			<td><input type="text" size="50" name="title" required autofocus></td>
		</tr>

		<tr>
			<th>시험일자</th>
			<td align="left"><input type="date" style="width: 90%" id="datepicker" name="datepicker" placeholder="생년월일"
					title="생년월일은 필수 입력항목입니다." required="required">
				</td>
		</tr>
		<tr>
			<th>시험내용</th>
			
			<td>
				<textarea rows="10" cols="50" name="content"></textarea>
		</tr>
	</table>
	<div style="padding-top: 10px;"> <p align="center"><a class="btn btn-txt btn-blue txt-writeExam-s" href="javascript:regist_submit()" >글등록</a>
	<a class="btn btn-txt btn-blue txt-writeExam-s" href="javascript:jsClose()" >취소</a></p></div>
</form>