package com.user.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.Shop_UserDAO;
import com.shop.model.Shop_UserDTO;

public class UpdataAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// get방식으로 넘어온 회원번호에 해당하는 회원의 정보를
		// DB에서 조회하여 수정 폼 페이지로 이동하는 비즈니스 로직
		
		HttpSession session = request.getSession();
		
		String userId = (String)session.getAttribute("userid");
		
		Shop_UserDAO dao = Shop_UserDAO.getInstance();
		
		Shop_UserDTO dto = dao.getUserId(userId);
		
		request.setAttribute("updata", dto);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		forward.setPath("user/user_updata_ok.jsp");
		
		return forward;
	}

}
