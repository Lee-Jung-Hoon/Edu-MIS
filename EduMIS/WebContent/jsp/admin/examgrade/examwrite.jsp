<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>시험 등록</h1>
	<hr/>
	<form action="/EduMIS/examgrade/write.do">
	<table>
		<tr>
			<td>id : <input type="text" name="id" id="id"></td>
			<td>name : <input type="text" name="name" id="name"></td>
		</tr>
	</table>
	<input type="submit" />
	</form>
</body>
</html>