<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
	<script src="https://code.jquery.com/jquery-1.9.0.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<h1>
	WOWA App
</h1>

<P>팬클럽 커뮤니티.</P>

<% if(request.getAttribute("user") == null){ %>
<p> 환영합니다. 로그인 부탁드립니다. </p>
<%} %>
</body>
</html>
