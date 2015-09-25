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
	<%@ include file="/jsp/admin/include/common.jsp" %>
</head>
<body class="page-memo btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<%@ include file="/jsp/admin/include/leftMenu.jsp" %>
			<div class="container">
				<%@ include file="/jsp/admin/include/topMenu.jsp" %>
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
			$.get("/EduMIS/admin/memo/updateMemo.do",params,function(){
			})
	}
	else{														 // 저장
		$.get("/EduMIS/admin/memo/insertMemo.do",params,function(data){
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
				$.get("/EduMIS/admin/memo/deleteMemo.do",params);
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
