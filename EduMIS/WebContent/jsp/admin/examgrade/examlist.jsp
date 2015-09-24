<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<table border="1" class="table-board">
		<tr>
			<th width="100px">회차번호</th>
			<th width="200px">시험제목</th>
			<th width="300px">시험내용</th>
			<th width="100px">시험일자</th>
			<th width="200px">성적등록/수정</th>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr align="center">
				<td width="100px">${list.no}</td>
				<td width="200px">${list.title}</td>

				<td width="300px"><c:if test="${list.ck=='false'}">
					${list.content}
				</c:if> <c:if test="${list.ck=='true'}">
						<a
							href="${pageContext.request.contextPath}/examgrade/ExamGradeDetail.do?no=${list.no}">${list.content}</a>
					</c:if></td>

				<td width="300px">${list.regDate}</td>

				<td width="100px"><c:if test="${list.ck=='false'}">
						<a href='#' onclick="doInsert(${list.no})">성적등록</a>
					</c:if> <c:if test="${list.ck=='true'}">
						<a href='#' onclick="doModify(${list.no})">성적수정</a>
					</c:if></td>
			</tr>
		</c:forEach>
	</table>
	<div id="registmodal2" style="display: none;">
	<h2>시험별 상세</h2>
	<form action="${pageContext.request.contextPath}/examgrade/ExamTurnWrite.do">
		<input type="submit" value="등록">
	</form>
</div>
</body>
</html>