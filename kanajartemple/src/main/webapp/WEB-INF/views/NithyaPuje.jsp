<%@include file="/WEB-INF/views/tagdefinition.jsp"%>

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
<h1> This page is under construction .Sorry for any inconvenience this may cause</h1>
<p>If you want to update address ,please send the information in below format to shreebrahmalingeshwara@kanajartemple.com<br/>
Name 				:<br/>
Address to Update 	:<br/>
Pooje Date			:<br/>
Email				:<br/>
Mobile No 			:<br/>
<p>
</div>
<%-- <div class="mainbody">
	<br />
	<center>
		<h1><spring:message code="label.nithyapooje.header" /></h1>
	</center>

	<!--Pagination Header  -->

	<jsp:include page="admin/AdminPaginationheader.jsp" />


	<!-- data -->
	<div class="box text-shadow">
		<table class="demo-tbl">
			<thead>
				<tr>
					<th><spring:message code="label.recno"/></th>
					<th><spring:message code="label.name"/></th>
					<th><spring:message code="label.poojedate"/></th>
					<th><spring:message code="label.edit"/></th>

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
										id="nithyaPoojeUpdate" title="<spring:message code="label.nithyapooje.update"/>">Edit</a>
								</p>
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>

		</table>


	</div>

	<jsp:include page="admin/AdminPaginationfooter.jsp"></jsp:include>
</div> --%>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>


<script src="<c:url value="/resources/js/jquery.colorbox.js"/>"></script>
<script>
	$(document).ready(function() {
		$(document).on('click', '#nithyaPoojeUpdate', function(e) {
			e.preventDefault();
			$.colorbox({
				title : $(this).attr('title'),
				href : $(this).attr('href'),
				iframe : true,
				width : "415px",
				height : "450px",				
			});
		});
	});
</script>

<c:if test="${success}">

</c:if>
