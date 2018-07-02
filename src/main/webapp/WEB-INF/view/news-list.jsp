<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" charset="utf-8">
<title>Starhotel</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link rel="shortcut icon" href="favicon.ico">

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

	<!-- Parallax Effect -->
	<script type="text/javascript">
		$(document).ready(function() {
			$('#parallax-pagetitle').parallax("50%", -0.55);
		});
	</script>

	<section class="parallax-effect">
		<div id="parallax-pagetitle"
			style="background-image: url(./images/parallax/parallax-01.jpg);">
			<div class="color-overlay">
				<!-- Page title -->
				<div class="container">
					<div class="row">
						<div class="col-sm-12">
							<ol class="breadcrumb">
								<li><a
									href="${pageContext.request.contextPath }/index.html">Home</a></li>
								<li class="active">News</li>
							</ol>
							<h1>News</h1>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<div class="container">
		<div class="row">
			<!-- Blog -->
			<section class="blog mt50">
				<div class="col-md-9">
					<!-- Article Video -->
					<%-- <article>
						<div class="video-format">
							<iframe src="http://player.vimeo.com/video/89409343"></iframe>
						</div>
						<div class="row">
							<div class="col-sm-1 col-xs-2 meta">
								<div class="meta-date">
									<span>Apr</span>15
								</div>
							</div>
							<div class="col-sm-11 col-xs-10 meta">
								<h2>
									<a href="${pageContext.request.contextPath }/news-detail.html#">This is a video post</a>
								</h2>
								<span class="meta-author"><i class="fa fa-user"></i><a
									href="${pageContext.request.contextPath }/blog.html#">Starhotel</a></span> <span class="meta-category"><i
									class="fa fa-pencil"></i><a href="${pageContext.request.contextPath }/blog.html#">Hotel
										business</a></span> <span class="meta-comments"><i
									class="fa fa-comment"></i><a href="${pageContext.request.contextPath }/blog.html#">3 Comments</a></span>
								<p class="intro">Lorem ipsum dolor sit amet, consectetur
									adipiscing elit. Curabitur sed turpis neque. In auctor, odio
									eget luctus lobortis, sapien erat blandit felis, eget volutpat
									augue felis in purus. Aliquam ultricies est id ultricies
									facilisis. Maecenas tempus...</p>
								<a href="${pageContext.request.contextPath }/news-detail.html#" class="btn btn-primary pull-right">Read
									More</a>
							</div>
						</div>
					</article> --%>
					<!-- Article Image-->
					<c:forEach var="news" items="${listNews.content }">
						<article>
							<a
								href="${pageContext.request.contextPath }/news-detail.html?id=${news.id }"
								class="mask"><img
								src="${pageContext.request.contextPath }/resources/${news.images[0].imagePath }"
								alt="image" class="img-responsive zoom-img"></a>
							<div class="row">
								<div class="col-sm-1 col-xs-2 meta">
									<div class="meta-date">
										<span><fmt:formatDate value="${news.postedDate }"
												pattern="MMM" /> </span>
										<fmt:formatDate value="${news.postedDate }" pattern="dd" />
									</div>
								</div>
								<div class="col-sm-11 col-xs-10 meta">
									<h2>
										<a
											href="${pageContext.request.contextPath }/news-detail.html?id=${news.id }">${news.title }</a>
									</h2>
									<span class="meta-author"><i class="fa fa-user"></i><a
										href="${pageContext.request.contextPath }/news-detail.html?id=${news.id }#author">${news.employeeAccount.nickName }</a></span>
									<span class="meta-category"><i class="fa fa-pencil"></i><a
										href="${pageContext.request.contextPath }/category/${news.category.name}-${news.category.id}/news-list.html">${news.category.name }</a></span> <span class="meta-comments"><i
										class="fa fa-comment"></i><a
										href="${pageContext.request.contextPath }/news-detail.html?id=${news.id }#comment">${fn:length(news.comments) }
											Comments</a></span>
									<p class="intro">${news.shortDescription }</p>
									<a
										href="${pageContext.request.contextPath }/news-detail.html?id=${news.id }"
										class="btn btn-primary pull-right">Read More</a>
								</div>
							</div>
						</article>
					</c:forEach>
					<!-- Article Audio-->
					<%-- <article>
						<iframe height="166"
							src="https://w.soundcloud.com/player/?url=https://soundcloud.com/slashdown/slashdown-happy-thoughts&amp;show_comments=false"></iframe>
						<div class="row">
							<div class="col-sm-1 col-xs-2 meta">
								<div class="meta-date">
									<span>Apr</span>12
								</div>
							</div>
							<div class="col-sm-11 col-xs-10 meta">
								<h2>
									<a href="${pageContext.request.contextPath }/news-detail.html#">Audio included post</a>
								</h2>
								<span class="meta-author"><i class="fa fa-user"></i><a
									href="${pageContext.request.contextPath }/blog.html#">Starhotel</a></span> <span class="meta-category"><i
									class="fa fa-pencil"></i><a href="${pageContext.request.contextPath }/blog.html#">Hotel
										business</a></span> <span class="meta-comments"><i
									class="fa fa-comment"></i><a href="${pageContext.request.contextPath }/blog.html#">3 Comments</a></span>
								<p class="intro">Lorem ipsum dolor sit amet, consectetur
									adipiscing elit. Curabitur sed turpis neque. In auctor, odio
									eget luctus lobortis, sapien erat blandit felis, eget volutpat
									augue felis in purus. Aliquam ultricies est id ultricies
									facilisis. Maecenas tempus...</p>
								<a href="${pageContext.request.contextPath }/news-detail.html#" class="btn btn-primary pull-right">Read
									More</a>
							</div>
						</div>
					</article> --%>
					<!-- Article Slider-->
					<%-- <article>
						<section class="standard-slider">
							<div id="owl-standard" class="owl-carousel">
								<div class="item">
									<a href="${pageContext.request.contextPath }/news-detail.html#"><img src="${pageContext.request.contextPath }/resources/images/blog/slide1.jpg"
										alt="image" class="img-responsive zoom-img"></a>
								</div>
								<div class="item">
									<a href="${pageContext.request.contextPath }/news-detail.html#"><img src="${pageContext.request.contextPath }/resourcesimages/blog/slide3.jpg"
										alt="image" class="img-responsive zoom-img"></a>
								</div>
							</div>
						</section>
						<div class="row">
							<div class="col-md-1 col-xs-2 meta">
								<div class="meta-date">
									<span>Apr</span>9
								</div>
							</div>
							<div class="col-md-11 col-xs-10 meta">
								<h2>
									<a href="${pageContext.request.contextPath }/news-detail.html#">And this is a slider post</a>
								</h2>
								<span class="meta-author"><i class="fa fa-user"></i><a
									href="${pageContext.request.contextPath }/blog.html#">Starhotel</a></span> <span class="meta-category"><i
									class="fa fa-pencil"></i><a href="${pageContext.request.contextPath }/blog.html#">Hotel
										business</a></span> <span class="meta-comments"><i
									class="fa fa-comment"></i><a href="${pageContext.request.contextPath }/blog.html#">3 Comments</a></span>
								<p class="intro">Lorem ipsum dolor sit amet, consectetur
									adipiscing elit. Curabitur sed turpis neque. In auctor, odio
									eget luctus lobortis, sapien erat blandit felis, eget volutpat
									augue felis in purus. Aliquam ultricies est id ultricies
									facilisis. Maecenas tempus...</p>
								<a href="${pageContext.request.contextPath }/news-detail.html#" class="btn btn-primary pull-right">Read
									More</a>
							</div>
						</div>  class=""
					</article> --%>
					<c:set scope="request" value="${empty param.page ? 1 : param.page }" var="page"/>
					<!-- Pagination -->
					<div class="text-center mt50">
						<ul class="pagination clearfix">
							<li ${page - 1 <= 0 ? "class='disabled'" : "" }><a
								href='${pageContext.request.contextPath }${url }${page - 1 <= 0 ? "#" : "?page=".concat(page - 1)}'>«</a></li>
							<c:forEach begin="1" end="${listNews.totalPages}" varStatus="i">
								<li ${i.count == page ?  "class='active'" : ""} ><a
									href="${pageContext.request.contextPath }${url }?page=${i.count }">${i.count }</a></li>
							</c:forEach>
							<li ${page + 1 > listNews.totalPages ? "class='disabled'" : "" }><a href='${pageContext.request.contextPath }${url }${page + 1 > listNews.totalPages ? "#" : "?page=".concat(page + 1)}'>»</a></li>
						</ul>
					</div>
				</div>
			</section>

			<!-- Aside -->
			<c:import url="asideNews.jsp" />
		</div>
	</div>

	<!-- Call To Action -->
	<section id="call-to-action" class="mt100">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-sm-8 col-xs-12"></div>
				<div class="col-md-4 col-sm-4 col-xs-12"></div>
			</div>
		</div>
	</section>

	<!-- Footer -->
	<c:import url="footer.jsp" />

	<!-- Go-top Button -->
	<div id="go-top">
		<i class="fa fa-angle-up fa-2x"></i>
	</div>

	<script type="text/javascript">
		$(document).ready(function(e) {
			$('.disabled').on('click', function(e) {
				e.preventDefault();
			});
			$('.active').on('click', function(e) {
				e.preventDefault();
			});
		});
	</script>
</body>
</html>