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
  function DeleteBoard() {
    $.ajax({
      type : 'get',
      url : "/EduMIS/examgrade/ExamTurnDelete.do?no=" + "${board.no}",
      success : function() {
        alert("시험 정보가 삭제되었습니다.");
        jsClose();
      },
      error : function(err) {
        alert("삭제시 오류가 발생했습니다.");
      }
    });
  }

  function doModify() {
    if (confirm("게시글을 수정하시겠습니까?")) {
      // 				location.href = "${pageContext.request.contextPath}/examgrade/ExamTurnModify.do?no="+"${board.no}";
    }
  }
</script>
<input type="button" value="수정" onclick="doModify()">
<input type="button" value="삭제" onclick="DeleteBoard()">
<table class="table-board">
	<tr>
		<th width="100px">시험제목</th>
		<td>${board.title}</td>
	</tr>

	<tr>
		<th width="100px">시험일자</th>
		<td>${board.regDate}</td>
	</tr>
	<tr>
		<th width="100px">시험내용</th>
		<td>${board.content}</td>
	</tr>
</table>
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
<br />