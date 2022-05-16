package com.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.Shop_UserDAO;
import com.shop.model.Shop_UserDTO;

public class UserDataAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// get방식으로 넘어온 아이디에 해당하는 유저의 정보를 가져오는 비즈니스 로직
		
		HttpSession session = request.getSession();
		
		String userid = (String)request.getAttribute("user_id");
		
		Shop_UserDAO dao = Shop_UserDAO.getInstance();
		
		Shop_UserDTO dto = dao.getUserId(userid);
		
		request.setAttribute("userupdate", dto);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		forward.setPath("user/user_updata.jsp");
		
		
		return forward;
	}

}
