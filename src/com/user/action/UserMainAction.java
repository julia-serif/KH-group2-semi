package com.user.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.Ks_ProductDAO;
import com.shop.model.Ks_ProductDTO;

public class UserMainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 제품 전체 리스트를 DB에서 조회하여 뷰페이지로 이동
		
		Ks_ProductDAO dao = Ks_ProductDAO.getInstance();
		
		List<Ks_ProductDTO> list = dao.getKsProductList();
		
		request.setAttribute("ksproduct", list);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		forward.setPath("user/user_main.jsp");
				
		return forward;
	}

}
