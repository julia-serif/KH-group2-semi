<%@page import="java.util.List"%>
<%@page import="com.shop.model.CategoryDTO"%>
<%@page import="com.shop.model.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
 	CategoryDAO dao = CategoryDAO.getInstance();
    List<CategoryDTO> list =  dao.getCategoryList();
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

 	<jsp:include page="../include/top.jsp"/>
 
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
 	 	<div class="line">CATEGORY</div> 
<main>
 	 <div class="container">
 	  <div class="row g-4 mt-4">
 	   <c:set var="code" value="${code}"/>
 	 	 <c:if test="${!empty code }">
 	 	  <c:forEach items="${code }" var="dto">
 	 	 <div class="col-lg-4 col-md-5">
 	 	  <div class="card" style="width: 18rem;">
 	 	  <a href="<%=request.getContextPath() %>/order_ok.do?order=${dto.getPno()}"
  		        style="text-decoration: none;">
  			<img src="<%=request.getContextPath() %>/image/${dto.getPimage()}" class="card-img-top">
  		<div class="card-body">
  			<span class="badge bg-info text-dark">${dto.getPspec() }</span>
    		<h5 class="card-name">${dto.getPname() }</h5>
    		<p class="card-cont">${dto.getPcontents() }</p>
    		<p class="card-price">
    		<fmt:formatNumber value="${dto.getPrice() }"/>원</p>
    		<span class="badge rounded-pill bg-warning text-dark">
    		${dto.getPoint() } 적립
    		</span>	
    	  </div>
    	</a>
   		 <div class="btn-group" role="group">
 			<a href="<%=request.getContextPath() %>/">
 			<button type="button" class="btn btn-sm btn-outline-primary">장바구니 담기</button></a>
  			<a href="<%=request.getContextPath() %>/order_ok.do?order=${dto.getPno()}">
  			<button type="button" class="btn btn-sm btn-outline-primary">주문하기</button></a>
		</div>
  		</div>
		</div>
 	 	  </c:forEach>
 	 	 </c:if>
 	 	</div>
 	 </div>
 	 </main>
 	 </div>	 	
 	 	
 	 	<c:if test="${empty code }">
 	  	 <tr> 	  	 
 	  	 <td colspan="2"><h3>검색된 결과가 없습니다.</h3></td>
 	  	 </tr>
 	  	</c:if>
 	 	</table>
 	 	
 	 	
 	 	<c:if test="${page > block }">
 	 	 	<a href="paging.do?page=1">◀◀</a>
 	 	 	<a href="paging.do?page=${startBlock -1 }">◀</a>
 	 	</c:if>
 	 	
 	 	<c:forEach begin="${startBlock }" end="${endBlock }" var="i">
 	 	 	<c:if test="${i == page }">
 	 	 	 	<b><a href="paging.do?page=${i }">[${i }]</a></b>
 	 	 	</c:if>
 	 	 	
 	 	 	<c:if test="${i != page }">
 	 	 	 	<a href="paging.do?page=${i }">[${i }]</a>
 	 	 	</c:if>
 	 	</c:forEach>
 	 	
 	 	<c:if test="${endBlock < allPage }">
 	 	 	<a href="paging.do?page=${endBlock + 1 }">▶</a>
 	 	 	<a href="paging.do?page=${allPage}">▶▶</a>
 	 	</c:if>
 	</div>
</body>
</html>