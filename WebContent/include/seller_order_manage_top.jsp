<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
	#subtitle {
		font-weight : bold;
	}
	
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
	
</style>
</head>
<body>

	<div align="center">
		<hr width="65%">
		<h2>${sessionScope.user_name}님 주문 관리 페이지</h2>
		
		<ul id="seller_navigation">
			<li>
				<a href="<%=request.getContextPath() %>/sell_home.do"
				 id="subtitle">[판매자 홈으로]</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/seller_ship_manage.do"
				 id="subtitle">[배송 관리]</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/seller_sales_perform.do"
				 id="subtitle">[판매 실적 확인]</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/admin_logout.do"
				 id="subtitle" style="font-weight : normal;">로그아웃</a>
			</li>
		</ul>
		
		<hr width="65%">
	</div>

</body>
</html>