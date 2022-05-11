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
 	<div class="col-12 md mt-4">
 	  <c:set var="dto" value="${userupdate }"></c:set>
 	 	<form method="post" action="<%=request.getContextPath() %>/user_updata.do">
 	 	<h2>${username }님 회원 정보 수정</h2>
 	 	<hr width="100%" color="pink">
 	 	<input type="hidden" name="dbpwd" value="${userpwd}">
 	 	<table class="table table-bordered" class="mt-4">
 	 	 	<tr>
 	 	 	 	<th>아이디</th>
 	 	 	 	<td><input name="userid" value="${userid }" readonly></td>
 	 	 	</tr>
 	 	 	
 	 	 	<tr>
 	 	 	 	<th>이  름</th>
 	 	 	 	<td><input name="username" value="${username }" readonly></td>
 	 	 	</tr>
 	 	 	
 	 	 	<tr>
 	 	 	 	<th>휴대폰번호</th>
 	 	 	 	<td><input name="userphone"></td>
 	 	 	</tr>
 	 	 	
 	 	 	<tr>
 	 	 	 	<th>이메일</th>
 	 	 	 	<td><input name="useremail"></td>
 	 	 	</tr>
 	 	 	
 	 	 	<tr>
 	 	 	 	<th>주  소</th>
 	 	 	 	<td><input name="user_addr"></td>
 	 	 	</tr>
 	 	 	
 	 	 	<tr>
 	 	 	 	<td colspan="2">
 	 	 	 	비밀번호를 입력해 주세요.
 	 	 	 	</td>
 	 	 	</tr>
 	 	 	<tr>
 	 	 	 	<td colspan="2">
 	 	 	 	<input type="password" name="userpwd">
 	 	 	 	</td> 
  	 	 	</tr>
 	 	 	
 	 	 	<tr>
 	 	  	 	<td colspan="2" align="center">
 	 	  	 	 	<input type="submit" value="정보수정">&nbsp;&nbsp;&nbsp;
 	 	  	 	 	<input type="reset" value="다시작성">
 	 	  	 	</td>
 	 	  	</tr>
 	 	</table>		
 	 	</form> 	 	
 	</div>
 </div>
</div>
</body>
</html>