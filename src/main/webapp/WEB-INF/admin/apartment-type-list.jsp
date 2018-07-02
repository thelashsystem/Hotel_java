<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="getAllApartmentTypeUrl"
	value="${pageContext.request.contextPath }/management/apartment-type/getAllApartmentType" />
<c:set var="addApartmentTypeUrl"
	value="${pageContext.request.contextPath }/management/apartment-type/addApartmentType" />
<c:set var="updateApartmentTypeUrl"
	value="${pageContext.request.contextPath }/management/apartment-type/updateApartmentType" />
<c:set var="deleteApartmentTypeUrl"
	value="${pageContext.request.contextPath }/management/apartment-type/deleteApartmentType" />
	<c:set var="getApartmentTypeById"
	value="${pageContext.request.contextPath }/management/apartment-type/getApartmentTypeById" />


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
				<h1>Apartment Type</h1>
				<ol class="breadcrumb">
					<li><a
						href="${pageContext.request.contextPath }/management/index.html"><i
							class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Apartment Type</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class='col-md-12 mt20' id='main_content'>
				<div class='box box-solid box-primary'>
					<div class='box-header'>
						<h3 class='box-title'>
							<a
								href='${pageContext.request.contextPath }/management/apartment/manageApartment.html'>Apartment
								Type List</a>
						</h3>
						<div class='box-tools pull-right'>
							<a href='#add_apartment' data-toggle='modal'>
								<button class='btn btn-sm btn-hover alert_add'
									style='color: black;' data-toggle='modal'
									data-target="#modalAdd">
									<i class='fa fa-plus-circle'></i> Add New Apartment Type
								</button>
							</a>


							<!-- Modal dialog add  -->
							<section id='modalAdd' class='modal fade modalAdd' role='dialog'
								tabindex="-1" data-modal-index="1"
								aria-labelledby="myModalLabel1" aria-hidden='true'>
								<div class='modal-dialog'>
									<div class="model-content row">
										<div
											class="col-xs-12 col-sm-12 col-md-12 col-lg-12 well well-sm">
											<div class='modal-header'>
												<h5 class='modal-title' id="myModalLabel1">
													<i class="fa fa-building"></i> &nbsp;Add New Apartment Type
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</h5>
											</div>
											<form action='${addApartmentTypeUrl }' method='post'
												class="form frmModal" role="form"
												enctype="multipart/form-data">
												<div class='modal-body'>
													<div class='row'>
														<label class='col-md-4 col-xs-4 col-sm-4' for="name">Apartment
															Type Name: </label> <span class='col-md-8 col-xs-8 col-sm-8'><input
															class='form-control' type='text' name='name'
															placeholder='Apartment Type Name' id='name' /> </span>
													</div>
													<div class="row btn-group" data-toggle="buttons"
														style="display: block;">
														<label
															class="col-md-offset-2 col-md-4 col-xs-4 col-sm-4 btn btn-primary"
															style="margin-left: 16.667%; line-height: 20px">
															<input type="checkbox" name="hot" value="true"/>
															<strong>Is Hot</strong>
														</label> <label class="col-md-4 col-xs-4 col-sm-4 btn btn-primary"
															style='line-height: 20px'> <input type="checkbox"
															 name="new" value="true"/> <strong>Is New</strong>
														</label>
													</div>
													<div class='row'>
														<label class='col-md-4 col-xs-4 col-sm4' for="name">Apartment Type
															Code: </label> <span class='col-md-4 col-xs-4 col-sm-4'><input
															class='form-control' type='text' name='code'
															placeholder='Apartment Type Code' id='code' /> </span>
													</div>
													<div class='row'>
														<label class='col-md-3 col-xs-3 col-sm-3'
															for='address.addressName'>Priority Order: </label> <span
															class='col-md-3 col-xs-3 col-sm-3'> <input
															type='text' class='form-control' name="orderNum" />
														</span>
													</div>
													<div class='row'>
														<label class='col-md-3 col-xs-3 col-sm-3'>Current
															price: </label> <span class='col-md-3 col-xs-3 col-sm-3'>
															<input type='text' class='form-control' name="price" />
														</span>
													</div>
													<div class='row'>
														<label class='col-md-3 col-xs-3 col-sm-3'>Description:</label>
														<span class='col-md-9 col-xs-9 col-sm-9'> <textarea
																style="width: 100%" name="description"></textarea>
														</span>
													</div>
												</div>

												<div class='modal-footer'>
													<div class='row'>
														<button
															class='btn btn-primary btn-md col-md-2 col-sm-2 col-xs-2'
															type="button" data-dismiss="modal" aria-label="Close">Close</button>
														<button
															class='btn btn-primary btn-md col-md-2 col-sm-2 col-xs-2'
															type="reset">Reset</button>
														<button
															class='btn btn-primary btn-md col-md-2 col-sm-2 col-xs-2'
															type="submit" id='btnAdd'>Add</button>
													</div>
												</div>
											</form>
										</div>
									</div>
								</div>
							</section>

							<!-- Modal Dialog update -->
							<section id='modalUpdate' class='modal fade modalUpdate'
								role='dialog' tabindex="-1" data-modal-index="1"
								aria-labelledby="myModalLabel2" aria-hidden='true'>
								<div class='modal-dialog'>
									<div class="model-content row">
										<div
											class="col-xs-12 col-sm-12 col-md-12 col-lg-12 well well-sm">
											<div class='modal-header'>
												<h5 class='modal-title' id="myModalLabel2">
													<i class="fa fa-building"></i> &nbsp;Update Apartment
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</h5>
											</div>
											<form action='${updateApartmentTypeUrl }' method='post'
												class="form frmModal" role="form"
												enctype="multipart/form-data">
												<input type='hidden' name='id' />
												<div class='modal-body'>
													<div class='row'>
														<label class='col-md-4 col-xs-4 col-sm-4' for="name">Apartment
															Type Name: </label> <span class='col-md-8 col-xs-8 col-sm-8'><input
															class='form-control' type='text' name='name'
															placeholder='Room Name' id='name' /> </span>
													</div>
													<div class="row btn-group" data-toggle="buttons"
														style="display: block;">
														<label
															class="col-md-offset-2 col-md-4 col-xs-4 col-sm-4 btn btn-primary"
															style="margin-left: 16.667%; line-height: 20px">
															<input type="checkbox" name="hot" value="1">
															<strong>Is Hot</strong>
														</label> <label class="col-md-4 col-xs-4 col-sm-4 btn btn-primary"
															style='line-height: 20px'> <input type="checkbox"
															 name="new" value="1"> <strong>Is New</strong>
														</label>
													</div>
													<div class='row'>
														<label class='col-md-4 col-xs-4 col-sm-4' for="name">Apartment Type
															Code: </label> <span class='col-md-4 col-xs-4 col-sm4'><input
															class='form-control' type='text' name='name'
															placeholder='Apartment Type Code' id='name' /> </span>
													</div>
													<div class='row'>
														<label class='col-md-3 col-xs-3 col-sm-3'
															for='address.addressName'>Priority Order: </label> <span
															class='col-md-3 col-xs-3 col-sm-3'> <input
															type='text' class='form-control' name="orderNum" />
														</span>
													</div>
													<div class='row'>
														<label class='col-md-3 col-xs-3 col-sm-3'>Current
															price: </label> <span class='col-md-3 col-xs-3 col-sm-3'>
															<input type='text' class='form-control' name="price" />
														</span>
													</div>
													<div class='row'>
														<label class='col-md-3 col-xs-3 col-sm-3'>Description:</label>
														<span class='col-md-9 col-xs-9 col-sm-9'> <textarea
																style="width: 100%" name="description"></textarea>
														</span>
													</div>
												</div>
												<div class='modal-footer'>
													<div class='row'>
														<button
															class='btn btn-primary btn-md col-md-2 col-sm-2 col-xs-3'
															type="submit" id='btnAdd'>Update</button>
														<button
															class='btn btn-primary btn-md col-md-2 col-sm-2 col-xs-3'
															type="button" data-dismiss="modal" aria-label="Close">Close</button>

													</div>
												</div>
											</form>
										</div>
									</div>
								</div>
							</section>

							<button class='btn btn-primary btn-sm' data-widget='collapse'>
								<i class='fa fa-minus'></i>
							</button>
						</div>
					</div>
					<div class='box-body table-responsive' style='display: block;'>
						<table id="table" class="display" width="100%">
							<thead>
								<tr>
									<th class='col-md-1'>Options</th>
									<th class='col-md-3'>Room Name</th>
									<th class='col-md-2'>Current Price</th>
									<th class='col-md-2'>Number of rooms</th>
									<th class='col-md-2'>Number of avaiable rooms</th>
									<th class='col-md-2'>Status</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td></td>
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
			</section>

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
							var table = $('#table')
									.DataTable(
											{
												'dom' : '<"clear"><"row"<"col-md-3 col-sm-3 col-xs-12"l>'
														+ '<"col-md-6 col-sm-6 col-xs-12"fr><"col-md-3 col-sm-3 col-xs-12"RC>>tip',
												"processing" : false,
												"serverSide" : false,
												"autoWidth" : true,
												"ajax" : {
													"url" : "${getAllApartmentTypeUrl}",
													"data" : function(d) {

													}
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
																return "<a href='#update_apartment_type' class='mr10 alert_update' data-toggle='modal' data-target='#modalUpdate'>"
																		+ "<span class='fa-1x2 fa fa-pencil-square-o'></span></a>"
																		+ "<a href='#view_detail' class='mr10 view_detail'><span class='fa-1x2 fa fa-th'></span></a>"
																		+ "<a href='#delete_apartment_type' class='alert_delete' ><span class='fa-1x2 fa fa-trash-o'></span></a>";
															}
														},
														{
															"data" : "name"
														},
														{
															"data" : "currentPrice"
														},
														{
															"data" : "numberRoom"
														},
														{
															"data" : "numberAvailableRoom",
														}, {
															"data" : "status",
														}, ],
												"language" : {
													"search" : ""
												},

											});
							$('.dataTables_filter input').attr("placeholder",
									"enter seach terms here");

							var options = {
								success : showResponse,
								/* clearForm: true,
								resetForm : true,  */
								timeout : 4000

							}

							function showResponse(responseText, statusText,
									xhr, $form) {
								if (responseText.success) {
									bootbox.alert("successfully!");
									table.ajax.reload(null, false);
									$form.parents('.modal').modal('toggle');
									$form.resetForm();
								} else {
									bootbox.alert("Failed!");
								}

							}

							$('.frmModal').submit(function() {
								$(this).ajaxSubmit(options);
								return false;
							});

							$(document)
									.on(
											'click',
											'.view_detail',
											function() {
												var id = table.row(
														$(this).parents('tr'))
														.data().id;
												location.href = 'apartment-type-detail.html?id='
														+ id;
											});

							$(document)
									.on(
											"click",
											".alert_update",
											function(e) {
												var data = table.row(
														$(this).parents('tr'))
														.data();
												$
														.ajax({
															url : "${getApartmentTypeById}",
															dataType : "JSON",
															method : "get",
															data : {
																"id" : data.id,
															},
															success : function(
																	response) {
																if (response.success) {
																	var apartmentType = response.object;
																	$(
																			'#modalUpdate')
																			.find(
																					'.frmModal')
																			.resetForm()
																			.autofill(
																					apartmentType)
																} else {

																}
															},
															error : function(
																	data) {
																alert('cannot get data')
															}

														});
											});

							$(document)
									.on(
											"click",
											".alert_delete",
											function(e) {
												var data = table.row(
														$(this).parents('tr'))
														.data();

												e.preventDefault();
												bootbox
														.confirm(
																"Are you sure want to proceed?",
																function(result) {
																	if (result) {

																		$
																				.ajax({
																					url : "${deleteApartmentTypeUrl}",
																					dataType : "Json",
																					method : "Post",
																					data : {
																						"id" : data.id,
																					},
																					success : function(
																							response) {
																						if (response.success) {
																							table.ajax
																									.reload(
																											null,
																											false);
																							bootbox
																									.alert("Deleted successfully!");
																						}
																					}
																				})
																	}
																});
											});

							$.fn.modal.Constructor.prototype.enforceFocus = function() {
							};

						});
	</script>
</body>
</html>