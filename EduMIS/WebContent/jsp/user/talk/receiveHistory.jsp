<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width">
	<title>제목</title>
	<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
	<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
<style>
table.table-board {
	/* width: 100%; */ /* Optional */
	/* border-collapse: collapse; */
	border-spacing: 0;
}

table.table-board tbody, table.table-board thead {
	display: block;
}

thead tr th {
	height: 30px;	
	line-height: 30px;
	/* text-align: left; */
}

table.table-board tbody {
	height: 200px;
	overflow-y: auto;
	overflow-x: hidden;
}

tbody {
}

tbody td, thead th {
	display:table-cell;
	width: 350px; 
	/* width: 20%; */ /* Optional */
/* 	border-right: 1px solid black; */
	/* white-space: nowrap; */
}

tbody td:last-child, thead th:last-child {
	border-right: none;
}
</style>

<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>
<body class="page-board btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<aside>
				<h2>MENU</h2>
				<ul>
					<li><a href="#">과제 제출 게시판</a></li>
					<li><a href="#">교육생관리</a></li>
					<li><a href="#">조짜기</a></li>
					<li><a href="#">메시지 히스토리</a></li>
				</ul>
			</aside>
			<div class="container">
				<header class="header">
					<button type="button" class="btn-menu">
						  <span></span>
						  <span></span>
						  <span></span>
						  <span></span>
					</button>
					<ul>
						<li><a href="#"><img src="/EduMIS/images/icon-user.png" alt="" />마이페이지</a></li>
						<li class="login">
							<a href="#">로그인</a>
							<div class="login-form">
								<form action="" method="">
									<input type="text"  placeholder="아이디" />
									<input type="password"  placeholder="비밀번호" />
									<span><input type="checkbox" id="save" /><label for="save">아이디 저장하기</label></span>
									<input type="submit" value="LOGIN" class="btn-submit" />
								</form>
								<button type="button" class="btn-close">닫기</button>
							</div>
						</li>
						<li><a href="#">회원가입</a></li>
					</ul>
				</header>
				<script>
				$(document).ready(function () {
				$(".allCheck").on('click', function () {
				  if(this.checked) {
						  $(".delCheck").prop('checked', true);
				  } else {
						  $(".delCheck").prop('checked', false);
				  }
				})
				})
// 					function check() {
// 					  if($("#allCheck").find("checked")){
// 						  $(".delCheck").prop('checked', false)
// 					  } else {
// 						  $(".delCheck").prop('checked', false)
// 					  }
// 					}
					
					function selectTalk(value) {
						
						var sel = document.querySelector("#sel");
						var opts = sel.options;
						var index = sel.selectedIndex;
						var param = opts[index].value;
						console.log(param)
						switch (param) {
						case "send":
							//sendRequest("/EduMIS/talk/sendList.do", true);
							location.href = '/EduMIS/talk/sendList.do';
							break;
						case "receive":
							//sendRequest("/EduMIS/talk/receiveList.do", true);
							location.href = '/EduMIS/talk/recvList.do';
							break;
						case "basket":
							location.href = '/EduMIS/talk/talkTrash.do';
							//sendRequest("/EduMIS/talk/receiveList.do", true);
							break;
						}
					}
				// Change the selector if needed
					var $table = $('table.table-board'),
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
				<div class="container-inner">
					<div class="content">
						<!--  test-class 부분을  s-aaa 형식의 이름으로 클래스 잡아주세요  common 클래스 이름은 지우지 마세요 -->
						<section class="test-class common">
							<!--  작업부분 제목 써주세요 -->
							<h2>Talk 히스토리</h2>
							<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->

							<div class="table-board board-style1">
								<select id="sel" onchange="selectTalk()">
									<option value="send">보낸쪽지함</option>
									<option value="receive" selected="selected">받은쪽지함</option>
									<option value="basket">휴지통</option>
								</select>

								<form action="/EduMIS/talk/checkDelete.do">
								<input type="hidden" name = "type" value="receive_del" />
								<input type="submit" style="width:50px; height:30px;" class="btn btn-txt txt-del-s btn-blue" value="삭제" />
<!-- 									<table style="width: 100%" border="1" class="table-board"> -->
							
<!-- 									</table> -->
									<table style="width: 100%" border="1" class="table-board" >
										<colgroup>
											<col style="width:20%" />
											<col style="width:20%" />
											<col style="width:20%" />
											<col style="width:20%" />
										</colgroup>
										<thead >
											<tr>
												<th><input type="checkbox"
													name="allCheck" class="allCheck" /></th>
												<th>보낸사람</th>
												<th>제목</th>
												<th>받은시간</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="list" items="${list}">
												<tr>
													<td><input type="checkbox"
														class="delCheck" name="delCheck" value="${list.no}" /></td>
													<td>${list.name}</td>
													<td><a style="width: 200px"
														href="/EduMIS/talk/datilTalk.do?no=${list.no}&name=${list.name}&sendNo=${list.sendMemberNo}&receiveNo=${list.receiveMemberNo}&pNo=${list.pNo}">${list.content}</a></td>
													<td>${list.sendDate}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</form>
							<!-- 페이징 -->
							<!-- 페이징 -->
							<!-- 페이징 -->
							<!-- 페이징 -->
							<form action="/EduMIS/talk/searchTalk.do" style=" padding-left: 300px; ">
									<select name="searchType">
										<option value="content" selected="selected">제목</option>
										<option value="send_member_no">보낸사람</option>
									</select> 
									<input type="text" name="searchTalk" /> 
									<input type="submit" style="width:50px; height:30px;" class="btn btn-txt txt-search btn-blue" value="검색" />	
								</form>
							</div>
							<!--  작업완료 부분 -->
							
						</section>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="/EduMIS/js/common.js"></script>
</html>
