<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<link rel="stylesheet"
	href="<c:url value="/resources/css/colorbox.css"/>" />

<jsp:include page="Adminheader.jsp"></jsp:include>
<div class="mainbody">
	<br />



	<jsp:include page="AdminPaginationheader.jsp"></jsp:include>
	<!-- data -->
	<div class="box text-shadow">
		<table class="demo-tbl">
			<thead>
				<tr>
					<th><spring:message code="label.recno" /></th>
					<th><spring:message code="label.name" /></th>
					<th><spring:message code="label.fullview" /></th>
					<th><spring:message code="label.approve" /></th>
					<th><spring:message code="label.delete" /></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fun:length(data) > 0}">
					<c:forEach items="${data}" var="app">

						<tr class="tbl-item">


							<!-- data -->
							<td class="td-block">

								<p class="title">${app.RecNo}</p>

							</td>
							<td><p class="desc">${app.Name}</td>

							<td class="td-block">
								<p>
									<a href="<c:url value="/Admin/address/${app.id}"/>"
										id="fullview"><spring:message code="label.view" /></a>
								</p>
							</td>

							<td class="td-block">
								<p>
									<a href="<c:url value="/Admin/address/approve/${app.id}"/>"><spring:message
											code="label.approve" /></a>
								</p>
							</td>
							<td class="td-block">

								<p>
									<a href="<c:url value="/Admin/address/delete/${app.id}"/>"
										onclick="return confirmDelete()"><spring:message
											code="label.delete" /></a>
								</p>
							</td>

						</tr>
					</c:forEach>
				</c:if>
			</tbody>

		</table>


	</div>

	<jsp:include page="AdminPaginationfooter.jsp"></jsp:include>


	<script src="<c:url value="/resources/js/jquery.colorbox.js"/>"></script>
	<script>
		$(document).ready(function() {
			$(document).on('click', '#fullview', function(e) {
				e.preventDefault();
				$.colorbox({
					href : $(this).attr('href'),

				});
			});
		});
	</script>

</div>
<jsp:include page="Adminfooter.jsp"></jsp:include>
