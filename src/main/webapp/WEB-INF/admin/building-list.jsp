<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="getAllBuildingUrl"
	value="${pageContext.request.contextPath }/management/building/getAllBuilding" />
<c:set var="getBuildingByIdUrl"
	value="${pageContext.request.contextPath }/management/building/getBuildingById" />
<c:set var="addBuildingUrl"
	value="${pageContext.request.contextPath }/management/building/addBuilding" />
<c:set var="updateBuildingUrl"
	value="${pageContext.request.contextPath }/management/building/updateBuilding" />
<c:set var="deleteBuildingUrl"
	value="${pageContext.request.contextPath }/management/building/deleteBuilding" />
<c:set var="addCityUrl"
	value="${pageContext.request.contextPath }/management/address/addCity" />
<c:set var="addDistrictUrl"
	value="${pageContext.request.contextPath }/management/address/addDistrict" />
<c:set var="getAllDistrictUrl"
	value="${pageContext.request.contextPath }/management/address/getAllDistrict" />
<c:set var="getAllCitytUrl"
	value="${pageContext.request.contextPath }/management/address/getAllCity" />
<c:set var="getDistrictByCityUrl"
	value="${pageContext.request.contextPath }/management/address/getDistrictByCity" />
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
				<h1>Building</h1>
				<ol class="breadcrumb">
					<li><a
						href="${pageContext.request.contextPath }/management/index.html"><i
							class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Building</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class='col-md-12 mt20' id='main_content'>
				<div class='box box-solid box-primary'>
					<div class='box-header'>
						<h3 class='box-title'>
							<a
								href='${pageContext.request.contextPath }/management/building/building-list.html'>Building
								List</a>
						</h3>
						<div class='box-tools pull-right'>
							<a href='#add_building' data-toggle='modal'>
								<button class='btn btn-sm btn-hover alert_add'
									style='color: black;' data-toggle='modal'
									data-target="#modalAdd">
									<i class='fa fa-plus-circle'></i> Add New Building
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
													<i class="fa fa-building"></i> &nbsp;Add New Building
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</h5>
											</div>
											<form action='${addBuildingUrl }' method='post'
												class="form frmModal" role="form"
												enctype="multipart/form-data">
												<div class='modal-body'>
													<div class='row'>
														<label class='col-md-3 col-xs-4 col-sm-3' for="name">Building
															Name: </label> <span class='col-md-9 col-xs-8 col-sm-9'><input
															class='form-control' type='text' name='name'
															placeholder='Building Name' id='name' /> </span>
													</div>
													<div class='row'>
														<label class='col-md-3 col-xs-3 col-sm-3'
															for='address.addressName'>Address: </label> <span
															class='col-md-9 col-xs-9 col-sm-9'><input
															class='form-control' type='text'
															name='address.addressName' placeholder='Address'
															id='addressName' /> </span>
													</div>
													<div class='row'>
														<label class='col-md-3 col-xs-3' for='phone'>Phone
															Number: </label> <span class='col-md-9 col-xs-9'><input
															class='form-control' type='text' name='phone' id='phone'
															placeholder='Phone Number' /> </span>
													</div>
													<div class='row'>
														<label class='col-md-3 col-xs-3' for='wardName'>Ward:
														</label> <span class='col-md-9 col-xs-9 '> <input
															class='form-control' type='text' name='address.wardName'
															id='wardName' placeholder='Ward' />
														</span>
													</div>
													<div class='row'>
														<label class='col-md-2 col-xs-2'>District: </label>
														<button
															class='btn btn-primary btn-sm col-md-1 col-xs-1 fa fa-plus btnAdd'
															type='button' data-target="#addDistrict"
															data-toggle="modal"></button>
														<select id="sltDistrict1" class='chosen-select'
															name='address.district.id' style='width: 75%'
															data-placeholder="Choose a district...">
															<option value='-1' disabled="disabled"
																selected="selected">Choose a district...</option>
															<c:forEach var="district" items="${listDistrict }">
																<option value="${district.id}">${district.name}</option>
															</c:forEach>
														</select>
													</div>
													<div class='row'>

														<label class='col-md-2 col-xs-2'>City:</label> <select
															id="sltCity1" class='chosen-select'
															name='address.district.city.id' style='width: 75%'>
															<c:forEach var="city" items="${listCity }">
																<option value="${city.id}">${city.name}</option>
															</c:forEach>
														</select>
														<button
															class='btn btn-sm btn-primary col-md-1 col-xs-1 fa fa-plus btnAdd'
															type='button' data-target="#addCity" data-toggle="modal"></button>
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
													<i class="fa fa-building"></i> &nbsp;Update Building
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</h5>
											</div>
											<form action='${updateBuildingUrl }' method='post'
												class="form frmModal" role="form"
												enctype="multipart/form-data">
												<input type='hidden' name='id' />
												<div class='modal-body'>
													<div class='row'>
														<label class='col-md-3 col-xs-4 col-sm-3' for="name">Building
															Name: </label> <span class='col-md-9 col-xs-8 col-sm-9'><input
															class='form-control' type='text' name='name'
															placeholder='Building Name' id='name' /> </span>
													</div>
													<div class='row'>
														<label class='col-md-3 col-xs-3 col-sm-3'
															for='address.addressName'>Address: </label> <span
															class='col-md-9 col-xs-9 col-sm-9'><input
															class='form-control' type='text'
															name='address.addressName' placeholder='Address'
															id='addressName' /> </span>
													</div>
													<div class='row'>
														<label class='col-md-3 col-xs-3' for='phone'>Phone
															Number: </label> <span class='col-md-9 col-xs-9'><input
															class='form-control' type='text' name='phone' id='phone'
															placeholder='Phone Number' /> </span>
													</div>
													<div class='row'>
														<label class='col-md-3 col-xs-3' for='wardName'>Ward:
														</label> <span class='col-md-9 col-xs-9 '> <input
															class='form-control' type='text' name='address.wardName'
															id='wardName' placeholder='Ward' />
														</span>
													</div>
													<div class='row'>
														<label class='col-md-2 col-xs-2'>District: </label>
														<button
															class='btn btn-primary btn-sm col-md-1 col-xs-1 fa fa-plus btnAdd'
															type='button' data-target="#addDistrict"
															data-toggle="modal"></button>
														<select id="sltDistrict1" class='chosen-select'
															name='address.district.id' style='width: 75%'
															data-placeholder="Choose a district...">
															<option value='-1' disabled="disabled"
																selected="selected">Choose a district...</option>
															<c:forEach var="district" items="${listDistrict }">
																<option value="${district.id}">${district.name}</option>
															</c:forEach>
														</select>
													</div>
													<div class='row'>

														<label class='col-md-2 col-xs-2'>City:</label> <select
															id="sltCity1" class='chosen-select'
															name='address.district.city.id' style='width: 75%'>
															<c:forEach var="city" items="${listCity }">
																<option value="${city.id}">${city.name}</option>
															</c:forEach>
														</select>
														<button
															class='btn btn-sm btn-primary col-md-1 col-xs-1 fa fa-plus btnAdd'
															type='button' data-target="#addCity" data-toggle="modal"></button>
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


							<!-- Modal add new city -->
							<div class="modal fade modalAdd" id="addCity"
								data-modal-index="2" tabindex="-1">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">
												<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
											</button>
											<h4 class="modal-title">Add New City</h4>
										</div>
										<form action="${addCityUrl }" method="post"
											class="form frmModal" role="form">
											<div class="modal-body">
												<div class='row'>
													<label class='col-md-3 col-xs-3' for='cityName'>City
														Name: </label> <span class='col-md-9 col-xs-9'><input
														class='form-control' type="text" name="name" id='cityName'
														placeholder="City Name" /> </span>
												</div>
												<div class='row'>
													<label class='col-md-3 col-xs-3' for='zipcode'>Zipcode:
													</label> <span class='col-md-4 col-xs-4'><input
														class='form-control' type="text" name="zipcode"
														id='zipcode' placeholder="Zipcode" /> </span>
												</div>
											</div>

											<div class="modal-footer">
												<button type="button" class="btn btn-primary"
													data-dismiss="modal">Close</button>
												<button type="submit" class="btn btn-primary">Add
													New City</button>
											</div>
										</form>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- /.modal -->


							<!-- Modal Add New district -->

							<div class="modal fade modalAdd" id="addDistrict"
								data-modal-index="2" tabindex="-1">
								<div class="modal-dialog modalAdd">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">
												<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
											</button>
											<h4 class="modal-title">Add New District</h4>
										</div>
										<form action="${addDistrictUrl }" method="post"
											class="form frmModal" role="form">
											<div class="modal-body">
												<div class='row'>
													<label class='col-md-3 col-xs-3'>District Name: </label> <span
														class='col-md-9 col-xs-12'><input
														class='form-control' type="text" name="name"
														placeholder="District Name" /> </span>
												</div>
												<div class='row'>
													<label class='col-md-3 col-xs-3'>City: </label> <select
														class="chosen-select" style='width: 75%' name='city.id'>
														<c:forEach var="city" items="${listCity }">
															<option value="${city.id}">${city.name}</option>
														</c:forEach>
													</select>
												</div>
											</div>

											<div class="modal-footer">
												<button type="button" class="btn btn-primary"
													data-dismiss="modal">Close</button>
												<button type="submit" class="btn btn-primary">Add
													New District</button>
											</div>
										</form>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- /.modal -->


							<button class='btn btn-primary btn-sm' data-widget='collapse'>
								<i class='fa fa-minus'></i>
							</button>
						</div>
					</div>
					<div class='box-body table-responsive' style='display: block;'>
						<table id="table" class="display" style="width:100%">
							<thead>
								<tr>
									<th class='col-md-1'>Options</th>
									<th class='col-md-3'>Building name</th>
									<th class='col-md-3'>Address</th>
									<th class='col-md-2'>Phone number</th>
									<th class='col-md-1'>Number of apartment</th>
									<th class='col-md-1'>Number of floors</th>
									<th class='col-md-1'>Number of employees</th>
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
						function() {
							var table = $('#table')
									.DataTable(
											{
												'dom' : '<"clear"><"row"<"col-md-3 col-sm-3 col-xs-12"l>'
														+ '<"col-md-6 col-sm-6 col-xs-12"fr><"col-md-3 col-sm-3 col-xs-12"RC>>tip',
												"processing" : false,
												"serverSide" : false,
												"autoWidth" : true,
												"ajax" : {
													"url" : "${getAllBuildingUrl}",
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
																return "<a href='#update_building' class='mr10 alert_update' data-toggle='modal' data-target='#modalUpdate'>"
																		+ "<span class='fa-1x2 fa fa-pencil-square-o'></span></a>"
																		+ "<a href='#view_detail' class='mr10 view_detail'><span class='fa-1x2 fa fa-th'></span></a>"
																		+ "<a href='#delete_building' class='alert_delete' ><span class='fa-1x2 fa fa-trash-o'></span></a>";
															}
														},
														{
															"data" : "name"
														},
														{
															"data" : "address"
														},
														{
															"data" : "phone"
														},
														{
															"data" : "numberApartment"
														},
														{
															"data" : "numberFloor",
														},
														{
															"data" : "numberEmployee",
														}, ],
												"language" : {
													"search" : ""
												},

											});
							$('.dataTables_filter input').attr("placeholder",
									"enter seach terms here");

							var options = {
								success : showResponse,
								/* clearForm: true, */
								resetForm : true,
								timeout : 4000

							}

							function showResponse(responseText, statusText,
									xhr, $form) {
								if (responseText.success) {
									bootbox.alert("successfully!");
									ajaxReloadDistrict();
									ajaxReloadCity();
									table.ajax.reload(null, false);
									$form.parents('.modal').modal('toggle');
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
												location.href = 'building-detail.html?id='
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
															url : "${getBuildingByIdUrl}",
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
																					url : "${deleteBuildingUrl}",
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

							$(".chosen-select").chosen({
								width : "72%"
							});
							$(".chosen-select").attr('disabled', false)
									.trigger("chosen:updated")
							$("#sltDistrict1").depdrop({
								url : '${getDistrictByCityUrl}',
								depends : [ 'sltCity1' ]
							}).on(
									'depdrop.change',
									function(event, id, value, count) {
										$(this).find('option').eq(0).attr(
												'disabled', true);
										$(this).val('').trigger(
												"chosen:updated");
									})
							$("#sltDistrict2").depdrop({
								url : '${getDistrictByCityUrl}',
								depends : [ 'sltCity2' ]
							}).on(
									'depdrop.change',
									function(event, id, value, count) {
										$(this).find('option').eq(0).attr(
												'disabled', true);
										$(this).val('').trigger(
												"chosen:updated");
									});
							$('.btnAdd')
									.on(
											'click',
											function() {
												var v = $(this)
														.parents('.row')
														.find(
																'.chosen-select[name*="city.id"]')
														.val();
												var target = $(this).attr(
														'data-target');
												$(target)
														.find(
																'.chosen-select[name*="city.id"]')
														.val(v)
														.trigger(
																"chosen:updated");
											});
							$.fn.modal.Constructor.prototype.enforceFocus = function() {
							};

						});

		function ajaxReloadDistrict() {
			$.ajax({
				url : "${getAllDistrictUrl}",
				dataType : "JSON",
				method : "Get",
				success : function(data) {
					$('select[name*="district.id"]').html(
							'<option value="0">Choose District</option>');
					$.each(data, function() {
						$('select[name*="district.id"]').append(
								'<option value="' + this.id + '">' + this.name
										+ '</option>');
					});
					$('select[name*="district.id"]').trigger("chosen:updated")
				},
				error : function() {
					alert('cannot reload data')
				}
			});
		}

		function ajaxReloadCity() {
			$.ajax({
				url : "${getAllCitytUrl}",
				dataType : "JSON",
				method : "Get",
				success : function(data) {
					$('select[name*="city.id"]').html('');
					$.each(data, function() {
						$('select[name*="city.id"]').append(
								'<option value="' + this.id + '">' + this.name
										+ '</option>');
					});
					$('select[name*="city.id"]').trigger("chosen:updated")
				},
				error : function() {
					alert('cannot reload data')
				}
			});
		}
	</script>
</body>
</html>