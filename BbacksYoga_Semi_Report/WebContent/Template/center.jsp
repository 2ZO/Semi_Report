<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Bootstrap core CSS -->
   <link href="${pageContext.request.contextPath}/CSS/min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/CSS/carousel.css" rel="stylesheet">
  </head>
  <body>
    <div class="container-fluid center">
    <main role="main">

      <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img class="first-slide" src="${pageContext.request.contextPath}/Image/center/main02.jpg" alt="First slide">
            <div class="container">
              <div class="carousel-caption text-left">
                <h1>Bbak's Yoga</h1>
                <p>Yoga is like music. The Rhythm of the body, the melody of the mind and the harmony of the soul creates the symphony of life.</p>
                <p><a class="btn btn-lg btn-primary" href="#" role="button">Sign up today</a></p>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <img class="second-slide" src="${pageContext.request.contextPath}/Image/center/main01.jpg" alt="Second slide">
            <div class="container">
              <div class="carousel-caption">
                <h1>Yoga is my life.</h1>
                <p>Those who practice yoga have joy within, delight within and radiance within. </p>
                <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <img class="third-slide" src="${pageContext.request.contextPath}/Image/center/main03.jpg" alt="Third slide">
            <div class="container">
              <div class="carousel-caption text-right">
                <h1>One more for good measure.</h1>
                <p>The superior man is modest in his speech, but exceeds in his action.</p>
                <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
              </div>
            </div>
          </div>
        </div>
        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>


      <!-- Marketing messaging and featurettes
      ================================================== -->
      <!-- Wrap the rest of the page in another container to center all the content. -->

      <div class="marketing">

        <!-- Three columns of text below the carousel -->
        <div class="row">
          <div class="col-lg-4">
            <img class="rounded-circle" src="${pageContext.request.contextPath}/Image/center/con01.png" alt="Generic placeholder image" width="140" height="140">
            <h2>Ashtanga Yoga</h2>
            <p>아쉬탕가 요가는 빈야사라고 불리우는 호흡과 움직임의 독특한 조화입니다.가까운 층에 쌓인 독소를 제거하여, 정화시키는 역할을 합니다.</p>
            <p><a class="btn btn-secondary" href="${pageContext.request.contextPath}/DispatcherServlet?command=programList" role="button">View details &raquo;</a></p>
          </div><!-- /.col-lg-4 -->
          <div class="col-lg-4">
            <img class="rounded-circle" src="${pageContext.request.contextPath}/Image/center/con02.png" alt="Generic placeholder image" width="140" height="140">
            <h2>Pilates</h2>
            <p>필라테스는 스트레칭을 좀더 체계적으로 하여 몸을 건강하게 단련시키고 아름답게 가꿔가는데 좋은 운동법입니다.</p>
            <p><a class="btn btn-secondary" href="${pageContext.request.contextPath}/DispatcherServlet?command=programList"" role="button">View details &raquo;</a></p>
          </div><!-- /.col-lg-4 -->
          <div class="col-lg-4">
            <img class="rounded-circle" src="${pageContext.request.contextPath}/Image/center/con03.png" alt="Generic placeholder image" width="140" height="140">
            <h2>Vinyasa Yoga</h2>
            <p>빈야사 요가란 호흡의 리듬을 따라 그 기운을 놓치지 않고 자연스럽게 자세를 연결시키는 독특한 아사나 수련법입니다.</p>
            <p><a class="btn btn-secondary" href="${pageContext.request.contextPath}/DispatcherServlet?command=programList"" role="button">View details &raquo;</a></p>
          </div><!-- /.col-lg-4 -->
        </div><!-- /.row -->
      </div><!-- /.container -->


      <!-- FOOTER -->
      <footer class="container">
        <p class="float-right"><a href="#">Back to top</a></p>
      </footer>
    </main>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <!-- <script src="bootstrap-4.0.0-dist/js/vendor/popper.min.js"></script> -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <!-- <script src="bootstrap-4.0.0-dist/js/holder.min.js"></script> -->
  </div>
  </body>

