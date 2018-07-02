<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" uri="http://www.springframework.org/tags" %>
<div class="navbar yamm navbar-default" id="sticky">
	<div class="container">
		<div class="navbar-header">
			<button type="button" data-toggle="collapse"
				data-target="#navbar-collapse-grid" class="navbar-toggle">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="${pageContext.request.contextPath }/index.html" class="navbar-brand"> <!-- Logo --> <span
				id="logo"> <img id="default-logo" src="${pageContext.request.contextPath }/resources/images/logo.png"
					alt="Starhotel" style="height: 44px;" /> <img id="retina-logo"
					src="${pageContext.request.contextPath }/resources/images/logo-retina.png" alt="Starhotel" style="height: 44px;" />
			</span>
			</a>
		</div>
		<div id="navbar-collapse-grid" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="${pageContext.request.contextPath }/index.html"><tag:message code="label.home"/></a></li>
				<li class="dropdown"><a href="${pageContext.request.contextPath }/index.html#"
					data-toggle="dropdown" class="dropdown-toggle js-activated"><tag:message code="label.apartment"/><b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath }/apartment-list.html"><span>All Apartments</span></a></li>
						<c:forEach var="apartmentType" items="${listApartmentType }" >
						<li><a href="${pageContext.request.contextPath }/Apartment-Type/${apartmentType.name }-${apartmentType.id }/apartment-list.html">${apartmentType.name }</a></li>
						</c:forEach>
					</ul></li>
				
				<!-- <li class="dropdown"><a href="${pageContext.request.contextPath }/index.html#"
					data-toggle="dropdown" class="dropdown-toggle js-activated">Features<b
						class="caret"></b></a>
					<div class="dropdown-menu">
						<div class="yamm-content">
							<div class="row">
								<ul class="col-sm-6 list-unstyled mt20">
									<li>
										<p>
											<strong>Colors</strong>
										</p>
										<ul class="list-unstyled">
											<li class="row">
												<ul class="col-sm-6 list-unstyled">
													<li><a href="${pageContext.request.contextPath }/index.html#" class="styleswitch"
														id="black"><i class="fa fa-circle"
															style="color: #000;"></i> Black</a></li>
													<li><a href="${pageContext.request.contextPath }/index.html#" class="styleswitch"
														id="blue"><i class="fa fa-circle"
															style="color: #057ad4;"></i> Blue</a></li>
													<li><a href="${pageContext.request.contextPath }/index.html#" class="styleswitch"
														id="brown"><i class="fa fa-circle"
															style="color: #A76837;"></i> Brown</a></li>
													<li><a href="${pageContext.request.contextPath }/index.html#" class="styleswitch"
														id="green"><i class="fa fa-circle"
															style="color: #7ec923;"></i> Green</a></li>
												</ul>
												<ul class="col-sm-6 list-unstyled">
													<li><a href="${pageContext.request.contextPath }/index.html#" class="styleswitch"
														id="orange"><i class="fa fa-circle"
															style="color: #dc7b13;"></i> Orange</a></li>
													<li><a href="${pageContext.request.contextPath }/index.html#" class="styleswitch"
														id="purple"><i class="fa fa-circle"
															style="color: #e331bf;"></i> Purple</a></li>
													<li><a href="${pageContext.request.contextPath }/index.html#" class="styleswitch" id="red"><i
															class="fa fa-circle" style="color: #c20808;"></i> Red</a></li>
													<li><a href="${pageContext.request.contextPath }/index.html#" class="styleswitch"
														id="turquoise"><i class="fa fa-circle"
															style="color: #75c5cf;"></i> Turquoise</a></li>
												</ul>
											</li>
										</ul>
									</li>
								</ul>
							</div>
						</div>
					</div></li> -->
				<li><a href="${pageContext.request.contextPath }/service-list.html"><tag:message code="label.service"/></a></li>	
				<li><a href="${pageContext.request.contextPath }/news-list.html"><tag:message code="label.news"/></a></li>
				<li><a href="${pageContext.request.contextPath }/gallery.html"><tag:message code="label.gallery"/></a></li>
				<li class="dropdown"><a href="index.html#"
					data-toggle="dropdown" class="dropdown-toggle js-activated"><tag:message code="label.contact"/><b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath }/about-us.html"><tag:message code="label.aboutUs"/></a></li>
						<li><a href="${pageContext.request.contextPath }/contact.html"><tag:message code="label.contactUs"/></a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</div>