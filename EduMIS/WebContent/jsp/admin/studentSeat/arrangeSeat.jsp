<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>  
  <meta charset="utf-8">
  <title>교육생 배치도</title>
  <%@ include file="/jsp/admin/include/common.jsp" %>	 
  <link href="http://fonts.googleapis.com/earlyaccess/jejuhallasan.css" rel="stylesheet" type="text/css" />	
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
	  html, body { height: 85%; }
	  .student h1, .seat h1 { font-size: 25px; }
	  .student ul { font-size: 1.2em; }
	  
	  ul { list-style: none; }
	  h1 { padding: .2em; margin: 0; }
	  .info ul { width: 100%; height: 100px; border: 1px solid red; overflow: auto; }
	  .info ul li { list-style: none; float: left; margin: 5px; padding: 5px; }	
	  .leftSeat ul, .rightSeat ul {
		  display: -webkit-box;
		  -webkit-box-orient: horizontal;
		  -webkit-box-align: stretch;
		  -webkit-box-pack: left;
	  }
	  .leftSeat ul > li, .rightSeat ul > li {
	  	  box-flex: 1;
		  -webkit-box-flex: 1;
	  }
	  
	  .content {width:100%; box-sizing:border-box; padding:30px;}
	  .seat {width:100%; overflow:hidden; border: 1px solid tomato; margin-top: 20px; }
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
		  border: 1px solid blue;
		  height:80px;
	      text-align: center;
	      line-height: 80px;
	      font-size: 1.2em;
	  }
	  .left-side {float:left; padding-right:15px;}
	  .right-side {float:right; padding-left:15px;}
	  .inner-div {width:80%; margin: 10px auto; height:80px;
  </style>
  <script>
  
  $(function() {
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
        	$(this).text($("#" + dragId).text());
        	$("#" + dragId).remove();
		}
    }); 
    /*
    $("#seatBtn").click(function () {
    	var html = "";
    	
    	html += '<div class="inner-div">';
    	html += '  <ul>';
    	html += ' 	 <li></li>';
		  	<li></li>
		  	<li></li>
		  	<li></li>
		  </ul>
		  </div>    	
   	});
    */
  });
  
  </script>
</head>
<body>
<div class="content">
	<div class="student">
	  <h1>교육생 명단 <input type="button" onclick="capture();" value="저장" /></h1>
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
	  <h1>자리배치</h1>
	  <div>
	  	위치 : <select id="seat_loc">
	  		<option value="R">오른쪽</option>
	  		<option value="L">왼쪽</option>
	  	</select>
	  	칸 : <input type="number" id="cNum" min="1" max="5" value="4" />
	  	<input type="button" id="seatBtn" value="줄추가" />
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
</body>
</html>