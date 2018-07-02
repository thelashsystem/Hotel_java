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

	<section class="login-page mt50">
		<div class="login-box containter-fluid"
			style="width: 600px; margin: 0 auto">
			<div class="login-logo"></div>
			<!-- /.login-logo -->
			<div class="login-box-body">
				<p class="login-box-msg">
					<a href="${pageContext.request.contextPath }/index.html">Homepage</a>
				</p>
				<%-- <form action="<c:url value='j_spring_security_check' />"
					method="post">
					<div class="form-group has-feedback">
						<input type="text" class="form-control" placeholder="Email"
							name='j_username' /> <span
							class="glyphicon glyphicon-envelope form-control-feedback"></span>
					</div>
					<div class="form-group has-feedback">
						<input type="password" class="form-control" placeholder="Password"
							name='j_password' /> <span
							class="glyphicon glyphicon-lock form-control-feedback"></span>
					</div>
					<div class="row">
						<div class="col-xs-8">
							<div class="checkbox icheck">
								<label> <input type="checkbox"> Remember Me
								</label>
							</div>
						</div>
						<!-- /.col -->
						<div class="col-xs-4">
							<button type="submit" class="btn btn-primary btn-block btn-flat">Sign
								In</button>
						</div>
						<!-- /.col -->
					</div>
				</form> --%>
				<form action="${pageContext.request.contextPath }/management/login.html"
					method="post">
					<div class="form-group has-feedback">
						<input type="text" class="form-control" placeholder="Email"
							name='email' /> <span
							class="glyphicon glyphicon-envelope form-control-feedback"></span>
					</div>
					<div class="form-group has-feedback">
						<input type="password" class="form-control" placeholder="Password"
							name='password' /> <span
							class="glyphicon glyphicon-lock form-control-feedback"></span>
					</div>
					<div class="row">
						<div class="col-xs-8">
							<div class="checkbox icheck">
								<label> <input type="checkbox" value="1"
									name="rememberMe"> Remember Me
								</label>
							</div>
						</div>
						<!-- /.col -->
						<div class="col-xs-4">
							<button type="submit" class="btn btn-primary btn-block btn-flat">Sign
								In</button>
						</div>
						<!-- /.col -->
					</div>
				</form>
				<div class="social-auth-links text-center">
					<p>- OR -</p>
					<a href="#"
						class="btn btn-primary btn-block btn-social btn-facebook btn-flat"><i
						class="fa fa-facebook"></i> Sign in using Facebook</a> <a href="#"
						class="btn btn-primary btn-block btn-social btn-google-plus btn-flat"><i
						class="fa fa-google-plus"></i> Sign in using Google+</a>
				</div>
				<!-- /.social-auth-links -->

				<div style="margin-top: 20px;">
					<a href="#">I forgot my password</a><br> <a
						href="register.html" class="text-center">Register a new
						membership</a>
				</div>
			</div>
			<!-- /.login-box-body -->
		</div>
		<!-- /.login-box -->
	</section>


	<script type="text/javascript">
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
	</script>
</body>
</html>