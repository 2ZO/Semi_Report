package org.kosta.controller.first;



import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.controller.Controller;
import org.kosta.model.DAO.PostDAO;
import org.kosta.model.VO.PostListVO;
import org.kosta.model.VO.PostVO;
import org.kosta.model.etc.PagingBean;

public class Read_BoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int total=PostDAO.getInstance().getTotalPostCount();
		String nowpage=request.getParameter("nowPage");
		PagingBean pb=null;
		if(nowpage==null) {
			pb=new PagingBean(total);
		}else {
			pb=new PagingBean(total,Integer.parseInt(nowpage));
		}
		ArrayList<PostVO> list=PostDAO.getInstance().getPostingList(pb);
		PostListVO lvo=new PostListVO(list,pb);
		request.setAttribute("lvo", lvo);
		request.setAttribute("url", "/Post/QNA.jsp");
		return "Template/layout.jsp";
	}
}
