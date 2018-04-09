<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
function sendList(){
	location.href="${pageContext.request.contextPath}/index.jsp";
}
function deleteBoard(){
	if(confirm("게시글을 삭제하시겠습니까?")){
		document.deleteForm.submit();
	}
}
function updateBoard(){
	if(confirm("게시글을 수정하시겠습니까?")){
		location.href="${pageContext.request.contextPath}/DispatcherServlet?command=updateView&no=${requestScope.pvo.no}";
	}
}
</script>
	<table class="table">
		<tr >
			<td>글번호 ${requestScope.pvo.no }</td>
			<td>제목: ${requestScope.pvo.title} </td>
			<td>작성자 :  ${requestScope.pvo.memberVO.name }</td>
			<td>조회수 : ${requestScope.pvo.hits }</td>
			<td>${requestScope.pvo.timePosted }</td>
		</tr>		
		<tr>
			<td colspan="5" class="content">
			<pre>${requestScope.pvo.content}</pre>
			</td>
		</tr>
		<tr>
			<td colspan="5" class="btnArea">
			 <c:if test="${requestScope.pvo.memberVO.id==sessionScope.mvo.id}">
			 <form name="deleteForm" action="${pageContext.request.contextPath}/DispatcherServlet" method="post">
			 	<input type="hidden" name="command" value="deletePosting">
			 	<input type="hidden" name="no" value="${requestScope.pvo.no}">
			 </form>
			 <button type="button" class="btn" onclick="deleteBoard()">삭제</button>
			 <button type="button" class="btn" onclick="updateBoard()">수정</button>
			 </c:if>
			 </td>
		</tr>
	</table>
	
	
	
	
	
	
	
	