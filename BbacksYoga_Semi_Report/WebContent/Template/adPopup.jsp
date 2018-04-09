<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<style>
div{
	height: 10px;
}
</style>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="//code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">

//이미지 클릭시 이동
function forward(){
	location.href="http://healthcare.pe.kr/product/list.html?cate_no=804";
}

//체크박스 클릭시 쿠키를 set해준다
$(document).ready(function(){
	$("#popUpFlag").click(function(){
		setCookie();
		window.close();
	});
});

function setCookie(){
	<%
	Cookie info = new Cookie("popup", "false");  
	info.setMaxAge(1*24*60*60);//하루동안 유지
	info.setPath("/");//디렉토리 경로
	response.addCookie(info);
	%>
}
</script>
<title>PopUp Ad</title>
</head>
<body>
	<img
		src="${pageContext.servletContext.contextPath}/Image/Popup/yogaPopup.jpg" onclick="foward()"> 
		<!-- 클릭시 다른 홈페이지로 이동 -->
	<div>
		<label>오늘 다시 안보기</label> <input type="checkbox" id="popUpFlag">
	</div>
</body>
</html>