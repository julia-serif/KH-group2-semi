package com.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.Ks_UserDAO;
import com.shop.model.Ks_UserDTO;

public class UserDataAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// DB에서 회원의 정보를 받아와 뷰페이지로 이동하는 비즈니스 로직
		
		HttpSession session = request.getSession();
		
		String userid = (String)request.getAttribute("userid");
		
		Ks_UserDAO dao = Ks_UserDAO.getInstance();
		
		Ks_UserDTO dto = dao.getKs_User(userid);
				
		request.setAttribute("User", dto);
		
		ActionForward forard = new ActionForward();
		
		forard.setRedirect(false);
		
		forard.setPath("user/user_updata.jsp");
		
		return forard;
	}

}
