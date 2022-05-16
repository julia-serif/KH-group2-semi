<%@page import="com.seller.model.ProductOrderDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%
	List<ProductOrderDTO> list = 
				(List<ProductOrderDTO>)request.getAttribute("List");
%>
<html>
<head>
<meta charset="UTF-8">
<title>전체 판매목록</title>
<link rel="stylesheet" href="./CSS/admin.css">
<link href="./CSS/admin_sidebar.css" rel="stylesheet">

</head>
<body>
	<%@ include file="admin_main_sidebar.jsp"%>
	<div class="arti" align="center">

		<h2>판매목록</h2>
		<br> <br>
		<table border="1" cellspacing="0" width="80%">
			<tr>
				<th>판매자 아이디</th>
				<th>주문번호</th>
				<th>상품주문번호</th>
				<th>상품번호</th>
				<th>수량</th>
				<th>구매자 아이디</th>
				<th>총 금액</th>
				<th>주문날짜</th>
				<th>배송상태</th>
			</tr>

			<c:set var="list" value="${List }" />
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.getSeller_id() }</td>
						<td>${dto.getOrder_no() }</td>
						<td>${dto.getProduct_order_no() }</td>
						<td>${dto.getProduct_no() }</td>
						<td>${dto.getProduct_quantity() }</td>
						<td>${dto.getUser_id() }</td>
						<td>${dto.getProduct_price() }</td>
						<td>${dto.getOrder_date() }</td>
						<td>${dto.getOrder_status() }</td>
					</tr>
				</c:forEach>
			</c:if>

			<c:if test="${empty list }">
				<tr>
					<td colspan="9" align="center">
						<h3>데이터가 없습니다.</h3>
					</td>
				</tr>
			</c:if>

		</table>
		
		<%
			int sum=0;
	   	     if(list.size() != 0) { 
	   	    	 for(int i=0; i<list.size(); i++) {
	   	    		 ProductOrderDTO dto = list.get(i);
	   	    			sum=sum+dto.getProduct_price();
	   	    	 }
	   	     }
	   	   %>
	   	   <br>
	   	   <br>
	   	 <div align="center">
		<table border="1">
		<tr>
		<td width="100px" height="20px">총 판매 금액</td>
		<td width="100px" height="20px"><%=sum %></td>
		</tr>
		</table>
</div>
		<br> <a href="javascript:history.back();">뒤로가기</a>
	</div>
</body>
</html>
