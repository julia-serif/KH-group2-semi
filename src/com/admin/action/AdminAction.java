package com.admin.action;

import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.action.Action;
import com.shop.action.ActionForward;
import com.shop.model.AdminDAO;
import com.shop.model.UserDTO;

public class AdminAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		AdminDAO dao =AdminDAO.getInstance();
		List<UserDTO> list =dao.getUserList();
		request.setAttribute("List", list);
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("admin/admin_main.jsp");
		return forward;
	}

}
