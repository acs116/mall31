<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>addMember</title>
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
	<h3> 비번찾기 </h3>
	<div class="row">
		
		<div class="col-sm-10">
			
			<!-- action 요청 -->
			<form method="post" action="${pageContext.request.contextPath }/member/findPw">
				
				<label> 아이디 : </label>
				<input  class="form-control type="text" name="memberId"  >
				<label> 이름 : </label>
				<input  class="form-control type="text" name="memberName"  >					
				
				<button type="submit" class="btn btn-dark">이메일ㄱㄱ</button>
				
			</form>
				<a href="${pageContext.request.contextPath }/">처음으로</a> 
		</div>
	</div>
</body>
</html>