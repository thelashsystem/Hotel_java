<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<aside class="mt50">
				<div class="col-md-3">
					<!-- Widget: Text -->
					<div class="widget">
						<h3>About our news</h3>
						<p>
							${setting.descriptionAboutNews }
						</p>
					</div>
					<!-- Widget: Latest news -->
					<div class="widget clearfix">
						<h3>Latest News</h3>
						<ul class="list-unstyled">
							<c:forEach var="lastestNews" items="${list3LastestNews }"
								begin="0" end="2">
								<li>
									<article>
										<div class="news-thumb">
											<a
												href="${pageContext.request.contextPath }/news-detail.html?id=${lastestNews.id }"><img
												src="${pageContext.request.contextPath }/resources/${lastestNews.images[0].imagePath}"
												alt="Popular news" width="71" height="71"></a>
										</div>
										<div class="news-content clearfix" style="min-height: 95px">
											<h4>
												<a
													href="${pageContext.request.contextPath }/news-detail.html?id=${lastestNews.id }">${lastestNews.title }</a>
											</h4>
											<span><a
												href="${pageContext.request.contextPath }/news-detail.html?id=${lastestNews.id }"><fmt:formatDate
														value="${lastestNews.postedDate }" pattern="MMMM dd, yyyy" />
											</a></span>
										</div>
									</article>
								</li>
							</c:forEach>
							<%-- <li>
								<article>
									<div class="news-thumb">
										<a
											href="${pageContext.request.contextPath }/news-detail.html#"><img
											src="${pageContext.request.contextPath }/resources/images/blog/blog-sm-2.jpg"
											alt="Popular news"></a>
									</div>
									<div class="news-content clearfix">
										<h4>
											<a
												href="${pageContext.request.contextPath }/news-detail.html#">An
												image post</a>
										</h4>
										<span><a
											href="${pageContext.request.contextPath }/news-detail.html#">April
												14 2014</a></span>
									</div>
								</article>
							</li>
							<li>
								<article>
									<div class="news-thumb">
										<a
											href="${pageContext.request.contextPath }/news-detail.html#"><img
											src="${pageContext.request.contextPath }/resources/images/blog/blog-sm-3.jpg"
											alt="Popular news"></a>
									</div>
									<div class="news-content clearfix">
										<h4>
											<a
												href="${pageContext.request.contextPath }/news-detail.html#">Audio
												included post</a>
										</h4>
										<span><a
											href="${pageContext.request.contextPath }/news-detail.html#">April
												12 2014</a></span>
									</div>
								</article>
							</li> --%>
						</ul>
					</div>
					<!-- Widget: Categories -->
					<div class="widget">
						<h3>Category</h3>
						<ul class="list-unstyled arrow">
							<c:forEach var="each" items="${countNewsCategory}" >
								<li><a
									href="${pageContext.request.contextPath }/category/${each[1] }-${each[0] }/news-list.html">${each[1]}
										<span class="badge pull-right">${each[2]}</span>
								</a></li>
							</c:forEach>
							<%-- <li><a
								href="${pageContext.request.contextPath }/news-detail.html#">Media
									<span class="badge pull-right">11</span>
							</a></li>
							<li><a
								href="${pageContext.request.contextPath }/news-detail.html#">Marketing
									<span class="badge pull-right">42</span>
							</a></li> --%>
						</ul>
					</div>
					<!-- Widget: Tags -->
					<div class="widget">
						<h3>Tags</h3>
						<div class="tags">
							<a href="${pageContext.request.contextPath }/news-detail.html#">HTML</a>
							<a href="${pageContext.request.contextPath }/news-detail.html#">CSS</a>
							<a href="${pageContext.request.contextPath }/news-detail.html#">Jquery</a>
							<a href="${pageContext.request.contextPath }/news-detail.html#">Modern</a>
							<a href="${pageContext.request.contextPath }/news-detail.html#">Responsive</a>
							<a href="${pageContext.request.contextPath }/news-detail.html#">Wordpress</a>
							<a href="${pageContext.request.contextPath }/news-detail.html#">Fun</a>
							<a href="${pageContext.request.contextPath }/news-detail.html#">Movies</a>
							<a href="${pageContext.request.contextPath }/news-detail.html#">Music</a>
							<a href="${pageContext.request.contextPath }/news-detail.html#">Information</a>
						</div>
					</div>
					<!-- Widget: Archive -->
					<div class="widget">
						<h3>Archive</h3>
						<ul class="list-unstyled arrow">
							<c:forEach var="each" items="${countNewsYearMonth }">
							<li><a
								href="${pageContext.request.contextPath }/archive/${each[0] }/news-list.html">${each[0] } <span class="badge pull-right">${each[1] }</span>
							</a></li>
							</c:forEach>
							<%-- <li><a
								href="${pageContext.request.contextPath }/news-detail.html#">May
									2014 <span class="badge pull-right">9</span>
							</a></li>
							<li><a
								href="${pageContext.request.contextPath }/news-detail.html#">February
									2014 <span class="badge pull-right">3</span>
							</a></li>
							<li><a
								href="${pageContext.request.contextPath }/news-detail.html#">January
									2014 <span class="badge pull-right">5</span>
							</a></li> --%>
						</ul>
					</div>
				</div>
			</aside>