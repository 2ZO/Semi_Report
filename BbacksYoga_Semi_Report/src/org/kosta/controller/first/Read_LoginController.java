package org.kosta.controller.first;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.kosta.controller.Controller;
import org.kosta.model.DAO.MemberDAO;
import org.kosta.model.VO.MemberVO;

public class Read_LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String id = request.getParameter("userId").trim();
		String password = request.getParameter("userPassword").trim();
		MemberVO vo = MemberDAO.getInstance().LogIn(id, password);
		HttpSession session = request.getSession();
		JSONObject json = null;
		if (vo == null) {
			json= new JSONObject().put("flag", "false");
			//로그인 실패의 경우 json object에 flag를 키로 false값을 담아 보낸다.
		} else {
			json= new JSONObject().put("flag", "true");
			session.setAttribute("memberVO", vo);
			request.setAttribute("url", "/Template/center.jsp");
		}
		request.setAttribute("responseBody", json);
		return "AjaxView";
	}

}
