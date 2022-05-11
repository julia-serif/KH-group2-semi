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

</head>
<body>

 	<jsp:include page="../include/top.jsp"/>
 	
<div class="container">
  <div class="row">
 	<div class="col-12 md mt-4" class="top_user">
 	<c:set var="dto" value="${userid }"/>
 	 <h2>${username }님 회원 정보 </h2><hr width="100%" color="pink">
 	 <div class="user">
 	   <p>아이디 <input name="userid" value="${userid }">
                   이 름 <input name="username" value="${username }">
 	   </p>
 	   <hr width="100%" color="pink">
 	   <p>-${username }님의 회원정보입니다.</p>
 	   <table class="table table-bordered" class="usertable">
 	    <tr>
 	     <th>이  메  일</th>
 	      <td>${useremail }</td>
 	    </tr>
 	    <tr>
 	     <th>나   이</th>
 	      <td>${userage }</td>
 	    </tr>
 	    <tr>
 	     <th>휴대폰번호</th>
 	      <td> ${userphone }</td>
 	    </tr>
 	    <tr>
 	      <th>주   소</th>
 	       <td>${user_addr }</td>
 	    </tr>
 	    <tr>
 	     <th>마 일 리 지</th>
 	      <td>${user_mileage }</td>
 	    </tr>	    
 	    <tr>
 	     	<td align="center" colspan="2">
 	     	<a href="<%=request.getContextPath() %>/updata.do"
 	     	style="text-decoration: none;"><h4>정보수정하러가기</h4></a></td>
 	    </tr>
 	   </table>
 	 </div>
 	</div>
</div>
</div>
</body>
</html>