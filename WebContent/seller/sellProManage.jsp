<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

	ul li {
		list-style: none;
		display: inline-block;
		margin-left: 80px;
	}

</style>
</head>
<body>

	<div align="center">
	
	   <ul>
	      
	      <li> <a href="<%=request.getContextPath() %>/sell_cart_input.do">카테고리 등록</a>
	      
	      <li> <a href="<%=request.getContextPath() %>/sell_cart_list.do">카테고리 목록</a>
	         
	      <li> <a href="<%=request.getContextPath() %>/sell_pr_lIst.do">판매 상품 목록</a>

	      <li> <a href="<%=request.getContextPath() %>/sell_pro_input.do">판매 상품 등록</a>
	   
	      <li> <a href="<%=request.getContextPath() %>/sell_pro_ques.do">상품 문의 관리</a>
	   
	   </ul>
	
	</div>
	
</body>
</html>