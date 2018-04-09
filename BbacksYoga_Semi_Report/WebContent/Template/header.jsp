<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script
   src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/js/header.js"></script>
<!-- 스크립트 별도 폴더에 넣고 import -->

<!-- header -->
   <!-- header 쪽 로고 -->   
   <head>
     <script type="text/javascript">
     $(document).ready(function(){
		setTimeout(function() {
			$("#rotation2").html('<img id="egg" src="${pageContext.request.contextPath }/TimeTable/카카오.gif" width="200px" height="200px">');
		}, 2200);
     });
    </script>
   <style type="text/css">
    #rotation {
		-webkit-animation: rotation 2s linear;
		
	}

	@-webkit-keyframes rotation {
		from {
				-webkit-transform: rotate(0deg);
		}
		to {
				-webkit-transform: rotate(359deg);
		}
	}
</style>
   </head>
   
   <div class="row">
       <div class="col-sm-4"></div>
       <div class="col-sm-4">
          <h1 id="headerLogo">
            <c:choose>
          		<c:when test="${sessionScope.egg_flag eq 'true' }">
          			<a href="" id="rotation2" ><img id="rotation" src="${pageContext.request.contextPath}/Image/logo01.png" alt="logo"></a>
          		</c:when>
          		<c:otherwise>
          			<a href="${pageContext.request.contextPath }/index.jsp"><img src="${pageContext.request.contextPath}/Image/logo01.png" alt="logo"></a>
          		</c:otherwise>				
          	</c:choose>
         </h1>
       </div>
       <div class="col-sm-4">
          <div id="rightWrap" class="setDiv">
            <ul id="headerRight">
               <c:choose>
                  <c:when test="${empty memberVO}">
                     <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=page&url=/Member/Login.jsp">Login</a></li>
                     <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=page&url=/Member/Register.jsp">Join</a></li>
                     <!-- "   -->
                  </c:when>
                  <c:otherwise>
                     <li><span>${memberVO.name}님 환영합니다.</span>
                     <li><span><a href="${pageContext.request.contextPath}/Member/Logout.jsp">LogOut</a></span>
                  </c:otherwise>
               </c:choose>
            </ul>
         </div>       
       </div>
    </div>
    
 <nav class="navbar navbar-inverse">
      <div class="container-fluid">
         <div class="navWrap">
            <ul class="nav navbar-nav">
               <li class="dropdown "><a class="dropdown-toggle"   data-toggle="dropdown" href="#">Bbak's</a>
                  <ul class="dropdown-menu ">
                     <li><a href="DispatcherServlet?command=page&url=/Post/intro.jsp">Bbak's 요가소개</a></li>
                     <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=teacherList">강사진소개</a></li>
                     <li><a href="DispatcherServlet?command=page&url=/Post/studio.jsp">시설소개</a></li>
                  </ul></li>
            </ul>
            <ul class="nav navbar-nav">
               <li class="dropdown"><a class="dropdown-toggle"   data-toggle="dropdown" href="#">Lesson</a>
                  <ul class="dropdown-menu">
                     <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=programList">프로그램 소개</a></li>
                     <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=Read_Timetable">강좌시간표</a></li>
                     <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=page&url=/TimeTable/RegisterClass_ok.jsp">강좌 신청</a></li>
                  </ul></li>
            </ul>
            <ul class="nav navbar-nav">
               <li class="dropdown">
               <a class="dropdown-toggle"   data-toggle="dropdown" href="#">Community</a>
                  <ul class="dropdown-menu">
                     <li><a href="DispatcherServlet?command=page&url=/Post/FAQ.jsp">FAQ</a></li>
                     <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=postList&nowPage=1">Q&amp;A</a></li>
                  </ul></li>
            </ul>
          
             <c:if test="${empty sessionScope.memberVO || !empty sessionScope.memberVO.id  }"> 
				<c:if test="${sessionScope.memberVO.id ne 'sys'}">

				<ul class="nav navbar-nav">
				<li class="dropdownn">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">My Page</a>
				<ul class="dropdown-menu">
                     <li><a href="DispatcherServlet?command=page&url=/Member/MyInfoCheck.jsp">내정보 수정</a></li>
                     <li><a href="DispatcherServlet?command=Read_Register">수강내역 확인</a></li>
                  </ul>
                  </li>
                   </ul>
                   </c:if>
            </c:if>
            <c:if test="${memberVO.id eq 'sys'}">
				<ul class="nav navbar-nav">
				<li class="dropdownn">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">관리자</a>
				<ul class="dropdown-menu">
                     <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=addClassView&option=class">강좌 등록</a></li>
                     <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=addClassView&option=teacher">강사 등록</a></li>
                     <li><a href="${pageContext.request.contextPath}/DispatcherServlet?command=addClassView&option=program">과목 등록</a></li>
                  </ul>
                  </li>
                   </ul>
            </c:if>
            
         </div>
      </div>
   </nav>
<audio id="club" controls autoplay="autoplay" loop="loop" hidden=""> 
   			<c:choose>
   				<c:when test="${sessionScope.egg_flag eq 'true' }">
   					<source src="TimeTable/EDM.mp3" type="audio/mpeg">
   				</c:when>
   				<c:otherwise>
   					<source src="TimeTable/main.mp3" type="audio/mpeg" >
   				</c:otherwise>
   			</c:choose>
		</audio>
		<%session.setAttribute("egg_flag", null); %>
