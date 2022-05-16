<%@page import="com.seller.model.ViewProductOrderDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<%
	List<ViewProductOrderDTO> list = 
				(List<ViewProductOrderDTO>)request.getAttribute("List");
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

		<h2>전체 판매목록</h2>
		<br> <br>
		<table border="1" cellspacing="0" width="100%">
			<tr>
				<th>판매자 아이디</th>
				<th>주문번호</th>
				<th>상품주문번호</th>
				<th>상품번호</th>
				<th>제품 금액</th>
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
						<td><fmt:formatNumber value="${dto.getProduct_price() }"/>원</td>
						<td>${dto.getProduct_quantity() }</td>
						<td>${dto.getUser_id() }</td>
						<td><fmt:formatNumber value="${dto.getProduct_price()*dto.getProduct_quantity()  }"/>원</td>
						<td>${dto.getOrder_date() }</td>
						<td>${dto.getOrder_status() }</td>
					</tr>
				</c:forEach>
			</c:if>

			<c:if test="${empty list }">
				<tr>
					<td colspan="10" align="center">
						<h3>데이터가 없습니다.</h3>
					</td>
				</tr>
			</c:if>

		</table>
		
		<%
			int sum=0; int amount=0;
	   	     if(list.size() != 0) { 
	   	    	 for(int i=0; i<list.size(); i++) {
	   	    		ViewProductOrderDTO dto = list.get(i);
	   	    		 	amount=amount+dto.getProduct_quantity();
	   	    			sum=sum+dto.getProduct_price()*dto.getProduct_quantity();
	   	    	 }
	   	     }
	   	   %>
	   	   <br>
	   	   <br>
	   	 <div align="center">
	   	 <form action="admin_select_mounth.do">
		<table border="1">
		<tr>
		<td width="120px" height="20px">총 판매 금액</td>
		<td width="120px" height="20px">총 판매 수량</td>
		<td width="120px" height="20px" colspan="2">월별 조회</td>
		</tr>
		<tr>
		<td><fmt:formatNumber value="<%=sum %>"/>원</td>
		<td><fmt:formatNumber value="<%=amount %>"/>개</td>
		<td>
			<select name="date" id="date">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
			</select>
			월
		</td>
		<td>
		<input type="submit" value="조회">
		</td>
		</tr>
		</table>
		</form>
</div>
		<br> <a href="javascript:history.back();">뒤로가기</a>
	</div>
</body>
</html>
