<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<jsp:include page="../include/seller_top.jsp" />
	<jsp:include page="../include/sell_pro_manage.jsp" />
<body>
	
	
	<div align="center">
	      <h3>카테고리 등록</h3>
	   <br>
	   
	   <form method="post"
	      action="<%=request.getContextPath() %>/sell_cart_input_ok.do">
	   
	      <table border="1" cellspacing="0" width="300">
	         <tr>
	            <th>카테고리 코드</th>
	            <td> <input name="cart_code"> </td>
	         </tr>
	         
	         <tr>
	            <th>카테고리 이름</th>
	         	<td> <input name="cart_name"> </td>
	         </tr>
	         
	         <tr>
	            <td colspan="2" align="center">
	               <input type="submit" value="등록">&nbsp;&nbsp;&nbsp;
	         	   <input type="reset" value="취소">
	            </td>
	         </tr>
	      </table>
	      
	   </form>
	</div>
	
</body>
</html>