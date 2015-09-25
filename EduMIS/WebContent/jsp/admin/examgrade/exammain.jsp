<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title>메인</title>
<%@ include file="/jsp/admin/include/common.jsp"%>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<link rel="stylesheet" href="/EduMIS/css/examgrade/colorbox.css" />
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="/EduMIS/js/examgrade/jquery.colorbox.js"></script>
<script type="text/javascript">
  $(document).ready(function() {
    $('#content').load('/EduMIS/examgrade/ExamTurnList.do');
    $('#exam').click(function() {
      $('#content').load('/EduMIS/examgrade/ExamTurnList.do');
      return false;
    });
    $('#student').click(function() {
      $('#content').load('/EduMIS/examgrade/ExamStudentList.do');
      return false;
    });
    $(".iframe").colorbox({
      iframe : true,
      title : "시험등록",
      overlayClose : false,
      width : "30%",
      height : "20%"
    });
    $("#datepicker").datepicker();
  });
</script>
</head>
<body class="page-main btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<%@ include file="/jsp/admin/include/leftMenu.jsp" %>	
			<div class="container">
				<%@ include file="/jsp/admin/include/topMenu.jsp"%>

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
								<p>
									<a class='iframe'
										href="/EduMIS/jsp/admin/examgrade/examturnwriteForm.jsp">시험등록</a>
								</p>
								<a href="javascript:void(0);" id="exam">시험별</a> <a
									href="javascript:void(0);" id="student">학생별</a>

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
<script type="text/javascript" src="/EduMIS/js/common.js"></script>
</html>