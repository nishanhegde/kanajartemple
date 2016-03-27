<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<jsp:include page="Adminheader.jsp"></jsp:include>
<div class="mainbody">
	<br />
	<center>
		<div class="invalid">${message}</div>
	</center>


	<jsp:include page="AdminPaginationheader.jsp"></jsp:include>

	<!-- data -->
	<div class="box text-shadow">
		<table class="demo-tbl">
			<thead>
				<tr>
					<th><spring:message code="label.id" /></th>
					<th><spring:message code="label.donation.name" /></th>
					<th><spring:message code="label.edit" /></th>

					<th><spring:message code="label.delete" /></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fun:length(Poojedata) > 0}">
					<c:forEach items="${Poojedata}" var="app" varStatus="status">

						<div id="Donation${status.count}" class="reveal-modal">
							
							<form action="<c:url value="/SuperAdmin/CUDDonation/update"/>"
								id="Donation"  name="Donation" required="required" method="post"
								>
								<input type="hidden" name="Did" value="${app.Did}" /> <spring:message code="label.donation.name" /> <input type="text" name="DonationName" required="required"
									id="DonationName" onfocus="enable('DonationName')" value="${app.DonationName}" /> <input
									type="submit" value="<spring:message code="label.update" /> " />

							</form>

							<a class="close-reveal-modal">&#215;</a>
						</div>
						<tr class="tbl-item">


							<!-- data -->
							<td class="td-block">

								<p class="title">${app.Did}</p>

							</td>
							<td><p class="desc">${app.DonationName}</td>

							<td class="td-block">

								<p>
									<a href="#" class="big-link"
										data-reveal-id="Donation${status.count}"><spring:message code="label.edit" /></a>
								</p>
							</td>

							<td class="td-block">

								<p>
									<a
										href="<c:url value="../SuperAdmin/CUDDonation/delete/${app.Did}"/>"
										onclick="return confirmDelete()"><spring:message code="label.delete" /></a>
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
