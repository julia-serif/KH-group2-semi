package com.shop.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.UserDAO;
import com.shop.model.UserDTO;

public class SignUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int user_age;
		String user_id=request.getParameter("id").trim();//1
		String user_pwd=request.getParameter("pwd").trim();//2
		String user_name=request.getParameter("name").trim();//3
		if(request.getParameter("age")=="") {
			user_age=-100;
		}else {
			user_age=Integer.parseInt(request.getParameter("age").trim());//4
		}
			String phone1=request.getParameter("phone1").trim();
			String phone2=request.getParameter("phone2").trim();
			String phone3=request.getParameter("phone3").trim();
		String user_phone=phone1+"-"+phone2+"-"+phone3;//5
			String email1=request.getParameter("email1").trim();
			String email2=request.getParameter("email2").trim();
		String user_email=email1+"@"+email2;//6
		String user_addr=request.getParameter("addr");//7
		String user_grade=request.getParameter("grade").trim();//8
		
		UserDTO dto= new UserDTO();
		dto.setUser_id(user_id);
		dto.setUser_pwd(user_pwd);
		dto.setUser_name(user_name);
		dto.setUser_age(user_age);
		dto.setUser_phone(user_phone);
		dto.setUser_email(user_email);
		dto.setUser_addr(user_addr);
		dto.setUser_grade(user_grade);
		
		UserDAO dao= UserDAO.getInstance();
		int check = dao.signup(dto);
		
		
		ActionForward forward = new ActionForward();
		PrintWriter out = response.getWriter();
		
			if(check>0) {
			System.out.println("가입완료");
			forward.setRedirect(false);  
			forward.setPath("main.jsp");
			}else if(check==-1) {
				out.println("<script>");
				out.println("alert('ID가 중복되었습니다.')");
				out.println("history.back()");
				out.println("</script>");
			}else if(check==-2) {
				out.println("<script>");
				out.println("alert('phone 번호가 중복되었습니다.')");
				out.println("history.back()");
				out.println("</script>");
			}else if(check==-3) {
				out.println("<script>");
				out.println("alert('email이 중복되었습니다.')");
				out.println("history.back()");
				out.println("</script>");
			}else if(check==-4) {
				out.println("<script>");
				out.println("alert('빈란이 존재합니다.')");
				out.println("history.back()");
				out.println("</script>");
			}
		return forward;
	}

}
