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
				
				
				
				
				
				

				// 현재의 달을 출력한다.

				for (var i = 1; i <= lastday; i++) {
					$("#date" + startnum).html(i);
					startnum++;
				}

				$("#month-name").html(y + "년 &nbsp;&nbsp;" + nMonth);
				
				  $('.test00 td').click(function() {
					            oneday=$(this).html();
					                        });
				

				// 다음을 선택할 경우 다음 달로 넘어간다.

				var month = [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월",
						"9월", "10월", "11월", "12월" ];

				$("#next-month").on("click", function() {
					 
					 // 페이지가 넘어갈 때 미리보기 페이지 정보를  없앤다.
					 $(".schedule-list").html( "");
					 // 페이지가 넘어 갈때 미리보기 페이지를 없앤다.
					 $('.test01').slideUp();
					 
					 
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

				
				// 이전 달 정보로 넘어가는 버튼
				$("#prev-month").on("click", function() {
					 
					 // 페이지가 넘어갈 때 미리보기 페이지 정보를  없앤다.
					 $(".schedule-list").html( "");
					 // 페이지가 넘어 갈때 미리보기 페이지를 없앤다.
					 $('.test01').slideUp();
					 
					 
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
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				

				$(document).ready(
						function() {
							
					var sizeArray = [ '60px', '180px', '300px', '420px', '540px',
										'660px', '780px' ]
					
					
								  $(".test00 td").on("click",function() {
									   
									   
									   
									   
											   $.get("/EduMIS/admin/listschedule", {year: y, month: nMonth, oneday: oneday}, function(data) {
													
												    	var dataArr = eval("(" + data + ")");	
												    	$(".schedule-list").html( "");
												     for(var i = 0; i < dataArr.length; i++){
												    		 $(".schedule-list").html( $(".schedule-list").html()+"<tr><td>" + dataArr[i].importance + "</td><td>"+ dataArr[i].title +"</td><td>"+  dataArr[i].content +"</td></tr>");
												    		 
												    		 
												    		 
												    	}
												    
													
												}).fail( function (){
													alert("에러발생")
												})
											   
											   
								    

								    
								    
											var index = $(this).index();
											
											
											if ($(this).hasClass('open')) {
												$('.test00 td').removeClass('open');
												$('.test01').slideUp();
												
												
//								        $('.test00 td').click(function() {
//				                  oneday=$(this).html();
//				                              });
								        
								        
								        

								        
								        
								        
												
											} 
											
											else if ($(this).siblings().hasClass('open')) {
												$('.test00 td').removeClass('open');
												$(this).addClass('open').parents(".test00")
														.next().slideDown().find('span').css(
																'left', sizeArray[index]);
												
												
												
//										    $('.test00 td').click(function() {
//				                  oneday=$(this).html();
//				                              });
										    
										    
										    
										    
										
												
												
										    
											} 
											
											
											else {
												$('.test00 td').removeClass('open');
												$('.test01').slideUp();
												$(this).addClass('open').parents(".test00")
														.next().slideDown().find('span').css(
																'left', sizeArray[index]);
												
//						            $('.test00 td').click(function() {
//				                  oneday=$(this).html();
//				                              });
												
											}
											

											
					
										});
						});
				
				
				
				
				
				

				

				
				
				
				
				
				
				
				
				
				
				

				// 월 정보를 불러낸다.

//				var sizeArray = [ '60px', '180px', '300px', '420px', '540px',
//						'660px', '780px' ]
//				$(".test00 td").on(
//						"click",
//						function() {
//						
//							
//							 
//							var index = $(this).index();
//							if ($(this).hasClass('open')) {
//								$('.test00 td').removeClass('open');
//								$('.test01').slideUp();
//							} else if ($(this).siblings().hasClass('open')) {
//								$('.test00 td').removeClass('open');
//								$(this).addClass('open').parents(".test00")
//										.next().slideDown().find('span').css(
//												'left', sizeArray[index]);
//							} else {
//								$('.test00 td').removeClass('open');
//								$('.test01').slideUp();
//								$(this).addClass('open').parents(".test00")
//										.next().slideDown().find('span').css(
//												'left', sizeArray[index]);
//							}
//						});
			});