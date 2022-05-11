<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>배송 관리</h3>
		<ul>
			<li><a href="<%=request.getContextPath()%>/seller_ship_new_order_list.do">신규 주문 확인</a></li>
			<li><a href="<%=request.getContextPath()%>/seller_ship_delivery_check.do">배송 상태 확인</a></li>
		</ul>
		<hr width="65%">
	</div>
</body>
</html>