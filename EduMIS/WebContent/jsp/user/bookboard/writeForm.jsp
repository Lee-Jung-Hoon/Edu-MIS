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

<form action="/EduMIS/bookboard/write.do" method="POST" enctype="multipart/form-data">
	<input type="hidden" name="id" id="id" value="user.id" /><br />
		<table>		
			<tr>
				<td><input type="hidden" name="id" id = "id"  value="user.id" /></td>
			</tr>
			<tr>
				<th>제목</th>
				<td class=""><input type="text" size="100%" name="title" id = "title" placeholder="제목을 입력해주세요." /></td>
			</tr>
			<tr>
				<th>글 내용</th>
				<td colspan="3"><textarea cols="110" rows="20"
						name="content" id = "content"></textarea></td>
			</tr>
			<tr>
				<th>첨부 파일</th>
				<td align="left"><input type="file" name="file" /></td>
			</tr>
		 </table>
<input type="submit" value="글등록" />
</form>
</body>
</html>


