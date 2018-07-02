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
<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/resources/script/google-analytics.js"></script> --%>

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
								<li><a
									href="${pageContext.request.contextPath }/index.html">Home</a></li>
								<li><a
									href="${pageContext.request.contextPath }/apartment-list.html">Apartment
										Type</a></li>
								<li><a
									href="${pageContext.request.contextPath }/Apartment-Type/${apartment.apartmentType.name }-${apartment.apartmentType.id }/apartment-list.html">${apartment.apartmentType.name }</a></li>
								<li class="active">Apartment details</li>
							</ol>
							<h1>Apartment details</h1>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<div class="container">
		<div class="row">
			<!-- Slider -->
			<section class="room-slider standard-slider mt50">
				<div class="col-sm-12 col-md-8">
					<div id="owl-standard" class="owl-carousel">
						<c:forEach var="image" items="${apartment.image }">
							<div class="item">
								<a
									href="${pageContext.request.contextPath }/resources/${image.imagePath }"
									data-rel="prettyPhoto[gallery1]"><img
									src="${pageContext.request.contextPath }/resources/${image.imagePath }"
									alt="Bed" class="img-responsive"></a>
							</div>
						</c:forEach>
					</div>
				</div>
			</section>

			<!-- Reservation form -->
			<section id="reservation-form" class="mt50 clearfix">
				<div class="col-sm-12 col-md-4">
					<form class="reservation-vertical clearfix" role="form"
						method="post"
						action="${pageContext.request.contextPath }/booking-apartment.html"
						name="reservationform" id="reservationform">
						<input type="hidden" value="${apartment.id }" name="apartmentId" />
						<h2 class="lined-heading">
							<span>Reservation</span> <input type="hidden" name='apartmentId'
								value='${apartment.id }' />
						</h2>
						<div class="price">
							<h4>${apartment.apartmentType.name }</h4>
							&euro; 99,-<span> a night</span>
						</div>
						<div id="message"></div>
						<!-- Error message display -->
						<div class="form-group">
							<label for="email" accesskey="E">E-mail</label> <br />
							<c:choose>
								<c:when test="${not empty user }">
									<span style="line-height: 34px;">${user.email }</span>
								</c:when>
								<c:otherwise>
									<input name="email" type="email" id="email" value=""
										class="form-control" placeholder="Please enter your E-mail" />
								</c:otherwise>
							</c:choose>

						</div>
						<!-- <div class="form-group">
							<select class="hidden" name="room" id="room">
								<option selected="selected">Double Room</option>
							</select>
						</div> -->
						<div class="form-group">
							<label for="checkIn">Check-in</label>
							<div class="popover-icon" data-container="body"
								data-toggle="popover" data-trigger="hover"
								data-placement="right" data-content="Check-In is from 11:00">
								<i class="fa fa-info-circle fa-lg"> </i>
							</div>
							<i class="fa fa-calendar infield"></i> <input name="checkIn"
								type="text" id="checkIn" value="" class="form-control"
								placeholder="Check-in" />
						</div>
						<div class="form-group">
							<label for="checkOut">Check-out</label>
							<div class="popover-icon" data-container="body"
								data-toggle="popover" data-trigger="hover"
								data-placement="right" data-content="Check-out is from 12:00">
								<i class="fa fa-info-circle fa-lg"> </i>
							</div>
							<i class="fa fa-calendar infield"></i> <input name="checkOut"
								type="text" id="checkOut" value="" class="form-control"
								placeholder="Check-out" />
						</div>
						<div class="form-group">
							<div class="guests-select">
								<label>Guests</label> <i class="fa fa-user infield"></i> <input
									class="total form-control" id="test" value="1" name='numGuest'>
								<div class="guests">
									<div class="form-group adults">
										<label for="adults">Adults</label>
										<div class="popover-icon" data-container="body"
											data-toggle="popover" data-trigger="hover"
											data-placement="right" data-content="+18 years">
											<i class="fa fa-info-circle fa-lg"> </i>
										</div>
										<select id="adults" class="form-control">
											<option value="1">1 adult</option>
											<option value="2">2 adults</option>
											<option value="3">3 adults</option>
										</select>
									</div>
									<div class="form-group children">
										<label for="children">Children</label>
										<div class="popover-icon" data-container="body"
											data-toggle="popover" data-trigger="hover"
											data-placement="right" data-content="0 till 18 years">
											<i class="fa fa-info-circle fa-lg"> </i>
										</div>
										<select id="children" class="form-control">
											<option value="0">0 children</option>
											<option value="1">1 child</option>
											<option value="2">2 children</option>
											<option value="3">3 children</option>
										</select>
									</div>
									<button type="button"
										class="btn btn-default button-save btn-block">Save</button>
								</div>
							</div>
						</div>
						<button type="submit" class="btn btn-primary btn-block">Book
							Now</button>
					</form>
				</div>
			</section>

			<!-- Room Content -->
			<section>
				<div class="container">
					<div class="row">
						<div class="col-sm-7 mt50">
							<h2 class="lined-heading">
								<span>Apartment Details</span>
							</h2>
							<h3 class="mt50">Apartment Details</h3>
							<div class="container-fluid table table-striped">
								<div class="row">
									<%-- <div class="col-md-4">${apartment.apartmentType.criterias }</div> --%>
									<c:forEach var="criteria"
										items="${apartment.apartmentType.criterias }">
										<div class="col-xs-12 col-sm-6 col-md-4 col-lg-4 mt20 ">
											<i class="fa-2x ${criteria.icon.code }"></i> &nbsp;
											${criteria.name }
										</div>
									</c:forEach>
								</div>
							</div>
							<h3 class="mt50">Discription:</h3>
							<p>${apartment.description }</p>
						</div>
						<div class="col-sm-5 mt50">
							<h2 class="lined-heading">
								<span>Overview</span>
							</h2>

							<!-- Nav tabs -->
							<ul class="nav nav-tabs">
								<li class="active"><a
									href="${pageContext.request.contextPath }/detail-apartment.html#overview"
									data-toggle="tab">Features</a></li>
								<li><a
									href="${pageContext.request.contextPath }/detail-apartment.html#facilities"
									data-toggle="tab">Facilities</a></li>
								<li><a
									href="${pageContext.request.contextPath }/detail-apartment.html#floorPlan"
									data-toggle="tab">FloorPlan</a></li>
								<li><a
									href="${pageContext.request.contextPath }/detail-apartment.html#rentChart"
									data-toggle="tab">Rent Chart</a></li>
							</ul>
							<!-- Tab panes -->
							<div class="tab-content">
								<div class="tab-pane fade in active" id="overview">
									<div class='container-fluid'>
										<div class='row'>
											<h5 class='col-md-4'>Apartment Size:</h5>
											<span class='col-md-2'>${apartment.apartmentSize	 }</span>
											<h5 class='col-md-4'>Total Rooms:</h5>
											<span class='col-md-2'>${apartment.numberRoom }</span>
										</div>
										<div class='row'>
											<h5 class='col-md-4'>Bedrooms:</h5>
											<span class='col-md-2'>${apartment.numberBedroom }</span>
											<h5 class='col-md-4'>Bathrooms:</h5>
											<span class='col-md-2'>${apartment.numberBathroom }</span>
										</div>
										<div class='row'>
											<h5 class='col-md-4'>Car Garage:</h5>
											<span class='col-md-2'></span>
											<h5 class='col-md-4'>Basement:</h5>
											<span class='col-md-2'></span>
										</div>
										<div class='row'>
											<h5 class='col-md-4'></h5>
											<span class='col-md-2'></span>
											<h5 class='col-md-4'>Year Of Build:</h5>
											<span class='col-md-2'>${apartment.floor.building.yearBuild }</span>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="facilities">
									<div class='container-fluid'>
										<div class='row'>
											<c:forEach var="facility" items="${listFacility }">
												<div class='col-md-6'>${facility.equipment.name }</div>
											</c:forEach>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="floorPlan">
									<img
										src='${pageContext.request.contextPath }/resources/${apartment.floorPlanImage }'
										width='420' height='280' />
								</div>
								<div class="tab-pane fade" id="rentChart">
									<div class='container-fluid'>
										<div class='row'>
											<h5 class='col-md-6'>Stay Duration:</h5>
											<span class='col-md-6'>Regular Price</span>
										</div>
										<div class='row'>
											<h5 class='col-md-6'>Rent per Month:</h5>
											<span class='col-md-6'>${apartmentTypePrice.price }</span>
										</div>
										<div class='row'>
											<h5 class='col-md-6'>Deposit Amount(%):</h5>
											<span class='col-md-6'>${apartment.apartmentType.depositPercentageRate * 100 }%</span>
										</div>
										<div class='row'>
											<hr />
										</div>
										<div class='row'>
											<h5 class='col-md-6'>Building:</h5>
											<span class='col-md-6'>
												${apartment.floor.building.name }</span>
										</div>
										<div class='row'>
											<h5 class='col-md-6'>Floor:</h5>
											<span class='col-md-6'>${apartment.floor.floorGroup.name }</span>
										</div>
										<div class='row'>
											<h5 class='col-md-6'>Address:</h5>
											<span class='col-md-6'> <%-- ${apartment.addressName } ${apartment.wardName } --%>
											</span>
										</div>
										<div class='row'>
											<h5 class='col-md-6'>District:</h5>
											<span class='col-md-6'> <%-- ${apartment.district.name } --%>
											</span>
										</div>
										<div class='row'>
											<h5 class='col-md-6'>City:</h5>
											<span class='col-md-6'> <%-- ${apartment.city.name } --%>
											</span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</div>

	<!-- Other Rooms -->
	<section class="rooms mt50">
		<div class="container">
			<div class="row">
				<div class="col-sm-12">
					<h2 class="lined-heading">
						<span>Other rooms</span>
					</h2>
				</div>
				<!-- Room -->
				<c:forEach var="otherApartment" items="${listRandomApartment}"
					varStatus="i" begin="0" end="2">
					<div class="col-sm-4 ${otherApartment.apartmentType.code }">
						<div class="room-thumb">
							<img
								src="${pageContext.request.contextPath }/resources/${otherApartment.image[0].imagePath}"
								alt="room 1" class="img-responsive" />
							<div class="mask">
								<div class="main">
									<h5>${otherApartment.apartmentType.name }</h5>
									<div class="price">
										&euro; ${otherApartment.apartmentType.price }<span>Monthly</span>
									</div>
								</div>
								<div class="content">
									<p>
										<span>${otherApartment.name }</span> <span
											style="min-height: 56px">${otherApartment.shortDescription }
										</span>
									</p>
									<ul class="row list-unstyled">
										<c:forEach var="criteria"
											items="${otherApartment.apartmentType.criterias }" begin="0"
											end="5">
											<li class="col-xs-6"><i class="fa fa-check-circle"></i>
												${criteria.name }</li>
										</c:forEach>
									</ul>
									<a
										href="${pageContext.request.contextPath }/Apartment-Type/${otherApartment.apartmentType.name }-${otherApartment.apartmentType.id }/Apartment/${otherApartment.name }-${otherApartment.id }/apartment-detail.html"
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
	<div id="datepicker" data-date="2015" data-date-format="mm/dd/yyyy"></div>

	<script type="text/javascript">
		$(document).ready(function(e) {
			$('#checkIn').datepicker();

			$('#checkOut').datepicker();
		})
	</script>
</body>
</html>