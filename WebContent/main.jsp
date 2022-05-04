<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑몰</title>
</head>

<body>
	<div>
	<%--백그라운드 이미지--%>
	<div>
		<span><%--왼쪽: 쇼핑몰 이름 --%>
		
		</span>
		
		<span><%--오른쪽: 로그인 --%>
			<a href="view/sign_in.jsp">
				<button>로그인</button>
			</a>
		</span>
		
	</div>
		<div align="center">
			<%-- 쇼핑몰 소개 --%>
			
			<br><br><br>
			
			<a href="view/sign_up.jsp">
				<button>회원가입</button>
			</a>
			<br>
			<br>
			확인용
			<br>
			<a href="<%=request.getContextPath()%>/select.do">회원 리스트보기</a>
		</div>

	</div>
</body>
</html>