<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<script>
		alert("세션이 종료되었습니다. 다시 로그인 해주세요");
		location.href="${pageContext.servletContext.contextPath}/index.jsp";
	</script>