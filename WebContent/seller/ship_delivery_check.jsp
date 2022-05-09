<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../include/seller_order_manage_top.jsp" />
	<jsp:include page="../include/seller_ship_manage_top2.jsp" />
	
	<div align="center">
		<br>
		<table border="1" cellspacing="0" width="800">
			<tr>
				<th>주문번호</th>
				<th>상품주문번호</th>
				<th>상품번호</th>
				<th>수량</th>
				<th>금액</th>
				<th>주문자</th>
				<th>배송주소</th>
				<th>주문날짜</th>
				<th>배송상태</th>
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
					<td colspan="9" align="center">목록이 없습니다.</td>
				</tr>
			</c:if>
		</table>
	</div>
</body>
</html>