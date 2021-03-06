<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title>출석</title>

<%@ include file="/WEB-INF/view/admin/include/common.jsp" %>	
<link href="/EduMIS/css/layout.css" rel="stylesheet">
<link href="/EduMIS/css/common.css" rel="stylesheet">
<link href="/EduMIS/css/attstyle.css" rel="stylesheet">
<script src="/EduMIS/jsp/admin/attendance/httprequest.js"></script>
<script type="text/javascript" charset="utf-8"
	src="/EduMIS/js/jquery.leanModal.min.js"></script>
	
<script>
	var id = "";
	var date;
	var param = "";
	var today = new Date();
	var gAttList = null;
	$(document).ready(function () {
		idDate('kCalendar');

	});
	
// Change the selector if needed
	var $table = $('table.scroll'),
	    $bodyCells = $table.find('tbody tr:first').children(),
	    colWidth;

	// Adjust the width of thead cells when window resizes
	$(window).resize(function() {
	    // Get the tbody columns width array
	    colWidth = $bodyCells.map(function() {
	        return $(this).width();
	    }).get();
	    
	    // Set the width of thead columns
	    $table.find('thead tr').children().each(function(i, v) {
	        $(v).width(colWidth[i]);
	    });    
	}).resize(); // Trigger resize handler
	
	
	
	$(function() {
		$('#modaltrigger').leanModal({
			top : 110,
			overlay : 0.8,
			closeButton : ".hidemodal"
		});
	});
  
  function regAttend() {
		sendRequest("/EduMIS/attendance/memListController.do", null, memberList, "GET");
  }
	
  var today = new Date();
	function memberList() {
	  var tr = "";
	  var todayDate = null;
    var tableList = document.createElement("table");
    $("#list").attr("class","scroll");
		
	  if (httpRequest.readyState == 4) {
		  if (httpRequest.status == 200) {
		      var cnt = 0;
		      var attDate;
			    var memList = eval(httpRequest.responseText);

		      for(var i = 0; i < gAttList.length; i++){
		  			var type = null;
		  			var attArr = gAttList[i].attInfo;
		  			var m = memList[i];

		  			for (var key in attArr) {
		  				attDate = attArr[key].split(":")[1].split("-");
		  					
		  				if((Number(attDate[0]) == today.getFullYear()) && 
		  				    (Number(attDate[1]) == today.getMonth() + 1) && 
		  				    (Number(attDate[2]) == today.getDate()) && Number(m.grade) != 1){
		  				  	console.log(gAttList[i].mName+" : "+cnt);
		  						cnt++;
		  				}
		  			}
		  			
		  		}
		      todayDate = today.getFullYear()+"-"+"0"+(today.getMonth()+1)+"-"+today.getDate();
					var chk = document.getElementById("chk");
			    var listDIV = document.getElementById("memberList");
			    var todayDIV = document.getElementById("today");
			    todayDIV.innerHTML = today.getFullYear() + "년 " + (today.getMonth() + 1) + "월 " + today.getDate() + "일";
		      
			    var tableList = document.getElementById("list");
			    chk.innerHTML = "";

// 			    tableList.innerHTML = "";
					
					var mode=0;
			    if(cnt == gAttList.length - 1){
			      chk.innerHTML = "<form class='test' action='/EduMIS/attendance/AttUpdate.do'></form>";
			    	mode=1;
			    }
			    else{
				    chk.innerHTML = "<form class='test' action='/EduMIS/attendance/AttRegist.do'></form>";
				    
			    }
			    tbody = document.createElement("tbody");
			    tableList.innerHTML = "";
			    
			    for(var i=0; i < memList.length; i++) {
			      var mem = memList[i];
			      console.log(mem.grade+" -- "+mem.no+" -- "+mem.mName);
			      if(Number(mem.grade) == 1){
			        alert("관리자");
			        continue;
			      }
			   		tr = document.createElement("tr");
			      tr.innerHTML = "<td align = 'center'><span><input type = 'text' id = '" + mem.no  +  "' name = '" + mem.mName + "' value = '" + mem.mName + "' readonly = 'readonly' style = 'display: inline-block;'/><input type='hidden' value='"+todayDate+"' name='attDate' >" + 
			       "<select id = '" + mem.no + "' name = '" + mem.no + "'><option>출석</option><option>지각</option><option>조퇴</option><option>결석</option></select><input type = 'hidden' id = '" + mem.no  +  "' name = 'no_" + mem.no + "' value = '" + mem.no + "' readonly = 'readonly' /></td>";
			      tbody.appendChild(tr);
			      tableList.appendChild(tbody);
			    }
// 			    $('.test').insertBefore("<div align='center'>"+today.getFullYear() + "년 " + (today.getMonth() + 1) + "월 " + today.getDate() + "일</div>");
			    $('.test').append(tableList);
			    if(mode == 1){
			   	  $('.test').append("<div align='center'><input type='submit' value='수정' /></div>");
			    }
			    else{
			      $('.test').append("<div align='center'><input type='submit' value='등록' /></div>");
			    }
			   }
		  }
	  }
	
	
	function idDate(id2, calDate){
		if( typeof( date ) !== 'undefined' ) {
			calDate = calDate.split('-');
			calDate[1] = calDate[1] - 1;
			calDate = new Date(calDate[0], calDate[1], calDate[2]);
			date = calDate;
			id = id2;
			sendRequest("/EduMIS/attendance/memAttList.do", null, kCalendar, "GET");
		} else {
			calDate = new Date();
			date = calDate;
			id = id2;
			sendRequest("/EduMIS/attendance/memAttList.do", null, kCalendar, "GET");

		}
	}
	function kCalendar() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				var kCalendar = document.getElementById(id);
 				var attList = eval(httpRequest.responseText);
 				gAttList = eval(httpRequest.responseText);
				var calendar = '';
				
				var currentYear = date.getFullYear();
				//년도를 구함
				
				var currentMonth = date.getMonth() + 1;
				//연을 구함. 월은 0부터 시작하므로 +1, 12월은 11을 출력
				
				var currentDate = date.getDate();
				//오늘 일자.
				
				date.setDate(1);
				var currentDay = date.getDay();
				//이번달 1일의 요일은 출력. 0은 일요일 6은 토요일
				
				var dateString = new Array('sun', 'mon', 'tue', 'wed', 'thu', 'fri', 'sat');
				var dateUTF = new Array('일', '월', '화', '수', '목', '금', '토');
				var lastDate = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
				if( (currentYear % 4 === 0 && currentYear % 100 !== 0) || currentYear % 400 === 0 )
					lastDate[1] = 29;
				//각 달의 마지막 일을 계산, 윤년의 경우 년도가 4의 배수이고 100의 배수가 아닐 때 혹은 400의 배수일 때 2월달이 29일 임.
				
				var currentLastDate = lastDate[currentMonth-1];
				var week = Math.ceil( ( currentDay + currentLastDate ) / 7 );
				//총 몇 주인지 구함.
				
				
				//이전달 버튼 누를때
				if(currentMonth != 1){
					var prevDate = currentYear + '-' + ( currentMonth - 1 ) + '-' + currentDate;
				}
					//만약 이번달이 1월이라면 1년 전 12월로 출력.
				else{
					var prevDate = ( currentYear - 1 ) + '-' + 12 + '-' + currentDate;
				}
				
				if(currentMonth != 12) {
					//다음달 버튼 누를떄
					var nextDate = currentYear + '-' + ( currentMonth + 1 ) + '-' + currentDate;
				}
				else{
					var nextDate = ( currentYear + 1 ) + '-' + 1 + '-' + currentDate;
				//만약 이번달이 12월이라면 1년 후 1월로 출력.
					
				}
		
				if( currentMonth < 10 )
					var currentMonth = '0' + currentMonth;
				//10월 이하라면 앞에 0을 붙여준다.
				
				calendar += '<div id="header">';
				calendar += '			<span><a href="#" class="button left" onclick="idDate(\'' +  id + '\', \'' + prevDate + '\')"><</a></span>';
				calendar += '			<span id="date">' + currentYear + '년 ' + currentMonth + '월</span>';
				calendar += '			<span><a href="#" class="button right" onclick="idDate(\'' + id + '\', \'' + nextDate + '\')">></a></span>';
				calendar += '		</div>';
		//		calendar += '			<thead>';
		//		calendar += '				<tr>';
		//		calendar += '				  <th class="sun" scope="row">일</th>';
		//		calendar += '				  <th class="mon" scope="row">월</th>';
		//		calendar += '				  <th class="tue" scope="row">화</th>';
		//		calendar += '				  <th class="wed" scope="row">수</th>';
		//		calendar += '				  <th class="thu" scope="row">목</th>';
		//		calendar += '				  <th class="fri" scope="row">금</th>';
		//		calendar += '				  <th class="sat" scope="row">토</th>';
		//		calendar += '				</tr>';
		//		calendar += '			</thead>';
				calendar += '		<table class="attend" border="1" cellspacing="0" cellpadding="0">';
				calendar += '			<caption>' + currentYear + '년 ' + currentMonth + '월 달력</caption>';
				calendar += '			<tbody>';
				
				var dateNum = 1 - currentDay;
				
				calendar += '			<tr>';
				calendar += '			<td rowspan="2" class="tbName">이름</td>';
				// 여기에 이름 뿌려줌....
				for(var i = 0; i < week; i++) {
					for(var j = 0; j < 7; j++, dateNum++) {
						if( dateNum < 1 || dateNum > currentLastDate ) {
							calendar += '				<td class="' + dateString[j] + ' test"> </td>';
							continue;
						}
						// 월에 해당하는 일자를 뿌려줌...
						calendar += '				<td class="' + dateString[j] + '">' + dateNum + '</td>';
					}
				}
				calendar += '			</tr>';
				
				// 요일을 써주기 위해 재선언 
				dateNum = 1 - currentDay;
				
				calendar += '			<tr >';
				for(var i = 0; i < week; i++) {
					for(var j = 0; j < 7; j++, dateNum++) {
						if( dateNum < 1 || dateNum > currentLastDate ) {
							calendar += '				<td class="' + dateString[j] + ' test"> </td>';
							continue;
						}
						calendar += '				<td class="' + dateString[j] + '">' + dateUTF[j] + '</td>';
					}
				}
				calendar += '			</tr>';
				
				// 이름 뿌려주는 곳
				for(var i = 0; i < attList.length; i++){
					calendar += '			<tr>';
					console.log(attList[i].grade + "---"+ attList[i].mName);
					if(Number(attList[i].grade) == 1){
					  continue;
					}
					else{
						calendar += '<td>'+attList[i].mName+'</td>';
					}
					/* att_type의 1: 출석  2: 지각   3: 조퇴   4: 결석   */
					// 출석 사항 뿌려주는 곳
					// 여기에 월, 일, 마지막 일수까지 얻어온다음 for문 돌면서 attType
					for(var j = 0; j < currentLastDate; j++){
					  var type = null;
					  var attArr = attList[i].attInfo;
					  
					  for (var key in attArr) {
							var attDate = attArr[key].split(":")[1].split("-");
							
							if((Number(attDate[0]) == currentYear) && (Number(attDate[1]) == currentMonth) && (Number(attDate[2]) == j+1)){
								type = attArr[key].split(":")[0]; 
								break;
							}
					  }
						
						switch(type){
						case '1': calendar += '<td>O</td>';
								break;
							
						case '2': calendar += '<td>◎</td>';
								break;
							
						case '3': calendar += '<td>▲</td>';
								break;
							
						case '4': calendar += '<td>X</td>';
								break;
						default :
							  calendar += '<td>-</td>'; 
								break;						  
						}
					}
				}
				calendar += '			</tr>';
				
				calendar += '			</tbody>';
				calendar += '		</table>';
				calendar += '		<span class="attType">* 화면상태 표시 설명 => 출석:[○] 지각:[◎] 조퇴:[▲] 결석:[×] </span>';
				kCalendar.innerHTML = calendar;
			}
		}
	}

</script>
</head>
<body class="page-join">
	<div class="wrap">
		<div class="wrap-inner">
		<%@ include file="/WEB-INF/view/admin/include/leftMenu.jsp" %>
			<div class="container">
				<%@ include file="/WEB-INF/view/admin/include/topMenu.jsp" %>
				
				<div class="container-inner">
					<div class="content">
						<!--  test-class 부분을  s-aaa 형식의 이름으로 클래스 잡아주세요  common 클래스 이름은 지우지 마세요 -->
						<section class="test-class common">
							<!--  작업부분 제목 써주세요 -->
							<h2>출석부</h2>
<!-- 							<input type="button" value="출석등록" id="modaltrigger" onclick="regAttend()" /> -->
							<!-- 작업시작부분 div안에 클래스명 넣어서 작업 해 주세요 나머지 url부분은 추후 취합할 예정이니 일단 MENU 부분의 링크태그에 값 넣어서 작업 해주시면 됩니다. 게시판 담당하시는 분들은 추후 공통 클래스 드릴테니 일단 테이블로 작업 부탁드립니다. -->
							 <a href="#loginmodal" style="display:inline-block; text-indent:-5000px; width:80px; height:40px;" class="btn txt-attan-regist-s btn-txt btn-blue" onclick="regAttend()" id="modaltrigger">출석등록</a>
							<div id="kCalendar"></div>
							<!--  작업완료 부분 -->
						</section>
					</div>
				</div>
			</div>
		</div>
	</div>
	
		<!-- 출석 등록을 위한 div -->
	<div id="loginmodal" style="display: none;" >
	
		<h2 align="center">출석등록</h2>
		<!-- 등록 주소 재설정 -->
		<div id = "today" align="center" ></div>
		<div id="chk">

			<br />
			<div align="center" ></div>
			<div id="memberList"></div>
			
			<br/>
			<table id = "list">
			</table>
			<br/>
		</div>
	</div>
</body>
</html>
