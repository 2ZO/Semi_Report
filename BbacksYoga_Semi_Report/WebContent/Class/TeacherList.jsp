<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<%--이미지 테스트 <img src="${pageContext.request.contextPath}/Class/img/teacher/시우민.png1" alt="시우민">--%>

<!-- modal선택시 데이터를 받아올 ajax 영역  -->

<script>
   $(function() {
     
      $('a').click(function() {
         
         var teacherId = $(this).attr('id'); 
        // alert(teacherId);
         $('#myModal').on('show.bs.modal', function () {
//        	 alert(1);
            $.ajax({
               type : "get",
               url : "${pageContext.request.contextPath}/DispatcherServlet",
               dataType : "json",
               data : "command=teacherDetail&teacherId=" + teacherId,
               success : function(data) { 
                  /* alert(data.classList);  */
                  /* alert(data.teacherName); */
               var img="${pageContext.request.contextPath}/Image/teacher/"+data.img_url;
                  $("#tName").html(data.teacherName);
                  $("#nick").html(data.teacherNick); 
                  $("#pImg").attr("src",img); 
                  $("#tProfile").html(data.teacherProfile); 
                  $("#tClass").html(data.classList); 
               }//success
            })//ajax              
         })//show modal 	
         $('.modal').on('hidden.bs.modal', function () {
               $(this).removeData('bs.modal');
         });//hide modal
      })//a click
   })// function

</script>

<!-- 선생님 리스트  -->
<div id="mask"></div>
<div class="container">
   <div class="col-md-12 contents">
      <div class="row teacher-list">
         <c:forEach items="${requestScope.teacherList}" var="list" varStatus="vs">
               
            <!-- 선생님 박스  -->
            <div class="col-md-3">
               <section class="profile">
                  <!-- 사진 영역  -->
                  <div class="teacher-img-box">
                     <!-- 강사 사진을 누르면 디테일 페이지로 이동  -->
                     
                     <%-- <a
                        href="${pageContext.request.contextPath}/DispatcherServlet?command=teacherDetail&teacherId=${list.teacherId}"
                        
                        > --%>
                        <a href="#" data-toggle="modal"  data-target="#myModal" id="${list.teacherId}">                        
                        <img src="${pageContext.request.contextPath}/Image/teacher/${list.img_url}" alt="${list.img_url}">
                     </a> <%-- <a
                        href="${pageContext.request.contextPath}/DispatcherServlet?command=teacherDetail&teacherId=${list.teacherId}"
                        class="detail"> --%>
                        <%-- <a href="#" data-toggle="modal"  class="detail" id="${vs.index}"> --%>
                        <a href="#" class="detail" data-toggle="modal"  data-target="#myModal" id="${list.teacherId}">
                         <i class="fa teacherDetail"> <!-- 강사 아이콘박스를 누르면 디테일 페이지로 이동  -->
                           <img src="${pageContext.request.contextPath}/Image/teacher/yoga_teacher_icon.png">
                        </i>
                     </a>
                  </div>
                  <!-- 이름과 닉네임 영역 -->
                  <div class="panel-body text-center">
                     <h4 class="teacherName">${list.teacherName}</h4>
                     <p class="teacherNick">${list.teacherNick}</p>
                  </div>
               </section>
            </div>
            <!--  모달 id는 고유값이기 떄문에 foreach에서 modal을 돌리면 같이 넣어줘야함 -->
            <!-- The Modal -->
         </c:forEach>
      </div>
   </div>
</div>



<div class="modal fade" id="myModal">
   <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">

         <!-- Modal Header -->
         <div class="modal-header">
            <h4 class="modal-title">강사소개</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
         </div>

         <!-- Modal body -->
         <div class="modal-body">
            <div class="row profile_detail">
               <img class="profile-img" id="pImg" src="#">
               <div class="profile-text">
                  <div class="profile-description">
                     <span id="tName"></span>&nbsp;
                     <span id="nick"></span><br>
                     <span class="profile-title" id="tProfile"></span>
                  </div>
                  <div class="profile-description2">
                     <div class="profile-des">
                        <b>수강중인 프로그램</b>
                     </div>
                     <div class="profile-des" id="tClass">
                        현재 수강중인 강의가 없습니다.
                     </div>
                  </div>
               </div>
            </div>
         </div>

         <!-- Modal footer -->
         <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
         </div>

      </div>
   </div>
</div>
