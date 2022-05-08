<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="center">
	
	<h2>회원 테이블</h2>
	<table border="1" cellspacing="0">
	      <tr>
	         <th>유저 번호</th> <th>유저 아이디</th> <th>유저 비밀번호</th>
	         <th>유저 이름</th> <th>유저 나이</th> <th>유저 전화번호</th>
	         <th>유저 이메일</th> <th>유저 주소</th> <th>유저 마일리지</th> 
	         <th>유저 등급</th> <th>유저 레벨</th> <th>유저 생성일자</th> 
	      </tr>
	      
	      <c:set var="list" value="${List }" />
	      <c:if test="${!empty list }">
	         <c:forEach items="${list }" var="dto">
	            <tr>
	               <td> ${dto.getUser_no() } </td>
	               <td> ${dto.getUser_id() } </td>
	               <td> ${dto.getUser_pwd() } </td>
	               <td> ${dto.getUser_name() } </td>
	               <td> ${dto.getUser_age() } </td>
	               <td> ${dto.getUser_phone() } </td>
	               <td> ${dto.getUser_email() } </td>
	               <td> ${dto.getUser_addr() } </td>
	               <td> ${dto.getUser_mileage() } </td>
	               <td> ${dto.getUser_grade() } </td>
	               <td> ${dto.getUser_level() } </td>
	               <td> ${dto.getUser_date().substring(0, 10) } </td>
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