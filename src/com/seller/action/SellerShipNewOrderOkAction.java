package com.seller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seller.model.ViewProductOrderDAO;
import com.seller.model.ViewProductOrderDTO;
import com.shop.controller.Action;
import com.shop.controller.ActionForward;

public class SellerShipNewOrderOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// checkbox에 체크한 상품주문번호에 해당하는 주문들을 배송처리하는 비지니스 로직.
		String user_id = (String) request.getSession().getAttribute("user_id");
		ViewProductOrderDAO dao = ViewProductOrderDAO.getInstance();
		
		
		//checkbox를 체크한 상품주문번호들을 getParameterValues로 가져온다.
		String[] arr = request.getParameterValues("checked_pons");
		int[] checked_pons = new int[arr.length];
		for (int i=0; i<arr.length; i++) {
			checked_pons[i] = Integer.parseInt(arr[i]);
		}//getParameterValues의 반환값은 String[]이므로 product_order_no를 숫자로 얻기 위해 int로 변환
		
		
		//배송 상태 변경하는 메소드
		int check = dao.updateDeliveryStatus(user_id, checked_pons);
		
		//결과에 따라 alert 표시.
		ActionForward forward = new ActionForward();
		PrintWriter out = response.getWriter();
		
		if(check > 0) {
			//배송 처리 됨.
			forward.setRedirect(true);
			forward.setPath("seller_ship_delivery_check.do");
		} else {
			out.println("<script>");
			out.println("alert('배송 상태 업데이트 실패.')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
