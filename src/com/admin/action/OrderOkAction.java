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
<<<<<<< HEAD:src/com/admin/action/OrderOkAction.java
		// get방식으로 넘어온 번호에 해당하는 상품을
		// db에서 조회하여 뷰페이지로 이동하는 비즈니스 로직
		
		int order = Integer.parseInt(request.getParameter("order").trim());
		
		Ks_ProductDAO dao = Ks_ProductDAO.getInstance();
		
		Ks_ProductDTO orderOk = dao.getOrderOk(order);
		
		request.setAttribute("orderOk", orderOk);
=======
		// 저장된 카테고리를 가져와 뷰페이지로 이동하는 비즈니스 로직
				
		Ks_ProductDAO dao = Ks_ProductDAO.getInstance();
		
		List<Ks_ProductDTO> list = dao.getKsProductList();
		
		request.setAttribute("productCode", list);
>>>>>>> 28e142edc15046037b1d242403d22f1980660153:src/com/user/action/FoodAction.java
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		forward.setPath("user/orderok.jsp");
		
		return forward;
	}

}
