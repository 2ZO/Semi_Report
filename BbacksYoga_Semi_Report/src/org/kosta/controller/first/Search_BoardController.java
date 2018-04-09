package org.kosta.controller.first;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.kosta.controller.Controller;
import org.kosta.model.DAO.PostDAO;
import org.kosta.model.VO.PostListVO;
import org.kosta.model.VO.PostVO;
import org.kosta.model.etc.PagingBean;



public class Search_BoardController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String opt=request.getParameter("opt");
		String keyword=request.getParameter("keyword");
		String nowpage=request.getParameter("nowPage");
		
		int total=PostDAO.getInstance().getTotalSearchPostCount(opt,keyword);
		PagingBean pb=null;
		if(nowpage==null) {
			pb=new PagingBean(total);
		}else {
			pb=new PagingBean(total,Integer.parseInt(nowpage));
		}
		ArrayList<PostVO> list=PostDAO.getInstance().getPostSearch(opt,keyword,pb);
		PostListVO lvo=new PostListVO(list,pb);
		request.setAttribute("lvo", lvo);
		request.setAttribute("opt",opt);
		request.setAttribute("url", "/Post/PostSearch.jsp");
		request.setAttribute("keyword",keyword);
		return "Template/layout.jsp";
	}

}
