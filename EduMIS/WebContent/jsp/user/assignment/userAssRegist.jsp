<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width">
	<title>제목</title>
	<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
	<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script>
	   function List() {
		   if (confirm("목록으로 가시겠습니까?")) {
				location.href = "${pageContext.request.contextPath}/user/assList.do";
			}
	}

	</script>
</head>
<body class="page-join btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<aside>
				<h2>MENU</h2>
				<ul>
					<li><a href="#">과제 제출 게시판</a></li>
					<li><a href="#">교육생관리</a></li>
					<li><a href="#">조짜기</a></li>
					<li><a href="#">메시지 히스토리</a></li>
				</ul>
			</aside>
			<div class="container">
				<header class="header">
					<button type="button" class="btn-menu">
						  <span></span>
						  <span></span>
						  <span></span>
						  <span></span>
					</button>
					<!-- 메시지 들어가는 부분 -->
					<div class="top-message">
						<button type="button" class="btn-message">
							<img src="/EduMIS/images/message.png" alt="" />
							<span class="count">1<!-- 메시지 개수 --></span>
						</button>
						<div class="message-layer">
							<button type="button" class="btn-message-close">닫기</button>
							<div class="message-frame">
							<!-- 메시지 작업 시작영역 -->
							<!--  메시지 작업 시작영역 끝 -->	
							</div>
						</div>
					</div>
					<!-- 메시지 들어가는 부분 끝 -->
					<ul>
						<li><a href="#"><img src="/EduMIS/images/icon-user.png" alt="" />마이페이지</a></li>
						<li class="login">
							<a href="#">로그인</a>
							<div class="login-form">
								<form action="" method="">
									<input type="text"  placeholder="아이디" />
									<input type="password"  placeholder="비밀번호" />
									<span><input type="checkbox" id="save" /><label for="save">아이디 저장하기</label></span>
									<input type="submit" value="LOGIN" class="btn-submit" />
								</form>
								<button type="button" class="btn-close">닫기</button>
							</div>
						</li>
						<li><a href="#">회원가입</a></li>
					</ul>
				</header>
				<div class="container-inner">
					<div class="content">
					<!--  test-class 부분을  s-aaa 형식의 이름으로 클래스 잡아주세요  common 클래스 이름은 지우지 마세요 -->
						<section class="test-class common">
							<!--  작업부분 제목 써주세요 --><h2>과제등록</h2>
							<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->

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
					    <form action="/EduMIS/user/assRegist.do"method="POST" enctype="multipart/form-data">
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
									<span class="width50"><input type="button" class="btn txt-list btn-txt btn-blue" value="목록" onclick="List();"/></span>
								</div>
							</form>
					    </c:when>
						
						<c:otherwise >
						  <form action="/EduMIS/user/assBfModify.do?no=${ass.no}" method="POST" enctype="multipart/form-data">
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
									<span class="width50"><input type="button" class="btn txt-list btn-txt btn-blue" value="목록" onclick="List();"/></span>
								</div>
							</form>
						</c:otherwise>
					</c:choose>
					

							</div>
							<!--  작업완료 부분 -->
						</section>				
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="/EduMIS/js/common.js"></script>
</html>
