 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="styleSheet" href="${pageContext.request.contextPath}/css/index.css" />
<script>
	var contextPath = '${pageContext.request.contextPath}';
</script>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
 <div id="stage">
   <div id="container">
     <div id="gameContainer">
        <div id="gameHeader">
          <div class="left questions">
            <div class="container"><span></span></div>
          </div>
          <div class="left timer">
            <div class="container">TIME: <span></span></div>
          </div>
          <div class="left score">
            <div class="container">SCORE: <span></span></div>
          </div>
        </div>
        <div id="gameChoices">
          <div class="row">
            <div class="left half">
              <div class="container"><button id="buttonOne" data-index="0"></button></div>
            </div>
            <div class="left half">
              <div class="container"><button id="buttonTwo" data-index="1"></button></div>
            </div>
          </div>
          <div class="row">
            <div class="left half">
              <div class="container"><button id="buttonThree" data-index="2"></button></div>
            </div>
            <div class="left half">
              <div class="container"><button id="buttonFour" data-index="3"></button></div>
            </div>
          </div>
        </div>
        <h1 id="title">강의 관리 시스템</h1>
     </div>
     <button id="startButton" onclick="movePage(1)">관리자 메인</button>
     <br />
     <button id="startButton" onclick="movePage(2)">사용자 메인</button>
   </div>
 </div>
 <div id="modal_window">
  <div class="modal_message">
    <p></p>
 </div>
 </div>