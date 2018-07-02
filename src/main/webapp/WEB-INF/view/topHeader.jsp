<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="top-header">
	<div class="container">
		<div class="row">
			<div class="col-xs-6">
				<div class="th-text pull-left">
					<div class="th-item">
						<a href="index.html#"><i class="fa fa-phone"></i>
							${setting.hotLine }</a>
					</div>
					<div class="th-item">
						<a href="index.html#"><i class="fa fa-envelope"></i>
							${setting.officalEmail } </a>
					</div>
					<div class="th-item">
						<div class="social-icons">
							<a href="${setting.facebookFanPageLink }"><i
								class="fa fa-facebook"></i></a> <a
								href="${setting.twitterFanPageLink }"><i
								class="fa fa-twitter"></i></a> <a href="${setting.youTubeLink }"><i
								class="fa fa-youtube-play"></i></a>
						</div>
					</div>


				</div>
			</div>
			<div class="col-xs-6">
				<div class="th-text pull-right">
					<c:choose>
						<c:when test="${empty user }">
							<div class="th-item">
								<a href="${pageContext.request.contextPath }/#" id="login-btn"
									class="btn btn-primary btn-xs dropdown-toggle"
									data-toggle="dropdown">Login <span
									class="glyphicon glyphicon-chevron-down"></span></a>
								<ul id="login-form" class="dropdown-menu"
									style="padding: 15px; min-width: 250px;">
									<li>
										<div class="row">
											<div class="col-md-12">
												<form class="form" role="form" method="post"
													action="${pageContext.request.contextPath }/login.html"
													accept-charset="UTF-8" id="login-nav">
													<div class="form-group">
														<label class="sr-only" for="exampleInputEmail2">Email
															address</label> <input type="email" class="form-control"
															id="exampleInputEmail2" placeholder="Email address"
															name="email" required>
													</div>
													<div class="form-group">
														<label class="sr-only" for="exampleInputPassword2">Password</label>
														<input type="password" class="form-control"
															name="password" id="exampleInputPassword2"
															placeholder="Password" required>
													</div>
													<div class="checkbox">
														<label> <input type="checkbox"> Remember
															me
														</label>
													</div>
													<div class="form-group">
														<button type="submit" class="btn btn-success btn-block">Sign
															in</button>
													</div>
												</form>
											</div>
											<div class="col-md-8">
												<a href="${pageContext.request.contextPath }/#"
													id="forgetPass">Forget password?</a>
											</div>
										</div>
									</li>
									<li class="divider"></li>
									<li><button class="btn btn-primary btn-block"
											type="button" id="sign-in-google">
											Sign In with Google &nbsp; <i class="fa fa-google-plus"
												style="color: black; font-size: 18px;"> </i>
										</button>
										<button class="btn btn-primary btn-block" type="button"
											id="sign-in-twitter">
											Sign In with Twitter &nbsp; <i class="fa fa-twitter"
												style="color: black; font-size: 18px;"> </i>
										</button>
										<button class="btn btn-primary btn-block" type="button"
											id="sign-in-twitter">
											Sign In with Facebook &nbsp; <i class="fa fa-facebook"
												style="color: black; font-size: 18px;"></i>
										</button></li>
								</ul>
								<a href="${pageContext.request.contextPath }/#" id="signup-btn"
									class="btn btn-primary btn-xs" data-toggle="modal"
									data-target="#signup-form">Sign up</a>
							</div>
						</c:when>
						<c:otherwise>
							<div class="th-item">
								<div class="dropdown">
									<a href="index.html#" data-toggle="dropdown"
										class="dropdown-toggle js-activated btn btn-primary btn-xs">${user.email }
										<b class="caret"></b>
									</a>
									<ul class="dropdown-menu" style="z-index: 9999;">
										<li><a
											href="${pageContext.request.contextPath }/account/account-info.html?id=${user.id}"
											style="font-size: 15px !important;">Update Information</a></li>
										<li><a
											href="${pageContext.request.contextPath }/message.html"
											style="font-size: 15px !important;">Message</a></li>
										<li><a
											href="${pageContext.request.contextPath }/history-booking.html"
											style="font-size: 15px !important;">History Booking</a></li>
										<li><a
											href="${pageContext.request.contextPath }/logout.html"
											style="font-size: 15px !important;">Logout</a></li>
									</ul>
								</div>
							</div>
						</c:otherwise>
					</c:choose>

					<div class="th-item">
						<div class="btn-group">
							<button
								class="btn btn-default btn-xs dropdown-toggle js-activated"
								type="button" data-toggle="dropdown">
								${language } <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a
									href="${pageContext.request.contextPath }/index.html?lang=english"><span
										class="flag flag-us"></span> &nbsp; ENGLISH </a></li>
								<li><a
									href="${pageContext.request.contextPath }/index.html?lang=vietnamese"><span
										class="flag flag-vn"></span> &nbsp; VIETNAMESE </a></li>
							</ul>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>