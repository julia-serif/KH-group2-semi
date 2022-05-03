<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<hr width="65%" color="marmoon">
			<h3>카테고리 등록 폼 페이지</h3>
		<hr width="65%" color="marmoon">
		<br>
		
		<form method="post" 
			action="<%=request.getContextPath() %>/admin_car_input_ok.do">
			
			<table border="1" cellspacing="0" width="300">
				<tr>
					<th>카테고리 코드</th>
					<td><input name="cart_code"></td>
				</tr>
				
				<tr>
					<th>카테고리 이름</th>
					<td><input name="cart_name"></td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="등록">&nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시 작성">
					</td>
				</tr>
			</table>	
		</form>
	</div>

</body>
</html>