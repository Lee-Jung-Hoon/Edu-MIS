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
	
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>	
</head>
<body class="page-main btn-page">
	<div class="wrap">
		<div class="wrap-inner">
<%-- 			<%@ include file="/jsp/admin/include/leftMenu.jsp" %>	 --%>
			<div class="container">
<%-- 				<%@ include file="/jsp/admin/include/topMenu.jsp" %> --%>
					
				<div class="container-inner">
					<div class="content">
					<section class="test-class common table-common talk-history-detail">
							<!--  작업부분 제목 써주세요 -->
							<h2>Talk 히스토리</h2>
							<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->

																	<div class="">
								<table border="1">

									<tr>
										<th>보낸사람 :</th>
										<td>${detail.name}</td>
										<th>받은시간 :</th>
										<td>${detail.sendDate}</td>
									</tr>
									<tr>
										<th>내용 :</th>
										<td>${detail.content}</td>
									</tr>
								</table>
							
								<Form action="${pageContext.request.contextPath}/talk/insertSendTalk.do">
									<table class="table-common" style="margin-top:20px;">
										<tr>
											
											<th>답장 : </th>
											<td><input type="text" name="content" size="85" /></td>
											<td><input type="submit" value="보내기" class="btn btn-txt txt-send-s btn-blue" />
												<input type="hidden" name="sendMemberNo" value="${detail.sendMemberNo}" />
												<input type="hidden" name="tNo" value="${detail.no}" />
												<input type="hidden" name="receiveMemberNo" value="${detail.receiveMemberNo}" />
												<input type="hidden" name="pNo" value="${detail.pNo}" />
											</td>
										</tr>
									</table>
									<div class="btn-area">
										<span class="width50"><a class="btn btn-txt txt-list btn-blue" href="${pageContext.request.contextPath}/talk/recvList.do">목록</a></span>
										<span class="width50"><a class="btn btn-txt txt-del-b btn-blue" href="${pageContext.request.contextPath}/talk/deleteTalk.do?no=${detail.no}">삭제</a></span>
									</div>
								</Form>


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
