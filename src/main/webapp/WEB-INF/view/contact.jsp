<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="random" class="java.util.Random" />


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
			style="background-image: url(${pageContext.request.contextPath}/resources/images/parallax/parallax-01.jpg);">
			<div class="color-overlay">
				<!-- Page title -->
				<div class="container">
					<div class="row">
						<div class="col-sm-12">
							<ol class="breadcrumb">
								<li><a
									href="${pageContext.request.contextPath }/index.html">Home</a></li>
								<li class="active">Contact</li>
							</ol>
							<h1>Contact</h1>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<div class="container">
		<div class="row">

			<!-- Contact details -->
			<section class="contact-details">
				<div class="col-md-5">
					<h2 class="lined-heading  mt50">
						<span>Address</span>
					</h2>

					<!-- GMap -->
					<div class="container-fluid">
						<div id="map">
							<p>This will be replaced with the Google Map.</p>
						</div>
					</div>
					<!-- Panel -->
					<div class='container-fluid'>
						<div class="panel panel-default text-center mt50 ">
							<div class="panel-heading">
								<div class="panel-title">
									<i class="fa fa-star"></i> <strong>Starhotel</strong>
								</div>
							</div>
							<div class="panel-body">
								<c:forEach var="building" items="${listBuilding }">
									<address>
										<strong>Name: ${building.name }</strong> <br />
										${building.address.addressName }<br> Ward
										${building.address.wardName }, District
										${building.address.district.name }<br>
										${building.address.district.city.name } city, Viet Nam <br />
										<abbr title="Phone">P:</abbr> <a
											href="${pageContext.request.contextPath }/contact.html#">${building.phone }</a><br>
										<abbr title="Email">E:</abbr> <a
											href="${pageContext.request.contextPath }/contact.html#">${building.officalEmail }</a><br>
									</address>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</section>

			<!-- Contact form -->
			<section id="contact-form" class="mt50">
				<div class="col-md-7">
					<h2 class="lined-heading">
						<span>Send a message</span>
					</h2>
					<p>Pellentesque facilisis justo sed enim facilisis luctus. Duis
						pretium nibh at lectus tempus, vel lacinia quam adipiscing. Nullam
						luctus congue mattis.</p>
					<form class="clearfix mt50" role="form" method="post"
						action="${pageContext.request.contextPath }/sendMessage"
						name="contactform" id="contactform">
						<!-- Error message -->
						<div id="message"></div>
						<div class="row">
							<c:choose>
								<c:when test="${empty user }">
									<div class="col-md-6">
										<div class="form-group">
											<label for="name" accesskey="U"><span
												class="required">*</span> Your Name</label> <input name="name"
												type="text" id="name" class="form-control" value="" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="email" accesskey="E"><span
												class="required">*</span> E-mail</label> <input name="email"
												type="text" id="email" value="" class="form-control" />
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="col-md-6">
										<div class="">
											<span>Your Name:</span> <br /> <span>${user.customer.profile.lastName }
												${user.customer.profile.firstName } </span>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<span>E-mail:</span> <br /> <span> ${user.email } </span>
										</div>
									</div>

								</c:otherwise>
							</c:choose>

						</div>
						<div class="form-group">
							<label for="subject" accesskey="S">Subject</label> <select
								name="subject" id="subject" class="form-control">
								<option value="Booking">Booking</option>
								<option value="Apartment">Apartment</option>
								<option value="Other">Other</option>
							</select>
						</div>
						<div class="form-group">
							<label for="comments" accesskey="C"><span
								class="required">*</span> Your message</label>
							<textarea name="comments" rows="9" id="comments"
								class="form-control"></textarea>
						</div>
						<div class="form-group">
							<label><span class="required">*</span> Spam Filter:
								&nbsp;&nbsp;&nbsp;1 + 1 =</label> <input name="verify" type="text"
								id="verify" value="" class="form-control"
								placeholder="Please enter the outcome" />
						</div>
						<div style='text-align: center'>
							<button type="submit" class="btn  btn-lg btn-primary">Send
								message</button>
						</div>
					</form>
				</div>
			</section>
		</div>
	</div>

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