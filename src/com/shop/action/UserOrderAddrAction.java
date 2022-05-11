package com.shop.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.OrderDAO;
import com.shop.model.UserDAO;
import com.shop.model.UserDTO;

public class UserOrderAddrAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String userId = request.getParameter("id").trim();
		
		UserDAO dao = UserDAO.getInstance();
		
		UserDTO info = dao.getMember(userId);
		
		PrintWriter out = response.getWriter();
		
		//ajax에 반환
		out.println(info);
		
		return null;
	}

}
