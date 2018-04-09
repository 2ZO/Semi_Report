package org.kosta.controller.third;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.controller.Controller;
import org.kosta.model.DAO.RSDAO;
import org.kosta.model.VO.MemberVO;
import org.kosta.model.VO.RSVO;

public class Read_TimeTableController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		MemberVO vo=(MemberVO) session.getAttribute("memberVO");//session값 받기
		ArrayList<RSVO> list=new ArrayList<RSVO>();
		if(session==null||vo==null) {
			list=RSDAO.getInstance().readTimetableInfo();
		}else {
			int user_package = RSDAO.getInstance().readUserPackage(vo.getId());
			request.setAttribute("userPackage", user_package);
			list=RSDAO.getInstance().readTimetableInfo();
		}
		request.setAttribute("url", "/TimeTable/TimeTable.jsp");
		request.setAttribute("timetable_list", list);
		return "Template/layout.jsp";
	}
}
