<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<jsp:include page="../include/top.jsp"/>
	
		
	<div align="center">
		<hr width="65%" color="gray">		
			<h3>주문이 완료되었습니다.</h3>
		<hr width="65%" color="gray">		
		<br>
		
		<a href="<%=request.getContextPath() %>/user_main.do">[메인 페이지]</a>
		<a href="<%=request.getContextPath() %>/user_cart_list.do">[장바구니]</a>
	
	</div>
	
	
	
</body>
</html>
