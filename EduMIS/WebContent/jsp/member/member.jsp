<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function chkForm() {
	var join = document.joinForm;

	var id = join.id.value;
	if (id == "") {
		alert("ID를 입력하세요");
		join.id.focus();
		return false;
	}
	
	var name = join.name.value;
	if (name == "") {
		alert("이름을 입력하세요");
		join.name.focus();
		return false;
	}
	
	var password = join.password.value;
	if (password == "") {
		alert("비밀번호를 입력하세요");
		join.password.focus();
		return false;
	}
	
	var passChk= join.passChk.value;
	if (passChk == "") {
		alert("비밀번호 확인을 입력하세요");
		join.passChk.focus();
		return false;
	}
	if(password!=passChk) {
		alert("비밀번호를 확인하세요");
		f.password.focus();
		f.password.select();
		return false;
		}
	
	var addr= join.addr.value;
	if (addr == "") {
		alert("주소를 입력하세요");
		join.addr.focus();
		return false;
	}
	
	var phone= join.phone.value;
	if (phone == "") {
		if(value == "1") {
		alert("휴대폰 번호를 입력하세요");
		join.phone.focus();
		return false;
		}
	}
	
	var email= join.email.value;
	if (email == "") {
		alert("이메일을 입력하세요");
		join.email.focus();
		return false;
	}
	
	var major= join.major.value;
	if (major == "") {
		alert("전공여부를 선택하세요");
		join.major.focus();
		return false;
	}
}

// 	var httpRequest;
// 	function idCheck() {
// 		var idVal = document.getElementById("id").value;
// 		httpRequest = new XMLHttpRequest();
// 		httpRequest.onreadystatechange = callBack;
// 		httpRequest.open("GET", "idCheck/idCheck.do?id=" + idVal, true);
// 		httpRequest.send(null);
// 	}
// 	function callBack() {
// 		if (httpRequest.readyState == 4) {
// 			if (httpRequest.status == 200) {
// 			var idResult = document.getElementById("idResult");
// 			idResult.innerHTML = httpRequest.responseText;
// 			}
// 		}
// 	}
</script>
</head>
<body>
	<h1>회원가입</h1>
	<hr />
	<form name="joinForm" onsubmit="return chkForm()" action ="/minipro/controller/join.do" method="POST">
	<table align="center" border="1" >
	<tr>
	<td>ID : <input type="text" name="id" onkeyup="idCheck()">
	<span id="idResult"></span></td>
	</tr>
	
	<tr>
	<td>이름 : <input type="text" name="name"><br /></td>
	</tr>
	
	<tr>
	<td>비밀번호 : <input type="password" name="password"></td>
	</tr>
	
	<tr>
	<td>비밀번호 재입력 : <input type="password" name="passChk"></td>
	</tr>
	
	<tr>
	<td>생년월일 : 
	<select id="birth" name="birth"> 
	<option value="">출생년도</option>
	<% for(int i=1950; i<2016; i++){ %>
	<option value="<%=i%>"><%=i+"년"%></option>
	<%} %>
	</select>
	
	<select id="month" name="month"> 
	<option value="">월</option>
	<% for(int i=1; i<13; i++){ %>
	<option value="<%=i%>"><%=i+"월"%></option>
	<%} %>
	</select>
	
	<select id="day" name="day">
	<option value="">일</option>
	<% for(int i=1; i<32; i++){ %>
	<option value="<%=i%>"><%=i+"일"%></option>
	<%} %>
	</select>
	</tr>
	
	<tr>
		<td>주소 : <input type="text" name="addr" size="50">(동까지 입력)</td></tr>
	<tr><td>상세 : <input type="text" name="addr" size="50">(나머지 입력) </td>
	</tr>
	
	<tr>
	<td>핸드폰 : <select id="phone" name="phone">
	<option value="">선택</option>
	<option value="010">010</option>
	<option value="011">011</option>
	<option value="016">016</option>
	<option value="019">019</option>
	</select>
	<input type="text" name="phone" size="10"> - <input type="text" name="phone" size="10"> </td>
	</tr>
	
	<tr>
	<td>이메일 : <input type="text" name="email"> @
	<select>
	<option>naver.com</option>
	<option>daum.net</option>
	<option>google.com</option>
	</select></td>
	</tr>
	
	<tr>
	<td>전공 여부 : <input type="radio" name="major"> 전공
		  <input type="radio" name="major">비전공</td>
	</tr>
	
	<tr>
	<td><input type="submit" value="회원가입"> <input type="reset" value="재작성"></td>
	</tr>
	</table>
	</form>
</body>
</html>