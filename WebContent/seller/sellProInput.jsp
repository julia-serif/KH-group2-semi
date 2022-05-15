<%@page import="com.seller.model.CategoryDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.seller.model.CategoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	
<body>
<jsp:include page="../include/sell_top.jsp" />

	
	<div align="center">
	      <h3>쇼핑몰 판매자 상품 등록</h3>
	   <br>
	   
	   <form method="post" enctype="multipart/form-data"
	      action="<%=request.getContextPath() %>/sell_pro_input_ok.do">
	   
	      <table border="1" cellspacing="0" width="400">
	         <c:set var="list" value="${categoryList }" />
	         <tr>
	            <th>카테고리 코드</th>
	            <td>
	               <select name="p_code">
	                  <c:if test="${empty list }">
	                     <option value="">카테고리 없음</option>
	                  </c:if>
	                 
	                  <c:if test="${!empty list }">
	                     <c:forEach items="${list }" var="dto">
	                      <option value="${dto.getCategory_code() }">
	                        	${dto.getCategory_name() } [${dto.getCategory_code() }]</option>
	                    
	                    </c:forEach>
	                  </c:if>
	              </select>
	            </td>
	         </tr>
	         
	         <tr>
	            <th>상품명</th>
	            <td> <input name="p_name"> </td>
	         </tr>

	         <tr>
	            <th>상품제조사</th>
	            <td> <input name="p_company"> </td>
	         </tr>
	         
	         <tr>
	            <th>상품 이미지</th>
	            <td> <input type="file" name="p_image"> </td>
	         </tr>
	         
	         <tr>
	            <th>상품 수량</th>
	            <td>
	               <input type="number" name="p_qty"
	               		min="1" max="100" value="1">
	            </td>
	         </tr>
	         
	         <tr>
	            <th>상품 가격</th>
	            <td> <input name="p_price" maxlength="8"> </td>
	         </tr>
	         
	         <tr>
	            <th>상품 사양</th>
	            <td>
	               <select name="p_spec">
	                  <option value="none" selected>일반</option>
	                  <option value="hit">인기</option>
	                  <option value="new">최신</option>
	                  <option value="recommand">추천</option>
	               </select>
	            </td>
	         </tr>
	         
	         <tr>
	            <th>상품 소개</th>
	            <td>
	               <textarea rows="7" cols="30" name="p_content"></textarea>
	            </td>
	         </tr>
	      
	         <tr>
	            <th>상품 포인트</th>
	            <td> <input name="p_point"> </td>
	         </tr>
	         
	         <tr>
	            <td colspan="2" align="center">
	               <input type="submit" value="상품등록">&nbsp;&nbsp;&nbsp;
	               <input type="reset" value="다시작성">
	            </td>
	         </tr>
	      </table>
	   </form>
	
	</div>
	


</body>
</html>