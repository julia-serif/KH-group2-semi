package com.seller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seller.model.SalesPerformanceDAO;
import com.seller.model.SalesPerformanceDTO;
import com.shop.controller.Action;
import com.shop.controller.ActionForward;

public class SellerSalesPerformAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 판매자의 id에 해당하는 주문 목록을 조회하여 주문 내역 조회 페이지로 이동시키는 비지니스 로직.

		String user_id = (String) request.getSession().getAttribute("user_id");
		
		SalesPerformanceDAO dao = SalesPerformanceDAO.getInstance();
		
		List<SalesPerformanceDTO> list = dao.getProductList(user_id);
		
		request.setAttribute("productList", list);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("seller/sales_performance.jsp");
		
		return forward;
	}

}
