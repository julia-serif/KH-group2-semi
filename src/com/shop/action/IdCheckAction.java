package com.shop.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.model.UserDAO;

public class IdCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out =response.getWriter();
		ActionForward forward = new ActionForward();
		
		String user_id=request.getParameter("id").trim();
		UserDAO dao= UserDAO.getInstance();
		String res=dao.Overlap(user_id);
		out.write(res);
		System.out.println("@@@@@@@@@@@"+res);
		return forward;
	}

}
