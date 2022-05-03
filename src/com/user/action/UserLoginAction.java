package com.user.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.Ks_UserDAO;
import com.shop.model.Ks_UserDTO;

public class UserLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 넘어온 데이터가 DB에 있는지 확인하고 뷰페이지로 넘기는 메서드
		
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		
		Ks_UserDAO dao = Ks_UserDAO.getInstance();
		
		int check = dao.getUserCheck(user_id,user_pwd);
		
		ActionForward forward = new ActionForward();
		
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		if(check > 0) {
			Ks_UserDTO dto = dao.getKs_User(user_id);
			
			session.setAttribute("userid", dto.getUser_id());
			session.setAttribute("username", dto.getUser_name());
			
			forward.setRedirect(true);
			forward.setPath("user_main.do");
			
		}else if(check == -1) {
			// 비밀번호가 틀린경우
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다. 확인해주세요.')");
			out.println("history.back()");
			out.println("</script>");	
		}else {
			// 회원이 아닌경우(아이디가 없거나 아이디가 틀린경우)
			out.println("<script>");
			out.println("alert('없는 아이디입니다. 다시 한번 아이디를 확인해주세요.')");
			out.println("history.back()");
			out.println("</script>");	
		}
		
		return forward;
	}

}
