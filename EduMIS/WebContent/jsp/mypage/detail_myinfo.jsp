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
	<%@ include file="/jsp/user/include/common.jsp" %>	
<script>
<c:if test="${not empty member}">
	var socket = io.connect("192.168.200.72:10004");
	socket.emit("setInfo", {no: "${member.no}", name: "${member.name}"})
</c:if>	
</script>	
</head>
<body class="page-main btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<%@ include file="/jsp/user/include/leftMenu.jsp" %>	
			<div class="container">
				<%@ include file="/jsp/user/include/topMenu.jsp" %>

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
												<input type = "hidden" id ="filePath" name = "filePath" value = "${list.filePath }" />
												<input type = "hidden" id ="realFileName" name = "realFileName" value = "${list.realFileName }" />
												<input type = "hidden" id ="orgFileName" name = "orgFileName" value = "${list.orgFileName }" />
													<div>
														<span id="imgFrame" class="img"><c:if test="${not empty list.filePath}"><img src="/EduMIS${list.filePath}/${list.realFileName}" alt='' /></c:if></span>
<!-- 														<span class="file btn-txt txt-photo btn-blue"><input type="file" onchange="loadFile(event)" ></span> -->
														<ul>
															<li>- 파일이름</li>
															<li>${list.orgFileName}</li>
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
</body>
</html>
