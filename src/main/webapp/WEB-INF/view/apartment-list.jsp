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
								<li><a
									href="${pageContext.request.contextPath }/index.html">Home</a></li>
								<li class="active">Rooms Type View</li>
							</ol>
							<h1>Rooms Type List View</h1>
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
					<li class="active"><a
						href="${pageContext.request.contextPath }/apartment-list.html#"
						data-filter="*">All</a></li>
					<c:forEach var="apartmentType" items="${listApartmentType }">
						<li><a
							href="${pageContext.request.contextPath }/apartment-list.html#"
							data-filter=".${apartmentType.code }">${apartmentType.name }</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>

	<!-- Rooms -->
	<section class="rooms mt100">
		<div class="container">
			<div class="row room-list fadeIn appear">
				<!-- Room -->
				<c:forEach var="apartment" items="${listApartment }">
					<div class="col-sm-4 ${apartment.apartmentType.code }">
						<div class="room-thumb">
							<img
								src="${pageContext.request.contextPath }/resources/${apartment.image[0].imagePath }"
								alt="room 1" class="img-responsive" />
							<div class="mask">
								<div class="main">
									<h5>${apartment.apartmentType.name }</h5>
									<div class="price">
										&euro; ${apartment.apartmentType.price }<span>Monthly</span>
									</div>
								</div>
								<div class="content">
									<p>
										<span>${apartment.name }</span> <span style="min-height: 56px">${apartment.description }
										</span>
									</p>
									<ul class="row list-unstyled" style="min-height: 56px">
										<c:forEach var="criteria"
											items="${apartment.apartmentType.criterias }" begin="0"
											end="5">
											<li class="col-xs-6"><i class="fa fa-check-circle"></i>
												${criteria.name }</li>
										</c:forEach>
									</ul>
									<a
										href="${pageContext.request.contextPath }/Apartment-Type/${apartment.apartmentType.name }-${apartment.apartmentType.id }/Apartment/${apartment.name }-${apartment.id }/apartment-detail.html"
										class="btn btn-primary btn-block">Book Now</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
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