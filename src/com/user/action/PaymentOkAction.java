package com.user.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.CartDAO;
import com.shop.model.CartDTO;

public class PaymentOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 해당유저의 정보를 가져와 뷰페이지로 이동하는 비즈니스로직
		
        HttpSession session = request.getSession();
		
		String userid = (String)session.getAttribute("userid");
		int payNo = Integer.parseInt(request.getParameter("payNo").trim());
		
		CartDAO dao = CartDAO.getInstance();
		
		List<CartDTO> list =  dao.getCartPayList(userid,payNo);
		
		request.setAttribute("payok", list);
		
        ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		forward.setPath("user/payment.jsp");
		
		return forward;
	}

}
