<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
alert("회원가입 축하드립니다. \n로그인 해주세요.");
location.href="${pageContext.request.contextPath}/DispatcherServlet?command=page&url=/Member/Login.jsp";
</script> 
