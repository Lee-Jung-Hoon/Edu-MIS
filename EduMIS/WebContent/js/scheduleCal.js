// 날짜 객체를 얻어온다.
	var date = new Date();
	var y = date.getFullYear();
	var m = date.getMonth();
	var firstdate = new Date(y, m, 1);
	var firstday = firstdate.getDay();
	var startnum = eval(firstday + 1);
	var lastdate = new Date(y, m + 1, 0);
	var lastday = lastdate.getDate();
	// 전달
	var nMonth = m + 1;
	

					function responseMsg() {
						if(httpRequest.readyState == 4){
							if (httpRequest.status == 200) {
								var memList = eval(httpRequest.responseText);
								 var calMain = document.getElementById("cal-main");
								 calMain.innerHTML = "";
						            calMain.innerHTML = httpRequest.responseText;
								}
								
							}
						}

	$(document).ready(
			function() {
				
				
				
				
				// 일정등록 누를시 화면 변경
			
				
				
				$(".test00 td").click(function(){
					
					var tdId = $(this).attr("id");
					var dateVal =document.getElementById(tdId).textContent;
					if(nMonth < 10 ){
						var nMonth1 = "0"+nMonth;
					}else{
						var nMonth1 = nMonth;
						
					}
					if(dateVal < 10){
						var dateVal1 = "0"+dateVal;
					}else{
						var dateVal1 = dateVal;
						
					}
					var datepickerMsg = nMonth1 +"/"+ dateVal1 +"/"+y;
					$("#datepicker").val(datepickerMsg);
					var datepickerMsg = nMonth1 +"/"+ dateVal1 +"/"+y;
					$("#datepicker2").val(datepickerMsg);
				})
				
				
				
				
				
				

				

				for (var i = 1; i <= lastday; i++) {
					$("#date" + startnum).html(i);
					startnum++;
				}

				$("#month-name").html(y + "년 &nbsp;&nbsp;" + nMonth);

				// 다음을 선택할 경우 다음 달로 넘어간다.

				var month = [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월",
						"9월", "10월", "11월", "12월" ];

				$("#next-month").on("click", function() {

					firstdate = new Date(y, nMonth, 1);
					firstday = firstdate.getDay();
					startnum = eval(firstday + 1);

					++nMonth;
					lastdate = new Date(y, nMonth, 0);
					lastday = lastdate.getDate();

					for (var i = 1; i <= 35; i++) {
						$("#date" + i).html("");
					}

					for (var i = 1; i <= lastday; i++) {
						$("#date" + startnum).html(i);
						startnum++;
					}

					// 월 정보를 중앙에 보여준다.
					if (nMonth > 12) {
						y += 1;
						nMonth = 1;
					}

					$("#month-name").html(y + "년 &nbsp;&nbsp;" + nMonth);

				});

				$("#prev-month").on("click", function() {
					nMonth--;
					firstdate = new Date(y, nMonth, 1);
					firstday = firstdate.getDay();
					startnum = eval(firstday + 1);
					lastdate = new Date(y, nMonth + 1, 0);
					lastday = lastdate.getDate();
					for (var i = 1; i <= 35; i++) {
						$("#date" + i).html("");

					}
					for (var i = 1; i <= lastday; i++) {

						$("#date" + startnum).html(i);
						startnum++;
					}

					if (nMonth < 1) {
						y -= 1;
						nMonth = 12;
					}

					$("#month-name").html(y + "년 &nbsp;&nbsp;" + nMonth);
					// 					$("#month-name").html(y);
					
				});

				// 월 정보를 불러낸다.

				var sizeArray = [ '60px', '180px', '300px', '420px', '540px',
						'660px', '780px' ]
				$(".test00 td").on(
						"click",
						function() {
						
							
							 
							var index = $(this).index();
							if ($(this).hasClass('open')) {
								$('.test00 td').removeClass('open');
								$('.test01').slideUp();
							} else if ($(this).siblings().hasClass('open')) {
								$('.test00 td').removeClass('open');
								$(this).addClass('open').parents(".test00")
										.next().slideDown().find('span').css(
												'left', sizeArray[index]);
							} else {
								$('.test00 td').removeClass('open');
								$('.test01').slideUp();
								$(this).addClass('open').parents(".test00")
										.next().slideDown().find('span').css(
												'left', sizeArray[index]);
							}
						});
			});