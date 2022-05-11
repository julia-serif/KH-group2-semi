package com.shop.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.controller.Action;
import com.shop.controller.ActionForward;
import com.shop.model.CartDAO;

public class UserCheckedDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//선택된 체크박스의 cart_num을 배열로 가져옴
		String[] sArr = request.getParameterValues("string");
		
		System.out.println("값: " + request.getParameterValues("string"));
		
		//배열은 parseInt가 안되기 때문에 sArr크기의 int형 배열을 생성
		int[] cbArr = new int[sArr.length];
		
		//for문으로 형변환 작업을 시켜줌
		for(int i=0; i<sArr.length; i++) {
			cbArr[i] = Integer.parseInt(sArr[i]);
		}
		
		CartDAO dao = CartDAO.getInstance();
		
		int check = dao.checkedBoxDelete(cbArr);
		
		PrintWriter out = response.getWriter();
		
		//ajax에 넘겨줌
		out.println(check);
		
		
		return null;
		
		
	}

}

