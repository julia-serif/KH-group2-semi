package com.user.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.ProductDAO;
import com.shop.model.ProductDTO;

public class CategoryNameAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// get 방식으로 넘어온 이름을 검색해서 뷰페이지로 이동하는 비즈니스 로직
		
        String cate_code = request.getParameter("code").trim();
        String cate_name = request.getParameter("catename").trim();
        		
		ProductDAO dao = ProductDAO.getInstance();
		
		List<ProductDTO> list =  dao.getProductCode(cate_code);
		
		request.setAttribute("categoryname", list);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		forward.setPath("user/categoryname.jsp");
		
		return forward;
	}

}
