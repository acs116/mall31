<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>로그인</h1>
	<form method="post" action="${pageContext.request.contextPath}/member/login">
		<div>
			<table class = "table table-dark">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="memberId" value="id001"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="passward" name="memberPw" value="pw001" ></td>
				</tr>
				<tr>
					<td colsmpa="2">
					<input type="submit" value="로그인" ></td>
			</table>
		</div>	
	</form>	
</body>
</html>