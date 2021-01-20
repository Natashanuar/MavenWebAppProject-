<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@page isELIgnored="false"%>

<html>
<head>

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<jsp:include page="/WEB-INF/view/template/css.jsp" />
<jsp:include page="/WEB-INF/view/template/js.jsp" />

</head>
<body>
	<header>
		<div class="container-fluid">
			<nav class="navbar navbar-inverse">
				<div class="navbar-header">
					<button class="navbar-toggle" type="button" data-toggle="collapse"
						data-target=".js-navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand"
						href="${pageContext.request.contextPath}/home"> <i
						class="fa fa-car" aria-hidden="true"></i> AutoTraderIN
					</a>
				</div>
				<div class="collapse navbar-collapse js-navbar-collapse">
					<ul class="nav navbar-nav">
						<li class="dropdown mega-dropdown"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown">Products <span
								class="caret"></span></a>
							<ul class="dropdown-menu mega-dropdown-menu">
								<c:forEach var="brand" items="${brandList}">
									<li class="col-sm-3">
										<ul>
											<li class="dropdown-header">${brand.name}</li>
											<c:forEach var="product" items="${productList}">
												<c:if test="${brand.name == product.brandId}">
													<li><a
														href="${pageContext.request.contextPath}/productDetails/${product.id}">${product.name}</a></li>
												</c:if>
											</c:forEach>
											<li class="divider"></li>
											<li><a
												href="${pageContext.request.contextPath}/allProducts/${brand.name}">View
													all ${brand.name} Products <span
													class="glyphicon glyphicon-chevron-right pull-right"></span>
											</a></li>
										</ul>
									</li>
								</c:forEach>
							</ul></li>
						<li><a href="${pageContext.request.contextPath}/aboutus">About
								Us <i class="fa fa-info-circle" aria-hidden="true"></i>
						</a></li>
						<security:authorize access="hasAuthority('ROLE_ADMIN')">
							<li class="dropdown"><a
								href="${pageContext.request.contextPath}/adminHome"
								class="dropdown-toggle" data-toggle="dropdown" role="button"
								aria-expanded="false">Admin Dashboard <span class="caret"></span>
							</a>
								<ul class="dropdown-menu" role="menu">
									<li><a
										href="${pageContext.request.contextPath}/addProduct">Add
											Product</a></li>
									<li><a href="${pageContext.request.contextPath}/addBrand">Add
											Brand</a></li>
									<li><a
										href="${pageContext.request.contextPath}/addSupplier">Add
											Supplier</a></li>
								</ul></li>
						</security:authorize>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a
							href="${pageContext.request.contextPath}/login"
							class="dropdown-toggle" data-toggle="dropdown" role="button"
							aria-expanded="false"><i class="fa fa-user"
								aria-hidden="true"></i> My Account <span class="caret"></span> </a>
							<ul class="dropdown-menu" role="menu">
								<security:authorize access="isAnonymous()">
									<li><a href="${pageContext.request.contextPath}/login">Login
											<i class="fa fa-sign-in" aria-hidden="true"></i>
									</a></li>
									<li><a href="${pageContext.request.contextPath}/register">Register
											<i class="fa fa-user-plus" aria-hidden="true"></i>
									</a></li>
								</security:authorize>
								<security:authorize access="isAuthenticated()">
									<security:authorize access="hasAuthority('ROLE_USER')">
										<li><a href="${pageContext.request.contextPath}/cart">My
												Cart <i class="fa fa-shopping-cart" aria-hidden="true"></i>
										</a></li>
									</security:authorize>
									<security:authorize access="hasAuthority('ROLE_ADMIN')">
										<li><a
											href="${pageContext.request.contextPath}/adminHome">Admin
												Home <i class="fa fa-home" aria-hidden="true"></i>
										</a></li>
									</security:authorize>
									<li><a href="${pageContext.request.contextPath}/logout">Logout
											<i class="fa fa-sign-out" aria-hidden="true"></i>
									</a></li>
								</security:authorize>
							</ul></li>
					</ul>
				</div>
			</nav>
		</div>
	</header>