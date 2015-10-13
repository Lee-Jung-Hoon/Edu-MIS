<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width">
	<title>메인</title>
<%-- 	<%@ include file="/jsp/admin/include/common.jsp" %> --%>
	<style>
table.table-board {
	/* width: 100%; */ /* Optional */
	/* border-collapse: collapse; */
	border-spacing: 0;
	display:block;
	border:0;
	border-bottom:1px solid #ddd;
}

table.table-board tbody, table.table-board thead {
	display:block;
}
thead tr {
	display:table;
	width:100%;
}
tbody tr {
	display:table;
	width:100%;
	border-bottom:1px solid #ddd;
}

thead tr th {
	height: 30px;	
	line-height: 30px;
	/* text-align: left; */
}
th, td {
	border-bottom:0 !important;
}


table.table-board tbody {
	height: 200px;
	overflow-y: auto;
	overflow-x: hidden;
	display:block;
}

tbody {
	width:100%;
}

tbody td, thead th {
	display:table-cell;
	/*width: 350px;*/ 
	/* width: 20%; */ /* Optional */
/* 	border-right: 1px solid black; */
	/* white-space: nowrap; */
}
thead th:first-child {
	width:10%;
}
thead th:nth-child(2) {
	width:20%;
}
thead th:nth-child(3) {
	width:40%;
}
thead th:last-child {
	width:30%;
}
tbody td:first-child {
	width:93px;
}
tbody td:nth-child(2) {
	width:187px;
}
tbody td:nth-child(3) {
	width:354px;
}
tbody td:last-child {
	
}
.board-style1 td a {
	width:auto;
}
tbody td:last-child, thead th:last-child {
	border-right: none;
}

.top-input-wrap {
	width:100%;
}

.btn-del {
	margin:10px 0;
}
.table-board {
	border-left:1px solid #ddd;
	border-right:1px solid #ddd;
}
.talk-history-receive select {
	height:30px;
}
.talk-form-inner-last {
	margin:20px 0;
	text-align:center;
}
.talk-form-inner-last input[type="text"] {
	height:30px;
	width:200px;
}
.talk-form-inner-last input[type="submit"] {
	display:inline-block;
}
</style>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>	
</head>
<body class="page-main btn-page">
	<div class="wrap">
		<div class="wrap-inner">
<%-- 			<%@ include file="/jsp/admin/include/leftMenu.jsp" %>	 --%>
			<div class="container">
<%-- 				<%@ include file="/jsp/admin/include/topMenu.jsp" %> --%>
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
				
					function selectTalk(value) {
						
						var sel = document.querySelector("#sel");
						var opts = sel.options;
						var index = sel.selectedIndex;
						var param = opts[index].value;
						console.log(param)
						switch (param) {
						case "send":
							//sendRequest("/EduMIS/talk/sendList.do", true);
							location.href = '${pageContext.request.contextPath}/talk/sendList.do';
							break;
						case "receive":
							//sendRequest("/EduMIS/talk/receiveList.do", true);
							location.href = '${pageContext.request.contextPath}/talk/recvList.do';
							break;
						case "basket":
							location.href = '${pageContext.request.contextPath}/talk/talkTrash.do';
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
					<section class="test-class common talk-history-receive">
							<!--  작업부분 제목 써주세요 -->
							<h2>Talk 히스토리 - 받은쪽지함</h2>
							<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->

							<div class="table-board board-style1" style="border:0;">
								
								<select id="sel" onchange="selectTalk()">
									<option value="send">보낸쪽지함</option>
									<option value="receive" selected="selected">받은쪽지함</option>
									<option value="basket">휴지통</option>
								</select>

								<form action="${pageContext.request.contextPath}/talk/checkDelete.do">

										<input type="hidden" name = "type" value="receive_del" />
										<input type="submit" style="width:50px; height:30px;" class="btn btn-txt txt-del-s btn-blue btn-del" value="삭제" />	


									<table style="width: 100%" border="1" class="table-board" >
										<colgroup>
											<col style="width:10%" />
											<col style="width:20%" />
											<col style="width:40%" />
											<col style="width:30%" />
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
													<td><input type="checkbox" class="delCheck" name="delCheck" value="${list.no}" /></td>
													<td>${list.name}</td>
													<td><a href="${pageContext.request.contextPath}/talk/datilTalk.do?no=${list.no}&name=${list.name}&sendNo=${list.sendMemberNo}&receiveNo=${list.receiveMemberNo}&pNo=${list.pNo}" style="display:block; width:350px; text-overflow:ellipsis; overflow:hidden; white-space:nowrap;">${list.content}</a></td>
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
							
							<form action="${pageContext.request.contextPath}/talk/searchTalk.do">
								<div class="talk-form-inner-last">
									<select name="searchType">
										<option value="content" selected="selected">제목</option>
										<option value="send_member_no">보낸사람</option>
									</select> 
									<input type="text" name="content" /> 
									<input type="submit" style="width:50px; height:30px;" class="btn btn-txt txt-search btn-blue" value="검색" />
								</div>
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
</html>
