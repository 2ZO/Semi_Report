package org.kosta.controller.second;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.kosta.controller.Controller;
import org.kosta.model.DAO.ProgramDAO;
import org.kosta.model.VO.ProgramVO;

public class Create_ProgramController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String programName = request.getParameter("programName");
		String programDetail =request.getParameter("programDetail");
		String programNo=ProgramDAO.getInstance().addProgram(programName, programDetail);
		ProgramVO program= ProgramDAO.getInstance().getProgramListByNoUseByMA(Integer.parseInt(programNo));
		
		JSONObject json= null;
		if(program == null) {
			json= new JSONObject().put("flag", "false"); //클래스가 없으면 false반환
		}else{
			System.out.println(program.getProgramDetail());
			json= new JSONObject().put("programDetail", program.getProgramDetail());
			json.put("programName", program.getProgramName());
		}
		request.setAttribute("responseBody", json);
		return "AjaxView";
	}
}
