<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="application"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<link rel="stylesheet" href="${contextPath}/resources/css/common.css">
<title><tiles:insertAttribute name="title"/></title>
</head>
<body>
	<div id="wrapper" style="padding-left:2px;">
		<tiles:insertAttribute name="header" />
		<div id="main">		
		<tiles:insertAttribute name="body"/>
		</div>
		<tiles:insertAttribute name="footer"/>
	</div>
	<% if(request.getAttribute("user") != null){ %>
	
		<div class="card" style="position:fixed; bottom:5px; right:5px; height: 50%;">
			<div class="card-body mx-auto">
				<h5 class="card-title">chating</h5>			
				<iframe  src="/echo/WebSocket-echo" frameborder="0" allowfullscreen style="height: 90%;"></iframe>
		</div>
	</div> 
	<%} %>
	

</body>

</html>