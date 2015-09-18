<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width">
	<title>회원가입</title>
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
						<li><a href="#"><img src="/EduMIS/images/icon-user.png" alt="" />마이페이지</a></li>
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
						<li><a href="#">회원가입</a></li>
					</ul>
				</header>
				<div class="container-inner">
					<div class="content">
						<section class="join common">
							<h2>회원가입</h2>
							<div class="table-common">
								<form action="" method="">
									<table>
										<colgroup>
											<col style="width:20%;" />
											<col style="width:70%;" />
											<col style="width:10%;" />
										</colgroup>
										<tbody>
											<tr>
												<th><label for="id">ID</label></th>
												<td><input type="text" id="id" placeholder="아이디 입력" class="size-input01" /></td>
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
												<td><input type="text" id="name" placeholder="이름 입력" class="size-input01" /></td>
											</tr>
											<tr>
												<th><label for="passwd">비밀번호</label></th>
												<td><input type="password" id="passwd" placeholder="비밀번호 입력" class="size-input01" /></td>
											</tr>
											<tr>
												<th><label for="passwd2">비밀번호 재입력</label></th>
												<td><input type="password" id="passwd2" placeholder="비밀번호 재입력" class="size-input01" /></td>
											</tr>
											<tr>
												<th><label for="year">생년월일</label></th>
												<td>
													<select id="year">
														<option value="">출생년도</option>
														<option value=""></option>
														<option value=""></option>
													</select>
													<select>
														<option value="">월</option>
														<option value=""></option>
														<option value=""></option>
													</select>
													<select>
														<option value="">일</option>
														<option value=""></option>
														<option value=""></option>
													</select>
												</td>
											</tr>
											<tr>
												<th><label for="addr">주소</label></th>
												<td>
													<div class="post-addr"><label for="">(우)</label><input type="text" class="size-input03" /> - <input type="text" class="size-input03" /><button type="button" class="btn-post btn-txt btn-blue">우편번호검색</button></div>
													<input type="text" id="addr" class="size-input02" placeholder="주소를 동까지 입력해주세요" /><span class="txt-rest">(동까지 입력)</span>
													</td>
											</tr>
											<tr>
												<th><label for="addr2">주소 상세</label></th>
												<td><input type="text" id="addr2" class="size-input02" placeholder="나머지 주소를 입력해주세요" /><span class="txt-rest">(나머지 입력)</span></td>
											</tr>
											<tr>
												<th><label for="hp1">휴대폰</label></th>
												<td>
													<select id="hp1">
														<option value="">선택</option>
														<option value="">010</option>
														<option value="">011</option>
														<option value="">016</option>
														<option value="">019</option>
													</select>
													<input type="text" placeholder="번호 가운데 자리" />
													<input type="text"  placeholder="번호 끝자리" />
												</td>
											</tr>
											<tr>
												<th><label for="email1">이메일</label></th>
												<td>
													<input type="text" id="email1" class="size-input01" placeholder="이메일 도메인 입력" />
													<label for="">@</label>
													<select name="" id="">
														<option value="">naver.com</option>
														<option value="">daum.net</option>
														<option value="">gmail.com</option>
													</select>
												</td>
											</tr>
											<tr>
												<th><label for="major">전공여부</label></th>
												<td>
													<input type="radio" name="major" id="major1" checked /><label for="major1">전공</label>&nbsp;&nbsp;
													<input type="radio" name="major" id="major2" /><label for="major2">비전공</label>
												</td>
											</tr>
										</tbody>
									</table>
									<div class="btn-area">
										<span class="width33"><input type="submit" value="회원가입" class="btn txt-join btn-txt btn-blue" /></span>
										<span class="width33"><input type="reset" value="재작성" id="reset" class="btn txt-reset btn-txt btn-blue" /></span>
										<span class="width33"><a href="#" class="btn txt-cancel btn-txt btn-gray">취소</a></span>
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
		var popUrl = "pop.html";	//팝업창에 출력될 페이지 URL
		var popOption = "width=500, height=400, resizable=no, scrollbars=no, status=no;";    //팝업창 옵션(optoin)
		window.open(popUrl,"",popOption);
	});
</script>
</html>
