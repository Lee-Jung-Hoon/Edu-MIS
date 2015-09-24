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
function modifyGrade_submit() {
  $.ajax({
    type : 'get',
    url : '${pageContext.request.contextPath}/examgrade/ModifyScoreUpdate.do',
    data : $("#exammodifyForm").serialize(),
    success : function(data) {
      alert("시험 정보가 등록되었습니다.");
      jsClose();
    },
    error : function(err) {
      alert("등록시 오류가 발생했습니다.");
    }
  });
}
</script>
<form name="exammodifyForm" method="get" id="exammodifyForm">
	<input type="hidden" id="no" name="no" value="${no}">
	<table class="table-board scroll">
		<thead>
			<tr>
				<th width="150px">이름</th>
				<th width="200px">아이디</th>
				<th width="100px">점수</th>
				<th width="200px">시험일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${list}">
				<tr>
					<td width="150px">${list.name}</td>
					<td width="200px">${list.id}</td>
					<td width="100px"><input id="${list.id}" name="${list.id}"
						type="text" value="${list.score}"></td>
					<td width="200px">${list.regDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="javascript:modifyGrade_submit()">성적 수정</a>
</form>
<script type="text/javascript" src="/EduMIS/js/common.js"></script>