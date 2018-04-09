package org.kosta.controller.first;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.controller.Controller;
import org.kosta.model.DAO.PostDAO;
import org.kosta.model.VO.MemberVO;

public class Create_PostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		MemberVO mvo=(MemberVO)session.getAttribute("memberVO");
		//비회원이라고 생각하고
		String id="visitor";
		//비회원이 아니면 session정보가 입력됨
		if(mvo!=null)
			id=mvo.getId();		
		//게시판에 글쓰기
		PostDAO.getInstance().createPost(title,content,id);
		return "DispatcherServlet?command=postList&nowPage=1";
	}

}
