<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="contents">
<div class="row profile_detail">
  <img class="profile-img" src=${pageContext.request.contextPath}/Image/teacher/${requestScope.teacherInfo.img_url} >
  <div class="profile-text">
		<div class="profile-description">
			<span id="tName">${requestScope.teacherInfo.teacherName}</span>&nbsp;
	    	<span id="nick">${requestScope.teacherInfo.teacherNick}</span><br>
	    	<span class="profile-title">"${requestScope.teacherInfo.teacherProfile}"</span>
        </div>
        <div class="profile-description2">
			<div class="profile-des"><b>수강중인 프로그램</b></div>
			<div class="profile-des">
				<c:forEach items="${requestScope.classList}" var="i">
					${i}&nbsp;
				</c:forEach>
			</div>
        </div>
        <div class="back_button"> 
        <input id="back_page" type="button" value="목록으로" onclick="history.back()">
        </div>
  </div>
</div>
</div>