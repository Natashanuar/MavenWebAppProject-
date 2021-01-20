<jsp:include page="/WEB-INF/view/template/Header.jsp" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<div class="container">
	<div class="card">
		<div class="container-fluid">
			<div class="wrapper row">
				<div class="preview col-md-6">
					<div class="preview-pic tab-content">
						<div class="tab-pane active" id="pic-1">
							<img
								src="${pageContext.request.contextPath}/resources/images/${product.id}.jpg"
								class="img-responsive" />
						</div>
					</div>
				</div>
				<div class="details col-md-6">
					<h3 class="product-title">${product.brandId}&nbsp${product.name}</h3>
					<div class="rating">
						<div class="stars">
							<span class="fa fa-star checked"></span> <span
								class="fa fa-star checked"></span> <span
								class="fa fa-star checked"></span> <span class="fa fa-star"></span>
							<span class="fa fa-star"></span>
						</div>
						<span class="review-no">41 reviews</span>
					</div>
					<p class="product-description">${product.desc}</p>
					<h4 class="price">
						ex-showroom price: <span>Rs. ${product.price}</span>
					</h4>
					<p class="vote">
						<strong>91%</strong> of buyers enjoyed this product! <strong>(87
							votes)</strong>
					</p>
					<br> <br>
					<div class="action">
						<form
							action="${pageContext.request.contextPath}/cartadd/${product.id}">
							<button class="add-to-cart btn btn-default"
								name="cartadd" id="cartadd" type="submit">add
								to cart</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/template/Footer.jsp" />