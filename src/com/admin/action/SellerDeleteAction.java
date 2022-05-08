package com.admin.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.UserDAO;

public class SellerDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int user_no = Integer.parseInt(request.getParameter("user_no").trim());
		UserDAO dao = UserDAO.getInstance();

		int check = dao.deleteuser(user_no);
	
		ActionForward forward = new ActionForward();
		PrintWriter out = response.getWriter();
		
		if (check > 0) {
			forward.setRedirect(false);
			forward.setPath("admin/admin_user_list_seller.jsp");

		} else {
			out.println("<script>");
			out.println("alert('제품 정보 수정 실패~~~')");
			out.println("history.back()");
			out.println("</script>");
		}

		return forward;
	}

}
