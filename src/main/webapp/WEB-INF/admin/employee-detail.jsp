<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<c:set var="updateEmployeeDetailUrl" value="${pageContext.request.contextPath }/management/employee/employee-detail.html"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administrator panel</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>

<c:import url="import.jsp" />
</head>
<body class="skin-blue">
	<div class="wrapper">

		<!-- Main Header -->
		<c:import url="header.jsp" />

		<!-- Left side column. contains the logo and sidebar -->
		<c:import url="aside.jsp" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>Employee Detail</h1>
				<ol class="breadcrumb">
					<li><a href="${pageContext.request.contextPath }/management/index.html"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Employee</li>
				</ol>
			</section>

			<!-- Main content -->
			<section
				style='width: 98%; margin: 20px auto 0 auto; border: 1px; border-style: ridge; border-color: blue; min-height: 400px; border-radius: 10px'>
				<div class='tabs-x tabs-above'>
					<ul id="myTab-1" class="nav nav-tabs" role="tablist">
						<li class="active"><a href="#detail-infor" role="tab"
							data-toggle="tab">Detail Information</a></li>
						<li><a href="#update-infor" role="tab	" data-toggle="tab">Update
								Information</a></li>
						<li><a href="#uploadImage" role='tab' data-toggle='tab'>Upload
								Image </a></li>
					</ul>
					<div id="myTabContent-1" class="tab-content">
						<div class="tab-pane fade in active" id="detail-infor">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h3 class="panel-title">Detail Employee Information</h3>
								</div>
								<div class="panel-body">
									<div class='container-fluid'>
										<div class='row'>
											<div class='col-md-8'>
												<div class='row'>
													<h5 class='col-md-3'>Last Name:</h5>
													<span class='col-md-9'>${employee.profile.lastName }</span>
												</div>
												<div class='row'>
													<h5 class='col-md-3'>FirstName:</h5>
													<span class='col-md-9'>${employee.profile.firstName }</span>
												</div>
												<div class='row'>
													<h5 class='col-md-3'>Employee Code:</h5>
													<span class='col-md-9'>${employee.employeeCode }</span>
												</div>
												<div class='row'>
													<h5 class='col-md-3'>Position:</h5>
													<span class='col-md-9'></span>
												</div>
												<div class='row'>
													<h5 class='col-md-3'>Assigned Apartment:</h5>
													<span class='col-md-9'></span>
												</div>
												<div class='row'>
													<h5 class='col-md-3'>Hired Date:</h5>
													<span class='col-md-9'>${employee.hiredDate }</span>
												</div>

												<div class='row'>
													<h5 class='col-md-3'>Gender:</h5>
													<span class='col-md-9'>${employee.profile.gender }</span>
												</div>
												<div class='row'>
													<h5 class='col-md-3'>Birthday:</h5>
													<span class='col-md-9'>${employee.profile.birthday }</span>
												</div>
												<div class='row'>
													<h5 class='col-md-3'>Identity Card:</h5>
													<span class='col-md-9'>${employee.profile.identityCard }</span>
												</div>
												<div class='row'>
													<h5 class='col-md-3'>Phone Number:</h5>
													<span class='col-md-9'>${employee.profile.phone }</span>
												</div>
											</div>
											<div class='col-md-3'>

												<div class='row panel panel-primary'>
													<div class='panel-heading'>
														<div class='row panel-title'>
															<h4 class='col-md-12'>Personal Image:</h4>
														</div>
													</div>
													<div class='panel-body'>
														<div class='row'>
															<div id="links" class='col-md-12'>
																<a href="images/banana.jpg" title="Banana" data-gallery>
																	<img src="images/thumbnails/banana.jpg" width='220'
																	height='160'>
																</a>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="tab-pane fade update-detail-info" id="update-infor">
							<spring:form action='${updateEmployeeDetailUrl }' method="post" modelAttribute="employee">
								<div class='container-fluid'>
									<div class='row'>
										<label class='col-md-3 col-sm-4'>Last Name: </label> <span
											class='col-md-9 col-sm-8'><spring:input path="profile.lastName" cssClass="form-control"/>
											 </span>
									</div>
									<div class='row'>
										<label class='col-md-3 col-sm-4'>First Name: </label> <span
											class='col-md-9 col-sm-8'><spring:input path="profile.firstName" cssClass="form-control"/> </span>
									</div>
									<div class='row'>
										<label class='col-md-3 col-sm-4'>Employee Code: </label> <span
											class='col-md-9 col-sm-8'><spring:input path="employeeCode" cssClass="form-control"/> </span>
									</div>
									<div class='row'>
										<label class='col-md-3 col-sm-4'>Position: </label> <span
											class='col-md-9 col-sm-8'><spring:input path="" cssClass="form-control"/> </span>
									</div>
									<div class='row'>
										<label class='col-md-3 col-sm-4'>Hired Date: </label> <span
											class='col-md-9 col-sm-8'><spring:input path="hiredDate" cssClass="form-control"/> </span>
									</div>
									<div class='row'>
										<label class='col-md-3 col-sm-4'>Gender: </label> <span
											class='col-md-9 col-sm-8'><spring:input path="profile.gender" cssClass="form-control"/> </span>
									</div>
									<div class='row'>
										<label class='col-md-3 col-sm-4'>Identity Card: </label> <span
											class='col-md-9 col-sm-8'><spring:input path="profile.identityCard" cssClass="form-control"/> </span>
									</div>
									<div class='row'>
										<label class='col-md-3 col-sm-4'>Phone Number: </label> <span
											class='col-md-9 col-sm-8'><spring:input path="profile.phone" cssClass="form-control"/> </span>
									</div>
									<div class='row mt20'>
										<button
											class='btn btn-primary col-md-offset-6 col-sm-offset-6 col-xs-offset-4 col-md-1 col-sm-2 col-xs-3'
											type="submit">Save</button>
									</div>

								</div>
							</spring:form>
						</div>
						<div class="tab-pane fade" id="uploadImage">
							<form action='#' method="post" enctype="multipart/form-data">
								<div class='container-fluid table-responsive'>
									<div class='row'>
										<div class='col-md-12 col-sm-12 col-xs-12'>
											<input id="upload-image" type="file" multiple=true>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</section>

			<div id="blueimp-gallery" class="blueimp-gallery">
				<!-- The container for the modal slides -->
				<div class="slides"></div>
				<!-- Controls for the borderless lightbox -->
				<h3 class="title"></h3>
				<a class="prev">‹</a> <a class="next">›</a> <a class="close">×</a> <a
					class="play-pause"></a>
				<ol class="indicator"></ol>
				<!-- The modal dialog, which will be used to wrap the lightbox content -->
				<div class="modal fade">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" aria-hidden="true">&times;</button>
								<h4 class="modal-title"></h4>
							</div>
							<div class="modal-body next"></div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default pull-left prev">
									<i class="glyphicon glyphicon-chevron-left"></i> Previous
								</button>
								<button type="button" class="btn btn-primary next">
									Next <i class="glyphicon glyphicon-chevron-right"></i>
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<footer class="main-footer">
			<div class="pull-right hidden-xs">
				<b>Version</b> 2.0
			</div>
			<strong>Copyright &copy; 2014-2015 <a
				href="http://almsaeedstudio.com">Almsaeed Studio</a>.
			</strong> All rights reserved.
		</footer>

	</div>
	<!-- ./wrapper -->


	<script type="text/javascript">
		$(document)
				.ready(
						function(e) {

							$("#upload-image").fileinput({
								maxFileCount : 10,
								allowedFileTypes : [ "image" ],

							});
						});
	</script>
</body>
</html>