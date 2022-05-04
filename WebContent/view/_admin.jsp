<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<style type="text/css">
body{
	padding: 0;
	margin: 0;
}
.header{
}
.side{
float: left;
width:100px;
}
.section{
float:right;
width:auto;
}

div{
border: 1px solid black;
}
</style>
</head>
<body>
	<div class="header">헤더</div>
	<div class="side">
	<a href="<%=request.getContextPath()%>/approve.do">판매자 승인요청</a>
	</div>
	
	<div class="section">본문</div>
</body>
</html>