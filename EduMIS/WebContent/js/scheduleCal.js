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
						 
						// 페이지가 넘어갈 때 미리보기 페이지 정보를  없앤다.
						 $(".schedule-list").html( "");
						 // 페이지가 넘어 갈때 미리보기 페이지를 없앤다.
						 $('.test01').slideUp();
						 
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
					firstdate = new Date(y, nMonth-1, 1);
					firstday = firstdate.getDay();
					startnum = eval(firstday + 1);
					lastdate = new Date(y, nMonth + 1, 0);
					lastday = lastdate.getDate();
					for (var i = 1; i <= 35; i++) {
						$("#date" + i).html("");

					}
					for (var i = 1; i <= lastday; i++) {

						// 페이지가 넘어갈 때 미리보기 페이지 정보를  없앤다.
						 $(".schedule-list").html( "");
						 // 페이지가 넘어 갈때 미리보기 페이지를 없앤다.
						 $('.test01').slideUp();
						 
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
								
									   
									   $(".schedule-list").html( "");
									   // __________________________________ 리스트 출력 ______________________________________________
											   $.get("/EduMIS/admin/listschedule.do", {year: y, month: nMonth, oneday: oneday}, function(data) {
												    	var dataArr = eval("(" + data + ")");	
												    	$(".schedule-list").html( "");
												    // 클릭과 동시에 DB의 값을 가져와서 <TR> 태그에 입력된다.
												     for(var i = 0; i < dataArr.length; i++){
													      
													      var im = dataArr[i].importance;
													      
													      switch(im){  
													      	case "1" :
									    					 
									    					 $(".schedule-list").html( $(".schedule-list").html()+"<tr style='color=green' id="+dataArr[i].no+" class='d'><td ><em style='color:green;'>● 보통</em></td><td><em style='color:green;'>"+ dataArr[i].title +"</em></td><td><em style='color:green;'>"+  dataArr[i].content +"</em></td></tr>");
									    					
									    					 break;
									    					 
													      	case "2" :
									    					 
									    					 $(".schedule-list").html( $(".schedule-list").html()+"<tr id="+dataArr[i].no+" class='d'><td><em style='color:orange;'>★ 중요</em></td><td><em style='color:orange;'>"+ dataArr[i].title +"</em></td><td><em style='color:orange;'>"+  dataArr[i].content +"</em></td></tr>");
									    					 
									    					 break;
									    					 
													      	case "3" :
													      		 
									    					 $(".schedule-list").html( $(".schedule-list").html()+"<tr id="+dataArr[i].no+" class='d'><td><em style='color:red;'>★ 매우중요</em></td><td><em style='color:red;'>"+ dataArr[i].title +"</em></td><td><em style='color:red;'>"+  dataArr[i].content +"</em></td></tr>");
									    					 
									    					 break;
									    					 
									    				}
												    		
												    		 
												    		 
												    		 
												    		 
												    		 
												    		 
												    		// 각각의 list의 <tr>클릭시 modify 창 발생
												    		 $(".schedule-list tr").click( function () {
												    			  
												    			$('.detail_form').attr("display","none");
												    			  
												    			  // id 값을 가지고 온다.
												    			  var searchNo = $(this).attr("id");
												    			  
												    			  
												    			  // jquery - Ajax  로  json 객체를 가지고 와서	 등록폼에  수정을 할 수 있도록 뿌려준다.
												    			  $.get("/EduMIS/admin/detailschedule.do", {no: searchNo}, function(data2) {
												    				   
												    				   var dataArr = eval("(" + data2 + ")");	
												    				   
												    				   $("input[name=m_startDate]").val(dataArr.startDate);
												    				   $("input[name=m_endDate]").val(dataArr.endDate);
												    				   $("input[name=m_title]").val(dataArr.title);
												    				   $("input[name=m_content]").val(dataArr.content);
												    				   $("input[name=m_place]").val(dataArr.place);
												    				   $("input[name=m_importance]").val(dataArr.importance);
												    				
												    				   
												    				   $('.modify_form').animate({ 'left' : '38%'   }, 1);
												    				   
												    				   
												    				   
												    				   
												    				 $('.cal_close').on('click', function() {
												    					   // 					  $('.plan_form').animate({'left':'20%'},1000);
												    					   $('.modify_form').animate({
												    						    'left' : '200%'
												    					   }, 1000);
												    					   // 					  $('.plan_form').animate(1000);

												    				  });
												    				   
												    				   
												    				   
												    			  }).fail( function (){
												    				   alert("에러발생");
												    			  });
												    			  
												    		 });
												    		 
												    		 
												    		 
												    		 
												    		
												    		 
												    		 
												    		 
												    		 // 각각의 list의 <tr>에 커서를 올려 놓을시 detail 창 발생
												    		 $(".schedule-list tr").mouseenter( function () {

												    			  
												    			  // id 값을 가지고 온다.
												    			  var searchNo = $(this).attr("id");
												    			  
												    			
												    			  // jquery - Ajax  로  json 객체를 가지고 와서 detail에 뿌려준다.
												    			  $.get("/EduMIS/admin/detailschedule.do", {no: searchNo}, function(data1) {
												    				   
												    				var dataArr = eval("(" + data1 + ")");	
												    				
												    				
												    				
												    				
												    				
												    				var i = dataArr.importance;
												    				
												    				switch(i){
												    				case "1" :
												    					 
												    					 $('#d_importance').css("color","green");
												    					 $('#d_importance').text("● 보통");
												    					 $(".detail-name").html(y + "년&nbsp;" + nMonth+"월&nbsp;" + oneday +"일&nbsp; 일정").css("color","green");
												    					 $('#d_startDate').text(dataArr.startDate).css("color","green");
												    					 $('#d_content').text(dataArr.content).css("color","green");
												    					 $('#d_place').text(dataArr.place).css("color","green");
												    					 $('#d_endDate').text(dataArr.endDate).css("color","green");
												    					 $('#d_title').text(dataArr.title).css("color","green");
												    					 
												    					 
												    					 
												    					
												    					 
												    					 
												    					 
												    					 
												    					 
												    					 
												    					 
												    					 
												    					 
												    					 break;
												    					 
												    				case "2" :
												    					 
												    					 $(".detail-name").html(y + "년&nbsp;" + nMonth+"월&nbsp;" + oneday +"일&nbsp; 일정").css("color","orange");
												    					 $('#d_startDate').text(dataArr.startDate).css("color","orange");
												    					 $('#d_content').text(dataArr.content).css("color","orange");
												    					 $('#d_place').text(dataArr.place).css("color","orange");
												    					 $('#d_endDate').text(dataArr.endDate).css("color","orange");
												    					 $('#d_title').text(dataArr.title).css("color","orange");
												    					 $('#d_importance').css("color","orange");
												    					 $('#d_importance').text("★ 중요");
												    					 
												    					 break;
												    					 
												    				case "3" :
												    					 $(".detail-name").html(y + "년&nbsp;" + nMonth+"월&nbsp;" + oneday +"일&nbsp; 일정").css("color","red");
												    					 $('#d_startDate').text(dataArr.startDate).css("color","red");
												    					 $('#d_content').text(dataArr.content).css("color","red");
												    					 $('#d_place').text(dataArr.place).css("color","red");
												    					 $('#d_endDate').text(dataArr.endDate).css("color","red");
												    					 $('#d_title').text(dataArr.title).css("color","red");
												    					$('#d_importance').css("color","red");
												    					 $('#d_importance').text("★ 매우중요");
												    					 
												    					 
												    					 break;
												    					 
												    				}
												    				
												    				
												    				
												    				
												    				
												    				$('.detail_form').stop().animate({ 'left' : '38%'   }, 1);
												    				 
												    				
												    				
												    				
												    				
												    				var container2 = document.getElementById('map2');
											    	                                             var options = {
											    	                                                center : new daum.maps.LatLng(dataArr.latitude,
											    	                                                    dataArr.longitude),
											    	                                                level : 3
											    	                                             };
											    	                                             var map2 = new daum.maps.Map(container2, options);
											    	                                             displayMarker(latitude2, longitude2);
											    	                                             function displayMarker(latitude2, longitude2) {
											    	                                                var marker = new daum.maps.Marker({
											    	                                                   map : map2,
											    	                                                   position : new daum.maps.LatLng(latitude2,
											    	                                                         longitude2)
											    	                                                });
											    	                                             }
												    				   
											    	                                             
											    	                                             
											    	                                             
											    	                                             
											    	                                             
											    	                                             
											    	                                             
											    	                                             
											    	                                             
												 			}).fail( function (){
												 				alert("에러발생");
												 			});
												    			  
												    		 }).mouseleave( function () {
												    			  
												    			 $('.detail_form').animate({
																    'left' : '200%'
															   }, 100);
														});	  
												    		 
												    		 
												    		 
												    		 
												    		 
												    		 
												    		 
												    		 
												    		
												    	}
												}).fail( function (){
													alert("에러발생")
												})
									//__________________________________________________________________________________________________
											var index = $(this).index();
											
											
											if ($(this).hasClass('open')) {
												$('.test00 td').removeClass('open');
												$('.test01').slideUp();
											} 
											
											else if ($(this).siblings().hasClass('open')) {
												$('.test00 td').removeClass('open');
												$(this).addClass('open').parents(".test00")
														.next().slideUp.find('span').css(
																'left', sizeArray[index]);
											} 
											else {
												$('.test00 td').removeClass('open');
												$('.test01').slideUp();
												$(this).addClass('open').parents(".test00")
														.next().slideDown().find('span').css(
																'left', sizeArray[index]);
											}
										});
					
					
					
					
					
					
					
					
					
					
					
					
					
					// 등록후 등록된글 바로 보여주기 
					//	__________________________________________________________________________________________________
					 
						
						$("#regScheduleBtn").click(function () {
					    var formData = $("#regscheduleForm").serialize();
					    
					    $.ajax({
					      type : "GET",
					      url : "/EduMIS/admin/regschedule",
					      cache : false,
					      data : formData,
					      success : onSuccess,
					      error : onError
					    });
					    
					    $('.plan_form').animate({
					      'left' : '200%'
					    }, 1000);
					    
					  });
						
						
						
					  function onSuccess(json, status) {
					    alert("스케줄 등록 완료"); 
					    $(".schedule-list").html( "");
	                $.get("/EduMIS/admin/listschedule.do", {year: y, month: nMonth, oneday: oneday}, function(data) {
	                     var dataArr = eval("(" + data + ")"); 
	                     $(".schedule-list").html( "");
	                     
	                    for(var i = 0; i < dataArr.length; i++){
				      
	                    	  var im = dataArr[i].importance;
				      
				      switch(im){  
				      	case "1" :
					 
					 $(".schedule-list").html( $(".schedule-list").html()+"<tr style='color=green' id="+dataArr[i].no+" class='d'><td ><em style='color:green;'>● 보통</em></td><td><em style='color:green;'>"+ dataArr[i].title +"</em></td><td><em style='color:green;'>"+  dataArr[i].content +"</em></td></tr>");
					
					 break;
					 
				      	case "2" :
					 
					 $(".schedule-list").html( $(".schedule-list").html()+"<tr id="+dataArr[i].no+" class='d'><td><em style='color:orange;'>★ 중요</em></td><td><em style='color:orange;'>"+ dataArr[i].title +"</em></td><td><em style='color:orange;'>"+  dataArr[i].content +"</em></td></tr>");
					 
					 break;
					 
				      	case "3" :
				      		 
					 $(".schedule-list").html( $(".schedule-list").html()+"<tr id="+dataArr[i].no+" class='d'><td><em style='color:red;'>★ 매우중요</em></td><td><em style='color:red;'>"+ dataArr[i].title +"</em></td><td><em style='color:red;'>"+  dataArr[i].content +"</em></td></tr>");
					 
					 break;
					 
				
					 
				}
	                        
	                        // 각각의 list의 <tr>에 커서를 올려 놓을시 detail 창 발생
	                        $(".schedule-list tr").mouseenter( function () {

	                           
	                           // id 값을 가지고 온다.
	                           var searchNo = $(this).attr("id");
	                           
	                         
	                           // jquery - Ajax  로  json 객체를 가지고 와서 detail에 뿌려준다.
	                           $.get("/EduMIS/admin/detailschedule.do", {no: searchNo}, function(data1) {
	                              
	                           var dataArr = eval("(" + data1 + ")");  
	                           
	                           var i = dataArr.importance;
 				
 				switch(i){
 				case "1" :
 					 
 					 $('#d_importance').css("color","green");
 					 $('#d_importance').text("● 보통");
 					 $(".detail-name").html(y + "년&nbsp;" + nMonth+"월&nbsp;" + oneday +"일&nbsp; 일정").css("color","green");
 					 $('#d_startDate').text(dataArr.startDate).css("color","green");
 					 $('#d_content').text(dataArr.content).css("color","green");
 					 $('#d_place').text(dataArr.place).css("color","green");
 					 $('#d_endDate').text(dataArr.endDate).css("color","green");
 					 $('#d_title').text(dataArr.title).css("color","green");
 					 
 					 
 					 
 					 
 					 
 					 break;
 					 
 				case "2" :
 					 
 					 $(".detail-name").html(y + "년&nbsp;" + nMonth+"월&nbsp;" + oneday +"일&nbsp; 일정").css("color","orange");
 					 $('#d_startDate').text(dataArr.startDate).css("color","orange");
 					 $('#d_content').text(dataArr.content).css("color","orange");
 					 $('#d_place').text(dataArr.place).css("color","orange");
 					 $('#d_endDate').text(dataArr.endDate).css("color","orange");
 					 $('#d_title').text(dataArr.title).css("color","orange");
 					 $('#d_importance').css("color","orange");
 					 $('#d_importance').text("★ 중요");
 					 
 					 break;
 					 
 				case "3" :
 					 $(".detail-name").html(y + "년&nbsp;" + nMonth+"월&nbsp;" + oneday +"일&nbsp; 일정").css("color","red");
 					 $('#d_startDate').text(dataArr.startDate).css("color","red");
 					 $('#d_content').text(dataArr.content).css("color","red");
 					 $('#d_place').text(dataArr.place).css("color","red");
 					 $('#d_endDate').text(dataArr.endDate).css("color","red");
 					 $('#d_title').text(dataArr.title).css("color","red");
 					$('#d_importance').css("color","red");
 					 $('#d_importance').text("★ 매우중요");
 					 
 					 
 					 break;
 					 
 				}
 				
 				
 				
 				
 				
 				$('.detail_form').stop().animate({ 'left' : '38%'   }, 1);
 				 
 				
 				
 				
 				
 				var container2 = document.getElementById('map2');
	                                             var options = {
	                                                center : new daum.maps.LatLng(dataArr.latitude,
	                                                    dataArr.longitude),
	                                                level : 3
	                                             };
	                                             var map2 = new daum.maps.Map(container2, options);
	                                             displayMarker(latitude2, longitude2);
	                                             function displayMarker(latitude2, longitude2) {
	                                                var marker = new daum.maps.Marker({
	                                                   map : map2,
	                                                   position : new daum.maps.LatLng(latitude2,
	                                                         longitude2)
	                                                });
	                                             }
	                         
	                              
	                     }).fail( function (){
	                       alert("에러발생");
	                     });
	                           
	                        }).mouseleave( function () {
	                           
	                          $('.detail_form').animate({
	                           'left' : '200%'
	                        }, 100);
	                   });   
	                        
	                        // 각각의 list의 <tr>클릭시 modify 창 발생
	                        $(".schedule-list tr").click( function () {
	                           
	                         $('.detail_form').attr("display","none");
	                           
	                           // id 값을 가지고 온다.
	                           var searchNo = $(this).attr("id");
	                           
	                           
	                           // jquery - Ajax  로  json 객체를 가지고 와서   등록폼에  수정을 할 수 있도록 뿌려준다.
	                           $.get("/EduMIS/admin/detailschedule.do", {no: searchNo}, function(data2) {
	                              
	                              var dataArr = eval("(" + data2 + ")"); 
	                              
	                              $("input[name=m_startDate]").val(dataArr.startDate);
	                              $("input[name=m_endDate]").val(dataArr.endDate);
	                              $("input[name=m_title]").val(dataArr.title);
	                              $("input[id=m_content]").val(dataArr.content);
	                              $("input[name=m_place]").val(dataArr.place);
	                              $("input[name=m_importance]").val(dataArr.importance);
	                           
	                              
	                              $('.modify_form').animate({ 'left' : '38%'   }, 1);
	                              
	                              
	                              
	                            $('.cal_close').on('click', function() {
	                                //             $('.plan_form').animate({'left':'20%'},1000);
	                                $('.modify_form').animate({
	                                   'left' : '200%'
	                                }, 1000);
	                                //             $('.plan_form').animate(1000);

	                             });
	                              
	                              
	                              
	                           }).fail( function (){
	                              alert("에러발생");
	                           });
	                           
	                        });
	                        
	                       
	                     }
	               }).fail( function (){
	                 alert("에러발생")
	               })
	         //__________________________________________________________________________________________________
	             var index = $(this).index();
					          
  }
					  
					  
					  function onError(data, status){alert("에러 입니다");}
					  
							});
			
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
					
				
				  // 수정, 수정후 수정된글 바로 보여주기 
				        //  __________________________________________________________________________________________________
				         
				        
				        $("#modScheduleBtn").click(function () {
				//          var searchNo = $(this).attr("id");
				//          var no = searchNo 
				          var formData = $("#modscheduleForm").serialize();
				          $.ajax({
				            type : "GET",
				            url : "/EduMIS/admin/modschedule",
				            cache : false,
				            data : formData,
				            success : onSuccess,
				            error : onError
				          });
				          
				          $('.plan_form').animate({
				            'left' : '200%'
				          }, 1000);
				          
				        });
				        
				        
				        

				        
				        function onSuccess(json, status) {
				          alert("수정 완료"); 
				          $(".schedule-list").html( "");
				              $.get("/EduMIS/admin/listschedule.do", {year: y, month: nMonth, oneday: oneday}, function(data) {
				                   var dataArr = eval("(" + data + ")"); 
				                   $(".schedule-list").html( "");
				                   
				                  for(var i = 0; i < dataArr.length; i++){


				          	         
				          	         var im = dataArr[i].importance;
							      
							      switch(im){  
							      	case "1" :
								 
								 $(".schedule-list").html( $(".schedule-list").html()+"<tr style='color=green' id="+dataArr[i].no+" class='d'><td ><em style='color:green;'>● 보통</em></td><td><em style='color:green;'>"+ dataArr[i].title +"</em></td><td><em style='color:green;'>"+  dataArr[i].content +"</em></td></tr>");
								
								 break;
								 
							      	case "2" :
								 
								 $(".schedule-list").html( $(".schedule-list").html()+"<tr id="+dataArr[i].no+" class='d'><td><em style='color:orange;'>★ 중요</em></td><td><em style='color:orange;'>"+ dataArr[i].title +"</em></td><td><em style='color:orange;'>"+  dataArr[i].content +"</em></td></tr>");
								 
								 break;
								 
							      	case "3" :
							      		 
								 $(".schedule-list").html( $(".schedule-list").html()+"<tr id="+dataArr[i].no+" class='d'><td><em style='color:red;'>★ 매우중요</em></td><td><em style='color:red;'>"+ dataArr[i].title +"</em></td><td><em style='color:red;'>"+  dataArr[i].content +"</em></td></tr>");
								 
								 break;
								 
							
								 
							}
				          	         
				          	         
				          	         
				          	         
				                      // 각각의 list의 <tr>에 커서를 올려 놓을시 detail 창 발생
				                      $(".schedule-list tr").mouseenter( function () {

				                         
				                         // id 값을 가지고 온다.
				                         var searchNo = $(this).attr("id");
				                         
				                       
				                         // jquery - Ajax  로  json 객체를 가지고 와서 detail에 뿌려준다.
				                         $.get("/EduMIS/admin/detailschedule.do", {no: searchNo}, function(data1) {
				                            
				                         var dataArr = eval("(" + data1 + ")");  
				                         
				                         
				                         var i = dataArr.importance;
			    				
			    				switch(i){
			    				case "1" :
			    					 
			    					 $('#d_importance').css("color","green");
			    					 $('#d_importance').text("● 보통");
			    					 $(".detail-name").html(y + "년&nbsp;" + nMonth+"월&nbsp;" + oneday +"일&nbsp; 일정").css("color","green");
			    					 $('#d_startDate').text(dataArr.startDate).css("color","green");
			    					 $('#d_content').text(dataArr.content).css("color","green");
			    					 $('#d_place').text(dataArr.place).css("color","green");
			    					 $('#d_endDate').text(dataArr.endDate).css("color","green");
			    					 $('#d_title').text(dataArr.title).css("color","green");
			    					 
			    					 
			    					 
			    					 break;
			    					 
			    				case "2" :
			    					 
			    					 $(".detail-name").html(y + "년&nbsp;" + nMonth+"월&nbsp;" + oneday +"일&nbsp; 일정").css("color","orange");
			    					 $('#d_startDate').text(dataArr.startDate).css("color","orange");
			    					 $('#d_content').text(dataArr.content).css("color","orange");
			    					 $('#d_place').text(dataArr.place).css("color","orange");
			    					 $('#d_endDate').text(dataArr.endDate).css("color","orange");
			    					 $('#d_title').text(dataArr.title).css("color","orange");
			    					 $('#d_importance').css("color","orange");
			    					 $('#d_importance').text("★ 중요");
			    					 
			    					 break;
			    					 
			    				case "3" :
			    					 $(".detail-name").html(y + "년&nbsp;" + nMonth+"월&nbsp;" + oneday +"일&nbsp; 일정").css("color","red");
			    					 $('#d_startDate').text(dataArr.startDate).css("color","red");
			    					 $('#d_content').text(dataArr.content).css("color","red");
			    					 $('#d_place').text(dataArr.place).css("color","red");
			    					 $('#d_endDate').text(dataArr.endDate).css("color","red");
			    					 $('#d_title').text(dataArr.title).css("color","red");
			    					$('#d_importance').css("color","red");
			    					 $('#d_importance').text("★ 매우중요");
			    					 
			    					 
			    					 break;
			    					 
			    				}
			    				
			    				
			    				
			    				
			    				
			    				$('.detail_form').stop().animate({ 'left' : '38%'   }, 1);
			    				 
			    				
			    				
			    				
			    				
			    				var container2 = document.getElementById('map2');
		    	                                             var options = {
		    	                                                center : new daum.maps.LatLng(dataArr.latitude,
		    	                                                    dataArr.longitude),
		    	                                                level : 3
		    	                                             };
		    	                                             var map2 = new daum.maps.Map(container2, options);
		    	                                             displayMarker(latitude2, longitude2);
		    	                                             function displayMarker(latitude2, longitude2) {
		    	                                                var marker = new daum.maps.Marker({
		    	                                                   map : map2,
		    	                                                   position : new daum.maps.LatLng(latitude2,
		    	                                                         longitude2)
		    	                                                });
		    	                                             }
				                            
				                   }).fail( function (){
				                     alert("에러발생");
				                   });
				                         
				                      }).mouseleave( function () {
				                         
				                        $('.detail_form').animate({
				                         'left' : '200%'
				                      }, 100);
				                 });   
				                      
				                      // 각각의 list의 <tr>클릭시 modify 창 발생
				                      $(".schedule-list tr").click( function () {
				                         
				                       $('.detail_form').attr("display","none");
				                         
				                         // id 값을 가지고 온다.
				                         var searchNo = $(this).attr("id");
				                         
				                         
				                         // jquery - Ajax  로  json 객체를 가지고 와서   등록폼에  수정을 할 수 있도록 뿌려준다.
				                         $.get("/EduMIS/admin/detailschedule.do", {no: searchNo}, function(data2) {
				                            
				                            var dataArr = eval("(" + data2 + ")"); 
				                            
				                            $("input[name=m_startDate]").val(dataArr.startDate);
				                            $("input[name=m_endDate]").val(dataArr.endDate);
				                            $("input[name=m_title]").val(dataArr.title);
				                            $("input[id=m_content]").val(dataArr.content);
				                            $("input[name=m_place]").val(dataArr.place);
				                            $("input[name=m_importance]").val(dataArr.importance);
				                            $('.modify_form').animate({ 'left' : '38%'   }, 1);
				                          $('.cal_close').on('click', function() {
				                              //             $('.plan_form').animate({'left':'20%'},1000);
				                              $('.modify_form').animate({
				                                 'left' : '200%'
				                              }, 1000);
				                              //             $('.plan_form').animate(1000);

				                           });
				                         }).fail( function (){




				                            alert("에러발생");
				                         });
				                         
				                      });
				                   }
				             }).fail( function (){
				               alert("에러발생")
				             })
				           var index = $(this).index();
				          }
				        function onError(data, status){alert("에러 입니다");}			
				
				
				
				

				

				
				
				
				
				
				
				
				
				
				
				

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