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
	
	<section style="width: 860px; margin: 30px auto 10px auto; min-height: 20px">
		<p>${msg }</p>
	</section>
	
	<section class='container-fliud' style="width: 860px; margin: 10px auto 40px auto">
		<form action="${pageContext.request.contextPath }/active-account.html" method="get">
			<div class='row'>
				<div class='col-md-2'><label>Email: </label></div>
				<div class='col-md-5'><input type="email" name="email" class='form-control' value="${email }"/></div>
			</div>
			<div class='row'>
				<div class='col-md-2'><label>Active Cdoe: </label></div>
				<div class='col-md-5'><input type="text" name="activeCode" class='form-control' /></div>
			</div>
			<div class='row mt20' >
				<div class='col-md-offset-2 col-md-2'><button type="submit" class='btn btn-primary form-control'>Active</button></div>
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