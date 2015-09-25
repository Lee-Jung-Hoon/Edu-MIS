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
							<h2>도서게시판</h2>
							<div class="table-common vod">
								<table>
									<colgroup>
										<col style="width: 15%;" />
										<col style="width: 85%;" />
									</colgroup>
									<tbody>
										<tr>
											<td style="width: 600px">${board.title}</td>
										</tr>
										<tr>
											<td class="vod-content"><img src="${board.filePath}"
												/"${board.orgFileName}" width="200px" alt="이미지" /></td>
										</tr>
										<tr>
											<td>${board.content}</td>
										</tr>
									</tbody>
								</table>
								<div class="btn-area">
									<a href="/EduMIS/bookboard/list.do" class="btn txt-list-lecture btn-txt btn-blue">도서목록</a>
								</div>
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
