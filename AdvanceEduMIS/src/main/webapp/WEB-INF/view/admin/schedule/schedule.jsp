<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">


<title>일정표</title>

<!-- <script type="text/javascript" 	src="http://apis.daum.net/maps/maps3.js?apikey=1cd4d7ef46ee8be854cdc1de37076a25&libraries=services"></script> -->
<!-- <script src="//code.jquery.com/jquery-1.10.2.js"></script> -->
<%-- <script src="${pageContext.request.contextPath}/js/scheduleCal.js"></script> --%>
<%-- <script src="${pageContext.request.contextPath}/js/scheduleReg.js"></script> --%>
<!-- <script type="text/javascript" charset="utf-8" src="js/jquery.leanModal.min.js"></script> -->
<%-- <script src="${pageContext.request.contextPath}/js/httprequest.js"></script> --%>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>


<!-- <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"> -->
<!-- <link rel="stylesheet" href="http://resources/demos/style.css"> -->
<%-- <link href="${pageContext.request.contextPath}/css/scheduleReg.css" rel="stylesheet" type="text/css" /> --%>
<%-- <link href="${pageContext.request.contextPath}/css/scheduleCal.css" rel="stylesheet"	type="text/css" /> --%>
<link href="${pageContext.request.contextPath}/css/layout.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/schedule.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">


// 날짜 정보 추출
var date = new Date();  													//  Tue Oct 13 2015 11:46:57 GMT+0900 (대한민국 표준시)
var y = date.getFullYear(); 							 				//  2015
var m = date.getMonth();							 				//  9  			(현재 10월)

var firstdate = new Date(y, m, 1);				//		Thu Oct 01 2015 00:00:00 GMT+0900 (대한민국 표준시)
var firstday = firstdate.getDay();   				// 	4  월화수목금토일   기준으로  4번째 목요일에 1일이 있다는 자리 확인 
var startnum = eval(firstday + 1);  				//		5
var lastdate = new Date(y, m + 1, 0);  // Sat Oct 31 2015 00:00:00 GMT+0900 (대한민국 표준시)
var lastday = lastdate.getDate();  				// 	31
var lastday2 = lastdate.getDay();  				// 	6
var lastdate = new Date(y, m + 1, 0);  // Sat Oct 31 2015 00:00:00 GMT+0900 (대한민국 표준시)



//	각각의 날짜 클릭시  날짜 정보 출력
$(document).on("click" , ".dayClick" , function(){

	$(".dayClick").css("background-color" , "#fff");
	$(".dayInfoDiv").hide();
	
	 var id = $(this).attr("id");
	 
	 // 클릭한 날짜정보를 가져온다.
	 var listDate 			=  $(this).find("strong").text();
	 var listMonth 	= m+1;
	 var listYear 			= y;
	 
	 // 날짜 정보가 없을 경우 클릭을 하지 못하게 설정
	 if( listDate != "" ){
	 
				 // 일수가 10미만 일 경우 날짜 앞에  0을 붙여준다.
			   if (listDate < 10) {
				    listDate = "0" + listDate ;
			   }
				 
				 // 월수가 10미만 일 경우 월 앞에 0을 붙여준다.
				 if ( listMonth < 10){
					  listMonth = "0" + listMonth ;
				 }
				 
				 var listData = listMonth +"/"+ listDate +"/"+ listYear;

				 
				 // 해당 날짜의 정보를 가져온다.
			   $.ajax({
				    
				    url : "listInfo.json",
				    dataType : "json",
				    data : "day=" + listData
				    
			   }).done(function(response) {
				    
				    
				    // 클릭한 날짜 아래에 div 의 id 값을 가져온다.
				    var dayInfoDiv =  $("#"+id).parents("table").next().attr("id");
				   
				    
						var dayInfoDivHtml = "";
						
						// 결과값을 뿌린다.						
						response.forEach(function(ScheduleVO, index){
							 
					     dayInfoDivHtml += "<table>";
					     dayInfoDivHtml += "		<tr>";
					     
					     // 중요도에 따라 색상이 다른 색상 값들을 출력
							 if(ScheduleVO.importance == '1'){
								  dayInfoDivHtml += "	 <td ><em style='color:green;'>● 보통</em></td> ";
							 }else if ( ScheduleVO.importance == '2' ){
								  dayInfoDivHtml += "	 <td><em style='color:orange;'>★ 중요</em></td> ";
							 }else{
								  dayInfoDivHtml += "	 <td><em style='color:orange;'>★ 중요</em></td> ";
							 }
					     
					     dayInfoDivHtml += "			<td>      "+ScheduleVO.title+"   </td>";
					     dayInfoDivHtml += "			<td>   "+ScheduleVO.content+"   </td>";
					     dayInfoDivHtml += "		</tr>";
					     dayInfoDivHtml += "</table>";
					     
				    });
						
						
						// 클릭한 날짜 해당란 색상 변경
						$("#"+id).css("background-color" , "#EAEAEA");
						// 정보 출력 div 색상 변경
				    $("#"+dayInfoDiv).css("background-color" , "#EAEAEA");
						// 숨겨진 div 출력
				    $("#"+dayInfoDiv).show();
						
						// 정보 초기화
				    $("#"+dayInfoDiv).html("");
						//  받아온 정보 뿌려주기
				    $("#"+dayInfoDiv).append(dayInfoDivHtml);
				    
				    
			   });

		  }else{
			   
			   var returnChk = confirm("일정을 추가하시겠습니까?");
			   if (returnChk == true) {
								
				    
				    
			   } 
		  }

});








	// 화면이 실행되고 나서 각각의  <td> 태그에 날짜를 입력한다.
	$(document).ready(function() {
		// 최초 로딩 시 해당 월의 일정 조회
		$.ajax({
		    url : "info.json",
		    dataType : "json",
		    data : "year=" + y + "&month=" + (m + 1) + "&lastDay=" + lastday 
	    }).done(function(response) {
	    	showDateInfo(response);
		});	   	
	 });
	 
	 function showDateInfo(dateList) {
		  // 달력의 <td> 에 각각의 날짜 정보를 입력.
		  for (var i = 1; i <= lastday; i++) {
			var dayInfoDivHtml = "";
			if (dateList[i - 1].length == 0) {
				dayInfoDivHtml += i;
				$("#day" + startnum).html(dayInfoDivHtml);
				startnum++;
				continue;
			} 
			dateList[i-1].forEach(function(ScheduleVO, index){

				 console.log(   i+"-"+ScheduleVO.importance+"-"+startnum  );
				 
				 dayInfoDivHtml += "<strong>"+i+"</strong>";
				 
		     // 중요도에 따라 색상이 다른 색상 값들을 출력
				 if(ScheduleVO.importance == '1'){
					  dayInfoDivHtml += "	 <em style='color:green;'>● 보통</em> ";
				 } else if ( ScheduleVO.importance == '2' ){
					  dayInfoDivHtml += "	 <em style='color:orange;'>★ 중요</em> ";
				 } else {
					  dayInfoDivHtml += "	 <em style='color:orange;'>★ 중요</em> ";
				 }
		    });
			// 정보 초기화
			//  받아온 정보 뿌려주기
		    $("#day" + startnum).html(dayInfoDivHtml);
			startnum++;
		  }
	 }
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
							<img src="${pageContext.request.contextPath }/images/message.png" alt="" /> <span
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
						<li><a href="#"><img src="${pageContext.request.contextPath }/images/icon-user.png"
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

						<!-- 							schedule  전체 화면										 -->
						<h1>일정표</h1>
						
							<div>
								
								<!--  달력 화면 -->
								<div>
									<!--  달력 요일 테이블 -->
									<table>
										<tr>
												<th class='dayTitle' id='sunday'>일</th>
												<th class='dayTitle' id='monday'>월</th>
												<th class='dayTitle' id='tueday'>화</th>
												<th class='dayTitle' id='wednesday'>수</th>
												<th class='dayTitle' id='thursday'>목</th>
												<th class='dayTitle' id='friday'>금</th>
												<th class='dayTitle' id='saturday'>토</th>
										</tr>
									</table>
									
									<!--  달력 첫번째 일수 테이블 -->
									<table>
										<tr>
												<td id='day1' class='dayClick'><em id='importance1'></em></td>
												<td id='day2' class='dayClick'><em id='importance2'></em></td>
												<td id='day3' class='dayClick'><em id='importance3'></em></td>
												<td id='day4' class='dayClick'><em id='importance4'></em></td>
												<td id='day5' class='dayClick'><em id='importance5'></em></td>
												<td id='day6' class='dayClick'><em id='importance6'></em></td>
												<td id='day7' class='dayClick'><em id='importance7'></em></td>
										</tr>
									</table>
									
									<!--  클릭시 정보를 보여주는 Div -->
									<div class='dayInfoDiv' id='dayInfoDiv1'>
											
									</div>
									
									
									<!--  달력 두번째 일수 테이블 -->
									<table>
										<tr>
												<td id='day8' 		class='dayClick'><em id='importance8'></em></td>
												<td id='day9' 		class='dayClick'><em id='importance9'></em></td>
												<td id='day10' class='dayClick'><em id='importance10'></em></td>
												<td id='day11' class='dayClick'><em id='importance11'></em></td>
												<td id='day12' class='dayClick'><em id='importance12'></em></td>
												<td id='day13' class='dayClick'><em id='importance13'></em></td>
												<td id='day14' class='dayClick'><em id='importance14'></em></td>
										</tr>
									</table>
									
									<!--  클릭시 정보를 보여주는 Div -->
									<div class='dayInfoDiv' id='dayInfoDiv2'>
									
									</div>
									
									<!--  달력 세번째 일수 테이블 -->
									<table>
										<tr>
												<td id='day15' class='dayClick'><em id='importance15'></em></td>
												<td id='day16' class='dayClick'><em id='importance16'></em></td>
												<td id='day17' class='dayClick'><em id='importance17'></em></td>
												<td id='day18' class='dayClick'><em id='importance18'></em></td>
												<td id='day19' class='dayClick'><em id='importance19'></em></td>
												<td id='day20' class='dayClick'><em id='importance20'></em></td>
												<td id='day21' class='dayClick'><em id='importance21'></em></td>
										</tr>
									</table>
									
									<!--  클릭시 정보를 보여주는 Div -->
									<div class='dayInfoDiv' id='dayInfoDiv3'>
									
									</div>
									
									<!--  달력 네번째 일수 테이블 -->
									<table>
										<tr>
												<td id='day22' class='dayClick'><em id='importance22'></em></td>
												<td id='day23' class='dayClick'><em id='importance23'></em></td>
												<td id='day24' class='dayClick'><em id='importance24'></em></td>
												<td id='day25' class='dayClick'><em id='importance25'></em></td>
												<td id='day26' class='dayClick'><em id='importance26'></em></td>
												<td id='day27' class='dayClick'><em id='importance27'></em></td>
												<td id='day28' class='dayClick'><em id='importance28'></em></td>
										</tr>
									</table>
									
									<!--  클릭시 정보를 보여주는 Div -->
										<div class='dayInfoDiv' id='dayInfoDiv4'>
									
									</div>
									
									
									<!--  달력 다섯번째 일수 테이블 -->
									<table>
										<tr>
												<td id='day29' class='dayClick'><em id='importance29'></em></td>
												<td id='day30' class='dayClick'><em id='importance30'></em></td>
												<td id='day31' class='dayClick'><em id='importance31'></em></td>
												<td id='day32' class='dayClick'><em id='importance32'></em></td>
												<td id='day33' class='dayClick'><em id='importance33'></em></td>
												<td id='day34' class='dayClick'><em id='importance34'></em></td>
												<td id='day35' class='dayClick'><em id='importance35'></em></td>
										</tr>
									</table>
									
									<!--  클릭시 정보를 보여주는 Div -->
										<div class='dayInfoDiv' id='dayInfoDiv5'>
									
									</div>
									
									
									
								</div>
								<!--  달력 끝 -->
								
							</div>
							<!--  달력 전체화면 끝 -->
							
							
							
							
							
								<div class="plan_form" style="position: fixed; top: 110px; left: 200%; width: 450px; padding: 30px; z-index: 99; background: #fff; box-shadow: 0px 0px 50px rgba(10,10,10,10); border-radius: 40px; " >
								<div style="font-size: 20px;">일정 등록</div>
								<hr />
								<form name="regscheduleForm" id="regscheduleForm" action="">
									<table id="reg-Form" style="border-collapse: collapse;">
										<tr>
											<th>일 시</th>
											<td style="width: 230px">
											<input type="text"		id="datepicker" name="startDate" size="10px"			style="width: 100px" /> ~ <input type="text"	id="datepicker2" name="endDate" size="10px"	style="width: 100px" />
											</td>
											<th>중요도</th>
											<td width="30px"><select id="importance" name="importance">
													<option value="1" selected="selected">보통</option>
													<option value="2">중요함</option>
													<option value="3">매우중요함</option>
											</select></td>
										</tr>
										<tr>
											<th>제 목</th>
											<td colspan="3"><input type="text" id="title" size="46"		maxlength="20px" name="title" /></td>
										</tr>
										<tr>
											<th>내 용</th>
											<td colspan="3"><textarea rows="5" id="content"
													name="content" cols="45" maxlength="100px"></textarea></td>
										</tr>
									</table>
									<br />
									<div align="center">
										<span>
											<input style="width: 100%;" type="button" class="btn-txt txt-regist" id="regScheduleBtn" name="regScheduleBtn" value="저장" size="10px" />
										</span>
									</div>
								</form>
								<input  style="width: 100%;" type="button" class="btn-txt txt-cancel" size="30px">
							</div>
							
							
							
							
							
							
							
							
							
							
							
							
							
							
							

						</section>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
