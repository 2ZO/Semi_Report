<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript"></script>
<script src="${pageContext.servletContext.contextPath}/CSS/logIn.css"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
span{
	color:red;
}
.container{
	margin: 35px auto 0 !important;
}
</style>
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
/*로그인 ajax로 처리하기~*/
$(document).ready(function(){
$("#logInBtn").click(function(){
		$.ajax({
		type:"post",
		dataType:"json",   
		url:"${pageContext.request.contextPath}/DispatcherServlet",
		data:$("#logInForm").serialize(),
		success:function(data){
			//alert(data.length);
			if(data.flag=="false"){
				$("#loginFail").html("LogIn Fail");
				$("#id").val("");
				$("#password").val("");
				$("#id").focus();
			}else{
				//flag가 true면 메인페이지로 바로 이등~
				location.href="${pageContext.request.contextPath}/index.jsp"
			}
			//$("#membody").html(info);
		}//success
	});//ajax
	});
});
</script>
<title>LogIn</title>
<style type="text/css">
</style>
	<div class="container">
		<div class="row login_contents">
		<div class="col-md-4 login_col"></div>
			<div class="col-md-4 login_col">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Welcome to Bbak's Yoga</h3>
					</div>
					<div class="panel-body">
						<form accept-charset="UTF-8" role="form" id="logInForm">
						<input type="hidden" value="LogIn" name="command">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="ID" name="userId"
										type="text" id="id">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password"
										name="userPassword" type="password" value="" id="password">
								</div>
								<input class="btn btn-lg btn-success btn-block" type="button"
									value="Login" id="logInBtn">
								<div class="form-group">
									<span id="loginFail"></span>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-4 login_col"></div>
		</div>
	</div>