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
	<c:import url="/jsp/admin/include/common.jsp" />	
</head>
<body class="page-main btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<c:import url="/jsp/admin/include/leftMenu.jsp" />	
			<div class="container">
				<c:import url="/jsp/admin/include/topMenu.jsp" />
				
				<div class="container-inner">
					<div class="content">
						<section class="main-section">		
							<div id="page1" class="intro">
								<h2><img src="/EduMIS/images/tit-present.png" alt="금일 출석 현황" /></h2>
								<div id="chartContainer" style="width:100%; height:500px;"></div>
							</div>
						</section>				
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="/EduMIS/js/canvasjs.min.js"></script>
<script type="text/javascript" src="/EduMIS/js/common.js"></script>
<script type="text/javascript">
	window.onload = function () {
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
				{  y: 24, indexLabel: "출석 24명" },
				{  y: 3, indexLabel: "결석 - 임지원 안지원 김지원 3명" },
				{  y: 1, indexLabel: "지각 - 홍길동" }
/*				{  y: 0.74, indexLabel: "CSS {y}%" },
				{  y: 2.06,  indexLabel: "Jquery {y}%"}*/

				]
			}
			]
		});
		chart.render();
	}
</script>
</html>
