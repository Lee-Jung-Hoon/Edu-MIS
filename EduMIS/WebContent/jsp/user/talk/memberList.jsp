<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 전체글개수 -->
<c:forEach var="member" items="${list}">
	<li>
		<label for="${member.no}">${member.name}</label>
		<input type="checkbox" id="${member.no}" value="${member.name}" />
	</li>
</c:forEach>

