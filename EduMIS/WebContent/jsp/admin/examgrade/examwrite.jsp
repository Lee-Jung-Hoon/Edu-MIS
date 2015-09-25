<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
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
      url : "${pageContext.request.contextPath}/examgrade/writescore.do",
      data : $("#examForm").serialize(),
      success : function(data) {
        alert("시험 정보가 등록되었습니다.");
        jsClose();
      },
      error : function(err) {
        alert("등록시 오류가 발생했습니다.");
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
				<tr>
					<th width="80px">시험제목</th>
					<td width="180px">${board.title}</td>
				</tr>
				<tr>
					<th width="80px">시험내용</th>
					<td width="180px">${board.content}</td>
				</tr>
				<tr>
					<th width="80px">시험일자</th>
					<td width="180px">${board.regDate}</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="member" items="${member}">
					<tr>
						<td width="80px"><c:out value="${member.name}" /></td>
						<td width="170px"><input type="text" id="${member.id}"
							name="${member.id}"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
<input type="hidden" value="${board.title}" name="title" />
<input type="hidden" value="${board.content}" name="content" />
<input type="hidden" value="${board.no}" name="no" />
	<a href="javascript:registGrade_submit()">글등록</a> <a
		href="javascript:jsClose()">취소</a>
</form>
<script type="text/javascript" src="/EduMIS/js/common.js"></script>

