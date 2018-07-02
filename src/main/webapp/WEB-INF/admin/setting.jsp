<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="spring"%>
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
				<h1>Setting</h1>
				<ol class="breadcrumb">
					<li><a
						href="${pageContext.request.contextPath }/management/index.html"><i
							class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">Setting</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class='container-fluid'>
				<spring:form action="${pageConetxt.request.contextPath }/management/setting.html" method="post" modelAttribute="setting">
					<div class='row mt20 form-group'>
						<div class='col-md-2'>
							<spring:label path="companyName">Company Name: </spring:label>
						</div>
						<div class='col-md-6'>
							<spring:input path="companyName" cssClass="form-control" />
						</div>
						<div class='col-md-2'>
							<spring:errors path="companyName" />
						</div>
					</div>
					<div class='row form-group'>
						<div class='col-md-2'>
							<spring:label path="mainAddress">Address: </spring:label>
						</div>
						<div class='col-md-6'>
							<spring:input path="mainAddress" cssClass="form-control" />
						</div>
						<div class='col-md-2'>
							<spring:errors path="mainAddress" />
						</div>
					</div>
					<div class='row form-group'>
						<div class='col-md-2'>
							<spring:label path="mainPhone">Phone Number: </spring:label>
						</div>
						<div class='col-md-6'>
							<spring:input path="mainPhone" cssClass="form-control" />
						</div>
						<div class='col-md-2'>
							<spring:errors path="mainPhone" />
						</div>
					</div>
					<div class='row form-group'>
						<div class='col-md-2'>
							<spring:label path="imagePathLogo">Logo</spring:label>
						</div>
						<div class='col-md-6'>
							<spring:input path="imagePathLogo" cssClass="form-control" />
						</div>
						<div class='col-md-2'>
							<spring:errors path="imagePathLogo" />
						</div>
					</div>
					<div class='row form-group'>
						<div class='col-md-2'>
							<spring:label path="facebookFanPageLink">Facebook Fanpage Link</spring:label>
						</div>
						<div class='col-md-6'>
							<spring:input path="facebookFanPageLink" cssClass="form-control" />
						</div>
						<div class='col-md-2'>
							<spring:errors path="facebookFanPageLink" />
						</div>
					</div>
					<div class='row form-group'>
						<div class='col-md-2'>
							<spring:label path="twitterFanPageLink">Twitter Fanpage Link</spring:label>
						</div>
						<div class='col-md-6'>
							<spring:input path="twitterFanPageLink" cssClass="form-control" />
						</div>
						<div class='col-md-2'>
							<spring:errors path="twitterFanPageLink" />
						</div>
					</div>
					<div class='row form-group'>
						<div class='col-md-2'>
							<spring:label path="youTubeLink">Youtube Page Link</spring:label>
						</div>
						<div class='col-md-6'>
							<spring:input path="youTubeLink" cssClass="form-control" />
						</div>
						<div class='col-md-2'>
							<spring:errors path="youTubeLink" />
						</div>
					</div>
					<div class='row form-group'>
						<div class='col-md-2'>
							<spring:label path="officalEmail">Offical Email: </spring:label>
						</div>
						<div class='col-md-6'>
							<spring:input path="officalEmail" cssClass="form-control" />
						</div>
						<div class='col-md-2'>
							<spring:errors path="officalEmail" />
						</div>
					</div>
					<div class='row form-group'>
						<div class='col-md-2'>
							<spring:label path="hotLine">Hot Line: </spring:label>
						</div>
						<div class='col-md-6'>
							<spring:input path="hotLine" cssClass="form-control" />
						</div>
						<div class='col-md-2'>
							<spring:errors path="hotLine" />
						</div>
					</div>
					<div class='row form-group'>
						<div class='col-md-2'>
							<spring:label path="website">Website: </spring:label>
						</div>
						<div class='col-md-6'>
							<spring:input path="website" cssClass="form-control" />
						</div>
						<div class='col-md-2'>
							<spring:errors path="website" />
						</div>
					</div>
					<div class='row form-group'>
						<div class='col-md-2'>
							<spring:label path="descriptionAboutUs">Description about us: </spring:label>
						</div>
						<div class='col-md-6'>
							<spring:textarea path="descriptionAboutUs" cssClass="form-control" />
						</div>
						<div class='col-md-2'>
							<spring:errors path="descriptionAboutUs" />
						</div>
					</div>
					<div class='row form-group'>
						<div class='col-md-2'>
							<spring:label path="descriptionAboutNews">Description about news: </spring:label>
						</div>
						<div class='col-md-6'>
							<spring:textarea path="descriptionAboutNews" cssClass="form-control" />
						</div>
						<div class='col-md-2'>
							<spring:errors path="descriptionAboutNews" />
						</div>
					</div>
					<div class='row'>
						<div class='col-md-offset-3 col-md-2 mt20'><button type="submit" class='form-control btn btn-primary' >Save</button></div>
					</div>
				</spring:form>
				
				<p>${msg }</p>
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

</body>
</html>