<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매 실적 확인</title>
</head>
<body>
	<jsp:include page="../include/seller_top.jsp" />
	<jsp:include page="../include/seller_order_manage_top.jsp" />
	
	<div align="center">
		<h3>판매 실적 확인</h3>
		<table border="1" cellspacing="0" width="800">
			<tr>
				<th>주문 번호</th>
				<th>상품주문번호</th>
				<th>상품번호</th>
				<th>상품명</th>
				<th>주문 수량</th>
				<th>주문 금액</th>
				<th>주문 날짜</th>
			</tr>
			
			<c:set var="list" value="${productList }" />
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
					<tr>
						<td> ${dto.getOrder_no() } </td>
						<td> ${dto.getProduct_order_no() } </td>
						<td> ${dto.getProduct_no() } </td>
						<td> ${dto.getPname() } </td>
						<td> ${dto.getProduct_quantity() } </td>
						<td> ${dto.getProduct_price() } </td>
						<td> ${dto.getOrder_date() } </td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty list }">
				<tr>
					<td colspan="7" align="center">목록이 없습니다.</td>
				</tr>
			</c:if>
		</table>
	</div>
</body>
</html>