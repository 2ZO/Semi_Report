package org.kosta.controller.second;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.kosta.controller.Controller;
import org.kosta.model.DAO.ClassDAO;
import org.kosta.model.DAO.ProgramDAO;
import org.kosta.model.DAO.TeacherDAO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Read_AvailableTimeController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String tempTeacher = request.getParameter("teacher");
		String program = request.getParameter("program");
		String day= request.getParameter("day");
		String teacher=null;
		String[][] mapping= {{"mon","월"},{"tue","화"},{"wed","수"},{"thu","목"},{"fri","금"},{"sat","토"}};
		String[][] mapping2= {{"mon","1"},{"tue","2"},{"wed","3"},{"thu","4"},{"fri","5"},{"sat","6"}};
	
		for(int i=0;i<tempTeacher.length();i++) {
			if(tempTeacher.charAt(i)=='<') {
				teacher=tempTeacher.substring(0, i);
				break;
			}
		}//닉네임이 따라와서 걸러내는 알고리즘
		
		for(int i=0;i<mapping.length;i++) {
			if(day.equals(mapping[i][1])) {
				System.out.println();
				day=mapping[i][0];
				break;
			}
		}//day가 한글로 들어옴...
		//프라이머리값을 다시 불러와서 class를 찾는다
		String pNo=ProgramDAO.getInstance().getProgramNoByName(program);
		String tNo=TeacherDAO.getInstance().getTeacherNoByName(teacher);
		
		ArrayList<String> timeList=ClassDAO.getInstance().getAvailableTime(tNo,pNo,day);
		
		//이거 넘기기기
		JSONObject json= null;
		if(timeList == null || timeList.size()<1) {
			json= new JSONObject().put("flag", "false"); 
			//클래스가 없으면 false반환
		}else{
			json= new JSONObject().put("avaTime", timeList);
		}
		request.setAttribute("responseBody", json);
		return "AjaxView";
	}

}
