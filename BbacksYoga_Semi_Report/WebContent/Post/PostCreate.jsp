<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
function datasubmit()
{
	form.content.value = dhtmlframe.document.body.innerHTML;
	return confirm('글을 등록하겠음?');
	
}
</script>

<div class="container">
	<div class="row text">
		<div class="col-sm-12 contents">
			<form action="DispatcherServlet" method="post" name="form" class="editorform" onsubmit="return datasubmit()">
				<input type="hidden" name="command" value="postWrite"> 
				<!-- 제목 -->
				글제목 <input type="text" class="title" name="title" required="required"><br> 
				<!-- 에디터 영역 -->
				<c:import url="/Post/editor.jsp"></c:import>
				<!-- 쓰기영역 -->
				<br>
				<IFRAME NAME=dhtmlframe id="dhtmlframe"></IFRAME><br>				
				<!-- 쓰기영역 html -->
				<textarea rows="10" cols="40" class="postContents" name="content">	</textarea>
				
				<!-- 글 등록 & 취소-->
				<div class="post_button2">
					<input id="submit_post" type="submit" value="등록">
					<input id="cancel_post" type="button" value="취소" Onclick="history.back()">
				</div>
			</form>
			<!-- 사진올리기 -->
			
			<form method="post" enctype="multipart/form-data" id="postImg">
				   <input type="hidden" name="test" value="hidden">
				    <div>
				        <div class="input_wrap">
				            <input name="input_imgs" type="file" id="input_imgs" >			 		
				        </div>
				    </div>				 
				    <div>
				        <div class="imgs_wrap">
				        	이미지 첨부시 미리보기로 확인하시고, 사진을 클릭하면 본문에 추가됩니다
				            <img id="img" />
				        </div>
				    </div>
		   </form>		
		      
		   		<div class="post_button">
		   			<a href="javascript:" class="my_button" onclick="submitAction();">등록</a>
		   			<a href="javascript:" class="my_button" onclick="cancelAction();">취소</a>
		   		</div>	   		   
		</div>
	</div>
</div>
