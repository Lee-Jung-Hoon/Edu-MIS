<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title>강의영상 게시판</title>
<link href="/EduMIS/css/reset.css" rel="stylesheet" type="text/css" />
<link href="/EduMIS/css/style.css" rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script>
  function moveList() {
    location.href = "${pageContext.request.contextPath}/user/lectureList.do";
  }

  var list = function() {
    var list = eval(str);
    $("#id").empty();
    $("#comment").empty();
    $.each(list, function(index, value) {
      $("#id").append(list[index].id);
      $("#comment").append(list[index].comments);
    });
  };

  $(document).ready(function() {
    $("#insertComment").click(function() {
      $.get("/EduMIS/user/LecCommentController", {
        //     id : "${user.id}",
        no : "${lecture.no}",
        id : "test",
        comments : $("#comments").val()
      }).fail(function() {
        alert("에러 발생");
      });

      $.get("/EduMIS/user/LecCommentList", {
        no : "${lecture.no}"
      }, list);

    });

    $("#deleteComment").click(function() {
      $.get("/EduMIS/user/LecCommentDelete", {
        no : $(this).val()
      })

      $.get("/EduMIS/user/LecCommentList", {
        no : "${lecture.no}"
      }, list);

    });
  });
</script>
</head>
<body class="page-vod btn-page">
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
							<img src="/EduMIS/images/message.png" alt="" /> <span
								class="count">1<!-- 메시지 개수 --></span>

						</button>
						<div class="message-layer">
							<button type="button" class="btn-message-close">닫기</button>
							<div class="message-frame">
								<!-- 메시지 작업 시작영역 -->
								<!--  메시지 작업 시작영역 끝 -->
								<a href="#" class="btn-send">
									<div class="circle">
										<div class="envelope-top"></div>
										<div class="envelope"></div>
									</div>
								</a>
							</div>
						</div>
					</div>
					<!-- 메시지 들어가는 부분 끝 -->
					<ul>
						<li><a href="#"><img src="/EduMIS/images/icon-user.png"
								alt="" />마이페이지</a></li>
						<li class="login"><a href="#">로그인</a>
							<div class="login-form">
								<form action="" method="">
									<input type="text" placeholder="아이디" /> <input type="password"
										placeholder="비밀번호" /> <span><input type="checkbox"
										id="save" /><label for="save">아이디 저장하기</label></span> <input
										type="submit" class="btn-submit" />
								</form>
								<button type="button" class="btn-close">닫기</button>
							</div></li>
						<li><a href="#">회원가입</a></li>
					</ul>
				</header>
				<div class="container-inner">
					<div class="content">
						<section class="join common">
							<div class="table-common vod">
								<form action="" method="">
									<table>
										<colgroup>
											<col style="width: 15%;" />
											<col style="width: 85%;" />
										</colgroup>
										<tbody>
											<tr>
												<th>${lecture.no}강</th>
												<td>${lecture.title}</td>
											</tr>

											<tr>
												<td colspan="2">
													<div class="vod-wrap-frame">
														<div class="vod-left-frame">
															<iframe width="500" height="281"
																src="https://www.youtube.com/embed/gBqFVEGN2xo?list=PL68HocmNHe998_R-5H7V_oz5Awdh2KZ1l"
																frameborder="0" allowfullscreen></iframe>
														</div>
														<br />
														<div class="vod-intro">
															<ul>
																<c:forEach var="lecComment" items="${lecComment }">
																	<li>${lecComment.id}&nbsp;&nbsp;:&nbsp;&nbsp;${lecComment.comments}
																		<button class="btn btn-txt txt-del btn-blue btn-del"
																			type="button" id="deleteComment"
																			value="${lecComment.comno}">삭제</button>
																	</li>
																</c:forEach>
															</ul>
															<div class="reply-regist-area">
																<input type="text" placeholder="댓글등록" name="comments"
																	id="comments" /> <input type="button"
																	class="btn btn-txt txt-regist-s btn-blue btn-regist"
																	value="등록" id="insertComment" />
															</div>
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<th>강의 내용</th>
												<td>
													<div class="vod-content">
														<p>${lecture.contents}</p>
													</div>
												</td>
											</tr>
										</tbody>
									</table>
									<div style="text-align: right; margin-top: 10px;">
										<a
											href="${pageContext.request.contextPath}/user/lectureSelect.do?no=${lecture.no}"
											style="display: inline-block; width: 80px; height: 40px;"
											class="btn btn-txt txt-edit btn-blue">수정</a> <a
											href="${pageContext.request.contextPath}/user/lectureSelect.do?no=${lecture.no}"
											style="display: inline-block; width: 80px; height: 40px;"
											class="btn btn-txt txt-del btn-blue">삭제</a>
									</div>
									<div class="btn-area">
										<a
											href="${pageContext.request.contextPath}/user/lectureList.do"
											class="btn txt-list-lecture btn-txt btn-blue">강의목록</a>
									</div>
								</form>
							</div>
						</section>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="/EduMIS/js/common.js"></script>
</html>
