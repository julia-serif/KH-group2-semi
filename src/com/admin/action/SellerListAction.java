package com.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.action.Action;
import com.shop.action.ActionForward;
import com.shop.model.UserDAO;
import com.shop.model.UserDTO;

public class SellerListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		UserDAO dao = UserDAO.getInstance();
		List<UserDTO> list = dao.getSellerList();
		request.setAttribute("List", list);
		ActionForward forward = new ActionForward();

		forward.setRedirect(false);
		forward.setPath("admin/admin_user_list_seller.jsp");

		return forward;
	}

}
