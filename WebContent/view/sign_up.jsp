<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 창</title>

</head>
<body>

	<%--백그라운드 이미지 --%>
		<span><%--왼쪽: 쇼핑몰 이름 --%>
		~~쇼핑몰
		</span>
	<br>
	<br>
	<br>
	
	<%--실패 처리 해야함 --%>
<div align="center">
	<form action="<%=request.getContextPath() %>/sign_up.do" method="post">
		
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id"></td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd"></td>
			</tr>
			
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			
			<tr>
				<th>나이</th>
				<td><input type="text" name="age"></td>
			</tr>
			
			<tr>
				<th>전화번호</th>
				<td>
				<input type="text" name="phone1" value="010" size="1" maxlength="3">-<input type="text" name="phone2" size="3" maxlength="4">-<input type="text" name="phone3" size="3" maxlength="4">
				</td>
			</tr>
			
			<tr>
				<th>이메일</th>
				<td>
				<input type="text" name="email1" size="7"> @ 
				<input type="text" name="email2" size="7"> 
				</td>
				
			<tr>
				<th>주소</th>
				<td>
				<input type="text" name="addr">
				</td>
			</tr>
		
			
			<tr>
				<th>등급명</th>
				<td>
				<input type="radio" name="grade" value="구매자">구매자&nbsp;&nbsp; 
				<input type="radio" name="grade" value="판매자">판매자
				</td>				
			</tr>
			
			<tr>
				<td colspan="2">
					--판매자 일 경우 내용이 출력 @Ajax발생
					<br>
					--판매자인 경우 관리자의 승인이 필요합니다!!
				</td>
			</tr>
			<tr>
				<td colspan="2">
					--id,email,phone의 중복이 있을 경우 @Ajax발생
					<br>
					--중복발생!
				</td>
			</tr>
			
			<tr>
			<td colspan="2" align="center">
			<input type="submit" value="회원가입">
			</td>
			</tr>
		</table>
		</form>
		<button onclick="location.href='../main.jsp'"> 홈으로</button>
	</div>
</body>
</html>