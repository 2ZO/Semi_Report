<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-condensed">
	<tr>
		<th>프로그램 번호: ${vo.programNo} </th><th>프로그램 이름: ${vo.programName}</th>
	</tr>
	<tr>
		<td colspan="2">${vo.programDetail}</td>
	</tr>
</table>
<div class="back_button"> 
	<input id="back_page" type="button" value="목록으로" onclick="history.back()">
</div>
