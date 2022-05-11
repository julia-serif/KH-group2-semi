package com.shop.bbs;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.BoardDAO;
import com.shop.model.BoardDTO;

public class BbsContentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		int bbs_no =
				Integer.parseInt(request.getParameter("no").trim());
		
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardDTO dto =  dao.getBbsContent(bbs_no);
		
		// 글번호에 해당하는 상세내역을 view page로 이동시키자.
		request.setAttribute("bCont", dto);
		request.setAttribute("pno", dto.getBoard_product());
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("bbs/bbs_content.jsp");
				
		return forward;
		
		
	}

}
