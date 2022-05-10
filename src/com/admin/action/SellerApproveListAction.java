package com.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.action.Action;
import com.shop.action.ActionForward;
import com.shop.model.AdminDAO;
import com.shop.model.UserDTO;

public class SellerApproveListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		AdminDAO dao = AdminDAO.getInstance();
		List<UserDTO> list = dao.getApproveList();
		request.setAttribute("List", list);
		ActionForward forward = new ActionForward();

		forward.setRedirect(false);
		forward.setPath("admin/admin_user_approve_list_seller.jsp");

		return forward;
	}

}
