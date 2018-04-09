package org.kosta.controller.first;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.kosta.controller.Controller;
import org.kosta.model.DAO.MemberDAO;
import org.kosta.model.VO.MemberVO;

public class Read_MemberByIdController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id").trim();
		System.out.println(id);
		boolean flag = MemberDAO.getInstance().getMemberById(id);
		JSONObject json = null;
		if (flag==false) {
			json= new JSONObject().put("flag", "false");
			//아이디가 존재 고로 사용불가능
		} else {
			json= new JSONObject().put("flag", "true");
			//아이디 없음 사용가능
		}
		request.setAttribute("responseBody", json);
		return "AjaxView";
	}

}
