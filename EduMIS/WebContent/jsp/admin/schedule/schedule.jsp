<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title>제목</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="http://resources/demos/style.css">

<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="http://apis.daum.net/maps/maps3.js?apikey=1cd4d7ef46ee8be854cdc1de37076a25&libraries=services"></script>
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<link href="css/common1.css" rel="stylesheet" type="text/css" />
<link href="/EduMIS/css/scheduleCal.css" rel="stylesheet"
	type="text/css" />
<link href="/EduMIS/css/scheduleReg.css" rel="stylesheet"
	type="text/css" />
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="/EduMIS/js/scheduleCal.js"></script>
<script src="/EduMIS/js/scheduleReg.js"></script>
<script type="text/javascript" charset="utf-8"
	src="js/jquery.leanModal.min.js"></script>
<script src="/EduMIS/js/httprequest.js"></script>
<script>
			$(document).ready(function(){
				
				
				 $('.txt-plan').on('click', function(){
// 					  $('.plan_form').animate({'left':'20%'},1000);
 					  $('.plan_form').animate({'left':'38%'},1000);
// 					  $('.plan_form').animate(1000);
					  
				 });
				 
				 $('.cal_close').on('click', function(){
// 					  $('.plan_form').animate({'left':'20%'},1000);
 					  $('.plan_form').animate({'left':'200%'},1000);
// 					  $('.plan_form').animate(1000);
					  
				 });
				 
				
			});
		</script>







<script type="text/javascript">
	 $(document).ready(function() {
		  $(".schedule-list tr").click(function() {
			   $.get("/EduMIS/detailshedule.do", {no:"42"}, function(data) {
					$(".iframe").colorbox({iframe:true, width:"80%", height:"80%"});
					$("#resultDiv").html(data);
				}).fail( function (){
					alert("에러발생")
				})
			   
			   
		  });
	 });

</script>






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
						<span></span> <span></span> <span></span> <span></span>
					</button>
					<!-- 메시지 들어가는 부분 -->
					<div class="top-message">
						<button type="button" class="btn-message">
							<img src="/EduMIS/images/message.png" alt="" /> <span
								class="count">1<!-- 메시지 개수 --></span>
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
						<li><a href="#"><img src="/EduMIS/images/icon-user.png"
								alt="" />마이페이지</a></li>
						<li class="login"><a href="#">로그인</a>
							<div class="login-form">
								<form action="" method="">
									<input type="text" placeholder="아이디" /> <input type="password"
										placeholder="비밀번호" /> <span><input type="checkbox"
										id="save" /><label for="save">아이디 저장하기</label></span> <input
										type="submit" value="LOGIN" class="btn-submit" />
								</form>
								<button type="button" class="btn-close">닫기</button>
							</div></li>
						<li><a href="#">회원가입</a></li>
					</ul>
				</header>
				<div class="container-inner">
					<div class="content">

						<!--  test-class 부분을  s-aaa 형식의 이름으로 클래스 잡아주세요  common 클래스 이름은 지우지 마세요 -->
						<section class="test-class common">









							<!------------------------------------( 등록 폼)----------------------------------------------------------------------- -->

					<div  class="plan_form" style="position:fixed; top:100px; left:30%; width:500px; padding:30px; z-index:99; background:#fff;">		
								<div style="font-size: 20px;">일정 등록</div>
								<hr />
								<form action="/EduMIS/regschedule.do">
									<table id="reg-Form" style="border-collapse: collapse;">
										<tr>
											<th>일 시</th>
											<td style="width:200px"><input type="text" id="datepicker" name="startDate"
												size="10px" style="width:80px" /> ~ <input type="text" id="datepicker2"
												name="endDate" size="10px" style="width:80px" /></td>
											<th>중 요 도</th>
											<td><select id="importance" name="importance">
													<option value="1" selected="selected">보통</option>
													<option value="2">중요함</option>
													<option value="3">매우중요함</option>
											</select></td>
										</tr>
										<tr>
											<th>제 목</th>
											<td colspan="3"><input type="text" id="title" size="46"
												maxlength="20px" name="title" /></td>
										</tr>
										<tr>
											<th>내 용</th>
											<td colspan="3"><textarea rows="5" id="content"
													name="content" cols="45" maxlength="100px"></textarea></td>
										</tr>


										<tr>
											<th width="30%">장 소</th>
											<td colspan="3">
												<div id="search">
													<input type="text" id="place" name="place"> <input
														type="button" value="장소 검색" onclick="search()" style="display:inline-block; width:100px; height:30px;"> <input
														type="hidden" id="latitude" name="latitude"> <input
														type="hidden" id="longitude" name="longitude">
												</div>
												<div id="map" style="width: 100%; height: 200px;"></div>
											</td>
										</tr>
										<tr>
											<hr />
											<script type="text/javascript"
												src="//apis.daum.net/maps/maps3.js?apikey=1cd4d7ef46ee8be854cdc1de37076a25&libraries=services"></script>
											</td>
										</tr>

									</table>
									<br />
									<div align="center">
										<span><input type="submit" value="저장" size="10px" /></span>
									</div>
								</form>
								<button type="button" class="cal_close" size="30px">닫기</button>
				</div> 							


							<!------------------------------------------------------------------------------------------------------------------------------------ -->









							<!--  작업부분 제목 써주세요 -->
							<h2>일정표</h2>
							<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->

<div id="resultDiv">
</div>

							<div class="" id="cal-main">
								<div>
									<table class="top">
										<colgroup>
											<col style="width: 33.333%" />
											<col style="width: 33.333%" />
											<col style="width: 33.333%" />
										</colgroup>
										<tr>
											<td class="topTd_first"><input type="button"
												id="prev-month" value="이전" class="btn-txt txt-search"
												style="width: 40px;"></td>
											<td id="topTd1" class="topTd_middle">&nbsp;&nbsp;&nbsp;<span
												id="month-name"></span>월 &nbsp;&nbsp;&nbsp;
											</td>
											<td class="topTd_last"><input type="button"
												id="next-month" value="다음" class="btn-txt txt-search"
												style="width: 40px;"></td>
										</tr>

									</table>
								</div>
								<br /> <br /> <br />

								<div>
									<table class="tb-0line">
										<tr>
											<th style="color: red;">일</th>
											<th>월</th>
											<th>화</th>
											<th>수</th>
											<th>목</th>
											<th>금</th>
											<th style="color: blue;">토</th>
										</tr>
									</table>
								</div>
								<div class="test00">
									<table class="tb-1line">
										<tr>
											<td id="date1"></td>
											<td id="date2"></td>
											<td id="date3"></td>
											<td id="date4"></td>
											<td id="date5"></td>
											<td id="date6"></td>
											<td id="date7"></td>
										</tr>
									</table>
								</div>
								<div class="test01">
									<div style="width: 60px; float: left;">
										<table>
											<tr>
												<td><input type="button"
														class="btn-txt txt-plan" id="writeBt" style="width: 60px">
												</td>
											</tr>
										</table>
									</div>









									<div style="float: left; width: 85%; text-align: center;">
										
									</div>
								</div>
								<div class="test00">
									<table class="tb-2line">
										<tr>
											<td id="date8"></td>
											<td id="date9"></td>
											<td id="date10"></td>
											<td id="date11"></td>
											<td id="date12"></td>
											<td id="date13"></td>
											<td id="date14"></td>
										</tr>
									</table>
								</div>
								<div class="test01">
									<a href="#loginmodal" class="flatbtn modaltrigger"
										id="modaltrigger"><input type="button"
										class="btn-txt txt-plan" id="writeBt" style="width: 60px"></a>

								</div>
								<div class="test00">
									<table class="tb-3line">
										<tr>
											<td id="date15"></td>
											<td id="date16"></td>
											<td id="date17"></td>
											<td id="date18"></td>
											<td id="date19"></td>
											<td id="date20"></td>
											<td id="date21"></td>
										</tr>
									</table>
								</div>
								<div class="test01">
									<a href="#loginmodal" class="flatbtn modaltrigger"
										id="modaltrigger"><input type="button"
										class="btn-txt txt-plan" id="writeBt" style="width: 60px"></a>

								</div>
								<div class="test00">
									<table class="tb-4line">
										<tr>
											<td id="date22"></td>
											<td id="date23"></td>
											<td id="date24"></td>
											<td id="date25"></td>
											<td id="date26"></td>
											<td id="date27"></td>
											<td id="date28"></td>
										</tr>
									</table>
								</div>
								<div class="test01">

									<a href="#loginmodal" class="flatbtn modaltrigger"
										id="modaltrigger"><input type="button"
										class="btn-txt txt-plan" id="writeBt" style="width: 60px"></a>

								</div>
								<div class="test00">
									<table class="tb-5line">
										<tr>
											<td id="date29"></td>
											<td id="date30"></td>
											<td id="date31"></td>
											<td id="date32"></td>
											<td id="date33"></td>
											<td id="date34"></td>
											<td id="date35"></td>
										</tr>

									</table>
								</div>
								<div class="test01">

									<a href="#loginmodal" class="flatbtn modaltrigger"
										id="modaltrigger"><input type="button"
										class="btn-txt txt-plan" id="writeBt" style="width: 60px"></a>

								</div>
							</div>
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
