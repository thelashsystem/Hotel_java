<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Service</title>
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
								<li class="active">Service list view</li>
							</ol>
							<h1>Service List View</h1>
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
					<li class="active"><a href="${pageContext.request.contextPath }/room-list.html#" data-filter="*">All</a></li>
					<li><a href="${pageContext.request.contextPath }/room-list.html#" data-filter=".single">Single
							Room</a></li>
					<li><a href="${pageContext.request.contextPath }/room-list.html#" data-filter=".double">Double
							Room</a></li>
					<li><a href="${pageContext.request.contextPath }/room-list.html#" data-filter=".executive">Executive
							Room</a></li>
					<li><a href="${pageContext.request.contextPath }/room-list.html#" data-filter=".apartment">Apartment</a></li>
				</ul>
			</div>
		</div>
	</div>

	<!-- Rooms -->
	<section class="rooms mt100">
		<div class="container">
			<div class="row room-list fadeIn appear">
			
				<!-- Room -->
				<c:forEach var="service" items="${listService }">
				<div class="col-sm-4 single">
					<div class="room-thumb">
						<img src="${pageContext.request.contextPath }/resources/images/rooms/room-01.jpg" alt="room 1"
							class="img-responsive" />
						<div class="mask">
							<div class="main">
								<h5>${service.name }</h5>
							</div>
							<div class="content">
								<p style="min-height: 140px;">
									<span><i>Working Time: </i>${service.workingTime }</span> 
									<span><i>Hot Line: </i>${service.hotLine }</span>
									${service.shortDescription }
								</p>
								<a href="${pageContext.request.contextPath }/Service/${service.name }-${service.id }/service-detail.html" class="btn btn-primary btn-block">Read
									More</a>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
				
				<!-- Room -->
				<%-- <div class="col-sm-4 double apartment">
					<div class="room-thumb">
						<img src="${pageContext.request.contextPath }/resources/images/rooms/room-02.jpg" alt="room 2"
							class="img-responsive" />
						<div class="mask">
							<div class="main">
								<h5>King Size Bedroom</h5>
								<div class="price">
									&euro; 149<span>a night</span>
								</div>
							</div>
							<div class="content">
								<p>
									<span>A modern hotel room in Star Hotel</span> Nunc tempor erat
									in magna pulvinar fermentum. Pellentesque scelerisque at leo
									nec vestibulum. malesuada metus.
								</p>
								<div class="row">
									<div class="col-xs-6">
										<ul class="list-unstyled">
											<li><i class="fa fa-check-circle"></i> Incl. breakfast</li>
											<li><i class="fa fa-check-circle"></i> Private balcony</li>
											<li><i class="fa fa-check-circle"></i> Sea view</li>
										</ul>
									</div>
									<div class="col-xs-6">
										<ul class="list-unstyled">
											<li><i class="fa fa-check-circle"></i> Free Wi-Fi</li>
											<li><i class="fa fa-check-circle"></i> Incl. breakfast</li>
											<li><i class="fa fa-check-circle"></i> Bathroom</li>
										</ul>
									</div>
								</div>
								<a href="${pageContext.request.contextPath }/room-detail.html" class="btn btn-primary btn-block">Book
									Now</a>
							</div>
						</div>
					</div>
				</div>
				<!-- Room -->
				<div class="col-sm-4 double apartment">
					<div class="room-thumb">
						<img src="${pageContext.request.contextPath }/resources/images/rooms/room-03.jpg" alt="room 3"
							class="img-responsive" />
						<div class="mask">
							<div class="main">
								<h5>Single room</h5>
								<div class="price">
									&euro; 120<span>a night</span>
								</div>
							</div>
							<div class="content">
								<p>
									<span>A modern hotel room in Star Hotel</span> Nunc tempor erat
									in magna pulvinar fermentum. Pellentesque scelerisque at leo
									nec vestibulum. malesuada metus.
								</p>
								<div class="row">
									<div class="col-xs-6">
										<ul class="list-unstyled">
											<li><i class="fa fa-check-circle"></i> Incl. breakfast</li>
											<li><i class="fa fa-check-circle"></i> Private balcony</li>
											<li><i class="fa fa-check-circle"></i> Sea view</li>
										</ul>
									</div>
									<div class="col-xs-6">
										<ul class="list-unstyled">
											<li><i class="fa fa-check-circle"></i> Free Wi-Fi</li>
											<li><i class="fa fa-check-circle"></i> Incl. breakfast</li>
											<li><i class="fa fa-check-circle"></i> Bathroom</li>
										</ul>
									</div>
								</div>
								<a href="${pageContext.request.contextPath }/room-detail.html" class="btn btn-primary btn-block">Book
									Now</a>
							</div>
						</div>
					</div>
				</div>
				<!-- Room -->
				<div class="col-sm-4 double executive">
					<div class="room-thumb">
						<img src="${pageContext.request.contextPath }/resources/images/rooms/room-04.jpg" alt="room 4"
							class="img-responsive" />
						<div class="mask">
							<div class="main">
								<h5>Deluxe Room</h5>
								<div class="price">
									&euro; 99<span>a night</span>
								</div>
							</div>
							<div class="content">
								<p>
									<span>A modern hotel room in Star Hotel</span> Nunc tempor erat
									in magna pulvinar fermentum. Pellentesque scelerisque at leo
									nec vestibulum. malesuada metus.
								</p>
								<div class="row">
									<div class="col-xs-6">
										<ul class="list-unstyled">
											<li><i class="fa fa-check-circle"></i> Incl. breakfast</li>
											<li><i class="fa fa-check-circle"></i> Private balcony</li>
											<li><i class="fa fa-check-circle"></i> Sea view</li>
										</ul>
									</div>
									<div class="col-xs-6">
										<ul class="list-unstyled">
											<li><i class="fa fa-check-circle"></i> Free Wi-Fi</li>
											<li><i class="fa fa-check-circle"></i> Incl. breakfast</li>
											<li><i class="fa fa-check-circle"></i> Bathroom</li>
										</ul>
									</div>
								</div>
								<a href="${pageContext.request.contextPath }/room-detail.html" class="btn btn-primary btn-block">Book
									Now</a>
							</div>
						</div>
					</div>
				</div>
				<!-- Room -->
				<div class="col-sm-4 double">
					<div class="room-thumb">
						<img src="${pageContext.request.contextPath }/resources/images/rooms/room-05.jpg" alt="room 5"
							class="img-responsive" />
						<div class="mask">
							<div class="main">
								<h5>Honeymoon Suite</h5>
								<div class="price">
									&euro; 179<span>a night</span>
								</div>
							</div>
							<div class="content">
								<p>
									<span>A modern hotel room in Star Hotel</span> Nunc tempor erat
									in magna pulvinar fermentum. Pellentesque scelerisque at leo
									nec vestibulum. malesuada metus.
								</p>
								<div class="row">
									<div class="col-xs-6">
										<ul class="list-unstyled">
											<li><i class="fa fa-check-circle"></i> Incl. breakfast</li>
											<li><i class="fa fa-check-circle"></i> Private balcony</li>
											<li><i class="fa fa-check-circle"></i> Sea view</li>
										</ul>
									</div>
									<div class="col-xs-6">
										<ul class="list-unstyled">
											<li><i class="fa fa-check-circle"></i> Free Wi-Fi</li>
											<li><i class="fa fa-check-circle"></i> Incl. breakfast</li>
											<li><i class="fa fa-check-circle"></i> Bathroom</li>
										</ul>
									</div>
								</div>
								<a href="${pageContext.request.contextPath }/room-detail.html" class="btn btn-primary btn-block">Book
									Now</a>
							</div>
						</div>
					</div>
				</div>
				<!-- Room -->
				<div class="col-sm-4 single executive apartment">
					<div class="room-thumb">
						<img src="${pageContext.request.contextPath }/resources/images/rooms/room-06.jpg" alt="room 6"
							class="img-responsive" />
						<div class="mask">
							<div class="main">
								<h5>Family Room</h5>
								<div class="price">
									&euro; 59<span>a night</span>
								</div>
							</div>
							<div class="content">
								<p>
									<span>A modern hotel room in Star Hotel</span> Nunc tempor erat
									in magna pulvinar fermentum. Pellentesque scelerisque at leo
									nec vestibulum. malesuada metus.
								</p>
								<div class="row">
									<div class="col-xs-6">
										<ul class="list-unstyled">
											<li><i class="fa fa-check-circle"></i> Incl. breakfast</li>
											<li><i class="fa fa-check-circle"></i> Private balcony</li>
											<li><i class="fa fa-check-circle"></i> Sea view</li>
										</ul>
									</div>
									<div class="col-xs-6">
										<ul class="list-unstyled">
											<li><i class="fa fa-check-circle"></i> Free Wi-Fi</li>
											<li><i class="fa fa-check-circle"></i> Incl. breakfast</li>
											<li><i class="fa fa-check-circle"></i> Bathroom</li>
										</ul>
									</div>
								</div>
								<a href="${pageContext.request.contextPath }/room-detail.html" class="btn btn-primary btn-block">Book
									Now</a>
							</div>
						</div>
					</div>
				</div>
				<!-- Room -->
				<div class="col-sm-4 single executive">
					<div class="room-thumb">
						<img src="${pageContext.request.contextPath }/resources/images/rooms/room-07.jpg" alt="room 7"
							class="img-responsive" />
						<div class="mask">
							<div class="main">
								<h5>Business Class</h5>
								<div class="price">
									&euro; 89<span>a night</span>
								</div>
							</div>
							<div class="content">
								<p>
									<span>A modern hotel room in Star Hotel</span> Nunc tempor erat
									in magna pulvinar fermentum. Pellentesque scelerisque at leo
									nec vestibulum. malesuada metus.
								</p>
								<div class="row">
									<div class="col-xs-6">
										<ul class="list-unstyled">
											<li><i class="fa fa-check-circle"></i> Incl. breakfast</li>
											<li><i class="fa fa-check-circle"></i> Private balcony</li>
											<li><i class="fa fa-check-circle"></i> Sea view</li>
										</ul>
									</div>
									<div class="col-xs-6">
										<ul class="list-unstyled">
											<li><i class="fa fa-check-circle"></i> Free Wi-Fi</li>
											<li><i class="fa fa-check-circle"></i> Incl. breakfast</li>
											<li><i class="fa fa-check-circle"></i> Bathroom</li>
										</ul>
									</div>
								</div>
								<a href="${pageContext.request.contextPath }/room-detail.html" class="btn btn-primary btn-block">Book
									Now</a>
							</div>
						</div>
					</div>
				</div>
				<!-- Room -->
				<div class="col-sm-4 double">
					<div class="room-thumb">
						<img src="${pageContext.request.contextPath }/resources/images/rooms/room-08.jpg" alt="room 8"
							class="img-responsive" />
						<div class="mask">
							<div class="main">
								<h5>Jungle View</h5>
								<div class="price">
									&euro; 139<span>a night</span>
								</div>
							</div>
							<div class="content">
								<p>
									<span>A modern hotel room in Star Hotel</span> Nunc tempor erat
									in magna pulvinar fermentum. Pellentesque scelerisque at leo
									nec vestibulum. malesuada metus.
								</p>
								<div class="row">
									<div class="col-xs-6">
										<ul class="list-unstyled">
											<li><i class="fa fa-check-circle"></i> Incl. breakfast</li>
											<li><i class="fa fa-check-circle"></i> Private balcony</li>
											<li><i class="fa fa-check-circle"></i> Sea view</li>
										</ul>
									</div>
									<div class="col-xs-6">
										<ul class="list-unstyled">
											<li><i class="fa fa-check-circle"></i> Free Wi-Fi</li>
											<li><i class="fa fa-check-circle"></i> Incl. breakfast</li>
											<li><i class="fa fa-check-circle"></i> Bathroom</li>
										</ul>
									</div>
								</div>
								<a href="${pageContext.request.contextPath }/room-detail.html" class="btn btn-primary btn-block">Book
									Now</a>
							</div>
						</div>
					</div>
				</div>
				<!-- Room -->
				<div class="col-sm-4 double apartment">
					<div class="room-thumb">
						<img src="${pageContext.request.contextPath }/resources/images/rooms/room-09.jpg" alt="room 9"
							class="img-responsive" />
						<div class="mask">
							<div class="main">
								<h5>Special Spa Room</h5>
								<div class="price">
									&euro; 259<span>a night</span>
								</div>
							</div>
							<div class="content">
								<p>
									<span>A modern hotel room in Star Hotel</span> Nunc tempor erat
									in magna pulvinar fermentum. Pellentesque scelerisque at leo
									nec vestibulum. malesuada metus.
								</p>
								<div class="row">
									<div class="col-xs-6">
										<ul class="list-unstyled">
											<li><i class="fa fa-check-circle"></i> Incl. breakfast</li>
											<li><i class="fa fa-check-circle"></i> Private balcony</li>
											<li><i class="fa fa-check-circle"></i> Sea view</li>
										</ul>
									</div>
									<div class="col-xs-6">
										<ul class="list-unstyled">
											<li><i class="fa fa-check-circle"></i> Free Wi-Fi</li>
											<li><i class="fa fa-check-circle"></i> Incl. breakfast</li>
											<li><i class="fa fa-check-circle"></i> Bathroom</li>
										</ul>
									</div>
								</div>
								<a href="${pageContext.request.contextPath }/room-detail.html" class="btn btn-primary btn-block">Book
									Now</a>
							</div>
						</div>
					</div>
				</div> --%>
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