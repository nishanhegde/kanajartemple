<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>



<jsp:include page="../Adminheader.jsp"></jsp:include>
<div class="mainbody">
	<center>
		<h1>${bankAccount.bankName} (${bankAccount.accountNo})</h1>
	</center>
	<jsp:include page="../AdminPaginationheader.jsp"></jsp:include>

	<!-- data -->
	<div class="box text-shadow">
		<table class="demo-tbl">
			<thead>
				<tr>
					<%-- <th><spring:message code="label.bankaccount.id" /></th> --%>
					<th><spring:message
							code="label.bankaccountentry.transactiondate" /></th>
					<th><spring:message code="label.bankaccountentry.description" /></th>
					<th><spring:message code="label.bankaccountentry.credit" /></th>
				
					<th><spring:message code="label.bankaccountentry.debit" /></th>
					<th><spring:message code="label.bankaccountentry.balance" /></th>
					<%-- <th><spring:message code="label.edit" /></th>
					<th><spring:message code="label.delete" /></th> --%>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fun:length(bankAccountEntry) > 0}">
					<c:forEach items="${bankAccountEntry}" var="app">

						<tr class="tbl-item">


							<!-- data -->
							<%-- <td class="td-block">

								<p class="title">${app.bankAccountEntryId}</p>

							</td> --%>
							<td><p>${app.transactionDate}</td>
							<td >
								<p class="desc">${app.description}
								<c:if test="${not empty app.chequeOrRefNo}">
										<br />(${app.chequeOrRefNo})</c:if></p>
							</td>
							<td><p>${app.credit}</p></td>

							<td><p>${app.debit}</p></td>
							
							<td><p>${app.balance}</p></td>


							<%-- <td class="td-block">

								<p>
									<a
										onclick="popupCenter('../Admin/editaccount/${app.id}/${app.id}', 'Kanajar Temple',400,290);"
										href="javascript:void(0);"><spring:message
											code="label.edit" /></a>
								</p>

							</td>
							<td class="td-block">
								<p>
									<a onclick="return confirmDelete()"
										href="<c:url value="../Admin/deleteaccount/${app.id}/${app.id}"/>"><spring:message
											code="label.delete" /></a>
								</p>
							</td>
 --%>

						</tr>
					</c:forEach>
				</c:if>
			</tbody>

		</table>


	</div>

	<jsp:include page="../AdminPaginationfooter.jsp"></jsp:include>
</div>
<jsp:include page="../Adminfooter.jsp"></jsp:include>
