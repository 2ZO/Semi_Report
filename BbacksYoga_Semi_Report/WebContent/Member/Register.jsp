<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <meta charset="utf-8">
        <!-- meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0"/ -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>회원가입</title>
        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link href="/resources/image/icon/HalfLife.ico" rel="shortcuticon">
        <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
        <script src="//code.jquery.com/jquery.js"></script>
        <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
        <script src="/resources/bootstrap/js/respond.js"></script>
        <style type="text/css">
        	h2{
        		text-align: center;
        		margin-top: 40px;
        		margin-bottom: 10px;
        	}
        	span{
        		color:red;
        	}
        	label{
        		margin-top: 13px;
        	}
        </style>
        
<script type="text/javascript">
/*id 중복체크 ajax로 처리하기~*/

function flagTest(){
	if($("#idFlag").val()=="false"){
		alert("아이디 중복체크 해주세요.");
		return false;
	}else if($("#emailFlag").val()=="false"){
		alert("이메일 중복체크 해주세요.");
		return false;
	}else if($("#pwdFlag").val()=="false"){
		alert("패스워드가 일치하지 않습니다.");
		return false;
	}else{
		return true;
	}
	
}
$(document).ready(function(){
$("#checkId").click(function(){
	if($("#id").val().length<8){
		alert("8자 이상 입력해주세요");
	}else{
		$.ajax({
		type:"get",
		dataType:"json",
		url:"${pageContext.request.contextPath}/DispatcherServlet?command=getMemberById",
		data:$("#registerForm").serialize(),
		success:function(data){
			//alert(data.length);
			if(data.flag=="false"){
				$("#idCheck").html("중복된 아이디 입니다.");
			}else{
				$("#idCheck").html("사용가능한 아이디 입니다.");
				$("#idFlag").val("true");
			}
			//(info);
		}//success
	});//ajax	
	}
	});
$("#id").change(function(){
	$("#idCheck").html("");
	$("#idFlag").val("false");
});
$("#email").change(function(){
	$("#emailCheck").html("");
	$("#emailFlag").val("false");
});
$("#password").change(function(){
	$("#passwordCheck").html("");
	$("#pwdFlag").val("false");
});
	//이메일중복체크
	$("#checkEmail").click(function(){
		if(!$("#email").val().match("@")){
			alert("이메일 형식이 아닙니다");
		}else{
		$.ajax({
		type:"get",
		dataType:"json",
		url:"${pageContext.request.contextPath}/DispatcherServlet?command=getMemberByEmail",
		data:$("#registerForm").serialize(),
		success:function(data){
			//alert(data.length);
			if(data.flag=="false"){
				$("#emailCheck").html("중복된 이메일 입니다.");
			}else{
				$("#emailCheck").html("사용가능한 이메일 입니다.");
				$("#emailFlag").val("true");
			}
			//(info);
		}//success
	});//ajax
		}
	});
	//패스워드 자릿수 제한
	$("#password").on('keyup', function(){
		if($("#password").val().length<8){
			$("#warn").html("8자이상 입력해주세요.");
		}else{
			$("#warn").html("");
		}
	});
	//비번 중복체크
	$("#passwordCheck").keyup(function(){
		if($("#password").val().length<8){
			$("#warnPasswordCheck").html("");
		}else if($("#password").val()==$(this).val()){ 
			$("#warnPasswordCheck").html("일치합니다.");
		}else{
			$("#warnPasswordCheck").html("일치하지 않습니다.");
			$("#pwdFlag").val("true");
		}
	});
	
});
</script>
	 <div class="container"><!-- 좌우측의 공간 확보 -->
            <!-- 헤더 들어가는 부분 -->
             <h2>회원가입</h2>
            <!--// 헤더 들어가는 부분 -->
            <!-- 모달창 -->
            <div class="modal fade" id="defaultModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">알림</h4>
                        </div>
                        <div class="modal-body">
                            <p class="modal-contents"></p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
            <!--// 모달창 -->
            <hr>
                <!-- 본문 들어가는 부분 -->
        <form class="form-horizontal" role="form" id="registerForm" method="post" action="${pageContext.request.contextPath}/DispatcherServlet">
        	<input type="hidden" name="command" value="register"> 	
        	<input type="hidden" id="idFlag" value="false">
        	<input type="hidden" id="pwdFlag" value="false">
        	<input type="hidden" id="emailFlag" value="false">
            <div class="form-group" id="divId">
                <label for="inputId" class="col-lg-3 control-label">아이디</label>
                <div class="col-lg-4">
                    <input type="text" class="form-control onlyAlphabetAndNumber" id="id" name="id" data-rule-required="true" placeholder="5자이상 20자 이하 알파벳과 숫자만 입력 가능합니다." maxlength="20" required="required">	
                </div>
                <div class="col-lg-4">
                	<input type="button" value="중복확인" id="checkId">      
                	<span id="idCheck"></span>    
                </div>      
            </div>
            <div class="form-group" id="divPassword">
                <label for="inputPassword" class="col-lg-3 control-label">패스워드</label>
                <div class="col-lg-6">
                    <input type="password" class="form-control" name ="password" id="password" name="excludeHangul" data-rule-required="true" placeholder="패스워드, 8자 이상입력" maxlength="30" required="required">
              		<span id="warn"></span>
                </div>
            </div>
            <div class="form-group" id="divPasswordCheck">
                <label for="inputPasswordCheck" class="col-lg-3 control-label">패스워드 확인</label>
                <div class="col-lg-6">
                    <input type="password" class="form-control" id="passwordCheck" data-rule-required="true" placeholder="패스워드 확인" maxlength="30" required="required">
               		 <span id="warnPasswordCheck"></span>
                </div>
            </div>
            <div class="form-group">
                <label for="passwordHint" class="col-lg-3 control-label">패스워드 힌트</label>
                <div class="col-lg-6">
                    <select class="form-control" id="password_question" name="password_question">
                        <option value="question1">나의 고향은?</option>
                        <option value="question2">나의 초등학교는?</option>
                        <option value="question3">내가 가장 좋아하는 음식은?</option>
                    </select>
                </div>
            </div>
            <div class="form-group" id="passwordHintCheck">
                <label for="inputPasswordCheck" class="col-lg-3 control-label">패스워드 힌트 답변</label>
                <div class="col-lg-6">
                    <input type="text" class="form-control" id="password_answer" name="password_answer" data-rule-required="true" placeholder="패스워드 힌트 답변" maxlength="30" required="required">
                </div>
            </div>
            <div class="form-group" id="divName">
                <label for="inputName" class="col-lg-3 control-label">이름</label>
                <div class="col-lg-6">
                    <input type="text" class="form-control onlyHangul" name ="name" id="name" data-rule-required="true" placeholder="한글만 입력 가능합니다." maxlength="15" required="required">
                </div>
            </div>
             
            <div class="form-group" id="Address">
                <label for="inputNickname" class="col-lg-3 control-label">주소</label>
                <div class="col-lg-6">
                    <input type="text" class="form-control" name= "address" id="address" data-rule-required="true" placeholder="주소" maxlength="15" required="required">
                </div>
            </div>
             
            <div class="form-group" id="divEmail">
                <label for="inputEmail" class="col-lg-3 control-label">이메일</label>
                <div class="col-lg-4">
                    <input type="email" class="form-control" id = "email" name="email" data-rule-required="true" placeholder="이메일" maxlength="40" required="required">
                </div>
                <div class="col-lg-4">
                	<input type="button" value="중복확인" id="checkEmail">
                	 <span id="emailCheck"></span>
                </div>
            </div>
            <div class="form-group" id="divPhoneNumber">
                <label for="inputPhoneNumber" class="col-lg-3 control-label">휴대폰 번호</label>
                <div class="col-lg-6">
                    <input type="tel" class="form-control onlyNumber" name = "phone_number" id="phone_number" data-rule-required="true" placeholder="-를 제외하고 숫자만 입력하세요." maxlength="11" required="required">
                </div>
            </div>
            <div class="form-group">
                <label for="weekCount" class="col-lg-3 control-label"> 1주일 당 신청 횟수</label>
                <div class="col-lg-6">
                    <select class="form-control" id="class_package" name="class_package">
                        <option value="3">3회</option>
                        <option value="5">5회</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-8 col-lg-10">
                    <button type="submit" class="btn btn-default" id="RegisterBtn" onclick="return flagTest()">Sign in</button>
                </div>
            </div>
        </form>
        </div>
    