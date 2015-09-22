<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<style>
#write {
	width: 60px;
	height: 30px;
	position: absolute;
	float: inherit;e
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('#content').get('/EduMIS/examgrade/ExamTurnList.do');
		
		$('#exam').click(function() {
			$('#content').load('/EduMIS/examgrade/ExamTurnList.do');
				return false;
		});
	});

	function doInsert(val) {
		if (confirm("성적을 등록하시겠습니까?")) {
			location.href = "${pageContext.request.contextPath}/examgrade/ExamGradeWriteForm.do?no="+val;
		}
	}
	
	function doModify(val) {
		if (confirm("성적을 수정하시겠습니까?")) {
			location.href = "${pageContext.request.contextPath}/examgrade/ExamGradeModifyForm.do?no="+val;
		}		
	}
</script>
</head>
<table border="1" class="table-board">
	<tr>
		<th width="100px">회차번호</th>
		<th width="200px">시험제목</th>
		<th width="300px">시험내용</th>
		<th width="100px">시험일자</th>
		<th width="200px">성적등록/수정</th>
	</tr>
	<c:forEach var="list" items="${list}">
		<tr align="center">
			<td width="100px">${list.no}</td>
			<td width="200px">${list.title}</td>

			<td width="300px">
				<c:if test="${list.ck=='false'}">
					${list.content}
				</c:if> 

				<c:if test="${list.ck=='true'}">
					<a href="${pageContext.request.contextPath}/examgrade/ExamGradeDetail.do?no=${list.no}">${list.content}</a>
				</c:if>
			</td>

			<td width="300px">${list.regDate}</td>

			<td width="100px">
				<c:if test="${list.ck=='false'}">
					<a href='#' onclick="doInsert(${list.no})" >성적등록</a>
<%-- 					<input type="button" value="성적등록" onclick="doInsert(${list.no})"> --%>
				</c:if> 
				<c:if test="${list.ck=='true'}">
					<a href='#' onclick="doModify(${list.no})" >성적수정</a>
				</c:if>
			</td>
		</tr>
	</c:forEach>
</table>