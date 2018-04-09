<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style>
.addClass{
	padding-top: 50px;
} 
</style>
<script type="text/javascript">
$(document).ready(function(){
	$("#addProgramBtn").click(function(){
			$.ajax({
			type:"post",
			dataType:"json",   
			url:"${pageContext.request.contextPath}/DispatcherServlet",
			data:$("#programForm").serialize(),
			success:function(data){
				if(data.flag=="false"){
					alert("뭔가 에러")
				}else{
					alert(data.programName+"추가완료!\n리스트를 확인해주세요");
						$("#table_body tr:last").after("<tr><td>"+data.programName+"</td>"+
								"<td>"+data.programDetail+"</td>");
						$('#program').val('');
						$('#introduce').val('');
					}
				}
				//$("#membody").html(info);
			});//success
		});//ajax
	});
</script>
<div class="col-sm-1"></div>
<div class="col-sm-4 addClass">
<form action="${pageContext.request.contextPath}/DispatcherServlet" id="programForm">
요가 프로그램: <input type="text" name="programName" required="required" id="program"><br>
프로그램 소개<br><br>
<textarea rows="10" cols="40" name="programDetail" required="required" id="introduce"></textarea> <br>
<input type="hidden" name="command" value="addProgram" > <br>
<input type="button" id="addProgramBtn" value="추가하기">
</form>
<hr>
<form action="${pageContext.request.contextPath}/DispatcherServlet?command=addProgramImg" method="post" enctype="multipart/form-data" >
프로그램 이미지 파일<input type="file" name="programFile1" >
프로그램 이미지 파일<input type="file" name="programFile2" >
프로그램 이미지 파일<input type="file" name="programFile3" >
프로그램 이미지 파일<input type="file" name="programFile4" >
프로그램 인기: <input type="text" name="programHit"><br>
<input type="submit" value="추가하기">
</form>

</div>
<div class="col-sm-6  addClass">
<div class="container">
<form>
	<table id="table" class="table table-hover">
		<thead id="table_head">
			<tr>
				<th>요가 프로그램</th>
				<th>프로그램 소개</th>
			</tr>
		</thead>
		<tbody id="table_body">
		<c:forEach items="${programList}" var="list" >
		<!-- 원래 있던 리스트 -->
		<tr>
		<td>${list.programName}</td>
		<td>${list.programDetail}</td>
		</tr>
		</c:forEach>
			<!-- 데이터 AJAX에서 추가해서 보여준다 -->
		</tbody>
	</table>
</form>
</div>
</div>