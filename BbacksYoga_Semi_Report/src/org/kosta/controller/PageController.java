package org.kosta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String url=request.getParameter("url");
		HttpSession session = request.getSession();
		if(url.contains("MyInfoCheck")&&session.getAttribute("memberVO")==null) {
			request.setAttribute("url", "/Member/Login.jsp");
		}else{
			request.setAttribute("url", url);
		}
		return "Template/layout.jsp";
	}

}
