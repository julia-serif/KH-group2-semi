<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰</title>

<link rel="stylesheet" href="./css/home.css">
</head>

<body>
	<div id="container">

		<div id="main">
			<div id="intro">
				<h2>Shopping<br> Mall</h2>
			</div>
            <div id="intro2">
                <h5>Semi Project 2조</h5>
            </div>

			<div id="start">
				<a href="view/sign_in.jsp">Start ></a>
			</div>
		</div>
	</div>
</head>
<body>

	<h2>김지호</h2>
	<a href="<%=request.getContextPath() %>/user_main.do">메인</a>
	<a href="<%=request.getContextPath() %>/admin_car_input.do">카테고리</a>
	<a href="<%=request.getContextPath() %>/admin_product_input.do">상품등록</a>
	
</body>
</html>