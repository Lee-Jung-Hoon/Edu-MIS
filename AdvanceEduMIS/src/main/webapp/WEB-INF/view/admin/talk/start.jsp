<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/talk/login.do">
	no<input type="text" name="no" />
	 name<input type="text" name="name"/> 
	grade<input type="text" name="grade"/>
	<input type="submit" value="로그인"/>
	</form>
<!-- 	<form action="/EduMIS/talk/memberList.do"> -->
<!-- 	no<input type="text" name="no" value="1"/> -->
<!-- 	 name<input type="text" name="name" value="강사"/>  -->
<!-- 	grade<input type="text" name="grade" value="s"/> -->
<!-- 	<input type="submit" value="로그인"/> -->
<!-- 	</form> -->
	
	
	
</body>
</html>