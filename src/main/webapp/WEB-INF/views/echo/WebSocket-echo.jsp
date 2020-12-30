<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-1.9.0.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<title>Chating</title>
</head>
<body>
<script type="text/javascript">
	var user = "${user}";
	console.log(user);
	
	$(document).ready(function() {
		$("#message").keydown(function(key) {
			if(key.keyCode == 13) {
				sendMessage();
				$("#message").val('');
			}
		});
	});
	
	
	let sock = new SockJS("http://localhost:8080/echo/");
	sock.onmessage = onMessage;
	sock.onclose = onClose;
	
	function sendMessage(){
		var message = $("#message").val();
		console.log(message);
		var data = new Array();
		var data = { user : user, message : message};
		console.log(data);
		sock.send(JSON.stringify(data));
		$("#message").val('');
	}
	
	function onMessage(evt){
		var data = evt.data;
		$("#data").append(data+"<br/>");
	}
	
	function onClose(evt){
		$("#data").append("연결끊김<br/>");
	}
	window.setInterval(function() {
        var elem = document.getElementById('data');
        elem.scrollTop = elem.scrollHeight;
    }, 0);
</script>
<div>
	<!-- <div style="overflow:auto;width: 50%; height:230px;" id="data"></div> -->
	<div id="data"></div>
 	 <div class="input-group mb-3" >
		<input type="text" class="form-control" id="message" />
		<input type="button" class="btn btn-outline-secondary" id="sendBtn" onClick="sendMessage();" value="전송" align="center" style="font-size : 7px;" />
	</div>
	
</div>
</body>
</html>