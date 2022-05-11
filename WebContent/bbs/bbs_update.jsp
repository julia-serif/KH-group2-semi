<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<c:set var="dto" value="${modify }"/>
		<h2>Q&A 수정 페이지</h2>
		
		<form method="post" 
			action="<%=request.getContextPath() %>/bbs_update_ok.do">
			
			<input type="hidden" name="bbs_no" value="${dto.getBoard_no() }">
			<table border="1" cellspacing="0" width="400">
				<tr>
					<th>작성자</th>
					<td><input name="writer"
							value="${dto.getBoard_writer() }" readonly>
					</td>
				</tr>
				
				<tr>
					<th>제목</th>
					<td><input name="title"
							value="${dto.getBoard_title() }">
					</td>
				</tr>
				
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="7" cols="30" name="content">${dto.getBoard_cont() }</textarea>
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="글 수정">&nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시 작성">
					</td>			
				</tr>
			</table>
		</form>
	</div>

</body>
</html>