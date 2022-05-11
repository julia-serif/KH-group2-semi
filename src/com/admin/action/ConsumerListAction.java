package com.admin.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.UserDAO;
import com.shop.model.UserDTO;

public class ConsumerListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
<<<<<<< HEAD:src/com/admin/action/ConsumerListAction.java
		UserDAO dao = UserDAO.getInstance();
		List<UserDTO> list = dao.getConsumerList();
		request.setAttribute("List", list);
=======
		// 저장된 카테고리를 가져와 뷰페이지로 이동하는 비즈니스 로직
				
		Ks_ProductDAO dao = Ks_ProductDAO.getInstance();
		
		List<Ks_ProductDTO> list = dao.getKsProductList();
		
		request.setAttribute("productCode", list);
		
>>>>>>> 28e142edc15046037b1d242403d22f1980660153:src/com/user/action/FoodAction.java
		ActionForward forward = new ActionForward();

		forward.setRedirect(false);
		forward.setPath("admin/admin_user_list_consumer.jsp");

		return forward;
	}

}
