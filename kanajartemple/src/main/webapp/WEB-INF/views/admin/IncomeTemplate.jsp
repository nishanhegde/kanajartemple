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
					<th><spring:message code="label.income.name" /></th>
					<th><spring:message code="label.edit" /></th>
					<th><spring:message code="label.delete" /></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fun:length(Income) > 0}">
					<c:forEach items="${Income}" var="app" varStatus="status">

						<div id="Income${status.count}" class="reveal-modal">

							<form action="<c:url value="/SuperAdmin/CUDIncome/update"/>"
								id="Donation" name="Donation" required="required" method="post">
								<input type="hidden" name="Iid" value="${app.Iid}" />
								<spring:message code="label.income.name" />
								<input type="text" name="IncomeName" required="required"
									id="IncomeName" onfocus="enable('IncomeName')"
									value="${app.IncomeName}" /> <input type="submit"
									value="<spring:message code="label.update" /> " />

							</form>

							<a class="close-reveal-modal">&#215;</a>
						</div>
						<tr class="tbl-item">


							<!-- data -->
							<td class="td-block">

								<p class="title">${app.Iid}</p>

							</td>
							<td><p class="desc">${app.IncomeName}</td>

							<td class="td-block">

								<p>
									<a href="#" class="big-link"
										data-reveal-id="Income${status.count}"><spring:message
											code="label.edit" /></a>
								</p>
							</td>

							<td class="td-block">

								<p>
									<a
										href="<c:url value="../SuperAdmin/CUDIncome/delete/${app.Iid}"/>"
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







</div>
<jsp:include page="Adminfooter.jsp"></jsp:include>
