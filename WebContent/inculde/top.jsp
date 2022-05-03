
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../CSS/top.css">
</head>
<body>

 	<div align="center">
 	<input type="hidden" name="userid" value="${userid }"> 
 	 	<table border="1" cellspacing="0">
 	 	 	<tr>
 	 	 	 	<td colspan="5" align="right">
 	 	 	 	<a href="#">${username }님 </a>
 	 	 	 	<a href="<%=request.getContextPath()%>/logout.do">로그아웃</a>
 	 	 	 	<a href="<%=request.getContextPath()%>/#">회원가입</a>
 	 	 	   <div class="dropdown">
 	 	 	 	  	<button class="dropbtn">
 	 	 	 	  	 <span class="drop_icon"></span>
 	 	 	 	  	 고객센터
 	 	 	 	  	</button>
 	 	 	 	  	<div class="dropdown_content">
 	 	 	 	  	  <a href="<%=request.getContextPath()%>/ask.do">자주묻는 질문</a>
 	 	 	 	  	  <a href="<%=request.getContextPath()%>/">상품 문의</a>
 	 	 	 	  	</div>
 	 	 	    </div>
 	 	 	  </td>	 	 	 	
 	 	 	</tr>
 	 	 	<tr>
 	 	 	 	<td>
 	 	 	 	  <div class="dropdown">
 	 	 	 	  	<button class="dropbtn">
 	 	 	 	  	 <span class="drop_icon"></span>
 	 	 	 	  	 카테고리
 	 	 	 	  	</button>
 	 	 	 	  	<div class="dropdown_content">
 	 	 	 	  	  <a href="<%=request.getContextPath()%>/food.do">식품</a>
 	 	 	 	  	  <a href="<%=request.getContextPath()%>/#">악기</a>
 	 	 	 	  	  <a href="<%=request.getContextPath()%>/#">도서</a>
 	 	 	 	  	</div>
 	 	 	    </div>
 	 	 	 	</td>
 	 	 	 	<td>
 	 	 	 	 <img src="image/쿠팡로고.png" width="300" height="100">
 	 	 	 	</td>
 	 	 	 	<td>
 	 	 	 	 	<form method="post" 
 	 	 	 	 	   action="<%=request.getContextPath() %>/search.do">
 	 	 	 	 	 	<select name="find_field">
 	 	 	 	 	 	 	<option value="all">전체</option>
 	 	 	 	 	 	 	<option value="food">식품</option>
 	 	 	 	 	 	 	<option value="#">악기</option>
 	 	 	 	 	 	 	<option value="#">도서</option>
 	 	 	 	 	 	</select>
 	 	 	 	 	 	<input type="text" name="find_name"> 	 	
 	 	 				<input type="submit" value="검색">	 	 	 	 	 	
 	 	 	 	 	</form>
 	 	 	 	</td>
 	 	 	 	<td>
 	 	 	 	  <div class="dropdown">
 	 	 	 	  	<button class="dropbtn">
 	 	 	 	  	 <span class="drop_icon"></span>
 	 	 	 	  	 마이페이지
 	 	 	 	  	</button>
 	 	 	 	  	<div class="dropdown_content">
 	 	 	 	  	  <a href="<%=request.getContextPath()%>/order_list.do">주문목록</a>
 	 	 	 	  	  <a href="<%=request.getContextPath()%>/user_data.do">회원정보</a>
 	 	 	 	  	</div>
 	 	 	    </div>	
 	 	 	    <a href="<%=request.getContextPath()%>/">장바구니</a>
 	 	 	 	</td>
 	 	 	</tr>
 	 	</table>
 	</div>

</body>
</html>