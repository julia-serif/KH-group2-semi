<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소비자 관리 페이지</title>
<link rel="stylesheet" href="./CSS/admin.css">
<link href="./CSS/admin_sidebar.css" rel="stylesheet">

</head>
<body>
	<%@ include file="admin_main_sidebar.jsp"%>

	<div class="arti" align="center">
		<h2>소비자 목록</h2>
		<br>
		<br>
		<table border="1" cellspacing="0" width="100%">
			<tr>
				<th>이름</th>
				<th>아이디</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>주소</th>
				<th>나이</th>
				<th>마일리지</th>
				<th>가입일</th>
				<th>탈퇴</th>
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
						<td><a
							href="<%=request.getContextPath()%>/update_user_mileage.do?user_no=${dto.getUser_no() }">
								<fmt:formatNumber value="${dto.getUser_mileage() }" />원
						</a></td>
						<td>${dto.getUser_date().substring(0,10) }</td>
						<td><a
							onclick="if(confirm('해당 회원을 탈퇴 처리시키겠습니까?')){location.href='admin_consumer_delete.do?user_no=${dto.getUser_no() }'}
							else{return;}">[탈퇴처리]</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>

			<c:if test="${empty list }">
				<tr>
					<td colspan="9" align="center">
						<h3>소비자 데이터가 없습니다.</h3>
					</td>
				</tr>
			</c:if>

		</table>
		<br> <a href="javascript:history.back();">뒤로가기</a>
	</div>
</body>
</html>
