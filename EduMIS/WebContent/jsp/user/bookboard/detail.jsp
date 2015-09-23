<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<tr>
		<td style="width:600px">${board.title}</td>
	</tr>
	<tr>
		<td style="height:500px">
		<img src="${board.filePath}"/"${board.orgFileName}" width="200px" alt="이미지" />
		${board.content}</td>
	</tr>
</table>

</body>
</html>