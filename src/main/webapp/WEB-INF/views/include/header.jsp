<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-1.9.0.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<div class="Header"></div>
<% if(request.getAttribute("user") != null){ %>
<p>${user} 님</p>

<div class="col">
<a class="home" href="/mypage" style="color: #6E6E6E; font-size: 12pt; font-weight: bolder; border-bottom: none;">home</a><!-- 
&emsp;&emsp;
<a class="chating_interface" href="/echo/WebSocket-echo" style="color: #6E6E6E; font-size: 12pt; font-weight: bolder; border-bottom: none;">채팅하기</a> -->
&emsp;&emsp;
<a class="todo_interface" href="/board/todo" style="color: #6E6E6E; font-size: 12pt; font-weight: bolder; border-bottom: none;">Todo List</a>
&emsp;&emsp;
<a class="schedule_interface" href="/crawling/wepcrawling" style="color: #6E6E6E; font-size: 12pt; font-weight: bolder; border-bottom: none;">일정관리</a>
</div>
<%} else{%>

<div class="col">
	<a class="login_interface" href="/member/login" style="color: #6E6E6E; font-size: 12pt; font-weight: bolder; border-bottom: none;">로그인</a><!-- 
&emsp;&emsp;
	<a class="chating_interface" href="#" onClick="alert('로그인 후 이용 가능합니다.')" style="color: #6E6E6E; font-size: 12pt; font-weight: bolder; border-bottom: none;">채팅하기</a> -->
&emsp;&emsp;
	<a class="todo_interface" href="#" onClick="alert('로그인 후 이용 가능합니다.')" style="color: #6E6E6E; font-size: 12pt; font-weight: bolder; border-bottom: none;">Todo List</a>
&emsp;&emsp;
	<a class="schedule_interface" href="#" onClick="alert('로그인 후 이용 가능합니다.')" style="color: #6E6E6E; font-size: 12pt; font-weight: bolder; border-bottom: none;">일정관리</a>
</div>
<% } %>

