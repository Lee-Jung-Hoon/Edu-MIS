<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width">
	<title>수강생 관리</title>
	
		<%@ include file="/jsp/admin/include/common.jsp" %>	
	<style>
	table.scroll {
    /* width: 100%; */ /* Optional */
    /* border-collapse: collapse; */
    border-spacing: 0;
/*     border: 2px solid black; */
		}

	table.scroll tbody,
	table.scroll thead { display: block; }
	
	thead tr th { 
	    height: 30px;
	    line-height: 30px;
	    /* text-align: left; */
	    border-bottom: 2px solid black;
	}
	
	table.scroll tbody {
	    height: 100px;
	    overflow-y: auto;
	    overflow-x: hidden;
	}
	
	tbody {
/* 	 border-top: 2px solid black;  */
					width: 500px;	
					}
	
	tbody td, thead th {
			width: 80px;
			height: 15px;
	    /* width: 20%; */ /* Optional */
/* 	    border-right: 1px solid black; */
	    /* white-space: nowrap; */
	}
	
	tbody td:last-child, thead th:last-child {
	    border-right: none;
	}
		
	</style>
	<script>
	function popUp(id){
			window.open("http://localhost:8000/EduMIS/admin/commentSelect.do?id=" + id, // 팝업창에 띄울 페이지 주소
			"수강생 정보", // 팝업창에 이름 설정
			"width=600, height=500, resizable=no");
		
		}
	
	//Change the selector if needed
	var $table = $('table.scroll'),
	    $bodyCells = $table.find('tbody tr:first').children(),
	    colWidth;

	// Adjust the width of thead cells when window resizes
	$(window).resize(function() {
	    // Get the tbody columns width array
	    colWidth = $bodyCells.map(function() {
	        return $(this).width();
	    }).get();
	    
	    // Set the width of thead columns
	    $table.find('thead tr').children().each(function(i, v) {
	        $(v).width(colWidth[i]);
	    });    
	}).resize(); // Trigger resize handler
	
	
	$(document).ready(function () {
	  
	  $("input[type='button']").click(function () {
	    var no = this.id;
	    $.get(
	        "/EduMIS/comment/delete.do",
	        {no:no},
	        function(data){
	          if(confirm("삭제하시겠습니까?")){
		          $("#" + no).remove();
		          $("#" + no).remove();
	          }
	        })
	 		 })
	})
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
							<a href="#" class="btn-send">
							  <div class="circle">
								<div class="envelope-top"></div>
								<div class="envelope"></div>
							  </div>
							</a>
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
									<input type="submit" class="btn-submit" />
								</form>
								<button type="button" class="btn-close">닫기</button>
							</div>
						</li>
						<li><a href="#">회원가입</a></li>
					</ul>
				</header>
				<div class="container-inner">
					<div class="content">
						<section class="join common">
							<h2>수강생 관리</h2>
							<div class="student-info">
						
								<ul>
									<li>
										
											<c:forEach var="student" items="${list}">	
										<form action="/EduMIS/admin/commentInsert.do" method="post">
										
											<div class="all-frame">
												<div class="img-frame" style="margin-right:20px;">
													<span class="img"><img src="/EduMIS/images/icon-user.png" alt="" /></span>
													<a href="javascript:popUp('${student.id}');"
														style = "text-decoration: none;">${student.name}</a>
												</div>
												
												<div>
												<input type="text" style="height:30px; width:500px;" name="content"size="100" />
												<input type="hidden" value = "${student.id}" name = "id"/>
												<input type="submit" style="width:80px; height:30px;float:right;" class="btn btn-txt txt-regist-s btn-blue" value="등록" />
												<br/>
												</div>
												<div>
												
											
												<br/>
												
													<div>
														<table class="scroll">
														    <thead>
														        <tr>
														            <th style="	width: 80px;">날짜</th>
														            <th style="	width: 400px;">내용</th>
														        </tr>
														    </thead>
														    <tbody>
														<c:forEach var="clist" items="${clist}">
															<c:if test="${student.id eq clist.id}">
														        <tr id = "${clist.no}">
														            <td style="	width: 82px;">${clist.reg_date}</td>
														            <td style="	width: 400px;"> ${clist.content}</td>
														        		<td><input type = "button" value = "삭제" id = "${clist.no}" style="	display:block;
																																																						width:20px;
																																																						height:20px;
																																																						background:url('../images/btn-close.png') no-repeat center;
																																																						background-size:100%;
																																																						overflow:hidden;
																																																						z-index:99;
																																																						text-indent:-5000px;"/></td>
														        </tr>
															</c:if>
														</c:forEach>
														    </tbody>
														</table>
													</div>
												</div>
											</div>
										</form>
												</c:forEach>
									</li>
								
								</ul>
							</div>
						</section>				
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="/EduMIS/js/common.js"></script>
</html>
