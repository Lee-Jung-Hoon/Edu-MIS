<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="/EduMIS/js/examgrade/jquery.battatech.excelexport.js"></script>
<script type="text/javascript" src="/EduMIS/js/httprequest.js"></script>
<!-- <script src="//code.jquery.com/jquery-1.10.2.js"></script> -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
  $(document).ready(
      function() {
        sendRequest("/EduMIS/ExamGradeExcelController.do", null, responseMsg, "GET");

        $("#btnExport").click(function() {
          $("#tblExport").battatech_excelexport({
            containerid : "tblExport",
            datatype : 'table'
          });
        });
      });

  function responseMsg() {
    if (httpRequest.readyState == 4) {
      if (httpRequest.status == 200) {
        var tr = '';
        var div = document.getElementById("theadTr");
        var scoreList = eval(httpRequest.responseText);
        var s = scoreList[0].score;
        div.innerHTML += "<th>이름/시험명</th>";
        for (var i = 0; i < s.length; i++)
          div.innerHTML += "<th>" + s[i].split(":")[0] + "</th>";
      }
      div = document.getElementById("tbody");
      for (var j = 0; j < scoreList.length; j++) {
        tr = document.createElement("tr");
        var s = scoreList[j].score;
        tr.innerHTML += "<td> " + scoreList[j].name + " </td>";
        for (var k = 0; k < s.length; k++) {
          tr.innerHTML += "<td>" + s[k].split(":")[1] + "</td>";
        }
        div.appendChild(tr);
      }
    }
  }
</script>
</head>
<body>
	<div id="wrap">
	<h1>엑셀 저장 내용</h1>
		<table border="1" class="table-board" id='tblExport'>
			<thead>
				<tr id="theadTr"></tr>
			</thead>
			<tbody id="tbody">
			</tbody>
		</table>

		<button id='btnExport' type='button'>엑셀로 저장</button>
	</div>
</body>
</html>