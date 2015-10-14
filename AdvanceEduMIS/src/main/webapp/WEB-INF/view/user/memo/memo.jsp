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
	<%@ include file="/WEB-INF/view/user/include/common.jsp" %>
<!-- <script src="//code.jquery.com/jquery-1.11.3.min.js"></script> -->
<!--   <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script> -->
<style type="text/css">.btn-memo {
	-moz-box-shadow:inset 0px 1px 0px 0px #ffffff;
	-webkit-box-shadow:inset 0px 1px 0px 0px #ffffff;
	box-shadow:inset 0px 1px 0px 0px #ffffff;
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #f9f9f9), color-stop(1, #e9e9e9) );
	background:-moz-linear-gradient( center top, #f9f9f9 5%, #e9e9e9 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#f9f9f9', endColorstr='#e9e9e9');
	background-color:#f9f9f9;
	-webkit-border-top-left-radius:0px;
	-moz-border-radius-topleft:0px;
	border-top-left-radius:0px;
	-webkit-border-top-right-radius:0px;
	-moz-border-radius-topright:0px;
	border-top-right-radius:0px;
	-webkit-border-bottom-right-radius:0px;
	-moz-border-radius-bottomright:0px;
	border-bottom-right-radius:0px;
	-webkit-border-bottom-left-radius:0px;
	-moz-border-radius-bottomleft:0px;
	border-bottom-left-radius:0px;
	text-indent:0;
	border:3px solid #756275;
	display:inline-block;
	color:#666666;
	font-family:Arial;
	font-size:15px;
	font-weight:bold;
	font-style:normal;
	height:39px;
	line-height:39px;
	width:99px;
	text-decoration:none;
	text-align:center;
	text-shadow:1px 1px 0px #ffffff;
}
.btn-memo:hover {
	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #e9e9e9), color-stop(1, #f9f9f9) );
	background:-moz-linear-gradient( center top, #e9e9e9 5%, #f9f9f9 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#e9e9e9', endColorstr='#f9f9f9');
	background-color:#e9e9e9;
}.btn-memo:active {
	position:relative;
	top:1px;
}
/* This button was generated using CSSButtonGenerator.com */</style>
</head>
<body class="page-memo btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<%@ include file="/WEB-INF/view/user/include/leftMenu.jsp" %>
			<div class="container">
				<%@ include file="/WEB-INF/view/user/include/topMenu.jsp" %>
				<div class="container-inner">
					<button type="button" class="btn-memo">메모생성</button>
					<div class="inner-layer">
						
						<c:forEach var="memo" items="${list}">
							<div class="memo saved" id="${memo.memoNo}" style="left:${memo.posX}px; top:${memo.posY}px;">
		 							<textarea>${memo.content}</textarea>
		 							<button type="button" class="btn-m btn-m-del">삭제</button>
		 					</div>
						</c:forEach>
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">

// 메모 저장
var saveMemo = function(memoDiv) {
	var content = memoDiv.find('textarea').val(); 
	var posXVal = parseInt(memoDiv.css('left'));				
	var posYVal = parseInt(memoDiv.css('top'));				
	var idVal = memoDiv.attr("id");

	var params = {
				content : content,
				memoNo : idVal
				};

	if(posXVal && posYVal){
		params["posX"]=posXVal;
		params["posY"]=posYVal;
	}
	console.log(params);
	
	if(memoDiv.hasClass("saved")){		 // 업데이트
			$.get("update.json",params,function(){
			})
	}
	else{														 // 저장
		$.get("insert.json",params,function(memoNo){
		  memoDiv.attr("id",memoNo);
			memoDiv.addClass("saved");
		})	
	
	}	
}
	
	$(document).ready(function(){
		$(".memo").draggable();
		
		// 메모 삭제 클릭
		$(".inner-layer").on('click',".btn-m-del", function() {
			if($(this).parent().hasClass("saved")){ 	
				var idVal = $(this).parent().attr("id");
				var params={
						memoNo : idVal
				}	
				$.get("delete.json",params);
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
	  saveMemo($('<div class="memo"> <textarea></textarea> <button type="button" class="btn-m btn-m-del">삭제</button>	</div>')
		.appendTo('.inner-layer')
		.draggable());
	});

	

	
	
</script>
</html>
