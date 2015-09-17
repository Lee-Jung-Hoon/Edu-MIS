<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function doWrite() {
		if (confirm("시험을 등록하시겠습니까?")) {
			location.href = "${pageContext.request.contextPath}/examgrade/writeForm.do";
		}
	}
</script>
</head>
<body>
	<h1>성적 관리</h1>
	<hr />
	<input type="button" value="시험 등록" onclick="doWrite();">
	<table border="1">
		<tr>
			<th>관리번호</th>
			<th>시험제목</th>
			<th>시험일</th>
			<th>수강인원</th>
		</tr>
		<tr>
			<td></td>
		</tr>
	</table>
</body>
</html>

