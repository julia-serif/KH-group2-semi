package com.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.Ks_ProductDAO;
import com.shop.model.Ks_ProductDTO;

public class OrderOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// get방식으로 넘어온 번호에 해당하는 상품을
		// db에서 조회하여 뷰페이지로 이동하는 비즈니스 로직
		
		int order = Integer.parseInt(request.getParameter("order").trim());
		
		Ks_ProductDAO dao = Ks_ProductDAO.getInstance();
		
		Ks_ProductDTO orderOk = dao.getOrderOk(order);
		
		request.setAttribute("orderOk", orderOk);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		forward.setPath("user/orderok.jsp");
		
		return forward;
	}

}
