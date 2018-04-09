package org.kosta.controller.second;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.controller.Controller;
import org.kosta.model.DAO.ProgramDAO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class Create_ProgramImgController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ServletContext ctx=request.getServletContext();
		
		//파일 업로드용 - request, 저장폴더, 최대용량, 인코딩, 같은이름 파일처리방법
		String savePath=ctx.getRealPath("Image/program");	//저장 폴더명
		System.out.println(savePath);
		int maxPostSize=10*1024*1024; //10MB
		String format="UTF-8";	
		
		MultipartRequest req=new MultipartRequest(request,savePath,maxPostSize,format,new DefaultFileRenamePolicy());
		
		String programHit=req.getParameter("programHit");
		String imgURL1=req.getOriginalFileName("programFile1");
		String imgURL2=req.getOriginalFileName("programFile2");
		String imgURL3=req.getOriginalFileName("programFile3");
		String imgURL4=req.getOriginalFileName("programFile4");
		System.out.println(programHit+imgURL1+imgURL2+imgURL3+imgURL4);
		ProgramDAO.getInstance().addProgramImg(programHit, imgURL1, imgURL2, imgURL3, imgURL4);
		return  "DispatcherServlet?command=programList";
	}
}
