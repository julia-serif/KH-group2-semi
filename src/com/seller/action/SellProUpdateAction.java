package com.seller.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.ProductDAO;
import com.shop.model.ProductDTO;

public class SellProUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// get 방식으로 넘어온 제품번호에 해당하는 제품의 상세 내역을 
		// DB에서 조회하여 수정 폼 페이지(view page)로 이동시키는 비지니스 로직.
		
		int product_num = 
				Integer.parseInt(request.getParameter("pno").trim());
		
		ProductDAO dao = ProductDAO.getInstance();
		
		ProductDTO dto = dao.productContent(product_num);
		
		request.setAttribute("productCont", dto);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		forward.setPath("seller/sellProUpdate.jsp");
		
		
		return forward;
		
	}

}
