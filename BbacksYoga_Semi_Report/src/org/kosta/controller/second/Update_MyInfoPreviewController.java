package org.kosta.controller.second;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.controller.Controller;
import org.kosta.model.DAO.MemberDAO;
import org.kosta.model.VO.MemberVO;

public class Update_MyInfoPreviewController implements Controller {

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
				MemberVO mvo1  =(MemberVO)session.getAttribute("memberVO");
				ArrayList<MemberVO> list = MemberDAO.getInstance().getPasswordById(mvo1.getId());
				request.setAttribute("list", list);
				MemberDAO.getInstance().checkMyinfoById(list.get(0).getId(), list.get(0).getPassword());
			}
		}
		return "DispatcherServlet?command=passwordCheck";
	}
}
