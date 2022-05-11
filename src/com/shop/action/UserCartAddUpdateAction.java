package com.shop.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.CartDAO;

public class UserCartAddUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int cart_pnum = Integer.parseInt(request.getParameter("pnum").trim());
		int cart_pqty = Integer.parseInt(request.getParameter("cart_pqty").trim());
		String userId = request.getParameter("userId").trim();
		
		
		CartDAO dao = CartDAO.getInstance();
		
		int check = dao.addCartUpdate(cart_pnum, userId, cart_pqty);
		
		ActionForward forward = new ActionForward();
		
		PrintWriter out = response.getWriter();
		
		
		if(check > 0) {
			
			forward.setRedirect(true);
			forward.setPath("user_cart_list.do");
		
		}else {
			out.println("<script>");
			out.println("alert('장바구니 업데이트 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		
		return forward;
	}

}
