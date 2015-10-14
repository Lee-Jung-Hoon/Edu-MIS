<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title>수강생 관리</title>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	<%@ include file="/WEB-INF/view/user/include/common.jsp" %>	
<style>
table.scroll {
	/* width: 100%; */ /* Optional */
	/* border-collapse: collapse; */
	border-spacing: 0;
	/*     border: 2px solid black; */
}

table.scroll tbody, table.scroll thead {
	display: block;
}

thead tr th {
	height: 30px;
	line-height: 30px;
	/* text-align: left; */
	border-bottom: 2px solid black;
}

table.scroll tbody {
	height: 100px;
	overflow-y: auto;
	overflow-x: hidden;
}

tbody {
	/* 	 border-top: 2px solid black;  */
	width: 500px;
}

tbody td, thead th {
	width: 80px;
	height: 15px;
	/* width: 20%; */ /* Optional */
	/* 	    border-right: 1px solid black; */
	/* white-space: nowrap; */
}

tbody td:last-child, thead th:last-child {
	border-right: none;
}
</style>
<script>
	function popUp(id){
			window.open("http://localhost:8000/AdvanceEduMIS/admin/commentSelect.do?id=" + id, // 팝업창에 띄울 페이지 주소
			"수강생 정보", // 팝업창에 이름 설정
			"width=600, height=500, resizable=no");
		
		}
	
	//Change the selector if needed
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
	
$(document).ready(function () {
	  
	  $("input[type='button']").on("click", function () {
				 if ($(this).val() == '등록') {
			   if(confirm("등록하시겠습니까?")){
					var id = this.id;
					var content = $("#" + id).val();
										
	         $.ajax({
	           url:"/EduMIS/comment/RegistComment.do",
	           type:"POST",
	           datatype:"json",
	           data:{id:id, content:content},
	           success: function onSuccess(data, status) {
	           var jsondata = eval('(' + data +  ')');
	             $("#" + id + "com").prepend(
		 	              "<tr id = "+ jsondata.no + "com>" + 
		 	              "<td style=' width:82px;'>" + jsondata.regDate + "</td>" + 
		 								"<td style=' width:400px;'>" + jsondata.content + "</td>" + 
		 								"<td><input type = 'button' value = '삭제' id = " + jsondata.no + " style=\"display:block; width:20px; height:20px; background:url(\'../images/btn-close.png\') no-repeat center; background-size:100%; overflow:hidden; z-index:99; text-indent:-5000px;\"></td>" + 
		 								"</tr>"
						 )
						 $("#" + id).val("");
						 
	           }
	         })
			   }
			 }
    })
	})
	
	$(document).on("click", "input[type='button']", function() {
	  if($(this).val() == '삭제') {
	     if(confirm("삭제하시겠습니까?")){
	       var no = this.id;
			    $.get(
			      "/EduMIS/comment/delete.do",
			      {no:no},
			      function(data){
				      $("#" + no + "com").remove();
		  	    })
		  	  }
	     }
	  })

					


	</script>


</head>
<body class="page-join btn-page">
	<div class="wrap">
		<div class="wrap-inner">
		
			<%@ include file="/WEB-INF/view/user/include/leftMenu.jsp" %>

			<div class="container">

				<%@ include file="/WEB-INF/view/user/include/topMenu.jsp" %>
				

				<div class="container-inner">
					<div class="content">
						<section class="join common">
							<h2>수강생 관리</h2>
							<div class="student-info">

								<ul>
									<li><c:forEach var="student" items="${list}">
											<form action="/AdvanceEduMIS/admin/commentInsert.do" method="post">

												<div class="all-frame">
													<div class="img-frame" style="margin-right: 20px;">
														<span class="img"><img
															src="/AdvanceEduMIS/images/icon-user.png" alt="" /></span> <a
															href="javascript:popUp('${student.id}');"
															style="text-decoration: none;">${student.name}</a>
													</div>

													<div>
														<input type="text" style="height: 30px; width: 500px;"
															name="content" id="${student.id}" size="100" />
														<input type="button"
															id = "${student.id}"
															style="width: 80px; height: 30px; float: right;"
															class="btn btn-txt txt-regist-s btn-blue" value="등록" />
														<br />
													</div>
													<div>


														<br />

														<div>
															<table class="scroll">
																<thead>
																	<tr>
																		<th style="width: 80px;">날짜</th>
																		<th style="width: 400px;">내용</th>
																	</tr>
																</thead>
																<tbody id="${student.id}com">
																	<c:forEach var="clist" items="${clist}">
																		<c:if test="${student.id eq clist.id}">
																			<tr id="${clist.no}com">
																				<td style="width: 82px;">${clist.reg_date}</td>
																				<td style="width: 400px;">${clist.content}</td>
																				<td><input type="button" value="삭제"
																					id="${clist.no}"
																					style="display: block; width: 20px; height: 20px; background: url('../images/btn-close.png') no-repeat center; background-size: 100%; overflow: hidden; z-index: 99; text-indent: -5000px;" /></td>
																			</tr>
																		</c:if>
																	</c:forEach>
																</tbody>
															</table>
														</div>
													</div>
												</div>
											</form>
										</c:forEach></li>

								</ul>
							</div>
						</section>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript" src="/AdvanceEduMIS/js/common.js"></script>

</html>
