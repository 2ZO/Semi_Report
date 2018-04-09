package org.kosta.controller.third;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.controller.Controller;

public class tempController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("flag_no", 1);
		return "/DispatcherServlet?command=Read_Timetable";
	}
}
