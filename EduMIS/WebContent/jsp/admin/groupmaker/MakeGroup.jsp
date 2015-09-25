<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>인연나비</title>
	<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
		<%@ include file="/jsp/admin/include/common.jsp" %>	
<style>

#selectNumber>div {
	position: relative;
}

#selectNumber>div::before {
	content: "";
	display: block;
	position: absolute;
	bottom: -32px;
	left: -1px;
	width: 146px;
	height: 30px;
	border: 1px solid #000;
}

#selectSub>div {
	position: relative;
}

#selectSub>div::before {
	content: "";
	display: block;
	position: absolute;
	bottom: -32px;
	left: -1px;
	width: 146px;
	height: 30px;
	border: 1px solid #000;
}

.droppable {
	width: 130px;
	height: 130px;
	padding: 0.5em;
	float: left;
	margin: 10px 10px 50px 0;
	border: 1px solid black;
}

.droppable-ui-droppable {
	width: 120px;
	height: 130px;
	padding: 0.5em;
	float: left;
	margin: 10px 10px 10px 0;
	border: 1px solid black;
}

.draggable {
  animation-name: example;
    animation-duration: 4s;
    animation-iteration-count: 3;
	width: 100px;
	height: 100px;
	padding: 0.5em;
	float: left;
	margin: 0;
	position: inherit;
	text-align: center;
	padding-left: 15px;
	font-weight: bold;
}

.draggable img {
	margin-bottom: 1px;
}

.div_clear {
	clear: both;
}

#mybody {

padding-bottom: 500px;

}
</style>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

<script>
  var httpRequest;
  var gNum = 0; //전체조의 갯수를 저장할 변수
  var sLeader = new Array(); //선택된 조장들을 저장해놓을 배열
  var selectedParam = ""; //조장 선택창에 selected를 시킬지 안시킬지 결정할 변수
  var memberLoading = 1;
  var value = " ";
  var dropValue = 0;

  window.onload = function() {
    memberLoading = 100;
    httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = responseSelect;
    httpRequest.open("GET", "/EduMIS/makegroups/ajax", true);
    httpRequest.send(null);
  };

  function dropStart() {

    $('#memberlist>div').draggable({
      revert : "invalid"
    });

    $('#drag>div>div').droppable(
        {
          drop : function(event, ui) {
            // 		 alert(ui.draggable.find("input").val());
            $(this).find("select").val(ui.draggable.find("input").val());

            var leng = $(this).find("select").attr("id").substring(10);
            dropValue = 1;
            DropMember($(this).find("select").attr("id").substring(10),
                ui.draggable.find("input").val());
            //             alert(ui.draggable.find("input").val());
            //             ui.draggable.css('top', 100);
          }
        });
    refreshValue();
    var send = 0;
    var httpParams ="";
    if (memberLoading != 100 && memberLoading != 0) {
      for (var i = 1; i <= gNum; i++) {
				httpParams += 'leader'+i+'='+sLeader[i];
				httpParams += "&";
        if (sLeader[i] == "선택하세요") {
          send = 1;

          break;
        } else {

        }

      }
      httpParams += 'gNum='+gNum;
    
      if (send == 0) {
        if (confirm("준비가 끝났습니다. 조짜기를 시작하시겠습니까?")) {
//           alert(httpParams);
          
          location.href="/EduMIS/makegroups/make.do?"+httpParams+"&method=post";
          

        }

      }

    }
  }
  
  function refreshValue() {
    for (var i = 1; i <= gNum; i++) {
      if (i <= (gNum / 2)) {
        sLeader[i] = document.getElementById("techleader" + i).value;
      } else {

        sLeader[i] = document.getElementById("subbleader" + i).value
      }
    }
    
  }
  

  function DropMember(num, val) {
    memberLoading = 2;
    httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = responseSelect;
    httpRequest.open("GET", "/EduMIS/makegroups/ajax", true);
    httpRequest.send(null);
    refreshValue();

    for (var i = 1; i <= gNum; i++) {
      if (i == num) {
        sLeader[i] = val;
      } else if (sLeader[i] == val && num != i) {

        sLeader[i] = "";
      }
    }
    
    autoMove(num);

  }

  function responseSelect() {
    if (httpRequest.readyState == 4) {
      if (httpRequest.status == 200) {
        value = eval(httpRequest.responseText);
        var selnum = document.getElementById("selectNumber");
        var selsub = document.getElementById("selectSub");
        selnum.innerHTML = "";
        selsub.innerHTML = "";
        if (memberLoading == 100 || memberLoading == 0) {
          var list = document.getElementById("memberlist");
          list.innerHTML = "";
          for (var i = 0; i < value.length; i++) {

            list.innerHTML += "<div style='display: block;' id='draggable"
                + (i + 1)
                + "' class ='draggable'><p></p><br/><input type='hidden' id ='member"
                + (i + 1) + "' value='" + value[i].no + "'>"
                + '<img src ="/EduMIS/jsp/admin/groupmaker/images/pic1.jpg" width="90px" height="90px">'
                + value[i].name + '</div>';
          }
        }
        setTimeout(setName(value, selnum, selsub), 700);
//         setName(value, selnum, selsub);

      }
    }

  }
  
 

  function selectNumber(val) {
    dropValue = 0;
    memberLoading = val;
    switch (val) {
    case 0:

      break;
    case 100:
      sLeader = new Array();
      break;
    default:
      for (var i = 1; i <= gNum; i++) {

        if (i <= (gNum / 2)) {
          sLeader[i] = document.getElementById("techleader" + i).value;
        } else {

          sLeader[i] = document.getElementById("subbleader" + i).value
        }

      }
      autoMove(val);

      break;
    }
    httpRequest = new XMLHttpRequest();
    httpRequest.onreadystatechange = responseSelect;
    httpRequest.open("GET", "/EduMIS/makegroups/ajax", true);
    httpRequest.send(null);

    // 	switch(val){
    // 	case 1:

    // 		num = document.getElementById("groupNumber").value;
    // 		groupSelect();
    // 		break;
    // 	case 2:
    // 		break;

    // 	}

  }

  function autoMove(val) {
    
    var moveBox;

    if (val <= (gNum / 2)) {
      moveBox = $("#techleader" + val);
    } else {

      moveBox = $("#subbleader" + val);
    }
    var pic = sLeader[val];
    for (var j = 1; j <= value.length; j++) {

      var moveMember = document.getElementById("member" + j);
      if (moveMember.value === pic) {
        var moveDrag = $("#draggable" + j);
        console.log("top : "  +moveBox.offset().top);
        console.log("left : "  +moveBox.offset().left);
        console.log("top : "  +moveDrag.offset().top);
        console.log("left : "  +moveDrag.offset().left);
        var top = moveBox.offset().top;
        top -= moveDrag.offset().top;
        var left = moveBox.offset().left;
        left -= moveDrag.offset().left;
        var offset = moveDrag.offset();
        
//        moveDrag.animate({ "top" : top , "left" : left } ,2000 );
  		if(dropValue ==0){
       moveDrag.animate({ "top" : top,"left" : left  } ,500 );
       moveDrag.offset(offset);
  		  
  		}else {
        moveDrag.offset(moveBox.offset());
  		  
  		  
  		}      
       
//        moveDrag.animate({ "top" : "-=300" , "left" : "-=300" } ,2000 );
       console.log("top : "  +moveBox.offset().top);
       console.log("left : "  +moveBox.offset().left);
       console.log("top : "  +top);
       console.log("left : "  +left);
     

       
        break;
      }
    }

  }

  function setName(value, selnum, selsub) {
    gNum = document.getElementById("groupNumber").value * 2;
    for (var index = 1; index <= gNum; index++) {
      if (index <= (gNum / 2)) {
        selnum.innerHTML += "<div id='droppable"+index+"' style='display: block;' class='droppable'> 기술조장"
            + index
            + ": <select id ='techleader"
            + index
            + "' onchange='selectNumber(" + index + ")'><option>선택하세요</option>";
      } else {
        var number = index - (gNum / 2);
        selsub.innerHTML += "<div id='droppable"+index+"' style='display: block;' class='droppable'> 부조장"
            + number
            + ": <select id ='subbleader"
            + index
            + "' onchange='selectNumber(" + index + ")'><option>선택하세요</option>";
      }

      for (var i = 0; i < value.length; i++) {
        selectedParam = "";
        var sw = true;
        for (var k = 1; k <= gNum; k++) {
          var selectID = sLeader[k];
          if (k == index && value[i].no == selectID) {
            selectedParam = 'selected="selected"';
            break;
          } else if (selectID == value[i].no) {
            sw = false;
            break;
          }
        }

        if (sw == true) {
          if (index <= (gNum / 2)) {
            document.getElementById("techleader" + index).innerHTML += "<option value='"+value[i].no+"'"+selectedParam+">"
                + value[i].name + "</option>";
          } else {

            document.getElementById("subbleader" + index).innerHTML += "<option value='"+value[i].no+"'"+selectedParam+">"
                + value[i].name + "</option>";

          }
        }
      }
      if (index <= (gNum / 2)) {
        selnum.innerHTML += "</select></div>";

      } else {
        selsub.innerHTML += "</select></div>";

      }
    }

    dropStart();

  }
</script>
	

</head>
<body class="page-main btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<%@ include file="/jsp/admin/include/leftMenu.jsp" %>	
					
			<div class="container">
				<%@ include file="/jsp/admin/include/topMenu.jsp" %>

				<div class="container-inner">
					<div class="content">
					<section class="groups common">
							<div id ="mybody">
							<h2>조짜기- 어떤 인연이..?</h2>
							전체 몇개의 조가 필요하신가요?
	<select id="groupNumber" onchange="selectNumber(0)" style="height:30px; margin:0 10px;">
		<option>선택하세요</option>
		<c:forEach begin="2" end="10" var="i">
			<option>${i}</option>
		</c:forEach>
	</select>개  
	<input type="button" value="조장초기화" style="display:inline-block; width:100px; height:40px; margin-left:10px;" class="btn txt-leader-reset-s btn-txt btn-blue" onclick="selectNumber(100)" />
	<br />
	<div id="drag">
		<div id="selectNumber" style="width: 100%; padding-bottom: 50px;"></div>

		<br /> <br /> <br /> <br /> <br /> <br /> <br /> <br /> <br />

		<hr style="width: 100%; clear: both;" />
		<div id="selectSub" style="width: 100%; clear: both;"></div>
	</div>
	<br />


	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<hr/ style="clear: both;">



	<div id="memberlist" style="display: block; clear: both;">
		<div id="draggable" style="display: block;">
			<input type="hidden" value="1"> <img src="/EduMIS/jsp/admin/groupmaker/images/pic1.jpg"
				width="90px" height="90px">
			<p align="justify">손예진</p>
		</div>
	</div>
							
							</div>
							</section>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
