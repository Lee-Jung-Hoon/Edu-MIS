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
	<link href="http://fonts.googleapis.com/earlyaccess/jejuhallasan.css"
	rel="stylesheet" type="text/css" />
<%@ include file="/WEB-INF/view/user/include/common.jsp" %>	
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          <c:forEach var = "votelist" items = "${votelist}">
          ['${votelist.vname}',  ${votelist.vcount}],
          </c:forEach>

        ]);

        var options = {
          title: '투표 결과',
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
      }
      
      function moveVote(){
    	  if(confirm("되돌아가시겠습니까?")){
    		  location.href="/AdvanceEduMIS/user/votelist.do";
    	  }
    	  
      }
    </script>
 
</head>
<body class="page-main btn-page">
	<div class="wrap">
		<div class="wrap-inner">
		
			<%@ include file="/WEB-INF/view/user/include/leftMenu.jsp" %>
			<div class="container">
					<%@ include file="/WEB-INF/view/user/include/topMenu.jsp" %>

			
							<section class="leader common">
							<h2>투표 결과</h2>
							<div id="donutchart" style="width: 900px; height: 500px;"></div>
							<div align="center">
							<table class = "tb-test2">
								<tr>
									<td>
									<span><a href="${pageContext.request.contextPath}/user/votelist.do"
									class="btn txt-back btn-txt btn-gray"></a></span>
									</td>
								</tr>
							</table>
							</div>
						</section>
			</div>
		</div>
	</div>
</body>
</html>
