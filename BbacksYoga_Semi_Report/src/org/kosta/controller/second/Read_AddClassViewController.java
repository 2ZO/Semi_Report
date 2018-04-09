package org.kosta.controller.second;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.controller.Controller;
import org.kosta.model.DAO.ClassDAO;
import org.kosta.model.DAO.ProgramDAO;
import org.kosta.model.DAO.TeacherDAO;
import org.kosta.model.VO.ClassVO;
import org.kosta.model.VO.MemberVO;
import org.kosta.model.VO.ProgramVO;
import org.kosta.model.VO.TeacherVO;

public class Read_AddClassViewController implements Controller {
//관리자용 뷰 컨트롤러
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String option=request.getParameter("option");
		ArrayList<TeacherVO> tlist=null;
		ArrayList<ClassVO> classList =null;
		ArrayList<ProgramVO> plist= null;
		//옵션을 파라미터로 받아서
		//클래스/티쳐/프로그램 리스트를 여기서 골라서 뽑아간다
		HttpSession session = request.getSession();
		if(session.getAttribute("memberVO")==null) {
			request.setAttribute("url", "/Template/center");
			return "redirect:admin_ver2/NotAdmin.jsp";
		}else {
			MemberVO member= (MemberVO) session.getAttribute("memberVO");
			if(!member.getId().equals("sys")) {
				request.setAttribute("url", "/Template/center");
				return "redirect:admin_ver2/NotAdmin.jsp";
			}
		}
		//관리자 페이지에 sys가 아닌 다른인간이 들어오면 쫒아냄
		if(option.equals("class")) {
			plist=ProgramDAO.getInstance().getProgramList();
			request.setAttribute("programList", plist);
			tlist=TeacherDAO.getInstance().getTeacherList();
			request.setAttribute("teacherList", tlist);
			classList= ClassDAO.getInstance().getClassList();
			request.setAttribute("classList", classList);
			request.setAttribute("url", "/admin_ver2/Create_AddClass.jsp");
		}else if(option.equals("teacher")) {
			tlist=TeacherDAO.getInstance().getTeacherList();
			request.setAttribute("teacherList", tlist);
			request.setAttribute("url", "/admin_ver2/Create_AddTeacher.jsp");
		}else if(option.equals("program")){
			plist=ProgramDAO.getInstance().getProgramList();
			request.setAttribute("programList", plist);
			request.setAttribute("url", "/admin_ver2/Create_AddProgram.jsp");
		}else {
			System.out.println("스펠링체크");
		}
		return "index.jsp";
	}

}
