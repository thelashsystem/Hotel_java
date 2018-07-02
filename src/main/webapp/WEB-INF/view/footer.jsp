<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<footer>
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-3">
				<h4>About Starhotel</h4>
				<p>${setting.descriptionAboutUs }</p>
			</div>
			<div class="col-md-3 col-sm-3">
				<h4>Recieve our newsletter</h4>
				<p>Suspendisse sed sollicitudin nisl, at dignissim libero. Sed
					porta tincidunt ipsum, vel volutpa!</p>
				<form role="form" action="${pageContext.request.contextPath }/subcribeNews">
					<div class="form-group">
						<input name="newsletter" type="text" id="newsletter" value="" name="subcriebe"
							class="form-control"
							placeholder="Please enter your E-mailaddress" />
					</div>
					<button type="submit" class="btn btn-lg btn-black btn-block">Submit</button>
				</form>
			</div>
			<div class="col-md-3 col-sm-3">
				<h4>From our blog</h4>
				<ul class="list-unstyled">
					<c:forEach var="lastestNews" items="${list3LastestNews }" begin="0"
						end="2">
						<li>
							<article>
								<a href="${pageContext.request.contextPath }/news-detail.html?id=${lastestNews.id }">${lastestNews.title }<br><fmt:formatDate value="${lastestNews.postedDate }"/>
								</a>
							</article>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div class="col-md-3 col-sm-3">
				<h4>Our Policy</h4>
			</div>
		</div>
		<div class='row mt30'>
			<h4 style="text-align: center">Address</h4>
		</div>
		<div class='row'>
			<c:forEach var="building" items="${listBuilding }">
				<address class='col-md-3'>
					<strong>Name: ${building.name }</strong> <br />
					${building.address.addressName }<br> Ward
					${building.address.wardName }, District
					${building.address.district.name }<br>
					${building.address.district.city.name } city, Viet Nam <br /> <abbr
						title="Phone">P:</abbr> <a
						href="${pageContext.request.contextPath }/contact.html#">${building.phone }</a><br>
					<abbr title="Email">E:</abbr> <a
						href="${pageContext.request.contextPath }/contact.html#">${building.officalEmail }</a><br>
				</address>
			</c:forEach>
		</div>
	</div>
	<div class="footer-bottom">
		<div class="container">
			<div class="row">
				<div class="col-xs-6">&copy; 2014 Starhotel All Rights
					Reserved</div>
				<div class="col-xs-6 text-right">
					<ul>
						<li><a
							href="${pageContext.request.contextPath }/contact.html">Contact</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</footer>