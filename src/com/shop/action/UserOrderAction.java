package com.shop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.CartDAO;
import com.shop.model.CartDTO;
import com.shop.model.UserDAO;
import com.shop.model.UserDTO;

public class UserOrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//name값이 넘어온다 
		String[] chkBox = request.getParameterValues("checkBox");
		
		String userId = request.getParameter("userId"); 
		
		
		/* 배열은 parseInt가 안되기 때문에 sArr크기의 int형 배열을 생성 */
		int[] cbArr = new int[chkBox.length];
		
		//for문으로 형변환 작업을 시켜줌
		for(int i=0; i<chkBox.length; i++) {
			cbArr[i] = Integer.parseInt(chkBox[i]);
		}
		
		CartDAO dao = CartDAO.getInstance();
		
		List<CartDTO> cartList = dao.orderInfo(cbArr);
		
		UserDAO daoU = UserDAO.getInstance();
		
		UserDTO userInfo = daoU.getMember(userId);
		
		request.setAttribute("cartList", cartList);
		request.setAttribute("userInfo", userInfo);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("user/user_order.jsp");
		
		return forward;
	}

}
