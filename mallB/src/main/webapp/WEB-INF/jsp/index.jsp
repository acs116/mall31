<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<h1>INDEX</h1>
		<h3>쇼핑몰 메인 페이지</h3>
		<div>
		<c:if test="${loginMember != null}">		
		<a href="${pageContext.request.contextPath }/member/selectMember">상세보기</a>
		</c:if>
		
		<c:if test="${loginMember == null}">
		<a href="${pageContext.request.contextPath }/member/login">로그인</a>
		</c:if>
		
		<c:if test="${loginMember != null}">		
		<a href="${pageContext.request.contextPath }/member/logout">로그아웃</a>
		</c:if>
		
		<a href="${pageContext.request.contextPath }/member/addMember">회원가입</a>		
		<a href="${pageContext.request.contextPath }/member/loginId">아이디찾기</a>
		<a href="${pageContext.request.contextPath }/member/findPw">비번찾기</a>
		<a href="${pageContext.request.contextPath }/member/getAffirmation">아이디중복확인</a>
		</div>
		<!-- 쇼핑몰메뉴 -->
		<div>
			<ul>
				<c:forEach var="category" items="${categoryList}">
					<li>
						<a href="${pageContext.request.contextPath }/product/selectProductCommonList?categoryNo=${category.categoryNo}">${category.categoryName}</a>
					</li>
				</c:forEach>
			</ul>
		</div>
		
</body>
</html>