<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Content Wrapper. Contains page content -->


<div class="col-md-4 mx-auto">
	<div class="card">
		<div class="card-body mx-auto">

			<h5 class="card-title">Login</h5>
			<p class="card-text">
			<form method="post">
				<input type="text" name="id" id="id" placeholder="아이디" /><br />
				<input type="password" name="password" id="password"
					placeholder="비밀번호" /><br />
				<input class="button fit"  type="submit" id="login" value="로그인" />
			</form>
			</p>
		</div>
	</div>
</div>