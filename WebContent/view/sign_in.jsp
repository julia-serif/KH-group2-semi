<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>

	<%--백그라운드 이미지 --%>
		<span><%--왼쪽: 쇼핑몰 이름 --%>
		~~쇼핑몰
		</span>
	<br>
	<br>
	<br>
	   <div align="center">
	   <form method="post"
	      action="<%=request.getContextPath() %>/sign_in_ok.do">
	   
	      <table border="1" cellspacing="0">
	         <tr>
	            <th>사용자 아이디</th>
	            <td> <input name="id"> </td>
	         </tr>
	         
	         <tr>
	         	<th>사용자 비밀번호</th>
	         	<td> <input type="password" name="pwd"> </td>
	         </tr>
	         
	         <tr>
	            <td colspan="2" align="center">
	               <input type="submit" value="로그인">
	            </td>
	         </tr>
	         
	      </table>
	   
	   </form>
	<button onclick="location.href='../main.jsp'"> 홈으로</button>
	</div>
	
</body>
</html>