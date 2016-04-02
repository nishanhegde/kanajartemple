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
					<th><spring:message code="label.expense.name" /></th>
					<th><spring:message code="label.edit" /></th>
					<th><spring:message code="label.delete" /></th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fun:length(Expenditure) > 0}">
					<c:forEach items="${Expenditure}" var="app" varStatus="status">

						<div id="Expenditure${status.count}" class="reveal-modal">

							<form action="<c:url value="/SuperAdmin/CUDExpenditure/update"/>"
								id="Expense" name="Expense" required="required"
								method="post">
								<input type="hidden" name="Eid" value="${app.Eid}" />
								<spring:message code="label.expense.name" />
								<input type="text" name="ExpenseName" required="required"
									id="ExpenseName" onfocus="enable('ExpenseName')"
									value="${app.ExpenditureName}" /> <input type="submit"
									value="<spring:message code="label.update" /> " />

							</form>

							<a class="close-reveal-modal">&#215;</a>
						</div>
						<tr class="tbl-item">


							<!-- data -->
							<td class="td-block">

								<p class="title">${app.Eid}</p>

							</td>
							<td><p class="desc">${app.ExpenditureName}</td>

							<td class="td-block">

								<p>
									<a href="#" class="big-link"
										data-reveal-id="Expenditure${status.count}"><spring:message
											code="label.edit" /></a>
								</p>
							</td>

							<td class="td-block">

								<p>
									<a
										href="<c:url value="../SuperAdmin/CUDExpenditure/delete/${app.Eid}"/>"
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
