<jsp:include page="/WEB-INF/view/template/Header.jsp" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@page isELIgnored="false"%>

<security:authorize access="hasAuthority('ROLE_ADMIN')">
<jsp:forward page="/adminHome" />
</security:authorize>

<c:if test="${LoginClicked==true}">
	<jsp:include page="Login.jsp"></jsp:include>
</c:if>

<c:if test="${RegisterClicked==true}">
	<jsp:include page="Register.jsp"></jsp:include>
</c:if>

<!-- CAROUSEL -->

<div class="container">
	<!-- Indicators -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="resources/images/carousalbmw.jpg" alt="BMW" width="1778"
					height="1000" class="img-responsive">
				<div class="carousel-caption">
					<h3>BMW M3</h3>
					<p>
						The BMW M3 is a high-performance version of the BMW 3 Series, <br>developed
						by BMW's in-house motorsport division, BMW M.
					</p>
				</div>
			</div>
			<div class="item">
				<img src="resources/images/carousalaudi.jpg" alt="Audi" width="1778"
					height="1000" class="img-responsive">
				<div class="carousel-caption">
					<h3>AUDI RS7</h3>
					<p>
						Cloaked in luxury, the 2017 Audi RS 7 is a definitive statement on
						performance <br> powered by racing technology, yet elegantly
						refined for the road.
					</p>
				</div>
			</div>
			<div class="item">
				<img src="resources/images/carousalmerc.jpg" alt="Merc" width="1778"
					height="1000" class="img-responsive">
				<div class="carousel-caption">
					<h3>Mercedes-AMG GTR</h3>
					<p>
						Developed in the Green Hell: never before has Mercedes AMG <br>
						packed so much motorsport technology into a production vehicle
						than into the new AMG GT R.
					</p>
				</div>
			</div>
		</div>
		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="fa fa-angle-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span class="fa fa-angle-right"
			aria-hidden="true"></span> <span class="sr-only">Next</span>
		</a>
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
	</div>
</div>

<!-- END CAROUSEL -->
<br>
<br>
<br>
<!-- DIVIDED COLUMNS -->
<div class="container-fluid">
	<div class="row grid-divider">
		<a href="${pageContext.request.contextPath}/allProducts/BMW">
			<div class="col-sm-4">
				<div class="col-padding">
					<h3>
						BMW <img alt="logo" width="25" height="25"
							src="resources/images/BMW_Logo.jpg">
					</h3>
					<div>
						<img src="resources/images/dividerbmw.jpg" width="400"
							height="250">
					</div>
				</div>
			</div>
		</a><a href="${pageContext.request.contextPath}/allProducts/AUDI">
			<div class="col-sm-4">
				<div class="col-padding">
					<h3>
						AUDI <img alt="logo" width="40" height="25"
							src="resources/images/AUDI_Logo.jpg">
					</h3>
					<div>
						<img src="resources/images/divideraudi.jpg" width="400"
							height="250">
					</div>
				</div>
			</div>
		</a><a href="${pageContext.request.contextPath}/allProducts/MERCEDES">
			<div class="col-sm-4">
				<div class="col-padding">
					<h3>
						MERCEDES <img alt="logo" width="50" height="30"
							src="resources/images/MERC_Logo.jpg">
					</h3>
					<div>
						<img src="resources/images/dividermerc.jpg" width="400"
							height="250">
					</div>
				</div>
			</div>
		</a>
	</div>
</div>
<!-- END DIVIDED COLUMNS-->
<br>
<jsp:include page="/WEB-INF/view/template/Footer.jsp" />