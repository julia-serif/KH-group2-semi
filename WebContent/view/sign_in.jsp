<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
