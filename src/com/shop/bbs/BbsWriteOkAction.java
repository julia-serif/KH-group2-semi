package com.shop.bbs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.BoardDAO;
import com.shop.model.BoardDTO;

public class BbsWriteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String board_title = request.getParameter("title").trim();
		String board_cont = request.getParameter("content").trim();
		
		BoardDTO dto = new BoardDTO();
		
		dto.setBoard_title(board_title);
		dto.setBoard_cont(board_cont);
		
		BoardDAO dao = BoardDAO.getInstance();
		
		int check = dao.insertBoard(dto);
		
		PrintWriter out = response.getWriter();
		
		ActionForward forward = new ActionForward();
		
		if(check > 0) {
			out.println("<script>");
			out.println("alert('게시물 추가 성공')");
			out.println("</script>");
			forward.setRedirect(true);
			forward.setPath("user_product_view.do");
		}else {
			out.println("<script>");
			out.println("alert('게시물 추가 실패')");
			out.println("history.back()");
			out.println("</script>");
			
		}
		
		return forward;
		
	}

}
