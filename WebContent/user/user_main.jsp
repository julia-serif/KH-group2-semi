<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">

	$(function() {
		
		
		let image1 = '<a href="#"><img src="upload/book1.jpg" width="500" height="450"></a>'
		let image2 = '<a href="#"><img src="upload/book2.jpg" width="500" height="450"></a>'
		
		$("#first_thum").mouseover(function() {

			$("#main_image").text('');
			$("#main_image").append(image1);
			$("#main_image").show();
			
		});
		
		$("#second_thum").mouseover(function() {

			$("#main_image").text('');
			$("#main_image").append(image2);
			$("#main_image").show();
			
		});
		
		$("#third_thum").mouseover(function() {

			$("#main_image").text('');
			$("#main_image").append(image1);
			$("#main_image").show();
			
		});
		
		$("#fourth_thum").mouseover(function() {

			$("#main_image").text('');
			$("#main_image").append(image2);
			$("#main_image").show();
			
		});
		
		$("#fifth_thum").mouseover(function() {

			$("#main_image").text('');
			$("#main_image").append(image1);
			$("#main_image").show();
			
		});
	
		$("#sixth_thum").mouseover(function() {

			$("#main_image").text('');
			$("#main_image").append(image2);
			$("#main_image").show();
			
		});
		
		
	});
	


</script>
<style type="text/css">
	
	.main_thumbnails{
		list-style: none;
	}
	
</style>
</head>
<body>

	<div align="center">
				
		<c:set var="list" value="${productList }"/>
		<c:if test="${empty list }">
			<span>제품 목록이 없습니다.</span> <br>
			<a href="<%=request.getContextPath() %>/admin_product_input.do">상품등록</a>
			
		</c:if>
				
		<c:if test="${!empty list }">

				<h3>Koupang 제품 추천</h3>
			
			<table>
			<tr>
			<td id="main_image">
				
			</td>
			<td>
			<ul class="main_thumbnails">  
				<li id="first_thum">
					<a href="">
						<img src="upload/book1.jpg" width="180" height="60">
					</a>
				</li>
				<li id="second_thum">
					<a href="#">
						<img src="upload/book2.jpg" width="180" height="60">
					</a>
				</li>
				<li id="third_thum">
					<a href="#">
						<img src="upload/book1.jpg" width="180" height="60">
					</a>
				</li>
				<li id="fourth_thum">
					<a href="#">
						<img src="upload/book2.jpg" width="180" height="60">
					</a>
				</li>
				<li id="fifth_thum">
					<a href="#">
						<img src="upload/book1.jpg" width="180" height="60">
					</a>
				</li>
				<li id="sixth_thum">
					<a href="#">
						<img src="upload/book2.jpg" width="180" height="60">
					</a>
				</li>
			</ul>
			</td>
			
			</tr>
			</table>
		

				<h3>Koupang 제품 목록</h3>

			<br>
			
			<table border="1" cellspacing="0">
				<tr>
					<c:forEach items="${list }" var="dto">
					<c:set var="count" value="${count + 1 }"/>
						<td align="center">
							<a href="<%=request.getContextPath() %>/user_product_view.do?pnum=${dto.getPnum() }">
								<img src="<%=request.getContextPath() %>/upload/${dto.getPimage() }"
									width="120" height="120" border="0">
							</a>
							<br>
							${dto.getPname() } <br>
							<fmt:formatNumber value="${dto.getPrice() }"/>원<br>
						</td>
					<c:if test="${count % 4 == 0 }">
				</tr>
				<tr>
					</c:if>
					</c:forEach>
					
					
				</tr>
				
    		</table>
    		
    		<a href="<%=request.getContextPath() %>/admin_product_input.do">상품등록</a>
    		
    	</c:if>
	
	</div>

</body>
</html>