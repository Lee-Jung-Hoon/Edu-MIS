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
					});
				});
					function selectTalk(value) {
						
						var sel = document.querySelector("#sel");
						var opts = sel.options;
						var index = sel.selectedIndex;
						var param = opts[index].value;
						console.log(param)
						switch (param) {
						case "send":
							//sendRequest("/EduMIS/talk/sendList.do", true);
							location.href = '/EduMIS/talk/user/sendList.do';
							break;
						case "receive":
							//sendRequest("/EduMIS/talk/receiveList.do", true);
							location.href = '/EduMIS/talk/user/recvList.do';
							break;
						case "trash":
							location.href = '/EduMIS/talk/user/trashList.do';
							//sendRequest("/EduMIS/talk/receiveList.do", true);
							break;
						}
					}
				
				function doAction(type) {
				  var f = document.talkForm;

				  var ckVal = "";
			    $(".delCheck:checked").each(function (index, item) {
			      if (index != 0) {
			        ckVal += ",";
			      }
			      ckVal += $(this).val();
			    });
					// checkbox 체크된 값 :   1,2,3 ..
			    f.delCheck.value = ckVal;
					switch(type) {
					case 1:
					  f.action = "/EduMIS/talk/user/realDelete.do";
					  break;
					case 2:
					  f.action = "/EduMIS/talk/user/reviveTalk.do";
					  break;
					}				
					f.submit();
				}
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
											<option value="receive">받은쪽지함</option>
											<option value="basket" selected="selected">휴지통</option>
										</select>
								<form name="talkForm" method="post">
									<input type="hidden" name = "type" value="receive_del" />
									<input type="hidden" name="delCheck" />
								</form>
								
								<input type="button" style="width:50px; height:30px;" class="btn btn-txt txt-del-s btn-blue" value="완전삭제" onclick="doAction(1)" />
								<input type="button" style="width:50px; height:30px;" class="revive" value="복원" onclick="doAction(2)"  />
								<table style="width: 100%" border="1" class="table-board">
									<tr>
										<td align="center" width=5%>
										<input type="checkbox" name="allCheck"class= "allCheck" /></td>
										<th align="center" width=20%>보낸사람</th>
										<th align="center" width=50%>제목</th>
										<th align="center" width=20%>받은시간</th>
									</tr>

									<c:forEach var="list" items="${list}">
										<tr>
											<td align="center" width=5% >
											<input type="checkbox" class="delCheck" name="delCheck" value="${list.no}" /></td>
											<td align="center" width=15%>${list.name}</td>
											<td align="center" width=50%>${list.content}</td>
											<td align="center" width=20%>${list.sendDate}</td>
										</tr>
									</c:forEach>
								</table>
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
