<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 전체글개수 -->
<input type="hidden" id="count" value="${size}"/>
<c:forEach var="talk" items="${list}">
	<li>
	<button type="button" class="btn-message-remove" onclick="checkTalk(${talk.no})">삭제</button>
	<a href='#'><span class='info1'>
	<strong	title='${talk.name}'>${talk.name}</strong>(으)로부터도착</span> <span class='info2'>${talk.sendDate}</span></a>
		<div class='text-content'>
			<p >${talk.content}</p>
			<textarea id="${talk.no}"></textarea>
			<button type='button' class='btn-send' onclick="sendTalk(${talk.no}, '${user.name}')">
				<div class='circle'>
					<div class='envelope-top'></div>
					<div class='envelope'></div>
				</div>
			</button>
		</div></li>
</c:forEach>
