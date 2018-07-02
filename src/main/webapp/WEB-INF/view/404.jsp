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
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/script/google-analytics.js"></script>

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
			style="background-image: url(./images/parallax/parallax-01.jpg);">
			<div class="color-overlay">
				<!-- Page title -->
				<div class="container">
					<div class="row">
						<div class="col-sm-12">
							<ol class="breadcrumb">
								<li><a href="${pageContext.request.contextPath }/index.html">Home</a></li>
								<li class="active">404</li>
							</ol>
							<h1>404 Page not found</h1>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- 404 -->
	<section class="error-404">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h2 class="fadeIn appear">404</h2>
					<h3 class="fadeIn appear" data-start="700">Well this is
						embarrassing... We can’t find your page.</h3>
					<a class="btn btn-lg btn-default mt30 fadeIn appear"
						data-start="1000" href="${pageContext.request.contextPath }/index.html"><i class="fa fa-home"></i>
						Go back to home</a>
				</div>
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