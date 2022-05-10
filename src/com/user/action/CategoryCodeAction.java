package com.user.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.Ks_ProductDAO;
import com.shop.model.Ks_ProductDTO;

public class CategoryCodeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// get방식으로 넘어온 카테고리 코드에 해당하는 제품 리스트를
		// DB에서 조회하여 view page로 이동시키는 비지니스 로직
		
		String code = request.getParameter("code").trim();
		
		Ks_ProductDAO dao = Ks_ProductDAO.getInstance();
		
		List<Ks_ProductDTO> list =  dao.getProductCode(code);
		
		request.setAttribute("code", list);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		forward.setPath("user/categorycode.jsp");
		
		return forward;
	}

}
