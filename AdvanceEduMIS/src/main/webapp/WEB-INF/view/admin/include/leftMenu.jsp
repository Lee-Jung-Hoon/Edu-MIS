<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	var adminLogin = "${admin}";
</script>    
<aside>
	<h2><a href="${pageContext.request.contextPath}/admin/main.do">홈</a></h2>
	<ul>
		<li><a href="${pageContext.request.contextPath}/admin/studentSeat/arrangeSeat.do">좌석 배치 관리</a></li>
		<li><a href="${pageContext.request.contextPath}/admin/assList.do">과제 제출 게시판</a></li>
		<li><a href="${pageContext.request.contextPath}/admin/commentList.do">교육생관리</a></li>
		<li><a href="${pageContext.request.contextPath}/examgrade/ExamGradeMain.do">성적관리</a></li>
		<li><a href="${pageContext.request.contextPath}/user/admin/attendance/attendance.jsp">출석부</a></li>
		<li><a href="${pageContext.request.contextPath}/attend/attend.do">출석통계</a></li>
		<li><a href="${pageContext.request.contextPath}/makegroups/result.do">조 현황보기</a></li>
		<li><a href="${pageContext.request.contextPath}/makegroups/MakeGroup.do">인연나비 조만들기</a></li>
		<li><a href="${pageContext.request.contextPath}/user/admin/schedule/schedule.jsp">스케줄</a></li>
		<li><a href="${pageContext.request.contextPath}/talk/recvList.do">메시지 히스토리</a></li>
		<li><a href="${pageContext.request.contextPath}/admin/memo/open.do">나의메모</a></li>
	</ul>
</aside>