<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<form method="post" action="${pageContext.request.contextPath }/member/getAffirmation">
				<div>
				<label> 아이디 : </label>
				<input  class="form-control type="text" name="memberId">
				</div>				
				<!-- eq == / ne != -->
				<c:if test="${check eq false}">				 
				ID사용가능			
				</c:if>				
				<c:if test="${check eq true}">
				ID사용불가능
				</c:if>				
				<div>
				<button type="submit" class="btn btn-dark">중복확인</button>
				</div>
				
								
	</form>
	<a href="${pageContext.request.contextPath }/">처음으로</a>				
</body>
</html>