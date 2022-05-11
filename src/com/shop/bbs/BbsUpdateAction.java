package com.shop.bbs;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.BoardDAO;
import com.shop.model.BoardDTO;

public class BbsUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int bbs_no = 
				Integer.parseInt(request.getParameter("no").trim());		
		
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardDTO dto = dao.getBbsContent(bbs_no);
		
		request.setAttribute("modify", dto);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("bbs/bbs_update.jsp");
		
		return forward;
	}

}
