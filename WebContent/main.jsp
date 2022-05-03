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
		<h3>판매자 로그인</h3>
		<form method="post" action="<%=request.getContextPath()%>/seller_order_manage.do">
			<table border="1" cellspacing="0" width="350">
				<tr>
					<th>판매자 아이디</th>
					<td> <input name="seller_id"> </td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="로그인">
					</td>
			</table>
		</form>
	</div>
</body>
</html>