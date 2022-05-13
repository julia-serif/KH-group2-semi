<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

	ul li {
		list-style: none;
		display: inline-block;
		margin-left: 80px;
	}

</style>
</head>
<body>
	<jsp:include page="../include/sell_top.jsp" />
	<div align="center">

		<h2>환영합니다.</h2>
		<h2>${sessionScope.user_name}님 판매관리 페이지 입니다.</h2>
	</div>
	
</body>
</html>