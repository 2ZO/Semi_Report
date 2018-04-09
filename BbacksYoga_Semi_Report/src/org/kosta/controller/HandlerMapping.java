package org.kosta.controller;

import org.kosta.controller.first.*;
import org.kosta.controller.second.*;
import org.kosta.controller.third.*;


public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();

	private HandlerMapping() {
	}

	public static HandlerMapping getInstance() {
		return instance;
	}

	public Controller create(String command) {
		Controller c = null;
					//1조~
		if (command.equals("LogIn")) {
			c = new Read_LoginController();
		}else if (command.equals("register")) {	
			c = new Create_RegisterController();
		}else if (command.equals("getMemberById")) {	
			c = new Read_MemberByIdController();
		}else if (command.equals("getMemberByEmail")) {	
			c = new Read_MemberByEmailController();
		}  else if (command.equals("postWrite")) {
			c = new Create_PostController();
		} else if(command.equals("writePostView")) { //임시 글쓰기 확인하려고
			c = new Create_PostControllerView();
		} else if(command.equals("modifyPostView")) { // 게시글 수정시 기존 데이터 불러오기
			c = new Read_ModifyPostView();
		}else if (command.equals("postModify")) {
			c = new Update_PostController();
		} else if (command.equals("getDetailPost")) {
			c = new Read_PostDetailController();
		} else if (command.equals("postList")) {
			c = new Read_BoardController();
		}else if(command.equals("deletePost")) { // 글쓰기 삭제
			c = new Delete_BoardController();
		}else if(command.equals("searchPost")) { // 게시글 검색
			c = new Search_BoardController();
					//2조~
		} else if (command.equals("teacherList")) {
			c = new Read_TeacherListController();
		} else if (command.equals("teacherDetail")) {
			c = new Read_TeacherDetailController();
		} else if (command.equals("programList")) {
			c = new Read_ProgramListController();
		} else if (command.equals("programDetail")) {
			c = new Read_ProgramDetailController();
		} else if (command.equals("passwordCheck")) {
			c = new Read_MyInfoCheckController();
		} else if (command.equals("updateMyInfo")) {
			c = new Update_MyInfoController();
		} else if (command.equals("updateMyInfoPreview")) {
			c = new Update_MyInfoPreviewController();
		} else if (command.equals("addTeacher")) { //강사등록
			c = new Create_TeacherController();
		} else if (command.equals("addProgram")) {
			c = new Create_ProgramController();
		} else if (command.equals("addProgramImg")) { // 프로그램 이미지 등록
			c = new Create_ProgramImgController();
		} else if (command.equals("addclass")) {
			c = new Create_ClassController();
		}else if (command.equals("getTime")) {//관리자모드에서 셀렉터 때매 만듬
			c = new Read_AvailableTimeController();
		}else if(command.equals("addClassView")) { //강좌등록시 강사, 프로그램 데이터를 불러옴
			c = new Read_AddClassViewController();
		}else if(command.equals("addPostImg")) {
			c = new CreatePostImageController();
		}
		//3조
		else if (command.equals("Create_RegisterClass")) {
			c = new Create_RegisterClassController();
		} else if (command.equals("Read_Timetable")) {
			c = new Read_TimeTableController();
		} else if (command.equals("Read_Register")) {
			c = new Read_RegisterController();
		} else if (command.equals("Delete_Register")) {
			c = new Delete_RegisterClassController();
		} else if (command.equals("시간표 등록")) {
			c = new Create_TimeTableController();
		} else if (command.equals("관리자 시간표 리스트 받기")) {
			c = new Read_AdminTimeTableController();
		} else if (command.equals("시간표 수정")) {
			c = new Update_TimeTableController();
		} else if (command.equals("시간표 삭제")) {
			c = new Delete_TimeTableController();
		} else if (command.equals("addTeacher")) { 
			c = new Create_TeacherController();
		}  else if(command.equals("checkOverlapClass")) {
			c= new Read_CheckOverlapClassController();
		} else if (command.equals("Create_NewRegisterClass")) {
			c = new Create_NewRegisterClassController();
		} else if (command.equals("temp")) { 
			c = new tempController();
		} else if (command.equals("temp2")) { 
			c = new temp2Controller();
		}
		//Paging Controller
		else if(command.equals("page")) {
			c= new PageController();
		}else {
			System.out.println("매핑오타났다 반성하고 고쳐라~~");
		}
		return c;
	}
}
