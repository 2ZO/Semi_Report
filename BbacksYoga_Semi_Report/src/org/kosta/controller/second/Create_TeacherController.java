package org.kosta.controller.second;

import javax.mail.Multipart;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.kosta.controller.Controller;
import org.kosta.model.DAO.ClassDAO;
import org.kosta.model.DAO.TeacherDAO;
import org.kosta.model.VO.ClassVO;
import org.kosta.model.VO.ProgramVO;
import org.kosta.model.VO.TeacherVO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Create_TeacherController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//선생님 정보를 받은 값을 별도의 변수에 입력
		/*String name=request.getParameter("teacherName");
		String nick=request.getParameter("teacherNick");
		String profile=request.getParameter("teacherProfile");*/
		/*String imgURL=request.getParameter("teacherImgURL");*/
		
		ServletContext ctx=request.getServletContext();
		String saveDirectory="Image/teacher";
		/*System.out.println(ctx.getRealPath(saveDirectory));*/
		
		//파일 업로드용 - request, 저장폴더, 최대용량, 인코딩, 같은이름 파일처리방법
		String savePath=ctx.getRealPath("Image/teacher");	//저장 폴더명
		int maxPostSize=10*1024*1024;	//10MB
		String format="UTF-8";	
		
		
		MultipartRequest req=new MultipartRequest(request, savePath,maxPostSize,format,new DefaultFileRenamePolicy());
		
		//사용자의 다른 정보 저장
		String name=req.getParameter("teacherName");
		String nick=req.getParameter("teacherNick");
		String profile=req.getParameter("teacherProfile");
		String imgURL=req.getOriginalFileName("teacherFile");
		System.out.println(name+nick+profile+imgURL);
	/*	//파일명
		String oriFileName=req.getOriginalFileName("teacherFile");
		String sysFileName=req.getFilesystemName("teacherFile");
		//파일의 종류
		String contentType=req.getContentType("teacherFile");
		//파일 크기
		long fileSize=req.getFile("teacherFile").length();
		*/
		/*String imgURL=req.getOriginalFileName("teacherFile");*/
		//sql 통해서 table에 입력
		
		
		//ajax로 추가된 리스트의 속성을 보낸다
		String teacherNo=TeacherDAO.getInstance().AddTeacher(name,nick,profile,imgURL);
		JSONObject json = null;
		TeacherVO teacher = TeacherDAO.getInstance().getTeacherInfobyId(teacherNo);

		if(teacher == null) {
			json= new JSONObject().put("flag", "false"); //클래스가 없으면 false반환
		}else{
			json= new JSONObject().put("teacherName", teacher.getTeacherName());
			json.put("teacherName",teacher.getTeacherName());
			json.put("teacherNick", teacher.getTeacherNick());
			json.put("teacherProfile", teacher.getTeacherProfile());
			
		}
		request.setAttribute("responseBody", json);
		return "AjaxView";
	}

}
