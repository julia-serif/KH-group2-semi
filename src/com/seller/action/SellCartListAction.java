package com.seller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seller.model.CategoryDAO;
import com.seller.model.CategoryDTO;
import com.shop.controller.Action;
import com.shop.controller.ActionForward;

public class SellCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 카테고리 테이블에 있는 전체 레코드를 조회하여
		// view page로 이동시키는 비지니스 로직.
		
		CategoryDAO dao = CategoryDAO.getInstance();
		
		List<CategoryDTO> list = dao.getCategoryList();
		
		request.setAttribute("categoryList", list);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		forward.setPath("seller/sellCartList.jsp");
		
		
		return forward;
		
	}

}
