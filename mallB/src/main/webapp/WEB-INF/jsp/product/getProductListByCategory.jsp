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

</head>
<body>
<div class="container">
    <h1>getProductListByCategory</h1>
   
    
    <table class="table table-striped">
        
            <tr>
            	<th>productCommonNo</th>
            	<td>${productCommon.productCommonNo}</td>
            </tr>
            <tr>	
                <th>productCommonName</th>
                <td>${productCommon.productCommonName}</td>
            </tr>
            <tr> 
                <th>productCommonPrice</th>
                <td>${productCommon.productCommonPrice}</td>
            </tr>
            <tr>    
                <th>productCommonDescription</th>
                <td>${productCommon.productCommonDescription}</td>
            </tr>
            <tr>    
                <th>productCommonDate</th>
                <td>${productCommon.productCommonDate}</td>        
            </tr>
            </table>
            
            <table class="table table-striped">
            	<tr>
            		<th>productCommonNo</th>
            		<th>productColor</th>
            		<th>productSize</th>
            		<th>productStock</th>
            	</tr>
            <c:forEach items="${productCommon.products}" var="p">
            	<tr>            		
            		<td>${p.productCommonNo}</td>
            		<td>${p.productColor}</td>
            		<td>${p.productSize}</td>
            		<td>${p.productStock}</td>
            	</tr>
            </c:forEach>
       
    		</table>
    		
    <a class="btn btn-default" href="${pageContext.request.contextPath}/product/selectProductCommonList?categoryNo=${productCommon.categoryNo}">전에</a> 
    
    
</div>
</body>
</html>



