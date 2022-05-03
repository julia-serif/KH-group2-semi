<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 관리 페이지</title>
</head>
<body>

	<div align="center">
		<h3>${param.seller_id}님 주문 관리 페이지</h3>
		<a href="<%=request.getContextPath()%>/seller_ship_manage.do?seller_id
		=${param.seller_id}">배송 관리</a>
		&nbsp;&nbsp;&nbsp;
		<a href="<%=request.getContextPath()%>/seller_sales_perform.do?seller_id
		=${param.seller_id}">판매 실적 확인</a>
	</div>

</body>
</html>