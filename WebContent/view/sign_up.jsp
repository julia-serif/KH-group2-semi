<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 창</title>
<script src="../js/signup.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css"
	rel="stylesheet">
<style type="text/css">

body, html {
margin-top: 10px;
width: 100%;
height: 100%;
background-color: rgb(241, 248, 244);
}
.input{
border: 0.5px solid lightgray;
border-radius: 4px;
height: 40px;
}
.title{
font-size: 13px;
font-family: 명조;
}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
	let idck=0;
	$("#idck").click(function() {
        
        //userid 를 param.
        var userid =  $("#user_id").val();
       
        $.ajax({
            async: true,
            type : 'POST',
            data : userid,
            url : "idcheck.do",
            dataType : "json",
            contentType: "application/json; charset=UTF-8",
            success : function(data) {
            	 if (data.cnt > 0) {
                     
                     alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
            }else {
                alert("사용가능한 아이디입니다.");
                idck=1;
            }
            },
            error : function(error) {
                
                alert("error : " + error);
            }
        });
    });
});
</script>
</head>
<body>

	<div align="center">
		<h3>쇼핑몰</h3>
		<form action="<%=request.getContextPath() %>/sign_up.do" method="post">

			<table width="400px">
				<tr>
					<td class="title">아이디 &nbsp;
					<input type="button" value="중복체크" id="idck">
					<span id="id_check"></span>
					</td>
				</tr>
				<tr>
					<td><input class="form-control" type="text" placeholder="ID" name="id" id="user_id">
				</tr>
				
				<tr>
					<td class="title">비밀번호</td>
				</tr>
				<tr>
					<td><input type="password" class="form-control" placeholder="PASSWORD" name="pwd"></td>
				</tr>

				<tr>
					<td class="title">이름</td>
				</tr>
				<tr>
					<td><input type="text" class="form-control" placeholder="NAME" name="name"></td>
				</tr>

				<tr>
					<td class="title">나이</td>
				</tr>
				<tr>
					<td><input type="text" class="form-control" placeholder="AGE" name="age"></td>
				</tr>

				<tr>
					<td class="title">전화번호</td>
				</tr>
				<tr>
					<td>
						<input class="input" type="text" name="phone1" placeholder="010" size="6"> -
						<input class="input" type="text" name="phone2" placeholder="0000" size="9">-
						<input class="input" type="text" name="phone3" placeholder="0000" size="9">
					</td>
				</tr>

				<tr>
					<td class="title">이메일</td>
				</tr>
				<tr>
					<td>
						<input class="input" type="text" placeholder="email1" name="email1" size="12">@
						<input class="input" type="text" placeholder="email2" name="email2" size="18">
						
					</td>
					
				<tr>
					<td class="title">주소</td>
				</tr>	
				<tr>
					<td><input type="text" class="form-control" placeholder="ADDRESS" name="addr"></td>
				</tr>

				<tr>
					<td class="title">등급명</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;
						<input type="radio" name="grade" value="구매자" checked>구매자&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="grade" value="판매자">판매자
					</td>
				</tr>
					
					<tr>
						<td colspan="2">
						<span id="idcheck">
						</span>
						
						--판매자 일 경우 내용이 출력 @Ajax발생 <br> --판매자인 경우
							관리자의 승인이 필요합니다!!
						</td>
					</tr>
					<tr>
						<td colspan="2">
						<span>
						</span>
						--id,email,phone의 중복이 있을 경우 @Ajax발생 <br>
							--중복발생!
						</td>
					</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="회원가입"></td>
				</tr>
			</table>
		</form>
		<br>
		<button onclick="location.href='../main.jsp'">메인화면</button>
	</div>
</body>
</html>