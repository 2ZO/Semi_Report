package org.kosta.controller.third;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.controller.Controller;
import org.kosta.model.DAO.RSDAO;
import org.kosta.model.VO.MemberVO;

public class Create_RegisterClassController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		MemberVO vo=(MemberVO) session.getAttribute("memberVO");
		if(vo==null)
			return "/DispatcherServlet?command=page&url=/Member/Login.jsp";
		
		boolean flag=RSDAO.getInstance().RegisterClass(request.getParameter("classNo"),vo.getId());
		if(!flag)
			return "TimeTable/RegisterClass_fail.jsp";
		else {
			return "redirect:DispatcherServlet?command=Read_Timetable";
		}
	}
}
