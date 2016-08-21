<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%>


<link rel="stylesheet"
	href="<c:url value="/resources/css/admin/reveal.css"/>" type="text/css" />
<link rel="stylesheet"
	href="<c:url value="/resources/css/colorbox.css"/>" />
<script type="text/javascript"
	src="<c:url value="/resources/js/admin/jquery-1.6.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/admin/jquery.reveal.js"/>"></script>

<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="menu.jsp"></jsp:include>
<div class="mainbody">
	<br />
	<center>
		<h1>Nithya Pooje Address</h1>
	</center>

	<!--Pagination Header  -->

	<jsp:include page="admin/AdminPaginationheader.jsp" />


	<!-- data -->
	<div class="box text-shadow">
		<table class="demo-tbl">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Puja Date</th>
					<th>Full View / Edit</th>

				</tr>
			</thead>
			<tbody>
				<c:if test="${fun:length(NithyaPooje) > 0}">
					<c:forEach items="${NithyaPooje}" var="app">

						<tr class="tbl-item">


							<!-- data -->
							<td class="td-block">

								<p class="title">${app.RecNo}</p>

							</td>
							<td><p class="desc">${app.Name}</td>

							<td><p class="td-block">${app.PDate}</td>

							<td class="td-block">

								<p>
									<a href="<c:url value='/NithyaPooje/update/${app.RecNo}'/>"
										id="nithyaPoojeUpdate">Edit</a>
								</p>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>

		</table>


	</div>

	<jsp:include page="admin/AdminPaginationfooter.jsp"></jsp:include>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>


<script src="<c:url value="/resources/js/jquery.colorbox.js"/>"></script>
<script>
	jQuery(document).ready(function() {
		$(document).on('click', '#nithyaPoojeUpdate', function(e) {
			e.preventDefault();
			$.colorbox({
				title:'Update details',
				href : $(this).attr('href'),
			});
		});
	});
</script>
