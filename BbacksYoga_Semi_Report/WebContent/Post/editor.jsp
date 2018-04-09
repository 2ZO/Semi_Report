<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/postEditor.js"></script>

<!-- 에디터 링크 -->
<div class="editor">
	<a href="javascript:htmledit('cut');">
		<img alt="자르기" src="${pageContext.request.contextPath}/Image/editor/cut.png">
	</a>
	<a href="javascript:htmledit('copy');">
		<img alt="복사" src="${pageContext.request.contextPath}/Image/editor/copy.png">
	</a>
	<!-- 붙여넣기는 보안상 되지 않음  -->
	<a href="javascript:htmledit('justifyleft');">
		<img alt="좌측정렬" src="${pageContext.request.contextPath}/Image/editor/justifyleft.png">
	</a>
	<a href="javascript:htmledit('justifycenter');">
		<img alt="중앙정렬" src="${pageContext.request.contextPath}/Image/editor/center-alignment.png">
	</a>
	<a href="javascript:htmledit('justifyright');">
		<img alt="우측정렬" src="${pageContext.request.contextPath}/Image/editor/justifyright.png">
	</a>
	<a href="javascript:htmledit('insertunorderedlist');">
		<img alt="리스트" src="${pageContext.request.contextPath}/Image/editor/list.png">
	</a>
	<a href="javascript:htmledit('insertorderedlist');">
		<img alt="숫자리스트" src="${pageContext.request.contextPath}/Image/editor/num_list.png">
	</a>
	<a href="javascript:htmledit('outdent');">
		<img alt="왼쪽들여쓰기" src="${pageContext.request.contextPath}/Image/editor/left-indent.png">
	</a>
	<a href="javascript:htmledit('indent');">
		<img alt="오른쪽들여쓰기" src="${pageContext.request.contextPath}/Image/editor/right-indent.png">
	</a>
	<a href="javascript:htmledit('createlink');">
		<img alt="링크" src="${pageContext.request.contextPath}/Image/editor/link.png">
	</a>
	<div class="dropdown">
				<img alt="폰트 글꼴" src="${pageContext.request.contextPath}/Image/editor/font.png">
				<div class="dropdown-content">
		    <a href="javascript:htmledit('fontname','굴림');">굴림</a>
			<a href="javascript:htmledit('fontname','궁서');">궁서</a>
	  </div>
	</div>
	
	<div class="dropdown">
				<img alt="폰트 사이즈" src="${pageContext.request.contextPath}/Image/editor/fontSize.png">
				<div class="dropdown-content">
		    <a href="javascript:htmledit('fontSize',2);">2</a>
			<a href="javascript:htmledit('fontSize',4);">4</a>
			<a href="javascript:htmledit('fontSize',6);">6</a>
			<a href="javascript:htmledit('fontSize',8);">8</a>
			<a href="javascript:htmledit('fontSize',10);">10</a>
	  </div>
	</div>
						
	<a href="javascript:htmledit('bold');">
		<img alt="볼드" src="${pageContext.request.contextPath}/Image/editor/bold.png">
	</a>
	<a href="javascript:htmledit('italic');">
		<img alt="이탤릭" src="${pageContext.request.contextPath}/Image/editor/italic.png">					
	</a>
	<a href="javascript:htmledit('underline');">
	<img alt="언더라인" src="${pageContext.request.contextPath}/Image/editor/underLine.png">
	</a>
	<a href="javascript:" onclick="fileUploadAction();">
	<img alt="언더라인" src="${pageContext.request.contextPath}/Image/editor/image.png">
	</a>
</div>