 
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img
					src="${pageContext.request.contextPath }/resources/${userManager.avatar}"
					class="img-circle" alt="User Image" />
			</div>
			<div class="pull-left info">
				<p>${userManager.employee.profile.lastName } ${userManager.employee.profile.firstName }</p>

				 <a href="#"><i class="fa fa-circle text-success"></i> ${userManager.employee }</a> 
			</div>
		</div>
		<!-- search form -->
		<form action="${pageContext.request.contextPath }/index.html"
			method="get" class="sidebar-form">
			<div class="input-group">
				<input type="text" name="q" class="form-control"
					placeholder="Search..." /> <span class="input-group-btn">
					<button type='submit' name='search' id='search-btn'
						class="btn btn-flat">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>
		</form>
		<!-- /.search form -->
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">MAIN NAVIGATION</li>
			<li class="active"><a
				href="${pageContext.request.contextPath }/management/index.html">
					<i class="fa fa-dashboard"></i> <span>Dashboard</span>
			</a></li>

			<li><a
				href="${pageContext.request.contextPath }/management/booking/#">
					<i class="fa fa-tags"></i> <span>Booking</span> <i
					class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class='treeview-menu'>
					<li><a href='${pageContext.request.contextPath }/management/booking/booking-apartment.html'><i
							class="fa fa-circle-o"></i>Booking Apartment</a></li>
					<li><a href='${pageContext.request.contextPath }/management/booking/overview-apartment.html'><i
							class="fa fa-circle-o"></i>Overview Apartment</a></li>
				</ul>
			</li>
			<li class='treeview'><a
				href="${pageContext.request.contextPath }/management/building/#">
					<i class="fa fa-building"></i> <span>Building</span> <i
					class="fa fa-angle-left pull-right"></i> <!-- <small class="label pull-right bg-green">new</small> -->
			</a>
				<ul class="treeview-menu">
					<li><a
						href="${pageContext.request.contextPath }/management/building/building-list.html"><i
							class="fa fa-circle-o"></i> Building List </a></li>
					<li><a
						href="${pageContext.request.contextPath }/management/building/floor-list.html"><i
							class="fa fa-circle-o"></i> Floor List </a></li>
					<li><a
						href="${pageContext.request.contextPath }/management/address/address-list.html"><i
							class="fa fa-circle-o"></i> Address </a></li>
				</ul></li>
			<li class="treeview"><a
				href="${pageContext.request.contextPath }/management/apartment/#"> <i
					class="fa fa-bed"></i> <span>Apartment</span> <i
					class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li><a
						href="${pageContext.request.contextPath }/management/apartment/apartment-list.html"><i
							class="fa fa-circle-o"></i> Apartment List</a></li>
					<li><a
						href="${pageContext.request.contextPath }/management/apartment-type/apartment-type-list.html"><i
							class="fa fa-circle-o"></i> Apartment Type List</a></li>
				</ul></li>
			<li class="treeview"><a
				href="${pageContext.request.contextPath }/management/service/#">
					<i class="fa fa-cutlery"></i> <span>Service</span> <i
					class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li><a
						href="${pageContext.request.contextPath }/management/service/#"><i
							class="fa fa-circle-o"></i> Service <i
							class="fa fa-angle-left pull-right"></i></a>
						<ul class='treeview-menu'>
							<li><a
								href='${pageContext.request.contextPath }/management/service/service-list.html'><i
									class="fa fa-minus"></i> Service List</a></li>
							<li><a
								href="${pageContext.request.contextPath }/management/service/service-price-plan.html"><i
									class="fa fa-minus"></i> Service Price Plan</a></li>
						</ul></li>
					<li><a
						href="${pageContext.request.contextPath }/management/resource/#"><i
							class="fa fa-circle-o"></i> Resource <i
							class="fa fa-angle-left pull-right"></i></a>
						<ul class='treeview-menu'>
							<li><a
								href='${pageContext.request.contextPath }/management/resource/resource-list.html'><i
									class="fa fa-minus"></i> Resource List</a></li>
							<li><a
								href="${pageContext.request.contextPath }/management/resource/resource-price-plan.html"><i
									class="fa fa-minus"></i> Resource Price Plan</a></li>
						</ul></li>
				</ul></li>
			<li class="treeview"><a
				href="${pageContext.request.contextPath }/management/employee/#">
					<i class="fa fa-database"></i> <span>Employee</span> <i
					class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li><a
						href="${pageContext.request.contextPath }/management/employee/employee-list.html"><i
							class="fa fa-circle-o"></i> Employee List</a></li>
					<li><a
						href="${pageContext.request.contextPath }/management/employee/employee-assignment.html"><i
							class="fa fa-circle-o"></i> Assignment</a></li>
				</ul></li>
			<li class="treeview"><a
				href="${pageContext.request.contextPath }/management/contract/#">
					<i class="fa fa-briefcase"></i> <span>Contract</span> <i
					class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li><a
						href="${pageContext.request.contextPath }/management/contract/customer-contract.html"><i
							class="fa fa-circle-o"></i> Customer Contract</a></li>
					<li><a
						href="${pageContext.request.contextPath }/management/contract/service-contract.html"><i
							class="fa fa-circle-o"></i> Service Contract</a></li>
					<li><a
						href="${pageContext.request.contextPath }/management/contract/employee-contract.html"><i
							class="fa fa-circle-o"></i> Employee Contract</a></li>
					<li><a
						href="${pageContext.request.contextPath }/management/contract/supplier-contract.html"><i
							class="fa fa-circle-o"></i> Supplier Contract</a></li>
					<li><a
						href="${pageContext.request.contextPath }/management/contract/advertising-contract.html"><i
							class="fa fa-circle-o"></i> Advertising Contract</a></li>
				</ul></li>
			<%-- <li><a href="${pageContext.request.contextPath }/#"> <i
					class="fa fa-calculator"></i> <span>Invoice</span> <!-- <small
					class="label pull-right bg-red">3</small> -->
			</a></li> --%>
			<%-- <li><a href="${pageContext.request.contextPath }/#"> <i
					class="fa fa-envelope"></i> <span>Mailbox</span> <small
					class="label pull-right bg-yellow">12</small>
			</a></li> --%>
			<li class="treeview"><a
				href="${pageContext.request.contextPath }/management/billing/#">
					<i class="fa fa-edit"></i> <span>Billing</span> <i
					class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li><a
						href="${pageContext.request.contextPath }/management/billing/pending-billing-list.html"><i
							class="fa fa-circle-o"></i> Pending Billing List</a></li>
					<li><a
						href="${pageContext.request.contextPath }/management/billing/billing-list.html"><i
							class="fa fa-circle-o"></i> All Billing List</a></li>
					<li><a
						href="${pageContext.request.contextPath }/management/billing/resource-billing-list.html"><i
							class="fa fa-circle-o"></i> Pending Resource Billing List</a></li>
					<li><a
						href="${pageContext.request.contextPath }/management/invoice/invoice-list.html"><i
							class="fa fa-circle-o"></i> Invoice</a></li>
				</ul></li>
			<li class="treeview"><a
				href="${pageContext.request.contextPath }/management/website/#">
					<i class="fa fa-globe"></i> <span>Website</span> <i
					class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li><a
						href="${pageContext.request.contextPath }/management/website/news/news-list.html"><i
							class="fa fa-circle-o"></i> News</a></li>
					<li><a
						href="${pageContext.request.contextPath }/management/website/banner/#"><i
							class="fa fa-circle-o"></i> Banners <i
							class="fa fa-angle-left pull-right"></i></a>
						<ul class="treeview-menu">
							<li><a
								href="${pageContext.request.contextPath }/management/website/banner/banner-list.html"><i
									class="fa fa-minus"></i> Banner List</a></li>
							<li><a
								href="${pageContext.request.contextPath }/management/website/banner/banner-position.html"><i
									class="fa fa-minus"></i> Position Banner <!-- <i
									class="fa fa-angle-left pull-right"></i> --></a> <%-- <ul class="treeview-menu">
									<li><a href="${pageContext.request.contextPath }/#"><i
											class="fa fa-circle-o"></i> Level Three</a></li>
									<li><a href="${pageContext.request.contextPath }/#"><i
											class="fa fa-circle-o"></i> Level Three</a></li>
								</ul></li> --%>
						</ul></li>
				</ul></li>
			<li><a
				href="${pageContext.request.contextPath }/management/customer/customer-list.html"><i
					class="fa fa-users"></i> Customer</a></li>
			<li><a
				href="${pageContext.request.contextPath }/management/asset/asset-list.html"><i
					class="fa fa-book"></i> Asset</a></li>
			<li><a
				href="${pageContext.request.contextPath }/management/parking-lot/#"><i
					class="fa fa-car"></i> Parking lot</a>
				<ul class="treeview-menu">
					<li><a
						href="${pageContext.request.contextPath }/management/parking-lot/parking-lot-list.html"><i
							class="fa fa-circle-o"></i> Parking Lot List</a></li>
					<li><a
						href="${pageContext.request.contextPath }/management/parking-lot/car-list.html"><i
							class="fa fa-circle-o"></i> Car List</a></li>
					<li><a
						href="${pageContext.request.contextPath }/management/parking-lot/check-in-out-car.html"><i
							class="fa fa-circle-o"></i> Check in/out Car</a></li>
				</ul></li>
			<li class="treeview"><a
				href="${pageContext.request.contextPath }/management/report-statistics/#">
					<i class="fa fa-line-chart"></i> <span> Report
						&nbsp;&amp;&nbsp; Statistics</span> <i
					class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li><a
						href="${pageContext.request.contextPath }/management/report-statistics/report-list.html"><i
							class="fa fa-circle-o"></i> Report</a></li>
					<li><a
						href="${pageContext.request.contextPath }/management/report-statistics/statistics-list.html"><i
							class="fa fa-circle-o"></i> Statistics</a></li>
				</ul></li>
			<li><a
				href="${pageContext.request.contextPath }/management/user/user-list.html"><i
					class="fa fa-user-plus"></i> User</a></li>
			<li><a
				href="${pageContext.request.contextPath }/management/setting.html">
					<i class="fa fa-cogs"></i> <span>Setting</span>
			</a></li>
			<li class="header">USER GUIDE</li>
			<!-- <li><a href="${pageContext.request.contextPath }/#"><i class="fa fa-circle-o text-danger"></i>
					Important</a></li>
			<li><a href="${pageContext.request.contextPath }/#"><i class="fa fa-circle-o text-warning"></i>
					Warning</a></li>
			<li><a href="${pageContext.request.contextPath }/#"><i class="fa fa-circle-o text-info"></i>
					Information</a></li> -->
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>
