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
 <c:set var="dto" value="${orderOk }"/>
 <c:if test="${!empty dto }">
  <main class="mt-3">
 	 <div class="container">
 	   <div class="row">
 	    <div class="col-md-5">
 	      <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="<%=request.getContextPath() %>/image/${dto.getPimage()}" class="d-block w-100" style="width: 300px; height: 300px;">
    </div>
    <div class="carousel-item">
      <img src="" class="d-block w-100" style="width: 300px; height: 300px;">
    </div>
    <div class="carousel-item">
      <img src="" class="d-block w-100" style="width: 300px; height: 300px;">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
 </div>
      
      <input type="hidden" name="userid" value="${user_id }">
      <input type="hidden" name="payNo" value="${dto.getPno() }">     
      <input type="hidden" name="cartPspec" value="${dto.getPspec() }">
      <input type="hidden" name="cartPimage" value="${dto.getPimage() }">

 	    <div class="col-md-7">
 	     <div class="card shadow-sm">  		
  			<div class="card-body">
    		<h4 class="card-name" name="pName">${dto.getPname() }</h4>
    		<p class="card-cont">${dto.getPcontents() }</p>
    		<h5 class="card-price pt-3 pb-3 border-top">
    		상품 가격
    		<input name="p_price" value="${dto.getPrice() }" readonly>원</h5>
    		
    	<div class="card-text boder-top pt-3 pb-3">
    	 <div class="row">
    	  <div class="col-auto">
    	   <label class="col-form-label">구매수량</label>
    	  </div>
    	  <div class="col-auto">
    	  <div class="input-group">
			  <input type="number" name="cartpqty" min="1" max="50" value="1">
			</div>
    	  </div>
    	 </div>
    	</div>	
    	
    	 <div class="btn-group" role="group">
   		 <div class="col-7 d-grid p-1">
 			<a href="<%=request.getContextPath() %>/">
 			<button type="button" class="btn btn-lg btn-dark">장바구니 담기</button></a>
 		</div>
 		<div class="col-7 d-grid p-1">
 		  <a href="<%=request.getContextPath()%>/payment.do">
  			<button type="button" class="btn btn-lg btn-danger">주문하기</button></a>
		</div>
		</div>
  		</div>
		</div>
 	    </div>
 	   </div>
 	   <div class="row">
 	    <div class="col-12">
 	    <img src="" class="img-fluid">
 	    </div>
 	   </div>
 	 </div>
 	</main>
 </c:if>


</body>
</html>