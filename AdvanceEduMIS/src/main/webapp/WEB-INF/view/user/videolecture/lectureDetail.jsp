<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title>영상</title>
<%@ include file="/WEB-INF/view/user/include/common.jsp"%>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script>
  function moveList() {
    location.href = "lectureList.do";
  }

  function list(str) {
    var commentList = eval(str);
    $("#cList").empty();
    $
        .each(
            commentList,
            function(index, value) {
              $("#cList")
                  .html(
                      $("#cList").html()
                          + "<li>"
                          + commentList[index].id
                          + "&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;"
                          + commentList[index].comments
                          + "<button class='btn btn-txt txt-del btn-blue btn-del deleteComment' type='button'" 
	               + "name='comno' value='"+commentList[index].comno+"'>"
                          + "</button></li>");
            });
  };

  $(document).ready(function() {
    $("#insertComment").click(function() {

      if ($("#comments").val() == "") {
        alert("댓글을 입력해주세요")
        $("#comments").focus();
        return false;
      }

      $.get("lecCommentRegist.do", {
        //     id : "${user.id}",
        no : "${lecture.no}",
        id : "test",
        comments : $("#comments").val()
      });

      $.get("lecCommentList.do", {
        no : "${lecture.no}"
      }, function(data) {
        list(data);
      });

      $('#comments').val("");
    });

    $("#cList").on("click", ".deleteComment", function() {
      $.get("lecCommentDelete.do", {
        comno : $(this).val()
      });

      $.get("lecCommentList.do", {
        no : "${lecture.no}"
      }, function(data) {
        list(data);
      });

    });
  });
</script>
</head>
<body class="page-vod btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<%@ include file="/WEB-INF/view/user/include/leftMenu.jsp"%>
			<div class="container">
				<%@ include file="/WEB-INF/view/user/include/topMenu.jsp"%>
				<div class="container-inner">
					<div class="content">
						<section class="join common">
							<h2>${lecture.no}강&nbsp;&nbsp;${lecture.title}</h2>
							<div class="table-common vod">
								<form>
									<input type="hidden" name="no" value="${lecture.no}" /> <input
										type="hidden" name="id" value="test" />
									<%-- 								<input type="hidden" name="id" value="${user.id}"/> --%>
									<table>
										<colgroup>
											<col style="width: 15%;" />
											<col style="width: 85%;" />
										</colgroup>
										<tbody>
											<tr>
												<td colspan="2" class="vod-frame-td">
													<div class="vod-wrap-frame">
														<div class="vod-left-frame">
															<iframe width="660" height="371"
																src="${lecture.video}?list=PL68HocmNHe998_R-5H7V_oz5Awdh2KZ1l"
																frameborder="0" allowfullscreen></iframe>
															<div class="vod-content">
																<p>&nbsp;&nbsp;${lecture.contents}</p>
															</div>
														</div>
														<div class="vod-intro" id="test">
															<ul id="cList" style="height: 373px; overflow-y: auto;"
																id="test2">
																<c:forEach var="lecComment" items="${lecComment}">
																	<li>${lecComment.id}&nbsp;&nbsp;:&nbsp;&nbsp;${lecComment.comments}
																		<button
																			class="btn btn-txt txt-del btn-blue btn-del deleteComment"
																			type="button" name="comno"
																			value="${lecComment.comno}">삭제</button>
																	</li>
																</c:forEach>
															</ul>
															<div class="reply-regist-area" id="test1">
																<input type="text" placeholder="댓글등록" name="comments"
																	id="comments" /> <input type="button"
																	class="btn btn-txt txt-regist-s btn-blue btn-regist"
																	value="등록" id="insertComment" />
															</div>
														</div>
													</div>
												</td>
											</tr>
										</tbody>
									</table>
									<%-- 									<c:if test="${user.id eq 'admin'}"> --%>
									<div style="text-align: right; margin-top: 10px;">
										<a
											href="${pageContext.request.contextPath}/user/lectureSelect.do?no=${lecture.no}"
											style="display: inline-block; width: 80px; height: 40px;"
											class="btn btn-txt txt-edit btn-blue">수정</a> <a
											href="${pageContext.request.contextPath}/user/lectureDelete.do?no=${lecture.no}"
											style="display: inline-block; width: 80px; height: 40px;"
											class="btn btn-txt txt-del btn-blue">삭제</a>
									</div>
									<%-- 									</c:if> --%>
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
<script type="text/javascript" src="js/common.js"></script>
</html>
