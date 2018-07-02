<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" charset="utf-8">
<title>Starhotel</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

<!-- Stylesheets & script library -->
<c:import url="import.jsp" />

<!-- Google analytics -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/script/google-analytics.js"></script>

</head>

<body>

	<!-- Top header -->
	<c:import url="topHeader.jsp" />

	<!-- Sign up form-->
	<c:import url="signupTag.jsp" />

	<!-- Header -->
	<header>
		<!-- Navigation -->
		<c:import url="header.jsp" />

	</header>

	<!-- Parallax Effect -->
	<script type="text/javascript">
		$(document).ready(function() {
			$('#parallax-pagetitle').parallax("50%", -0.55);
		});
	</script>

	<section class="parallax-effect">
		<div id="parallax-pagetitle"
			style="background-image: url(${pageContext.request.contextPath }/resources/images/parallax/parallax-01.jpg);">
			<div class="color-overlay">
				<!-- Page title -->
				<div class="container">
					<div class="row">
						<div class="col-sm-12">
							<ol class="breadcrumb">
								<li><a href="${pageContext.request.contextPath }/index.html">Home</a></li>
								<li class="active">Gallery</li>
							</ol>
							<h1>Gallery</h1>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- Filter -->
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<ul class="nav nav-pills" id="filters">
					<li class="active"><a href="gallery.html#" data-filter="*">All</a></li>
					<li><a href="gallery.html#" data-filter=".rooms">Rooms</a></li>
					<li><a href="gallery.html#" data-filter=".restaurant">Restaurant</a></li>
					<li><a href="gallery.html#" data-filter=".pool">Swimming
							Pool</a></li>
					<li><a href="gallery.html#" data-filter=".business">Business</a></li>
				</ul>
			</div>
		</div>
	</div>

	<!-- Gallery -->
	<section id="gallery" class="mt50">
		<div class="container">
			<div class="row gallery">
				<!-- Image 1 -->
				<div class="col-sm-3 restaurant fadeIn appear" data-start="200">
					<a
						href="${pageContext.request.contextPath }/resources/images/gallery/1.jpg"
						data-rel="prettyPhoto[gallery1]"><img
						src="${pageContext.request.contextPath }/resources/images/gallery/1.jpg"
						alt="image" class="img-responsive zoom-img" /><i
						class="fa fa-search"></i></a>
				</div>
				<!-- Image 2 -->
				<div class="col-sm-3 pool fadeIn appear" data-start="200">
					<a
						href="${pageContext.request.contextPath }/resources/images/gallery/2.jpg"
						data-rel="prettyPhoto[gallery1]"><img
						src="${pageContext.request.contextPath }/resources/images/gallery/2.jpg"
						alt="image" class="img-responsive zoom-img" /><i
						class="fa fa-search"></i></a>
				</div>
				<!-- Image 3 -->
				<div class="col-sm-3 restaurant fadeIn appear" data-start="200">
					<a
						href="${pageContext.request.contextPath }/resources/images/gallery/3.jpg"
						data-rel="prettyPhoto[gallery1]"><img
						src="${pageContext.request.contextPath }/resources/images/gallery/3.jpg"
						alt="image" class="img-responsive zoom-img" /><i
						class="fa fa-search"></i></a>
				</div>
				<!-- Image 4 -->
				<div class="col-sm-3 pool fadeIn appear" data-start="200">
					<a
						href="${pageContext.request.contextPath }/resources/images/gallery/4.jpg"
						data-rel="prettyPhoto[gallery1]"><img
						src="${pageContext.request.contextPath }/resources/images/gallery/4.jpg"
						alt="image" class="img-responsive zoom-img" /><i
						class="fa fa-search"></i></a>
				</div>
				<!-- Image 5 -->
				<div class="col-sm-3 business fadeIn appear" data-start="200">
					<a
						href="${pageContext.request.contextPath }/resources/images/gallery/5.jpg"
						data-rel="prettyPhoto[gallery1]"><img
						src="${pageContext.request.contextPath }/resources/images/gallery/5.jpg"
						alt="image" class="img-responsive zoom-img" /><i
						class="fa fa-search"></i></a>
				</div>
				<!-- Image 6 -->
				<div class="col-sm-3 pool fadeIn appear" data-start="200">
					<a
						href="${pageContext.request.contextPath }/resources/images/gallery/6.jpg"
						data-rel="prettyPhoto[gallery1]"><img
						src="${pageContext.request.contextPath }/resources/images/gallery/6.jpg"
						alt="image" class="img-responsive zoom-img" /><i
						class="fa fa-search"></i></a>
				</div>
				<!-- Image 7 -->
				<div class="col-sm-3 business fadeIn appear" data-start="200">
					<a
						href="${pageContext.request.contextPath }/resources/images/gallery/7.jpg"
						data-rel="prettyPhoto[gallery1]"><img
						src="${pageContext.request.contextPath }/resources/images/gallery/7.jpg"
						alt="image" class="img-responsive zoom-img" /><i
						class="fa fa-search"></i></a>
				</div>
				<!-- Image 8 -->
				<div class="col-sm-3 pool fadeIn appear" data-start="200">
					<a
						href="${pageContext.request.contextPath }/resources/images/gallery/8.jpg"
						data-rel="prettyPhoto[gallery1]"><img
						src="${pageContext.request.contextPath }/resources/images/gallery/8.jpg"
						alt="image" class="img-responsive zoom-img" /><i
						class="fa fa-search"></i></a>
				</div>
				<!-- Image 1 -->
				<div class="col-sm-3 restaurant fadeIn appear" data-start="200">
					<a
						href="${pageContext.request.contextPath }/resources/images/gallery/9.jpg"
						data-rel="prettyPhoto[gallery1]"><img
						src="${pageContext.request.contextPath }/resources/images/gallery/9.jpg"
						alt="image" class="img-responsive zoom-img" /><i
						class="fa fa-search"></i></a>
				</div>
				<!-- Image 2 -->
				<div class="col-sm-3 pool fadeIn appear" data-start="200">
					<a
						href="${pageContext.request.contextPath }/resources/images/gallery/10.jpg"
						data-rel="prettyPhoto[gallery1]"><img
						src="${pageContext.request.contextPath }/resources/images/gallery/10.jpg"
						alt="image" class="img-responsive zoom-img" /><i
						class="fa fa-search"></i></a>
				</div>
				<!-- Image 3 -->
				<div class="col-sm-3 rooms fadeIn appear" data-start="200">
					<a
						href="${pageContext.request.contextPath }/resources/images/gallery/11.jpg"
						data-rel="prettyPhoto[gallery1]"><img
						src="${pageContext.request.contextPath }/resources/images/gallery/11.jpg"
						alt="image" class="img-responsive zoom-img" /><i
						class="fa fa-search"></i></a>
				</div>
				<!-- Image 4 -->
				<div class="col-sm-3 pool fadeIn appear" data-start="200">
					<a
						href="${pageContext.request.contextPath }/resources/images/gallery/12.jpg"
						data-rel="prettyPhoto[gallery1]"><img
						src="${pageContext.request.contextPath }/resources/images/gallery/12.jpg"
						alt="image" class="img-responsive zoom-img" /><i
						class="fa fa-search"></i></a>
				</div>
			</div>
		</div>
	</section>

	<!-- Call To Action -->
	<section id="call-to-action" class="mt100">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-sm-8 col-xs-12"></div>
				<div class="col-md-4 col-sm-4 col-xs-12"></div>
			</div>
		</div>
	</section>

	<!-- Footer -->
	<c:import url="footer.jsp" />

	<!-- Go-top Button -->
	<div id="go-top">
		<i class="fa fa-angle-up fa-2x"></i>
	</div>

</body>
</html>