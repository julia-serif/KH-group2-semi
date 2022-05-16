package com.user.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.CartDAO;
import com.shop.model.CartDTO;

public class PaymentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 제품 상세 내역에서 구매하기 버튼을 클릭시
		// 해당 데이터들을 카트 테이블에 저장하는 비즈니스 로직
		
		HttpSession session = request.getSession();
			
		String userid = (String)session.getAttribute("userid");
		String cartPname = request.getParameter("pName");		
		int payNo = Integer.parseInt(request.getParameter("payNo").trim());
		int p_price = Integer.parseInt(request.getParameter("p_price").trim());
		int cartpqty = Integer.parseInt(request.getParameter("cartpqty").trim());
		String cartPspec = request.getParameter("cartPspec").trim();
		String cartPimage = request.getParameter("cartPimage").trim();
		
		CartDTO dto = new CartDTO();
		
		dto.setCart_userId(userid);
		dto.setCart_pname(cartPname);
		dto.setCart_pnum(payNo);
		dto.setCart_price(p_price);
		dto.setCart_pqty(cartpqty);
		dto.setCart_pspec(cartPspec);
		dto.setCart_pimage(cartPimage);
		
		CartDAO dao = CartDAO.getInstance();
		
		int payok = dao.getInsertCart(dto);
		
		ActionForward forward = new ActionForward();
		
		PrintWriter out = response.getWriter();
		
		if(payok > 0) {
			
			forward.setRedirect(true);
			
			forward.setPath("paymentok.do");
			
		}else {
			out.println("<script>");
			out.println("alert('장바구니 저장 실패!')");
			out.println("history.back()");
			out.println("</script>");	
		}
		
		return forward;
	}

}
