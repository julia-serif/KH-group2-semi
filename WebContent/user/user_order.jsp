<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery 선언  -->
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>


<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>


<script type="text/javascript">

$(function(){

   // 여러 ajax에서 동일하게 사용되는 속성 설정
   $.ajaxSetup({
      // ajax에서 한글 깨짐 문제 해결
      ContentType : "application/x-www-form-urlencoded;charset=UTF-8",
      type :"post"
   });
	
   
 	//회원 정보와 동일 버튼 클릭시 기존 회원 정보 삽입
   $("input[name=userAddrButton]").on("click", loadUserInfo);
	
 	//주소 검색 버튼 클릭시 카카오 api 실행
   $("#addrButton").on("click", sample6_execDaumPostcode);
   
 	
  	
   setTotalInfo();
});




function pointBox(val){
	
	var usePoint = val;
	var nowPoint = parseInt($("input[name=nowPoint]").val());
	
	if(usePoint > nowPoint) {
		
		alert("사용 가능한 포인트는" + nowPoint +" 포인트 입니다.");
		$("#usePoint").val("");
		setTotalInfo();
		
	}else {
		
		let totalPrice = 0;			//개당 총 가격
		let onePrice = 0;			//개당 가격
		let oneAmt = 0;				//개당 갯수
		let totalCount = 0;			//총 갯수
		let totalPoint = 0;			//총 포인트
		let shippingPrice = 0;		//배송비
		let allTotalPrice = 0; 		//최종 가격
		
		var len = $("input[name=oPrice]").length;
		
		var Parr = [];	//개당 가격
		var Iarr = [];	//개당 포인트
		var Aarr = new Array;	//갯수
		
		for(var i =0; i<len; i++){
			
			Parr.push($("input[name=oPrice]").eq(i).val());

			Aarr.push($("input[name=toAmt]").eq(i).val());
			
			totalPrice += Parr[i] * Aarr[i];
			
			totalPoint += Parr[i] * Aarr[i] * 0.01;
			
		} 	
		
		//배송비
		if(totalPrice >= 50000){
			shippingPrice = 0;
		}else if(totalPrice == 0){
			shippingPrice = 0;
		}else {
			shippingPrice = 4000;
		}
		

		//전체금액
		allTotalPrice = totalPrice + shippingPrice - usePoint; 
		
		// 총 가격
		$(".totalPrice_span").text(totalPrice.toLocaleString());
		// 총 갯수
		$(".totalCount_span").text(totalCount);
		// 총 포인트
		$(".totalPoint_span").text((totalPoint - usePoint).toLocaleString());
		// 배송비
		$(".shippingPrice_span").text(shippingPrice);	
		// 최종 가격(총 가격 + 배송비)
		$(".allTotalPrice_span").text(allTotalPrice.toLocaleString());	
		
	}
	
	console.log(nowPoint);
	
	
	
}


function requestPay() {
		
	if($("input[name=nameAddr]").val() === ""){
		alert("이름을 입력하세요");
		$("input[name=nameAddr]").focus();
		return false;
	}else if($("input[name=phoneAddr]").val() === ""){
		alert("연락처 입력하세요");
		$("input[name=phoneAddr]").focus();
		return false;
	}else if($("input[name=addr]").val() === ""){
		alert("주소를 입력하세요");
		$("input[name=addr]").focus();
		return false;
	}

		let mail = $("input[name=email]").val();		//주문자 이메일
		let name = $("input[name=userName]").val();		//주문자 이름
		let userAddr = $("input[name=userAddr]").val();		//주문자 주소
		let phone = $("input[name=userPhone]").val();	//주문자 전화번호
		let id = $("input[name=userId]").val();			//주문자 아이디
		
		let nameAddr = $("input[name=nameAddr]").val();		//받는사람 이름
		let phoneAddr = $("input[name=phoneAddr]").val();	//받는사람 전화번호
		let addr = $("input[name=addr]").val();				//받는사람 주소
		
		
		let usePoint = $("#usePoint").val(); 				//사용할 포인트
		let savePoint = $(".totalPoint_span").text();		//적립예정 포인트
		let allTotalPrice = $(".allTotalPrice_span").text(); 	//최종 결제 가격
		
		var cartNum = new Array;
		var pnum = new Array;
	 	var pqty = new Array;
	 	var pPrice = new Array;
		var seller = [];
	 	
		for(let i=0; i<$("input[name=pnum]").length; i++){   
			
			pnum.push($("input[name=pnum]").eq(i).val());
			pqty.push($("input[name=pqty]").eq(i).val());
			pPrice.push($("input[name=pPrice]").eq(i).val());
			seller.push($("input[name=seller]").eq(i).val());
			cartNum.push($("input[name=cartnum]").eq(i).val());
		} 
		console.log("cartnum: " + cartNum);
		
	
		 var IMP = window.IMP; 
		IMP.init('imp49649531');
		
		    IMP.request_pay({
		        pg: 'inicis',
		        pay_method: 'card',
		        merchant_uid: new Date().getTime(),
		        name: name + "님의 주문",
		        amount: 100,		//가격
		        buyer_email: mail,
		        buyer_name: name,
		        buyer_tel: phone,
		        buyer_addr: userAddr,
		        buyer_postcode: userAddr.substr(1,6)
		  
		    }, function (rsp) {
		    	console.log(rsp);
		    	if (rsp.success) {
		            // 결제 성공 시 로직,
		            var msg = '결제가 완료되었습니다.';
		            msg += '고유ID : ' + rsp.imp_uid;  
					msg += '주문 번호 : ' + rsp.merchant_uid; 
					msg += '결제 금액 : ' + rsp.paid_amount; 
					msg += '카드 승인번호 : ' + rsp.apply_num; 
					
					var dataTemp = {
			       			email : mail,
			       			name : name,
			       			userAddr : userAddr,
			       			phone : phone,
			       			id : id,
			       			nameAddr : nameAddr,
			       			phoneAddr : phoneAddr,
			       			addr : addr,
			       			usePoint : usePoint,
			       			savePoint : savePoint,
			       			allTotalPrice : allTotalPrice,
			       			pnum : pnum,
			       			pqty : pqty,
			       			pPrice : pPrice,
			       			seller : seller,
			       			merchant_uid: new Date().getTime(),
							cartno : cartNum
			       		};
					console.log(dataTemp);
					$.ajax({
		           		url: "<c:url value='/user_placeOrder.do'/>",
		           		type:"get" ,
		           		datatype : "get",
		           		data : dataTemp,
		          	 	success : function(data){
		           			
		          	 		if(data == 1){
		          	 			alert(msg);
		          	 			location.replace("<c:url value='/user/user_orderComplete.jsp'/>");
		          	 		}
		           		
		           		}
		           		
		           	});
	           
	           
	       	 	} else {
	           		
	            // 결제 실패 시 로직,
	            	alert("결제에 실패했습니다.")	
	            	msg += '에러내용 : ' + rsq.error_msg;
	      		}
	  	  });
	 
	
  
  }


//회원 정보와 동일 버튼 클릭시 기존 회원 정보 삽입
function loadUserInfo(){
	
	$("input[name=nameAddr]").val($("input[name=userName]").val()); 
	$("input[name=phoneAddr]").val($("input[name=userPhone]").val()); 
	$("input[name=addr]").val($("input[name=userAddr]").val()); 
	
}

//주소 검색 버튼 클릭시 카카오 api 실행
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
           
            var addrD = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addrD = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addrD = data.jibunAddress;
            }

          
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                $("input[name=addr]").val("(" + data.zonecode + ")" + addrD + extraAddr ).focus();
            
            } else {
            	$("input[name=addr]").val() = '';
            }

        }
    }).open();
}

function setTotalInfo() {
	
	let totalPrice = 0;			//개당 총 가격
	let onePrice = 0;			//개당 가격
	let oneAmt = 0;				//개당 갯수
	let totalCount = 0;			//총 갯수
	let totalPoint = 0;			//총 포인트
	let shippingPrice = 0;		//배송비
	let allTotalPrice = 0; 		//최종 가격
	
	
	var len = $("input[name=oPrice]").length;
	
	var Parr = [];	//개당 가격
	var Iarr = [];	//개당 포인트
	var Aarr = new Array;	//갯수
	
	for(var i =0; i<len; i++){
		
		//.push(값) : 배열에 추가 ※
		Parr.push($("input[name=oPrice]").eq(i).val());
		
		Aarr.push($("input[name=toAmt]").eq(i).val());
		
		totalPrice += Parr[i] * Aarr[i];
		
		totalPoint += Parr[i] * Aarr[i] * 0.01;
		
	} 	
	
		

	//배송비
	if(totalPrice >= 50000){
		shippingPrice = 0;
	}else if(totalPrice == 0){
		shippingPrice = 0;
	}else {
		shippingPrice = 4000;
	}
	

	
	//전체금액
	allTotalPrice = totalPrice + shippingPrice; 
	
	/* 세자리 콤마 Javascript Number 객체의 toLocaleString() */
	// 총 가격
	$(".totalPrice_span").text(totalPrice.toLocaleString());
	// 총 갯수
	$(".totalCount_span").text(totalCount);
	// 총 포인트
	$(".totalPoint_span").text(totalPoint.toLocaleString());
	// 배송비
	$(".shippingPrice_span").text(shippingPrice);	
	// 최종 가격(총 가격 + 배송비)
	$(".allTotalPrice_span").text(allTotalPrice.toLocaleString());	
}

</script>

<style>
	
.img {
    width: 100px;
    height: 100px; 
    border-radius: 30%;
    overflow: hidden;
}
.productImage {
    width: 100%;
    height: 100%;
    object-fit: cover;
}

.tableShipL{
	align:left;
	width: 700px; 
	
}

.tableShipR{
	align:left;
	width: 300px; 
	margin: 10px;
}

input:focus {outline:none;}


/* number의 증가 감소 버튼 없애기 */
input[type="number"]::-webkit-outer-spin-button,
input[type="number"]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}

table {
	border-collapse: collapse;
	border-color: F3F3F3;
	width:1000px;
	border: none;
}

.tableShipL {
	padding-left: 10px;
	padding-bottom: 10px;
}

.addrinput {

	height:17px;
	font-size:16px;
	border: none;
	background-color: f3f3f3; 
	width: 500px;
	
}

#addrdiv1 {
	
	display : flex;
	float : left;
	margin-top : 50px;
	width: 70%;
	
}

#addrdiv2 {
	
	display : flex;
	left : 70%;
	right: 28%;
	float : left;
	width: 28%;
	margin-top : 50px;
	margin-left: 20px;
} 

#tableDiv {
	
	width : 1000px;
	display : flex;
	margin-left: auto;
	margin-right: auto; 
	
	
}

.pad{
	
	border: 0;
	padding-left: 20px;
	
}

#tableO1{
	border : none;
	font-size: 16px;
	border :1px;
	left : 70%;
	float : left;
	margin-top : 10px;
	width: 70%;
	padding-left: 10px;
}



#tableO2{
	
	border : none;
	padding-top : 51px;
	display : flex;
	float : left;
	width:28%;
	margin-top : 10px;
	margin-left: 30px;
	
}

#tableDiv2 {
	
	
	margin-bottom : 100px;
	width : 1000px;
	display : flex;
	margin-left: auto;
	margin-right: auto; 
	
}

.payButton {
	
	
	padding-top : 16px;
	padding-right : 35px;
	width : 250px;
	border : 0;
	color: #fff;
	background-color: red;
	font-size:18px;
	font-weight:600;
	cursor: pointer;
	float: right;
	
}

#divB {
	
	margin-top : 100px;
	display: block;
	margin-left : 30px;
	width : 100%;
	height : 60px;
	border : 1px;
	box-sizing : border-box;
	background-color : red;
	
	float: right;

}


#usePoint {
	
	border : none;

}

.button{
	
	border-width : thin;
	background-color: #f3f3f3;	
	cursor: pointer;
	
}

.button:hover {
  color : white;
  background-color: black;
  
}



</style>

</head>
<body>
	<jsp:include page="../include/top.jsp"/>
	
	<form method="post">
	<c:set var="list" value="${cartList }"/>
	<c:set var="dtoU" value="${userInfo }"/>
	
	<table border="0" align="center" style="margin-top: 30px; ">
	
		<tr>
			<td colspan="7" class="center" align="center" >
				<p>장바구니 > <b>주문/결제</b> > 완료<p>
			</td> 
		</tr>
	</table>
	
	<table border="1" align="center" style="margin-top: 30px; border-color: F3F3F3;" >
	
		<tr height="50" bgcolor="F3F3F3" style="border: none;">
			<th width="300px" colspan="2">상품 정보</th> <th>판매자</th> <th width="12%">판매가</th>  
			<th width="10%">수  량</th> <th width="12%">포인트</th> <th width="12%">합  계</th> 
		</tr>
 		<c:if test="${!empty list }">
 			
 			<c:forEach items="${list }" var="dto" >
				<c:set var="price" value="${dto.getCart_price() }" />
				<c:set var="amount" value="${dto.getCart_pqty() }" />
				<input type="hidden" name="oPrice" value="${dto.getCart_price() }"/>
				<input type="hidden" name="toPrice" value="${price * amount }"/>
				<input type="hidden" name="toPoint" value="${price * amount  * 0.01 }"/>
				<input type="hidden" name="toAmt" value="${dto.getCart_pqty() }"/>
				<input type="hidden" name="nowPoint" value="${dtoU.getUser_mileage() }"/>
				<input type="hidden" name="email" value="${dtoU.getUser_email() }"/>
				<input type="hidden" name="seller" value="${dto.getCart_seller() }"/>
				<input type="hidden" name="pnum" value="${dto.getCart_pnum() }"/>
				<input type="hidden" name="pqty" value="${dto.getCart_pqty() }"/>
				<input type="hidden" name="pPrice" value="${dto.getCart_price() }"/>
				<input type="hidden" name="cartnum" value="${dto.getCart_num() }"/>
				
				
				
				
				<tr align="center" style="border-color: F3F3F3;">	
					<td class="center" width="150px" style="border-right: 0px;">
					<div class="img" >
						<img src="<%=request.getContextPath() %>/upload/${dto.getCart_pimage() }"
							class="productImage" >
					</div>		
					</td>
					<td class="center" style="border-left: 0px;">${dto.getCart_pname() }</td>
					<td class="center" >${dto.getCart_seller() }</td>
					<td class="center" >
						<fmt:formatNumber value="${dto.getCart_price() }" />원
					</td>
					
					
					<td class="center">
						<p>${amount }</p>
					</td>
					
					<td class="center">
						<fmt:formatNumber value="${price * amount  * 0.01 }" />원
					</td>
					
					<td class="center">
						<fmt:formatNumber value="${price * amount }"/>원
					</td>
				</tr>
			</c:forEach>
		</c:if>	
		<c:if test="${empty list }">
			<tr>
			<td colspan="7" class="center" align="center">
				<h3>주문 목록이 없습니다.</h3>
			</td> 
		</tr>
		</c:if>
		
	</table>
	
	<div id="tableDiv">
	<table border="1" id="addrdiv1" >
		<tr>
			<td class="tableShipL" bgcolor="F3F3F3">
				<h4>배송지정보</h4>
			</td> 

		</tr>
		
		<tr>
			<td class="tableShipL" class="pad"  style="padding-left: 10px; padding-top: 10px; padding-bottom: 10px;">
				<%-- sesseion.setAttribute로 설정한  ("userId", dto.getUser_id()); 를 가져옴 --%>
				<input type="hidden" name="userAddr" value="${dtoU.getUser_addr() }">
				<input type="hidden" name="userPhone" value="${dtoU.getUser_phone() }">
				<input type="hidden" name="userName" value="${dtoU.getUser_name() }">
				<input type="hidden" name="userId" value="${user_id }">
				<input type="button" class="button" name="userAddrButton" value="회원 정보와 동일">
				<input type="reset"  class="button" name="resetButton" value="다시작성">
			</td>

		</tr>
		
		<tr>
			<td class="tableShipL" >
				<label><p>받으시는 분</p>
				<input type="text" class="addrinput" name="nameAddr"  placeholder="이름 입력"
							onfocus="placeholder = ''" onblur="placeholder = '이름 입력'"></label>
			</td>
		</tr>
		
		<tr>
			<td class="tableShipL">
				<label><p>연락처</p>
				<input type="text" class="addrinput" name="phoneAddr"  placeholder="전화번호 입력"
						onfocus="placeholder = ''" onblur="placeholder = '전화번호 입력'"></label>
			</td>
		</tr>
		
		<tr>
			<td class="tableShipL" colspan="2">
				<p>주  소 <input type="button"  class="button" id="addrButton" value="주소검색" ></p>
				<input type="text" class="addrinput" name="addr" onfocus="placeholder = ''" 
							placeholder="상세주소까지 입력" onblur="placeholder = '상세주소까지 입력'">
			</td>
		</tr>
		
	</table>
	
	
	
	<table border="1" id="addrdiv2" >
		<tr bgcolor="F3F3F3">
			<td class="tableShipR" class="pad" style="padding-left :10px;">
				<h4 class="pad1">주문자 정보</h4 >
			</td> 
			<tr>
			<td class="tableShipR" rowspan="3" style="padding :10px;">
				<p><b>${dtoU.getUser_name() }</b></p>
				<p><b>${dtoU.getUser_phone() }</b></p>
				<p><b>${dtoU.getUser_email() }</b></p>
			</td>
		</tr>
	</table>	
	</div>

	
	<table border="0" style="width: 1000px; margin-top: 80px;" align="center">
		<tr >
			<td colspan="6" class="center" align="center"style="display: inline; padding-left: 10px;">
				<h4 style="display: inline;">결제내역</h4>
			</td> 
		</tr>
		
	</table>
	
	<div id="tableDiv2">
	<table border="1" id ="tableO1" width="700px" >
		
		<tr>
			<td align="left"  style="padding-left: 10px; padding-top: 10px; padding-bottom: 10px;">
				<b>총 상품가격 :</b>
			</td>
			<td align="right"  style="padding-right :10px;">
				<span class="totalPrice_span"></span>원
			</td>
		</tr>
			<tr align="left" >
			<td style="padding-left: 10px; padding-top: 10px; padding-bottom: 10px;">
				<span><b>사용 가능 포인트</b> (${dtoU.getUser_mileage() } 원) <b>:</b></span>
			</td>
			<td align="right" style="padding-right :10px;">
				<!-- oninput="this.value = this.value.replaceAll(/\D/g, '')" 숫자만 입력되게함  -->
				<input type="number" id="usePoint"  onfocus="placeholder = ''"  oninput="this.value = this.value.replaceAll(/\D/g, '')"
						onkeyup="pointBox(this.value)" style="text-align: right"
						placeholder="사용할 포인트 입력" onblur="placeholder = '사용할 포인트 입력'">
			</td>	
		</tr>	
		
		<tr>
			<td align="left" style="padding-left: 10px; padding-top: 10px; padding-bottom: 10px;">
				<b>배송비 : </b>
			</td>
			<td align="right" style="padding-right :10px;">
				<span class="shippingPrice_span"></span>원
			</td>
		</tr>
		<tr>
			<td align="left" style="padding-left: 10px; padding-top: 10px; padding-bottom: 10px;">
				<b>총 결제 예정 금액  : </b>
			</td>
			<td align="right" style="padding-right :10px;">
				<span class="allTotalPrice_span"></span>원
			</td>
		</tr>
		<tr>
			<td align="left" style="padding-left: 10px; padding-top: 10px; padding-bottom: 10px;"> 
				<b>적립 예정 포인트  : </b>
			</td>
			<td align="right" style="padding-right :10px;">
				<span class="totalPoint_span"></span>원
			</td>
		</tr>	
		
		
	</table >
	
	<table id ="tableO2">
		

		
		
		<tr >
			
			<td>
				<div id="divB" >
			 		<button type="button"  onclick="requestPay()" class="payButton">결제하기</button>
				</div>			
			</td>
		</tr>
		
	</table>
	</div>
	</form>
	
</body>
</html>