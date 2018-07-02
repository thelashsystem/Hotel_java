<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>

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


	<section class='container-fluid'
		style="width: 900px; margin: 20px auto">
		<spring:form action="${pageContext.request.contextPath }/account/update-account.html" method="post" modelAttribute="customerAccount">
			<spring:hidden path="id" />
			<div class='row'>
				<div class='col-md-2'>
					<label>Last Name: </label>
				</div>
				<div class='col-md-6'>
					<spring:input path="customer.profile.lastName" cssClass="form-control" />
				</div>
			</div>
			<div class='row'>
				<div class='col-md-2'>
					<label>First Name: </label>
				</div>
				<div class='col-md-6'>
					<spring:input path="customer.profile.firstName" cssClass="form-control" />
				</div>
			</div>
			<div class='row'>
				<div class='col-md-2'>
					<label>Gender: </label>
				</div>
				<div class='col-md-6'>
					<spring:input path="customer.profile.gender" cssClass="form-control" />
				</div>
			</div>
			<%-- <div class='row'>
				<div class='col-md-2'>
					<label>Birthday: </label>
				</div>
				<div class='col-md-6'>
					<spring:input path="customer.profile.birthday" cssClass="form-control" />
				</div>
			</div> --%>
			<div class='row'>
				<div class='col-md-2'>
					<label>Email: </label>
				</div>
				<div class='col-md-6'>
					<spring:input path="email" cssClass="form-control" />
				</div>
			</div>
			<div class='row'>
				<div class='col-md-2'>
					<label>Identity Card: </label>
				</div>
				<div class='col-md-6'>
					<spring:input path="customer.profile.identityCard" cssClass="form-control" />
				</div>
			</div>
			<div class='row'>
				<div class='col-md-2'>
					<label>Phone Number: </label>
				</div>
				<div class='col-md-6'>
					<spring:input path="customer.profile.phone" cssClass="form-control" />
				</div>
			</div>
			<div class='row'>
				<div class='col-md-2'>
					<label>Avatar: </label>
				</div>
				<div class='col-md-6'>
					<spring:input path="avatar" cssClass="form-control" />
				</div>
			</div>
			<div class='row'>
				<div class='col-md-offset-3 col-md-2 mt20'>
					<button class='btn btn-primary form-control' type="submit">Save</button>
				</div>
			</div>
		</spring:form>
	</section>


	<!-- Footer -->
	<c:import url="footer.jsp" />

	<!-- Go-top Button -->
	<div id="go-top">
		<i class="fa fa-angle-up fa-2x"></i>
	</div>
</body>
</html>