<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<link href="/AdvanceEduMIS/css/reset.css" rel="stylesheet" type="text/css" />
<link href="/AdvanceEduMIS/css/style.css" rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>
  function jsClose() {
    parent.$.fn.colorbox.close();
    parent.location.reload();
  }
  // ajaxSubmit
  function registGrade_submit() {
    $.ajax({
      type : 'get',
      url : "/AdvanceEduMIS/examgrade/writescore.do",
      data : $("#examForm").serialize(),
      success : function(data) {
        alert("시험 정보가 등록되었습니다.");
        jsClose();
      },
      error : function(err) {
        alert("시험 정보가 등록되었습니다.");
        jsClose();
      }
    });
  }
  
//Change the selector if needed
  var $table = $('table.scrollwrite'),
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

.txt-writeExam-s {
/*  		background-image:url('/AdvanceEduMIS/images/ExamGrade_writeBtn.png'); */
	color: white;
	border: solid 1px white;
	text-decoration: none;
	font-weight: bold;
 }
 
 .btnDiv {
 	padding-top: 10px;
 }

table.scrollwrite {
    /* width: 100%; */ /* Optional */
    /* border-collapse: collapse; */
    border-spacing: 0;
    border: 2px solid black;
}

table.scrollwrite tbody,
table.scrollwrite thead { display: block; }

thead tr th { 
    height: 30px;
    line-height: 30px;
    /* text-align: left; */
}

table.scrollwrite tbody {
    height: 200px;
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
<form name="examForm" method="get" id="examForm">
	<c:if test="${empty member}">
				입력할 회원이 없습니다.
		</c:if>

	<c:if test="${!empty member}">
		<table class="table-board scrollwrite">
			<thead>
				<tr style="display:table; width:100%;">
					<th width="20%">시험제목</th>
					<td width="80%">${board.title}</td>
				</tr>
				<tr style="display:table; width:100%;">
					<th width="20%">시험내용</th>
					<td width="80%">${board.content}</td>
				</tr>
				<tr style="display:table; width:100%;">
					<th width="20%">시험일자</th>
					<td width="80%">${board.regDate}</td>
				</tr>
			</thead>
			<tbody>
				<c:set var="list" value="${member}" />
				<c:forEach var="member" items="${member}" varStatus="loop">
					<tr>
						<c:if test="${loop.first}">
							<th width="20%" rowspan="${fn:length(list)}">입력</th>
						</c:if>
						<td width="40%"><c:out value="${member.name}" /></td>
						<td width="40%"><input type="text" id="${member.id}" name="${member.id}" value="0" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
<input type="hidden" value="${board.title}" name="title" />
<input type="hidden" value="${board.content}" name="content" />
<input type="hidden" value="${board.no}" name="no" />
<div class="btnDiv"><p align="center">
	<a class="btn btn-txt btn-blue txt-writeExam-s" href="javascript:registGrade_submit()">글등록</a> <a
		href="javascript:jsClose()" class="btn btn-txt btn-blue txt-writeExam-s" >취소</a>
</p></div>
</form>
<script type="text/javascript" src="/AdvanceEduMIS/js/common.js"></script>

