<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title>회원가입</title>
<script>
	
function chkForm() {
	var member = document.memberForm;
	var ch;

	var id = member.id.value;
	if (id == "") {
		alert("ID를 입력하세요");
		member.id.focus();
		return false;
	}
	
	if(member.id.value.length < 3 || member.id.value.length > 12) {
	  alert("아이디를 3~12자리로 입력하세요");
	  member.id.value="";
	  member.id.focus();
	  return false;
	
	}
	
	 for(var i = 0 ; i < member.id.value.length; i++) {
	         ch = member.id.value.charAt(i);
	         if(((ch >= "ㅏ") && (ch <= "히")) || ((ch >="ㄱ") && (ch <="ㅎ")))  {
	   alert("한글은 사용 할 수 없습니다.");
	   member.id.value="";
	   member.id.focus();
		return false;
	  }
	 }
	
	var name = member.name.value;
	if (name == "") {
		alert("이름을 입력하세요");
		member.name.focus();
	  return false;
	}
	
	 for(var i = 0 ; i < member.name.value.length; i++) {
        var name = member.name.value.charAt(i);

        if(((name < "ㅏ") || (name > "히")) && ((name < "ㄱ") || (name  > "ㅎ"))) {
	     alert("한글이 아닙니다.");
	     member.name.value="";
	     member.name.focus();
	     return false;
	    } 
	 }
	
	var pass = member.pass.value;
	if (pass == "") {
		alert("비밀번호를 입력하세요");
		member.pass.focus();
		return false;
	}
	
	if(member.pass.value.length < 4 || member.pass.value.length > 12) {
	  alert("비밀번호를 4~12자리로 입력하세요");
	  member.pass.value="";
	  member.pass.focus();
	  return false;
	}
	
	var passChk= member.passChk.value;
	if (passChk == "") {
		alert("비밀번호 확인을 입력하세요");
		member.passChk.focus();
		return false;
	}
	if(member.pass.value.length < 4 || member.pass.value.length > 12) {
	  alert("비밀번호를 4~12자리로 입력하세요");
	  member.id.value="";
	  member.id.focus();
	  return false;
	}
	
	if(pass!=passChk) {
		alert("비밀번호를 확인하세요");
		f.pass.focus();
		f.pass.select();
		return false;
		}
	
	var year = member.year.value;
	if (year == "") {
		if(value == "") {
		alert("년을 입력하세요");
		member.year.focus();
		return false;
		}
	}
	var month = member.month.value;
	if (month == "") {
	  if(value == ""){
		alert("월을 입력하세요");
		member.month.focus();
		return false;
	  }
	}
	var day = member.day.value;
	if (day == "") {
	  if(value == ""){
		alert("일을 입력하세요");
		member.day.focus();
		return false;
	}
	}


	var basicAddr= member.basicAddr.value;
	if (basicAddr == "") {
		alert("주소를 입력하세요");
		member.basicAddr.focus();
		return false;
	}
	var detailAddr= member.detailAddr.value;
	if (detailAddr == "") {
		alert("상세 주소를 입력하세요");
		member.detailAddr.focus();
		return false;
	}
	
	var phone1 = member.phone1.value;
	if (phone1 == "") {
		if(value == "010") {
		alert("휴대폰 번호를 입력하세요");
		member.phone1.focus();
		return false;
		}
	}
	var phone2 = member.phone2.value;
	if (phone2 == "") {
		alert("휴대폰 번호를 입력하세요");
		member.phone2.focus();
		return false;
	}
	var phone3 = member.phone3.value;
	if (phone3 == "") {
		alert("휴대폰 번호를 입력하세요");
		member.phone3.focus();
		return false;
	}
	
	var email= member.email.value;
	if (email == "") {
		alert("이메일을 입력하세요");
		member.email.focus();
		return false;
	}
	
	var major= member.major.value;
	if (major == "") {
		alert("전공여부를 선택하세요");
		member.major.focus();
		return false;
	}
}

var httpRequest;
function idCheck() {
	var idVal = document.getElementById("id").value;
	httpRequest = new XMLHttpRequest();
	httpRequest.onreadystatechange = callBack;
	httpRequest.open("GET", "/EduMIS/member/idCheck.do?id=" + idVal, true);
	httpRequest.send(null);
}
function callBack() {
	if (httpRequest.readyState == 4) {
		if (httpRequest.status == 200) {
		var idResult = document.getElementById("idResult");
		idResult.innerHTML = httpRequest.responseText;
		}
	}
}
</script>

<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="httprequest.js"></script>
</head>
<body class="page-join btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<%@ include file="/jsp/admin/include/leftMenu.jsp" %>	
			<div class="container">
					<%@ include file="/jsp/admin/include/topMenu.jsp" %>
				<div class="container-inner">
					<div class="content">
						<section class="join common">
							<h2>회원가입</h2>
							<div class="table-common">
								<form name="memberForm" onsubmit="return chkForm()"
									action="/EduMIS/user/member/join.do" method="POST" enctype="multipart/form-data">
									<table>
										<colgroup>
											<col style="width: 20%;" />
											<col style="width: 70%;" />
											<col style="width: 10%;" />
										</colgroup>
										<tbody>
											<tr>
												<th><label for="id">ID</label></th>
												<td><input type="text" id="id" name="id"
													onkeyup="idCheck()" placeholder="아이디 입력"
													class="size-input01" /> <span id="idResult"></span></td>
												<td rowspan="11" class="table-photo">
													<div>
														<span id="imgFrame" class="img"></span> <span
															class="file btn-txt txt-photo btn-blue"><input type="file" name="attachFile" onchange="loadFile(event)"></span>
														<ul>
															<li>- gif 혹은 jpg 형식</li>
															<li>- 100kbyte 이내<br />&nbsp;&nbsp;사진만 업로드 가능
															</li>
															<li>- 권장사이즈 100*150</li>
														</ul>
													</div>
												</td>
											</tr>
											<tr>
												<th><label for="name">이름</label></th>
												<td><input type="text" id="name" name="name"
													placeholder="이름 입력" class="size-input01" /></td>
											</tr>
											<tr>
												<th><label for="passwd">비밀번호</label></th>
												<td><input type="password" id="passwd" name="pass"
													placeholder="비밀번호 입력" class="size-input01" /></td>
											</tr>
											<tr>
												<th><label for="passwd2">비밀번호 재입력</label></th>
												<td><input type="password" id="passwd2" name="passChk"
													placeholder="비밀번호 재입력" class="size-input01" /></td>
											</tr>
											<tr>
												<th><label for="year">생년월일</label></th>
												<td><select id="year" name="year">
														<option value="year">출생년도</option>
														<%
															for (int i = 1950; i < 2016; i++) {
														%>
														<option value="<%=i%>"><%=i + "년"%></option>
														<%
															}
														%>
												</select> <select id="month" name="month">
														<option value="month">월</option>
														<%
															for (int i = 1; i < 13; i++) {
														%>
														<option value="<%=i%>"><%=i + "월"%></option>
														<%
															}
														%>
												</select> <select id="day" name="day">
														<option value="day">일</option>
														<%
															for (int i = 1; i < 32; i++) {
														%>
														<option value="<%=i%>"><%=i + "일"%></option>
														<%
															}
														%>
												</select></td>
											</tr>
									
											<tr>
												<th><label for="addr">주소</label></th>
												<td>
													<div class="post-addr">
														<label for="">(우)</label><input type="text" name="postNo"
															class="size-input03" style="width: 100px" />
														<button type="button" class="btn-post btn-txt btn-blue">우편번호검색</button>
													</div> <input type="text" id="addr" name="basicAddr"
													class="size-input02" placeholder="주소를 동까지 입력해주세요" /><span
													class="txt-rest">(동까지 입력)</span>
												</td>
											</tr>
											<tr>
												<th><label for="addr2">주소 상세</label></th>
												<td><input type="text" id="addr2" name="detailAddr"
													class="size-input02" placeholder="나머지 주소를 입력해주세요" /><span
													class="txt-rest">(나머지 입력)</span></td>
											</tr>
											<tr>
												<th><label for="hp1">휴대폰</label></th>
												<td><select id="hp1" name="phone1">
														<option value="010">010</option>
														<option value="011">011</option>
														<option value="016">016</option>
														<option value="019">019</option>
												</select> <input type="text" name="phone2" placeholder="번호 가운데 자리" />
													<input type="text" name="phone3" placeholder="번호 끝자리" /></td>
											</tr>
											<tr>
												<th><label for="email1">이메일</label></th>
												<td><input type="text" id="email1" name="email"
													class="size-input01" placeholder="이메일 도메인 입력" /> <label
													for="">@</label> <select name="emailDomain"
													id="emailDomain">
														<option value="1">naver.com</option>
														<option value="2">daum.net</option>
														<option value="3">gmail.com</option>
												</select></td>
											</tr>
											<tr>
												<th><label for="major">전공여부</label></th>
												<td><input type="radio" name="major" value="1"
													id="major1" checked /><label for="major1">전공</label>&nbsp;&nbsp;
													<input type="radio" name="major" value="2" id="major2" /><label
													for="major2">비전공</label></td>
											</tr>
										</tbody>
									</table>
									<div class="btn-area">
										<span class="width33"><input type="submit" value="회원가입"
											class="btn txt-join btn-txt btn-blue" /></span> <span
											class="width33"><input type="reset" value="재작성"
											id="reset" class="btn txt-reset btn-txt btn-blue" /></span> <span
											class="width33"><a href="#"
											class="btn txt-cancel btn-txt btn-gray">취소</a></span>
									</div>
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
	function childCall(val, val2) {
		   $(".size-input03").attr("value",val);
		   $("#addr").attr("value",val2);
	   }
</script>
</html>