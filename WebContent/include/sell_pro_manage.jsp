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
		<h2>상품 관리</h2>
		<ul id="seller_navigation">
			<li>
				<a href="<%=request.getContextPath() %>/sell_cart_list.do" id="subtitle">[카테고리 목록]</a>
			</li>
			<li>
				<a href="<%=request.getContextPath() %>/sell_cart_input.do" id="subtitle">[카테고리 관리]</a>
			</li>
			<li>
				<a href="<%=request.getContextPath() %>/sell_pro_input.do" id="subtitle">[판매상품 등록]</a>
			</li>
			<li>
				 <a href="<%=request.getContextPath() %>/sell_pro_list.do" id="subtitle">[판매상품 관리]</a>
			</li>
		</ul>
		
		<hr width="65%">
	</div>


</body>
</html>
