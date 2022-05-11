package com.shop.bbs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.BoardDAO;
import com.shop.model.BoardDTO;

public class BbsUpdateOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String bbs_title = request.getParameter("title").trim();
		String bbs_cont = request.getParameter("content").trim();
		
		int bbs_no = 
				Integer.parseInt(request.getParameter("bbs_no").trim());
		
		
		BoardDTO dto = new BoardDTO();
		
		dto.setBoard_no(bbs_no);
		dto.setBoard_title(bbs_title);
		dto.setBoard_cont(bbs_cont);
		
		BoardDAO dao = BoardDAO.getInstance();
		
		int check = dao.updateBbs(dto);
		
		ActionForward forward = new ActionForward();
		
		PrintWriter out = response.getWriter();
		
		if(check > 0) {
			forward.setRedirect(true);
			forward.setPath("bbs_content.do?no="+bbs_no);
		
		}else {
			out.println("<script>");
			out.println("alert('게시물 수정 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
