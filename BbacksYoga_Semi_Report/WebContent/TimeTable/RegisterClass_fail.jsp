<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
<!-- 강좌 중복 신청 시 alert + 시간표로 이동 -->
	alert("이미 신청한 강좌입니다!");
	location.href="${pageContext.request.contextPath}/DispatcherServlet?command=Read_Timetable";
</script>