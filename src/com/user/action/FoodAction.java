package com.user.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.Ks_ProductDAO;
import com.shop.model.Ks_ProductDTO;

public class FoodAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 저장된 카테고리를 가져와 뷰페이지로 이동하는 비즈니스 로직
				
		Ks_ProductDAO dao = Ks_ProductDAO.getInstance();
		
		List<Ks_ProductDTO> list = dao.getKsProductList();
		
		request.setAttribute("productCode", list);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		forward.setPath("user/food.jsp");
		
		return forward;
	}

}
