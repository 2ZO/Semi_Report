package org.kosta.controller.third;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.controller.Controller;
import org.kosta.model.DAO.RSDAO;
import org.kosta.model.VO.MemberVO;
import org.kosta.model.VO.RSVO;

public class Read_RegisterController implements Controller {
	//수강내역
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		MemberVO vo=(MemberVO) session.getAttribute("memberVO");//session값 받기
		if(session==null||vo==null) {
			//비로그인 시 로그인유도
			return "/DispatcherServlet?command=page&url=/Member/Login.jsp";
		}
		//회원 Id에 저장된 수강내역List 보내기
		ArrayList<RSVO> list=RSDAO.getInstance().Read_RegisteRStatus(vo.getId());
		request.setAttribute("registerStatus_list", list);
		request.setAttribute("url", "/TimeTable/RegisterStatus.jsp");
		return "/Template/layout.jsp";
	}
}
