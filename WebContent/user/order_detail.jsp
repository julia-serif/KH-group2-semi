<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/top.css">
</head>
<body>
 	
 	<c:set var="dto" value="${detail }"/>

 	 	<div class="container">
 	 	  <div class="col-10  mt-4">
 	 	    <div class="col-8"><h4>주문 상세 내역</h4></div>
 	 	    <hr width="100%">
 	 	    <div class="b_ta_info">
 	 	    <c:if test="${!empty dto }">
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
 	 	    
 	 	    </tfoot>
 	 	    <tbody id="orderList">
 	 	     <tr cno="3686652494" ctype="G" column="4">
 	 	      <td class="first_cell" rowspan="1">
 	 	       <div class="td_detaol">
 	 	        ${dto.getOrder_date() }	 	     
 	 	       </div>
 	 	      </td>
 	 	      <td>
 	 	       <div class="tit_info">
 	 	        <p>주문번호 : ${dto.getOrder_no() }</p>
 	 	        <ul>
 	 	         <li></li>
 	 	         <li class="cart">수량 : ${dto.getProduct_quantity() } 개</li>
 	 	         <li class="price">
                  <strong><fmt:formatNumber value="${dto.getProduct_price() }"/></strong>원
                 </li>
 	 	        </ul>
 	 	       </div>
 	 	      </td>
 	 	      <td cidx="3">
 	 	       <div class="td_status">
 	 	         <span class="btn_bg2 btn_status_b1">${dto.getOrder_status() }</span>
 	 	       </div>
 	 	      </td>
 	 	      <td cidx="4" class="b_table_right"></td>	 	  
 	 	     </tr>
 	 	    </tbody>
 	 	   </table>
 	 	   <table width="100%" border="1" >
 	 	    <tr>
 	 	     	<td colspan="3"><strong>결제내역</strong></td>
 	 	    </tr>
 	 	    <tr>
 	 	    <th>결제방식</th><th>결제일시</th><th>결제금액</th>
 	 	    </tr>
 	 	    <tr>
 	 	    <td>카드 </td><td>${dto.getOrder_date() }</td>
 	 	    <td><fmt:formatNumber value="${dto.getProduct_price() }"/> 원</td>
 	 	    </tr>
 	 	    <tr>
 	 	    <td colspan="3"><strong>배송정보</strong></td>
 	 	    </tr>
 	 	    <tr>
 	 	    <td>이   름</td>
 	 	    <td colspan="2">${user_name }</td>
 	 	    </tr>
 	 	    <tr>
 	 	    <td>연락처</td>
 	 	    <td colspan="2">${dto.getRecipient_phone() }</td>
 	 	    </tr>
 	 	    <tr>
 	 	    <td>주  소 </td>
 	 	    <td colspan="2">${dto.getAddress() }</td>
 	 	    </tr>
 	 	   </table>
 	 	    </c:if>
 	 	  </div>
 	 	  </div>
 	 	</div>
 	

</body>
</html>