<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/top.css">
</head>
<body>

 	<jsp:include page="inculde/top_main.jsp"/>

 <main class="mt-3">
 	 <div class="container">
 	   <div class="row">
 	    <div class="col-12">
 	      <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
	  <div class="carousel-indicators">
	    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
	    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
	    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
	  </div>
	  <div class="carousel-inner">
	    <div class="carousel-item active">
	      <img src="https://image7.coupangcdn.com/image/ccm/banner/1d2d9f01882432f845041744c603d042.jpg" class="d-block w-100">
	    </div>
	    <div class="carousel-item">
	      <img src="https://image8.coupangcdn.com/image/ccm/banner/5d10a4e96a508d22b13daa6658e13043.png" class="d-block w-100">
	    </div>
	    <div class="carousel-item">
	      <img src="https://static.coupangcdn.com/qa/cmg_paperboy/image/1651816088094/220509_C1_%EB%B7%B0%ED%8B%B0%EB%A1%9C%EB%93%9C%EC%83%B5_SMD-17271_PC.jpg" class="d-block w-100">
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
	 </div>
	 </div>
	 </main>
	
</body>
</html>