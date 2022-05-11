package com.admin.action;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.AdminDAO;

public class SellerApproveOkAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int user_no = Integer.parseInt(request.getParameter("user_no").trim());
		AdminDAO dao = AdminDAO.getInstance();

		int check = dao.approve(user_no);
		
		ActionForward forward = new ActionForward();
		PrintWriter out = response.getWriter();
		
		if (check > 0) {
			forward.setRedirect(true);
			forward.setPath("admin_seller_approve.do");

		} else {
			out.println("<script>");
			out.println("alert('제품 정보 수정 실패~~~')");
			out.println("history.back()");
			out.println("</script>");
		}

		return forward;
	}

}
