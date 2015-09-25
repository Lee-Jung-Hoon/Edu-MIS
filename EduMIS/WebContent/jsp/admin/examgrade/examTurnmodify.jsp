<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
#chart_div {
	border: 2px solid black;
}
</style>

<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script>
  google.load('visualization', '1', {
    packages : [ 'corechart', 'bar' ]
  });
  google.setOnLoadCallback(drawBasic);

  function drawBasic() {
    var data = google.visualization.arrayToDataTable([
        [ '성적', '성적' ],
        <c:forEach var="list" items="${list}">['${list.name}, ${list.id}',
            Number('${list.score}')], </c:forEach> ]);

    var options = {
      title : '${board.title}', // 제목
      chartArea : {
        width : '80%',
        height : '75%'
      },
      hAxis : {
        title : '${board.content}',
        minValue : 0
      }
    };

    var chart = new google.visualization.BarChart(document
        .getElementById('chart_div'));

    chart.draw(data, options);
  }

  function jsClose() {
    parent.$.fn.colorbox.close();
    parent.location.reload();
  }

  // ajaxSubmit
 function modifyTurn_submit() {
  $.ajax({
    type : 'get',
    url : '${pageContext.request.contextPath}/examgrade/ExamTurnUpdate.do',
    data : $("#examTurnmodifyForm").serialize(),
    success : function(data) {
      alert("시험 정보가 수정되었습니다.");
      jsClose();
    },
    error : function(err) {
      alert("수정시 오류가 발생했습니다.");
    }
  });
}
  
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
<form name="examTurnmodifyForm" method="get" id="examTurnmodifyForm">
<table class="table-board">
	<tr>
		<input type="hidden" value="${no}"/>
		<th width="100px">시험제목</th>
		<td align="left"><input size="170px" id="title" name="title" type="text" value="${board.title}"></td>
	</tr>

	<tr>
		<th width="100px">시험일자</th>
		<td align="left">${board.regDate}</td>
	</tr>
	<tr>
		<th width="100px">시험내용</th>
		<td align="left"><input size="170px" id="content" name="content" type="text" value="${board.content}"></td>
	</tr>
</table>
</form>
<br/>
<table>
	<tr>
		<th>성적 통계</th>
	</tr>
	<tr>
		<td>
			<div style="width: 1250px; height: 450px" id="chart_div"
				align="center"></div>
		</td>
	</tr>
</table>
	<a href="javascript:modifyTurn_submit()">성적 수정</a>