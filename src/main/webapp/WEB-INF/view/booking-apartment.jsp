<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

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

	<c:choose>
		<c:when test="${not empty booking }">
			<section class='container-fluid' style="width: 900px; margin: 20px auto">
				<h1>${booking }</h1>
			</section>
		</c:when>

		<c:when test="${not empty bookingRequest }">
			<section class='container-fluid mt50'>
				<div class="container"></div>
				,
				<div class="container">
					<div class="stepwizard col-md-offset-3">
						<div class="stepwizard-row setup-panel">
							<div class="stepwizard-step">
								<a href="#step-1" type="button"
									class="btn btn-primary btn-circle">1</a>
								<p>Sign up</p>
							</div>
							<div class="stepwizard-step">
								<a href="#step-2" type="button"
									class="btn btn-default btn-circle" disabled="disabled">2</a>
								<p>Information</p>
							</div>
							<div class="stepwizard-step">
								<a href="#step-3" type="button"
									class="btn btn-default btn-circle" disabled="disabled">3</a>
								<p>Finished</p>
							</div>
						</div>
					</div>
					
					<form role="form"
						action="${pageContext.request.contextPath }/booking-apartment-create-account.html"
						method="post"> 
						<input type="hidden" name="apartmentId" value="${bookingRequest.apartmentId }" /> 
						 <input type="hidden" value='<fmt:formatDate value="${bookingRequest.checkIn }" pattern="MM/dd/yyyy" />' 
							name="checkIn" /> <input type="hidden"
							value='<fmt:formatDate value="${bookingRequest.checkOut }" pattern="MM/dd/yyyy" />' name="checkOut" />  <input
							type="hidden" value="${bookingRequest.numGuest }" name="numGuest" />
						<div class="row setup-content" id="step-1">
							<div class="col-xs-6 col-md-offset-3">
								<div class="col-md-12">
									<h3>Sign Up An Account</h3>
									<div class="form-group">
										<label class="control-label">Email: </label> <input
											maxlength="100" required="required" class="form-control"
											placeholder="Enter Your Email" type="email" name="email"
											value="${bookingRequest.email }" />
									</div>
									<div class="form-group">
										<label class="control-label">Password: </label> <input
											maxlength="100" required="required" class="form-control"
											placeholder="Password" type="password" name="password" />
									</div>
									<div class="form-group">
										<label class="control-label">Re-enter Password: </label> <input
											maxlength="100" required="required" class="form-control"
											placeholder="Password" type="password" name="reenterPassword" />
									</div>
									<div class="form-group">
										<label class="control-label" style="margin-right: 20px">Gender:
										</label>
										<div class="btn-group" data-toggle="buttons">
											<label class="btn btn-primary active"> <input
												type="radio" name="customer.profile.gender" id="inlineCheckbox1" value="0"
												autocomplete="off" checked /> Male
											</label> <label class="btn btn-primary"> <input type="radio"
												name="customer.profile.gender" id="inlineCheckbox2" value="1"
												autocomplete="off" /> Female
											</label>
										</div>
										<div class="form-group mt10">
											<label class="control-label">Phone Number:</label> <input
												maxlength="200" required="required" class="form-control"
												placeholder="Enter Your Phone Number" type="text" name="customer.profile.phone" />
										</div>
									</div>
									<button class="btn btn-primary nextBtn btn-md pull-right"
										type="button">Next</button>
								</div>
							</div>
						</div>
						<div class="row setup-content" id="step-2">
							<div class="col-xs-6 col-md-offset-3">
								<div class="col-md-12">
									<h3>Fill In Your Personal Information</h3>
									<div class="form-group">
										<label class="control-label">Identity Card:</label> <input
											maxlength="200" required="required" class="form-control"
											placeholder="Enter Identity Card" type="text" name="customer.profile.identityCard" />
									</div>
									<div class="form-group">
										<label class="control-label">Birthday: </label> <input
											maxlength="200" required="required" class="form-control date-picker"
											 placeholder="Birthday" type="text" name="customer.profile.birthday" />
									</div>
									<div class="form-group">
										<label class="control-label">First Name: </label> <input
											maxlength="200" required="required" class="form-control"
											placeholder="Enter First Name" type="text" name="customer.profile.firstName" />
									</div>
									<div class="form-group">
										<label class="control-label">Last Name: </label> <input
											maxlength="200" required="required" class="form-control"
											placeholder="Enter Last Name" type="text" name="customer.profile.lastName" />
									</div>
									

									<button class="btn btn-primary prevBtn btn-md pull-left"
										type="button">Previous</button>
									<button class="btn btn-primary nextBtn btn-md pull-right"
										type="button">Next</button>
								</div>
							</div>
						</div>
						<div class="row setup-content" id="step-3">
							<div class="col-xs-6 col-md-offset-3">
								<div class="col-md-12">
									<h3>Finished</h3>
									<p>Your booking almost finished, but please check your
										information again.</p>
									<button class="btn btn-primary prevBtn btn-md pull-left"
										type="button">Previous</button>
									<button class="btn btn-success btn-md pull-right" type="submit">Booking</button>
								</div>
							</div>
						</div>
					</form>

				</div>
			</section>
		</c:when>

		<c:otherwise>
			<section class='container-fluid'
				style="width: 900px; margin: 20px auto">
				<h1>Please choose an apartment first</h1>
			</section>
		</c:otherwise>
	</c:choose>



	<!-- Footer -->
	<c:import url="footer.jsp" />

	<!-- Go-top Button -->
	<div id="go-top">
		<i class="fa fa-angle-up fa-2x"></i>
	</div>

	<div id="datepicker" data-date="2015" data-date-format="mm/dd/yyyy"></div>

	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var navListItems = $('div.setup-panel div a'), allWells = $('.setup-content'), allNextBtn = $('.nextBtn'), allPrevBtn = $('.prevBtn');

							allWells.hide();

							navListItems
									.click(function(e) {
										e.preventDefault();
										var $target = $($(this).attr('href')), $item = $(this);

										if (!$item.hasClass('disabled')) {
											navListItems.removeClass(
													'btn-primary').addClass(
													'btn-default');
											$item.addClass('btn-primary');
											allWells.hide();
											$target.show();
											$target.find('input:eq(0)').focus();
										}
									});

							allPrevBtn
									.click(function() {
										var curStep = $(this).closest(
												".setup-content"), curStepBtn = curStep
												.attr("id"), prevStepWizard = $(
												'div.setup-panel div a[href="#'
														+ curStepBtn + '"]')
												.parent().prev().children("a");

										prevStepWizard.removeAttr('disabled')
												.trigger('click');
									});

							allNextBtn
									.click(function() {
										var curStep = $(this).closest(
												".setup-content"), curStepBtn = curStep
												.attr("id"), nextStepWizard = $(
												'div.setup-panel div a[href="#'
														+ curStepBtn + '"]')
												.parent().next().children("a"), curInputs = curStep
												.find("input[type='text'],input[type='url'],input[type='email'],input[type='password']"), isValid = true;

										$(".form-group").removeClass(
												"has-error");
										for (var i = 0; i < curInputs.length; i++) {
											if (!curInputs[i].validity.valid) {
												isValid = false;
												$(curInputs[i]).closest(
														".form-group")
														.addClass("has-error");
											}
										}

										if (isValid)
											nextStepWizard.removeAttr(
													'disabled')
													.trigger('click');
									});

							$('div.setup-panel div a.btn-primary').trigger(
									'click');

							$('.date-picker').datepicker();

						});
	</script>
</body>
</html>