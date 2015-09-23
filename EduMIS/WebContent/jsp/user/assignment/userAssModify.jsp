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
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script>
	   function List() {
		   if (confirm("목록으로 가시겠습니까?")) {
				location.href = "${pageContext.request.contextPath}/user/assList.do";
			}
	}

	</script>
</head>
<body class="page-join">
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
							<!--  작업부분 제목 써주세요 --><h2>과제수정</h2>
							<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->

							<div class="AssignmentAsk">
			<form action="/EduMIS/user/assModify.do" method="POST" enctype="multipart/form-data">
				<table border="1" width ='100%'>
			           <h1>과제정보</h1>
					   <hr/>
					         <tr>
							        <td>과제번호</td>
							        <td>${ass.no}</td>
							    </tr>
							     <tr>
							        <td>과제명</td>
							        <td>${ass.title}</td>
							    </tr>
							    <tr>    
							        <td>내용</td>
							        <td>${ass.content}</td>
							     </tr>
							    <tr>    
							        <td>기간</td>
							        <td>${ass.startDate} ~ ${ass.endDate}</td>
							     </tr>
							    <tr>    
							        <td>첨부파일</td>
                                    <td><a href='${pageContext.request.contextPath}/fileDownload?orgFileName=${ass.orgFileName}&realFileName=${ass.realFileName}'>
                                        ${ass.orgFileName}</a></td>
							     </tr>
							   </table>
						 <span>과제제출</span>
							<hr/>
							<table border="1" width ='100%'>
						   <input type ="hidden" name ="no" value="${ass.no}" />
						   <input type ="hidden" name ="id" value="${userInfo.id}"/>
					     <input type ="hidden" name ="name" value="${userInfo.name}"/>
	                 <tr>    
							        <td>내용</td>
							        <td>
							        <textarea cols="70" rows="10" name ="usertext" >${userass.content}</textarea>
							        </td>
							     </tr>
							    <tr>    
							        <td>첨부파일</td>
							        <td><input type="file" name= "userattachFile" /></td>
							     </tr>
							 </table>
							  <input type="submit" value="수정완료" />	
							<input type="button" value="목록"  onclick="List();"/>
							<hr/>
				      </form>
							
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
