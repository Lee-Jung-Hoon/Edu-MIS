<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width">
	<title>회원정보</title>
	<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
	<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>
<body class="page-join btn-page">
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
					<!-- 메시지 들어가는 부분 -->
					<div class="top-message">
						<button type="button" class="btn-message">
							<img src="/EduMIS/images/message.png" alt="" />
							<span class="count">1<!-- 메시지 개수 --></span>
						</button>
						<div class="message-layer">
							<button type="button" class="btn-message-close">닫기</button>
							<div class="message-frame">
							<!-- 메시지 작업 시작영역 -->
							<!--  메시지 작업 시작영역 끝 -->	
							</div>
						</div>
					</div>
					<!-- 메시지 들어가는 부분 끝 -->
					<ul>
						<li><a href="/EduMIS/user/mypage/detailMyinfo.do"><img src="/EduMIS/images/icon-user.png" alt="" />마이페이지</a></li>
						<li class="login">
							<a href="#">로그인</a>
							<div class="login-form">
								<form action="" method="">
									<input type="text"  placeholder="아이디" />
									<input type="password"  placeholder="비밀번호" />
									<span><input type="checkbox" id="save" /><label for="save">아이디 저장하기</label></span>
									<input type="submit" class="btn-submit" />
								</form>
								<button type="button" class="btn-close">닫기</button>
							</div>
						</li>
						<li><a href="/user/member/joinForm.do">회원가입</a></li>
					</ul>
				</header>
				<div class="container-inner">
					<div class="content">
						<section class="join common">
							<h2>회원정보</h2>
							<div class="table-common">
								<form name="memberForm" action ="/EduMIS/user/mypage/modifyMyinfoForm.do" method="POST">
								<c:forEach var="list" items="${list}">
									<table>
										<colgroup>
											<col style="width:20%;" />
											<col style="width:70%;" />
											<col style="width:10%;" />
										</colgroup>
										<tbody>
											<tr>
												<th><label for="id">ID</label></th>
												<td><input type="hidden" id="id" name="id" onkeyup="idCheck()" placeholder="아이디 입력" class="size-input01" value = "${list.id}"/>
													${list.id}
<!-- 												    <span id="idResult"></span> -->
												</td>
												<td rowspan="11" class="table-photo">
													<div>
														<span id="imgFrame" class="img"></span>
														<span class="file btn-txt txt-photo btn-blue"><input type="file" onchange="loadFile(event)"></span>
														<ul>
															<li>- gif 혹은 jpg 형식</li>
															<li>- 100kbyte 이내<br />&nbsp;&nbsp;사진만 업로드 가능</li>
															<li>- 권장사이즈 100*150</li>
														</ul>
													</div>
												</td>
											</tr>
											<tr>
												<th><label for="name">이름</label></th>
												<td><input type="hidden" id="name" name="name" placeholder="이름 입력" class="size-input01" value = "${list.name}"/>
													${list.name}
												</td>
											</tr>
											<tr>
												<th><label for="year">생년월일</label></th>
												<td>
												<input type="hidden" id="year" name="year" class="size-input01" value = "${list.year }"/>
												<input type="hidden" id="month" name="month" class="size-input01" value = "${list.month }"/>
												<input type="hidden" id="day" name="day" class="size-input01" value = "${list.day }"/>
												${list.year }년 ${list.month }월 ${list.day }일
<!-- 													<select id="year"  name="year"> -->
<!-- 														<option value="">출생년도</option> -->
<%-- 														<% for(int i=1950; i<2016; i++){ %> --%>
<%-- 														<option value="<%=i%>"><%=i+"년"%></option> --%>
<%-- 														<%} %> --%>
<!-- 													</select> -->
<!-- 													<select id="month"> -->
<!-- 														<option value="">월</option> -->
<%-- 														<% for(int i=1; i<13; i++){ %> --%>
<%-- 														<option value="<%=i%>"><%=i+"월"%></option> --%>
<%-- 														<%} %> --%>
<!-- 													</select> -->
<!-- 													<select id="day"> -->
<!-- 														<option value="">일</option> -->
<%-- 														<% for(int i=1; i<32; i++){ %> --%>
<%-- 														<option value="<%=i%>"><%=i+"일"%></option> --%>
<%-- 														<%} %> --%>
<!-- 													</select> -->
												</td>
											</tr>
											<tr>
												<th><label for="addr">주소</label></th>
												<td>
													<div class="post-addr"><label for="">(우)</label><input type="hidden" name="postNo" class="size-input03" value="${list.postNo }"/>${list.postNo }</div>
													<input type="hidden" id="addr" name="basicAddr" class="size-input02" placeholder="주소를 동까지 입력해주세요" value="${list.basicAddr }"/>
													<input type="hidden" id="addr2" name="detailAddr" class="size-input02" placeholder="나머지 주소를 입력해주세요" value="${list.detailAddr }"/>
													${list.basicAddr}<br/>
													${list.detailAddr }
													</td>
											</tr>
											<tr>
												<th><label for="hp1">휴대폰</label></th>
												<td>
													<input type="hidden" name="phone1" placeholder="번호 첫 자리" value="${list.phone1 }"/>
													<input type="hidden" name="phone2" placeholder="번호 가운데 자리" value="${list.phone2 }"/>
													<input type="hidden" name="phone3"  placeholder="번호 끝자리" value="${list.phone3 }"/>
													${list.phone1 } - ${list.phone2 } - ${list.phone3 }
												</td>
											</tr>
											<tr>
												<th><label for="email1">이메일</label></th>
												<td>
													<input type="hidden" id="email1" name="email" class="size-input01" placeholder="이메일 도메인 입력" value = "${list.email}"/>
													<input type="hidden" id="emailDomain" name="emailDomain" class="size-input01" placeholder="이메일 도메인 입력" value = "${list.emailDomain}"/>
													${list.email}@${list.emailDomain}
												</td>
											</tr>
											<tr>
												<th><label for="major">전공여부</label></th>
												<td>
													<input type="hidden" id="major" name="major" class="size-input01" value = "${list.major}"/>
													${list.major}
												</td>
											</tr>
										</tbody>
									</table>
									<div class="btn-area" style = "margin-left: 17%">
										<span class="width33"><input type="submit" value="수정하기" class="btn txt-modify btn-txt btn-blue"/></span>
										<span class="width33"><a href="#" class="btn txt-cancel btn-txt btn-gray">취소</a></span>
									</div>
									</c:forEach>
								</form>
							</div>
						</section>				
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="/EduMIS/js/common.js"></script>
<script type="text/javascript">
  var loadFile = function(event) {
    var reader = new FileReader();
    reader.onload = function(){
      var output = "<img src="+reader.result+" alt='' />";
	  $('.img').html(output);
    };
    reader.readAsDataURL(event.target.files[0]);
  };
	$('#reset').on('click', function(){
		$('#imgFrame').find('img').remove();
	});
	$('.btn-post').on('click',function(){
		var popUrl = "post_popup.jsp";	//팝업창에 출력될 페이지 URL
		var popOption = "width=500, height=400, resizable=no, scrollbars=no, status=no;";    //팝업창 옵션(optoin)
		window.open(popUrl,"",popOption);
	});
</script>
</html>
