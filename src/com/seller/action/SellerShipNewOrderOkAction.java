package com.seller.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;

public class SellerShipNewOrderOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// checkbox에 체크한 상품주문번호에 해당하는 주문들을 배송처리하는 비지니스 로직.
		
		
		//checkbox를 체크한 상품주문번호들을 getParameterValues로 가져온다.
		
		//배송 상태 변경하는 메소드
		
		//결과에 따라 alert 표시.
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(true);
		forward.setPath("seller_ship_delivery_check.do");
		
		return forward;
	}

}
