<%@page import="com.shop.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String userId = request.getParameter("id").trim();
	UserDAO dao = UserDAO.getInstance();
	String res = dao.Overlap(userId);
	out.println(res);

%>
</body>
</html>