<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<style>
#write {
	width: 60px;
	height: 30px;
	position: absolute;
	float: inherit;
}

table.scroll {
    /* width: 100%; */ /* Optional */
    /* border-collapse: collapse; */
    border-spacing: 0;
    border: 2px solid black;
}

table.scroll tbody,
table.scroll thead { display: block; }

thead tr th { 
    height: 30px;
    line-height: 30px;
    /* text-align: left; */
}

table.scroll tbody {
    height: 200px;
    overflow-y: auto;
    overflow-x: hidden;
}

tbody { border-top: 2px solid black; }

tbody td, thead th {
    /* width: 20%; */ /* Optional */
    border-right: 1px solid black;
    /* white-space: nowrap; */
}

tbody td:last-child, thead th:last-child {
    border-right: none;
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


var $table = $('table.scroll'),
$bodyCells = $table.find('tbody tr:first').children(),
colWidth;

//Adjust the width of thead cells when window resizes
$(window).resize(function() {
// Get the tbody columns width array
colWidth = $bodyCells.map(function() {
    return $(this).width();
}).get();

// Set the width of thead columns
$table.find('thead tr').children().each(function(i, v) {
    $(v).width(colWidth[i]);
});    
}).resize(); // Trigger resize handler
</script>
</head>

<!-- <input type="button" value="시험 등록" onclick="doWrite();"> -->
<table border="1" class="table-board scroll">
    <thead>
	<tr>
		<th width="100px">번호</th>
		<th width="200px">이름</th>
		<th width="300px">아이디</th>
		<th width="330px">가입일</th>
	</tr>
	    </thead>
    <tbody>
	<c:forEach var="member" items="${member}">
	
		<tr align="center">
			<td width="100px">${member.no}</td>
			<td width="200px">${member.name}</td>

			<td width="300px"> <a href="${pageContext.request.contextPath}/examgrade/StudentGradeDetail.do?id=${member.id}">${member.id}</a>
				</td>

			<td width="300px">${member.joinDate}</td>
		</tr>
	</c:forEach>
		</tbody>
</table>
<div>
</div>