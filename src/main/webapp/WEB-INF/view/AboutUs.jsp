<jsp:include page="/WEB-INF/view/template/Header.jsp" />

<link href="https://fonts.googleapis.com/css?family=Oleo+Script:400,700"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Teko:400,700"
	rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

<div id="main" class="container">

	<div class="row">
		<div class="col-md-12">
			<h1>ABOUT US</h1>
			<p>This is about us page of AutoTraderIN.</p>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-12">
			<h3>SiteMap:</h3>
			<ul>
				<li><a href="${pageContext.request.contextPath}/home"><strong>Home</strong></a></li>
				<li><a href="${pageContext.request.contextPath}/aboutus"><strong>About
							Us</strong></a></li>
				<li><a
					href="${pageContext.request.contextPath}/allProducts/BMW"><strong>BMW
							products</strong></a></li>
				<li><a
					href="${pageContext.request.contextPath}/allProducts/AUDI"><strong>AUDI
							products</strong></a></li>
				<li><a
					href="${pageContext.request.contextPath}/allProducts/MERCEDES"><strong>
							MERCEDES products</strong></a></li>
				<li><a href="cart"><strong>Cart</strong></a></li>
			</ul>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/template/Footer.jsp" />