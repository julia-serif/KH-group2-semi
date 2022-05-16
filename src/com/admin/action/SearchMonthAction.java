package com.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seller.model.SalesPerformanceDAO;
import com.seller.model.SalesPerformanceDTO;
import com.shop.controller.Action;
import com.shop.controller.ActionForward;

public class SearchMonthAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String date= request.getParameter("date");
		
		SalesPerformanceDAO dao=SalesPerformanceDAO.getInstance();
		
		List<SalesPerformanceDTO> list =dao.getSelectMonth(date);
		
		request.setAttribute("List", list);
		request.setAttribute("date", date);
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("admin/admin_search_list.jsp");
		return forward;
	}

}
