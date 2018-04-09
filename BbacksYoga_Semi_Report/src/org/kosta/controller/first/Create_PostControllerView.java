package org.kosta.controller.first;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.controller.Controller;

public class Create_PostControllerView implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("url", "/Post/PostCreate.jsp");
		return "Template/layout.jsp";
	}

}
