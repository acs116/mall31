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
	<h3> 아이디찾기 </h3>
	<div class="row">
		
		<div class="col-sm-10">
			
			<!-- action 요청 -->
			<form method="post" action="${pageContext.request.contextPath }/member/loginId">
				
				<label> 이름 : </label>
				<input  class="form-control type="text" name="memberName"  >
				<label> 휴대폰 : </label>
				<input  class="form-control type="text" name="memberPhone"  >					
				
				<button type="submit" class="btn btn-dark">아이디찾기</button>
				<div>
				아이디 : ${loginId.getMemberId()} 
				</div>
			</form>
				<a href="${pageContext.request.contextPath }/">처음으로</a> 
		</div>
	</div>
</body>
</html>