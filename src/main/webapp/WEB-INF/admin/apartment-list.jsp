<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="getAllApartmentUrl" value="${pageContext.request.contextPath }/management/apartment/getAllApartment" />
<c:set var="addApartmentUrl" value="${pageContext.request.contextPath }/management/apartment/addApartment" />
<c:set var="updateApartmentUrl" value="${pageContext.request.contextPath }/management/apartment/updateApartment" />
<c:set var="deleteApartmentUrl" value="${pageContext.request.contextPath }/management/apartment/deleteApartment" />
<c:set var="getApartmentById" value="${pageContext.request.contextPath }/management/apartment/getApartmentById" />
<c:set var="getFloorInBuildingUrl" value="${pageContext.request.contextPath }/management/apartment/getFloorInBuilding" />



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
				<h1>Apartment</h1>
				<ol class="breadcrumb">
					<li><a href="${pageContext.request.contextPath }/management/index.html"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Apartment</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class='col-md-12 mt20' id='main_content'>
				<div class='box box-solid box-primary'>
					<div class='box-header'>
						<h3 class='box-title'>
							<a
								href='${pageContext.request.contextPath }/management/apartment/manageApartment.html'>Apartment
								List</a>
						</h3>
						<div class='box-tools pull-right'>
							<a href='#add_apartment' data-toggle='modal'>
								<button class='btn btn-sm btn-hover alert_add'
									style='color: black;' data-toggle='modal'
									data-target="#modalAdd">
									<i class='fa fa-plus-circle'></i> Add New Apartment
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
													<i class="fa fa-building"></i> &nbsp;Add New Apartment
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</h5>
											</div>
											<form action='${addApartmentUrl }' method='post'
												class="form frmModal" role="form"
												enctype="multipart/form-data">
												<div class='modal-body'>
													<div class='row'>
														<label class='col-md-3 col-xs-4 col-sm-3' for="name">Apartment
															Name: </label> <span class='col-md-9 col-xs-8 col-sm-9'><input
															class='form-control' type='text' name='name'
															placeholder='Apartment Name' id='name' /> </span>
													</div>
													<div class='row'>
														 <label
															class='col-md-3 col-xs-4 col-sm-3'>Apartment Type: </label> <span
															class='col-md-9 col-xs-8 col-sm-9'><select class='form-control' style="height:34px" name="apartmentType.id">
																<option value="0">Select Apartment Type</option>
																<c:forEach var="apartmentType" items="${listApartmentType }">
																	<option value="${apartmentType.id }">${apartmentType.name } </option>
																</c:forEach>
														</select></span>
													</div>
													<div class='row'>
														<label class='col-md-3 col-xs-3 col-sm-3'
															for='address.addressName'>Building: </label> <span
															class='col-md-9 col-xs-4 col-sm-4'> <select  class='form-control' style="height:34px" name="floor.building.id">
																<option value="0">Select Building</option>
																<c:forEach var="building" items="${listBuilding }">
																	<option value="${building.id }"> ${building.name } </option>
																</c:forEach>
														</select>
														</span> 
													</div>
													<div class='row'>
														<label class='col-md-3 col-xs-3 col-sm-3'>Floor:
														</label> <span class='col-md-9 col-xs-9 col-sm-9'> <select class='form-control' style="height:34px" name="floor.id">
																<option value="0">Select Floor</option>
														</select>
														</span>
													</div>
													<div class='row'>
														<label class='col-md-3 col-xs-3 col-sm-3'
															for='address.addressName'>Size: </label> <span
															class='col-md-9 col-xs-9 col-sm-9'> <input type='text' class='form-control' name="apartmentSize"/>
														</span> 
													</div>
													<div class='row'>
														<label class='col-md-3 col-xs-3 col-sm-3'>Description:</label>
														<span class='col-md-9 col-xs-9 col-sm-9'>
															<textarea style="width: 100%" name="description"></textarea>
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
											<form action='${updateApartmentUrl }' method='post'
												class="form frmModal" role="form"
												enctype="multipart/form-data">
												<input type='hidden' name='id' />
												<div class='modal-body'>
													<div class='row'>
														<label class='col-md-3 col-xs-4 col-sm-3' for="name">Apartment
															Name: </label> <span class='col-md-9 col-xs-8 col-sm-9'><input
															class='form-control' type='text' name='name'
															placeholder='Apartment Name' id='name' /> </span>
													</div>
													<div class='row'>
														 <label
															class='col-md-3 col-xs-4 col-sm-3'>Apartment Type: </label> <span
															class='col-md-9 col-xs-8 col-sm-9'><select class='form-control' style="height:34px" name="apartmentType.id">
																<option value="0">Select Apartment Type</option>
																<c:forEach var="apartmentType" items="${listApartmentType }">
																	<option value="${apartmentType.id }">${apartmentType.name } </option>
																</c:forEach>
														</select></span>
													</div>
													<div class='row'>
														<label class='col-md-3 col-xs-3 col-sm-3'
															for='address.addressName'>Building: </label> <span
															class='col-md-9 col-xs-4 col-sm-4'> <select  class='form-control' style="height:34px" name="floor.building.id">
																<option value="0">Select Building</option>
																<c:forEach var="building" items="${listBuilding }">
																	<option value="${building.id }"> ${building.name } </option>
																</c:forEach>
														</select>
														</span> 
													</div>
													<div class='row'>
														<label class='col-md-3 col-xs-3 col-sm-3'>Floor:
														</label> <span class='col-md-9 col-xs-9 col-sm-9'> <select class='form-control' style="height:34px" name="floor.id">
																<option value="0">Select Floor</option>
														<c:forEach var="floor" items="${listFloor }">
															<option value="${floor.id }">${floor.floorGroup.name } </option>
														</c:forEach>
														</select>
														</span>
													</div>
													<div class='row'>
														<label class='col-md-3 col-xs-3 col-sm-3'
															for='address.addressName'>Size: </label> <span
															class='col-md-9 col-xs-9 col-sm-9'> <input type='text' class='form-control' name="apartmentSize"/>
														</span> 
													</div>
													<div class='row'>
														<label class='col-md-3 col-xs-3 col-sm-3'>Description:</label>
														<span class='col-md-9 col-xs-9 col-sm-9'>
															<textarea style="width: 100%" name="description"></textarea>
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
								<tr style="overflow: hidden">
									<th class='col-md-1'>Options</th>
									<th class='col-md-3'>Apartment Name</th>
									<th class='col-md-2'>Apartment Type</th>
									<th class='col-md-3'>Building</th>
									<th class='col-md-1'>Floor</th>
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
													"url" : "${getAllApartmentUrl}",
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
																return "<a href='#update_apartment' class='mr10 alert_update' data-toggle='modal' data-target='#modalUpdate'>"
																		+ "<span class='fa-1x2 fa fa-pencil-square-o'></span></a>"
																		+ "<a href='#view_detail' class='mr10 view_detail'><span class='fa-1x2 fa fa-th'></span></a>"
																		+ "<a href='#delete_apartment' class='alert_delete' ><span class='fa-1x2 fa fa-trash-o'></span></a>";
															}
														},
														{
															"data" : "name"
														},
														{
															"data" : "apartmentType",
															"mRender" : function(data, type, full) {
																return "<a href='" + "${pageContext.request.contextPath}/management/apartment-type/apartment-type-detail.html?id=" + 
																data.id + "'>" + data.name  + " </a>";
															}
														},
														{
															"data" : "building",
															"mRender" : function(data, type, full) {
																return "<a href='" + "${pageContext.request.contextPath}/management/building/building-detail.html?id=" + 
																data.id + "'>" + data.name  + " </a>";
															}
														},
														{
															"data" : "floor",
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
						resetForm : true, */
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
							var err = responseText.message;
							var str = "";
							$.each(err, function(index, value){
								str += value + "\n";
							})
							
							bootbox.alert("Failed! \n" + str);
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
										location.href = 'apartment-detail.html?id='
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
													url : "${getApartmentById}",
													dataType : "JSON",
													method : "get",
													data : {
														"id" : data.id,
													},
													success : function(
															response) {
														if (response.success) {
															var building = response.object;
															$(
																	'#modalUpdate')
																	.find(
																			'.frmModal')
																	.resetForm()
																	.autofill(
																			building)
															$(
																	'.chosen-select')
																	.trigger(
																			"chosen:updated");
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
																			url : "${deleteApartmentUrl}",
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

							$(document).on('change', 'select[name="floor.building.id"]', function() {
								var id = $(this).val();
								if (id != 0) {
									var floorSelector = $(this).parents('form').find('select[name="floor.id"]');
									$.ajax({
										url : "${getFloorInBuildingUrl}",
										method: "get",
										dataType: "JSON",
										data: {
											"buildingId" : id,
										},
										success: function(response) {
											if (response.success) {
												var floors = response.objects;
												$(floorSelector).html('<option value="0">Select Floor</option>');
												$.each(floors, function(index, value) {
													$(floorSelector).append('<option value="' + value.id + '"> ' + value.floorGroup.name + '</option>');
												})
											} else {
												alert('cannot load data');
											}
										},
										error: function(response) {
											alert('error, cannot load data');
										}
									})
								}
								
							});
						})
	</script>
</body>
</html>