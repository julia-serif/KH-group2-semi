<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link rel="stylesheet" href="CSS/top.css">
<link rel="stylesheet" href="CSS/category.css">
</head>
<body>

 	<jsp:include page="../include/top.jsp"/> 	

<div class="container">
<div class="row">
<div class="col-10 mt-5">
<div class="accordion " id="accordionExample">
 <h3>자주묻는 질문</h3>
 <div class="btn-group col-12 mt-3" role="group" aria-label="Basic outlined example">
 <button type="button" class="btn btn-outline-primary">배송문의</button>
 <button type="button" class="btn btn-outline-primary">반품/교환/환불</button>
 <button type="button" class="btn btn-outline-primary">주문/결제</button>
 <button type="button" class="btn btn-outline-primary">회원서비스</button>
</div>
  <div class="accordion-item mt-5">
    <h2 class="accordion-header" id="headingOne">
      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
        [배송완료미수령] 상품을 받지 못했는데 배송완료로 확인됩니다.
      </button>
    </h2>
    <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
      <div class="accordion-body">
        <p>	
               만약 '배송완료'로 확인되나 상품을 받지 못했다면 다음을 먼저 확인해 주십시오.<br>
       	1) 배송완료 문자 혹은 [마이페이지>주문목록] > [배송조회]에서 사진 확인.<br>
		2) 대리 수령 가능 장소(경비실, 이웃, 주변 편의점 등) 확인.<br>		
		<br>
		■ 판매자 배송 상품을 받지 못한 경우.<br>
		[ > 택배기사 전화하기]로 문의.<br>
		※ 택배기사 연락처는 배송완료 직후까지만 확인 가능.<br>
		<br>
		■ 선물 상품을 받지 못한 경우.<br>
		1) 받는 사람에게 발송된 문자 또는 카카오톡 메시지 내 [배송조회]링크 접속하여 관련 정보 재확인.<br>
		2) 페이지 하단 [문의하기]를 통해 고객센터 문의.<br>
        </p>
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingTwo">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
        [배송일정] 주문한 상품의 배송상태가 계속 상품준비중으로 표시됩니다.
      </button>
    </h2>
    <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
      <div class="accordion-body">
      <p>     	
		'상품준비중' 단계는 판매자가 고객님의 주문을 확인하여 상품을 포장, 배송을 준비하는 상태입니다. <br>		
		갑작스러운 주문량 증가 등 예상치 못한 상황이 발생할 경우 '상품준비중' 단계가 길어질 수 있습니다.	<br>	
		또한, 해외배송상품의 경우 시차로 인해 주문확인 및 상품포장에 시간이 소요될 수 있으니 참고 부탁드립니다. 	<br>	
		<br>
		■ '상품 준비중' 단계가 길어져 취소를 원할 경우	<br>	
		[마이페이지>주문목록]에서 주문취소가 가능합니다.		<br>
		수령을 원하신다면 판매자에게 배송일정 문의 부탁드립니다.		<br>
      </p>
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingThree">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
        [반품비] 반품할 경우, 비용은 누가 부담하나요?
      </button>
    </h2>
    <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
      <div class="accordion-body">
      <p>     					
			반품 사유에 따라 비용이 발생 할 수 있습니다. 			<br>
			발생하는 비용 및 환불 예정금액은 반품접수 시 마이 쿠팡에서 확인 가능합니다. 	<br>		
			 <br>
			■ 단순 변심 반품 시 배송비<br>
			    판매자배송 			<br>
			    - 최초 배송비를 포함한 왕복 배송비가 발생 합니다.　　　　　　　                　<br>　　　　　　			
			    - 무료배송 상품의 경우 반품 시 발생하는 반품비는 고객 부담합니다.<br>
			    - 도서/산간 지역이거나 설치 상품을 반품하는 경우에는 반품비가 추가될 수 있습니다. 　<br>
			<br>
			■ 상품의 불량 또는 오배송 　<br>
			    - 반품비용이 발생하지 않습니다.  <br>
			※ 해외 배송 상품, 가구 및 설치 상품의 경우 상품 상세 페이지를 확인해주세요.<br>
      </p>
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingFour">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
       [취소] 주문한 상품을 취소하고 싶은데 어떻게 해야 하나요?
      </button>
    </h2>
    <div id="collapseFour" class="accordion-collapse collapse" aria-labelledby="headingFour" data-bs-parent="#accordionExample">
      <div class="accordion-body">
      <p>     							
			주문하신 상품은 마이쿠팡에서 쉽고 빠르게 취소 및 반품을 신청할 수 있습니다.		<br>	
			판매자배송 상품의 경우 판매자에게 직접 문의하여 취소도 가능합니다.<br>
			<br>
			이미 배송이 시작된 상품은 반품으로 접수하며 반품비용이 발생 할 수 있습니다.<br>
	<br>
			■ 주문 취소하기<br>
			<br>
			1. [마이페이지 > 주문목록] 에서 [주문취소] 클릭						<br>
			<br>
			■ 반품하기<br>
			<br>
			1. [마이페이지 > 주문목록] 에서 [반품신청] 클릭 > 반품 수량과 반품사유 선택<br>
			<br>
			2. 반품 상품의 [상품 회수 여부]선택<br>
			<br>
			- 판매자에게 상품 도착 후 승인 취소가 완료됩니다.<br>
			<br>
			※ 반품 신청 이후 배송된 상품은 수취 거부<br>
			<br>
			※ 반품 접수 후 1~3일 이내 택배기사 방문 해 상품 회수<br>
			<br>
			■ 판매자에게 문의하기<br>
			- [상품 상세 페이지> 배송/교환/반품 안내 > 판매자 정보란]에서 판매자 연락처 확인<br>
			<br>
			- [마이 페이지> 주문 목록> 상품 선택> 배송/교환/반품 안내> 판매자 정보란]에서 연락처 확인<br>
      </p>
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingFive">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
        [회원정보] 회원정보 수정은 어떻게 하나요?
      </button>
    </h2>
    <div id="collapseFive" class="accordion-collapse collapse" aria-labelledby="headingFive" data-bs-parent="#accordionExample">
      <div class="accordion-body">
      <p>	
			회원정보에서는 이메일, 휴대폰번호, 주소록.배송지를 수정할 수 있습니다.<br>
			<br>
			■ 회원정보 수정하기<br>
			[마이페이지 > 회원정보] 에서 수정 가능 합니다.<br>
      </p>
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingSix">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
        [회원가입] 아이디를 여러개 사용할 수 있나요?
      </button>
    </h2>
    <div id="collapseSix" class="accordion-collapse collapse" aria-labelledby="headingSix" data-bs-parent="#accordionExample">
      <div class="accordion-body">
      <p>     	
		인증을 받지 않은 아이디는 여러 개 보유할 수 있지만,<br>
		정확한 구매 활동에 대한 안내를 받기 위해서는 1인당 1개의 아이디만 사용하실 것을 권장합니다.<br>
        <br>
		회원 가입 후 첫 주문/결제 시에 인증 절차가 필요합니다.<br>
      </p>
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingSeven">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSeven" aria-expanded="false" aria-controls="collapseSeven">
       [상품문의] 상품에 대해서 문의하려면 어떻게 해야 하나요?
      </button>
    </h2>
    <div id="collapseSeven" class="accordion-collapse collapse" aria-labelledby="headingSeven" data-bs-parent="#accordionExample">
      <div class="accordion-body">
      <p>     				
		상품에 관한 내용은 상세 페이지 내 [상품상세]에 자세히 안내되어 있습니다.<br>
		[마이페이지 > 주문목록]에서 상품을 선택하여 확인하실 수 있습니다.<br>
		<br>
		상품 상세 페이지에 안내되어 있지 않은 내용은 판매자 연락처로 문의해 주십시오.<br>
		<br>
		■ 판매자에게 문의하기<br>
		<br>
		1. [마이페이지 > 주문목록]에서 상품 선택 > 배송/교환/반품 안내 > 최하단 [판매자 정보란]에서 판매자연락처로 문의<br>
		<br>
		2. [마이페이지 > 주문목록 > 판매자 문의하기]<br>
      </p>
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingEight">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseEight" aria-expanded="false" aria-controls="collapseEight">
        [배송일정] 주문한 상품의 배송상태가 계속 상품준비중으로 표시됩니다.
      </button>
    </h2>
    <div id="collapseEight" class="accordion-collapse collapse" aria-labelledby="headingEight" data-bs-parent="#accordionExample">
      <div class="accordion-body">
      <p>     	
		'상품준비중' 단계는 판매자가 고객님의 주문을 확인하여 상품을 포장, 배송을 준비하는 상태입니다. <br>		
		갑작스러운 주문량 증가 등 예상치 못한 상황이 발생할 경우 '상품준비중' 단계가 길어질 수 있습니다.	<br>	
		또한, 해외배송상품의 경우 시차로 인해 주문확인 및 상품포장에 시간이 소요될 수 있으니 참고 부탁드립니다. 	<br>	
		<br>
		■ '상품 준비중' 단계가 길어져 취소를 원할 경우	<br>	
		[마이페이지>주문목록]에서 주문취소가 가능합니다.		<br>
		수령을 원하신다면 판매자에게 배송일정 문의 부탁드립니다.		<br>
      </p>
      </div>
    </div>
  </div>
  <div class="accordion-item">
    <h2 class="accordion-header" id="headingNine">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseNine" aria-expanded="false" aria-controls="collapseNine">
        [현금영수증] 현금영수증을 신청하지 못했는데, 어떻게 해야 하나요?
      </button>
    </h2>
    <div id="collapseNine" class="accordion-collapse collapse" aria-labelledby="headingNine" data-bs-parent="#accordionExample">
      <div class="accordion-body">
      <p>     	
		쿠팡은 국세청이 지정한 코드(010-000-1234)로 고객님들의 현금영수증을 자진 발급해 드리고 있습니다.<br>
		현금영수증 자진발급 건에 대해 현금영수증 신청을 원하실 경우,<br>
		결제일 다음날부터 국세청 홈페이지(https://www.hometax.go.kr/)를 통해 직접 현금영수증을 발행 받으실 수 있습니다.<br>
      </p>
      </div>
    </div>
  </div>
</div>
</div>
</div>
</div>	
</body>
</html>