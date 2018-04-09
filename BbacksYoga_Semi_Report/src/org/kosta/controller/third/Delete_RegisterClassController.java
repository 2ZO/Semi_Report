package org.kosta.controller.third;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.controller.Controller;
import org.kosta.model.DAO.RSDAO;
import org.kosta.model.VO.MemberVO;

public class Delete_RegisterClassController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		MemberVO vo=(MemberVO) session.getAttribute("memberVO");
		RSDAO.getInstance().Delete_RegisterClass(vo.getId(),Integer.parseInt(request.getParameter("classNo")));
		return "redirect:DispatcherServlet?command=Read_Register";
	}
}
