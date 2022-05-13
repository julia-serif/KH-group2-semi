<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
a.btn{
    display:inline-block;
    width:100px;
    line-height:30px;
    text-align:center;
    background-color: #009AFF;
    color:#fff;
    padding: 10px 20px;
    border-radius: 5px;
    transition:all 0.1s;
}

a.btn:active{
    transform: translateY(3px);
   
    
} 

#zero{
  margin-left : auto;
  margin-right: auto;
	width:500px;
	height:300px;	
  margin-top: 100px;
  
  padding : 30px;
  border : 3px solid #009AFF;
  border-radius : 5px;
}

#zerotwo{
	
	padding-top : 55px;

}

</style>

</head>
<body>
	
	<jsp:include page="../include/top.jsp"/>
	
		
	<div align="center" id="zero" >
		<div id="zerotwo">
		<h3>주문이 완료되었습니다.</h3>
		<br>
		
		<a href="<%=request.getContextPath() %>/user_main.do" class="btn">메인 페이지</a> &nbsp; &nbsp; &nbsp;
		<a href="<%=request.getContextPath() %>/user_cart_list.do" class="btn">장바구니</a>
		</div>
	</div>
	
	
	
</body>
</html>