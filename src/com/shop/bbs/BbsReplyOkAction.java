package com.shop.bbs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.BoardDAO;
import com.shop.model.BoardDTO;

public class BbsReplyOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 답변글 폼 페이지에서 넘어온 데이터들을
		// DB에 저장하는 비지니스 로직.
		
		String reply_writer = request.getParameter("reply_writer").trim();
		String reply_title = request.getParameter("reply_title").trim();
		String reply_content = request.getParameter("reply_content").trim();
		
		// 히든으로 넘어온 데이터들도 받아주자.
		int bbs_no = 
				Integer.parseInt(request.getParameter("bbs_no").trim());
		int bbs_group = 
				Integer.parseInt(request.getParameter("bbs_group").trim());
		int bbs_step = 
				Integer.parseInt(request.getParameter("bbs_step").trim());
		int bbs_indent = 
				Integer.parseInt(request.getParameter("bbs_indent").trim());
		int pno = 
				Integer.parseInt(request.getParameter("pno").trim());
		
		
		BoardDTO dto = new BoardDTO();
		
		dto.setBoard_no(bbs_no);
		dto.setBoard_writer(reply_writer);
		dto.setBoard_title(reply_title);
		dto.setBoard_cont(reply_content);
		dto.setBoard_group(bbs_group);
		dto.setBoard_step(bbs_step);
		dto.setBoard_indent(bbs_indent);
		dto.setBoard_product(pno);
		
		BoardDAO dao = BoardDAO.getInstance();
		
		// 만약에 원글에 기존에 작성했던 답변글이 존재하는 경우
		// 해당 답변글에 step을 하나 증가시켜주는 메서드 호출.
		dao.replyUpdate(bbs_group, bbs_step);
		
		// 답변글을 DB에 저장하는 메서드 호출
		int check = dao.replyBbs(dto);
		
		ActionForward forward = new ActionForward();
		
		PrintWriter out = response.getWriter();
		
		if(check > 0) {
			forward.setRedirect(true);
			forward.setPath("user_product_view.do?pno=" + pno);
		}else {
			out.println("<script>");
			out.println("alert('게시물 답변글 등록 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
