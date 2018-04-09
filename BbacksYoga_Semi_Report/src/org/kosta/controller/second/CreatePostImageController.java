package org.kosta.controller.second;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.kosta.controller.Controller;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class CreatePostImageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ServletContext ctx=request.getServletContext();
		String savePath=ctx.getRealPath("Image/postImg");	//저장 폴더명
		int maxPostSize=10*1024*1024;	//10MB
		String format="UTF-8";	
		//테스트용 경로
		//String workspacePath="C:\\Users\\User\\git\\ILoveNotNull\\BbacksYoga\\WebContent\\Image\\postImg";
		MultipartRequest req=new MultipartRequest(request,savePath,maxPostSize,format,new DefaultFileRenamePolicy());
		
		//파일명
		String oriFileName=req.getOriginalFileName("postImg");
		
		//파일명 중복 확인
		String path="C:\\Users\\User\\Coding\\WAS\\web2-tomcat\\webapps\\BbacksYoga\\Image\\postImg\\";
		//가져온 파일명
		String fileName =req.getFilesystemName("postImg");
		String now = new SimpleDateFormat("yyyyMMddHmsS").format(new Date());  //현재시간
        int i = fileName.lastIndexOf("."); // 파일 확장자 위치
        String realFileName = fileName.substring(0, i)+"_" +now + fileName.substring(i, fileName.length());  //현재시간과 확장자 합치기
        File oldFile = new File(path + fileName);
        File newFile = new File(path + realFileName); 
        
        oldFile.renameTo(newFile); // 파일명 변경
		
		JSONObject json = null;
		if(oriFileName == null) {
			json= new JSONObject().put("flag", "false"); //클래스가 없으면 false반환
		}else{
			json= new JSONObject().put("fileName", realFileName);						
		}
		request.setAttribute("responseBody", json);
		return "AjaxView";
	}

}
