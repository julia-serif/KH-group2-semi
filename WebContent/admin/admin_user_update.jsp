<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소비자 마일리지 변경 페이지</title>
<link rel="stylesheet" href="./CSS/admin.css">
<link href="./CSS/admin_sidebar.css" rel="stylesheet">

</head>
<body>
	<%@ include file="admin_main_sidebar.jsp"%>
	<c:set var="dto" value="${dto }" />
	<div class="arti" align="center">
		<h2>${dto.getUser_name() }회원마일리지변경</h2>
		<br> <br>
		<form
			action="<%=request.getContextPath() %>/update_user_mileage_ok.do"
			method="post">
			<input type="hidden" name="user_no" value="${dto.getUser_no() }">
			<table border="1" cellspacing="0" width="80%">
				<tr>
					<th>이름</th>
					<th>아이디</th>
					<th>전화번호</th>
					<th>이메일</th>
					<th>주소</th>
					<th>나이</th>
					<th>마일리지</th>
					<th>가입일</th>
				</tr>

				<tr>
					<td>${dto.getUser_name() }</td>
					<td>${dto.getUser_id() }</td>
					<td>${dto.getUser_phone() }</td>
					<td>${dto.getUser_email() }</td>
					<td>${dto.getUser_addr() }</td>
					<td>${dto.getUser_age() }</td>
					<td width="200px"><input type="text" name="user_mileage"
						value="${dto.getUser_mileage() }">원</td>
					<td>${dto.getUser_date().substring(0,10) }</td>
				</tr>
				<tr>
					<td colspan="8"><input type="submit" value="마일리지 수정">
					</td>
				</tr>


			</table>
		</form>
		<br> <a href="javascript:history.back();">뒤로가기</a>
	</div>
</body>
</html>
