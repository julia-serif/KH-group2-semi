<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
	pageEncoding="UTF-8"%>
=======
    pageEncoding="UTF-8"%>
>>>>>>> 13dca13c916d9ea2dd070dc26f6c6a7a81e3c77d
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<<<<<<< HEAD
<title>관리자 페이지</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css"
	rel="stylesheet">
<style>
#login-form>div {
	margin: 20px 0;
}

body {
	padding-top: 200px;
}
</style>

</head>
<body>
	<div align="center">
		<div class="container">
			<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<div class="panel panel-success">
					<div class="panel-heading">
						<div class="panel-title">oo쇼핑몰에 오신 것을 환영합니다!</div>
					</div>
					<div class="panel-body">
						<form id="login-form" method="post"
							action="<%=request.getContextPath()%>/sign_in_ok.do">

							<div>
								<input type="text" class="form-control" name="id"
									placeholder="UserId" autofocus>
							</div>
							<div>
								<input type="password" class="form-control" name="pwd"
									placeholder="Password">
							</div>
							<div>
								<button type="submit" class="form-control btn btn-primary">로그인</button>
							</div>

						</form>
						<div>
							<button onclick="location.href='../main.jsp'"
								class="form-control btn btn-primary">홈으로</button>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>
=======
<title>로그인 페이지</title>
</head>
<body>

	<%--백그라운드 이미지 --%>
		<span><%--왼쪽: 쇼핑몰 이름 --%>
		~~쇼핑몰
		</span>
	<br>
	<br>
	<br>
	   <div align="center">
	   <form method="post"
	      action="<%=request.getContextPath() %>/sign_in_ok.do">
	   
	      <table border="1" cellspacing="0">
	         <tr>
	            <th>사용자 아이디</th>
	            <td> <input name="id"> </td>
	         </tr>
	         
	         <tr>
	         	<th>사용자 비밀번호</th>
	         	<td> <input type="password" name="pwd"> </td>
	         </tr>
	         
	         <tr>
	            <td colspan="2" align="center">
	               <input type="submit" value="로그인">
	            </td>
	         </tr>
	         
	      </table>
	   
	   </form>
	<button onclick="location.href='../main.jsp'"> 홈으로</button>
	</div>
	
</body>
</html>
>>>>>>> 13dca13c916d9ea2dd070dc26f6c6a7a81e3c77d
