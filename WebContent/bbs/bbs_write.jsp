<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

	#tit {
		line-height: 20px;
		height: 25px;
	}

</style>
</head>
<body>

	<div align="center">
		<hr width="30%" color="marmoon">
			<h2>상품 관련 Q & A</h2>
		<hr width="30%" color="marmoon">
		<br>
		
		<!-- 로그인 한 상태로 작성하니까 작성자를 DB에서 가져와서 hidden으로 넘김 -->
		<form method="post"
			action="<%=request.getContextPath() %>/bbs_write_ok.do">
			
			<table border="0" cellspacing="0" width="600">
				<tr>
					<td>
						<span>제  목</span>
					</td>
				</tr>
				
				<tr>
					<td>
						<input id="tit" name="title" size="80" maxlength="30">
					</td>
				</tr>
				
				<tr>
					<td>
						<span>내  용</span>
					</td>
				</tr>
				
				<tr>
					<td>
						<textarea rows="30" cols="82" name="content"></textarea>
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="right">
						<input type="reset" value="CANCLE">&nbsp;&nbsp;&nbsp;
						<input type="submit" value="WRITE">
					</td>
				</tr>
		
			</table>
		
		</form>
	
	</div>

</body>
</html>