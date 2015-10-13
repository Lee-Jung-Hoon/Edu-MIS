<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title>인연나비</title>
<%@ include file="/WEB-INF/view/admin/include/common.jsp"%>

<style>
.member {
	float: left;
}

img {
	width: "90px";
	height: "90px";
}

.mybody {
	padding-bottom: 300px;
}
.button2{
	width : 90px;
}

</style>
<script>
var count =0;
var list = null;
function remake() {
  
  $.ajax({
    Type : "post",
    url : "remake.json"
  }).done(function(data) {
    alert(data);
    list = eval(data);
    count = 0;
    for(var i = 0; i<list.length;i++){
    $("#list"+list[i].team).html('<div style="clear: both;"><h2>'+list[i].team+'조</h2></div>');
    }
    
    setTimeout(dummy, 1000);
    
  });
  
//   location.href = "/EduMIS/makegroups/remake.do";
} 

function dummy() {
  var i = count;
  var filePath = list[i].filePath + "/" + list[i].realFileName;

  if (list[i].filePath == "null") {
    filePath = "/jsp/admin/groupmaker/images/pic1.jpg";

  }
      
  var div ='<div style="display: block;" class="member"><input type="hidden" value="1">';
  div += '<img src ="/AdvanceEduMIS/'+filePath+'" width="60px" height="60px" style="margin-right: 3px">';
  div += 	'<p align="center">'+list[i].name+'</p>';
  $("#list"+list[i].team).append(div);
  count++;
  if(count<list.length){
	setTimeout(dummy, 700);
    
  }
	
	
  }


</script>

</head>
<body class="page-main btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<%@ include file="/WEB-INF/view/admin/include/leftMenu.jsp"%>
			<div class="container">
				<%@ include file="/WEB-INF/view/admin/include/topMenu.jsp"%>

				<div class="container-inner">
					<div class="content">
						<section class="groupsShow common">
							<h2>각 조 현황 보기 <input type="button" value="" onclick="remake()" id="button2"
							style="display: inline-block; width: 100px; height: 40px; margin-left: 10px;"
								class="btn txt-leader-make-s btn-txt btn-blue"></h2>
						
							<div id="mybody">
								<br>
								

								<c:forEach begin="1" end="${gNum/2}" var="i">
									<div id ="list${i}">
									
									<div style="clear: both;">



										<h2>${i}조</h2>
									</div>
									

<%-- 									<c:forEach var="list" items="${mlist}"> --%>

<%-- 										<c:if test="${list.team eq i}"> --%>
<!-- 											<div style="display: block;" class="member"> -->
<!-- 												<input type="hidden" value="1"> -->
<%-- 												<c:if test="${list.filePath eq 'null' }"> --%>
<!-- 												<img src="/EduMIS/jsp/admin/groupmaker/images/pic1.jpg" width="90px" -->
<!-- 													height="90px" style="margin-right: 3px"> -->
<%-- 												</c:if> --%>
<%-- 												<c:if test="${list.filePath ne 'null' }"> --%>
<%-- 												<img src="/EduMIS/${list.filePath}/${list.realFileName}" width="90px" --%>
<!-- 													height="90px" style="margin-right: 3px"> -->
<%-- 												</c:if> --%>
												 
<%-- 												<p align="center">${list.name}</p> --%>
<!-- 											</div> -->
<%-- 										</c:if> --%>

<%-- 									</c:forEach> --%>
							</div>
								</c:forEach>
								
							
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
										
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br /> <br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
								<br />
							</div>
						</section>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
