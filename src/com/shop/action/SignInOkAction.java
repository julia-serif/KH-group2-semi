package com.shop.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.model.UserDAO;
import com.shop.model.UserDTO;

public class SignInOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String user_id = request.getParameter("id").trim();
		String user_pwd = request.getParameter("pwd").trim();

		UserDAO dao = UserDAO.getInstance();
		int check = dao.userCheck(user_id, user_pwd);// 아이디 검사

		List<UserDTO> list = dao.getUserList(); // 관리자 메인 페이지에서 가입된 전체 유저 리스트를 출력하기 위한 메서드
		request.setAttribute("List", list);

		ActionForward forward = new ActionForward();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		if (check > 0) {
			// 회원인 경우
			UserDTO dto = dao.getuser(user_id);
			session.setAttribute("user_id", dto.getUser_id());
			session.setAttribute("user_name", dto.getUser_name());

			forward.setRedirect(false);
			
			if (dto.getUser_grade().equals("판매자")) {
				if (dto.getUser_level() == 1) {	//가입승인을 받은 판매자 계정
					forward.setPath("view/_seller.jsp");
				} else {//가입승인을 받지 못한 판매자 계정
					out.println("<script>");
					out.println("alert('관리자의 승인이 필요합니다.')");
					out.println("history.back()");
					out.println("</script>");
				}
			} else if (dto.getUser_grade().equals("관리자")) {
				forward.setPath("admin/admin_main.jsp");
			} else if (dto.getUser_grade().equals("구매자")) {
				forward.setPath("view/_custommer.jsp");
			} else {
				out.println("<script>");
				out.println("alert('error')");
				out.println("history.back()");
				out.println("</script>");
			}

		} else if (check == -1) {
			// 비밀번호가 틀린 경우
			out.println("<script>");
			out.println("alert('비밀번호가 틀립니다. 확인해 주세요~~~')");
			out.println("history.back()");
			out.println("</script>");

		} else {
			// 회원이 아닌 경우(아이디가 없거나 아이디가 틀린 경우)
			out.println("<script>");
			out.println("alert('없는 아이디입니다. 다시 한 번 아이디를 확인하세요~~~')");
			out.println("history.back()");
			out.println("</script>");
		}

		return forward;
	}

}
