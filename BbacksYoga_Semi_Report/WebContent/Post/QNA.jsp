<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	h3{
		text-align: center;
	}
	.searchDiv{
		text-align: center;
	}
	.writePost{
		text-align: right;
		margin-right: 20%;
	}
	.input-group-btn{
		display: inline;
		margin-left: -5px;
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
	.btn-primary{
		background-color: #7c8864 !important;
		border-color: #7c8864 !important;
	}
	.btn-primary:hover{
		background-color: #8ab03e;
		border-color: #8ab03e;
	}
	.btn-primary option{
		background-color: #8ab03e;
		border-color: #8ab03e;
	}
</style>
<script type="text/javascript">
function getDetailPost(postNo){
	location.href="${pageContext.request.contextPath}/DispatcherServlet?command=getDetailPost&postNo="+postNo;
}
function createPost() {
	location.href="${pageContext.request.contextPath}/DispatcherServlet?command=writePostView";
}
</script>
<h3>Q&amp;A</h3>
<div class="writePost">
	<input type="button" class="btn btn-default" value="글쓰기" onclick="return createPost()">
</div>
<table>
  <thead>
  	<tr class="success">
    	<th>번호</th>
    	<th>제목</th>
    	<th>작성자</th>
    	<th>작성일</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach items="${requestScope.lvo.list}" var="post">
  		<tr onclick="getDetailPost(${post.postNo})">
  			<td>${post.postNo}</td>
  			<td>${post.title}</td>
  			<td>${post.id}</td>
  			<td>${post.regDate}</td>
  		</tr>
  	</c:forEach>	
  </tbody>
</table>
<br><br>
<!-- 게시물 검색 -->
<form id="listForm" action="${pageContext.request.contextPath}/DispatcherServlet?command=searchPost}">
<input type="hidden" name="command" value="searchPost">
	<fieldset>
		<div class="searchDiv">
			<select name="opt" class="btn btn-primary">
				<option value="0">제목</option>
				<option value="1">작성자</option>
			</select>	
			<input type="text" size="20" placeholder="키워드를 입력하세요" name="keyword" class="btn btn-default" required="required">
			<div class="input-group-btn">
        		<button class="btn btn-default" type="submit" id="searchBtn"><i class="glyphicon glyphicon-search"></i></button>
      		</div>
		</div>
	</fieldset>
</form>

<!-- 페이징 처리 -->
<div class="pagingInfo">
	<c:set var="pb" value="${requestScope.lvo.pagingBean}"></c:set>
	<ul class="pagination">
	<c:if test="${pb.previousPageGroup}">
		<li><a href="DispatcherServlet?command=postList&nowPage=${pb.startPageOfPageGroup-1}">&laquo;</a></li>
	</c:if>
	<c:forEach var="paging" begin="${pb.startPageOfPageGroup}" end="${pb.endPageOfPageGroup}"> 
		<c:choose>
			<c:when test="${pb.nowPage!=paging}">
				<li><a href="DispatcherServlet?command=postList&nowPage=${paging}">${paging}</a></li>
			</c:when>
			<c:otherwise>
				<li class="active"><a href="#">${paging}</a></li>
			</c:otherwise>
		</c:choose> 
	&nbsp;
	</c:forEach>
	<c:if test="${pb.nextPageGroup}">
		<li><a href="DispatcherServlet?command=postList&nowPage=${pb.endPageOfPageGroup+1}">&raquo;</a></li>
	</c:if>
 </ul>
</div>

