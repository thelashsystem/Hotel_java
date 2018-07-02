<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>

<c:set var="getCurrentCustomerUrl" value="${pageContext.request.contextPath }/management/apartment/getCurrentCustomer" />
<c:set var="getRecentBillingUrl" value="${pageContext.request.contextPath }/management/apartment/getRecentBilling" />
<c:set var="updateApartmentDetailurl" value="${pageContext.request.contextPath }/management/apartment/apartment-detail.html" />

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
				<h1>Detail Apartment</h1>
				<ol class="breadcrumb">
					<li><a
						href="${pageContext.request.contextPath }/management/index.html"><i
							class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Apartment</li>
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
									<h3 class="panel-title">Detail Apartment Information</h3>
								</div>
								<div class="panel-body">
									<div class='container-fluid'>
										<div class='row'>
											<h5 class='col-md-2'>Apartment Name:</h5>
											<span class='col-md-6'>${apartment.name }</span>
										</div>
										<div class='row'>
											<h5 class='col-md-2'>Apartment Type:</h5>
											<span class='col-md-6'>${apartment.apartmentType.name }</span>
										</div>
										<div class='row'>
											<h5 class='col-md-2'>Building:</h5>
											<span class='col-md-6'>${apartment.floor.building.name }</span>
										</div>
										<div class='row'>
											<h5 class='col-md-2'>Floor:</h5>
											<span class='col-md-6'>${apartment.floor.floorGroup.name }</span>
										</div>
										<div class='row'>
											<h5 class='col-md-2'>Apartment Size:</h5>
											<span class='col-md-6'>${apartment.apartmentSize }</span>
										</div>
										<div class='row'>
											<h5 class='col-md-2'>Number of Bedrooms:</h5>
											<span class='col-md-6'>${apartment.numberBedroom }</span>
										</div>
										<div class='row'>
											<h5 class='col-md-2'>Number of Bathrooms:</h5>
											<span class='col-md-6'>${apartment.numberBathroom }</span>
										</div>
										<div class='row'>
											<h5 class='col-md-2'>Number of rooms:</h5>
											<span class='col-md-6'>${apartment.numberRoom }</span>
										</div>
										<div class='row'>
											<h5 class='col-md-2'>Status:</h5>
											<span class='col-md-6'>${apartment.status }</span>
										</div>
										<div class='row'>
											<h5 class='col-md-2'>Max People:</h5>
											<span class='col-md-6'>${apartment.apartmentType.maxNumGuest }</span>
										</div>
										<div class='row mt20'>
											<div class='box box-solid box-primary'>
												<div class='box-header'>
													<h4 class='box-title col-md-12'>Images:</h4>
													<div class='box-tools pull-right'>
														<button class='btn btn-primary btn-sm'
															data-widget='collapse'>
															<i class='fa fa-minus'></i>
														</button>
													</div>
												</div>
												<div class='box-body'>
													<div class='row'>
														<div id="links" class='col-md-12'>
															<c:forEach var="image" items="${apartment.image }">
																<a
																	href="${pageContext.request.contextPath }/resources/${image.imagePath }"
																	title="${image.name }" data-gallery> <img
																	src="${pageContext.request.contextPath }/resources/${image.imagePath }"
																	alt="${image.name }" width="180" height="120">
																</a>
															</c:forEach>
														</div>
													</div>
												</div>
											</div>

										</div>
									</div>
								</div>
							</div>


							<div class="box box-solid box-primary">
								<div class="box-header">
									<h3 class="box-title">List of current customer</h3>
									<div class='box-tools pull-right'>
										<button class='btn btn-primary btn-sm' data-widget='collapse'>
											<i class='fa fa-minus'></i>
										</button>
									</div>
								</div>
								<div class="box-body">
									<div class='container-fluid table-responsive'>
										<table id="table1">
											<thead>
												<tr>
													<th>Options</th>
													<th>Full Name</th>
													<th>Gender</th>
													<th>Phone Number</th>
													<th>Address</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>

							</div>

							<div class="box box-solid box-primary">
								<div class="box-header">
									<h3 class="box-title">List of recent billing</h3>
									<div class='box-tools pull-right'>
										<button class='btn btn-primary btn-sm' data-widget='collapse'>
											<i class='fa fa-minus'></i>
										</button>
									</div>
								</div>
								<div class="box-body">
									<div class='container-fluid table-responsive'>
										<table id="table2">
											<thead>
												<tr>
													<th>Options</th>
													<th>Date</th>
													<th>Total Price</th>
													<th>Status</th>
													<th>Customer Name</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
													<td></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>

							</div>
						</div>
						<div class="tab-pane fade update-detail-info" id="update-infor">
							<spring:form action='${updateApartmentDetailurl }' method="post" modelAttribute="apartment">
								<spring:hidden path="id" />
								<div class='container-fluid'>
									<div class='row'>
										<label class='col-md-3 col-sm-4'>Apartment Name: </label> <span
											class='col-md-9 col-sm-8'> <spring:input path="name"
												cssClass="form-control" /> <spring:errors path="name" />
										</span>
									</div>
									<div class='row'>
										<label class='col-md-3 col-sm-4'>Apartment Type: </label> <span
											class='col-md-9 col-sm-8'> <spring:select
												path="apartmentType.id" cssClass="form-control">
												<c:forEach var="apartmentType" items="${listApartmentType }">
													<spring:option value="${apartmentType.id }">${apartmentType.name }</spring:option>
												</c:forEach>
											</spring:select>
										</span>
									</div>
									<div class='row'>
										<label class='col-md-3 col-sm-4'>Building: </label> <span
											class='col-md-9 col-sm-8'><spring:select
												path="floor.building.id" cssClass="form-control">
												<c:forEach var="building" items="${listBuilding }">
													<spring:option value="${building.id }">${building.name }</spring:option>
												</c:forEach>
												</spring:select> </span>
									</div>
									<div class='row'>
										<label class='col-md-3 col-sm-4'>Floor: </label> <span
											class='col-md-9 col-sm-8'><spring:select path="floor.id" cssClass="form-control">
												<c:forEach var="floor" items="${listFloor }">
													<spring:option value="${floor.id }">${floor.floorGroup.name } - ${floor.building.name }</spring:option>
												</c:forEach>
											</spring:select>
										</span>
									</div>
									<div class='row'>
										<label class='col-md-3 col-sm-4'>Apartment Size: </label> <span
											class='col-md-2 col-sm-2'><spring:input
												path="apartmentSize" cssClass="form-control" /> <spring:errors
												path="" /></span>
									</div>
									<div class='row'>
										<label class='col-md-3 col-sm-4'>Number of Bathrooms:
										</label> <span class='col-md-2 col-sm-2'><spring:input
												path="numberBathroom" cssClass="form-control" />
											<spring:errors path="" /> </span>
									</div>
									<div class='row'>
										<label class='col-md-3 col-sm-4'>Number of Bedrooms: </label>
										<span class='col-md-2 col-sm-2'><spring:input
												path="numberBedroom" cssClass="form-control" /> <spring:errors
												path="" /></span>
									</div>
									<div class='row'>
										<label class='col-md-3 col-sm-4'>Number of Rooms: </label> <span
											class='col-md-2 col-sm-2'><spring:input
												path="numberRoom" cssClass="form-control" />
											<spring:errors path="" /></span>
									</div>
									<div class='row'>
										<label class='col-md-3 col-sm-4'>Status: </label> <span
											class='col-md-9 col-sm-8'><select>
												<option>Status</option>
										</select> </span>
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
							var table1 = $('#table1')
							.DataTable(
									{
										'dom' : '<"clear"><"row"<"col-md-3 col-sm-3 col-xs-12"l>'
												+ '<"col-md-6 col-sm-6 col-xs-12"fr><"col-md-3 col-sm-3 col-xs-12"RC>>tip',
										"processing" : false,
										"serverSide" : false,
										"autoWidth" : true,
										"ajax" : {
											"url" : "${getCurrentCustomerUrl}",
											"data" :  {
												"buildingId" : "${building.id}"}
										},
										"colVis" : {
											showAll : "Show all",
											showNone : "Show none"
										},
										"deferRender" : true,
										"createdRow" : function(row,
												data, index) {
										},
										"lengthMenu" : [
												[ 10, 25, 50, -1 ],
												[ 10, 25, 50, "All" ] ],
										"paging" : true,
										"ordering" : true,
										"filter" : true,
										"lengthChange" : true,
										"sort" : true,
										"info" : true,
										"order" : [ [ 1, "asc" ] ],
										columnDefs : [ {
											"searchable" : false,
											"orderable" : false,
											"targets" : 0,
										} ],

										"pagingType" : "full_numbers",
										/* "scrollY" : "330px",
										"scrollCollapse" : true,
										"scrollX" : true, */
										"language" : {
											"decimal" : ",",
											"thousands" : "."
										},
										"columns" : [
												{
													"data" : null,
													"mRender" : function(
															data, type,
															full) {
														return "<a href='#update_building' class='mr10 alert_update' data-toggle='modal' data-target='#modalUpdate'>"
																+ "<span class='fa-1x2 fa fa-pencil-square-o'></span></a>"
																+ "<a href='#view_detail' class='mr10 view_detail'><span class='fa-1x2 fa fa-th'></span></a>"
																+ "<a href='#delete_building' class='alert_delete' ><span class='fa-1x2 fa fa-trash-o'></span></a>";
													}
												},
												{
													"data" : "fullName"
												},
												{
													"data" : "gender"
												},
												{
													"data" : "phoneNumber"
												},
												{
													"data" : "address"
												}, ],
										"language" : {
											"search" : ""
										},

									});

							$('.dataTables_filter input').attr("placeholder",
							"enter seach terms here");

							var table1 = $('#table2')
							.DataTable(
									{
										'dom' : '<"clear"><"row"<"col-md-3 col-sm-3 col-xs-12"l>'
												+ '<"col-md-6 col-sm-6 col-xs-12"fr><"col-md-3 col-sm-3 col-xs-12"RC>>tip',
										"processing" : false,
										"serverSide" : false,
										"autoWidth" : true,
										"ajax" : {
											"url" : "${getRencentBillingUrl}",
											"data" :  {
												"buildingId" : "${building.id}"}
										},
										"colVis" : {
											showAll : "Show all",
											showNone : "Show none"
										},
										"deferRender" : true,
										"createdRow" : function(row,
												data, index) {
										},
										"lengthMenu" : [
												[ 10, 25, 50, -1 ],
												[ 10, 25, 50, "All" ] ],
										"paging" : true,
										"ordering" : true,
										"filter" : true,
										"lengthChange" : true,
										"sort" : true,
										"info" : true,
										"order" : [ [ 1, "asc" ] ],
										columnDefs : [ {
											"searchable" : false,
											"orderable" : false,
											"targets" : 0,
										} ],

										"pagingType" : "full_numbers",
										/* "scrollY" : "330px",
										"scrollCollapse" : true,
										"scrollX" : true, */
										"language" : {
											"decimal" : ",",
											"thousands" : "."
										},
										"columns" : [
												{
													"data" : null,
													"mRender" : function(
															data, type,
															full) {
														return "<a href='#update_building' class='mr10 alert_update' data-toggle='modal' data-target='#modalUpdate'>"
																+ "<span class='fa-1x2 fa fa-pencil-square-o'></span></a>"
																+ "<a href='#view_detail' class='mr10 view_detail'><span class='fa-1x2 fa fa-th'></span></a>"
																+ "<a href='#delete_building' class='alert_delete' ><span class='fa-1x2 fa fa-trash-o'></span></a>";
													}
												},
												{
													"data" : "date"
												},
												{
													"data" : "totalPrice"
												},
												{
													"data" : "status"
												},
												{
													"data" : "customerName"
												}, ],
										"language" : {
											"search" : ""
										},

									});

							$("#upload-image").fileinput({
								maxFileCount : 10,
								allowedFileTypes : [ "image" ],

							});
						});
	</script>
</body>
</html>