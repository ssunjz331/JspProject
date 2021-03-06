<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - Start Bootstrap Template</title>

<!-- Bootstrap core CSS -->
<link href="<%=request.getContextPath()%>/resource/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/resource/css/shop-item.css" rel="stylesheet">
	<style type="text/css">
		ul.orderby-menu{
			float: right;
		}
		ul.orderby-menu li{
			display: inline;				/*  세로나열을 가로나열로 변경 */
			border-left:1px solid #999;		/* 각 메뉴의 왼쪽에 "|" 표시(분류 표시) */
			font:bold 12px Dotum;           /* 폰트 설정 - 12px의 돋움체 굵은 글씨로 표시 */
            padding:0 10px;					/* 각 메뉴 간격 */
		}
		ul.orderby-menu li a{
			color: black;					/* css 152 line */
		}
		ul.orderby-menu li:first-child {
			border-left: none;				/* 메뉴 분류중 제일 왼쪽의 "|"는 삭제 */
		}
	</style>


</head>
<body>
	<nav id="top">
		<jsp:include page="/views/common/header.jsp" /><br>
		<br>
	</nav>


	<!-- Page Content -->


	<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="sample_img/carousel-first.jpg" class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img src="sample_img/carousel-first.jpg" class="d-block w-100" alt="...">
			</div>
			<div class="carousel-item">
				<img src="sample_img/carousel-first.jpg" class="d-block w-100" alt="...">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a>
		<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span class="sr-only">Next</span>
		</a>
	</div>

	<div class="container">
		
		<div class="row">

			<div class="col-lg-12">

				<br>
				<hr>
				
				<div>
					<strong style="float: left;">${products.size() }</strong><span style="float: left;">&nbsp;개의 상품</span>
					<ul class="orderby-menu">
						<li><a href="#">신상품</a></li>
						<li><a href="#">낮은가격</a></li>
						<li><a href="#">인기상품</a></li>
						<li><a href="#">평점순</a></li>
					</ul>
				</div>
				<br><br><br>
				
				<div class="row">

					<c:forEach var="product" items="${products }">
					
						<div class="col-lg-3 col-md-6 mb-4">
							<div class="card h-100">
								<a href="${pageContext.request.contextPath }/DetailController?num=${product.num }">
									<img class="card-img-top" src="${product.img }" alt="">
								</a>
								<div class="card-body">
									<h6 class="card-title">
										<a href="${pageContext.request.contextPath }/DetailController?num=${product.num }"><b>${product.name }</b></a>
									</h6>
									<h7>￦ ${product.price }</h7>
									
								</div>
								<div class="card-footer">
									<small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
								</div>
							</div>
						</div>

					</c:forEach>

				</div>
				<!-- /.row -->

			</div>
			<!-- /.col-lg-12 -->

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy; Your Website 2020</p>
		</div>
		<!-- /.container -->
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>