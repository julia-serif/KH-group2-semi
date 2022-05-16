<%@page import="java.util.List"%>
<%@page import="com.shop.depricated.Ks_CategoryDTO"%>
<%@page import="com.shop.depricated.Ks_CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
<c:set var="user" value="${userid }"/>
  <main class="mt-3">
 	 <div class="container">
 	 <h2>주문결제</h2>
 	 <hr width="100%">
 	   <div class="row">
 	    <div class="col-md-5">
 	    <div class="card">
  		<h5 class="card-header">${username }</h5>
  		 <div class="card-body">
    	 <h5 class="card-title"><strong>${username } | ${userphone }</strong></h5>
          <p class="card-text">${user_addr }</p>
     <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
		  <option selected>배송시 요청사항을 선택해 주세요.</option>
		  <option value="1">직접 수령하겠습니다</option>
		  <option value="2">배송 전 연락 바랍니다.</option>
		  <option value="3">부재 시 경비실에 맡겨주세요.</option>
		  <option value="4">부재 시 문 앞에 놓아주세요.</option>
		  <option value="5">부재 시 택배함에 넣어주세요.</option>
	</select>
  </div>
</div>
 </div>  
		<c:set var="dto" value="${payok }"/>
		  <c:if test="${!empty dto }">
		  <c:set var="price" value="${dto.getCart_price() }"/>
 	 	  <c:set var="amount" value="${dto.getCart_pqty() }"/>
 	 	  <c:set var="total" value="${total + (price * amount) }" />
 	    <div class="col-md-7">
 	     <div class="card shadow-sm">  		
  			<div class="card-body">
    		<h5 class="card-name"><strong>주문 상품</strong></h5>
    		<p class="card-price pt-3 pb-3 border-top"></p>
			<p class="card-cont">${dto.getCart_seller }</p>   		
    	<div class="card-text boder-top pt-3 pb-3">
    	 <div class="row">
    	  <div class="col-auto">
    	   <label class="col-form-label">구매수량</label>
    	  </div>
    	  <div class="col-auto">
    	  <div class="input-group">
			  <input type="number" value="${dto.getCart_pqty() }">
			</div>
    	  </div>
    	 </div>
    	</div>	
    	<div class="row pt-3 pb-3 boder-top">
    	 <div class="col-8">
    	  <h3>총 상품 금액</h3>
    	 </div>
    	  <div class="col-auto" style="text-align: right;">
    	  <h4><fmt:formatNumber value="${total }"/>원</h4>
    	 </div>
    	</div>
    	<div class="d-grid gap-2 col-12 mx-auto">
		  <button class="btn btn-primary" type="button">결제하기</button>
		</div>
  		</div>
		</div>
 	    </div>
 	    </c:if>
 	   </div>
 	 </div>
</main>


</body>
</html>