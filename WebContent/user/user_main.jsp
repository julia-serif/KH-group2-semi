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
		
		
		let image1 = '<img src="upload/book13.jpg" width="408" height="600">'
		let image2 = '<img src="upload/book23.jpg" width="408" height="600">'
		let image3 = '<img src="upload/book3.jpg" width="408" height="600">'
		let image4 = '<img src="upload/book4.jpg" width="408" height="600">'
		let image5 = '<img src="upload/book5.jpg" width="408" height="600">'
		
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
			$("#main_image").append(image3);
			$("#main_image").show();
			
		});
		
		$("#fourth_thum").mouseover(function() {

			$("#main_image").text('');
			$("#main_image").append(image4);
			$("#main_image").show();
			
		});
		
		$("#fifth_thum").mouseover(function() {

			$("#main_image").text('');
			$("#main_image").append(image5);
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

	<jsp:include page="../include/top_main.jsp"/>
	
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
				<img src="upload/book13.jpg" width="408" height="600">
			</td>
			<td>
			
			<ul class="main_thumbnails">  
				<li id="first_thum">
					<a href="<%=request.getContextPath() %>/user_product_view.do?pno=1">
						<img src="upload/book13.jpg" width="100" height="150">
					</a>
				</li>
				<li id="second_thum">
					<a href="<%=request.getContextPath() %>/user_product_view.do?pno=2">
						<img src="upload/book23.jpg" width="100" height="150">
					</a>
				</li>
				<li id="third_thum">
					<a href="<%=request.getContextPath() %>/user_product_view.do?pno=3">
						<img src="upload/book3.jpg" width="100" height="150">
					</a>
				</li>
				<li id="fourth_thum">
					<a href="<%=request.getContextPath() %>/user_product_view.do?pno=4">
						<img src="upload/book4.jpg" width="100" height="150">
					</a>
				</li>
				<li id="fifth_thum">
					<a href="<%=request.getContextPath() %>/user_product_view.do?pno=5">
						<img src="upload/book5.jpg" width="100" height="150">
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
						<td align="center" width="200" height="300">
							<a href="<%=request.getContextPath() %>/user_product_view.do?pno=${dto.getPno() }&page=${page }">
								<img src="<%=request.getContextPath() %>/upload/${dto.getPimage() }"
									width="150" height="220" border="0">
							</a>
							<br>
							<c:if test="${dto.getPname().length() <= 12 }">
								<br>${dto.getPname() }<br>
							</c:if>
							<c:if test="${dto.getPname().length() >= 12 }">
								<br>${dto.getPname().substring(0,11) }...<br>								
							</c:if>
							<fmt:formatNumber value="${dto.getPrice() }"/>원<br>
						</td>
					<c:if test="${count % 5 == 0 }">
				</tr>
				<tr>
					</c:if>
					</c:forEach>
					
					
				</tr>
				
    		</table>
    		
    		
   		<c:if test="${page > block }">
			<a href="user_main.do?page=1">◀◀</a>
			<a href="user_main.do?page=${startBlock - 1 }">◀</a>
		</c:if>
		
		<c:forEach begin="${startBlock }" end="${endBlock }" var="i">
			
			<c:if test="${i == page }">
				<b><a href="user_main.do?page=${i }">[${i }]</a></b>
			</c:if>
			
			<c:if test="${i != page }">
				<a href="user_main.do?page=${i }">[${i }]</a>
			</c:if>
			
		</c:forEach>
		
		<c:if test="${endBlock < allPage }">
			<a href="user_main.do?page=${endBlock + 1 }">▶</a>
			<a href="user_main.do?page=${allPage }">▶▶</a>
		</c:if>	

    	</c:if>
	
	</div>


</body>

</html>
