<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" charset="utf-8" src="js/jquery.leanModal.min.js"></script>

<script type="text/javascript">
$(function(){  
  $('#modaltrigger').leanModal({ top: 110, overlay: 0.8, closeButton: ".hidemodal" });
});
$(function() {
    $( "#datepicker" ).datepicker();
  });
</script>
<title>모달 윈도우 테스트</title>
</head>
<body>
<div id="wrap">
	<h1>모달 윈도우 테스트</h1>
	<div><a href="#loginmodal" class="flatbtn" id="modaltrigger">클릭!</a></div>
</div>

<div id="loginmodal" style="display:none;">
	<form action="${pageContext.request.contextPath}/examgrade/ExamTurnWrite.do">
	<h2>글등록</h2>
	시험일자: <input type="text" id="datepicker">
	시험제목: <input type="text" id="title">
	시험내용: <input type="text" id="content">
	<input type="submit" value="등록">
	</form>
</div>
</body>
</html>