<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
	ul {
		list-style: none;
		padding: 0px;
	}
	
	ul li {
		display: inline-block;
		padding-right: 15px;
		padding-left: 15px;
	}
	
	a {
		text-decoration: none;
	}
	
	#subtitle {
		font-weight : bold;
	}
	
	#logout {
		float: right;
		clear: both;
		padding-right: 17.5%;
	}
	
</style>
</head>
<body>
	<div align="center">
		<hr width="65%">
		<h1>판매자 페이지</h1>
		<a href="<%=request.getContextPath() %>/sell_home.do"
		id="subtitle" style="padding-left: 20%;">[홈]</a>
		&nbsp;&nbsp;&nbsp;
		<a href="<%=request.getContextPath() %>/seller_order_manage.do"
		id="subtitle">[주문 관리]</a>
		&nbsp;&nbsp;&nbsp;
		<a href="<%=request.getContextPath() %>/seller_product_manage.do"
		id="subtitle">[상품 관리]</a>
		<a href="<%=request.getContextPath()%>/admin_logout.do"
		id="logout">로그아웃</a>
		<hr width="65%">
	</div>
</body>
</html>