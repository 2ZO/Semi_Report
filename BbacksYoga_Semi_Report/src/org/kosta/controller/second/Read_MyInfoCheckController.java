package org.kosta.controller.second;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.controller.Controller;
import org.kosta.model.DAO.MemberDAO;
import org.kosta.model.VO.MemberVO;

public class Read_MyInfoCheckController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		String password = null;
		if(session==null) {
			return "Member/noSession.jsp";
		}else{
			MemberVO mvo=(MemberVO)session.getAttribute("memberVO");
			String id=mvo.getId();
			if(request.getParameter("memberPassword")==null){
				@SuppressWarnings("unchecked")
				ArrayList<MemberVO> list =  (ArrayList<MemberVO>) request.getAttribute("list");
				password = list.get(0).getPassword();
			}
			else	
				password=request.getParameter("memberPassword");
			mvo=MemberDAO.getInstance().checkMyinfoById(id, password);
			if(mvo==null)
				return "Member/MyInfoCheck_fail.jsp";
			else {
				request.setAttribute("MemberVO", mvo);
				request.setAttribute("url","/Member/MyInfoModify.jsp");
				return "Template/layout.jsp";
			}
		}
	}
}
