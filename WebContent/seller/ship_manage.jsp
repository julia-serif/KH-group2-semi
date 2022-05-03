<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송 관리</title>
</head>
<body>
	<div align="center">
		<h3>배송 관리</h3>
		<table border="1" cellspacing="0" width="800">
			<tr>
				<th>여기에 컬럼들 들어가야 함</th>
			</tr>
			
			<c:set var="list" value="${productList }" />
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>여기에 DB에서 받은 list 떠야 함</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
</body>
</html>