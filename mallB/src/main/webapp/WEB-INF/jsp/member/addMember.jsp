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
	<h3> 관리자 메인 페이지 </h3>
	<div class="row">
		
		<div class="col-sm-10">
			<h4>사원 추가 </h4>
			<!-- action 요청 -->
			<form method="post" action="${pageContext.request.contextPath }/member/addMember">
				
				<label> 아이디 : </label>
				<input  class="form-control type="text" name="memberId"  >							
				<label> 패스워드 : </label>
				<input  class="form-control type="password" name="memberPw"  >
				<label> 이름 : </label>
				<input  class="form-control type="text" name="memberName"  >
				<label> PHONE : </label>
				<input  class="form-control type="text" name="memberPhone"  >
				<label> 주소 : </label>
				<input  class="form-control type="text" name="memberAddress"  >
				<label> 성별 : </label>
				<input  class="form-control type="text" name="memberGender"  >
				<label> 회원레벨 : </label>
				<input  class="form-control type="text" name="memberLevel" value="consumer" readonly>
				<button type="submit" class="btn btn-dark">회원가입</button>
			</form> 
		</div>
	</div>
</body>
</html>