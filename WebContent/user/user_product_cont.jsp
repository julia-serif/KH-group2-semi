<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function goCart() {
		
		document.form.action="<%=request.getContextPath() %>/user_cart_add.do";
		
		document.form.submit();
	}

</script>
<link rel="stylesheet" href="css/product_cont.css" type="text/css">
</head>
<body>
	
	<!-- header -->
	
	<div align="center">
	
		<c:set var="dto" value="${pCont }"/>
		<c:if test="${!empty dto }">
			
			<table border="0" cellspacing="0" width="800">
				<tr>
					<td colspan="2" align="center" height="30"></td>
				</tr>
				
				<tr>
					<td align="center">
						<img src="<%=request.getContextPath() %>/upload/${dto.getPimage() }"
							width="225" height="300">
					</td>
					
					<td>
						<form method="post" name="form">
							<table border="0" cellspacing="0">
								<tr>
									<td>${dto.getPcompany() }</td>
								</tr>
								
								<tr>
									<td>${dto.getPname() }</td>
								</tr>
								
								<tr>
									<td colspan="2" align="center" height="20"></td>
								</tr>
								
								<tr>
									<td>${dto.getPrice() } 원</td>
								</tr>
								
								<tr>
									<td colspan="2" align="center" height="20"></td>
								</tr>
								
								<tr>
									<td>${dto.getPcontents() }</td>
								</tr>
																								
								<tr>
									<td colspan="2" align="center" height="20"></td>
								</tr>
							
								
									
							</table>
							
							<table border="0" cellspacing="0" width="85%" align="center">
								<tr>
									<td align="left" style="padding-left: 3px;">
										<input type="number" name="p_qty"
											min="1" max="50" value="1">
									</td>
								</tr>
								
								<tr>
									<td align="left">
										<a href="javascript:goCart()">
											<img src="<%=request.getContextPath() %>/uploadfile/1.PNG"
												border="0">
										</a>								
									</td>
								
									<td align="left">
										<a href="#">
											<img src="<%=request.getContextPath() %>/uploadfile/2.PNG"
												border="0">
										</a>								
									</td>
								</tr>			
							</table>
						</form>
					</td>
				</tr>
			</table>
			
			<br><br><br>
			
			
			<table border="1" cellspacing="0" width="650" id="bbs_list">
			<tr>
				<th>번호</th> <th>제목</th> <th>작성자</th> <th>작성일자</th>
			</tr>
			
			<c:set var="list" value="${List }"/>
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
					<tr align="center">
						<td>${dto.getBoard_no() }</td>
						<td>
							<%-- 답변인 경우 --%>
							<c:if test="${dto.getBoard_indent() != 0 }">
								<c:forEach begin="1" end="${dto.getBoard_indent() }">
									☞
								</c:forEach>
							</c:if>
							<a href="<%=request.getContextPath() %>/bbs_content.do?no=${dto.getBoard_no() }">
							${dto.getBoard_title() }</a>
						</td>
						<td>${dto.getBoard_writer() }</td>
						<td>${dto.getBoard_date().substring(0, 10) }</td>
					</tr>
				</c:forEach>
			</c:if>

			
			<c:if test="${empty list }">
				<tr>
					<td colspan="5" align="center">
						<h3>검색된 게시물이 없습니다.</h3>
					</td>
				</tr>
			</c:if>
						
			<tr>
				<td colspan="5" align="right">
					<input type="button" value="글 쓰기"
						onclick="location.href='bbs_write.do'">
				</td>			
			</tr>
			
		</table>
		
		
			<c:if test="${page > block }">
				<a href="user_bbs_list.do?page=1">◀◀</a>
				<a href="user_bbs_list.do?page=${startBlock - 1 }">◀</a>
			</c:if>
			
			<c:forEach begin="${startBlock }" end="${endBlock }" var="i">
				
				<c:if test="${i == page }">
					<b><a href="user_bbs_list.do?page=${i }">[${i }]</a></b>
				</c:if>
				
				<c:if test="${i != page }">
					<a href="user_bbs_list.do?page=${i }">[${i }]</a>
				</c:if>
				
			</c:forEach>
			
			<c:if test="${endBlock < allPage }">
				<a href="user_bbs_list.do?page=${endBlock + 1 }">▶</a>
				<a href="user_bbs_list.do?page=${allPage }">▶▶</a>
			</c:if>
	
		
		<br> <br>
		
		
		<ul class="qna">
            <li>
                <input type="checkbox" id="qna_1">
                <label for="qna_1">FAQ1</label>
                <div>
                    <p>질문1</p>
                </div>
            </li>
            <li>
                <input type="checkbox" id="qna_2">
                <label for="qna_2">FQA2</label>
                <div>
                    <p>질문2</p>
                    
                </div>
            </li>
            <li>
                <input type="checkbox" id="qna_3">
                <label for="qna_3">FAQ3</label>
                <div>
                    <p>질문3</p>
                   
                </div>
            </li>
            <li>
                <input type="checkbox" id="qna_4">
                <label for="qna_4">FAQ4</label>
                <div>
                    <p>질문4</p>
                   
                </div>
            </li>
        </ul>
			
	</c:if>	
	</div>
	
	<!-- footer -->

</body>
</html>