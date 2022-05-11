package com.shop.bbs;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.BoardDAO;
import com.shop.model.BoardDTO;

public class BbsWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int pno =
				Integer.parseInt(request.getParameter("pno").trim());
				
		request.setAttribute("pno", pno);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("bbs/bbs_write.jsp");
				
		return forward;
	}

}
