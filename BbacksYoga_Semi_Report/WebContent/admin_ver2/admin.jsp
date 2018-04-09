<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"><title>Insert title here</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	<a href="Create_AddTeacher.jsp">선생님 등록</a><br>
	<a href="Create_Program.jsp">프로그램 등록</a><br>
	<a href="${pageContext.request.contextPath}/DispatcherServlet?command=addClassView">강좌 등록</a><br>
</body>
</html>