<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<link rel="stylesheet"	href="${pageContext.request.contextPath}/CSS/faq.css">
<style type="text/css">
	.panel-group a{
		color:#60694e !important;
	}
</style>
<div class="container">
  <div class="col-md-12">
    <div class="tab-content panels-faq">
      <div class="tab-pane active" id="tab1">
        <div class="panel-group" id="help-accordion-1">
        <h3>FAQ <br>(자주 묻는 질문)</h3>
          <div class="panel panel-default panel-help">
            <a href="#opret-produkt" data-toggle="collapse" data-parent="#help-accordion-1">
              <div class="panel-heading">
                <h4>수강료는 어떻게 되나요?</h4>
              </div>
            </a>
            <div id="opret-produkt" class="collapse in">
              <div class="panel-body">
                <p>매달 Bbak's Yoga는 다양한 이벤트를 진행하오니, 본원에 문의해주시기 바랍니다.</p>
                <p><strong>tel: </strong>031-1111-2222</p>
              </div>
            </div>
          </div>
          <div class="panel panel-default panel-help">
            <a href="#rediger-produkt" data-toggle="collapse" data-parent="#help-accordion-1">
              <div class="panel-heading">
                <h4>요가가 처음인데 수강할 수 있나요?</h4>
              </div>
            </a>
            <div id="rediger-produkt" class="collapse">
              <div class="panel-body">
                <p>Bbak's 요가는 수강생들을 수준과 컨디션을 맞춰서 수업을 진행하기 때문에 실력에 상관없이 수강가능합니다.</p>
                <p></p>
              </div>
            </div>
          </div>
          <div class="panel panel-default panel-help">
            <a href="#ret-pris" data-toggle="collapse" data-parent="#help-accordion-1">
              <div class="panel-heading">
                <h4>환불 규정이 어떻게 되나요?</h4>
              </div>
            </a>
            <div id="ret-pris" class="collapse">
              <div class="panel-body">
                <p>환불해지는 1주일 안에만 가능합니다. 
환불시 10%위약금을 공재하고 이용하신 기간의 금액을 제한 후 환불해 드립니다.<br>
-카드로 결제하셨을 경우 카드 수수료를 공제합니다.</p>
                <p><strong>Example: </strong>Facere, id excepturi iusto aliquid beatae delectus nemo enim, ad saepe nam et.</p>
              </div>
            </div>
          </div>
          <div class="panel panel-default panel-help">
            <a href="#slet-produkt" data-toggle="collapse" data-parent="#help-accordion-1">
              <div class="panel-heading">
                <h4>수업 준비는 어떻게 해야하나요?</h4>
              </div>
            </a>
            <div id="slet-produkt" class="collapse">
              <div class="panel-body">
                <p>	
진한 화장과 향수 그리고 악세사리(목걸이, 반지, 시계등)의 착용을 삼가 해주시길 바랍니다.<br>
수련실 안에는 물병과 락카키 외의 반입을 금지합니다.(휴대폰, 디지털카메라, 음식물 등)<br>
요가는 공복에 하시는 것이 좋습니다.(식후 2~3시간 후)
뱃속에 음식이 가득 들어있으면 호흡과 아사나에 걸림돌이 됩니다<br>
수업 5분전에는 입실하여 주시기 바랍니다.
(명상과 안정은 아사나를 진행하는데 효과를 더욱 높여드립니다)</p>
                <p><strong>Example: </strong>Facere, id excepturi iusto aliquid beatae delectus nemo enim, ad saepe nam et.</p>
              </div>
            </div>
          </div>
          <div class="panel panel-default panel-help">
            <a href="#opret-kampagne" data-toggle="collapse" data-parent="#help-accordion-1">
              <div class="panel-heading">
                <h4>다이어트 요가만 다이어트 효과가 있나요?</h4>
              </div>
            </a>
            <div id="opret-kampagne" class="collapse">
              <div class="panel-body">
                <p>다이어트 뿐만 아니라 기타 여러가지 요가들도 다이어트 효과들이 
       많이 있습니다.
       요가는 왕성한 식욕을 조절하여주고 소화기능을 좋게 만들어줍니다.
       또한 요가를 통하여 바르게 잡힌 몸은 평상시에 칼로리 소비를 일정하게
      높여주어 지속적인 몸매관리와 요요현상이 없는 다이어트가 가능한 것입니다.</p>
                <p><strong></strong></p>
              </div>
            </div>
          </div>
        </div>
      </div>
  <!--     <div class="tab-pane" id="tab2">
        <div class="panel-group" id="help-accordion-2">      
          <div class="panel panel-default panel-help">
            <a href="#help-three" data-toggle="collapse" data-parent="#help-accordion-2">
              <div class="panel-heading">
                <h2>Question04</h2>
              </div>
            </a>
            <div id="help-three" class="collapse in">
              <div class="panel-body">
                <p>답변</p>
                <p><strong>Example: </strong>Facere, id excepturi iusto aliquid beatae delectus nemo enim, ad saepe nam et.</p>
              </div>
            </div>
          </div>
        </div>
      </div> -->
    </div>    
  </div>
</div>