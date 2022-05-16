package com.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.seller.model.SalesPerformanceDAO;
import com.seller.model.SalesPerformanceDTO;
import com.shop.controller.Action;
import com.shop.controller.ActionForward;

public class SellListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		SalesPerformanceDAO dao=SalesPerformanceDAO.getInstance();
		
		List<SalesPerformanceDTO> list =dao.getAllList();
		
		request.setAttribute("List", list);
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("admin/admin_sell_list.jsp");
		
		return forward;
		
	}

}
