<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script>
alert("Log Out");
<% session.invalidate(); %>
location.href="${pageContext.request.contextPath}/index.jsp";
</script> 
