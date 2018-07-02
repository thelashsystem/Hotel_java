<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" charset="utf-8">
<title>Starhotel</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

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
			style="background-image: url(${pageContext.request.contextPath }/resources/images/parallax/parallax-01.jpg);">
			<div class="color-overlay">
				<!-- Page title -->
				<div class="container">
					<div class="row">
						<div class="col-sm-12">
							<ol class="breadcrumb">
								<li><a
									href="${pageContext.request.contextPath }/index.html">Home</a></li>
								<li><a href="${pageContext.request.contextPath }/blog.html">News</a></li>
								<li class="active">News Detail</li>
							</ol>
							<h1>News Detail</h1>
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
					<!-- Article -->
					<article>
						<!-- <div class="video-format">
							<iframe src="http://player.vimeo.com/video/89409343"></iframe>
						</div> -->
						<div class="row">
							<div class="col-sm-1 col-xs-2 meta">
								<div class="meta-date">
									<span><fmt:formatDate value="${news.postedDate }"
											pattern="MMM" /> </span>
									<fmt:formatDate value="${news.postedDate }" pattern="dd" />
								</div>
							</div>
							<div class="col-sm-11 col-xs-10 meta">
								<h2>${news.title }</h2>
								<span class="meta-author"><i class="fa fa-user"></i><a
									href="${pageContext.request.contextPath }/news-detail.html?id=${news.id }#author">${news.employeeAccount.nickName }</a></span>
								<span class="meta-category"><i class="fa fa-pencil"></i><a
									href="${pageContext.request.contextPath }/category/${news.category.name }-${news.category.id}/news-list.html">${news.category.name }</a></span>
								<span class="meta-comments"><i class="fa fa-comment"></i><a
										href="${pageContext.request.contextPath }/news-detail.html?id=${news.id }#comment">${fn:length(news.comments) }
											Comments</a></span>
							</div>
							<div class="col-md-12">
								${news.content }
								<%-- <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Curabitur sed turpis neque. In auctor, odio eget luctus
									lobortis, sapien erat blandit felis, eget volutpat augue felis
									in purus. Aliquam ultricies est id ultricies facilisis.
									Maecenas tempus...</p>
								<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
									Sed feugiat tristique mauris, vitae ultrices mauris ultricies
									eu. In viverra ut sem eget venenatis. Sed nec ligula non eros
									ultrices euismod. Lorem ipsum dolor sit amet, consectetur
									adipiscing elit. Cras eget arcu imperdiet, semper dolor in,
									lacinia augue. Mauris hendrerit vestibulum lorem, non auctor
									felis dignissim vel. Sed arcu est, posuere pulvinar arcu non,
									porttitor consequat ligula. Curabitur ac volutpat mauris. Duis
									pretium commodo accumsan. Nullam ut facilisis velit.</p>
								<blockquote>
									<p>
										<em>"Lorem ipsum dolor sit amet, consectetur adipiscing
											elit. Integer posuere erat a ante."</em>
									</p>
									<span>John Doe in <cite title="Source Title">CEO
											Travel</cite></span>
								</blockquote>
								<p>Donec sit amet urna eu nisi egestas iaculis sed ac massa.
									Morbi interdum nibh sapien, non fermentum diam laoreet quis.
									Maecenas congue, nibh id placerat lacinia, nisi felis dictum
									risus, at commodo nisl quam ac libero. Fusce imperdiet vehicula
									luctus. Sed at auctor ligula. Phasellus a commodo dui, at
									iaculis odio. Mauris diam eros, tempor at neque eget, imperdiet
									facilisis mauris. Donec adipiscing nisi vel nisl tristique
									fermentum. Quisque ultrices justo vitae massa mollis, eu
									ultricies tortor varius. Nam auctor viverra sodales.
									Suspendisse ac lobortis sem. Nunc pretium molestie mauris in
									aliquet. Sed vitae ante porttitor mi condimentum eleifend. Duis
									at dictum libero, vel pellentesque enim.</p> --%>
							</div>
						</div>
					</article>

					<!-- Blog: Author -->
					<section class="blog-author clearfix" id="author">
						<h3>
							<!-- About the author: <span>Gigi Adriano</span> src="${pageContext.request.contextPath }/resources/images/blog/author-01.jpg" -->
							About the author: <span>${news.employeeAccount.employee.profile.lastName }
								${news.employeeAccount.employee.profile.firstName }</span>
						</h3>
						<img
							src="${pageContext.request.contextPath }/resources/${news.employeeAccount.avatar }"
							alt="Author" class="img-circle" />
						<!-- <p>Proin venenatis, diam in iaculis venenatis, ante lacus
							dictum dolor, sed laoreet nisl dui vel magna. Cras pulvinar
							tortor quis dolor viverra vel scelerisque magna suscipit.
							Maecenas nec placerat augue. Cras feugiat imperdiet nulla ut
							feugiat. Vestibulum nunc enim, consequat ac euismod vel, commodo
							eget nulla. Donec augue est, consectetur posuere dapibus non,
							aliquam tempor ligula. Suspendisse potenti. Cras vel vestibulum
							dolor L.orem ipsum dolor sit amet, consectetur adipiscing elit.
							Curabitur sed turpis neque. In auctor, odio eget luctus lobortis!</p> -->
						<p>${news.employeeAccount.biography }</p>
					</section>

					<!-- News: Comments -->
					<section class="comments mt50" id="comment">
						<div class="blog-comments">
							<h2 class="lined-heading">
								<span><i class="fa fa-comments"></i>${fn:length(news.comments) }
									Comments</span>
							</h2>
						</div>
						<!-- Comment 1 -->
						<c:forEach var="comment" items="${news.comments }">
							<c:if test="${empty comment.reply  }">
								<div class="comment">
									<a href="${pageContext.request.contextPath }/news-detail.html#">
										<span class="reply-button">Reply</span>
									</a>
									<div class="avatar">
										<img
											src="${pageContext.request.contextPath }/resources/images/blog/comment-01.jpg"
											alt="comment-01" class="img-circle" />
									</div>
									<div class="comment-text">
										<div class="author">
											<div class="name">Grandpa</div>
											<div class="date pull-left">
												<fmt:formatDate value="${comment.postedDate }"
													pattern="MMM dd, yyyy" />
												at
												<fmt:formatDate value="${comment.postedDate }"
													pattern="hh:mm a" />
											</div>
											<div class='like-btn  pull-left'>
												<a href="#" class='btn btn-primary btn-xs'
													style="margin: -10px 8px 0 10px"><i
													class='fa fa-thumbs-up'></i></a>
											</div>
											<div class='like'>
												<span style="color: red">&nbsp;${comment.likes }</span>
											</div>
										</div>
										<div class="text">
											<p>${comment.content }</p>
										</div>
									</div>
								</div>
							</c:if>

							<c:if test="${not empty comment.replies  }">
								<c:forEach var="subComment" items="${comment.replies }">
									<div class="reply-line" style="height: 108px"></div>
									<div class="reply">
										<div class="comment">
											<a
												href="${pageContext.request.contextPath }/news-detail.html#">
												<span class="reply-button">Reply</span>
											</a>

											<div class="avatar">
												<img
													src="${pageContext.request.contextPath }/resources/images/blog/comment-02.jpg"
													alt="comment-02" class="img-circle" />
											</div>
											<div class="comment-text">
												<div class="author">
													<div class="name">Hoo Lang</div>
													<div class="date pull-left">
														<fmt:formatDate value="${comment.postedDate }"
															pattern="MMM dd, yyyy 'at' hh:mm a" />
													</div>
													<div class='like-btn  pull-left'>
														<a href="#" class='btn btn-primary btn-xs'
															style="margin: -10px 8px 0 10px"><i
															class='fa fa-thumbs-up'></i></a>
													</div>
													<div class='like'>
														<span style="color: red">&nbsp;${subComment.likes }</span>
													</div>
												</div>

												<div class="text">
													<p>${subComment.content }</p>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</c:if>

						</c:forEach>
						<!-- Comment 2(Reply) -->

						<!-- Comment 3 -->
						<%-- <div class="comment">
							<a href="${pageContext.request.contextPath }/news-detail.html#">
								<span class="reply-button">Reply</span>
							</a>
							<div class="avatar">
								<img
									src="${pageContext.request.contextPath }/resources/images/blog/comment-03.jpg"
									alt="comment-03" class="img-circle" />
							</div>
							<div class="comment-text">
								<div class="author">
									<div class="name">Gigi Adriano</div>
									<div class="date">Apr 30, 2013 at 3:50 pm</div>
								</div>
								<div class="text">
									<p>Proin venenatis, diam in iaculis venenatis, ante lacus
										dictum dolor, sed laoreet nisl dui vel magna. Cras pulvinar
										tortor quis dolor viverra vel scelerisque magna suscipit.</p>
								</div>
							</div>
						</div> --%>

						<%-- <!-- Comment 1 -->
						<div class="comment">
							<a href="${pageContext.request.contextPath }/news-detail.html#">
								<span class="reply-button">Reply</span>
							</a>
							<div class="avatar">
								<img
									src="${pageContext.request.contextPath }/resources/images/blog/comment-01.jpg"
									alt="comment-01" class="img-circle" />
							</div>
							<div class="comment-text">
								<div class="author">
									<div class="name">Grandpa</div>
									<div class="date">Apr 30, 2013 at 3:20 pm</div>
								</div>
								<div class="text">
									<p>Proin venenatis, diam in iaculis venenatis, ante lacus
										dictum dolor, sed laoreet nisl dui vel magna. Cras pulvinar
										tortor quis dolor viverra vel scelerisque magna suscipit.</p>
								</div>
							</div>
						</div>
						<!-- Comment 2(Reply) -->
						<div class="reply-line"></div>
						<div class="reply">
							<div class="comment">
								<a href="${pageContext.request.contextPath }/news-detail.html#">
									<span class="reply-button">Reply</span>
								</a>
								<div class="avatar">
									<img
										src="${pageContext.request.contextPath }/resources/images/blog/comment-02.jpg"
										alt="comment-02" class="img-circle" />
								</div>
								<div class="comment-text">
									<div class="author">
										<div class="name">Hoo Lang</div>
										<div class="date">Apr 30, 2013 at 3:45 pm</div>
									</div>
									<div class="text">
										<p>Proin venenatis, diam in iaculis venenatis, ante lacus
											dictum dolor, sed laoreet nisl dui vel magna. Cras pulvinar
											tortor quis dolor viverra vel scelerisque magna suscipit.</p>
									</div>
								</div>
							</div>
						</div>
						<!-- Comment 3 -->
						<div class="comment">
							<a href="${pageContext.request.contextPath }/news-detail.html#">
								<span class="reply-button">Reply</span>
							</a>
							<div class="avatar">
								<img
									src="${pageContext.request.contextPath }/resources/images/blog/comment-03.jpg"
									alt="comment-03" class="img-circle" />
							</div>
							<div class="comment-text">
								<div class="author">
									<div class="name">Gigi Adriano</div>
									<div class="date">Apr 30, 2013 at 3:50 pm</div>
								</div>
								<div class="text">
									<p>Proin venenatis, diam in iaculis venenatis, ante lacus
										dictum dolor, sed laoreet nisl dui vel magna. Cras pulvinar
										tortor quis dolor viverra vel scelerisque magna suscipit.</p>
								</div>
							</div>
						</div> --%>
						<!-- Leave comment -->
						<div class="mt50">
							<h3>
								<i class="fa fa-comment"></i> Leave a comment
							</h3>
							<form role="form" class="mt30"
								action="${pageContext.request.contextPath }/commentNews">
								<div class="form-group">
									<label for="email">Your Email address</label> <input
										type="email" class="form-control" id="email" name="email"
										placeholder="Enter email" required />
								</div>
								<div class="form-group">
									<label for="name"><span class="required">*</span> Your
										Name</label> <input type="text" class="form-control" id="name"
										placeholder="Enter name" required />
								</div>
								<div class="form-group">
									<label for="txtComment"><span class="required">*</span>
										Your comment</label>
									<textarea name="comment" rows="9" id="txtComment"
										class="form-control" required></textarea>
								</div>
								<button type="submit" class="btn btn-default btn-lg">Post
									comment</button>
							</form>
						</div>
					</section>
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

</body>
</html>