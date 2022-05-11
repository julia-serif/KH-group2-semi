package com.shop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.CartDAO;
import com.shop.model.CartDTO;



public class UserCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();
		
		//object 타입이므로 넘겨줌
		String userId = (String)session.getAttribute("userId");
		
		CartDAO dao = CartDAO.getInstance();
		
		//userId에 해당하는 장바구니만 조회 ( 다른 아이디 장바구니는 보이지 않게 )
		List<CartDTO> list = dao.getCartList(userId);
		
		request.setAttribute("cartList", list);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("user/user_cart_list.jsp");
		
		
		
		return forward;
	}

}
