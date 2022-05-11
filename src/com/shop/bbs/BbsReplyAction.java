package com.shop.bbs;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.BoardDAO;
import com.shop.model.BoardDTO;

public class BbsReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// get 방식으로 넘어온 글번호에 해당하는 게시글을 조회하여 해당 게시글의 상세내역을
		// 답변 글 폼 페이지로 이동시키는 비지니스 로직.
		
		int bbs_no = 
				Integer.parseInt(request.getParameter("no").trim());
		
		BoardDAO dao = BoardDAO.getInstance();
		
		BoardDTO dto = dao.getBbsContent(bbs_no);
		
		request.setAttribute("reply", dto);
		request.setAttribute("pno", dto.getBoard_product());
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("bbs/bbs_reply.jsp");
				
		return forward;
	}

}
