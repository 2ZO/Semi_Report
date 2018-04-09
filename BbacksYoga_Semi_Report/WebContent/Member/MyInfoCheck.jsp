<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style type="text/css">
	.container{
		width: 465px !important;
		margin: 0 auto !important;
	}
	.container .contents{
		border: 3px dashed #ccc;
		width: 465px;
		text-align: center;
		margin-top: 73px;
	}
	h3{
		text-align: center;
		margin-top:33px;
		margin-bottom: 30px;
	}
	form{
		text-align: center;
	}
	form input:last-child{
		margin: 12px 0;
	}
</style>
<c:if test="${sessionScope.memberVO.id==null}">
	<script>
		alert("로그인해주세요");
		location.href="index.jsp";
	</script>
</c:if>
<div class="container">
	<div class="col-md-12 contents">
		<h3>회원 정보 수정</h3>
		<hr>
		<form action="DispatcherServlet" method="post"> <!-- 단순한 정보체크지만 패스워드를 넣기 때문에 post처리 -->
			<input type="hidden" name="command" value="passwordCheck">
					패스워드를 입력하세요 <input type="password" name="memberPassword" required="required">
					<br>
			<input type="submit" value="비밀번호 확인" class="btn btn-default">
		</form>
	</div>
</div>