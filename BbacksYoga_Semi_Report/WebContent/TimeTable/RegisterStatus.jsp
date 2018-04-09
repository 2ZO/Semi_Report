<%@page import="org.kosta.model.etc.classDay"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Date"%>
<script type="text/javascript">
	//수강 취소
	function delete_register(classNo){
		if(confirm("해당 강좌를 취소하시겠습니까?")){
			location.href="DispatcherServlet?command=Delete_Register&classNo="+classNo;
		}
	}
	function disable(){
		alert("어디서 수작질임?");
	}
</script>

<!-- CSS -->
<style type="text/css">

table {
	text-align: center;
    border-collapse: collapse;
    width: 100%;
}

th, td {
	text-align: center;
	border-style: solid;
	border-width: 1px;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

#back_page{
	margin-top: 10px;
	margin-bottom: 5px;
}

</style>

<div class="col-sm-1"></div>
<div class="col-sm-10">
<!-- timetable 링크 -->
 <a href="${pageContext.request.contextPath}/DispatcherServlet?command=Read_Timetable"><input id="back_page" type="button" value="TimeTable" ></a>
	<table>
		<thead>
			<tr>
				<th>강좌명</th>
				<th>강사</th>
				<th>요일</th>
				<th>시간</th>
				<th>등록일시</th>
				<th>비고</th>
			</tr>
		</thead>
		<tbody>
			<!-- 수강내역 뿌리기 -->
			<c:forEach items="${registerStatus_list }" var="list">
				<tr>
					<td>${list.programName }</td>
					<td>${list.teacherNick }</td>
					<td>
						<c:choose>
							<c:when test="${list.classDay==classDay.MON.getName() }">
								월요일
							</c:when>
							<c:when test="${list.classDay==classDay.TUE.getName() }">
								화요일
							</c:when>
							<c:when test="${list.classDay==classDay.WEN.getName() }">
								수요일
							</c:when>
							<c:when test="${list.classDay==classDay.THU.getName() }">
								목요일
							</c:when>
							<c:when test="${list.classDay==classDay.FRI.getName() }">
								금요일
							</c:when>
							<c:when test="${list.classDay==classDay.SAT.getName() }">
								토요일
							</c:when>
						</c:choose>
					</td>
					<td>${list.classTime }교시</td>
					<td>${list.regDate }</td>
					<c:set var="today" value="<%=new java.util.Date().getDay()%>"/>
				 	<td><c:choose>
						<c:when test="${list.classDay < today}">
							<input type="button" value="수강취소" onclick="disable()" data-toggle="tooltip" title="날짜를 확인하세요!">
						</c:when>
						<c:otherwise>
							<input type="button" value="수강취소" onclick="delete_register(${list.classNo})">
						</c:otherwise>
					</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="col-sm-1"></div>