package com.shop.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.BoardDAO;
import com.shop.model.BoardDTO;
import com.shop.model.ProductDAO;
import com.shop.model.ProductDTO;

public class UserProductViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		int product_no = 
				Integer.parseInt(request.getParameter("pno").trim());
		
		ProductDAO dao = ProductDAO.getInstance();
		
		ProductDTO cont = dao.productContent(product_no);
		
		request.setAttribute("pCont", cont);
		
		
		BoardDAO dao1 = BoardDAO.getInstance();
		
		List<BoardDTO> list = dao1.getBbsList(product_no);
		
		request.setAttribute("List", list);
		request.setAttribute("pno", product_no);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("user/user_product_cont.jsp");
		
		return forward;
	}

}
