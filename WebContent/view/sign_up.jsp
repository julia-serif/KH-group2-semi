<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 창</title>
<script src="../js/signup.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
<style type="text/css">
html, body{
	background-color: rgb(241, 248, 244);
}
span{
	color:red;
	font-family: 11px;
}
.title{
	padding-top:5px;
	font-size: 15px;
}
#input1{
	display:inline;
 	width:121px;
 	height:40px;
}
#input2{
	display:inline;
 	width:185px;
 	height:40px;
}
#input{
height:40px;
}
#idck{
	float:right;
}
#appr{
font-size: 17px;
}
#button{
	padding: 5px 10px;
	background-color: white;
	font-size: 17px;
	color: black;
	text-decoration: none;
	border-radius: 3px;
}
</style>


<script type="text/javascript">
	$(function() {
		$("#idck").click(function() {
			$.ajax({
				url:"/KH-group2-semi/view/idcheck.jsp",
				dataType:"text",
				data: {id: $("#user_id").val()},
				success: function(data){
					$("#id_check").html(data);//innerhtml과 비슷 글자 넣기
					 $("#user_id").focus();
				},
				error: function(data){
					alert("통신 오류");
				},
			});
		});
		$("#seller").click(function() {
			$("#appr").show();
			$("#appr").html("[판매자의 경우 관리자의 승인을 기다려야 합니다!]");
		});
		$("#customer").click(function() {
			$("#appr").hide();
		});
});
</script>
</head>
<body>

	<div align="center">
		<br>
		<font>회원가입</font>
			<br>
			<a href="javascript:history.back();"><font style="font-size:14px">나가기</font></a>
			<br>
		<form action="<%=request.getContextPath() %>/sign_up.do" method="post">

			<table width="400px">
				<tr>
					<td class="title">아이디 &nbsp;
					<span id="id_check"></span>
					<input type="button" value="중복체크" id="idck">
					</td>
				</tr>
				<tr>
					<td><input class="form-control" type="text" placeholder="ID" name="id" id="user_id"></td>
				</tr>
				
				<tr>
					<td class="title">비밀번호</td>
				</tr>
				<tr>
					<td><input id="input" type="password" class="form-control" placeholder="PASSWORD" name="pwd"></td>
				</tr>

				<tr>
					<td class="title">이름</td>
				</tr>
				<tr>
					<td><input id="input" type="text" class="form-control" placeholder="NAME" name="name"></td>
				</tr>

				<tr>
					<td class="title">나이</td>
				</tr>
				<tr>
					<td><input id="input" type="text" class="form-control" placeholder="AGE" name="age"></td>
				</tr>

				<tr>
					<td class="title">전화번호</td>
				</tr>
				<tr>
					<td>
						<input class="form-control" id="input1" type="text" name="phone1" placeholder="010" size="6"> -
						<input class="form-control" id="input1" type="text" name="phone2" placeholder="0000" size="9">-
						<input class="form-control" id="input1" type="text" name="phone3" placeholder="0000" size="9">
					</td>
				</tr>

				<tr>
					<td class="title">이메일</td>
				</tr>
				<tr>
					<td>
						<input class="form-control" id="input2" type="text" placeholder="email1" name="email1" size="12">@
						<input class="form-control" id="input2" type="text" placeholder="email2" name="email2" size="18">
						
					</td>
					
				<tr>
					<td class="title">주소</td>
				</tr>	
				<tr>
					<td><input id="input" type="text" class="form-control" placeholder="ADDRESS" name="addr"></td>
				</tr>

				<tr>
					<td class="title">등급명</td>
				</tr>
				<tr>
					<td align="center">
						<input type="radio" name="grade" value="구매자" checked id="customer" >소비자
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="grade" value="판매자" id="seller">판매자
					</td>
				</tr>
					
					<tr>
						<td colspan="2">
						<span id="appr"></span>
							
						</td>
					</tr>
				<tr>
					<td colspan="2" align="center"><input style="float:right" type="submit"
						value="회원가입" id="button"></td>
				</tr>
			</table>
		</form>

	</div>
</body>
</html>
