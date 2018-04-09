<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src="${pageContext.servletContext.contextPath}/js/postEditor.js"></script>
<style>
pre {
	display: block;
	height: 200px;
}
</style>
<script>
function postModify() {
	var flag=confirm("수정하시겠습니까?");
	if(flag)
		return true;
	else
		return false
}
function postRemove(){
	var flag=confirm("삭제하시겠습니까?");
	if(flag)
		location.href="DispatcherServlet?command=deletePost&postNo=${postVO.postNo}";
	else
		return false
}
</script>
<div class="container">
	<div class="row text">
		<div class="col-sm-12">
			<form action="DispatcherServlet" method="post" name="form" class="editorform" onsubmit="return postModify()">
				<input type="hidden" name="command" value="modifyPostView">
				<input type="hidden" name="postNo" value="${postVO.postNo}">
				<!-- 제목 -->
				글번호: ${postVO.postNo} 글쓴이: ${postVO.id} 작성 날짜:${postVO.regDate}<br>
				제목: ${postVO.title}
				<!-- 쓰기영역 -->
				<br>
				<!-- <IFRAME NAME=dhtmlframe></IFRAME><br>			 -->
				<!-- 쓰기영역 html -->
				<!-- <textarea rows="10" cols="40" class="postContents" name="content" readonly="readonly"> -->
				<div id="contentDiv">
					<pre>${postVO.content}</pre>
				</div>
				<!-- </textarea> -->
				<!-- 글 등록 & 취소-->
				<div class="post_button">
								<!--글쓴이와 현재 접속자와 아이디 비교, 수정가능여부 판단  -->
				<c:if test="${memberVO.id== postVO.id || memberVO.id == 'sys'}">
					<input id="post_button_bt" type="submit" value="수정" >
					<input id="post_button_bt" type="button" value="삭제" onclick="return postRemove()">
				</c:if>
					<input id="post_button_bt" type="button" value="확인" Onclick="history.back()">
				</div>
			</form>
		</div>
	</div>
</div>
