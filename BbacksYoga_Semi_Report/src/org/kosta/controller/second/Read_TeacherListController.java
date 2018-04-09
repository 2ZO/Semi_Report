package org.kosta.controller.second;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.controller.Controller;
import org.kosta.model.DAO.TeacherDAO;
import org.kosta.model.VO.TeacherVO;

public class Read_TeacherListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<TeacherVO> tlist=TeacherDAO.getInstance().getTeacherList();
		request.setAttribute("teacherList", tlist);
		request.setAttribute("url", "/Class/TeacherList.jsp");
		return "Template/layout.jsp";
	}

}
