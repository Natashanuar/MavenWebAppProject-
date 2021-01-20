<jsp:include page="/WEB-INF/view/template/Header.jsp" />

<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<center>
	<br>
	<fm:form action="${pageContext.request.contextPath}/registerSupplier"
		modelAttribute="supplier" method="post">

		<h4>REGISTER A NEW SUPPLIER :</h4>
		<table>
			<tr>
				<td>ID of the supplier:</td>
				<c:choose>
					<c:when test="${not empty supplier.id} ">
						<td><fm:input path="id" type="text" name="id" readonly="true" /></td>
					</c:when>
					<c:otherwise>
						<td><fm:input path="id" type="text" name="id" required="true" /></td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td>Name of the supplier:</td>
				<td><fm:input path="name" type="text" name="name"
						required="true" /></td>
			</tr>
			<tr>
				<td>Address of the supplier:</td>
				<td><fm:input path="address" type="text" name="address"
						required="true" /></td>
			</tr>
			<tr>
				<c:if test="${empty supplier.name }">
					<td><input type="submit" value="Add supplier"></td>
				</c:if>
				<c:if test="${not empty supplier.name }">
					<td><input type="submit" value="Edit supplier"></td>
				</c:if>
			</tr>
		</table>
	</fm:form>
</center>
<br>
<br>

<h4>
	<b>&nbsp;&nbsp;&nbsp;LIST OF ALL THE SUPPLIER IN THE DATABASE:</b>
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
						<th>Address</th>
						<th colspan="2">Modify</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="supplier" items="${supplierList}">
						<tr>
							<td>${supplier.id}</td>
							<td>${supplier.name}</td>
							<td>${supplier.address}</td>
							<td><a href="<c:url value='/editSupplier/${supplier.id}'/>">Edit</a></td>
							<td><a
								href="<c:url value='/deleteSupplier/${supplier.id}'/>">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/template/Footer.jsp" />