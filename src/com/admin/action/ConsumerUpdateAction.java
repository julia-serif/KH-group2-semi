package com.admin.action;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.AdminDAO;
import com.shop.model.UserDTO;

public class ConsumerUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int user_no=Integer.parseInt(request.getParameter("user_no").trim());
		AdminDAO dao= AdminDAO.getInstance();
		UserDTO dto = dao.getUserContent(user_no);
		
		request.setAttribute("dto", dto);
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("admin/admin_user_update.jsp");

		return forward;
	}

}
