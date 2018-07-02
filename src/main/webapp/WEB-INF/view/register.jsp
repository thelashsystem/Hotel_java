<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Service-detail</title>
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

	<section>
		<form action="${pageContext.request.contextPath }/register.html" method="post">
			<div class="container-fluid" style="width: 900px; margin: 30px auto">
				<div class="row">
					<div class="col-xs-6 col-md-6">
						<input class="form-control" name="firstName"
							placeholder="First Name" type="text" required autofocus />
					</div>
					<div class="col-xs-6 col-md-6">
						<input class="form-control" name="lastName"
							placeholder="Last Name" type="text" required />
					</div>
				</div>
				<input class="form-control" name="email" placeholder="Your Email"
					type="email" required /> <input class="form-control"
					name="password" placeholder="New Password" type="password" required />
				<input class="form-control" name="reenterpassword"
					placeholder="Re-enter Password" type="password" required /> <label
					for="birthday"> Birth Date</label>
				<div class="row">
					<div class="col-md-6 col-xs-6">
						<input class="form-control datepicker" type="date" id="birthday"
							name="birthdate" required />
					</div>
					<div class="col-md-6 col-xs-6 btn-group" data-toggle="buttons">
						<label
							class="col-xs-12 col-sm-6 col-md-4 col-lg-4 btn btn-primary active">
							<input type="radio" name="gender" id="inlineCheckbox1" value="0"
							autocomplete="off" checked /> Male
						</label> <label
							class="col-xs-12 col-sm-6 col-md-5 col-lg-5 btn btn-primary">
							<input type="radio" name="gender" id="inlineCheckbox2" value="1"
							autocomplete="off" /> Female
						</label>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 col-xs-12">
						<label><input type="checkbox" name="terms" required /> I
							agree with the <a href="${pageContext.request.contextPath }/#">Terms
								and Conditions</a>.</label>
					</div>
				</div>
				<div class='row'>
					<div class='col-md-offset-5 col-md-2 mt20'>
						<button class='btn btn-primary form-control' type="submit">Sign
							up</button>
					</div>
				</div>
			</div>
		</form>
	</section>

	<!-- Footer -->
	<c:import url="footer.jsp" />

	<!-- Go-top Button -->
	<div id="go-top">
		<i class="fa fa-angle-up fa-2x"></i>
	</div>
</body>
</html>