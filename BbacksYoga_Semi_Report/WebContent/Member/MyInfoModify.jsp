<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
h2{
   	text-align:center;
      margin-top: 23px;
       margin-bottom: 10px;
}
label{
        		margin-top: 12px;
        	}
</style>

<script type="text/javascript">
//개인정보 변경 확인
	function checkModify() {
	    var check_submit = confirm("개인정보를 변경 하시겠습니까?")
	       return check_submit;
	 }
	// 뒤로가기
	 function gobackMain() {
	    location.href="${pageContext.request.contextPath}/index.jsp";
	 }
	
	//비밀번호, 이메일 flag 체크 
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
	
	$(document).ready(function() {	
		
		
		//1. 패스워드 힌트 질문을 DB에서 불러와서 option값을 바꿔주기
		var num="${requestScope.MemberVO.password_question}";
		$("#passwordQuestion").val(num).prop("selected", true); 
		
		//2. 패스워드 칸 1) 패스워드 자리수 체크 2) 패스워드 와 패스워스 체크의 값 비교 
		$("#password").keyup(function(){
			if($("#password").val().length<8){
	   			$("#warnPassword").html("8자이상 입력해주세요.");
	   		}else if($("#password").val().length>=8){
	   			$("#warnPassword").html("");
	   		}			
			if($("#passwordCheck").val()!=$(this).val()){
	   			$("#warnPasswordCheck").html("패스워드가 일치하지 않습니다.");
	   			$("#pwdFlag").val("false");
	   		}else{
	   			$("#warnPasswordCheck").html("사용하실 수 있습니다.");
	   			
	   		}
		});//password keyup
		
		//3. 패스워드 체크 칸 1) 패스워드 자리수 체크 2) 패스워드 와 패스워스 체크의 값 비교 
		$("#passwordCheck").keyup(function(){
			if($("#password").val()!=$(this).val()){
	   			$("#warnPasswordCheck").html("패스워드가 일치하지 않습니다.");
	   			$("#pwdFlag").val("false");
	   		}else{
	   			$("#warnPasswordCheck").html("사용하실 수 있습니다.");
	   			
	   		}
		});//password keyup
		

		//4. 이메일, 이전 이메일과 같으면 그대로 유지, 다르면 중복 체크
		$("#email").on('keyup', function(){
			if(!$("#email").val().match("@")){
    			alert("이메일 형식이 아닙니다");
    		}else{
	    		$.ajax({
	    		type:"get",
	    		dataType:"json",
	    		url:"${pageContext.request.contextPath}/DispatcherServlet?command=getMemberByEmail",
	    		data:$("#updateForm").serialize(),
	    		success:function(data){
	    			//alert(data.length);
	    			if(!data.flag){
	    				$("#emailCheck").html("중복된 이메일 입니다.");
	    				$("#emailFlag").val("false");
	    			}else{
	    				$("#emailCheck").html("사용가능한 이메일 입니다.");    				
	    				}//(info);
	    			}//success
	    		});//ajax
    		}
	   	});//이메일 중복체크	
	   	
	   	
	});//ready
</script>


   <div class="container">
   <div class="col-md-12 contents"><!-- 좌우측의 공간 확보 -->
            <!-- 헤더 들어가는 부분 -->
             <h2>회원 정보 수정</h2>
            <!--// 헤더 들어가는 부분 -->
            <hr>

                <!-- 본문 들어가는 부분 -->
        
        <form class="form-horizontal" role="form" id="updateForm" method="post" action="DispatcherServlet" onsubmit="return checkModify()">
      	<input type="hidden" name="command" value="updateMyInfo">
      	<input type="hidden" id="pwdFlag" value="true">
        <input type="hidden" id="emailFlag" value="true">

<!--아이디-->            
            <div class="form-group" id="divId">
                <label for="inputId" class="col-lg-3 control-label">아이디</label>
                <div class="col-lg-4">
                     <input type="text" readonly="readonly" name="id" value="${requestScope.MemberVO.id}">
                </div>
                <div class="col-lg-4">
                   
                </div>
            </div>
<!--비밀번호-->            
            <div class="form-group" id="divPassword">
                <label for="inputPassword" class="col-lg-3 control-label">패스워드</label>
                <div class="col-lg-6">
                    <input type="password" class="form-control" name="password" id="password" name="excludeHangul" data-rule-required="true" placeholder="패스워드" maxlength="30" value="${requestScope.MemberVO.password}">
                	<p id="warnPassword"></p>   
                </div>
            </div>
<!--비밀번호 체크-->
            <div class="form-group" id="divPasswordCheck">
                <label for="inputPasswordCheck" class="col-lg-3 control-label">패스워드 확인</label>
                <div class="col-lg-6">
                    <input type="password" class="form-control" id="passwordCheck" data-rule-required="true" placeholder="패스워드 확인" maxlength="30" value="${requestScope.MemberVO.password}">
					<span id="warnPasswordCheck"></span>               
                </div>
            </div>
<!--아이디 비밀번호 힌트 선택-->
            <div class="form-group">
                <label for="passwordHint" class="col-lg-3 control-label">패스워드 힌트</label>
                <div class="col-lg-6">
                    <select class="form-control" id="passwordQuestion" name="password_question">
                        <option value="question1" >나의 고향은?</option>
                        <option value="question2" >나의 초등학교는?</option>
                        <option value="question3" >내가 가장 좋아하는 음식은?</option>
                    </select>
                </div>
            </div>
<!--비밀번호 힌트 답변-->
            <div class="form-group" id="passwordHintCheck">
                <label for="inputPasswordCheck" class="col-lg-3 control-label">패스워드 힌트 답변</label>
                <div class="col-lg-6">
                    <input type="text" class="form-control" name="password_answer" id="hintCheck" data-rule-required="true" value="${requestScope.MemberVO.password_answer}" maxlength="30">
                </div>
            </div>
<!--이름-->
            <div class="form-group" id="divName">
                <label for="inputName" class="col-lg-3 control-label">이름</label>
                <div class="col-lg-6">
                    <input type="text" class="form-control onlyHangul" name="name" id="name" data-rule-required="true" value="${requestScope.MemberVO.name}" maxlength="15">
                </div>
            </div>
<!--주소-->
            <div class="form-group" id="address">
                <label for="inputNickname" class="col-lg-3 control-label">주소</label>
                <div class="col-lg-6">
                    <input type="text" class="form-control" name="address" id="address" data-rule-required="true" value="${requestScope.MemberVO.address}" maxlength="15">
                </div>
            </div>
<!--이메일-->
            <div class="form-group" id="divEmail">
                <label for="inputEmail" class="col-lg-3 control-label">이메일</label>
                <div class="col-lg-4">
                    <input type="email" class="form-control" name="email" id="email" data-rule-required="true" value="${requestScope.MemberVO.email}" maxlength="40">
                </div>
<!--이메일 중복확인-->
                <div class="col-lg-4">
                   <span id="emailCheck"></span>
                </div>
            </div>
<!--전화번호-->
            <div class="form-group" id="divPhoneNumber">
                <label for="inputPhoneNumber" class="col-lg-3 control-label">휴대폰 번호</label>
                <div class="col-lg-6">
                    <input type="tel" class="form-control onlyNumber" name="phoneNumber" id="phoneNumber" data-rule-required="true" value="${requestScope.MemberVO.phone_number}" maxlength="11">
                </div>
            </div>
<!--신청횟수:수정안함-->
            <div class="form-group">
                <label for="weekCount" class="col-lg-3 control-label"> 1주일 당 신청 횟수</label>
                <div class="col-lg-6">
                   <input type="text" readonly="readonly" name="" value="${requestScope.MemberVO.class_package}">
                </div>
            </div>
<!--수정 / 취소 버튼-->
            <div class="form-group">
                <div class="col-lg-offset-8 col-lg-10">
                      <input type="submit" value="수정" onclick="return flagTest()">
                      <input type="button" value="취소" onclick="gobackMain()">
                </div>
            </div>
        </form>
        </div>
</div>
    