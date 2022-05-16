package com.user.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.ProductDAO;
import com.shop.model.ProductDTO;

public class SearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 검색 폼 창에서 넘어온 검색어를 가지고 
		// DB에서 검색어에 해당하는 모든 게시물을 반환하여 뷰페이지로 이동하는 비즈니스 로직
		
		String find_field = request.getParameter("find_field").trim();
		String find_name = request.getParameter("find_name").trim();
		
		ProductDAO dao = ProductDAO.getInstance();
		
		List<ProductDTO> list = dao.getSearchProduct(find_field,find_name);
		
		request.setAttribute("searchlist", list);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		forward.setPath("user/search.jsp");
		
		return forward;
	}

}
