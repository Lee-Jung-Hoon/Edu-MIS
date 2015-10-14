<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="/AdvanceEduMIS/css/reset.css" rel="stylesheet" type="text/css" />
<link href="/AdvanceEduMIS/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script>
google.load('visualization', '1', {packages: ['corechart', 'line']});
google.setOnLoadCallback(drawBasic);
var num=1;

function drawBasic() {

      var data = new google.visualization.DataTable();
      data.addColumn('number', '회차');
      data.addColumn('number', '점수');
      
      <c:forEach var="list" items="${list}">
		data.addRows([ [Number(num++), Number("${list.score}")]]);
		</c:forEach>

      var options = {
        hAxis: {
          title: '회차'
        },
        vAxis: {
          title: '점수'
        },
        width: 900,
        height: 500
      };

      var chart = new google.visualization.LineChart(document.getElementById('chart_div'));

      chart.draw(data, options);
    }
    
</script>
<div >
	<table class="table-board">
		<tr>
			<th>이름</th>
			<td>${member.name}</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${member.id}</td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td>${member.year}/${member.month}/${member.day}</td>
		</tr>

		<tr>
			<th>가입일</th>
			<td>${member.joinDate}</td>
		</tr>
	</table>
</div>
<div align="center" style="width: 900px; height: 500px" id="chart_div"></div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>

