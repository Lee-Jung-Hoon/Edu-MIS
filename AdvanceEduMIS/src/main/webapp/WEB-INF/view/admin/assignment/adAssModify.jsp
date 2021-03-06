<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width">
	<title>제목</title>
	<%@ include file="/WEB-INF/view/admin/include/common.jsp" %>
	<script src="${pageContext.request.contextPath}/js/assignment/assignment.js"></script>
	<script>	
	$('input:file').on('change', function(){
	  $('.val-txt').val($(this).val())
	});
	</script>
</head>
<body class="page-join btn-page">
	<div class="wrap">
		<div class="wrap-inner">
				<%@ include file="/WEB-INF/view/admin/include/leftMenu.jsp" %>
			<div class="container">
				<%@ include file="/WEB-INF/view/admin/include/topMenu.jsp" %>
				<div class="container-inner">
					<div class="content">
					<!--  test-class 부분을  s-aaa 형식의 이름으로 클래스 잡아주세요  common 클래스 이름은 지우지 마세요 -->
						<section class="test-class common">
							<!--  작업부분 제목 써주세요 --><h2>과제 수정</h2>
							<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->
								<form method="POST" action="assRegist.do" name = "regForm" enctype="multipart/form-data" onsubmit="return ckForm();" >
								<input type="hidden" name="type" value="M" />
								<div class="adAssRegist">
									<table class="tb-test table-common" align="center">
										<colgourp>
											<col style="width:10%" />
											<col style="width:90%" />
										</colgourp>
										<tr>
											<th style="text-align:center; text-indent:0;">제목</th>
											<td class=""><input type="text" size="100%" name="title" id = "title" value="${modi.title}" /></td>
										</tr>
										<tr>
											<th style="text-align:center; text-indent:0;">진행기간</th>
											<td>시작일&nbsp;&nbsp;<input type="date" size="40%" name="startDate" id = "startDate" value="${modi.startDate}" />
											    &nbsp;&nbsp; 종료일&nbsp;&nbsp;<input type="date" size="40%" name="endDate" id = "endDate" value="${modi.endDate}"/></td>
										</tr>
	
										<tr>
											<th style="text-align:center; text-indent:0;">글 내용</th>
											<td colspan="3"><textarea cols="110" rows="20"
													name="content" id = "content">${modi.content}</textarea></td>
										</tr>
	
										<tr>
											<th style="text-align:center; text-indent:0;">첨부 파일</th>
											<td align="left">
												<span class="file btn-txt txt-file btn-blue" style="display:inline-block; width:70px; height:40px;">
													<input type="file" name="file" style="display:block; width:100%; height:100%; cursor:pointer; padding:0; color:transparent; text-indent:-5000px;" />
												</span>
												<input type="text" class="val-txt" style="width:80%; border:0; background:none; position:relative; top:8px; -webkit-box-shadow:none;" disabled />
											</td>
										</tr>
	
									</table>
								</div>
								<div class="btn-area" style="text-align:right; margin-bottom:20px;">
									<input type="hidden" name = "no" value="${modi.no}"/>
									<input style="width:70px; height:40px; display:inline-block;" type="submit" value="과제 수정" class="btn txt-assign-modify-s btn-txt btn-blue" />
									<input type="button" style="width:70px; height:40px; display:inline-block;" value="목록" onclick="moveList();" class="btn txt-assign-list-s btn-txt btn-blue" />
								</div>
								<!-- 
								<div>
										<table class="tb-test2">
										<tr>
											<td>
												<span><input type="button" value="목록"  onclick="moveList();"/></span>
												<span><input type="hidden" name = "no" value="${modi.no}"/></span>
												<span><input type="submit" value="과제 수정"></span>	
											</td>
											</tr>
											</table>
								</div>
								 -->
							</form>
							<!--  작업완료 부분 -->
						</section>				
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
