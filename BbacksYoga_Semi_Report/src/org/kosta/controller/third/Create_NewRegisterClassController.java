package org.kosta.controller.third;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.controller.Controller;
import org.kosta.model.DAO.RSDAO;
import org.kosta.model.VO.MemberVO;

public class Create_NewRegisterClassController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		MemberVO vo=(MemberVO) session.getAttribute("memberVO");
		if(vo==null)
			return "/DispatcherServlet?command=page&url=/Member/Login.jsp";
		
		String[] regList=request.getParameter("classNo").split(",");
		ArrayList<String> classNoList=new ArrayList<String>();
		for(String classNo : regList)
			RSDAO.getInstance().NewRegisterClass(classNo, vo.getId());
		
			return "redirect:DispatcherServlet?command=Read_Timetable";
	}
}
