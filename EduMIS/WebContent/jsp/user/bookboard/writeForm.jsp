<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title>메인</title>
<%@ include file="/jsp/user/include/common.jsp"%>

<script>
	function checkForm() {
		var f = document.form;
		
		var title = f.title.value;
		var content = f.content.value;
		if(title == "") {
			alert("제목을 입력하세요");
			f.title.focus();
			return false;
		}
		else if(content == "") {
			alert("내용을 입력하세요");
			f.content.focus();
			return false;
		}
		return true;
	}
</script>

</head>
<body class="page-main btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<%@ include file="/jsp/user/include/leftMenu.jsp"%>
			<div class="container">
				<%@ include file="/jsp/user/include/topMenu.jsp"%>
				<div class="container-inner">
					<div class="content">
						<form action="/EduMIS/bookboard/write.do" method="POST" name="form" enctype="multipart/form-data" onsubmit="return checkForm();" >
							<table>
								<tr>
									<td><input type="hidden" name="id" id="id" value="${user.id}" /></td>
								</tr>
								<tr>
									<th>제목</th>
									<td class=""><input type="text" size="100%" name="title"
										id="title" placeholder="제목을 입력해주세요." /></td>
								</tr>
								<tr>
									<th>글 내용</th>
									<td colspan="3"><textarea cols="110" rows="20"
											name="content" id="content"></textarea></td>
								</tr>
								<tr>
									<th>첨부 파일</th>
									<td align="left"><input type="file" name="file" /></td>
									<td><input type="submit" value="글등록" style="display:inline-block; width:80px; height:30px;" class="btn btn-txt txt-write btn-blue" /></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>



