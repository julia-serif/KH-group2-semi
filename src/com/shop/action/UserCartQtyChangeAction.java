package com.shop.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.CartDAO;

public class UserCartQtyChangeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//변경될 수량과 카트번호를 받아옴
		int qty = Integer.parseInt(request.getParameter("aJaxCartQty").trim());
		int cartNum = Integer.parseInt(request.getParameter("aJaxCartNum").trim());
		String userId = request.getParameter("aJaxUserId").trim();
		
		System.out.println("사용자 : " + userId);
		System.out.println("수량 : " + qty);
		
		CartDAO dao = CartDAO.getInstance();
		
		int check = dao.changeCartQty(qty, cartNum, userId);
		
		PrintWriter out = response.getWriter();
		
		//ajax에 반환
		out.println(check);
		
		return null;
	}

}
