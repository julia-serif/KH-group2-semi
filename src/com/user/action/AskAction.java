package com.user.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.Customer_AskDAO;
import com.shop.model.Customer_AskDTO;

public class AskAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// DB에서 정보를 받아와 뷰페이지로 이동하는 비즈니스 로직
		
		Customer_AskDAO dao = Customer_AskDAO.getInstance();
		
		List<Customer_AskDTO> list = dao.getAskList();
		
		request.setAttribute("asklist", list);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		forward.setPath("user/ask.jsp");
		
		return forward;
	}

}
