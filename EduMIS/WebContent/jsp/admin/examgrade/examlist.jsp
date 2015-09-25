<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
$(".examdetail").colorbox({iframe:true, title: "시험별 상세정보",  width:"80%", height:"90%"});
$(".gradewrite").colorbox({iframe:true, title: "시험 성적 등록",  width:"30%", height:"65%"});
$(".grademodify").colorbox({iframe:true, title: "시험 성적 수정",  width:"25%", height:"45%"});
$(".excelExport").colorbox({iframe:true, title: "엑셀 저장",  width:"40%", height:"40%"});

//Change the selector if needed
var $table = $('table.scrollmain'),
    $bodyCells = $table.find('tbody tr:first').children(),
    colWidth;

// Adjust the width of thead cells when window resizes
$(window).resize(function() {
    // Get the tbody columns width array
    colWidth = $bodyCells.map(function() {
        return $(this).width();
    }).get();
    
    // Set the width of thead columns
    $table.find('thead tr').children().each(function(i, v) {
        $(v).width(colWidth[i]);
    });    
}).resize(); // Trigger resize handler

</script>

<style>
table.scrollmain {
	/* width: 100%; */ /* Optional */
	/* border-collapse: collapse; */
	border-spacing: 0;
	border: 2px solid black;
}

table.scrollmain tbody, table.scrollmain thead {
	display: block;
}

thead tr th {
	height: 30px;
	line-height: 30px;
	/* text-align: left; */
}

table.scrollmain tbody {
	height: 400px;
	overflow-y: auto;
	overflow-x: hidden;
}

tbody {
	border-top: 2px solid black;
}

tbody td, thead th {
	/* width: 20%; */ /* Optional */
	border-right: 1px solid black;
	/* white-space: nowrap; */
}

tbody td:last-child, thead th:last-child {
	border-right: none;
}

tr {
	display: table;
	width: 100%;
	text-align: left;
}

td:first-child {
	width: 93px;
}

td:nth-child(2) {
	width: 140px;
}

td:nth-child(3) {
	width: 232px;
}

td:nth-child(4) {
	width: 185px;
}

td:nth-child(5) {
	width: 139px;
}

td:last-child {
	
}
</style>
<a href="/EduMIS/jsp/admin/examgrade/excelExport.jsp"
	class="excelExport">엑셀저장</a>
<table class="table-board scrollmain">
	<thead>
		<tr>
			<th width="10%">회차번호</th>
			<th width="15%">시험제목</th>
			<th width="25%">시험내용</th>
			<th width="20%">시험일자</th>
			<th width="15%">성적등록/수정</th>
			<th width="15%">시험삭제</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="list" items="${list}">
			<tr align="center">
				<td>${list.no}</td>
				<td>${list.title}</td>

				<td><c:if test="${list.ck=='false'}">
					${list.content}
				</c:if> <c:if test="${list.ck=='true'}">
						<a class="examdetail"
							href="${pageContext.request.contextPath}/examgrade/ExamGradeDetail.do?no=${list.no}">${list.content}</a>
					</c:if></td>

				<td>${list.regDate}</td>

				<td><c:if test="${list.ck=='false'}">
						<a class="gradewrite txt-test-score-s btn btn-blue btn-txt"
							href='${pageContext.request.contextPath}/examgrade/ExamGradeWriteForm.do?no=+${list.no}'>성적등록</a>
					</c:if> <c:if test="${list.ck=='true'}">
						<a class='grademodify txt-edit btn btn-blue btn-txt'
							href='${pageContext.request.contextPath}/examgrade/ExamGradeModifyForm.do?no=+${list.no}'>성적수정</a>
					</c:if></td>
				<td><a class="txt-del btn btn-blue btn-txt"
					href="${pageContext.request.contextPath}/examgrade/ExamTurnDelete.do?no=+${list.no}">삭제</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>