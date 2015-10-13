<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	var userLogin = "${user}";
</script>        
<aside>
<h2><a href="${pageContext.request.contextPath}/user/main.do">홈</a></h2>
	<ul>
		<li><a href="${pageContext.request.contextPath}/user/lectureList.do">학습영상게시판</a></li>
		<li><a href="${pageContext.request.contextPath}/bookboard/list.do">도서게시판</a></li>
		<li><a href="${pageContext.request.contextPath}/user/assList.do">과제제출 게시판</a></li>
		<li><a href="${pageContext.request.contextPath}/user/votelist.do">조장추천 게시판</a></li>
		<li><a href="${pageContext.request.contextPath}/admin/recvList.do">메시지 히스토리</a></li>
		<li><a href="${pageContext.request.contextPath}/user/mypage/detailMyinfo.do">마이페이지</a></li>
		<li><a href="${pageContext.request.contextPath}/user/memo/open.do">나의메모</a></li>
	</ul>
</aside>