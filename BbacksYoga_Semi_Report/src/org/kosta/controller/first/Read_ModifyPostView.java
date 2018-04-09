package org.kosta.controller.first;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.controller.Controller;
import org.kosta.model.DAO.PostDAO;
import org.kosta.model.VO.PostVO;

public class Read_ModifyPostView implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("postNo");
		PostVO pvo=PostDAO.getInstance().getPostDetailByPostNo(id);
		request.setAttribute("postVO", pvo);
		request.setAttribute("url", "/Post/PostModify.jsp");
		return "Template/layout.jsp";
	}

}
