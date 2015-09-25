<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title>제목</title>
<%@ include file="/jsp/admin/include/common.jsp" %>	
<style type="text/css">
table {
	border: 0;
	border-collapse: separate;
	border-spacing: 0;
}

.tb-test {
	width: 900px;
	height: auto;
	border: 1px;
}

.tb-test td, .tb-test th {
	border-bottom: 1px solid #cccccc;
}

.tb-test th {
	text-align: center;
	width: 25%;
}

.tb-test tr {
	text-align: center;
	width: 25%;
}

.tb-test2 {
	width: 900px;
	height: auto;
	text-align: right;
}

th {
	text-align: center !important;
	text-indent: 0 !important;
}

td {
	text-align: left !important;
}
</style>
<script>
  function ckForm() {
    if ($("#title").val() == "") {
      alert("강의 제목을 입력하세요")
      $("#title").focus();
      return false;
    }

    if ($("#contents").val() == "") {
      alert("강의 내용을 입력하세요")
      $("#contents").focus();
      return false;
    }

    var com = $("#video").val();
    if (com.substring(0, 6) != "http://") {
      alert("강의 영상은 링크만 가능합니다.");
      $("#video").focus();
      return false;
    }

    if ($("#video").val() == "") {
      alert("강의 영상을 입력하세요")
      $("#video").focus();
      return false;
    }

    return true;
  }
  function moveList() {
    location.href = "${pageContext.request.contextPath}/user/lectureList.do";
  }
</script>
</head>
<body class="page-join btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<%@ include file="/jsp/admin/include/leftMenu.jsp" %>	
			<div class="container">
				<%@ include file="/jsp/admin/include/topMenu.jsp" %>
				<div class="container-inner">
					<div class="content">
						<!--  test-class 부분을  s-aaa 형식의 이름으로 클래스 잡아주세요  common 클래스 이름은 지우지 마세요 -->
						<section class="test-class common table-common">
							<!--  작업부분 제목 써주세요 -->
							<h2>강의 등록</h2>
							<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->

							<form method="POST" action="/EduMIS/user/lectureRegist.do"
								name="regForm" onsubmit="return ckForm();">
								<div class="adAssRegist">
									<table class="tb-test" align="center">
										<tr>
											<th>강의 제목</th>
											<td class=""><input type="text" size="100%" name="title"
												id="title" placeholder="제목을 입력해주세요." /></td>
										</tr>
										<tr>
											<th>강의 내용</th>
											<td colspan="3"><textarea cols="110" rows="20"
													name="contents" id="content"></textarea></td>
										</tr>
										<tr>
											<th>강의 파일</th>
											<td align="left"><input type="text" name="video"
												size="100%" id="video" placeholder="링크를 입력해주세요." /></td>
										</tr>
									</table>
								</div>
								<div class="btn-area" style="text-align: right">
									<input type="submit"
										style="display: inline-block; width: 70px; height: 40px;"
										class="btn txt-regist-s btn-txt btn-blue" value="강의 등록">
									</td>
								</div>
							</form>
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
