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
		<c:set var="dto" value="${reply }"/>
		
		
			<h3>JSP_BBS 테이블 게시물 답변 글 폼 페이지</h3>
		
		<br>
		
		<form method="post"
			action="<%=request.getContextPath() %>/bbs_reply_ok.do">
		
			<input type="hidden" name="bbs_no" value="${dto.getBoard_no() }">
			<input type="hidden" name="bbs_group" value="${dto.getBoard_group() }">
			<input type="hidden" name="bbs_step" value="${dto.getBoard_step() }">
			<input type="hidden" name="bbs_indent" value="${dto.getBoard_indent() }">
			<input type="hidden" name="pno" value="${pno }">
			<table border="1" cellspacing="0" width="400">
				<tr>
					<th>작성자</th>
					<td><input name="reply_writer"
							value="관리자" readonly>
					</td>
				</tr>
				
				<tr>
					<th>제목</th>
					<td><input name="reply_title"
							value="(답변)${dto.getBoard_title() }" readonly>
					</td>
				</tr>
				
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="7" cols="30" name="reply_content"></textarea>
					</td>
				</tr>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="답변 글 등록">&nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시 작성">
					</td>			
				</tr>
			</table>
		
		</form>
		
	
	</div>

</body>
</html>