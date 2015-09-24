<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width">
	<title>메모</title>
	<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
	<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script src="/EduMIS/template/httprequest.js"></script>
	<style>
	.btn-memo {
	-moz-box-shadow:inset 0px 0px 0px 0px #ffffff;
	-webkit-box-shadow:inset 0px 0px 0px 0px #ffffff;
	box-shadow:inset 0px 0px 0px 0px #ffffff;
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #ffffff), color-stop(1, #e9e9e9) );
	background:-moz-linear-gradient( center top, #ffffff 5%, #e9e9e9 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffff', endColorstr='#e9e9e9');
	background-color:#ffffff;
	-webkit-border-top-left-radius:20px;
	-moz-border-radius-topleft:20px;
	border-top-left-radius:20px;
	-webkit-border-top-right-radius:20px;
	-moz-border-radius-topright:20px;
	border-top-right-radius:20px;
	-webkit-border-bottom-right-radius:20px;
	-moz-border-radius-bottomright:20px;
	border-bottom-right-radius:20px;
	-webkit-border-bottom-left-radius:20px;
	-moz-border-radius-bottomleft:20px;
	border-bottom-left-radius:20px;
	text-indent:0px;
	border:3px solid #756075;
	display:inline-block;
	color:#666666;
	font-family:Comic Sans MS;
	font-size:19px;
	font-weight:bold;
	font-style:normal;
	height:65px;
	line-height:65px;
	width:131px;
	text-decoration:none;
	text-align:center;
	text-shadow:1px 1px 0px #ffffff;
}
.btn-memo:hover {
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #e9e9e9), color-stop(1, #ffffff) );
	background:-moz-linear-gradient( center top, #e9e9e9 5%, #ffffff 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#e9e9e9', endColorstr='#ffffff');
	background-color:#e9e9e9;
}.btn-memo:active {
	position:relative;
	top:1px;
}
/* This button was generated using CSSButtonGenerator.com */
</style>
</head>
<body class="page-memo btn-page">
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
					<button type="button" class="btn-memo">메모생성</button>
					<div class="inner-layer">
						<!-- <div class="memo">
							<textarea></textarea>
							<button type="button" class="btn-m btn-m-save">저장</button>
						</div>  -->
						
						<c:forEach var="memo" items="${list}">
							<div class="memo saved" id="${memo.memoNo}" style="left:${memo.posX}px; top:${memo.posY}px;">
		 							<textarea>${memo.content}</textarea>
<!-- 		 							<button type="button" class="btn-m btn-m-save">저장</button> -->
		 							<button type="button" class="btn-m btn-m-del">삭제</button>
		 					</div>
						</c:forEach>
						
						<!-- <div class="memo">
	 							<textarea></textarea>
	 							<button type="button" class="btn-m btn-m-save">저장</button>
	 							<button type="button" class="btn-m btn-m-del">삭제</button>
	 					</div> -->
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="/EduMIS/js/common.js"></script>
<script type="text/javascript">


var saveMemo = function(memoDiv) {
var content = memoDiv.find('textarea').val(); 
var posXVal = parseInt(memoDiv.css('left'));				
var posYVal = parseInt(memoDiv.css('top'));				
var idVal = memoDiv.attr("id");

	var params = {
				posX: posXVal, 
				posY: posYVal,
				content : content,
				id : idVal
				};
				
	if(memoDiv.hasClass("saved")){		 // 업데이트
			$.get("/EduMIS/memo/updateMemo.do",params,function(){
			})
	}
	else{														 // 저장
		$.get("/EduMIS/memo/insertMemo.do",params,function(data){
		  memoDiv.attr("id",data);
		})	
	
		memoDiv.addClass("saved");
	}	
}
	
	$(document).ready(function(){
		$(".memo").draggable();
		
		// 메모 삭제 클릭
		$(".inner-layer").on('click',".btn-m-del", function() {
			if($(this).parent().hasClass("saved")){ 	
				var idVal = $(this).parent().attr("id");
				var params={
						id : idVal
				}	
				$.get("/EduMIS/memo/deleteMemo.do",params);
			}			
			$(this).parent().remove();
		});
		
		// 움직일때 저장
		$('.inner-layer').on("mouseup",".memo", function(){
			saveMemo($(this));
		})
		
		// 키보드 떼면 저장
		$(".container-inner").on('keyup',".memo",function(){
			mDiv = $(this);
			saveMemo(mDiv);
		})
	})//ready종료

	// 메모 생성
	$('.btn-memo').on('click', function(){
		$('<div class="memo"> <textarea></textarea> <button type="button" class="btn-m btn-m-del">삭제</button>	</div>')
		.appendTo('.inner-layer')
		.draggable();
	});

	

	
	
</script>
</html>
