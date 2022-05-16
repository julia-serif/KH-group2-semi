package com.user.action;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.Ks_ProductDAO;
import com.shop.model.Ks_ProductDTO;
import com.shop.model.OrderDAO;
import com.shop.model.OrderDTO;



public class OrderListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// DB에서 주문 목록을 가져와 뷰페이지로 이동하는 비즈니스 로직
		
        HttpSession session = request.getSession();
		
		String userid = (String)session.getAttribute("user_id");
		
		
		OrderDAO dao = OrderDAO.getInstance();
		
		OrderDTO dto =  dao.getOrderList(userid);
		
		request.setAttribute("cartlist", dto);
		
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		forward.setPath("user/order_list.jsp");
		
		return forward;
	}

}
