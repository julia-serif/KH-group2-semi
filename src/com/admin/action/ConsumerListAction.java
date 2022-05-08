package com.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.UserDAO;
import com.shop.model.UserDTO;

public class ConsumerListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		UserDAO dao = UserDAO.getInstance();
		List<UserDTO> list = dao.getConsumerList();
		request.setAttribute("List", list);
		ActionForward forward = new ActionForward();

		forward.setRedirect(false);
		forward.setPath("admin/admin_user_list_consumer.jsp");

		return forward;
	}

}
