<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-1.9.0.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script>

	$(document).ready(function(){
		todoList();
		//댓글 쓰기 
		
		$("#td_text").keydown(function(key) {
		if(key.keyCode == 13) {
			var td_text=$("#td_text").val();
			console.log(td_text);
			var m_no="${m_no}";
			console.log(m_no);
			if(td_text == ""){
				alert("input todo.");
			}else{
			var param={
					td_text : td_text,
					m_no : m_no					
			};
			console.log(JSON.stringify(param));
			$.ajax({
				type: "post",
				url: "/board/insert",
				data: param,
				success: function(res){
					todoList();
					console.log(res);
					$("#td_text").val('');
				}
			});	
			}
		}
	});
		$("#btnReply").click(function(){
			var td_text=$("#td_text").val();
			console.log(td_text);
			var m_no="${m_no}";
			console.log(m_no);
			if(td_text == ""){
				alert("input todo.");
			}else{
			var param={
					td_text : td_text,
					m_no : m_no					
			};
			console.log(JSON.stringify(param));
			$.ajax({
				type: "post",
				url: "/board/insert",
				data: param,
				success: function(){
					todoList();
					$("#td_text").val('');
				}
			});	
			}
		});
	});

	//todo list
	function todoList(){
		$.ajax({
					type : "get",
					url : "/board/listJson?m_no=${m_no}",
					success : function(result) {
						console.log(result);
						var output = "<table>";
						for ( var i in result) {
								output += "<tr>";
								output += "<td>&emsp;• &nbsp;";
								output += result[i].td_text 						
								output += "</td>";
								output += "<td>&emsp;&emsp;&emsp;<button type='button' class='btn btn-outline-secondary' onClick='tododelete(" + result[i].td_no + ");'>완료</button></td>";
								output += "</tr>";
								
						}
						output += "</table>";
						$("#list2").html(output); 
					} 
						
				});

	}
	//todo 삭제
	function tododelete(e) {
		var param = {
			td_no : e
		};
			$.ajax({
				type : "get",
				url : "/board/tododelete",
				data : param,
				success : function() {
					todoList();
				}
			});
	}
</script>

  <h1>To do List page</h1>
 
  
  <div class="input-group mb-3" style="width: 50%;">
  <input type="text" class="form-control" id="td_text" placeholder="todo" />
  <button type="button" class="btn btn-outline-secondary" id="btnReply">작성</button>
  </div>
   <div id="list2" class="example01"></div> 

