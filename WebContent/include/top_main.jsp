<%@page import="com.shop.depricated.Ks_ProductDTO"%>
<%@page import="com.shop.depricated.Ks_ProductDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.shop.depricated.Shop_UserDTO"%>
<%@page import="com.shop.depricated.Shop_UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="stylesheet" href="../CSS/top.css">
</head>
<body>
<!-- 로그인 전 -->
 <div class="container">
 	<c:set var="dto" value="${userid }"/>
 	<input type="hidden" name="userid" value="${userid }"> 
 	<input type="hidden" name="userpwd" value="${userpwd }"> 
 	<input type="hidden" name="username" value="${username }"> 
 	<input type="hidden" name="userage" value="${userage }"> 
 	<input type="hidden" name="userphone" value="${userphone }"> 
 	<input type="hidden" name="user_mileage" value="${user_mileage }"> 
  	
 	 	<table class="top_line col-12">
 	 	 	<tr>
 	 	 	 	<td colspan="5" align="right">
 	 	 	 	<a href="view/sign_in.jsp">로그인</a>
 	 	 	 	<a href="<%=request.getContextPath()%>/sign_in_ok.do">회원가입</a>
 	 	 	   <div class="dropdown">
 	 	 	 	  	<button class="dropbtn">
 	 	 	 	  	 <span class="drop_icon"></span>
 	 	 	 	  	 고객센터
 	 	 	 	  	</button>
 	 	 	 	  	<div class="dropdown_content">
 	 	 	 	  	  <a href="<%=request.getContextPath()%>/ask.do">자주묻는 질문</a>
 	 	 	 	  	  <a href="<%=request.getContextPath()%>/user_product_view.do">상품 문의</a>
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
 	 	 	 	<a href="<%=request.getContextPath() %>/home.do">
 	 	 	 	<img src="image/쿠팡로고.png" width="250" height="100"></a> 
 	 	 	 	</td>
 	 	 	 	<td>
 	 	 	 	 	<form method="post" 
 	 	 	 	 	   action="<%=request.getContextPath() %>/search.do">
 	 	 	 	 	 <div class="search1">
 	 	 	 	 	 	<select name="find_field">
 	 	 	 	 	 	 	<option value="all">전체</option>
 	 	 	 	 	 	 	<option value="name">식품</option>
 	 	 	 	 	 	 	<option value="name">악기</option>
 	 	 	 	 	 	 	<option value="name">도서</option>
 	 	 	 	 	 	</select>
 	 	 	 	 	 	<input type="text" name="find_name"
 	 	 	 	 	 	 placeholder="찾고 싶은 물건을 검색해보세요!"> 	 	
 	 	 				<input type="submit" value="검색">	
 	 	 			</div> 	 	 	 	 	
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
 	 	 	    </td>
 	 	 	   <td><a href="<%=request.getContextPath()%>/">장바구니</a></td>
 	 	 	</tr>
 	 	 	
 	 	</table>
 	</div>

</body>
</html>