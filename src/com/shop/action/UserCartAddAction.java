package com.shop.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.CartDAO;
import com.shop.model.CartDTO;


public class UserCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String cart_name = request.getParameter("p_name").trim();
		String cart_spec = request.getParameter("p_spec").trim();
		String cart_image = request.getParameter("p_image").trim();
		String userId = request.getParameter("userId").trim();
		String seller = request.getParameter("p_seller").trim();
		
		int cart_price = Integer.parseInt(request.getParameter("p_price").trim());
		int cart_pqty = Integer.parseInt(request.getParameter("p_qty").trim());
		int cart_pnum = Integer.parseInt(request.getParameter("p_num").trim());
		
		
		CartDTO dto = new CartDTO();
		
		dto.setCart_pnum(cart_pnum); 		//상품 번호
		dto.setCart_pimage(cart_image);
		dto.setCart_pname(cart_name);
		dto.setCart_pqty(cart_pqty);
		dto.setCart_price(cart_price);
		dto.setCart_pspec(cart_spec);
		dto.setCart_userId(userId);
		dto.setCart_seller(seller);
		
		CartDAO dao = CartDAO.getInstance();
		
		int check = dao.insertCart(dto);
		
		ActionForward forward = new ActionForward();
		
		PrintWriter out = response.getWriter();
		
		if(check > 0) {
			
			forward.setRedirect(true);
			forward.setPath("user_cart_list.do");
		
			
		}else if (check == -1){
			out.println("<script>");
			out.println("if(confirm('이미 장바구니에 있습니다. 추가하시겠습니까?')){" + 
					"location.href='user_cart_AddUpdate.do?pnum="+ cart_pnum + "&userId=" + userId + 
					"&cart_pqty=" + cart_pqty +"'" + 
					"}else { location.href='user_product_view.do?pnum="+ cart_pnum + "'}");
			
			out.println("</script>");
		
		}else {
			out.println("<script>");
			out.println("alert('장바구니 저장 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
