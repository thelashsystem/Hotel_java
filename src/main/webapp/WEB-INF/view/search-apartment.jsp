<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
			style="background-image: url(./images/parallax/parallax-01.jpg);">
			<div class="color-overlay">
				<!-- Page title -->
				<div class="container">
					<div class="row">
						<div class="col-sm-12">
							<ol class="breadcrumb">
								<li><a
									href="${pageContext.request.contextPath }/home/index.html">Home</a></li>
								<li class="active">Search Apartment</li>
							</ol>
							<h1>Search Apartment</h1>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section class="search-apartment">
		<div class='container'>
			<div class='row'>
				<div class='col-md-12' style='padding: 20px 40px 0 40px'>
					<form
						action="${pageContext.request.contextPath }/search-apartment.html"
						method="post">
						<div class='row'>
							<div class='col-md-2'>
								<h5>
									<label for="cityId">Cities:</label>
								</h5>
								<select class='form-control' name="cityId" id="cityId">
									<option value="0">-- All Cities --</option>
									<c:forEach var="city" items="${listCity }">
										<option value="${city.id }">${city.name }</option>
									</c:forEach>
								</select>
							</div>

							<div class='col-md-3'>
								<h5>
									<label for='buildingId'>Buildings:</label>
								</h5>
								<select class='form-control' name="buildingId" id="buildingId">
									<option value="0">-- All Buildings --</option>
									<c:forEach var="building" items="${listBuilding }">
										<option value="${building.id }">${building.name }</option>
									</c:forEach>
								</select>
							</div>
							<div class='col-md-3'>
								<h5>
									<label for='apartmentTypeId'>Apartment Types:</label>
								</h5>
								<select class='form-control' name="apartmentTypeId"
									id="apartmentTypeId">
									<option value="0">-- All Types --</option>
									<c:forEach var="apartmentType" items="${listApartmentType }">
										<option value="${apartmentType.id }">${apartmentType.name }</option>
									</c:forEach>
								</select>
							</div>
							<div class='col-md-2'>
								<h5>
									<label for='numGuest'></label>Guests:
								</h5>
								<select class='form-control' name="numGuest" id="numGuest">
									<option value='1'>1 person</option>
									<option value='2'>2 people</option>
									<option value='3'>3 people</option>
									<option value='4'>4 people</option>
									<option value='5'>5 people</option>
									<option value='6'>6 people</option>
								</select>
							</div>
						</div>
						<div class='row'>
							<div class='col-md-2'>
								<h5>
									<label for='priceSort'>Price Sort:</label>
								</h5>
								<select class='form-control' name="priceSort" id="priceSort">
									<option value="0">Price low to high</option>
									<option value="1">Price high to low</option>
								</select>
							</div>
							<div class='col-md-2'>
								<h5>
									<label for='priceSort'>Price Range:</label>
								</h5>
								<select class='form-control' name="priceRange" id='priceSort'>
									<option value='100'>From $100</option>
									<option value='200'>From $200</option>
									<option value='300'>From $300</option>
									<option value='400'>From $400</option>
									<option value='500'>From $500</option>
									<option value='600'>From $600</option>
									<option value='700'>From $700</option>
									<option value='800'>From $800</option>
									<option value='900'>From $900</option>
									<option value='1000'>From $1000</option>
								</select>
							</div>
							<div class='col-md-2'>
								<div class="form-group">
									<h5 class="control-label">
										<label for='checkIn'>Check-in Date:</label>
									</h5>
									<div class="input-group">
										<input name="checkIn" type="text" value=""
											class='form-control' placeholder="Check-in"
											aria-describedby="check-in-date" id="checkIn" required /> <span
											class="input-group-addon" id="check-in-date"><span
											class="fa fa-calendar"></span></span>
									</div>
								</div>
							</div>
							<div class='col-md-2'>
								<div class="form-group">
									<h5 class="control-label">
										<label for='checkOut'>Check-out Date:</label>
									</h5>
									<div class="input-group">
										<input name="checkOut" type="text" value=""
											class='form-control' placeholder="Check-in"
											aria-describedby="check-out-date" id="checkOut" required /> <span
											class="input-group-addon" id="check-out-date"><span
											class="fa fa-calendar"></span></span>
									</div>
								</div>
							</div>
							<div class='col-md-1'>
								<h5>&nbsp;</h5>
								<button type="submit" class='form-control'>
									<i class='fa fa-search'></i>
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class='row'>
				<hr />
			</div>
			<div class='row' style='margin-top: -20px;'>
				<div class='col-md-12'>
					<div class='row'>
						<div class='col-md-12' style='text-align: center'>
							<h1>Available Apartments (${fn:length(listApartment.content) }
								results)</h1>
							<h3>${url }</h3>
						</div>
					</div>
					<div class='row'>
						<c:forEach var="apartment" items="${listApartment.content }"
							varStatus="i">
							<div class="col-sm-4 mt20">
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
												<span>${apartment.name }</span> <span
													style="min-height: 56px">${apartment.description } </span>
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