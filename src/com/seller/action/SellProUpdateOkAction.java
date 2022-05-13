package com.seller.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.seller.model.ProductDAO;
import com.seller.model.ProductDTO;

public class SellProUpdateOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 상품 수정 폼 페이지에서 넘어온 데이터들을 
		// DB에 수정하는 비지니스 로직.
		
		// 첨부파일이 저장될 위치(경로)를 설정.
		String saveFolder = 
				"C:\\NCS\\workspace(jsp)\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\KH-group2-semi\\pimg";
		
		// 첨부파일 용량(크기) 제한 - 파일 업로드 최대 크기
		int fileSize = 10 * 1024 * 1024;  // 10MB
		
		// 이지파일 업로드를 위한 객체 생성
		MultipartRequest multi = new MultipartRequest(
				request, 
				saveFolder, 
				fileSize,
				"UTF-8",
				new DefaultFileRenamePolicy()
		);
		
		// 수정 폼 페이지에서 넘어온 데이터들을 받아주자.
		String p_name = multi.getParameter("p_name").trim();
		
		String p_code= multi.getParameter("p_code").trim();
		
		String p_company = multi.getParameter("p_company").trim();
		
		int p_qty = Integer.parseInt(multi.getParameter("p_qty").trim());
		
		int p_price = Integer.parseInt(multi.getParameter("p_price").trim());
		
		String p_spec = multi.getParameter("p_spec").trim();
		
		String p_content = multi.getParameter("p_content").trim();
		
		int p_point = Integer.parseInt(multi.getParameter("p_point").trim());
		
		int p_no = Integer.parseInt(multi.getParameter("p_no").trim());
		
		String p_image_new = multi.getFilesystemName("p_image_new");
		
		if(p_image_new == null) {  // 수정할 첨부파일 이미지가 없는 경우
			p_image_new = multi.getParameter("p_image_old");
		}
		
		ProductDTO dto = new ProductDTO();
		
		dto.setPno(p_no);
		
		dto.setPname(p_name);
		
		dto.setPcode(p_code);
		
		dto.setPcompany(p_company);
		
		dto.setPimage(p_image_new);
		
		dto.setPqty(p_qty);
		
		dto.setPrice(p_price);
		
		dto.setPspec(p_spec);
		
		dto.setPcontents(p_content);
		
		dto.setPoint(p_point);
		
		
		ProductDAO dao = ProductDAO.getInstance();
		
		int check = dao.updateProduct(dto);
		
		ActionForward forward = new ActionForward();
		
		PrintWriter out = response.getWriter();
		
		if(check > 0) {
			
			forward.setRedirect(true);
			
			forward.setPath("sellProList.do");
			
		}else {
			out.println("<script>");
			out.println("alert('제품 정보 수정을 실패했습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
