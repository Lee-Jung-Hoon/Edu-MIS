<!doctype html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title>메인</title>
<%@ include file="/WEB-INF/view/admin/include/common.jsp" %>	
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/examgrade/colorbox.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/examgrade/jquery.battatech.excelexport.js"></script>
<script src="${pageContext.request.contextPath}/js/examgrade/jquery.colorbox.js"></script>
<style>
.txt-writeExam-sm {
	color: white !important;
	border: solid 1px black;
	text-decoration: none !important;
	font-weight: bold !important;
	text-indent:0 !important;
	line-height: 40px  !important;
 }
	.iframe {
		background-image:url('/AdvanceEduMIS/images/txt-test-regist-s.png');
		display:inline-block;
		text-indent:-5000px;
		background-color:#00528c;
    border:1px solid #092b68;
    background-repeat:no-repeat;
    background-position:center;
    width:70px;
    height:40px;
    box-sizing:border-box;
    vertical-align:top !important;
	}   
	.btn-page .btn {
		display:inline-block;
		width:70px;
		height:40px;
	}
	
 .txt-test-student-s {
 		background-image:url('/AdvanceEduMIS/images/txt-test-student-s.png');
 }
</style>
<script type="text/javascript">
  $(document).ready(function() {
    $('#content').load('ExamTurnList.do');
    $('#exam').click(function() {
      $('#content').load('ExamTurnList.do');
      return false;
    });
    $('#student').click(function() {
      $('#content').load('ExamStudentList.do');
      return false;
    });
    $(".iframe").colorbox({
      iframe : true,
      title : "시험등록",
      width : "30%",
      height : "45%"
    });
    
    $("#excelExport").colorbox({
      iframe : true,
      title : "엑셀 저장",
      width : "40%",
      height : "50%"
    });
  });
</script>

</head>
<body class="page-main btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<%@ include file="/WEB-INF/view/admin/include/leftMenu.jsp" %>	
			<div class="container">
				<%@ include file="/WEB-INF/view/admin/include/topMenu.jsp" %>
				<div class="container-inner">
					<div class="content">
						<div id="wrap">
							<!--  test-class 부분을  s-aaa 형식의 이름으로 클래스 잡아주세요  common 클래스 이름은 지우지 마세요 -->
							<section class="test-class common">
								<!--  작업부분 제목 써주세요 -->
								<div></div>
								<div></div>
								<h2>성적관리</h2>
								<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->
								<div style="margin-bottom:10px;">
									<a class="iframe"
										href="/AdvanceEduMIS/examgrade/ExamTurnWriteForm.do">시험등록</a>
								
									<a href="javascript:void(0);" class="btn btn-txt btn-blue txt-test-sort-s" id="exam">시험별</a> 
									<a href="javascript:void(0);" class="btn btn-txt btn-blue txt-test-student-s" id="student">학생별</a>
									<a href="${pageContext.request.contextPath}/examgrade/excelExport.do" id="excelExport" class="btn btn-txt btn-blue txt-writeExam-sm">엑셀</a>
								</div>
								
								<div id="content"></div>
								<!--  작업완료 부분 -->
							</section>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>