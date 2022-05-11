<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매 실적 관리</title>
</head>
<body>
	<jsp:include page="../include/seller_order_manage_top.jsp" />
	
	<div align="center">
		<h3>판매 실적 관리</h3>
		<table border="1" cellspacing="0" width="800">
			<tr>
				<th>주문 번호</th>
				<th>상품주문번호</th>
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
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty list }">
				<tr>
					<td colspan="6" align="center">목록이 없습니다.</td>
				</tr>
			</c:if>
		</table>
	</div>
</body>
</html>