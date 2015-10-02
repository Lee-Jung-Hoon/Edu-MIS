<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	var userLogin = "${user}";
</script>        
<aside>
	<h2>MENU</h2>
	<ul>
		<li><a href="/EduMIS/user/lectureList.do">학습영상게시판</a></li>
		<li><a href="/EduMIS/bookboard/list.do">도서게시판</a></li>
		<li><a href="/EduMIS/user/assList.do">과제제출 게시판</a></li>
		<li><a href="/EduMIS/user/votelist.do">조장추천 게시판</a></li>
		<li><a href="/EduMIS/admin/recvList.do">메시지 히스토리</a></li>
		<li><a href="/EduMIS/user/mypage/detailMyinfo.do">마이페이지</a></li>
		<li><a href="/EduMIS/user/memo/open.do">나의메모</a></li>
	</ul>
</aside>