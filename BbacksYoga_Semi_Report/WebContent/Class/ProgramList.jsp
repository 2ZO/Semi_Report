<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<!-- table css 추가 / QNA.jsp와 동일 css 적용 -->
<style type="text/css">
	table {
    border-collapse: collapse;
    width: 60%;
	margin: 40px auto 0;
}

	th, td {
    text-align: left;
    padding: 8px;
}

	tr:nth-child(even){background-color: #f2f2f2}

	th {
    background-color: #7c8864;
    color: white;
}
/*페이징 클릭 버튼 색*/
	.pagination>.active>a, .pagination>.active>a:focus, .pagination>.active>a:hover,
	 .pagination>.active>span, .pagination>.active>span:focus, 
	 .pagination>.active>span:hover{
		background-color: #8ab03e;
		border-color: #8ab03e;
	}
	.pagination>li>a, .pagination>li>span{
		color: #777;
	}
</style>
<script>
	$(document).ready(function() {
		$('tr').click(function() {
			var pno = $(this).attr('id');
			$('#myModal').on('show.bs.modal', function () {
				$.ajax({
					type : "get",
					url : "${pageContext.request.contextPath}/DispatcherServlet",
					dataType : "json",
					data : "command=programDetail&programNo="+pno,
					success : function(data) {
						$("#programName").html(data.programName); 
						$("#programDetail").html(data.programDetail);
						var img1 ="${pageContext.request.contextPath}/Image/program/"+ data.programImg1;
						var img2 ="${pageContext.request.contextPath}/Image/program/"+ data.programImg2;
						var img3 ="${pageContext.request.contextPath}/Image/program/"+ data.programImg3;
						var img4 ="${pageContext.request.contextPath}/Image/program/"+ data.programImg4;
						$("#pImg1").attr("src", img1);
						$("#pImg2").attr("src", img2);
						$("#pImg3").attr("src", img3);
						$("#pImg4").attr("src", img4);
					}//success
				})//ajax 				 
			})//show modal
			$('.modal').on('hidden.bs.modal', function () {
	            $(this).removeData('bs.modal');
			});//hide modal
		}); //myModal click
	});
</script>
<!-- 프로그램 리스트 출력 -->
<table>
	<tr>
		<th>프로그램 번호</th><th>프로그램 이름</th>
	</tr>
	<c:forEach items="${requestScope.lvo.list}" var="plist" varStatus="py">
	<tr id="${plist.programNo}" data-toggle="modal"  data-target="#myModal" >
		<c:set var= "sum" value="${(requestScope.lvo.pagingBean.nowPage-1)*5}"/>
		<td class="programNo">${py.index+sum+1}</td>
		<td class="programName">${plist.programName }</td>
	</tr>
	</c:forEach>
</table>
<!-- 페이징 처리 -->
<div class="pagingInfo">
	<c:set var="pb" value="${requestScope.lvo.pagingBean}"></c:set>
	<ul class="pagination">
	
	<c:if test="${pb.previousPageGroup}">	
		<li><a href="DispatcherServlet?command=programList&pageNo=${pb.startPageOfPageGroup-1}">&laquo;</a></li>
	</c:if>
	<c:forEach var="i" begin="${pb.startPageOfPageGroup}" end="${pb.endPageOfPageGroup}">
	
	<c:choose>
	<c:when test="${pb.nowPage!=i}">
		<li><a href="DispatcherServlet?command=programList&pageNo=${i}">${i}</a></li> 
	</c:when>
	<c:otherwise>
		<li class="active"><a href="#" >${i}</a></li>
	</c:otherwise>
	</c:choose>
	
		&nbsp;
	</c:forEach>
	<c:if test="${pb.nextPageGroup}">	
		<li><a href="DispatcherServlet?command=programList&pageNo=${pb.endPageOfPageGroup+1}">&raquo;</a></li>
	</c:if>
	</ul>
</div> 	

<div class="modal fade" id="myModal">
	<div class="modal-dialog modal-dialog-centered">
		<div class="modal-content" >
			<!-- Modal Header -->
			<div class="modal-header">
				<h4 class="modal-title">프로그램 소개 : <span id="programName"></span></h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<br><br><br>
				<img class="profile-img" id="pImg1">
			</div>
			<!-- Modal body -->
			<div class="modal-body">
				<div class="row program_detail">
					<div class="profile-description">
						<div class="profile-des">
							<span id="programDetail"></span>
						</div>			
					</div>
					<table>
						<tr>
							<td><img class="profile-img" id="pImg2"></td>
							<td><img class="profile-img" id="pImg3"></td>
							<td><img class="profile-img" id="pImg4"></td>
						</tr>
					</table>
				</div>
			</div>
			<!-- Modal footer -->
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>

