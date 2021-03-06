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
	<%@ include file="/WEB-INF/view/admin/include/common.jsp" %>	
</head>
<body class="page-main btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<%@ include file="/WEB-INF/view/admin/include/leftMenu.jsp" %>	
			<div class="container">
				<%@ include file="/WEB-INF/view/admin/include/topMenu.jsp" %>
				<div class="container-inner">
					<div class="content">
						<section class="main-section">		
							<div id="page2" class="intro">
								<div id="seatContainer" style="width:100%; height:500px;">
<%-- 									<img src="${pageContext.request.contextPath}/memberFile/pic3.jpg"/> --%>
								</div>
							</div>
							<div id="page1" class="intro">
								<h2><img src="${pageContext.request.contextPath}/images/tit-present.png" alt="금일 출석 현황" /></h2>
								<div id="chartContainer" style="width:100%; height:500px;"></div>
							</div>
						</section>				
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/canvasjs.min.js"></script>
<script type="text/javascript">
//*
	window.onload = function () {
		console.log("attend : " + "${attend}");
		console.log("absent : " + "${absent}");
		console.log("absentName : " + "${absentName}");
		console.log("late : " + "${late}");
		console.log("lateName : " + "${lateName}");
		
		var chart = new CanvasJS.Chart("chartContainer",
		{
			title:{
				text: ""
			},
            animationEnabled: true,
			theme: "theme2",
			data: [
			{        
				type: "doughnut",
				indexLabelFontFamily: "MalgunGothic",       
				indexLabelFontSize: 20,
				startAngle:0,
				indexLabelFontColor: "#000",       
				indexLabelLineColor: "darkgrey", 
				toolTipContent: "{y}명", 					

				dataPoints: [
				{  y: "${attend}", indexLabel: "출석 ${attend}명" },
				{  y: "${absent}", indexLabel: "결석 ${absentName} ${absent}명" },
				{  y: "${late}", indexLabel: "지각 ${lateName} ${late}명" }
				]
			}
			]
		});
		chart.render();
	}
	//*/
</script>
</html>
