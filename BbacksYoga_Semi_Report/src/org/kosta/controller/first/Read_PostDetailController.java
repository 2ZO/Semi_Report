package org.kosta.controller.first;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.controller.Controller;
import org.kosta.model.DAO.PostDAO;
import org.kosta.model.VO.PostVO;

public class Read_PostDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String postNo = request.getParameter("postNo");
		HttpSession session = request.getSession(false);
		// 나중에 비공개글 할 때 쓸생각임
		/*
		 * if(session==null || session.getAttribute("memberVO")==null) { return
		 * "redirect:Post/QNA.jsp"; }else
		 */
		PostVO post = PostDAO.getInstance().getPostDetailByPostNo(postNo);
		request.setAttribute("postVO", post);
		request.setAttribute("url", "/Post/PostDetail.jsp");
		return "index.jsp";
	}

}
