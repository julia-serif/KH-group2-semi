package com.user.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.Ks_UserDAO;
import com.shop.model.Ks_UserDTO;

public class UserUpdataAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// get방식으로 넘어온 데이터를 받아 DB에 저장하는 비즈니스 로직
		
		
		
		String userId = request.getParameter("userId").trim();
		String userName = request.getParameter("userName").trim();
		String userEmail = request.getParameter("userEmail").trim();
		String userAddr = request.getParameter("userAddr").trim();
		String userPhone = request.getParameter("userPhone").trim();
		
		Ks_UserDTO dto = new Ks_UserDTO();
		
		dto.setUser_id(userId);
		dto.setUser_name(userName);
		dto.setUser_email(userEmail);
		dto.setUser_addr(userAddr);
		dto.setUser_phone(userPhone);
		
		Ks_UserDAO dao = Ks_UserDAO.getInstance();
		
		int check = dao.UserUpdata(dto);
		
		ActionForward forward = new ActionForward();
		
		PrintWriter out = response.getWriter();
		if(check > 0) {
			forward.setRedirect(true);
			forward.setPath("user_data.do");
		}else {
			out.println("<script>");
			out.println("alert('회원 정보 수정 실패!')");
			out.println("history.back()");
			out.println("</script>");	
		}
		
		
		return forward;
	}

}
