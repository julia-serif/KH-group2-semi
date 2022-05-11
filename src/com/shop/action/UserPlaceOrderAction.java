package com.shop.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.CartDAO;
import com.shop.model.OrderDAO;
import com.shop.model.ProductDAO;
import com.shop.model.ProductDTO;
import com.shop.model.UserDAO;

public class UserPlaceOrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//주문자 정보
		String email = request.getParameter("email").trim();
		String name = request.getParameter("name").trim();
		String userAddr = request.getParameter("userAddr").trim();
		String phone = request.getParameter("phone").trim();
		String id = request.getParameter("id").trim();
		
		//수령인 정보
		String nameAddr = request.getParameter("nameAddr").trim();
		String phoneAddr = request.getParameter("phoneAddr").trim();
		String addr = request.getParameter("addr").trim();
		String merchant_uid = request.getParameter("merchant_uid").trim();
		//주문자 포인트, 결제관련
		String usePointt = request.getParameter("usePoint").trim();
		//사용 포인트가 0일경우
		int usePoint = 0;
		//사용 포인트가 0이 아닐 경우
		if(usePointt != "") {
			usePoint = Integer.parseInt(request.getParameter("usePoint").trim());
		}
		int savePoint = Integer.parseInt(request.getParameter("savePoint").replaceAll(",","").trim());
		int allTotalPrice = Integer.parseInt(request.getParameter("allTotalPrice").replaceAll(",","").trim());
		
		//결제된 상품들. 각각의 상품들의 정보를 받아주어야한다. 
		String[] ppnum = request.getParameterValues("pnum[]");


		String[] ppqty = request.getParameterValues("pqty[]");
		String[] ppPrice = request.getParameterValues("pPrice[]");
		String[] seller = request.getParameterValues("seller[]");
		String[] cartnumm = request.getParameterValues("cartno[]");
		
		//카트 삭제를 위해 카트 넘버 가져옴
		System.out.println("cartnumm : ");
		System.out.println(cartnumm[0]);
		System.out.println("ppnum :   ");
		System.out.println(ppnum[0]);
		
		int[] cartnum = new int[cartnumm.length];
		int[] pnum = new int[ppnum.length]; 
		int[] pqty = new int[ppqty.length];
		int[] pPrice = new int[ppPrice.length];
		
		System.out.println(cartnum);
		
		
		for(int i=0; i<ppnum.length; i++) { pnum[i] = Integer.parseInt(ppnum[i]); }
		
		for(int i=0; i<ppqty.length; i++) {
			pqty[i] = Integer.parseInt(ppqty[i]);
		}
		for(int i=0; i<ppPrice.length; i++) {
			pPrice[i] = Integer.parseInt(ppPrice[i]);
		}
		for(int i=0; i<cartnumm.length; i++) {
			cartnum[i] = Integer.parseInt(cartnumm[i]);
		}
		
		
		
		OrderDAO dao = OrderDAO.getInstance();
		
		
		int check = dao.saveOrderData(email, name, userAddr, phone, id, nameAddr,
		phoneAddr, addr, usePoint, savePoint, allTotalPrice , pnum, pqty, pPrice,
		seller, merchant_uid);
		
		
		//주문완료된 것들 카트에서 삭제
		CartDAO dao1 = CartDAO.getInstance();
		dao1.checkedBoxDelete(cartnum);
		
		//제품 DB에서 재고 줄이기 
		ProductDAO dao2 = ProductDAO.getInstance();
		
		dao2.productQty(pnum, pqty);
		
		
		PrintWriter out = response.getWriter();
		
		out.println(check);
		
		
/*			email : email,
			name : name,
			addr : addr,
			phone : phone,
			id : id,
			nameAddr : nameAddr,
			phoneAddr : phoneAddr,
			addr : addr,
			
			usePoint : usePoint,
			savePoint : savePoint,
			allTotalPrice : allTotalPrice,
			pnum : pnum,
			pqty : pqty,
			pPrice : pPrice,
			seller : seller*/
		
		return null;
	}

}
