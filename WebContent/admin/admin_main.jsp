<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<title>관리자 페이지</title>
<link href="./css/admin_sidebar.css" rel="stylesheet">
<link rel="stylesheet" href="./css/admin.css">
</head>
<body>
	<%@ include file="admin_main_sidebar.jsp"%>
	<div class="arti" align="center">
		<h2>관리자 페이지</h2>
		<br>
		<h4>전체 회원 목록</h4>
		<br>
		<br>
		<table border="1" cellspacing="0" width="90%">
			<tr>
				<th>유저 번호</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>나이</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>주소</th>
				<th>마일리지</th>
				<th>등급</th>
				<th>접근 레벨</th>
				<th>생성일자</th>
			</tr>
			<c:set var="list" value="${List }" />
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.getUser_no() }</td>
						<td>${dto.getUser_id() }</td>
						<td>${dto.getUser_pwd() }</td>
						<td>${dto.getUser_name() }</td>
						<td>${dto.getUser_age() }</td>
						<td>${dto.getUser_phone() }</td>
						<td>${dto.getUser_email() }</td>
						<td>${dto.getUser_addr() }</td>
						<td>${dto.getUser_mileage() }</td>
						<td>${dto.getUser_grade() }</td>
						<td>${dto.getUser_level() }</td>
						<td>${dto.getUser_date().substring(0, 10) }</td>
					</tr>
				</c:forEach>
			</c:if>

			<c:if test="${empty list }">
				<tr>
					<td colspan="12" align="center">
						<h3>검색된 게시물이 없습니다.....${dto.getuser }</h3>
					</td>
				</tr>
			</c:if>

		</table>
	</div>


</body>
</html>