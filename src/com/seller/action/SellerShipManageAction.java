package com.seller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.OrderDAO;
import com.shop.model.OrderDTO;

public class SellerShipManageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 판매자의 id에 해당하는 주문 목록을 조회하여 배송 조회 페이지로 이동시키는 비지니스 로직.

		String user_id = (String) request.getSession().getAttribute("user_id");
		
		OrderDAO dao = OrderDAO.getInstance();
		
		List<OrderDTO> list = dao.getProductList(user_id);
		
		request.setAttribute("productList", list);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("seller/ship_manage.jsp");
		
		return forward;
	}

}
