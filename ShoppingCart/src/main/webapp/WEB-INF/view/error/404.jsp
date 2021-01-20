<jsp:include page="/WEB-INF/view/template/Header.jsp"></jsp:include>

<link href="${pageContext.request.contextPath}/resources/css/404.css"
	type="text/css" rel="stylesheet">
<div id="block_error">
	<div>
		<h2>Error 404. Oops you've have encountered an error!</h2>

		<h5>Link: ${pageContext.request.requestURL}</h5>

		<p>
			It appears that the page you're trying to access doesn't exist.<br>
			Please go back to the <a
				href="${pageContext.request.contextPath}/home">Home Page</a> for a
			fresh start.
		</p>

	</div>
</div>
<br>
<jsp:include page="/WEB-INF/view/template/Footer.jsp"></jsp:include>