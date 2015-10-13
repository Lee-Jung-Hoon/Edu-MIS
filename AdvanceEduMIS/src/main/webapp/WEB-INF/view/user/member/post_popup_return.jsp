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
	<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script>
      $(document).ready(function() {
         $(".returnPost").click(function(){
            self.close();
            opener.childCall1($(this).html(), $(this).parent().parent().find(".returnAddr").html());
         });   
         $(".returnAddr").click(function(){
            self.close();
            opener.childCall2($(this).html(), $(this).parent().parent().find(".returnPost").html());
         });   
      });
   </script>
</head>
<body class="page-popup btn-page">
	<div class="wrap">
		<div class="pop-inner">
			<form action="${pageContext.request.contextPath}/postno/PostNo.do">
				<div class="area-wrap">
					<label for="area">동 입력</label>
					<input type="text" id="dong" name="dong"/>
					<input type="submit" style="width:50px" class="btn-txt txt-search btn-blue" value="검색" />
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
							<td><a href="#" class="returnPost">${ dong.zipcode }</a></td>
							<td><a href="#" class="returnAddr">${ dong.sido } ${ dong.gugun } ${ dong.dong } ${ dong.ri } ${ dong.bunji }</a></td>
						</tr>
						</c:forEach>
			
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
