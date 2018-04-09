package org.kosta.controller.second;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.controller.Controller;
import org.kosta.model.DAO.MemberDAO;
import org.kosta.model.VO.MemberVO;

public class Update_MyInfoController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null) {
			return "Member/noSession.jsp";
		} else{
			MemberVO mvo=(MemberVO)session.getAttribute("memberVO");
			if(mvo==null) {
				return "Member/MyInfoCheck_fail.jsp";
			} else {
				String id = request.getParameter("id");
				String password = request.getParameter("password");
				String password_question = request.getParameter("password_question");
				String password_answer = request.getParameter("password_answer");
				String name = request.getParameter("name");
				String address = request.getParameter("address");
				String email = request.getParameter("email");
				String phone_number = request.getParameter("phoneNumber");
				MemberVO vo = new MemberVO(id, password, name, phone_number, address, email, password_question, password_answer, null, null, null );
				MemberDAO.getInstance().updateMyInfo(vo);
				session.setAttribute("memberVO", vo);
				return "DispatcherServlet?command=updateMyInfoPreview";
			}
		}
	}
}
