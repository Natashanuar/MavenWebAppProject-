<jsp:include page="/WEB-INF/view/template/Header.jsp" />

<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<center>
	<br>
	<fm:form action="${pageContext.request.contextPath}/registerProduct"
		modelAttribute="product" method="post" enctype="multipart/form-data">
		<h4>REGISTER A NEW PRODUCT :</h4>
		<table>
			<c:if test="${not empty product.name }">
				<tr>
					<td>ID of the product:</td>
					<td><fm:input path="id" name="id" type="text" readonly="true" /></td>
				</tr>
			</c:if>
			<tr>
				<td>Name of the product:</td>
				<td><fm:input path="name" type="text" name="name"
						required="true" /></td>
			</tr>
			<tr>
				<td>Description of the product:</td>
				<td><fm:input path="desc" type="text" name="desc"
						required="true" /></td>
			</tr>
			<tr>
				<td>Price of the product:</td>
				<td><fm:input path="price" type="text" name="price"
						required="true" /></td>
			</tr>
			<tr>
				<td>Image of the product:</td>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td>Brand of the Product:</td>
				<td><fm:select path="brandId">
						<c:forEach var="brand" items="${brandList}">
							<fm:option value="${brand.name}">${brand.name}</fm:option>
						</c:forEach>
					</fm:select></td>
			</tr>
			<tr>
				<td>Supplier of the Product:</td>
				<td><fm:select path="supplierId">
						<c:forEach var="supplier" items="${supplierList}">
							<fm:option value="${supplier.name}">${supplier.name}</fm:option>
						</c:forEach>
					</fm:select></td>
			</tr>
			<tr>
				<c:if test="${empty product.name }">
					<td><input type="submit" value="Add product"></td>
				</c:if>
				<c:if test="${not empty product.name }">
					<td><input type="submit" value="Edit product"></td>
				</c:if>
		</table>
	</fm:form>
</center>
<br>
<br>

<h4>
	<b>&nbsp;&nbsp;&nbsp;LIST OF ALL THE PRODUCTS IN THE DATABASE:</b>
</h4>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-3">
			<form action="#" method="get">
				<div class="input-group">
					<!-- USE TWITTER TYPEAHEAD JSON WITH API TO SEARCH -->
					<input class="form-control" id="system-search" name="search"
						placeholder="Search for" required> <span
						class="input-group-btn">
						<button type="submit" class="btn btn-default">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</span>
				</div>
			</form>
		</div>
		<br> <br> <br>
		<div class="col-md-9">
			<table class="table table-list-search">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Description</th>
						<th>Price</th>
						<th>BrandName</th>
						<th>SupplierName</th>
						<th colspan="2">Modify</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="product" items="${productList}">
						<tr>
							<td>${product.id}</td>
							<td>${product.name}</td>
							<td>${product.desc}</td>
							<td>${product.price}</td>
							<td>${product.brandId}</td>
							<td>${product.supplierId}</td>
							<td><a href="<c:url value='/editProduct/${product.id}'/>">Edit</a></td>
							<td><a href="<c:url value='/deleteProduct/${product.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/template/Footer.jsp" />