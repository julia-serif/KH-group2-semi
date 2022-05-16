package com.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.CartDAO;
import com.shop.model.CartDTO;

public class OrderDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 번호에 해당하는 상품 상세내역을 DB에서 조회 후 뷰 페이지로 이동
		
		int order_detail = 
				Integer.parseInt(request.getParameter("order_detail"));
	
		CartDAO dao = CartDAO.getInstance();
		
		CartDTO dto = dao.getCartDetailList(order_detail);
		
		request.setAttribute("detail", dto);	
		
		ActionForward forward =  new ActionForward();
		
		forward.setRedirect(false);
		
		forward.setPath("user/order_detail.jsp");
				
		return forward;
	}

}
