<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
	$(document).ready(function() {
		//이미지를 포함한 태그를 불러올떄는 ""가 겹칠 수 있어서 ''로 불러온다
		dhtmlframe.document.open(); 
		dhtmlframe.document.write('${postVO.content}'); 
		dhtmlframe.document.close(); 			
	});	

    function modify()
    {
    	form.content.value = dhtmlframe.document.body.innerHTML;
    	var check_submit=confirm('글을 수정하겠음?');
    	return check_submit;
    }
</script>

<div class="container">
	<div class="row text">
		<div class="col-sm-12 contents">
			<form action="DispatcherServlet" method="post" name="form" class="editorform" onsubmit="return modify()">
				<input type="hidden" name="command" value="postModify"> 
				<input type="hidden" name="pre_contents" id="pre_contents" value="${postVO.content}">
				<input type="hidden" name="postNo" value="${postVO.postNo}">
				<!-- 제목 -->
				글번호: ${postVO.postNo} 글쓴이: ${postVO.id} 작성 날짜:${postVO.regDate}<br>					
				<!-- 제목 -->
				글제목 <input type="text" class="title" name="title" value="${postVO.title}" required="required"><br> 
				<!-- 에디터 링크 -->
				<c:import url="/Post/editor.jsp"></c:import>				<!-- 쓰기영역 -->
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
				        	이미지 첨부시 미리보기로 확인하시고, 사진을 클릭하면 본문에 추가됩니다.
				            <img id="img" />
				        </div>
				    </div>
				    <div class="post_button">
		   				<a href="javascript:" class="my_button" onclick="submitAction();">등록</a>
		   				<a href="javascript:" class="my_button" onclick="cancelAction();">취소</a>
		   			</div>
		   </form>	
		</div>
	</div>
</div>
