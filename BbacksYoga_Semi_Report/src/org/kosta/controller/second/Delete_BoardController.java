package org.kosta.controller.second;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.controller.Controller;
import org.kosta.model.DAO.PostDAO;

public class Delete_BoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String postNo=request.getParameter("postNo");
		PostDAO.getInstance().deletePost(postNo);
		return "DispatcherServlet?command=postList&nowPage=1";
	}

}
