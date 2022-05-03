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
	<div align="center">
		<h3>판매 실적 관리</h3>
		<table border="1" cellspacing="0" width="800">
			<tr>
				<th>주문 번호</th>
				<th>상품주문번호</th>
				<th>상품명</th>
				<th>주문 금액</th>
				<th>주문 수량</th>
			</tr>
			
			<c:set var="list" value="${productList }" />
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
					<tr>
						<td> ${dto.getOrder_no() } </td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
		<c:if test="${empty list }">
			<h3>안됐답니다</h3>
		</c:if>
	</div>
</body>
</html>