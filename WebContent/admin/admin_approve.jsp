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
	
	<h2>판매자 가입신청 확인창</h2>
	<table border="1" cellspacing="0">
	      <tr>
	         <th>신청인 아이디</th> <th>신청인 이름</th>
	         <th>신청인 나이</th> <th>신청인 전화번호</th>
	         <th>신청인 이메일</th> <th>신청인 승인여부</th> 
	         <th>승인</th> 
	      </tr>
	      
	      <c:set var="list" value="${List }" />
	      <c:if test="${!empty list }">
	         <c:forEach items="${list }" var="dto">
	            <tr>
	               <td> ${dto.getUser_id() } </td>
	               <td> ${dto.getUser_name() } </td>
	               <td> ${dto.getUser_age() } </td>
	               <td> ${dto.getUser_phone() } </td>
	               <td> ${dto.getUser_email() } </td>
	               <td> ${dto.getUser_level() } </td> 
	               <td>
	               <a href="<%=request.getContextPath() %>/approve_ok.do?user_no=${dto.getUser_no() }">승인</a>
	               </td>
	            </tr>
	         </c:forEach>
	      </c:if>
	      
	      <c:if test="${empty list }">
	         <tr>
	            <td colspan="7" align="center">
	         	</td>
	         </tr>
	      </c:if>
	      
	   </table>
</div>
</body>
</html>