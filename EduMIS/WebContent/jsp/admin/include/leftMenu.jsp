<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	var adminLogin = "${admin}";
</script>    
<aside>
	<h2>MENU</h2>
	<ul>
		<li><a href="/EduMIS/admin/assList.do">과제 제출 게시판</a></li>
		<li><a href="/EduMIS/admin/commentList.do">교육생관리</a></li>
		<li><a href="/EduMIS/jsp/admin/examgrade/exammain.jsp">성적관리</a></li>
		<li><a href="/EduMIS/jsp/admin/attendance/attendance.jsp">출석부</a></li>
		<li><a href="/EduMIS/attend/attend.do">출석통계</a></li>
		<li><a href="/EduMIS/makegroups/result.do">조 현황보기</a></li>
		<li><a href="/EduMIS/jsp/admin/groupmaker/MakeGroup.jsp">인연나비 조만들기</a></li>
		<li><a href="/EduMIS/jsp/admin/schedule/schedule.jsp">스케줄</a></li>
		<li><a href="/EduMIS/talk/recvList.do">메시지 히스토리</a></li>
		<li><a href="/EduMIS/admin/memo/open.do">나의메모</a></li>
	</ul>
</aside>