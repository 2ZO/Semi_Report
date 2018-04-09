package org.kosta.controller.second;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.kosta.controller.Controller;
import org.kosta.model.DAO.ClassDAO;
import org.kosta.model.DAO.TeacherDAO;
import org.kosta.model.VO.TeacherVO;

public class Read_TeacherDetailController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 파라미터 값을 가져온다
		String teacherId=request.getParameter("teacherId");
		
		//파라미터 값으로 반환할 값을 정의
		TeacherVO tvo=TeacherDAO.getInstance().getTeacherInfobyId(teacherId);
		ArrayList<String> classList=ClassDAO.getInstance().getClassListById(teacherId);
		
		//ajax 이전 컨트롤러
		/*
		request.setAttribute("classList", classList);
		request.setAttribute("teacherInfo", tvo);
		request.setAttribute("url", "/Class/TeacherDetail.jsp");
		return "Template/layout.jsp";*/
		
		//tvo string 방식으로 변경
		
		//ajax 컨트롤러
		JSONObject json=null;	// return 값을 넣을 jsonObject 선언
		// 각각의 값을 jsonObject에 넣음
		json=new JSONObject().put("classList", classList);
		json.put("teacherId", tvo.getTeacherId());
		json.put("teacherName", tvo.getTeacherName());
		json.put("teacherNick", tvo.getTeacherNick());
		json.put("teacherProfile", tvo.getTeacherProfile());
		json.put("img_url", tvo.getImg_url());		
		//ajaxview에 값을 넣은 josn을 반환
		request.setAttribute("responseBody", json);
		return "AjaxView";
		
	}

}
