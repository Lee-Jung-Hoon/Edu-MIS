<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form method="post" action="/EduMIS/user/login/login.do">
			<table border="1">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id"
						value="${cookie.loginId.value}" /></td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td><input type="password" name="pass" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="checkbox" id="saveId"
						name="saveId" value="Y"
						<c:if test="${not empty cookie.loginId}">
						checked="checked"
					</c:if> />
						<label for="saveId">아이디 저장</label></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="로그인" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>