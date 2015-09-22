<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width">
	<title>우편번호 검색</title>
	<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
	<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body class="page-popup btn-page">
	<div class="wrap">
		<div class="pop-inner">
			<form action="/postno/PostNo.do">	
				<div class="area-wrap">
					<label for="area">동 입력</label>
					<input type="text" id="dong" />
					<input type="button" class="btn-txt txt-search btn-blue" value="검색" />
				</div>
				<table class="table-common">
					<colgroup>
						<col style="width:25%" />
						<col style="width:75%" />
					</colgroup>
					<tbody>
						<tr>
							<th>우편번호</th>
							<th>주소</th>
						</tr>
						<c:forEach var="dong" items="${list}">
						<tr>
							<td><a href="#">${ dong.zipcode }</a></td>
							<td><a href="#">${ dong.sido } ${ dong.gugun } ${ dong.dong } ${ dong.ri } ${ dong.bunji }</a></td>
						</tr>
						</c:forEach>
			
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
