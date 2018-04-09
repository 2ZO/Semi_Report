<%@page import="org.kosta.model.VO.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="org.kosta.model.etc.classDay"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
		  /*   $(".regLink").click(function(){
		    	console.log("regLink click");
		    	if(${sessionScope.memberVO.id ne null}){
		    	console.log("memberVO==null");
		    		alert("로그인을 하세요");
		    		location.href="${pageContext.request.contextPath}/DispatcherServlet?command=page&url=/Member/Login.jsp";
		    	}
		    }); */
		    $(".eventBtn").click(function(){
				$("#eventSpan").toggle(0);
		    });
	// 수강 희망 시간표 클릭 시 
		    var regList=[];
		    var overlapFlag=true;
		    var up=${requestScope.userPackage};
		    for(var i=0; i<up; i++){
				$("#event"+i).html('<img id="e_img" src="${pageContext.request.contextPath }/TimeTable/알.gif" alt="">');
		    }
		    $('td').click(function(){
		    	var td=$(this); //현재 <td> 위치값 저장
		    	if($(this).css("background-color")=="rgb(255, 255, 255)"||$(this).css("background-color")=="rgb(165, 255, 177)"){
		    		if($(this).find(".classNo").val()!=null){
		    			if(up>0){
		    				//ajax 중복체크
		    				$.ajax({
								type:"post",
								dataType:"json",
								url:"${pageContext.request.contextPath}/DispatcherServlet",
								data: "command=checkOverlapClass&classNo="+$(this).find(".classNo").val(),
								success:function(data){
									overlapFlag=data.flag;
									if(overlapFlag){
			    						td.css("background","rgb(142, 255, 128)");
		    							regList.push(td.find(".classNo").val());
		    							console.log('after push regList: '+regList);
		    							up-=1;
		    							$("#back_page").val("신청 가능 횟수: "+up+"/"+${requestScope.userPackage});
									}else{
										alert("이미 신청한 강좌입니다!");
										overlapFlag=true;
									}//else class.val=null
								}//success
							});//ajax
		    			}else{
		    				alert("수강신청 가능 횟수를 모두 소모하셨습니다.");
		    			}// else userPackage=0
		    		}// if class.val!=null
		    	}else{
			    	$(this).css("background","white");
		    		regList.splice(regList.indexOf(""), 1);
		    		up+=1;
		    		if(${requestScope.userPackage}==up)
		    			$("#back_page").val("신청 가능 횟수: "+up);
		    		else
		    			$("#back_page").val("신청 가능 횟수: "+up+"/"+${requestScope.userPackage});
		    	}//else bgcolor=black
		    	console.log('package: '+up+', package: '+${requestScope.userPackage});
		    	$("#btn").val('패키지: '+up);
				for(var i=0; i<up; i++){
					$("#event"+i).html('<img id="e_img" src="${pageContext.request.contextPath }/TimeTable/알.gif" alt="">');
				}
				for(var j=up; j<${requestScope.userPackage}; j++){
					if(j==0){
						$("#event"+j).html('<img id="e_img" src="${pageContext.request.contextPath }/TimeTable/후라이2.gif" alt="">');
					}else{
						$("#event"+j).html('<img id="e_img" src="${pageContext.request.contextPath }/TimeTable/토토로.gif" alt="">');
					}
				}
		    });//click <td>
		    $("#regStart").click(function(){
		    	if(regList==""){
		    		alert("최소 1개 이상의 강좌를 신청하세요.");
		    	}else{
		    		var flag=confirm("신청 강좌수: "+regList.length+"개\n수강 신청을 하시겠습니까?\n\n(*주의: 당일 강좌는 신청 후 취소가 불가능 합니다.)\n");
		    		if(flag){
		    			location.href="${pageContext.request.contextPath}/DispatcherServlet?command=Create_NewRegisterClass&classNo="+regList;
		    		}
		    	}
		    });
		 });//ready
		 function btn_sys(a){
				if(a==0)
					location.href="${pageContext.request.contextPath}/DispatcherServlet?command=temp";
					else{
						location.href="${pageContext.request.contextPath}/DispatcherServlet?command=temp2";
				}
			}
	</script>


<!-- CSS -->
<style type="text/css">
#eventSpan{
	display: none;
}
.title {
	background-color: #4E7D55;
	color: white;
	font-size: 1.5em;
	padding: 1rem;
	text-align: center;
	text-transform: uppercase;
}

.table-users {
	border: #4E7D55;
	border-radius: 10px;
	box-shadow: 3px 3px 0 rgba(0, 0, 0, 0.1);
	max-width: calc(100% - 2em);
	margin: 1em auto;
	overflow: hidden;
	width: 100%;
}

table {
	text-align: center;
	border-collapse: collapse;
	width: 100%;
	font-weight: bold;
	opacity: 1;
	padding-left: 150px;
	padding-right: 150px;
}

table:hover tbody td a {
	opacity: .3;
}

table tbody td:hover a {
	opacity: 1;
	font-size: larger;
}

table a {
	color: black;
	text-decoration: none;
}

table a:hover {
	color: #007D12;
	text-decoration: none;
}

body {
	margin: 0;
	font-family: sans-serif;
	font-weight: 100;
}

th {
	background-color: #EDFFF0;
	text-align: center;
	border-style: solid;
	border-width: 1px;
	padding: 8px;
	width: 150px;
	height: 40px;
	color: #4E7D55;
}
td {
	background-color: white;
	text-align: center;
	border-style: solid;
	border-width: 1px;
	padding: 8px;
	width: 150px;
	height: 90px;
}

#classtime {
	width: 50px;
}

.fullClass {
	color: red;
	font-style: italic;
	text-decoration: line-through;
}

#back_page {
	margin-top: 10px;
	margin-bottom: 5px;
}

#today {
	background-color: #A5FFB1;
}
.past{
	color: #E6E6E6;
	font-style: italic;
	text-decoration: line-through;
}
#e_img{
	width: 5%;
}
</style>

<!-- body부분 -->
<%
	// 오늘 요일의 정보를 현재 페이지 변수인 pageContext.setAttribute에 저장
	// *Date().getDay() 현재요일의 데이터 값을 일~토 = 0~6으로 받는다.
	// 초기 시간표 구현시 월~토 = 0~5로 구현하여, 'today-1'값을 변수로 저장
	pageContext.setAttribute("today", new Date().getDay() - 1);
%>
<div class="col-sm-1"></div>
<div class="col-sm-10">
	<!-- 로그인 시 회원의 package수 출력 -->
	<c:choose>
		<c:when test="${sessionScope.memberVO.id!=null }">
			<input id="back_page" class="eventBtn" type="button" value="신청 가능 횟수: ${requestScope.userPackage}">
			<input id="regStart" type="button" value="강좌 수강 신청하기">
			<span id="eventSpan"><span id="event0"></span><span id="event1"></span><span id="event2"></span><span id="event3"></span><span id="event4"></span></span>
		</c:when>
		<c:otherwise>
			<!-- 비로그인 시 로그인 필요 구문 출력 -->
			<a href="${pageContext.request.contextPath}/DispatcherServlet?command=page&url=/Member/Login.jsp">
				<input id="back_page" type="button" value="로그인을 하세요">
			</a>
		</c:otherwise>
	</c:choose>
<%	
	MemberVO mvo=(MemberVO)session.getAttribute("memberVO");
	pageContext.setAttribute("today_date", new Date().getDay()-1);
	request.setAttribute("flag", request.getAttribute("flag_no"));
%>
<c:if test="${sessionScope.memberVO.id eq 'sys' }">
	<c:choose>
		<c:when test="${requestScope.flag eq 0}">
			<input type="button" value="블라인드 모드" onclick="btn_sys(0)"><br>
		</c:when>
		<c:otherwise>
			<input type="button" value="블라인드 모드" onclick="btn_sys(1)"><br>
		</c:otherwise>
	</c:choose>
</c:if> 

	<div class="table-users">
		<div class="title">Time Table</div>
		<!-- timetable -->
		<table id="maintable">
			<!-- table head / 요일 입력 -->
			<thead id="table_head">
				<tr>
					<th id="classtime">TIME</th>
					<c:choose>
						<c:when test="${pageScope.today == 0 }">
							<th id="today">MON</th><th>TUE</th><th>WED</th><th>THU</th><th>FRI</th><th>SAT</th>
						</c:when>
						<c:when test="${pageScope.today == 1 }">
							<th>MON</th><th id="today">TUE</th><th>WED</th><th>THU</th><th>FRI</th><th>SAT</th>
						</c:when>
						<c:when test="${pageScope.today == 2 }">
							<th>MON</th><th>TUE</th><th id="today">WED</th><th>THU</th><th>FRI</th><th>SAT</th>
						</c:when>
						<c:when test="${pageScope.today == 3 }">
							<th>MON</th><th>TUE</th><th>WED</th><th id="today">THU</th><th>FRI</th><th>SAT</th>
						</c:when>
						<c:when test="${pageScope.today == 4 }">
							<th>MON</th><th>TUE</th><th>WED</th><th>THU</th><th id="today">FRI</th><th>SAT</th>
						</c:when>
						<c:when test="${pageScope.today == 5 }">
							<th>MON</th><th>TUE</th><th>WED</th><th>THU</th><th>FRI</th><th id="today">SAT</th>
						</c:when>
						<c:otherwise>
							<th>MON</th><th>TUE</th><th>WED</th><th>THU</th><th>FRI</th><th>SAT</th>
						</c:otherwise>
					</c:choose>

				</tr>
			</thead>
			<!-- table body -->
			<tbody id="timetable">
				<c:choose>
					<%-- <c:when test="true"> --%>
					<c:when test="${requestScope.flag eq 0 }">
						<tr>
							<td class="" colspan="7">다음주 시간표 준비중 입니다.<br> <img
								src="${pageContext.request.contextPath }/TimeTable/settingTime.gif"
								alt=""></td>
						</tr>
					</c:when>
					<c:when test="${pageScope.today eq -1 }">
						<tr>
							<td class="" colspan="7">다음주 시간표 준비중 입니다.<br> <img
								src="${pageContext.request.contextPath }/TimeTable/settingTime.gif"
								alt=""></td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach begin="1" end="8" varStatus="countOfClassTime">
							<tr>
								<!-- 1열 1~8교시 입력 -->
								<td id="classtime">${countOfClassTime.count }</td>
								<!-- 요일 데이터변수 week에 0~5 지정 -->
								<c:forEach begin="0" end="5" varStatus="week">
									<%-- <!-- week과 today 데이터 값이 같을 때 해당 <td>에 id를 주어 색을 입힌다.(오늘에 해당하는 테이블열) -->
									<c:choose>
										<c:when test="${week.index eq pageScope.today }">
											<td id="today">
										</c:when>
										<c:otherwise>
											<td>
										</c:otherwise>
									</c:choose> --%>
									<td>
									<!-- 시간표 List 변수 선언 -->
									<c:forEach items="${timetable_list }" var="list"
										varStatus="tdNo">
										<!-- 클래스의 시간, 클래스에 맞는 위치에 클래스 정보 출력 -->
										<c:if
											test="${list.classTime==countOfClassTime.count&&list.classDay==week.index }">
											<!-- 정원와 등록인원이 같을 때 link를 해제한다. -->
											<c:choose>
												<c:when test="${list.capacity==list.count_reg }">
													<span class="fullClass">${list.programName }<br>${list.teacherNick }<br>${list.count_reg }/
														${list.capacity }
													</span>
												</c:when>
												<c:when test="${week.index < pageScope.today }">
													<span class="past">${list.programName }<br>${list.teacherNick }<br>${list.count_reg }/
														${list.capacity }
													</span>
												</c:when>
												<c:otherwise>
													<!-- 클래스 내용을 누르면 수강 신청으로 연결되는 링크 삽입 -->
													<a class="regLink">${list.programName }<br>${list.teacherNick }<br>
														${list.count_reg }/ ${list.capacity }
														<input type="hidden" name="classNo" class="classNo" value="${list.classNo }">
													</a>
												</c:otherwise>
											</c:choose>
										</c:if>
									</c:forEach>
									</td>
								</c:forEach>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</div>
<div class="col-sm-1"></div>