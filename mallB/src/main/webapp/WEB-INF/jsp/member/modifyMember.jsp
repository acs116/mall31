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
	<h3>  </h3>
	<div class="row">
		
		<div class="col-sm-10">
			<h4> </h4>
			<!-- action 요청 -->
			<form method="post" action="${pageContext.request.contextPath }/member/modifyMember">
				
				<label> 아이디 : </label>
				<input  class="form-control type="text" name="memberId" value="${dbmember.memberId}" readonly >				
			
				<label> 이름 : </label>
				<input  class="form-control type="text" name="memberName" value="${dbmember.memberName}" >
				<label> PHONE : </label>
				<input  class="form-control type="text" name="memberPhone" value="${dbmember.memberPhone}" >
				<label> 주소 : </label>
				<input  class="form-control type="text" name="memberAddress" value="${dbmember.memberAddress}" >
				<label> 성별 : </label>
				<input  class="form-control type="text" name="memberGender" value="${dbmember.memberGender}" >
				<label> 회원레벨 : </label>
				<input  class="form-control type="text" name="memberLevel" value="consumer" readonly>
				<button type="submit" class="btn btn-dark">수정완료</button>
			</form> 
		</div>
	</div>
</body>
</html>