package org.kosta.controller.second;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.kosta.controller.Controller;
import org.kosta.model.DAO.ClassDAO;
import org.kosta.model.VO.ClassVO;
import org.kosta.model.VO.ProgramVO;
import org.kosta.model.VO.TeacherVO;

public class Create_ClassController implements Controller {

	@SuppressWarnings("unused")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
				String teacherId=request.getParameter("teacherId");
				String programId=request.getParameter("programId");
				String day=request.getParameter("day");
				String time=request.getParameter("time");
				String capacity=request.getParameter("capacity");
				
				//ajax로 추가된 리스트의 속성을 보낸다
				String classNo=ClassDAO.getInstance().createClass(teacherId,programId,day,time,capacity);
				JSONObject json = null;
				ClassVO classVo=ClassDAO.getInstance().getClassById(classNo);
				ProgramVO program = classVo.getProgram();
				TeacherVO teacher = classVo.getTeacher();

				if(classVo == null) {
					json= new JSONObject().put("flag", "false"); //클래스가 없으면 false반환
				}else{
					json= new JSONObject().put("teacherName", teacher.getTeacherName());
					json.put("programName", program.getProgramName());
					System.out.println(program.getProgramName());
					json.put("classDay", classVo.getClassDay());
					json.put("classTime", classVo.getClassTime());
				}
				request.setAttribute("responseBody", json);
				return "AjaxView";
				/*return "redirect:DispatcherServlet?command=addClassView";*/
	}

}
