<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BOARD LIST</title>
<!-- bootstrap을 사용하기 위한 CDN주소 -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>
<div class="container">
    <h1>getProductListByCategory</h1>
    <div>전체행의 수 : ${countProductCommon}</div>
    <form>
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
            <c:forEach var="ProductCommon" items="${list}">
                <tr>
                    <td>${ProductCommon.productCommonNo}</td>
                    <td>${ProductCommon.categoryNo}</td>
                    <td>${ProductCommon.productCommonName}</td>
                    <td>${ProductCommon.productCommonPrice}</td>
                    <td>${ProductCommon.productCommonDescription}</td>
                    <td>${ProductCommon.productCommonDate}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
    
</div>
</body>
</html>



