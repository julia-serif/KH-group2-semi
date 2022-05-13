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
	   <hr width="65%">
	      <h2>판매자 페이지</h2>
	      <br>
      <hr width="65%">
	      
	      <br>
	      
	      <table width="800">
	         <tr>
	            <td>
	               <a href="<%=request.getContextPath() %>/sell_home.do">판매자 홈</a>
	            </td>
	            
	            <td>
	               <a href="<%=request.getContextPath() %>/sell_cart_input.do">카테고리 등록</a>
	            </td>
	            
	            <td>
	               <a href="<%=request.getContextPath() %>/sell_cart_list.do">카테고리 목록</a>
	            </td>
	            
	            <td>
	               <a href="<%=request.getContextPath() %>/sell_pro_input.do"> 판매 상품 등록</a>
	            </td>
	            
	            <td>
	               <a href="<%=request.getContextPath() %>/sell_pro_list.do">판매 상품 목록</a>
	            </td>
	         
	         </tr>
	      </table>
	   <hr width="65%">
</body>
</html>