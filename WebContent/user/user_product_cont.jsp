<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript" src="js/paging.js"></script>
<style type="text/css">

	#bbs_list {
	  border-collapse: collapse;
	  width: 50%;
	}
	
	#bbs_list th, td {
	  text-align: left;
	  padding: 8px;
	}
	
	#bbs_list tr:nth-child(even){background-color: white;}
	
	#bbs_list th {
	  background-color: skyblue;
	  color: white;
	}
	

</style>
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
										<a href="#">
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
				<th>제목</th> <th>작성자</th> <th>작성일자</th>
			</tr>
			
			<c:set var="list" value="${List }"/>
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
					<tr align="center">
						<td>
							<%-- 답변인 경우 --%>
							<c:if test="${dto.getBoard_indent() != 0 }">
								<c:forEach begin="1" end="${dto.getBoard_indent() }">
									↳
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
					<td colspan="3" align="center">
						<h3>검색된 게시물이 없습니다.</h3>
					</td>
				</tr>
			</c:if>
			
			<tr id="qna">
				<td colspan="3" align="right">
					<input type="button" value="문의하기"
						onclick="location.href='bbs_write.do?pno=${pno }'">
				</td>
			</tr>
			
		</table>
		
		<br> <br>
		
		<input type="button" value="목록으로"
	            	onclick="location.href='user_main.do'">
	            
		
		<ul class="qna">
            <li>
                <input type="checkbox" id="qna_1">
                <label for="qna_1">상품 취소/반품</label>
                <div>
                    <p>구매한 상품의 취소/반품은 마이페이지 구매내역에서 신청 </p>
                    <p>가능합니다. 상품문의 및 후기게시판을 통해 취소나 환불, </p>
                    <p>반품 등은 처리되지 않습니다.</p>
                </div>
            </li>
            <li>
                <input type="checkbox" id="qna_2">
                <label for="qna_2">교환/환불 및 배송등 상품 자체와 관련 없는 문의</label>
                <div>
                    <p>가격, 판매자, 교환/환불 및 배송 등 해당 상품 자체와 관련 </p>
                    <p>없는 문의는 고객센터 내 1:1 문의하기를 이용해주세요.</p>
                </div>
            </li>
            <li>
                <input type="checkbox" id="qna_3">
                <label for="qna_3">배송 소요일</label>
                <div>
                    <p>배송을 시작한 상품이 고객님들께 도착하는 시간은 약 2~3일 </p>
                    <p>정도 소요됩니다. </p>
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