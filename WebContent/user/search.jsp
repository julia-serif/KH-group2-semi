<%@page import="com.shop.model.Ks_CategoryDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.shop.model.Ks_CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
 	Ks_CategoryDAO dao = Ks_CategoryDAO.getInstance();
    List<Ks_CategoryDTO> list =  dao.getCategoryList();
 	request.setAttribute("categoryList", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="stylesheet" href="CSS/top.css">
<link rel="stylesheet" href="CSS/category.css">
</head>
<body>

 	<jsp:include page="../inculde/top.jsp"/>
 	
 	<div id="total">
 	 	<div id="side">
 	 	 	<c:set var="list" value="${categoryList}"/>
 	 	 	<h3>카테고리</h3>
 	 	 	<c:if test="${!empty list }">
 	 	 	 <c:forEach items="${list }" var="dto">
 	 	 	  	<a href="<%=request.getContextPath() %>/category_code.do?code=${dto.getCategory_code()}">
 	 	 	  	${dto.getCategory_name() }</a>
 	 	 	 </c:forEach>
 	 	 	</c:if>
 	 	</div>
 	 	
 	 	<div id="middle">
 	 	<div class="line">CATEGORY</div> 
 <main>
 	 <div class="container">
 	  <div class="row g-4">
 	 	 <div align="left"><h2>과일</h2></div>
 	 	 <c:set var="search" value="${searchlist}"/>
 	 	 <c:if test="${!empty search }">
 	 	  <c:forEach items="${search }" var="dto">
 	 	 <div class="col-lg-4 col-md-5">
 	 	  <div class="card" style="width: 18rem;">
  			<img src="<%=request.getContextPath() %>/image/${dto.getPimage()}" class="card-img-top">
  			<div class="card-body">
    		<h5 class="card-name">${dto.getPname() }</h5>
    		<p class="card-cont">${dto.getPcontents() }</p>
    		<p class="card-price">
    		<fmt:formatNumber value="${dto.getPrice() }"/>원</p>
   		 <div class="btn-group" role="group">
 			 <button type="button" class="btn btn-sm btn-outline-primary">장바구니 담기</button>
  			 <button type="button" class="btn btn-sm btn-outline-primary">주문하기</button>
		</div>
  		</div>
		</div>
		</div>
 	 	  </c:forEach>
 	 	 </c:if>
 	 	</div>
 	 </div>
 	 </main>
 	</div>

</body>
</html>