<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>  
  <meta charset="utf-8">
  <title>교육생 배치도</title>
  <%@ include file="/jsp/admin/include/common.jsp" %>	 
	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>	
  <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <script src="/EduMIS/js-plugins/imageCapture/html2canvas.js"></script>
  
    <script>
	function capture() { 
		html2canvas($(".seat"), {
			onrendered: function(canvas) { 
				var img = canvas.toDataURL("image/png");
				console.log(img); 
				$("#target2").html('<img src=' + img + '>');
			}
		}); 
	} 
	</script>
  
  <style>
	  * { margin: 0px; padding: 0px; }
	  html, body {}
	  .student h1, .seat h1 { font-size: 25px; }
	  .student .info {background:#fff;}
	  .student ul {font-size: 1.2em; }
	  
	  ul { list-style: none; }
	  h1 { padding: .2em; margin: 0; }
	  .info {width:100%; height:102px; border: 1px solid #000; box-sizing:border-box; overflow-y:auto;}
	  .info ul { width: 100%; height: 100px; overflow: auto; }
	  .info ul li { list-style: none; float: left; margin: 5px; padding: 5px; }
	  .seat {background:#fff;}	
	  .content {width:100%; box-sizing:border-box; padding:30px;}
	  .seat {width:100%; overflow:hidden; border: 1px solid #000; margin-top: 20px; }
	  .both-side {width:50%; box-sizing:border-box;}
	  .both-side ul {
	  		display: -webkit-box;
		  -webkit-box-orient: horizontal;
		  -webkit-box-align: stretch;
		  -webkit-box-pack: left;
	  }
	  .both-side ul li {
	  	  box-flex: 1;
		  -webkit-box-flex: 1;
		  border: 1px solid #999;
		  height:80px;
	      text-align: center;
	      line-height: 80px;
	      font-size: 1.2em;
	      font-weight:bold;
	  }
	  .left-side {float:left;}
	  .right-side {float:right;}
	  .inner-div {width:80%; margin:0 auto 20px; height:80px;}
	  .inner-div li {position:relative; margin-left:-1px; background:url('/EduMIS/images/wood-pattern.jpg') repeat-x left top;}
	  .inner-div .dropSpan {position:absolute; top:50%; left:0; display:block; width:100%; height:100%; text-align:center; margin-top:-40px;}
	  .content-seat .btn-save {display:inline-block !important; width:100px; height:40px; vertical-align:top;}
	  .content-seat h2 {text-indent:20px; font-size:24px; font-weight:bold; letter-spacing:-1px;}
	  .content-seat .student h2 {display:inline-block; height:40px; margin-right:10px; line-height:35px; margin-bottom:20px;}
	  .content-seat .seat {line-height:50px; padding-bottom:10px;}
	  .seat-info {padding-left:20px; height:80px; line-height:80px;}
	  .seat-info select, .seat-info input[type="number"] {height:30px;}
	  .seat-info input[type="number"] {box-sizing:border-box;}
	  .seat-info .btn-line {display:inline-block !important; width:70px; height:30px;}
  </style>
  <script>
  $(function() {
    dragEvent();
    function dragEvent() {
      $('.student_info').on({
        dragstart: function (event) {
  		console.log(event.target.id);    	  
        	event.originalEvent.dataTransfer.setData("dragId", event.target.id);
        }
      });

      $( ".seat ul li" ).on({
      	"dragover": function (event) {
  	    	event.preventDefault();
          },
          "drop": function (event) {
      		var dragId = event.originalEvent.dataTransfer.getData("dragId");
  				console.log("drop : " + dragId);
  					$(this).html("<span class='dropSpan'>"+$("#" + dragId).text()+"</span>")
          	//$(this).text($("#" + dragId).text());
          	$("#" + dragId).remove();
  		}
      }); 
    }
   
    
    $("#seatBtn").click(function () {
    		var direction = $("#seat_loc").val();
    		var count = $("#cNum").val();
    		var target = "";
    		if (direction == "L") {
    		  target = $(".left-side"); 
    		} else {
    		  target = $(".right-side");
    		}
    		target.append("<div class='inner-div'><ul></ul></div>");
    		addTable(target);
    		function addTable(target) {
    		  for(var i=0; i<count; i++) 
    		  {
    		  	target.find(".inner-div").last().find("ul").append("<li></li>");  
    		  }
    		}
    		dragEvent();

   	});
    
  });
  
  </script>
</head>
<body class="page-seat btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<%@ include file="/jsp/admin/include/leftMenu.jsp" %>
			<div class="container">
				<%@ include file="/jsp/admin/include/topMenu.jsp" %>
				<div class="container-inner">
					<div class="content content-seat">
						<div class="student">
						  <h2>교육생 명단</h2>
						  <input type="button" onclick="capture();" value="저장" class="btn btn-txt txt-save-b btn-blue btn-save" />
						  <div class="info">
						    <ul>
						      <li class="student_info" id="e1" draggable="true">빈자리</li>
						      <li class="student_info" id="s1" draggable="true">홍길동1</li>
						      <li class="student_info" id="s2" draggable="true">홍길동2</li>
						      <li class="student_info" id="s3" draggable="true">홍길동3</li>
						      <li class="student_info" id="s4" draggable="true">홍길동4</li>
						      <li class="student_info" id="s5" draggable="true">홍길동5</li>
						      <li class="student_info" id="s6" draggable="true">홍길동2</li>
						      <li class="student_info" id="s7" draggable="true">홍길동3</li>
						      <li class="student_info" id="s8" draggable="true">홍길동4</li>
						      <li class="student_info" id="s9" draggable="true">홍길동5</li>
						      <li class="student_info" id="s10" draggable="true">홍길동2</li>
						      <li class="student_info" id="s11" draggable="true">홍길동3</li>
						      <li class="student_info" id="s12" draggable="true">홍길동4</li>
						      <li class="student_info" id="s13" draggable="true">홍길동5</li>
						      <li class="student_info" id="s14" draggable="true">홍길동2</li>
						      <li class="student_info" id="s15" draggable="true">홍길동3</li>
						      <li class="student_info" id="s16" draggable="true">홍길동4</li>
						      <li class="student_info" id="s17" draggable="true">홍길동5</li>
						      <li class="student_info" id="s18" draggable="true">홍길동2</li>
						      <li class="student_info" id="s19" draggable="true">홍길동3</li>
						      <li class="student_info" id="s20" draggable="true">홍길동4</li>
						      <li class="student_info" id="s21" draggable="true">홍길동5</li>
						      <li class="student_info" id="s22" draggable="true">홍길동2</li>
						      <li class="student_info" id="s23" draggable="true">홍길동3</li>
						      <li class="student_info" id="s24" draggable="true">홍길동4</li>
						      <li class="student_info" id="s25" draggable="true">홍길동5</li>
						    </ul>
						  </div>
						</div>
						<div class="seat">
						  <h2>자리배치</h2>
						  <div class="seat-info">
						  	위치 : <select id="seat_loc">
						  		<option value="R">오른쪽</option>
						  		<option value="L">왼쪽</option>
						  	</select>
						  	칸 : <input type="number" id="cNum" min="1" max="5" value="4" />
						  	<input type="button" id="seatBtn" value="줄추가" class="btn btn-txt btn-blue txt-line-s btn-line" />
						  </div>
						  <div class="both-side left-side">
							 <div class="inner-div">
							  <ul>
							  	<li></li>
							  	<li></li>
							  	<li></li>
							  	<li></li>
							  </ul>
							  </div>
							  <div class="inner-div">
							  <ul>
							  	<li></li>
							  	<li></li>
							  	<li></li>
							  	<li></li>
							  	<li></li>
							  </ul>
							 </div>
						  </div>
						  <div class="both-side right-side">
							<div class="inner-div">
							  <ul>
							  	<li></li>
							  	<li></li>
							  	<li></li>
							  	<li></li>
							  </ul>
							</div>
							<div class="inner-div">
							  <ul>
							  	<li></li>
							  	<li></li>
							  </ul>
							</div>
						  </div>
						</div>
					</div>
					<div id="target2"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>