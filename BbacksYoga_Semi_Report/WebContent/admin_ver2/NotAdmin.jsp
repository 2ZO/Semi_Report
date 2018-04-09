<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
	alert("관리자가 아니시네요.\n 좋은말 할때 주소로 접속하지 마라");
	location.href = "${pageContext.servletContext.contextPath}/index.jsp";
</script>