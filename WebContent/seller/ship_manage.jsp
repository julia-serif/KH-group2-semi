<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송 관리</title>
<script type="text/javascript">
	
	function new_order_list(){
		
		$.ajax({
			success: function(data) {
				
			},
			error: function(data) {
				alert("통신 오류가 발생하였습니다.");
			}
		});
	}
	
	function delivery_check(){
		
		$.ajax({
			success: function(data) {
				
			},
			error: function(data) {
				alert("통신 오류가 발생하였습니다.");
			}
		});
	}

</script>
</head>
<body>
	<jsp:include page="../include/seller_order_manage_top.jsp" />
	<jsp:include page="../include/seller_ship_manage_top2.jsp" />
	
</body>
</html>