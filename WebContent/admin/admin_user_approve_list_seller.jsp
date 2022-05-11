<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자 승대 대기 페이지</title>
</head>
<body>

	<div align="center">

		<h2>판매자 가입 승인 대기 목록</h2>
		<table border="1" cellspacing="0" width="80%">
			<tr>
				<th>이름</th>
				<th>아이디</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>주소</th>
				<th>나이</th>
				<th>가입일</th>
				<th>승인상태</th>
			</tr>

			<c:set var="list" value="${List }" />
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.getUser_name() }</td>
						<td>${dto.getUser_id() }</td>
						<td>${dto.getUser_phone() }</td>
						<td>${dto.getUser_email() }</td>
						<td>${dto.getUser_addr() }</td>
						<td>${dto.getUser_age() }</td>
						<td>${dto.getUser_date() }</td>
						<td><a
							href="<%=request.getContextPath() %>/admin_seller_approve_ok.do?user_no=${dto.getUser_no() }">보류</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>

			<c:if test="${empty list }">
				<tr>
					<td colspan="8" align="center">
						<h3>가입 요청 대기중인 판매자가 없습니다.</h3>
					</td>
				</tr>
			</c:if>

		</table>
	</div>
</body>
</html>