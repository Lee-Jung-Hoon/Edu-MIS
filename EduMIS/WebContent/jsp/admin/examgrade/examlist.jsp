<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
$(".examdetail").colorbox({iframe:true, title: "시험별 상세정보",  width:"60%", height:"70%"});
$(".gradewrite").colorbox({iframe:true, title: "시험 성적 등록",  width:"16%", height:"45%"});
$(".grademodify").colorbox({iframe:true, title: "시험 성적 수정",  width:"25%", height:"45%"});
$(".excelExport").colorbox({iframe:true, title: "엑셀 저장",  width:"32%", height:"30%"});

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

table.scrollmain tbody,
table.scrollmain thead { display: block; }

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

tbody { border-top: 2px solid black; }

tbody td, thead th {
    /* width: 20%; */ /* Optional */
    border-right: 1px solid black;
    /* white-space: nowrap; */
}

tbody td:last-child, thead th:last-child {
    border-right: none;
}
</style>
<table class="table-board scrollmain">
    <thead>
		<tr>
			<th width="5%">회차번호</th>
			<th width="25%">시험제목</th>
			<th width="30%">시험내용</th>
			<th width="20%">시험일자</th>
			<th width="5%">성적등록/수정</th>
			<th width="15%">시험삭제</th>
		</tr>
    </thead>
		<tbody>
		<c:forEach var="list" items="${list}">
			<tr align="center">
				<td width="5%">${list.no}</td>
				<td width="25%">${list.title}</td>

				<td width="30%">
				<c:if test="${list.ck=='false'}">
					${list.content}
				</c:if> 
				<c:if test="${list.ck=='true'}">
						<a class="examdetail"
							href="${pageContext.request.contextPath}/examgrade/ExamGradeDetail.do?no=${list.no}">${list.content}</a>
				</c:if>
				</td>

				<td width="20%">${list.regDate}</td>

				<td width="5%"><c:if test="${list.ck=='false'}">
						<a class="gradewrite"
							href='${pageContext.request.contextPath}/examgrade/ExamGradeWriteForm.do?no=+${list.no}'>성적등록</a>
					</c:if> <c:if test="${list.ck=='true'}">
						<a class='grademodify'
							href='${pageContext.request.contextPath}/examgrade/ExamGradeModifyForm.do?no=+${list.no}'>성적수정</a>
					</c:if></td>
				<td width="15%"><a
					href="${pageContext.request.contextPath}/examgrade/ExamTurnDelete.do?no=+${list.no}">삭제</a></td>
			</tr>
		</c:forEach>
		</tbody>
</table>
		<a href="/EduMIS/jsp/admin/examgrade/excelExport.jsp" class="excelExport">엑셀저장</a>
</body>
</html>