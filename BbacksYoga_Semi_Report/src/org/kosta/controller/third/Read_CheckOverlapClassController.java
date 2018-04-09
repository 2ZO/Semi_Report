package org.kosta.controller.third;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.kosta.controller.Controller;
import org.kosta.model.DAO.RSDAO;
import org.kosta.model.VO.MemberVO;

public class Read_CheckOverlapClassController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		MemberVO vo=(MemberVO) session.getAttribute("memberVO");
		JSONObject json=null;
		if(vo==null)
			return "/DispatcherServlet?command=page&url=/Member/Login.jsp";
		
		boolean flag=RSDAO.getInstance().Check_OverlapByClassNo(request.getParameter("classNo"),vo.getId());
		
		json=new JSONObject();
		json.put("flag", flag);
		request.setAttribute("responseBody", json);
		return "AjaxView";
	}
}
