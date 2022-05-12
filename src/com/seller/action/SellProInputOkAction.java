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

public class SellProInputOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 상품 등록 폼 페이지에서 넘어온 데이터들을
		// DB에 저장하는 비지니스 로직.
		
		// 첨부파일이 저장될 위치(경로)를 설정.
		String saveFolder = 
				"C:\\Users\\nsims\\git\\KH-group2-semi\\WebContent\\pimg";
		
		// 첨부파일 용량(크기) 제한 - 파일 업로드 최대 크기
		int fileSize = 10 * 1024 * 1024;  // 10MB
		
		// 이미지파일 업로드 객체 생성
		MultipartRequest multi = new MultipartRequest(
				request, 
				saveFolder, 
				fileSize,
				"UTF-8",
				new DefaultFileRenamePolicy()
		);
		
		// 상품등록 폼 페이지에서 넘어온 데이터들을 받기
		
		String p_name = multi.getParameter("p_name").trim();
		
		String p_code = multi.getParameter("p_code").trim();
		
		String p_company = multi.getParameter("p_company").trim();
		
		// getFilesystemName() : 서버 상에 실제로 업로드될 파일의 이름을 문자열로 반환.
		String p_image = multi.getFilesystemName("p_image");
		
		int p_qty = Integer.parseInt(multi.getParameter("p_qty").trim());
		
		String p_spec = multi.getParameter("p_spec").trim();
		
		int p_price = Integer.parseInt(multi.getParameter("p_price").trim());
		
		String p_content = multi.getParameter("p_content").trim();
		
		int p_point = Integer.parseInt(multi.getParameter("p_point").trim());
		

		
		ProductDTO dto = new ProductDTO();
		
		
		dto.setPname(p_name);
		
		dto.setPcode(p_code);
		
		dto.setPcompany(p_company);
		
		dto.setPimage(p_image);
		
		dto.setPqty(p_qty);
		
		dto.setPrice(p_price);
		
		dto.setPspec(p_spec);
		
		dto.setPcontents(p_content);
		
		dto.setPoint(p_point);
		
		
		
		ProductDAO dao = ProductDAO.getInstance();
		
		int check = dao.insertProduct(dto);
		
		ActionForward forward = new ActionForward();
		
		PrintWriter out = response.getWriter();
		
		if(check > 0) {
			
			forward.setRedirect(true);
			
			forward.setPath("sell_pro_list.do");  // 상품 목록 컨트롤러로 이동
		}else {
			out.println("<script>");
			out.println("alert('상품 등록에 실패했습니다.')");
			out.println("history.back()");
			out.println("</script>");
		}
				
		
		return forward;
	}

}
