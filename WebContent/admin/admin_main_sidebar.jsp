<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<link href="./CSS/admin_sidebar.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./CSS/admin.css">
</head>
<body>

	<div class="sidebar">
		<span class="sidebar-brand"> 쇼핑몰 관리자 <span
			style="float: right; text-decoration: none;"><a
				href="<%=request.getContextPath()%>/admin.do">[메인] </a></span>
		</span>


		<ul class="sidebar-nav">

			<li><a href="javascript:void(0)" data-toggle="collapse"
				data-target="#menu-collapse-1"> 관리자 정보
					<div class="caret"></div>
			</a>
				<ul id="menu-collapse-1" class="collapse in">
					<li><a href="#">관리자 id: [<%=session.getAttribute("user_id")%>]
					</a></li>
					<li><a href="#">관리자 name: [<%=session.getAttribute("user_name")%>]
					</a></li>
					<li><a
						onclick="if(confirm('로그아웃 하시겠습니까?')){location.href='admin_logout.do'} else{return;}">[로그아웃]</a></li>
				</ul></li>

			<li><a href="javascript:void(0)" data-toggle="collapse"
				data-target="#menu-collapse-2"> 사용자 관리
					<div class="caret"></div>
			</a>
				<ul id="menu-collapse-2" class="collapse">
					<li><a
						href="<%=request.getContextPath()%>/admin_manage_consumer.do">
							소비자 목록 </a></li>
					<li><a
						href="<%=request.getContextPath()%>/admin_manage_seller.do">
							판매자 목록 </a></li>
					<li><a
						href="<%=request.getContextPath()%>/admin_seller_approve.do">
							판매자 가입 승인 </a></li>
				</ul></li>
			<li><a href="javascript:void(0)" data-toggle="collapse"
				data-target="#menu-collapse-3"> 쇼핑몰 내역
					<div class="caret"></div>
			</a>
				<ul id="menu-collapse-3" class="collapse">
					<li><a href="<%=request.getContextPath()%>/admin_buy_list.do">
							구매 내역 </a></li>
					<li><a href="<%=request.getContextPath()%>/admin_sell_list.do">
							판매 내역 </a></li>
				</ul></li>

			<li><a href="javascript:void(0)" data-toggle="collapse"
				data-target="#menu-collapse-4"> 고객센터
					<div class="caret"></div>
			</a>

				<ul id="menu-collapse-4" class="collapse">
					<li><a href="javascript:void(0)" data-toggle="collapse"
						data-target="#menu-collapse-4"> 답변 관리 </a></li>
				</ul></li>

		</ul>
	</div>


</body>
</html>
