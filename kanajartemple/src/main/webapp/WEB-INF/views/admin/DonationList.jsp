<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<jsp:include page="Adminheader.jsp"></jsp:include>
<div class="mainbody">
	<br />

	<center>
		<h1>${DonationName}</h1>
	</center>


	<jsp:include page="AdminPaginationheader.jsp"></jsp:include>





	<!-- data -->
	<div class="box text-shadow">
		<table class="demo-tbl">
			<thead>
				<tr>
					<th><spring:message code="label.recno"/></th>
					<th><spring:message code="label.name"/></th>

					<th><spring:message code="label.amount"/></th>
					<th><spring:message code="label.edit"/></th>
					<th><spring:message code="label.duplicate"/></th>
					<th><spring:message code="label.delete"/></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fun:length(PoojeDetails) > 0}">
					<c:forEach items="${PoojeDetails}" var="app">

						<tr class="tbl-item">


							<!-- data -->
							<td class="td-block">

								<p class="title">${app.RecNo}</p>

							</td>
							<td><p class="desc">${app.Name}</td>

							<td class="td-block">

								<p>&#8377 ${app.Amount}</p>

							</td>
							<td class="td-block">

								<p>
									<a
										onclick="popupCenter('../../Admin/EditDonation/${app.Did}/${app.RecNo}', 'Kanajar Temple',500,355);"
										href="javascript:void(0);"><spring:message code="label.edit"/></a>
								</p>

							</td>
							<td class="td-block">

								<p>
									<a target="_blank"
										href="<c:url value="../../Admin/DonationReceipt/${app.Did}/${app.RecNo}"/>"><spring:message code="label.print"/></a>
								</p>
							</td>
							<td class="td-block">

								<p>
									<a onclick="return confirmDelete()" href="<c:url value="../../Admin/deletedonation/${app.Did}/${app.RecNo}"/>"><spring:message code="label.delete"/></a>
								</p>
							</td>
							

						</tr>




					</c:forEach>
				</c:if>
			</tbody>

		</table>


	</div>

	<jsp:include page="AdminPaginationfooter.jsp"></jsp:include>







</div>
<jsp:include page="Adminfooter.jsp"></jsp:include>
