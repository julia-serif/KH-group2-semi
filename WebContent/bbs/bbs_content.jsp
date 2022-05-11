<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
	.btn-group .button {
	  background-color: gray; 
	  border: 1px solid black;
	  color: white;
	  padding: 7px 10px;
	  text-align: center;
	  text-decoration: none;
	  display: inline-block;
	  font-size: 12px;
	  cursor: pointer;
	}
	
	.btn-group .button:hover {
	  background-color: darkgray;
	}

</style>
</head>
<body>
	
	
	<div align="center">
		<h2>Q&A 상세 페이지</h2>
	   <c:set var="dto" value="${bCont }" />
	  	
	  
	   <table border="1" cellspacing="0" width="400">
	      <tr>
	         <th>작성자</th>
	      	 <td> ${dto.getBoard_writer() } </td>
	      </tr>
	      
	      <tr>
	         <th>글제목</th>
	      	 <td> ${dto.getBoard_title() } </td>
	      </tr>
	      
	      <tr>
	         <th>글내용</th>
	      	 <td>
	      	    <textarea rows="7" cols="25" readonly>${dto.getBoard_cont() }</textarea>
	         </td>
	      </tr>
	      
<%-- 	      <tr>
	         <th>비밀번호</th>
	         <td>
	            <c:if test="${!empty dto.getBoard_pwd() }">
	               <c:forEach begin="1" end="${dto.getBoard_pwd().length() }">
	               				*
	               </c:forEach>
	            </c:if>
	         </td>
	      </tr> --%>
	   	      
	      <tr>
	         <c:if test="${empty dto.getBoard_update() }">
	            <th>작성일자</th>
	            <td> ${dto.getBoard_date() } </td>
	         </c:if>
	      
	         <c:if test="${!empty dto.getBoard_update() }">
	            <th>수정일자</th>
	            <td> ${dto.getBoard_update() } </td>
	         </c:if>
	      </tr>
	      
	      <c:if test="${empty dto }">
	         <tr>
	            <td colspan="2" align="center">
	               <h3>검색된 게시물이 없습니다.....</h3>
	            </td>
	         </tr>
	      </c:if>
	      
	      <tr class="btn-group">
	         <td colspan="2" align="center">
	            <input type="button" value="글수정" class="button"
	               onclick="location.href='bbs_update.do?no=${dto.getBoard_no() }'">
	      
	            <input type="button" value="글삭제" class="button"
	               onclick="if(confirm('게시글을 삭제하시겠습니까?')) {
	            	   			location.href='bbs_delete.do?no=${dto.getBoard_no() }'
	               			}else {  return;  }">
	      
	            <input type="button" value="답변글" class="button"
	               onclick="location.href='bbs_reply.do?no=${dto.getBoard_no() }'">
	                
	            <input type="button" value="목록으로" class="button"
	            	onclick="location.href='user_product_view.do?pno=${dto.getBoard_product() }'">
	            
	      
	      		
	         </td>
	      </tr>
	   </table>
	
	</div>

</body>
</html>