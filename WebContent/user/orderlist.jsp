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
<style type="text/css">
.tit_info ul li{
	list-style: none;
}
</style>
</head>
<body>

 	<jsp:include page="../include/top.jsp"/>
 	
<div class="container">
  <div class="row">
 	<div class="col-10  mt-4 mb-5">
 	  <h3>주문목록</h3>
 	  <hr width="100%">
 	  
 	  <c:set var="list" value="${cartlist }"/>
		<c:if test="${!empty list }">
 	 	 <c:forEach items="${list }" var="dto">
 	 	  <div class="b_ta_info">
 	 	   <table width="100%" border="1" class="b_table_grey">
 	 	    <colgroup>
 	 	     <col width="108" class="daate">
 	 	     <col class="pinfo">
 	 	     <col width="115;" class="status">
 	 	     <col width="108;" class="confirm">
 	 	    </colgroup>
 	 	   
 	 	    <thead>
 	 	     <tr class="head">
 	 	      <th scope="col">날짜</th>
 	 	      <th scope="col">상품정보</th>
 	 	      <th scope="col">상태</th>
 	 	      <th scope="col">확인/신청</th>
 	 	     </tr>
 	 	    </thead>
 	 	    <tfoot>
 	 	     <tr>
 	 	      <td class="last" colspan="4">
 	 	     </tr>
 	 	    </tfoot>
 	 	    <tbody id="orderList">
 	 	     <tr cno="3686652494" ctype="G" column="4">
 	 	      <td class="first_cell" rowspan="1">
 	 	       <div class="td_detaol">
 	 	        "2022-05-10"
 	 	        <span class="btn_bg btn_w81_2">
 	 	         <a href="#" id=>주문상세보기</a>
 	 	        </span>
 	 	       </div>
 	 	      </td>
 	 	      <td>
 	 	       <div class="tit_info">
 	 	        <p><a href="<%=request.getContextPath() %>/image/${dto.getCart_pimage()}"></a></p>
 	 	        <ul>
 	 	         <li><a href=""></a>${dto.getCart_pname() }</li>
 	 	         <li class="cart">수량 : ${dto.getCart_pqty() } 개</li>
 	 	         <li class="price">
                  <strong><fmt:formatNumber value="${dto.getCart_price() }"/></strong>원
                 </li>
 	 	        </ul>
 	 	       </div>
 	 	      </td>
 	 	      <td cidx="3">
 	 	       <div class="td_status">
 	 	         <span class="btn_bg2 btn_status_b1">배송완료</span>
 	 	       </div>
 	 	      </td>
 	 	      <td cidx="4" class="b_table_right"></td>	 	  
 	 	     </tr>
 	 	    </tbody>
 	 	   </table>
 	 	  </div>
         </c:forEach>
        </c:if>
    </div>
  </div>
</div>
</body>
</html>