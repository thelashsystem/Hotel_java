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
	
	
	<!-- Footer -->
	<c:import url="footer.jsp" />

	<!-- Go-top Button -->
	<div id="go-top">
		<i class="fa fa-angle-up fa-2x"></i>
	</div>
</body>
</html>