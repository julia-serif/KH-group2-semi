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

 	<jsp:include page="../inculde/top.jsp"/> 	

<div class="container">
<div class="row">
<div class="col-12 mt-5">
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
        [배송일정] 주문한 상품의 배송상태가 계속 상품준비중으로 표시됩니다.
      </button>
    </h2>
    <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
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
    <h2 class="accordion-header" id="headingFour">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
        [배송일정] 주문한 상품의 배송상태가 계속 상품준비중으로 표시됩니다.
      </button>
    </h2>
    <div id="collapseFour" class="accordion-collapse collapse" aria-labelledby="headingFour" data-bs-parent="#accordionExample">
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
    <h2 class="accordion-header" id="headingFive">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
        [배송일정] 주문한 상품의 배송상태가 계속 상품준비중으로 표시됩니다.
      </button>
    </h2>
    <div id="collapseFive" class="accordion-collapse collapse" aria-labelledby="headingFive" data-bs-parent="#accordionExample">
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
    <h2 class="accordion-header" id="headingSix">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
        [배송일정] 주문한 상품의 배송상태가 계속 상품준비중으로 표시됩니다.
      </button>
    </h2>
    <div id="collapseSix" class="accordion-collapse collapse" aria-labelledby="headingSix" data-bs-parent="#accordionExample">
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
    <h2 class="accordion-header" id="headingSeven">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSeven" aria-expanded="false" aria-controls="collapseSeven">
        [배송일정] 주문한 상품의 배송상태가 계속 상품준비중으로 표시됩니다.
      </button>
    </h2>
    <div id="collapseSeven" class="accordion-collapse collapse" aria-labelledby="headingSeven" data-bs-parent="#accordionExample">
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
        [배송일정] 주문한 상품의 배송상태가 계속 상품준비중으로 표시됩니다.
      </button>
    </h2>
    <div id="collapseNine" class="accordion-collapse collapse" aria-labelledby="headingNine" data-bs-parent="#accordionExample">
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
    <h2 class="accordion-header" id="headingTen">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTen" aria-expanded="false" aria-controls="collapseTen">
        [배송일정] 주문한 상품의 배송상태가 계속 상품준비중으로 표시됩니다.
      </button>
    </h2>
    <div id="collapseTen" class="accordion-collapse collapse" aria-labelledby="headingTen" data-bs-parent="#accordionExample">
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
    <h2 class="accordion-header" id="headingEleven">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseEleven" aria-expanded="false" aria-controls="collapseEleven">
        [배송일정] 주문한 상품의 배송상태가 계속 상품준비중으로 표시됩니다.
      </button>
    </h2>
    <div id="collapseEleven" class="accordion-collapse collapse" aria-labelledby="headingEleven" data-bs-parent="#accordionExample">
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
    <h2 class="accordion-header" id="headingTwelve">
      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwelve" aria-expanded="false" aria-controls="collapseTwelve">
        [배송일정] 주문한 상품의 배송상태가 계속 상품준비중으로 표시됩니다.
      </button>
    </h2>
    <div id="collapseTwelve" class="accordion-collapse collapse" aria-labelledby="headingTwelve" data-bs-parent="#accordionExample">
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
</div>
</div>
</div>
</div>	
</body>
</html>