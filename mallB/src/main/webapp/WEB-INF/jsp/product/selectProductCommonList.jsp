<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BOARD LIST(spring mvc + mybatis 방식)</title>
<!-- bootstrap을 사용하기 위한 CDN주소 -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
<script>

$(document).ready(function(){
	$('#searchBtn').click(function(){
		console.log('searchBtn click...')
		$('#searchForm').submit();
	});
});
//자바스크립트는 함수를 변수에 담을수있다 . 매개변수로 함수로 보낼수있다 콜백함수?? 자바와 자바스크립트의 차이
// $(document).ready(function() = $(document).load(function() ready와 load의 차이 ready는 태그만읽으면되고 load다른 사진 동영상  ready가빠르다
//제이쿼리 '$' == 'jquery'
// $(document) 리턴값이 떨어진다 document. 제이쿼리에랩핑된 document .제이쿼리가제공하는소스 다쓸수있다
</script>
 
</head>
<body>
<div class="container">
    <h1>ProductCommon List</h1>
    <div>전체행의 수 : ${countProductCommon}</div>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>productCommonNo</th>
                <th>categoryNo</th>
                <th>productCommonName</th>
                <th>productCommonPrice</th>
                <th>productCommonDescription</th>
                <th>productCommonDate</th>               
            </tr>
        </thead>
        <tbody>
            <c:forEach var="list" items="${list}">
                <tr>
                    <td>${list.productCommonNo}</td>
                    <td>${list.categoryNo}</td>
                    <td>${list.productCommonName}</td>
                    <td>${list.productCommonPrice}</td>
                    <td>${list.productCommonDescription}</td>
                    <td>${list.productCommonDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    
    <form id="searchForm" action="/product/selectProductCommonList" method="get">
    	<input type="hidden" value="${categoryNo}" name="categoryNo">
    	productName 검색어 : <input type="text" name="searchWord">
    	<button id="searchBtn" type="button">검색</button>
    </form>
    <div>
    <!-- 이전 다음 /product/getProductListByCategory?categoryNo&currentPage -->
    </div>
    
    <ul class="pager">
        <c:if test="${currentPage > 1}">
            <li class="previous"><a href="/product/selectProductCommonList?categoryNo=${categoryNo}&currentPage=${currentPage-1}">이전</a></li>
        </c:if>
        <c:if test="${currentPage < lastPage}">
            <li class="next"><a href="/product/selectProductCommonList?categoryNo=${categoryNo}&currentPage=${currentPage+1}">다음</a></li>
        </c:if>
    </ul>
    <div>
        <%-- <a class="btn btn-default" href="${pageContext.request.contextPath}/board/addBoard">게시글 입력</a> --%>
    </div>
</div>
</body>
</html>



