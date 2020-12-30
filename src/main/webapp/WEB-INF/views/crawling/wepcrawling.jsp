<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-1.9.0.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

	<div style="position: absolute;right: 13%;">
	<input type="button" class="btn btn-outline-secondary" value="Now" onClick="location.href='/crawling/wepcrawling'">
	</div>
	<div class="container">
		<center>
			<h2>
				<input type="button" class="btn btn-outline-secondary" value="<" onClick="changDateBefore()">
				${year} 년 ${month} 월 Schedule
				<input type="button" class="btn btn-outline-secondary" value=">" onClick="changDateAfter()">
			</h2>
		</center>
		${scheduleChart}
	</div>

</body>
<script>

function changDateBefore() {
	if(${month} == 1){
		var year = ${year}-1;
		var month = 12;
	}else{
		var year = ${year};
		var month = ${month}-1;
	}
	console.log(year);
	console.log(month);
	location.href="/crawling/changedate?year="+year+"&month="+month;
}
function changDateAfter() {
	if(${month} == 12){
		var year = ${year}+1;
		var month = 1;
	}else{
		var year = ${year};
		var month = ${month}+1;
	}
	console.log(year);
	console.log(month);
	location.href="/crawling/changedate?year="+year+"&month="+month;
}
</script>
<style>
table#scheduleChart {
	border-collapse: collapse;
	text-align: left;
	line-height: 1.5;
}

table#scheduleChart thead th {
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	color: #369;	
	border-bottom: 3px solid #036;
}

table#scheduleChart td {
	width: 350px;
	padding: 10px;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
}

</style>

</html>