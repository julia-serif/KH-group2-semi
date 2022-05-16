package com.user.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.UserDAO;
import com.shop.model.UserDTO;

public class UserUpdataAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// get방식으로 넘어온 데이터를 받아 정보를 수정하는 비즈니스 로직

		String userid = request.getParameter("userid").trim();
		String username = request.getParameter("username").trim();
		String userphone = request.getParameter("userphone").trim();
		String useremail = request.getParameter("useremail").trim();
		String user_addr = request.getParameter("user_addr").trim();
		String userpwd = request.getParameter("userpwd").trim();
		
		String dbpwd = request.getParameter("dbpwd").trim();
				
		UserDTO dto = new UserDTO();
				
		dto.setUser_id(userid);
		dto.setUser_name(username);		
		dto.setUser_phone(userphone);
		dto.setUser_email(useremail);
		dto.setUser_addr(user_addr);
		dto.setUser_pwd(userpwd);
								
		UserDAO dao = UserDAO.getInstance();
				
		ActionForward forward = new ActionForward();
				
		PrintWriter out = response.getWriter();
				
		if(dto.getUser_pwd().equals(dbpwd)) {
					
			int check = dao.getUserData(dto);
					
			if(check > 0) {
						
				forward.setRedirect(true);
						
				forward.setPath("user_data.do");	
						
			}else{
				out.println("<script>");
				out.println("alert('회원 정보 수정 실패!')");
				out.println("history.back()");
				out.println("</script>");
				}
		  	}else {     // 비밀번호가 틀린 경우 
				out.println("<script>");
				out.println("alert('비밀번호가 일치하지 않습니다. 확인해 주세요.')");
				out.println("history.back()");
				out.println("</script>");
				}
	          		
		return forward;
	}

}
