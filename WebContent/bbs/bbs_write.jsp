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
	
	#writer {
		line-height: 20px;
		height: 25px;
	}
	
	.btn-group .button {
	  background-color: #4CAF50; /* Green */
	  border: none;
	  color: white;
	  padding: 15px 20px;
	  text-align: center;
	  text-decoration: none;
	  display: inline-block;
	  font-size: 16px;
	  cursor: pointer;
	  float: right;
	}
	
	.btn-group .button:hover {
	  background-color: #3e8e41;
	  clear: both;
	}

</style>
</head>
<body>

	<div align="center">

			<h2>상품 관련 Q & A</h2>
		<br>
		
		
		<form method="post"
			action="<%=request.getContextPath() %>/bbs_write_ok.do">
			
			
			<input type="hidden" name="pno" value="${pno }">
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
						<span>작성자</span>
					</td>
				</tr>
				
				<tr>
					<td>
						<input id="writer" name="writer" size="50" maxlength="30">
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
				
				
				<tr class="btn-group">
					<td colspan="2" align="right">
						<input type="reset" value="다시작성" class="button">&nbsp;&nbsp;&nbsp;
						<input type="submit" value="문의하기" class="button">
					</td>
				</tr>
		
			</table>
		
		</form>
	
	</div>

</body>
</html>