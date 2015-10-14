<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width">
	<title>조장 추천 게시판</title>
	<%@ include file="/WEB-INF/view/user/include/common.jsp" %>	
	<script>
	function voteChk(){
	  if($("input[name='id']:checked").length==0)
	    {
	    	alert("투표할 수강생을 선택해주세요");
	   		return false;
	    }
	  return true;
	};
	
	</script>
</head>
<body class="page-main btn-page">
	<div class="wrap">
	<div class="wrap-inner">

		<%@ include file="/WEB-INF/view/user/include/leftMenu.jsp" %>
			<div class="container">
					<%@ include file="/WEB-INF/view/user/include/topMenu.jsp" %>
			
						<section class="leader common">

							<h2>조장 추천 게시판</h2>
							<form action="/AdvanceEduMIS/user/voteInsert.do" name="voteForm" method="POST" onsubmit="return voteChk()">
								<div class="leader-frame">
									<ul>
									<c:forEach var="vote" items="${list}">
									
										<li>
									
										 <div class="img"><img src="/AdvanceEduMIS/memberFile/${vote.realFileName}" alt="" /></div>
									
											<div class="radio">
												<input type="radio" name="id" id="${vote.id}" value="${vote.id}"/>
												<label for="${vote.id}"><span class="id">${vote.id}&nbsp;${vote.name}</span><span class="name"></span></label>
											</div>
										</li>
										</c:forEach>
									</ul>
									<div class="btn-area">
										<span class="width50"><input type="submit" class="btn txt-vote btn-txt btn-blue" value="투표하기" /></span>
										<span class="width50"><a href="${pageContext.request.contextPath}/user/voteResult.do" class="btn txt-result btn-txt btn-blue">결과보기</a></span>
									</div>
								</div>
							</form>
						</section>				
					</div>
				</div>
			</div>
</body>

</html>
