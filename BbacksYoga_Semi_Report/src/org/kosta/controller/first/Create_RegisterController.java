package org.kosta.controller.first;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.controller.Controller;
import org.kosta.model.DAO.MemberDAO;
import org.kosta.model.VO.MemberVO;

public class Create_RegisterController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String phone_number= request.getParameter("phone_number");
		String email= request.getParameter("email");
		String password_question= request.getParameter("password_question");
		String password_answer= request.getParameter("password_answer");
		String class_package= request.getParameter("class_package");
		
		MemberVO vo=new MemberVO(id, password, name, phone_number, address, email, password_question, password_answer, 
				null, null, class_package);	
		MemberDAO.getInstance().createMember(vo);
		return "redirect:Member/Login_succ.jsp";
	}

}
