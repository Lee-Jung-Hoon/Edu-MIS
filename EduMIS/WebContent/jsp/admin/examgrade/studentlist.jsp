<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<style>
#write {
	width: 60px;
	height: 30px;
	position: absolute;
	float: inherit;
}
</style>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="jquery.colorbox.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$('#content').get('/EduMIS/examgrade/ExamTurnList.do');
	$('#exam').click(function() {
		$('#content').load('/EduMIS/examgrade/ExamTurnList.do');
		return false;
	});
});
</script>
</head>

<!-- <input type="button" value="시험 등록" onclick="doWrite();"> -->
<table border="1" class="table-board">
	<tr>
		<th width="100px">번호</th>
		<th width="200px">이름</th>
		<th width="300px">아이디</th>
		<th width="100px">가입일</th>
	</tr>
	<c:forEach var="member" items="${member}">
		<tr align="center">
			<td width="100px">${member.no}</td>
			<td width="200px">${member.name}</td>

			<td width="300px"> <a href="${pageContext.request.contextPath}/examgrade/StudentGradeDetail.do?id=${member.id}">${member.id}</a>
				</td>

			<td width="300px">${member.joinDate}</td>
		</tr>
	</c:forEach>
</table>
<div>
</div>