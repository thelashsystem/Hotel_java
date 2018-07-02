<section class="modal fade" id="signup-form" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="model-content row">
			<div class="col-xs-12 col-sm-12 col-md-12 well well-sm">
				<div class="modal-header">
					<span class="modal-title" id="myModalLabel"
						style="font-size: 16px;"><a
						href="${pageContext.request.contextPath }/#"><i
							class="glyphicon glyphicon-globe"></i></a> Sign up! </span>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="${pageContext.request.contextPath }/register.html"
					method="post" class="form" role="form">
					<div class="modal-body">
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
							name="password" placeholder="New Password" type="password"
							required /> <input class="form-control" name="reenterpassword"
							placeholder="Re-enter Password" type="password" required /> <label
							for="birthday"> Birth Date</label>
						<div class="row">
							<div class="col-md-6 col-xs-6">
								<input class="form-control datepicker" type="date" id="birthday"
									name="birthdate" required />
							</div>
							<div class="col-md-6 col-xs-6 btn-group" data-toggle="buttons">
								<label class="col-xs-12 col-sm-6 col-md-4 col-lg-4 btn btn-primary active"> <input
									type="radio" name="gender" id="inlineCheckbox1" value="0"  autocomplete="off"
									checked /> Male
								</label> <label class="col-xs-12 col-sm-6 col-md-5 col-lg-5 btn btn-primary"> <input
									type="radio" name="gender" id="inlineCheckbox2" value="1" autocomplete="off" />
									Female
								</label>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12 col-xs-12">
								<label><input type="checkbox" name="terms" required />
									I agree with the <a
									href="${pageContext.request.contextPath }/#">Terms and
										Conditions</a>.</label>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn btn-primary btn-block" type="submit">
							Sign up</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>