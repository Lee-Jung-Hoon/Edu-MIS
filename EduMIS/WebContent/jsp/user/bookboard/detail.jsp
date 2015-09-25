<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width">
<title>메인</title>
<%@ include file="/jsp/admin/include/common.jsp"%>
</head>
<body class="page-main btn-page">
	<div class="wrap">
		<div class="wrap-inner">
			<%@ include file="/jsp/admin/include/leftMenu.jsp"%>
			<div class="container">
				<%@ include file="/jsp/admin/include/topMenu.jsp"%>

				<div class="container-inner">
					<div class="content">
						<section class="join common">
							<h2>도서게시판</h2><br />
							<form action="/EduMIS/bookboard/delete.do">
							<div align="right">
							<input type="submit" value="글삭제" style="display:inline-block; width:100px; height:30px;"  class="btn btn-txt txt-del-s btn-blue" />
							</div>
							<div class="table-common">
								<table>
									<colgroup>
										<col style="width: 15%;" />
										<col style="width: 85%;" />
									</colgroup>
									<tbody>
										<tr>
											<th>제목</th>
											<td style="width: 600px">${board.title}</td>
											<td><input type="hidden" name="no" id="no" value="${board.no}" /></td>
										</tr>
										<tr>
											<th>도서 사진</th>
											<td>
												<span style="display:block; width:200px; height:250px; border:1px solid #ddd;">
													<img style="width:100%;" src="/EduMIS${board.filePath}/${board.orgFileName}" height="250px" width="200px" alt="이미지" />
												</span>
											</td>
										</tr>
										<tr>
											<th>도서 내용</th>
											<td>${board.content}</td>
										</tr>
									</tbody>
								</table>
								</div>
							</form>
								<div class="btn-area">
									<a href="/EduMIS/bookboard/list.do" class="btn txt-list btn-txt btn-blue">도서목록</a>
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
