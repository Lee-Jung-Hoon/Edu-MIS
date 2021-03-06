<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width">
	<title>메인</title>


	<%@ include file="/WEB-INF/view/user/include/common.jsp" %>	


</head>
<body class="page-main btn-page">
	<div class="wrap">
		<div class="wrap-inner">


			<%@ include file="/WEB-INF/view/user/include/leftMenu.jsp" %>

			<div class="container">


				<%@ include file="/WEB-INF/view/user/include/topMenu.jsp" %>

				<div class="container-inner">
					<div class="content">
						<section class="userAssRegist test-class common">
							<h2>과제등록</h2>

			<div class="AssignmentAsk table-common">
			<form method="POST" enctype="multipart/form-data">
				<table border="1">
			           <h1>과제정보</h1>
					         <tr>
							        <th>과제번호</th>
							        <td>${ass.no}</td>
							    </tr>
							     <tr>
							        <th>과제명</th>
							        <td>${ass.title}</td>
							    </tr>
							    <tr>    
							        <th>내용</th>
							        <td>${ass.content}</td>
							     </tr>
							    <tr>    
							        <th>기간</th>
							        <td>${ass.startDate} ~ ${ass.endDate}</td>
							     </tr>
							    <tr>    
							        <th>첨부파일</th>
                                    <td><a href='${pageContext.request.contextPath}/fileDownload?orgFileName=${ass.orgFileName}&realFileName=${ass.realFileName}'>
                                        ${ass.orgFileName}</a></td>
							     </tr>
							   </table>
				</form>
				<hr/>
		           <c:choose>
					    <c:when test='${empty userass}'>
					    <form action="${pageContext.request.contextPath}/user/assRegist.do"method="POST" enctype="multipart/form-data">
					    <input type ="hidden" name ="no" value="${ass.no}"/>
					    <input type ="hidden" name ="id" value="${user.id}"/>
					    <input type ="hidden" name ="name" value="${user.name}"/>
							<span>과제제출</span>
							<table >
							    <tr>    
							        <th>내용</th>
							        <td>
							        <textarea cols="70" rows="10" name ="usertext"></textarea>
							        </td>
							     </tr>
							    <tr>    
							        <th>첨부파일</th>
							        <td><input type="file" name= "userattachFile"/></td>
							     </tr>
							 </table>
							 <div class="btn-area">
									<span class="width50"><input type="submit" class="btn txt-send-assign btn-txt btn-blue" value="과제 제출" /></span>
									<span class="width50"><input type="button" class="btn txt-list btn-txt btn-blue" value="목록" onclick="location.href='${pageContext.request.contextPath}/user/assList.do'"/></span>
								</div>
							</form>
					    </c:when>
						
						<c:otherwise >
						  <form action="${pageContext.request.contextPath}/user/assBfModify.do?no=${ass.no}&id=${user.id}" method="POST" enctype="multipart/form-data">
						    <input type ="hidden" name ="no" value="${ass.no}"/>
						    <input type ="hidden" name ="id" value="${user.id}"/>
					      <input type ="hidden" name ="name" value="${user.name}"/>
							  <span>과제제출</span>
							  <table >
							    <tr>    
							        <th>내용</th>
							        <td><c:out value='${userass.content}'/></td>
							     </tr>
							    <tr>    
							        <th>첨부파일</th>
<td><a href='${pageContext.request.contextPath}/fileDownload?orgFileName=${userass.orgFileName}&realFileName=${ass.realFileName}'>
    <c:out value='${userass.orgFileName}'/></a></td>
							     </tr>
							 </table>
							 <div class="btn-area">
									<span class="width50"><input type="submit" class="btn txt-modi-assign btn-txt btn-blue" value="과제 수정" /></span>
									<span class="width50"><input type="button" class="btn txt-list btn-txt btn-blue" value="목록" onclick="location.href='${pageContext.request.contextPath}/user/assList.do'"/></span>
								</div>
							</form>
						</c:otherwise>
					</c:choose>
					

							</div>
						</section>						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
